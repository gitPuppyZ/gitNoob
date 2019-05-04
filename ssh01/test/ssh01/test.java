package ssh01;

import java.util.List;

import org.junit.Test;

import pojo.Dept;
import pojo.Emp;
import service.DeptBiz;
import service.EmpBiz;

public class test {
	@Test
	public void testfindDeptById() {
		// TODO Auto-generated method stub
		Dept dept = new DeptBiz().findDeptById(new Byte("10"));
		System.out.println(dept.getDeptName());
	}

	@Test
	public void testSave() {
		Dept dept = new Dept();
		dept.setDeptNo(new Byte("11"));
		dept.setDeptName("测试部");
		dept.setLocation("东区");
		new DeptBiz().addNewDept(dept);
	}

	@Test
	public void testUpdate() {
		Dept dept = new Dept();
		dept.setDeptNo(new Byte("11"));
		dept.setDeptName("质管部");
		dept.setLocation("东区");
		new DeptBiz().updateDept(dept);
	}

	@Test
	public void testDelete() {
		new DeptBiz().deleteDept(new Byte("11"));
	}

	@Test
	public void testMerge() {
		Dept dept = new Dept();
	}

	@Test
	public void testFindAllEmp() {
		List<Emp> empList = new EmpBiz().findAllEmps();
		for (Emp emp : empList) {
			System.out.println("员工姓名：" + emp.getEmpName());
		}
	}
	
	@Test
	public void testFindDeptByName(){
		List<Dept> result = new DeptBiz().findDeptByName("SALES");
		for (Dept dept : result){
			System.out.println("部门地址为："+dept.getLocation());
		}
	}
}
