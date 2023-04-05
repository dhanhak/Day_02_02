package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.catalina.connector.Response;

import dto.DTO;

public class DAO {
	
	// Singleton Design Pattern : 클래스에 대하여 인스턴스를 1개 이상 생성하지 못하게 통제하는 패턴
	
	private static DAO instance = null;
	
	public synchronized static DAO getInstance() {		//synchronized 쓰레드로부터 안전하다.
		if(instance == null) {
			instance = new DAO();
		}
		return instance;
	}
	
	private Connection getConntection() throws Exception {
		Context iCtx = new InitialContext();	
		DataSource ds = (DataSource)iCtx.lookup("java:/comp/env/jdbc/ora");
		
		return ds.getConnection();
	}
	

	public int Insert(DTO dto) throws Exception {
		String sql = "INSERT INTO MESSAGES VALUES(MESSAGES_seq.nextval,?,?)";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());

			con.commit();
			return pstat.executeUpdate();
		}
	}

	public List<DTO> Selectlist() throws Exception{
		String sql = "SELECT * FROM MESSAGES";
		try(Connection con = this.getConntection();
				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery()){
			List<DTO> list = new ArrayList<>();
			while(rs.next()) {
				int id = rs.getInt("id");
				String writer = rs.getString("writer");
				String message = rs.getString("message");
				DTO dto = new DTO(id,writer,message);
				list.add(dto);
			}
			return list;
		}
	}
	
	public int Delete(DTO dto) throws Exception {
		String sql = "DELETE FROM MESSAGES WHERE id = ?";
		try(Connection con = this.getConntection();
		PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setInt(1, dto.getId());
			con.commit();
			return pstat.executeUpdate();
		}
	}
	
	public int Update(DTO dto) throws Exception {
		String sql = "UPDATE MESSAGES SET writer = ?, message = ? where id=? ";
		try(Connection con = this.getConntection();
		PreparedStatement pstat = con.prepareStatement(sql);){
			pstat.setString(1, dto.getWriter());
			pstat.setString(2, dto.getMessage());
			pstat.setInt(3, dto.getId());
			con.commit();
			return pstat.executeUpdate();
		}
	}
}
