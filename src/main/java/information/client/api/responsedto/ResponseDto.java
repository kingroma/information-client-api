package information.client.api.responsedto;

public class ResponseDto<T> {
	public static final String SUCCESS_CODE = "200";
	
	public static final String PARAMETER_ERROR_CODE = "400";
	
	public static final String ERROR_CODE = "500";
	
	private String resultCode = SUCCESS_CODE;
	
	private String resultMessage = null ;
	
	private T result = null ;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}

	public static String getSuccessCode() {
		return SUCCESS_CODE;
	}

	public static String getErrorCode() {
		return ERROR_CODE;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
	
	
}
