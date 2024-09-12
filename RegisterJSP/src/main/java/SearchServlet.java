

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import register.servletex.User;


@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SearchServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String USER="root";
		String KEY="password";
		String URL="jdbc:mysql://localhost:3306/ebookshop?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String name=request.getParameter("search");
		System.out.println(name);
		String query="SELECT apname,age, profession FROM usersubmissions WHERE apname='"+name+"'  ";
		Integer age;
		String prof;
		Connection conn;
		
		List<User> searchedUser=new ArrayList<>();
		User u;
		
		try {
			
			conn=DriverManager.getConnection(URL, USER, KEY);
			Statement stmt=conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				name=rs.getString(1);
				age=rs.getInt(2);
				prof=rs.getString(3);
				u=new User(name,age,prof);
				searchedUser.add(u);
				System.out.println("Name: "+name+" Age: "+age+" Profession: "+prof);
				
			}
			
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
	
	

		request.setAttribute("searchedUser", searchedUser);
		getServletConfig().getServletContext().getRequestDispatcher("/SearchResults.jsp").forward(request, response);
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
