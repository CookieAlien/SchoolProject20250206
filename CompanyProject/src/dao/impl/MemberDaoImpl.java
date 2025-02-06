package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MemberDao;
import model.Member;
import util.DBConnection;

public class MemberDaoImpl implements MemberDao{
	private static Connection connection = DBConnection.getConnection();
	
	public static void main(String[] args) {
		new MemberDaoImpl().delete(3);
		
	}
	
	
	@Override
	public void add(Member member) {
		// TODO Auto-generated method stub
		String sql = "insert into member(name,username,password,address,phone,mobile) values(?,?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getUsername());
			preparedStatement.setString(3, member.getPassword());
			preparedStatement.setString(4, member.getAddress());
			preparedStatement.setString(5, member.getPhone());
			preparedStatement.setString(6, member.getMobile());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Member> selectAll() {
		// TODO Auto-generated method stub
		String sql="select * from member";
		List<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Member m = new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setPassword(resultSet.getString("password"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				members.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}

	@Override
	public List<Member> selectUsernameAndPassword(String username, String password) {
		String sql="select * from member where username=? and password=?";
		List<Member> members = new ArrayList<Member>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Member m=new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setPassword(resultSet.getString("password"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return members;
	}

	@Override
	public List<Member> selectById(int id) {
		String sql="select * from member where id=?";
		List<Member> members = new ArrayList<Member>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Member m=new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setPassword(resultSet.getString("password"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return members;
	}

	@Override
	public List<Member> selectByUsername(String username) {
		String sql="select * from member where username=?";
		List<Member> members = new ArrayList<Member>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Member m=new Member();
				m.setId(resultSet.getInt("id"));
				m.setName(resultSet.getString("name"));
				m.setUsername(resultSet.getString("username"));
				m.setPassword(resultSet.getString("password"));
				m.setAddress(resultSet.getString("address"));
				m.setPhone(resultSet.getString("phone"));
				m.setMobile(resultSet.getString("mobile"));
				
				members.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return members;
	}

	@Override
	public void update(Member member) {
		String sql = "update member set name=?,password=?,address=?,phone=?,mobile=? where id=?";
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, member.getName());
			preparedStatement.setString(2, member.getPassword());
			preparedStatement.setString(3, member.getAddress());
			preparedStatement.setString(4, member.getPhone());
			preparedStatement.setString(5, member.getMobile());
			preparedStatement.setInt(6, member.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "delete from member where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
