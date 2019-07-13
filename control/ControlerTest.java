package control;



import org.junit.Test;

public class ControlerTest {
	Controler con=new Controler();
	@Test
	public void testRegisteruser() {
		con.Registeruser("55", "55");
	}

	@Test
	public void testLoginuser() {
	con.Loginuser("1");
		
	}

	@Test
	public void testSelectProduct() {
		con.SelectProduct("123", 0, 100);
		
	}
	
}
