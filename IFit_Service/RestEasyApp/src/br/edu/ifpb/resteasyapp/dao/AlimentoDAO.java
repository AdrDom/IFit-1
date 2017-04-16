package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import br.edu.ifpb.resteasyapp.entidade.Alimento;
import br.edu.ifpb.resteasyapp.hibernate.HibernateUtil;

public class AlimentoDAO extends GenericDao<Integer, Alimento> {

	private static AlimentoDAO instance;

	public static AlimentoDAO getInstance() {
		instance = new AlimentoDAO();
		return instance;
	}

	@Override
	public List<Alimento> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getAll("Alimento.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Alimento.class;
	}

	@Override
	public Alimento find(Alimento entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Alimento getAlimentoByNome(String nome) throws SQLException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Alimento alimento = null;
		
		try{
		
			String hql = "from Alimento a "
				+ "where a.nome like :nome";
			
			Query query = session.createQuery(hql);
			
			query.setParameter("nome", "%" + nome + "%");
			
			alimento = (Alimento) query.uniqueResult();
			
		} catch(HibernateException hibernateException){
			
			session.getTransaction().rollback();
			
			throw new SQLException(hibernateException);
		
		} finally {
			session.close();
		}
		return alimento;
	}

}
