package dao;

import org.hibernate.Session;

import tools.HibernateUtil;

public class BaseDao {
	public Session currentSession() {
		return HibernateUtil.currentSession();
	}
}
