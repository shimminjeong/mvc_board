package com.simminjeong.service;

import java.util.ArrayList;

import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Service {
	
	public ArrayList<MBDto> excuteSelectAll();
	public MBDto excuteSelectId(int id);
	public void excuteInsert(MBDto dto);
	public void excuteUpdate(MBDto dto);
	public void excuteDelete(int id);
	

}
