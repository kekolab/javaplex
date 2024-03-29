package kekolab.javaplex;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.apache.hc.core5.net.URIBuilder;

import kekolab.javaplex.model.PlexDirectory;
import kekolab.javaplex.model.PlexFilter;
import kekolab.javaplex.model.PlexMetadata;
import kekolab.javaplex.model.PlexSection;

class Filter extends Directory implements PlexFilter {
    private UriProvider fastKey;
    private String type;

    public Filter() {
        fastKey = new UriProvider(this::uri);
    }

    @Override
    public String getFastKey() {
        return (String) fastKey.getValue();
    }

    @Override
    public URI fastKey() {
        return fastKey.uri();
    }

    @Override
    public String getType() {
        return type;
    }

    public void setFastKey(String fastKey) {
        this.fastKey.setValue(fastKey);
    }

    public void setType(String type) {
        this.type = type;
    } 
    
    /**
     * This function applies the filter to the following URI:
     * {SECTION.KEY()}/{PATH}?type={TYPE}, i.e., it adds this filter's query parameter to this uri. 
     * The queried uri is, though:
     * {SECTION.KEY()}/all?type={TYPE}&{FILTER_QUERY_KEY}={FILTER_QUERY_VALUE}
     * 
     * @param <T>, the type of the PlexMetadata to return
     * @param section
     * @param path
     * @param type, the typeId of the PlexMetadata to return
     * @return
     */
    <T extends PlexMetadata> List<T> apply(PlexSection<?, ?> section, Integer type) {
        try {
            String[] keyValue = getConditionQuery().split("=");
            URI uri = new URIBuilder(section.key()).appendPath("all")
                    .addParameter("type", Integer.toString(type))
                    .addParameter(keyValue[0], keyValue[1])
                    .build();
            return new MetadataContainer<T, PlexDirectory>(uri, getServer()).getMetadata();
        } catch (URISyntaxException e) {
            throw new PlexException(e); // TODO
        }
    }

    String getConditionQuery() {
        String query = fastKey().getPath();
        return query.substring(query.lastIndexOf("?") + 1);
    }
  }
