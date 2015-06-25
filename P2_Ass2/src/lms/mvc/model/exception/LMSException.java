package lms.mvc.model.exception;

/**
 * @author Mikhail Perepletchikov 06/2013
 */
@SuppressWarnings("serial")
public abstract class LMSException extends Exception {

	public LMSException() {
		super("Default LMS Exception");
	}

	// NOTE: it is advisable to use this constructor when creating new exceptions
	public LMSException(String message) {
		super(message);
	}
}