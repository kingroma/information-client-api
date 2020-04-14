package information.client.api.service;

import information.client.api.responsedto.TotalDto;
import information.client.api.responsedto.UserWatchHistDto;

public interface UserWatchHistService {
	public TotalDto<UserWatchHistDto> getUserWatchHistRecentProgram(String userId) throws Exception;
	
	public Boolean save(String userId , String programId , String productId) throws Exception ;
}
