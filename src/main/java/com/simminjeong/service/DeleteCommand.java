package com.simminjeong.service;

import com.simminjeong.dao.MBDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCommand implements MBCommand {

	@Override
	public void excute(HttpServletRequest request, HttpServletResponse response) {

		MBDao dao = new MBDao();
		String[] selectedIds = request.getParameterValues("selectedIds");

		if (selectedIds != null) {
			for (String id : selectedIds) {
				dao.deleteContent(Integer.parseInt(id));
			}
		}

	}

}
