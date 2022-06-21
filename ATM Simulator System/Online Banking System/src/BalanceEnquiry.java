
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*; //ResultSet class hyat asto





public class BalanceEnquiry extends JFrame implements ActionListener {

	String pinnumber;
	JButton back;
	
	BalanceEnquiry(String pinnumber){
		
		setLayout(null);

		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		
		back = new JButton("Back");
		back.setBounds(355,515,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		Conn c = new Conn();
		
			int balance = 0;
		
			try {
				
				ResultSet rs = c.s.executeQuery("select * from transaction where pin = '"+pinnumber+"'");
				
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						
						balance += Integer.parseInt(rs.getString("amount"));
						}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));

					}
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
		
			
		JLabel text = new JLabel("Your Current Account Balance Is Rs. " +balance);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170,400,400,20);
		image.add(text);
			
		setSize(900,900);
		setLocation(300,0);
		setTitle("ATM INTERFACE");
//		setUndecorated(true);//jr aplyala close ani minimize cha tab pahije nsl trch
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinnumber);
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new BalanceEnquiry("");

	}

}
