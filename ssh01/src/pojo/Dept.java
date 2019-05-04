package pojo;

public class Dept implements java.io.Serializable {
	/* public Dept(){} */
	private Byte deptNo; // OID
	private String deptName;
	private String location;

	public Byte getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Byte deptNo) {
		this.deptNo = deptNo;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
