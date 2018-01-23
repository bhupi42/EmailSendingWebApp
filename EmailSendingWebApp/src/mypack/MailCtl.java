package mypack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailCtl
 */
@WebServlet("/MailCtl")
public class MailCtl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String OP_GO="Go";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailCtl() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		String op=request.getParameter("operation");
		
		if(OP_GO.equalsIgnoreCase(op)){
			
		EmailMessage msg = new EmailMessage();
		msg.setTo(email);
		msg.setSubject(subject);
		msg.setMessage(message);
		msg.setMessageType(EmailMessage.HTML_MSG);
		try {
		
			EmailUtility.sendMail(msg);
			
			request.setAttribute("msg","Mail has been Send sucessfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

}
