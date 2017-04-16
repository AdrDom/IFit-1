package br.edu.ifpb.resteasyapp.dao;

import java.sql.SQLException;
import java.util.List;

import br.edu.ifpb.resteasyapp.entidade.Alimento;

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

}
