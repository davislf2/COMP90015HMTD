package Server;

public class Resource {
	private String name;
	private String[] tags;
	private String description;
	private String uri;
	private String channel;
	private String owner;
	private String ezserver;
	
	
	public Resource(String name, String[] tags,
		    String description,
		    String uri, String channel, 
		    String owner, String ezserver){
	      this.name = name;
	      this.tags = tags;
	      this.description = description;
	      this.uri = uri;
	      this.channel = channel;
	      this.owner = owner;
	      this.ezserver = ezserver;
	}
      /**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the tags
	 */
	public String[] getTags() {
		return tags;
	}

	/**
	 * @param tags the tags to set
	 */
	public void setTags(String[] tags) {
		this.tags = tags;
	}

	/**
	 * @return the channel
	 */
	public String getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(String channel) {
		this.channel = channel;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the ezServer
	 */
	public String getEzServer() {
		return ezserver;
	}

	/**
	 * @param ezServer the ezServer to set
	 */
	public String getEzserver() {
	      return ezserver;
	}


	public void setEzserver(String ezserver) {
	      this.ezserver = ezserver;
	}

	/**
	 * @param uri; return the uri
	 */
	
	
	public String getUri() {
            return uri;
	}

	/**
	 * @param uri; the uri to set
	 */
	
	public void setUri(String uri) {
            this.uri = uri;
      	}

}
