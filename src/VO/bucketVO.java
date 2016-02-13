package VO;
import java.io.Serializable;
public class bucketVO implements Serializable {
private int id;
private String bucketName;

regionVO regionVO;

public regionVO getRegionVO() {
	return regionVO;
}
public void setRegionVO(regionVO regionVO) {
	this.regionVO = regionVO;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getBucketName() {
	return bucketName;
}
public void setBucketName(String bucketName) {
	this.bucketName = bucketName;
}


}
