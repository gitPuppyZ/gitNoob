package service;

import java.util.List;

import org.hibernate.Transaction;

import pojo.Emp;
import dao.EmpDao;

public class EmpBiz {
	private EmpDao empDao = new EmpDao();

	public List<Emp> findAllEmps() {
		Transaction tx = null;
		List<Emp> emps = null;
		try {
			tx = empDao.currentSession().beginTransaction();// 开启事务
			emps = empDao.findAll();// 持久化操作
			tx.commit();// 提交事务
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return emps;
	}
}
