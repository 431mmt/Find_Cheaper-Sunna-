package findcheaper;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;


import control.Controler;
import findcheaper.OptionMessage.Command;

public class Model implements Message,Runnable{
	public ArrayBlockingQueue<OptionMessage> recieve=new ArrayBlockingQueue<OptionMessage>(10);
	public ArrayBlockingQueue<OptionMessage> send=new ArrayBlockingQueue<OptionMessage>(10);
	Controler control=new Controler();
	
	public Model(ArrayBlockingQueue<OptionMessage> recieve,ArrayBlockingQueue<OptionMessage> send)
	{
		this.recieve=recieve;
		this.send=send;
	}
	@Override
	public OptionMessage Recievemessage() {
		// TODO Auto-generated method stub
			try {
				while(this.recieve.size()==0)
				{}
				OptionMessage message=this.recieve.take();
				 switch(message.command)
				 {
				 case login1:{ArrayList<Object> news=new ArrayList<Object>();
				 	news.add(control.Loginuser((String)message.messageQueue.get(0)).equals(message.messageQueue.get(1)));
					 send.put(new OptionMessage(Command.login2,news,1)); break;}
				 case reg1:{ArrayList<Object> news=new ArrayList<Object>();
				 	news.add(control.Registeruser((String)message.messageQueue.get(0), (String)message.messageQueue.get(1)));
				 	send.put(new OptionMessage(Command.reg2,news,1));
				 break;}
				 case sea1:
				 /**
				  * 
				  * */
					 ArrayList<Object> news=new ArrayList<Object>();
					 news.add(control.SelectProduct((String)message.messageQueue.get(0),(int)message.messageQueue.get(1), (int)message.messageQueue.get(2)));
					 send.put(new OptionMessage(Command.sea2,news,1));
					 break;
				 default:break;
				 }
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(this.recieve.size()!=0)
				Recievemessage();	
		}
	}
	
}
