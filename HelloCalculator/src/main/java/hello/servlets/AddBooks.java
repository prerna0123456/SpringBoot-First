package hello.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/newaddition")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String USER = "root";

	public static final String KEY = "password";

	public static final String URL = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("<html><head>");
		writer.println("<title>");
		writer.println("Tax Application");
		writer.println("</title></head><body>");

		try {
			String booktitle=request.getParameter("booktitle");
			String bookauthor=request.getParameter("bookauthor");
			String quantity=request.getParameter("qty");
			Integer bqty=0;
			try {
			bqty=Integer.parseInt(quantity);
			String sqlstr="INSERT INTO newadditions(title,author,quantity) values('"+booktitle+"','"+bookauthor+"',"+bqty+")";
			System.out.println(sqlstr);
			Connection con=DBHelper.connectBookShop(URL, USER, KEY);
			Statement stms = con.createStatement();
			stms.executeUpdate(sqlstr);
			writer.println(booktitle+" added to the catalogs.");
			writer.println("Thanks for submission");
			
			}catch(NumberFormatException nfe) {
				writer.println("<h3>Recheck qty</h3>");
				writer.println("</body></html>");
			}
			writer.println("</body></html>");
		} catch (SQLException e) {
			e.printStackTrace();
			writer.println("<h2>Check tomcat console for more details</h2>");
			writer.println("</body></html>");
		}
		writer.println("</body></html>");
		
//		doGet(request, response);
	}

}
