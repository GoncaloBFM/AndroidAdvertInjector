package aptoide.injector.modifier.addendums;

/**
 * Base interface for an addendum file parser
 * An addendum file is used to discriminate the change that have to be done to another specified file
 *
 * @author      Gonçalo M.
 */
public interface IAddendum {

	/**
	 * Writes changes made to the target file
	 * @throws AddendumException Could not write changes
	 */
	void writeChanges() throws AddendumException;

	/**
	 * Applies changes to the target file, but does not save its contents
	 * @param <E> Modifications made
	 * @return Modifications made
	 * @throws AddendumException Could not apply all addendum changes to target file
	 */
	<E> E apply() throws AddendumException;

	/**
	 * Returns the target file
	 * @return The target file
	 */
	String getTargetFile();

	/**
	 * Returns the addendum file
	 * @return The addendum file
	 */
	String getAddendumFile();

}