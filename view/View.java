package view;

import java.awt.EventQueue;
import java.util.concurrent.ArrayBlockingQueue;

import findcheaper.OptionMessage;

public class View {
	public ArrayBlockingQueue<OptionMessage> recieve=new ArrayBlockingQueue<OptionMessage>(10);
	public ArrayBlockingQueue<OptionMessage> send=new ArrayBlockingQueue<OptionMessage>(10);
	Fc_login login;
	public View(ArrayBlockingQueue<OptionMessage> recieve,ArrayBlockingQueue<OptionMessage> send)
	{	
		this.recieve=recieve;
		this.send=send;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login = new Fc_login(recieve,send);
					login.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}

