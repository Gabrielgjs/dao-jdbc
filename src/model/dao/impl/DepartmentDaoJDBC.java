package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {

	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findByID(Integer id) {
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(// prepara comando sql
					"SELECT * FROM department WHERE Id = ?");
			
			st.setInt(1, id);// Configura o parametro do id
			rs = st.executeQuery();// executa a consulta, guardando no resultSet
			if(rs.next()) {// testa o resultset e instancia o objeto
				Department dep = new Department();
				dep.setId(rs.getInt("id"));
				dep.setName(rs.getString("Name"));
				return dep;
			}
			return null;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
