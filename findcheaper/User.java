package findcheaper;


public class User {
	public String username;
	private String password;
	private int power;
	User()
	{}
	User(String username,String password, int power)
	{
		this.username=username;
		this.password=password;
		this.power=power;
	}

	public void logout()
	{	
		
		this.password=null;
		this.username=null;
		this.power=-1;
	}
	
		
	
	public void update_power()
	{
		this.power=1;
	}
	
}
