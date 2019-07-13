package findcheaper;

import java.util.ArrayList;

public class OptionMessage {
 public enum Command{login1,login2,reg1,reg2,sea1,sea2}
	public Command command;
	public ArrayList<Object> messageQueue;
	public int messagelength;
	public OptionMessage(Command com,ArrayList<Object> messageQueue,int messagelength){
		this.command=com;
		this.messageQueue=messageQueue;
		this.messagelength=messagelength;
	}
	

}
