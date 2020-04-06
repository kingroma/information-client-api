package information.client.api.dto;

import java.util.ArrayList;
import java.util.List;

public class TotalDto<T> {
	public static final String SUCCESS_CODE = "200";
	
	public static final String ERROR_CODE = "500";
	
	private String resultCode = SUCCESS_CODE;
	
	private Integer totalCount = 0;
	
	private List<T> data = null ; 

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public List<?> getData() {
		return data;
	}

	public void add(T entity) {
		if ( data == null ) {
			data = new ArrayList<T>();
		}
		
		data.add(entity);
	}
	
	public void clear() {
		if ( data == null ) {
			data = new ArrayList<T>();
		}
		
		data.clear();
	}
	
	public void setData(List<T> data) {
		this.data = data;
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
}
