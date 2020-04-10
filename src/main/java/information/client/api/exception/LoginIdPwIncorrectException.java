package information.client.api.exception;

public class LoginIdPwIncorrectException extends BaseException {

	private static final long serialVersionUID = 1L;

	public LoginIdPwIncorrectException() {
		super();
	}

	public LoginIdPwIncorrectException(String s) {
		super(s);
	}

	public LoginIdPwIncorrectException(String s, Throwable t) {
		super(s, t);
	}
}
