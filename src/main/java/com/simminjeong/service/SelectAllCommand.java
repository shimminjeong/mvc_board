package com.simminjeong.service;

import java.util.ArrayList;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectAllCommand implements MBCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		MBDao dao = new MBDao();
		ArrayList<MBDto> dtos = dao.selectAll();
		request.setAttribute("boardlist", dtos);
	}

}
