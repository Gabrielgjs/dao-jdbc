package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"INSERT INTO department "
					+ "(Name) "
					+ "VALUES " 
					+"(?)",
					Statement.RETURN_GENERATED_KEYS);
			
					st.setString(1, obj.getName());
					
					int rowsAffected = st.executeUpdate();
					if (rowsAffected > 0) {
						ResultSet rs = st.getGeneratedKeys();
						if(rs.next()) {
							int id = rs.getInt(1);
							obj.setId(id);
						}
					}
					
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
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
		
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			
			st = conn.prepareStatement(
					"SELECT * FROM department ORDER BY Name");
			
			rs = st.executeQuery();// executa a consulta, guardando no resultSet
			
			List<Department> list =  new ArrayList<>();
			
			while(rs.next()) {
				Department dep = new Department();
				dep.setId(rs.getInt("Id"));
				dep.setName(rs.getString("Name"));
				list.add(dep);
			}
			return list;
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
}
