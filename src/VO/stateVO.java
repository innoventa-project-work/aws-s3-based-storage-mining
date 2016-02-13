package VO;

import java.io.Serializable;

public class stateVO implements Serializable{
	private int stateId;
	private String stateName;
	private String stateDescription;
	countryVO countryVO;
	countryVO cv= new countryVO();
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getStateDescription() {
		return stateDescription;
	}
	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}
	public countryVO getCountryVO() {
		return countryVO;
	}
	public void setCountryVO(countryVO countryVO) {
		this.countryVO = countryVO;
	}
	public countryVO getCv() {
		return cv;
	}
	public void setCv(countryVO cv) {
		this.cv = cv;
	}
	
	
	
	
	
	
	
	
	
	
}