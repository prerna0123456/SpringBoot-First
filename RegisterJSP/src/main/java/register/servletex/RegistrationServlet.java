package register.servletex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registeruser")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public  final String USER = "root";

	public  final String KEY = "password";

	public  final String URL = "jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public  Connection getDBConnect(String user,String password, String dbURL) {
    	
    	Connection conn=null;
    	try {
    		
    		
    		
			conn=DriverManager.getConnection(dbURL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return conn;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String age=request.getParameter("age");
		Integer iage;
		try {
		iage=Integer.valueOf(age);
		}catch(NumberFormatException nfe) {
			request.setAttribute("error", "Age can only be a number");
			System.out.println("Exception "+nfe.getMessage());
		}
		String profession=request.getParameter("prof");
		String agenda=request.getParameter("agenda");
		
		System.out.println("name: "+name+" Age: "+age+" Profession: "+profession+ " Agenda: "+agenda);
		
		Connection conn=getDBConnect(USER, KEY,URL);
		
		String sqlstr="INSERT INTO usersubmissions(name,age,profession,agenda) values( "+"'"+name+"',"+age+",'"+profession+"','"+agenda+"')";
		
		Statement stmt=null;
		int key=-1;
		
		try {
			if(conn!=null) {
			stmt=conn.createStatement();
			stmt.executeUpdate(sqlstr,Statement.RETURN_GENERATED_KEYS);
			ResultSet results = stmt.getGeneratedKeys();
			
			if( results!=null && results.next()){
				key=results.getInt(1);
			}
			} else {
				System.out.println("Unable to make connection");
			}
			
			}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		PrintWriter writer = response.getWriter();
		
		RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
		
		request.setAttribute("ticket",key);
		
		rd.forward(request, response);
		
//		writer.println();
		
		
		//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
