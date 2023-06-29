package com.simminjeong.service;

import java.util.ArrayList;

import com.simminjeong.dao.MBDao;
import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ServiceImpl implements Service {

	MBDao mbDao = new MBDao();

	@Override
	public ArrayList<MBDto> excuteSelectAll() {
		return mbDao.selectAll();
	}

	@Override
	public MBDto excuteSelectId(int id) {
		return mbDao.selectId(id);
	}

	@Override
	public void excuteInsert(MBDto dto) {
		mbDao.insertContent(dto);
	}

	@Override
	public void excuteUpdate(MBDto dto) {
		mbDao.updateContent(dto);
	}

	@Override
	public void excuteDelete(int id) {
		mbDao.deleteContent(id);
	}

}
