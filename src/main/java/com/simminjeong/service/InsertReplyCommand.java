package com.simminjeong.service;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertReplyCommand implements MBCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		int numid = Integer.parseInt(id);
		MBDao dao = new MBDao();
		MBDto getIdDto = dao.selectId(numid);
		int group = getIdDto.getId();
		int step = getIdDto.getStep() + 1;
		int indent = getIdDto.getIndent() + 1;
		MBDto newDto = new MBDto(name, title, content, group, step, indent);
		dao.insertReply(newDto);

	}

}
