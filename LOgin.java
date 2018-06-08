package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LOgin")
public class LOgin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LOgin() {
        super();
      }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doPost(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {	
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/message";
			String username = "root";					
			String password = "123456";						
			
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt = conn.createStatement();	
			String sql = "select * from note";			
			ResultSet rs = stmt.executeQuery(sql);		
			List<Listbean> list = new ArrayList<>();		
			while(rs.next()){								
				Listbean mess = new Listbean();					
				mess.setId(rs.getInt("id"));					
				mess.setAuthor(rs.getString("author"));		
				mess.setXinxi(rs.getString("xinxi"));
				mess.setJianjie(rs.getString("jianjie"));
					
				list.add(mess); 							
			}
			request.setAttribute("list", list); 		
			rs.close();									
			stmt.close();									
			conn.close();									
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("gouwu.jsp").forward(request, response);
	
	}

}
