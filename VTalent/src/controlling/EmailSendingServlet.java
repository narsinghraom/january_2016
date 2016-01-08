package controlling;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlling.EmailUtility;

/**
 * Servlet implementation class EmailSendingServlet
 */

@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

	private String host;
	private String port;
	private String user;
	private String pass;

	public EmailSendingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String candidate_Name = request.getParameter("Candidate_name");
		String candidate_Email = request.getParameter("Candidate_email");
		String candidate_MobileNo = request.getParameter("Candidate_mobileno");
		String candidate_Technology = request
				.getParameter("Candidate_technology");

		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, candidate_Name,
					candidate_Email, candidate_MobileNo, candidate_Technology);
			resultMessage = "Thanks For your enroll";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "oops..!!!!: " + ex.getMessage();
		} finally {
			session.setAttribute("Message", resultMessage);
			
			getServletContext().getRequestDispatcher("/Result.jsp").forward(
					request, response);
		}
	}
}
