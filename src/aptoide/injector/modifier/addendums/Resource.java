package aptoide.injector.modifier.addendums;

/**
 * Android resource transfer class
 * Holds information about a resource and its old and new id
 *
 * @author      Gonçalo M.
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

	/**
	 * Returns the new id of the resource
	 * @return The new id of the resource
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Returns the type of the resource
	 * @return The type of the resource
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Returns the name of the resource
	 * @return The name of the resource
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns the old  id of the resource
	 * @return The old id of the resource
	 */
	public String getOldId() { return this.oldId; }
}
