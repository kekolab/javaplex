package kekolab.javaplex;

import kekolab.javaplex.model.PlexRating;

public class Rating extends MediatagAttribute implements PlexRating  {
	private String image;
	private Double value;
	private String type;
	private Integer count;

	@Override
	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public String getImage() {
		ensureDetailed(image);
		return image;
	}

	@Override
	public String getType() {
		ensureDetailed(type);
		return type;
	}

	@Override
	public Double getValue() {
		ensureDetailed(value);
		return value;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public void setType(String type) {
		this.type = type;
	}
}
