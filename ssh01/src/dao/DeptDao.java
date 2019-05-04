package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import pojo.Dept;

public class DeptDao extends BaseDao {
	public Dept get(Serializable id) {
		return (Dept) currentSession().get(Dept.class, id);
	}

	public void save(Dept dept) {
		currentSession().save(dept);// 保存指定的Dept对象
	}

	public Dept load(Serializable id) {
		return (Dept) currentSession().load(Dept.class, id);
	}

	public void delete(Dept dept) {
		currentSession().delete(dept);
	}

	public Dept merge(Dept dept) {
		return (Dept) currentSession().merge(dept);
	}

	public List<Dept> findDeptByName(String deptName) {
		String hql = "from Dept as dept where dept.deptName = ?";
		Query query = currentSession().createQuery(hql);
		query.setString(0, deptName);
		return query.list();
	}
}
