package aptoide.injector.Modifier.Addendums;
import aptoide.injector.Modifier.Addendums.AddendumException;

import java.util.LinkedList;

/**
 * Created by gbfm on 8/11/15.
 */
public interface IAddendum {
	void writeChanges() throws AddendumException;

	<E> E apply() throws AddendumException;

	String getTargetFile();

	String getAddendumFile();

}