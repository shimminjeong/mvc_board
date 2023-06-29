package com.simminjeong.service;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateCommand implements MBCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		MBDao dao = new MBDao();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		dao.updateContent(id, name, title, content);
	}

}
