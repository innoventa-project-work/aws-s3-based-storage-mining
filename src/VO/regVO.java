package VO;

import java.io.Serializable;

public class regVO implements Serializable{
	private int rid;
	private String fn,ln,date,gender,address,contact;
	countryVO countryVO;
	stateVO stateVO;
	CityVO cityVO;
	loginVO logionVO;
	public loginVO getLogionVO() {
		return logionVO;
	}
	public void setLogionVO(loginVO logionVO) {
		this.logionVO = logionVO;
	}
	public countryVO getCountryVO() {
		return countryVO;
	}
	public void setCountryVO(countryVO countryVO) {
		this.countryVO = countryVO;
	}
	public stateVO getStateVO() {
		return stateVO;
	}
	public void setStateVO(stateVO stateVO) {
		this.stateVO = stateVO;
	}
	public CityVO getCityVO() {
		return cityVO;
	}
	public void setCityVO(CityVO cityVO) {
		this.cityVO = cityVO;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}

}
