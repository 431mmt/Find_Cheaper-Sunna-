package control;

import java.net.MalformedURLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import findcheaper.Product;

public class Controler {
	
	public Boolean Registeruser(String u,String p){//ע��ʱ�����û���Ϣ�����û��Ƿ����
		String sqlInsert1="insert into users_information VALUES('"+u+"',"+p+")";
		
		SqlConnection sql=new SqlConnection();//�������ݿ�
		try {
			Statement st=sql.con.createStatement();
			System.out.println("����Statement�ɹ�");
			st.executeUpdate(sqlInsert1);
			System.out.println("������ݳɹ� ");
			st.close();
			sql.con.close();
			return true;		
		} catch (SQLException e) {
			
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return false;
		}	
	}
	
	public String Loginuser(String u){//��¼ʱ�����û��Ƿ���ڻ������Ƿ���ȷ
		String sqlStr1="select * from users_information where users_name='"+u+"'";
		SqlConnection sql=new SqlConnection();//�������ݿ�
		try {
			Statement st=sql.con.createStatement();
			System.out.println("����Statement�ɹ�");		
			ResultSet rs=st.executeQuery(sqlStr1);
			String p=null;
			while(rs!=null&&rs.next())
			p=rs.getString(1);			//�õ�����
			System.out.println("��ѯ���ݳɹ�!");
			System.out.println("--------------!");
			rs.close();
			st.close();
			sql.con.close();
			return p;//��������	
		} catch (SQLException e) {
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return null;//��û���ҵ������ؿ�
		}	
	}
	
	
	public ArrayList<Product> SelectProduct(String name,int low,int high){//��ѯ��Ʒ
		String sqlStr1="select * from products_information where ProductTitle like'%"+name+"%'and ProductPrice>"+low+" and ProductPrice<"+high;//�ҵ���ѯ����Ʒ����һ������
		SqlConnection sql=new SqlConnection();//�������ݿ�
		try {
			Statement st=sql.con.createStatement();
			System.out.println("����Statement�ɹ�");		
			ResultSet rs=st.executeQuery(sqlStr1);
			 ArrayList<Product> news=new ArrayList<Product>();
			while(rs!=null&&rs.next()){

				news.add(new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getFloat(4),rs.getInt(5)));
			}
			
			System.out.println("��ѯ���ݳɹ�!");
			System.out.println("--------------!");
			rs.close();
			st.close();
			sql.con.close();
			return news;//��������	
		} catch (SQLException e) {
			System.out.println("ErrorCode"+e.getErrorCode());
			System.out.println("SQLState"+e.getSQLState());
			System.out.println("reason:"+e.getMessage());
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			return null;//��û���ҵ������ؿ�
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}


}
