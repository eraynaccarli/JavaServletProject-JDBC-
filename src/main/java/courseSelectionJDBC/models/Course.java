package courseSelectionJDBC.models;

public class Course {

	private int id;
	
	private String name;
	
	private String code;
	
	private Department department;
	
	private int departmentId;
	
	
	public Course() {
		
	}
	
	public Course(int id,String name , String code, Department department) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.department = department;
	}
	public Course(int id,String name , String code, int departmentId) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.departmentId = departmentId;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
}
