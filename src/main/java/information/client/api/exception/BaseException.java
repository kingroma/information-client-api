package information.client.api.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseException() {
		super();
	}

	public BaseException(String s) {
		super(s);
	}

	public BaseException(String s, Throwable t) {
		super(s, t);
	}

}