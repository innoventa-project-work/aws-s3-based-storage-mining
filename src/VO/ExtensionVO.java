package VO;

import java.io.Serializable;

public class ExtensionVO  implements Serializable{
	private int extensionId;
	private String extensionName;
	private String extensionDescription;
	categoryVO categoryVO;
	categoryVO ct= new categoryVO();
	
	public int getExtensionId() {
		return extensionId;
	}
	public void setExtensionId(int extensionId) {
		this.extensionId = extensionId;
	}
	public String getExtensionName() {
		return extensionName;
	}
	public void setExtensionName(String extensionName) {
		this.extensionName = extensionName;
	}
	public String getExtensionDescription() {
		return extensionDescription;
	}
	public void setExtensionDescription(String extensionDescription) {
		this.extensionDescription = extensionDescription;
	}
	public categoryVO getCategoryVO() {
		return categoryVO;
	}
	public void setCategoryVO(categoryVO categoryVO) {
		this.categoryVO = categoryVO;
	}
	public categoryVO getCt() {
		return ct;
	}
	public void setCt(categoryVO ct) {
		this.ct = ct;
	}
	
	
}
