package com.simminjeong.controller;

import java.sql.Timestamp;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.simminjeong.dto.MBDto;
import com.simminjeong.service.Service;
import com.simminjeong.service.ServiceImpl;

/**
 * Servlet implementation class FrontCon
 */
@WebServlet("*.do")
public class FrontCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontCon() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("actionDo");
		String uri = request.getRequestURI();
		System.out.println("uri : " + uri);

		String conPath = request.getContextPath();
		System.out.println("conPath : " + conPath);

		String command = uri.substring(conPath.length());
		System.out.println("command : " + command);

		if (command.equals("/main.do")) {
			System.out.println("/main.do");

			Service svc = new ServiceImpl();
			ArrayList<MBDto> dtos = svc.excuteSelectAll();

			request.setAttribute("boardlist", dtos);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/main.jsp");
			dispatcher.forward(request, response);

		} else if (command.contains("/submain.do")) {
			System.out.println("/submain.do");

			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println("id" + id);
			Service svc = new ServiceImpl();
			MBDto dto = svc.excuteSelectId(id);

			/*
			 * response.setContentType("text/html; charset=UTF-8"); PrintWriter pw =
			 * response.getWriter();
			 * pw.println("<html><head><title>회원조회</title></head></head><body>");
			 * 
			 * 
			 * int id1 = dto.getId(); String name = dto.getName(); String title =
			 * dto.getTitle(); String content = dto.getContent(); int hit = dto.getHit();
			 * 
			 * pw.println("SSSS"+id1 + ", " + name + ", " + title + ", " + content + ", " +
			 * hit);
			 * 
			 * pw.println("</body></html>");
			 */

			request.setAttribute("idcontent", dto);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/submain.jsp");
			dispatcher.forward(request, response);

		} else if (command.equals("/insert.do")) {
			System.out.println("insert.do");

			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			System.out.println(title + name + content);
			Service svc = new ServiceImpl();
			MBDto dto = new MBDto(name, title, content);
			svc.excuteInsert(dto);

			response.sendRedirect("/Mvc_board/main.do");

		} else if (command.equals("/update.do")) {
			System.out.println("update.do");
			int id = Integer.parseInt(request.getParameter("id"));
			String title = request.getParameter("title");
			String name = request.getParameter("name");
			String content = request.getParameter("content");
			System.out.println(title + name + content);

			MBDto dto = new MBDto(id, name, title, content);
			Service svc = new ServiceImpl();
			svc.excuteUpdate(dto);

			response.sendRedirect("/Mvc_board/main.do");

		} else if (command.equals("/delete.do")) {
			System.out.println("delete.do");
			Service svc = new ServiceImpl();
			String[] selectedIds = request.getParameterValues("selectedIds");
			if (selectedIds != null) {
				for (String id : selectedIds) {
					svc.excuteDelete(Integer.parseInt(id));
				}
				response.sendRedirect("/Mvc_board/main.do");
			} else {
				response.sendRedirect("/Mvc_board/main.do");

			}

		}

	}

}
