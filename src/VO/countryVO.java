package VO;

import java.io.Serializable;

public class countryVO implements Serializable {
private int id;
private   String countryName;
private   String countryDescription;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
public String getCountryDescription() {
	return countryDescription;
}
public void setCountryDescription(String countryDescription) {
	this.countryDescription = countryDescription;
}
}
