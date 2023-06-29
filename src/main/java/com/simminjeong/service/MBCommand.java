package com.simminjeong.service;

import java.util.ArrayList;

import com.simminjeong.dto.MBDto;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MBCommand {

	void excute(HttpServletRequest request, HttpServletResponse response);

}
