package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Administrador;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class AdministradorDAO extends GenericDao<Integer, Administrador> {

	private static AdministradorDAO instance;

	public static AdministradorDAO getInstance() {
		instance = new AdministradorDAO();
		return instance;
	}

	@Override
	public List<Administrador> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getAll("Administrador.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Administrador.class;
	}

	@Override
	public Administrador find(Administrador entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public Administrador findAdministradorByLogin(String login) throws SQLException {

		Session session = HibernateUtil.getSessionFactory().openSession();

		Administrador administrador = null;

		try {

			String hql = "from Administrador a " + "where a.login like :login";

			Query query = session.createQuery(hql);

			query.setParameter("login", "%" + login + "%");

			administrador = (Administrador) query.uniqueResult();

		} catch (HibernateException hibernateException) {

			session.getTransaction().rollback();

			throw new SQLException(hibernateException);

		} finally {
			session.close();
		}
		return administrador;
	}

}
