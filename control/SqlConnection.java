package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	//������SqlConnection ��

			/*
			*java����mysql���ݿ�
			*1��������������
			*2�����ݿ�����
			*3�����ݿ��¼��
			*3�����ݿ��¼����
			*/
	    Connection con = null;
	    private static final String url="jdbc:mysql://localhost:3306/"+"findcheaper_database"+"?userUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";		
		//���ݿ������ַ���
	    private static final String user="root";//��¼��
	    private static final String password="123321";//����
	    
		public SqlConnection()
		{
	        //1.��������
	        try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				System.out.println("δ�ܳɹ������������������Ƿ�����������");
	                        //���һ��println��������������쳣������Ƿ����������������������ַ����Ƿ����
				e.printStackTrace();
			}
			try {
				con = DriverManager.getConnection(url, user, password);
			        System.out.println("��ȡ���ݿ����ӳɹ���");
			} catch (SQLException e) {
				System.out.println("��ȡ���ݿ�����ʧ�ܣ�");
	                        //���һ��println���������ʧ�ܣ���������ַ������ߵ�¼���Լ������Ƿ����
				e.printStackTrace();
			}
	          
		}
}
