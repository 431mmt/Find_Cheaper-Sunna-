package view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import findcheaper.Message;
import findcheaper.OptionMessage;
import findcheaper.OptionMessage.Command;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.ActionEvent;

public class Fc_register extends JFrame implements Message{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	ArrayList<Object> messagerecive=null;
	ArrayList<Object> messagesend=null;
	public ArrayBlockingQueue<OptionMessage> recieve,send;
	int sendlength=0;
	int recivelength=0;


	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Fc_register( ArrayBlockingQueue<OptionMessage> recieve,ArrayBlockingQueue<OptionMessage> send ) {
		this.recieve=recieve;
		this.send=send;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1309, 760);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("楷体", Font.PLAIN, 22));
		label.setBounds(422, 321, 88, 45);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(510, 332, 231, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPasswordField textField_1 = new JPasswordField();
		textField_1.setBounds(512, 429, 229, 29);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 22));
		label_1.setBounds(438, 431, 72, 18);
		contentPane.add(label_1);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()==0 || textField_1.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "请将信息填写完整！", "提示", JOptionPane.ERROR_MESSAGE); 
				}
				else
				{
				ArrayList<Object> news=new ArrayList<Object>();
				
				news.add(textField.getText());
				news.add(textField_1.getText());
				sendlength=2;
				try {
					send.put(new OptionMessage(Command.reg1,news,sendlength));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				OptionMessage message=Recievemessage();
				if((boolean) message.messageQueue.get(0))
				{   
					JOptionPane.showMessageDialog(null, "注册成功!", "提示", JOptionPane.DEFAULT_OPTION); 
					Fc_login a1=new Fc_login(recieve,send);
					a1.setVisible(true);
					setVisible(false);
				}
				else 
					JOptionPane.showMessageDialog(null, "该用户已存在!", "提示", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		button_1.setFont(new Font("楷体", Font.PLAIN, 22));
		button_1.setBounds(526, 534, 204, 27);
		contentPane.add(button_1);
		
		ImageIcon l1=new ImageIcon("C:\\Users\\ASUS\\workspace\\cheaper\\src\\view\\1kkk.png");
		l1.setImage(l1.getImage().getScaledInstance(1065, 689, Image.SCALE_DEFAULT));
		JLabel lblNewLabel = new JLabel(l1);

lblNewLabel.setBounds(55, 0, 1065, 689);
contentPane.add(lblNewLabel);
		
		JButton button = new JButton("\u8FD4\u56DE\u767B\u5F55\u754C\u9762");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fc_login a1=new Fc_login(recieve,send);
				a1.setVisible(true);
				setVisible(false);
			}
		});
		button.setFont(new Font("楷体", Font.PLAIN, 22));
		button.setBounds(526, 588, 207, 27);
		contentPane.add(button);
	}
	public OptionMessage Recievemessage() {
		// TODO Auto-generated method stub
		
		while(true)
		{	while(this.recieve.size()==0)
		{}
			try {
				OptionMessage message=this.recieve.take();
				if( message.command==Command.reg2)
					return message;
				else
					this.recieve.put(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
