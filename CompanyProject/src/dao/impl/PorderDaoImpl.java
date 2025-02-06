package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.PorderDao;
import model.Porder;
import util.DBConnection;

public class PorderDaoImpl implements PorderDao{
	
	public static void main(String[] args) {
		PorderDaoImpl porderDaoImpl = new PorderDaoImpl();
		Porder p = porderDaoImpl.selectById(2).get(0);
		p.setMouse(1);
		porderDaoImpl.update(p);
		porderDaoImpl.delete(4);
	}
	
	private static Connection connection =DBConnection.getConnection();
	@Override
	public void add(Porder porder) {
		String sql = "insert into porder(name,lcd,ram,mouse) values(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, porder.getName());
			preparedStatement.setInt(2, porder.getLcd());
			preparedStatement.setInt(3, porder.getRam());
			preparedStatement.setInt(4, porder.getMouse());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Porder> selectAll() {
		String sql = "select * from porder";
		List<Porder> pList = new ArrayList<Porder>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Porder porder = new Porder();
				porder.setId(resultSet.getInt("id"));
				porder.setName(resultSet.getString("name"));
				porder.setLcd(resultSet.getInt("lcd"));
				porder.setRam(resultSet.getInt("ram"));
				porder.setMouse(resultSet.getInt("mouse"));
				pList.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public List<Porder> selectById(int id) {
		String sql = "select * from porder where id=?";
		List<Porder> pList = new ArrayList<Porder>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				Porder porder = new Porder();
				porder.setId(resultSet.getInt("id"));
				porder.setName(resultSet.getString("name"));
				porder.setLcd(resultSet.getInt("lcd"));
				porder.setRam(resultSet.getInt("ram"));
				porder.setMouse(resultSet.getInt("mouse"));
				pList.add(porder);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pList;
	}

	@Override
	public void update(Porder porder) {
		String sql = "update porder set name=?,lcd=?,ram=?,mouse=? where id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, porder.getName());
			preparedStatement.setInt(2, porder.getLcd());
			preparedStatement.setInt(3, porder.getRam());
			preparedStatement.setInt(4, porder.getMouse());
			preparedStatement.setInt(5, porder.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "delete from porder where id=?";
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
