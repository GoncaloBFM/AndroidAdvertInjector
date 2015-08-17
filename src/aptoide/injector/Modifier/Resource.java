package aptoide.injector.Modifier;

/**
 * Created by gbfm on 8/14/15.
 */
public class Resource {
	private final String id;
	private final String oldId;
	private final String type;
	private final String name;

	public Resource(String id, String oldId, String type, String name) {
		this.id = id;
		this.oldId = oldId;
		this.type = type;
		this.name = name;
	}

	public String getId() {
		return this.id;
	}

	public String getType() {
		return this.type;
	}

	public String getName() {
		return this.name;
	}

	public String getOldId() { return this.oldId; }
}
