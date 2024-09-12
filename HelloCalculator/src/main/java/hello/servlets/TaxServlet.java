package hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TaxServlet
 */
@WebServlet("/taxServlet")
public class TaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaxServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.println("<html><head>");
		writer.println("<title>");
		writer.println("Tax Application");
		writer.println("</title></head><body>");

		String annualIncome = request.getParameter("income");
		double totalIncome = 1;
		double tax;
		try {
			totalIncome = Double.parseDouble(annualIncome);
			tax = totalIncome * 0.3;
			writer.println("<h3>Your calculated tax payable is: </h3>");

			writer.println("<strong>Your tax amount is: </strong>" + tax);
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			response.sendRedirect("tax-form.html");

		} catch (NumberFormatException ex) {
			writer.println("<h3>Enter a valid number </h3>");
		}
//		tax=totalIncome*0.3;
//		writer.println("<strong>Your tax amount is: </strong>"+tax);
		writer.println("</body></html>");
		// response.getWriter().append("Served at: ").append(request.getContextPath());
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

}
