package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseItem {
	@JsonIgnore
	private Map<String, List<Object>> unmappedProperties;

	public BaseItem() {
		unmappedProperties = new HashMap<>();
	}

	@JsonAnySetter
	public void setUnmappedProperty(String name, Object value) {
		if (unmappedProperties.containsKey(name))
			unmappedProperties.get(name).add(value);
		else
			unmappedProperties.put(name, new ArrayList<>(Arrays.asList(value)));
		System.out.println("Unmapped property in class " + getClass() + " - Name: " + name + "; value: " + value);
	}

	@JsonAnyGetter
	public Map<String, List<Object>> getUnmappedProperties() {
		return unmappedProperties;
	}

	protected void clear() {
		unmappedProperties.clear();
	}

	protected void update(BaseItem source)  {
		unmappedProperties = source.unmappedProperties;
	}
}
