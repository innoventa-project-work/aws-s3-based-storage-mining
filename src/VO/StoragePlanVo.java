package VO;

import java.io.Serializable;

public class StoragePlanVo implements Serializable {

	private int storageId;
	private   String planName;
	private   String dataSize;
	private String price;
	private   String planDescription;
	
	public int getStorageId() {
		return storageId;
	}
	public void setStorageId(int storageId) {
		this.storageId = storageId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getDataSize() {
		return dataSize;
	}
	public void setDataSize(String dataSize) {
		this.dataSize = dataSize;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	
	}
	
		
	

	

