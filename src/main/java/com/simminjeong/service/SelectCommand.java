package com.simminjeong.service;

import java.util.ArrayList;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SelectCommand implements MBCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		MBDao dao = new MBDao();
		int id = Integer.parseInt(request.getParameter("id"));
		MBDto dto = dao.selectId(id);
		request.setAttribute("idContent", dto);
	}

}
