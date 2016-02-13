package VO;

import java.io.Serializable;

public class CityVO implements Serializable{
	private int cid;
	private String cityName;
	private String cityDescription;
	
	stateVO stateVO;
	stateVO sv = new stateVO();
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getCityDescription() {
		return cityDescription;
	}
	public void setCityDescription(String cityDescription) {
		this.cityDescription = cityDescription;
	}
	public stateVO getStateVO() {
		return stateVO;
	}
	public void setStateVO(stateVO stateVO) {
		this.stateVO = stateVO;
	}
	public stateVO getSv() {
		return sv;
	}
	public void setSv(stateVO sv) {
		this.sv = sv;
	}
	
	
	}

