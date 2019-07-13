
import java.util.concurrent.ArrayBlockingQueue;

import findcheaper.Model;
import findcheaper.OptionMessage;
import view.View;

public class FindCheaper {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayBlockingQueue<OptionMessage> recieve=new ArrayBlockingQueue<OptionMessage>(10);
		 ArrayBlockingQueue<OptionMessage> send=new ArrayBlockingQueue<OptionMessage>(10);
		Model model=new Model(send,recieve);
		new Thread(model).start();
		View view=new View(recieve,send);
	
		
		
		
		
	}

}
