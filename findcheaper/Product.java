package findcheaper;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
class TestUrl{
	private static URL url=null;
	private static HttpURLConnection connection;
	private static int statusCode = -1; 
	private static int testCounts = 5;
	
	public synchronized URL isConnect(String urlStr) {  
		 int counts = 1;  
		 if (urlStr == null || urlStr.length() <= 0) 
		 {                         return null;                   
		 }  
		 while (counts <= testCounts) 
		 {  
			 try {url = new URL(urlStr);  
			 connection = (HttpURLConnection) url.openConnection();  
			 statusCode = connection.getResponseCode();  
			 System.out.println("第"+(counts) +"/"+testCounts+"次链接，   statusCode:"+statusCode); 
			 counts++;   //非格式错误链接
		 if (statusCode == 200) {//可连接
			 System.out.println("URL可用！");  
			 break;  }
		 else{//不可连接
			 url = null;
			 }
		 }
		  
		 catch (MalformedURLException e) {//格式错误
			 System.out.println("URL不可用，尝试连接第"+(counts) +"/"+testCounts+"次"); 
			 url = null; counts++;   
			 continue;  }
		 catch (IOException e) {
			 //IO错误
			 System.out.println("URL不可用，尝试连接第"+(counts) +"/"+testCounts+"次"); 
			 url = null; counts++;   }
		 	}  
		 return url;  
		 }
		 
	 
	  
}


public class Product {
	public String title;
	public float price;
	public String img;
	public String url;
	public float CQF;
	Product(){}
	public Product(String title,String url, String img ,float CQF,float price) throws MalformedURLException{
		this.title=title;
		this.price=price;
		this.img=img;
		this.url=url;
		this.CQF=CQF;
	}
	public boolean test_url()	
	{
		TestUrl a=new TestUrl();
		
		URL temp=a.isConnect(url.toString());
		if(temp!=null)
		return true;
		else 
			return false;
	}
	 

	
}

