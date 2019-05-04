package dao;

import java.util.List;

import org.hibernate.Query;

import pojo.Emp;

public class EmpDao extends BaseDao {

	public List<Emp> findAll() {
		String hql = "from Emp";// 定义HQL语句
		Query query = currentSession().createQuery(hql);// 构建Query对象
		return query.list();// 查询
	}
	
}
