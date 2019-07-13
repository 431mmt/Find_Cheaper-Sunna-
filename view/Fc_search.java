package view;
import java.awt.Image;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import findcheaper.Message;
import findcheaper.OptionMessage;
import findcheaper.OptionMessage.Command;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


import findcheaper.Product;

public class Fc_search extends JFrame implements Message{

	/**
	 * 
	 */
	static int n=0;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	ArrayList<Object> messagerecive=new ArrayList<Object>();
	ArrayList<Object> messagesend=new ArrayList<Object>();
	public ArrayBlockingQueue<OptionMessage> recieve,send;
	int sendlength=0;
	int recivelength=0;
	String web2;
	String web3;
	String web4;
    String web1;
    private JTextField textField_5;
    private JTextField textField_6;
    @SuppressWarnings("unused")
	private JLabel lblNewLabel;
    JLabel label1,label2,label3,label4;
    ArrayList<JLabel> label=new ArrayList<JLabel>();
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Fc_search(ArrayBlockingQueue<OptionMessage> recieve,ArrayBlockingQueue<OptionMessage> send) {
		this.recieve=recieve;
		this.send=send;
		 for(int i=0;i<4;i++)
	        {
	        	messagerecive.add("E:\\ps\u7D20\u6750\\timg.jpg");
	        	messagerecive.add("药水哥");
	        	messagerecive.add("http://www.baidu.com");
	        }
	        recivelength=11;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1308, 746);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
       
		
      ImageIcon li=new ImageIcon("C:\\Users\\ASUS\\workspace\\cheaper\\src\\view\\222.png");
           li.setImage(li.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT));
		   JLabel label = new JLabel(li);
		//label.setIcon(new ImageIcon("E:\\ps\u7D20\u6750\\222.png"));
		label.setBounds(500, 0, 150, 150);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(447, 227, 418, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		JButton button = new JButton("\u641C\u7D22");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<Object> news=new ArrayList<Object>();
				news.add(textField.getText());
				news.add(Integer.parseInt(textField_5.getText()));
				news.add(Integer.parseInt(textField_6.getText()));
				sendlength=3;
				try {
					send.put(new OptionMessage(Command.sea1,news,sendlength));
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				label1=new JLabel();
				label2=new JLabel();
				label3=new JLabel();
				label4=new JLabel();
				OptionMessage message=Recievemessage();
				if(message.messageQueue.size()==0)
				{
					JOptionPane.showMessageDialog(null, "没有在该价位的商品!", "提示", JOptionPane.ERROR_MESSAGE); 
				}
				else
				{	removeImage(); 
					
								
					@SuppressWarnings("unchecked")
					ArrayList<Product> products=(ArrayList<Product>)message.messageQueue.get(0);
					if(products.size()!=0)
					{
					web1=products.get(n).url;
				
					String a1=products.get(n).img;
					ImageIcon l1=new ImageIcon(a1);
		           l1.setImage(l1.getImage().getScaledInstance(279, 215, Image.SCALE_DEFAULT));
				    label1.setIcon(l1);
				label1.setBounds(0, 351, 279, 215);
				label1.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						try {
							Runtime.getRuntime().exec("explorer "+ web1);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				});
				label.add(label1);
				label1.setVisible(true);
				contentPane.add(label1);
				textField_1.setText(products.get(n).title);
				
					}
					else{
						JOptionPane.showMessageDialog(null, "没有在该价位的商品!", "提示", JOptionPane.ERROR_MESSAGE); 
					}
				if(products.size()>1)
				{   n++;
					web2=products.get(n).url;
				 String a2=products.get(n).img;
				 ImageIcon l2=new ImageIcon(a2);
		           l2.setImage(l2.getImage().getScaledInstance(294, 223, Image.SCALE_DEFAULT));
		           label2.setIcon(l2);
				label2.setBounds(321, 347, 294, 223);
				label2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						try {
							Runtime.getRuntime().exec("explorer "+ web2);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				});
				label.add(label2);
				label2.setVisible(true);
				contentPane.add(label2);
				textField_2.setText(products.get(n).title);
				
				}
                
				if(products.size()>2)
				{   n++;
					web3=products.get(n).url;
				 String a3=products.get(n).img;
				ImageIcon l3=new ImageIcon(a3);
		           l3.setImage(l3.getImage().getScaledInstance(304, 215, Image.SCALE_DEFAULT));
		           label3.setIcon(l3);
				label3.setBounds(649, 355, 294, 223);
				label3.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						try {
							Runtime.getRuntime().exec("explorer "+ web3);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				});
				label.add(label3);
				label3.setVisible(true);
				contentPane.add(label3);
				textField_3.setText(products.get(n).title);
				}
				
				if(products.size()>3)
				{   n++;
					web4=products.get(n).url;
				 String a4=products.get(n).img;
				ImageIcon l4=new ImageIcon(a4);
		           l4.setImage(l4.getImage().getScaledInstance(311, 215, Image.SCALE_DEFAULT));
		           label4.setIcon(l4);
				label4.setBounds(965, 351, 311, 215);
				label4.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						try {
							Runtime.getRuntime().exec("explorer "+ web4);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
					}
				});
				label.add(label4);
				label4.setVisible(true);
				contentPane.add(label4);
				textField_4.setText(products.get(n).title);
				}
				
				
				JButton btnNewButton = new JButton("换一批");
				btnNewButton.setFont(new Font("楷体", Font.PLAIN, 22));
				btnNewButton.setBounds(580, 659, 113, 27);
				btnNewButton.addMouseListener(new MouseAdapter(){
					  public void mousePressed(MouseEvent e){
						  if(recivelength==0)
							{
								JOptionPane.showMessageDialog(null, "没有在该价位的商品!", "提示", JOptionPane.ERROR_MESSAGE); 
							}
							else
							{					
								removeImage();
								
								if(products.size()>n)
								{
								@SuppressWarnings("unchecked")
								ArrayList<Product> products=(ArrayList<Product>)message.messageQueue.get(0);
								
								web1=products.get(n).url;
								String a1=products.get(n).img;
							
								//URL url=new URL(a1);
								
								
								ImageIcon l1=new ImageIcon(a1);
								
					           l1.setImage(l1.getImage().getScaledInstance(279, 215, Image.SCALE_DEFAULT));
					           label1.setIcon(l1);
							label1.setBounds(0, 351, 279, 215);
							label1.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent e) {
									try {
										Runtime.getRuntime().exec("explorer "+ web1);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} 
								}
							});
							label.add(label1);
							label1.setVisible(true);
							contentPane.add(label1);
							textField_1.setText(products.get(n).title);
								}
							
							if(products.size()>1)
							{   n++;
								web2=products.get(n).url;
							 String a2=products.get(n).img;
							 ImageIcon l2=new ImageIcon(a2);
					           l2.setImage(l2.getImage().getScaledInstance(294, 223, Image.SCALE_DEFAULT));
					           label2.setIcon(l2);
							label2.setBounds(321, 347, 294, 223);
							label2.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent e) {
									try {
										Runtime.getRuntime().exec("explorer "+ web2);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} 
								}
							});
							label.add(label2);
							label2.setVisible(true);
							contentPane.add(label2);
							textField_2.setText(products.get(n).title);
							
							}
			                
							if(products.size()>2)
							{   n++;
								web3=products.get(n).url;
							 String a3=products.get(n).img;
							ImageIcon l3=new ImageIcon(a3);
					           l3.setImage(l3.getImage().getScaledInstance(304, 215, Image.SCALE_DEFAULT));
					           label3.setIcon(l3);
							label3.setBounds(649, 355, 294, 223);
							label3.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent e) {
									try {
										Runtime.getRuntime().exec("explorer "+ web3);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} 
								}
							});
							label.add(label3);
							label3.setVisible(true);
							contentPane.add(label3);
							textField_3.setText(products.get(n).title);
							}
							
							if(products.size()>3)
							{   n++;
								web4=products.get(n).url;
							 String a4=products.get(n).img;
							ImageIcon l4=new ImageIcon(a4);
					           l4.setImage(l4.getImage().getScaledInstance(311, 215, Image.SCALE_DEFAULT));
					           label4.setIcon(l4);
							label4.setBounds(965, 351, 311, 215);
							label4.addMouseListener(new MouseAdapter() {
								@Override
								public void mousePressed(MouseEvent e) {
									try {
										Runtime.getRuntime().exec("explorer "+ web4);
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} 
								}
							});
							label.add(label4);
							label4.setVisible(true);
							contentPane.add(label4);
							textField_4.setText(products.get(n).title);
						
							}
					
							}	
					  }});
				contentPane.add(btnNewButton);
				
				
				}
				
				
				
			}
		});
		button.setBounds(875, 289, 113, 27);
		contentPane.add(button);
		
	
		
		
		
		textField_1 = new JTextField();
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(0, 593, 279, 33);
		textField_1.setBorder(new EmptyBorder(0,0,0,0));;
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(321, 597, 294, 29);
		textField_2.setBorder(null);
		textField_2.setEditable(false);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(649, 597, 304, 29);
		textField_3.setBorder(null);
		textField_3.setEditable(false);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(965, 597, 311, 29);
		textField_4.setBorder(null);
		textField_4.setEditable(false);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
				e.consume(); 
				}
			}
		});
		textField_5.setBounds(447, 290, 97, 27);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5546\u54C1\u540D\u79F0\uFF1A");
		label_1.setFont(new Font("楷体", Font.PLAIN, 22));
		label_1.setBounds(266, 220, 194, 41);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u6700\u4F4E\u4EF7\u683C\uFF1A");
		label_2.setFont(new Font("楷体", Font.PLAIN, 22));
		label_2.setBounds(266, 286, 185, 27);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u8BF7\u8F93\u5165\u6700\u9AD8\u4EF7\u683C\uFF1A");
		label_3.setFont(new Font("楷体", Font.PLAIN, 22));
		label_3.setBounds(558, 286, 185, 27);
		contentPane.add(label_3);
		
		
		
		
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				int keyChar=e.getKeyChar();
				if (keyChar>=KeyEvent.VK_0 && keyChar<=KeyEvent.VK_9) {

				} else {
				e.consume(); 
				}
			}
		});
		textField_6.setBounds(737, 289, 128, 27);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
	

	}

	@Override
	public OptionMessage Recievemessage() {
		while(true)
		{	while(this.recieve.size()==0)
			{}
			try {
				OptionMessage message=this.recieve.take();
				if( message.command==Command.sea2)
					return message;
				else
					this.recieve.put(message);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void removeImage()
	{
		if(this.label!=null&&this.label.size()!=0)
		{
			for(JLabel i:this.label)
			{
				i.setVisible(false);
				remove(i);
			}
			this.label.clear();
		}
	}
}

