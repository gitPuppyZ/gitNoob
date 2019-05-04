package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import pojo.Dept;
import tools.HibernateUtil;
import dao.DeptDao;

public class DeptBiz {
	private DeptDao deptDao = new DeptDao();

	public Dept findDeptById(Byte id) {
		Transaction tx = null;
		Dept result = null;
		try {
			tx = HibernateUtil.currentSession().beginTransaction();// 开启事务
			result = deptDao.get(id);// 加载Dept对象
			tx.commit();// 提交事务
		} catch (HibernateException e) {
			e.printStackTrace();
			// 回滚
			if (tx != null) {
				tx.rollback();
			}
		}
		return result;
	}

	public void addNewDept(Dept dept) {
		Transaction tx = null;
		try {
			tx = deptDao.currentSession().beginTransaction();// 开启事务
			deptDao.save(dept);// 保存Dept对象
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		}
	}

	public void updateDept(Dept dept) {
		Transaction tx = null;
		try {
			tx = deptDao.currentSession().beginTransaction();// 开启事务
			Dept deptToUpdate = deptDao.load(dept.getDeptNo());// 加载需要修改的对象
			// 更新部门数据
			deptToUpdate.setDeptName(dept.getDeptName());
			deptToUpdate.setLocation(dept.getLocation());
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	public void deleteDept(Byte id) {
		Transaction tx = null;
		try {
			tx = deptDao.currentSession().beginTransaction();
			Dept deptToDelete = deptDao.load(id);
			deptDao.delete(deptToDelete);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
	}

	public Dept mergeDept(Dept dept) {
		Transaction tx = null;
		Dept persistentDept = null;
		try {
			tx = deptDao.currentSession().beginTransaction();// 开启事务
			// 合并dept的数据或者保存dept的副本，返回持久状态对象
			persistentDept = deptDao.merge(dept);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return persistentDept;
	}

	public List<Dept> findDeptByName(String deptName) {
		Transaction tx = null;
		List<Dept> result = null;
		try {
			tx = deptDao.currentSession().beginTransaction();
			result = deptDao.findDeptByName(deptName);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}
		return result;
	}
}
