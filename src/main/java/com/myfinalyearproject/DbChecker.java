//package com.myfinalyearproject;
//
//import java.sql.Connection;
//
//public class DbChecker {
//	public boolean userExists(String un,String pw){
//		String host="mysql.mcscw3.le.ac.uk";
//		  String database="sgo3";
//		  String username="sgo3";
//		 String password="ieB1Shae";
//		
//		// Connect to mysql and verify username password
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//		 // loads driver
//			String conn_string="jdbc:mysql://"+host+"/"+database;
//			 Connection connect =
//			DriverManager.getConnection(conn_string,username,password);
//
//		PreparedStatement ps = connect.prepareStatement("select email,password from REFERENDUM_USER where email=? and password=?");
//		ps.setString(1, un);
//		ps.setString(2, pw);
//		System.out.println(pw);
//
//		ResultSet rs = ps.executeQuery();
//
//		
////		HttpSession session1=request.getSession(); 
////		System.out.println(session1.getAttribute("name")+"asasasassa");
////		System.out.println("asasasassa");
//		
//		while (rs.next()) {
//			if(un.equals("admin")) {
//				
//				 HttpSession session=request.getSession();  
//			        session.setAttribute("name",un);  
//				 Cookie ck=new Cookie("username",un);  
//		            response.addCookie(ck); 
//				response.sendRedirect("Admin.jsp");}
//			else if(!un.equals("admin")){
//				 HttpSession session=request.getSession();  
//			        session.setAttribute("name",un);  
//				Cookie ck=new Cookie("username",un);  
//	            response.addCookie(ck);
////				request.setAttribute("un", un);
////				request.getRequestDispatcher("VotePage.jsp").forward(request,response);
//				response.sendRedirect("VotePage.jsp");
//				}
////			System.out.println(un);
//			return;
//		}
//}
