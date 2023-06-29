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
import com.simminjeong.service.DeleteCommand;
import com.simminjeong.service.InsertCommand;
import com.simminjeong.service.InsertReplyCommand;
import com.simminjeong.service.MBCommand;
import com.simminjeong.service.SelectAllCommand;
import com.simminjeong.service.SelectCommand;
import com.simminjeong.service.UpdateCommand;

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
		request.setCharacterEncoding("UTF-8");

		String viewPage = null;
		MBCommand service = null;

		String uri = request.getRequestURI();
//
		String conPath = request.getContextPath();

		String command = uri.substring(conPath.length());

		if (command.equals("/main.do")) {
			System.out.println("/main.do");
			viewPage = "main.jsp";

			MBCommand svc = new SelectAllCommand();
			svc.excute(request, response);

		} else if (command.equals("/submain.do")) {
			System.out.println("/submain.do");
			viewPage = "UpdateContent.jsp";

			MBCommand svc = new SelectCommand();
			svc.excute(request, response);
		} else if (command.equals("/update.do")) {
			System.out.println("/update.do");
			viewPage = "menu.jsp";

			MBCommand svc = new UpdateCommand();
			svc.excute(request, response);
		} else if (command.equals("/delete.do")) {
			System.out.println("/delete.do");
			viewPage = "menu.jsp";

			MBCommand svc = new DeleteCommand();
			svc.excute(request, response);
		} else if (command.equals("/insert.do")) {
			System.out.println("/insert.do");
			viewPage = "menu.jsp";

			MBCommand svc = new InsertCommand();
			svc.excute(request, response);

		} else if (command.equals("/insertReply.do")) {
			System.out.println("/insertReply.do");
			viewPage = "menu.jsp";
			MBCommand svc = new InsertReplyCommand();
			svc.excute(request, response);

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
