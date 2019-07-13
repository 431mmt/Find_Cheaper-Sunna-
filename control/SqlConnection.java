package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	//这里是SqlConnection 类

			/*
			*java连接mysql数据库
			*1、加载驱动程序
			*2、数据库连接
			*3、数据库登录名
			*3、数据库登录密码
			*/
	    Connection con = null;
	    private static final String url="jdbc:mysql://localhost:3306/"+"findcheaper_database"+"?userUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";		
		//数据库连接字符串
	    private static final String user="root";//登录名
	    private static final String password="123321";//密码
	    
		public SqlConnection()
		{
	        //1.加载驱动
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("未能成功加载驱动程序，请检查是否导入驱动程序！");
	                        //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url, user, password);
			        System.out.println("获取数据库连接成功！");
			} catch (SQLException e) {
				System.out.println("获取数据库连接失败！");
	                        //添加一个println，如果连接失败，检查连接字符串或者登录名以及密码是否错误
				e.printStackTrace();
			}
	          
		}
}
