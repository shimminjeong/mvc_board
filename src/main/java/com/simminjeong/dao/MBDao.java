package com.simminjeong.dao;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

public class MBDao {

	private DataSource ds;
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String query;

	public MBDao() {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public ArrayList<MBDto> selectAll() {
		ArrayList<MBDto> dtos = new ArrayList<MBDto>();

		query = "SELECT * FROM MVC_BOARD";

		try {
			conn = ds.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp write_date = rs.getTimestamp("WRRITE_DATE");
				int hit = rs.getInt("hit");
				int groups = rs.getInt("groups");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");

				MBDto dto = new MBDto(id, name, title, content, write_date, hit, groups, step, indent);
				dtos.add(dto);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dtos;
	}

	public MBDto selectId(int id) {

		MBDto dto = null;

		query = "SELECT * FROM MVC_BOARD WHERE ID =?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("!!!");
				String name = rs.getString("name");
				String title = rs.getString("title");
				String content = rs.getString("content");
				Timestamp write_date = rs.getTimestamp("WRRITE_DATE");
				int hit = rs.getInt("hit");
				int groups = rs.getInt("groups");
				int step = rs.getInt("step");
				int indent = rs.getInt("indent");

				dto = new MBDto(id, name, title, content, write_date, hit, groups, step, indent);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dto;

	}

	public void insertContent(MBDto dto) {

//		query = "insert into mvc_board values(seq_mvc)board.nextval,?,?,?,sysdate,?,?,?,?)";
		query = "INSERT INTO MVC_BOARD(ID,NAME,TITLE,CONTENT) VALUES(SEQ_MVC_BOARD.NEXTVAL,?,?,?)";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
//			pstmt.setInt(4, dto.getHit());
//			pstmt.setInt(5, dto.getGroups());
//			pstmt.setInt(6, dto.getStep());
//			pstmt.setInt(7, dto.getIndent());

			int iResult = pstmt.executeUpdate();
			System.out.println(iResult);
			if (iResult >= 1) {
				System.out.println("insert success");
			} else {
				System.out.println("insert fail");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void updateContent(MBDto dto) {

		int id = dto.getId();
		String name = dto.getName();
		String title = dto.getTitle();
		String content = dto.getContent();
//		Timestamp writedate = dto.getWrite_date();
//		int hit=dto.getHit();
//		int groups=dto.getGroups();
//		int step=dto.getStep();
//		int indent=dto.getIndent();
		System.out.println(title + name + content + id);

		query = "UPDATE MVC_BOARD SET NAME=?,TITLE=?,CONTENT=? WHERE ID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setInt(4, id);

			int iResult = pstmt.executeUpdate();

			if (iResult >= 1) {
				System.out.println("update success");
			} else {
				System.out.println("update fail");
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	public void deleteContent(int id) {

		query = "DELETE FROM MVC_BOARD WHERE ID=?";

		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);

			int iResult = pstmt.executeUpdate();

			if (iResult >= 1) {
				System.out.println("delete success");
			} else {
				System.out.println("delete fail");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
