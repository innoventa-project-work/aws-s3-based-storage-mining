package VO;

import java.io.Serializable;

public class regionVO implements Serializable{
private int regionId;
private String regionName;
private String regionDescription;

public int getRegionId() {
	return regionId;
}
public void setRegionId(int regionId) {
	this.regionId = regionId;
}
public String getRegionName() {
	return regionName;
}
public void setRegionName(String regionName) {
	this.regionName = regionName;
}
public String getRegionDescription() {
	return regionDescription;
}
public void setRegionDescription(String regionDescription) {
	this.regionDescription = regionDescription;
}

}
