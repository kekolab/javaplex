package kekolab.javaplex.model;

public interface PlexTextStream extends PlexStream {
	int TYPE_ID = 3;

	Boolean getSelected();

	Integer getTransient();

	String getFormat();

	Integer getSubIndex();

	Boolean getHearingImpaired();

	String getProviderTitle();

	String getSourceKey();

	Integer getUserID();

	Double getScore();
}
