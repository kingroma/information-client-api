package information.client.api.service;

import information.client.api.domain.Code;

public interface CodeService {
	
	public Code getCode(String codeId);
	
	public String lolSeason();
	
	public String lolVersion();
}
