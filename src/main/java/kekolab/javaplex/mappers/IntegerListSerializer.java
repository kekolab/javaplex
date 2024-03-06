package kekolab.javaplex.mappers;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class IntegerListSerializer extends StdSerializer<List<Integer>> {

	public IntegerListSerializer() {
		super((Class<List<Integer>>) null);
	}

	@Override
	public void serialize(List<Integer> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		List<String> stringValues = value.stream().map(i -> Integer.toString(i)).toList();
		gen.writePOJO(stringValues);
	}
}