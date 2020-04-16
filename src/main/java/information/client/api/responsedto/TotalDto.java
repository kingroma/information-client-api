package information.client.api.responsedto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class TotalDto<T> {
	public static final String SUCCESS_CODE = "200";
	
	public static final String PARAM_ERROR = "400";
	
	public static final String ERROR_CODE = "500";
	
	private String resultCode = SUCCESS_CODE;
	
	@JsonInclude(Include.NON_NULL)
	private Integer totalCount = 0;
	
	@JsonInclude(Include.NON_NULL)
	private List<T> result = null ; 
	
	@JsonInclude(Include.NON_NULL)
	private String errorMessage ;

	public void settingTotalCount() {
		if ( result != null ) {
			totalCount = result.size();
		}
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getResult() {
		return result;
	}

	public void add(T entity) {
		if ( result == null ) {
			result = new ArrayList<T>();
		}
		
		result.add(entity);
	}
	
	public void clear() {
		if ( result == null ) {
			result = new ArrayList<T>();
		}
		
		result.clear();
	}
	
	public void setResult(List<T> result) {
		this.result = result;
	}

	public static String getSuccessCode() {
		return SUCCESS_CODE;
	}

	public static String getErrorCode() {
		return ERROR_CODE;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	} 
	
	
}
