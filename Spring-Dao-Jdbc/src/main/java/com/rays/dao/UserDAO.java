package com.rays.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rays.dto.UserDTO;

@Repository
public class UserDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}
	
	public long nextPk() {
		
		String sql = "select max(id) from st_user";
		
		Long maxId = jdbcTemplate.queryForObject(sql, Long.class);
		
		if (maxId == null) {
			return 1;	// table empty
		}
		
		return maxId + 1;
	}

	public int add(UserDTO dto) {

		String sql = "insert into st_user values(?, ?, ?, ?, ?)";

		jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword());

		return dto.getId();

	}
	
	public void update(UserDTO dto) {

		String sql = "update st_user set firstName = ?, lastName = ?, login = ?, password = ? where id = ?";
		
		int i = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());
		
		System.out.println("record updated: " + i);
	}

	
	
	public void delete(int id) {

		String sql = "delete from st_user where id = ?";
		
		int i = jdbcTemplate.update(sql, id);
		
		System.out.println("record deleted = " + i);

	}
	
	public UserDTO findByPk(long id) {
		 
		UserDTO dto = null;
		
		String sql = "select * from st_user where id = ?";
		
		Object[] param = { id };
		
		dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());
		
		return dto;
	}
	
	public UserDTO findByLogin(String login) {
		
		UserDTO dto = null;
		
		String sql = "select * from st_user where login = ?";
		
		Object[] param = {login};
		
		dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());
		
		return dto;
	}
	
	public UserDTO authenticate(String login, String password) {

		UserDTO dto = null;

		String sql = "select * from st_user where login = ? and password = ?";

		Object[] param = { login, password };

		dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());

		return dto;

	}
	
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize){
		
		List<UserDTO> list = null;
		
		StringBuffer sql = new StringBuffer("select * from st_user where 1 = 1 ");
		
		if(dto!= null) {
			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {
				sql.append("and firstName like '" + dto.getFirstName() + "%'");
			}
			if (dto.getLastName() != null && dto.getLastName().length() > 0) {
				sql.append("and lastName like '" + dto.getLastName() + "%'");
			}
		}

		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + ", " + pageSize);
		}

		System.out.println("sql === > " + sql.toString());
		list = jdbcTemplate.query(sql.toString(), new UserMapper());

		return list;

	}

}