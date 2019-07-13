package control;

import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import findcheaper.Product;

public class Controler {
	
	public Boolean Registeruser(String u,String p){//注册时插入用户信息，看用户是否存在
		String sqlInsert1="insert into users_information VALUES('"+u+"',"+p+")";
		
		SqlConnection sql=new SqlConnection();//连接数据库
		try {
			Statement st=sql.con.createStatement();
			System.out.println("创建Statement成功");
			st.executeUpdate(sqlInsert1);
			System.out.println("添加数据成功 ");
			st.close();
			sql.con.close();
			return true;		
		} catch (SQLException e) {
			
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}	
	}
	
	public String Loginuser(String u){//登录时查找用户是否存在或密码是否正确
		String sqlStr1="select * from users_information where users_name='"+u+"'";
		SqlConnection sql=new SqlConnection();//连接数据库
		try {
			Statement st=sql.con.createStatement();
			System.out.println("创建Statement成功");		
			ResultSet rs=st.executeQuery(sqlStr1);
			String p=null;
			while(rs!=null&&rs.next())
			p=rs.getString(1);			//得到密码
			System.out.println("查询数据成功!");
			System.out.println("--------------!");
			rs.close();
			st.close();
			sql.con.close();
			return p;//返回密码	
		} catch (SQLException e) {
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;//若没有找到，返回空
		}	
	}
	
	
	public ArrayList<Product> SelectProduct(String name,int low,int high){//查询商品
		String sqlStr1="select * from products_information where ProductTitle like'%"+name+"%'and ProductPrice>"+low+" and ProductPrice<"+high;//找到查询的商品名的一列数据
		SqlConnection sql=new SqlConnection();//连接数据库
		try {
			Statement st=sql.con.createStatement();
			System.out.println("创建Statement成功");		
			ResultSet rs=st.executeQuery(sqlStr1);
			 ArrayList<Product> news=new ArrayList<Product>();
			while(rs!=null&&rs.next()){

				news.add(new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5)));
			}
			
			System.out.println("查询数据成功!");
			System.out.println("--------------!");
			rs.close();
			st.close();
			sql.con.close();
			return news;//返回密码	
		} catch (SQLException e) {
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;//若没有找到，返回空
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}


}
