package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Refeicao;

public class RefeicaoDAO extends GenericDao<Integer, Refeicao>{
	
	private static RefeicaoDAO instance;

	public static RefeicaoDAO getInstance() {
		instance = new RefeicaoDAO();
		return instance;
	}
	
	@Override
	public List<Refeicao> getAll() throws SQLException {
		// TODO Auto-generated method stub
		return super.getAll("Refeicao.getAll");
	}

	@Override
	public Class<?> getEntityClass() {
		// TODO Auto-generated method stub
		return Refeicao.class;
	}

	@Override
	public Refeicao find(Refeicao entity) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
