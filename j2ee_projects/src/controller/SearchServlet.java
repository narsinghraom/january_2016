package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.StateBean;
import dao.DBConnection;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String country_Name=request.getParameter("country");
		DBConnection connect=new DBConnection();
		ArrayList<StateBean> state_array=connect.getState(country_Name);
		Iterator<StateBean> iterator=state_array.iterator();
		StateBean statebean=null;
		while(iterator.hasNext())
		{
			statebean=(StateBean)iterator.next();
		}
		HttpSession session=request.getSession();
		session.setAttribute("state_object", statebean);
		RequestDispatcher dispatcher=request.getRequestDispatcher("SearchPage.jsp");
		dispatcher.include(request, response);
	}

}
