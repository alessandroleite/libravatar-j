package libravatarj;

public class AvatarException extends RuntimeException {

	/**
	 * Serial code version <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2574665849051070802L;

	/**
	 * Default constructor
	 */
	public AvatarException() {
		super();
	}

	/**
	 * 
	 * @param message Exception message text
	 */
	public AvatarException(String message) {
		super(message);
	}

	public AvatarException(Throwable root) {
		super(root);
	}

	public AvatarException(String message, Throwable root) {
		super(message, root);
	}
}