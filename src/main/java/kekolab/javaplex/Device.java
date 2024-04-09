package kekolab.javaplex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import kekolab.javaplex.mappers.StringListDeserializer;
import kekolab.javaplex.mappers.TimestampDeserializer;
import kekolab.javaplex.model.PlexConnection;
import kekolab.javaplex.model.PlexDevice;

public class Device extends BaseItem implements PlexDevice {
	private String name;
	private String product;
	private String productVersion;
	private String platform;
	private String platformVersion;
	private String device;
	private String clientIdentifier;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date createdAt;
	@JsonDeserialize(using = TimestampDeserializer.class)
	private Date lastSeenAt;
	@JsonDeserialize(using = StringListDeserializer.class)
	private List<String> provides;
	private Integer owned;
	private String accessToken;
	private String publicAddress;
	private Integer httpsRequired;
	private Integer relay;
	private Integer dnsRebindingProtection;
	private Integer natLoopbackSupported;
	private Integer publicAddressMatches;
	private Integer presence;
	@JsonProperty("Connection")
	@JacksonXmlElementWrapper(useWrapping = false)
	@JsonDeserialize(contentAs = Connection.class)
	private List<PlexConnection> connections;
	private Integer synced;
	@JsonIgnore
	private PlexHTTPClient client;

	public Device() {
		connections = new ArrayList<>();
		provides = new ArrayList<>();
	}

	@Override
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	@Override
	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}

	@Override
	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	@Override
	public String getPlatformVersion() {
		return platformVersion;
	}

	public void setPlatformVersion(String platformVersion) {
		this.platformVersion = platformVersion;
	}

	@Override
	public String getDevice() {
		return device;
	}

	public void setDevice(String device) {
		this.device = device;
	}

	@Override
	public String getClientIdentifier() {
		return clientIdentifier;
	}

	public void setClientIdentifier(String clientIdentifier) {
		this.clientIdentifier = clientIdentifier;
	}

	@Override
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public Date getLastSeenAt() {
		return lastSeenAt;
	}

	public void setLastSeenAt(Date lastSeenAt) {
		this.lastSeenAt = lastSeenAt;
	}

	@Override
	public List<String> getProvides() {
		return provides;
	}

	public void setProvides(List<String> provides) {
		this.provides = provides;
	}

	@Override
	public Integer getOwned() {
		return owned;
	}

	public void setOwned(Integer owned) {
		this.owned = owned;
	}

	@Override
	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	@Override
	public String getPublicAddress() {
		return publicAddress;
	}

	public void setPublicAddress(String publicAddress) {
		this.publicAddress = publicAddress;
	}

	@Override
	public Integer getHttpsRequired() {
		return httpsRequired;
	}

	public void setHttpsRequired(Integer httpsRequired) {
		this.httpsRequired = httpsRequired;
	}

	@Override
	public Integer getRelay() {
		return relay;
	}

	public void setRelay(Integer relay) {
		this.relay = relay;
	}

	@Override
	public Integer getDnsRebindingProtection() {
		return dnsRebindingProtection;
	}

	public void setDnsRebindingProtection(Integer dnsRebindingProtection) {
		this.dnsRebindingProtection = dnsRebindingProtection;
	}

	@Override
	public Integer getNatLoopbackSupported() {
		return natLoopbackSupported;
	}

	public void setNatLoopbackSupported(Integer natLoopbackSupported) {
		this.natLoopbackSupported = natLoopbackSupported;
	}

	@Override
	public Integer getPublicAddressMatches() {
		return publicAddressMatches;
	}

	public void setPublicAddressMatches(Integer publicAddressMatches) {
		this.publicAddressMatches = publicAddressMatches;
	}

	@Override
	public Integer getPresence() {
		return presence;
	}

	public void setPresence(Integer presence) {
		this.presence = presence;
	}

	@Override
	public List<PlexConnection> getConnections() {
		return connections;
	}

	public void setConnections(List<PlexConnection> connections) {
		this.connections = connections;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Integer getSynced() {
		return synced;
	}

	public void setSynced(Integer synced) {
		this.synced = synced;
	}

	protected void setClient(PlexHTTPClient client) {
		this.client = client;
	}

	@Override
	public boolean isServer() {
		return getProvides().stream().anyMatch(p -> p.equalsIgnoreCase("server"));
	}
}
