package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =  String.valueOf(request.getParameter("id"));
		String pwd =  String.valueOf(request.getParameter("password"));
		//System.out.println(id);
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/message";
		String username="root";
		String password="105188";
		Connection myconn=DriverManager.getConnection(url,username,password);
		if(myconn!=null){
			System.out.println("���ݿ����ӳɹ���");
			
			}else{
			System.out.println("���ݿ�����ʧ�ܣ�");
			}
		String sql="select * from person where name='"+id+"'and password='"+pwd+"'";//password='"+pwd+"'
		Statement stmt=myconn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			
			 response.sendRedirect("LOgin");
			System.out.println("��¼�ɹ�");
		}else{
			 if(request.getAttribute("name") == null){
				 request.setAttribute("error","��û�е�¼���������");
			       request.getRequestDispatcher("index.jsp").forward(request,response);
			    }
		}
		myconn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}