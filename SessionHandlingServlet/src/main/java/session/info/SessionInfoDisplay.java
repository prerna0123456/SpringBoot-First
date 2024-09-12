package session.info;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionInfoDisplay
 */
@WebServlet("/shop")
public class SessionInfoDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionInfoDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		
		HttpSession session;
		
		session=request.getSession();
		
		session.setMaxInactiveInterval(10);
		
		writer.println("<html><head>");
		writer.println("<title>SessionServlet</title>");
		writer.println("<body>");
		
		Date d = new Date(session.getCreationTime());
		
		ShoppingCart previouscart=new ShoppingCart();
		
		System.out.println(previouscart);
		
		session.setAttribute("previouscart", previouscart);
		
		
		Integer accessCount; 
		
		synchronized (session) {
			
			accessCount=(Integer)session.getAttribute("accessCoun");
			
			if(accessCount==null) {
				accessCount=1;
			}else {
				accessCount++;
				
			}
			session.setAttribute("accessCoun", accessCount);
		}
		writer.println("<h3>You have accessed this session "+ accessCount+" times");
		writer.println("<h3>Session cretion time"+ d +"</h3>");
		
		writer.println("<h3>Session id time"+ session.getId()+"</h3>");
		
		writer.println("<h3>Session last accessed time"+ new Date(session.getLastAccessedTime())+"</h3>");
		
		writer.println("<a href="+request.getRequestURI()+">Refresh</a>");
		
		var savedcart= session.getAttribute("previouscart");
		
		writer.println("You have saved items in your cart"+savedcart);
		
		
		writer.println("</body>");
		writer.println("</html>");
		
		
		
		
		
		
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		PrintWriter writer = response.getWriter();
		
		response.setContentType("text/html");
		
		HttpSession session;
		
		session=request.getSession();
		
		session.setMaxInactiveInterval(10);
		
		writer.println("<html><head>");
		writer.println("<title>SessionServlet</title>");
		writer.println("<body>");
		
		String[] addedItems=request.getParameterValues("electronics");
		String[] chocItems=request.getParameterValues("chocolates");
		
		System.out.println("Selected items on home page:"+Arrays.toString(addedItems));
		System.out.println("Selected items on home page:"+Arrays.toString(chocItems));
		
		writer.println("<h4>Items in your Electronics cart"+Arrays.toString(addedItems)+"</h4><br>");
		writer.println("<h4>Items in your Chocolate cart"+Arrays.toString(chocItems)+"</h4><br>");
		
		writer.println("</body>");
		writer.println("</html>");
		
		

	}

}
