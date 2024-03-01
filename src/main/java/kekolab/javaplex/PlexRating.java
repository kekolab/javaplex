package kekolab.javaplex;

public class PlexRating extends MediatagAttribute {
	private String image;
	private Double value;
	private String type;
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		getParentTag().fetchDetailedIfNullOrEmpty(image);
		return image;
	}

	public String getType() {
		getParentTag().fetchDetailedIfNullOrEmpty(type);
		return type;
	}

	public Double getValue() {
		getParentTag().fetchDetailedIfNullOrEmpty(value);
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
