

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.sql.*; //ResultSet class hyat asto


public class Withdrawl extends JFrame implements ActionListener{
	
	JTextField amount;
	JButton withdrawl, back;
	String pinnumber;
	
	Withdrawl(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image =  new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		text.setBounds(170,300,400,20);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 25));
		amount.setBounds(170,350,320,30);
		image.add(amount);

		withdrawl = new JButton("Withdraw");
		withdrawl.setBounds(355,450,150,30);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		back = new JButton("Back");
		back.setBounds(355,485,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		
		if (ae.getSource() == withdrawl) {
			
			String enteredamount = amount.getText();
			Date date = new Date();
			
			
			
			try {
			if (enteredamount.equals("")) {
				
				JOptionPane.showMessageDialog(null,"Please enter the amount"); // he sgle validation ahet. he jr nsl enter kel tr data base mde data janarch nahi
			}
			
			else {
				
				
				Conn conn = new Conn();
				
				int balance = 0;
				ResultSet rs = conn.s.executeQuery("select * from transaction where pin = '"+pinnumber+"'");
				
				
				while(rs.next()) {
					if(rs.getString("type").equals("Deposit")) {
						
						balance += Integer.parseInt(rs.getString("amount"));
						}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));

					}
				}
				
				if(balance < Integer.parseInt(enteredamount)) {
					JOptionPane.showMessageDialog(null,"Insufficient Balance Yaar !");
				}
				
				else {
				String query = "insert into transaction values('"+pinnumber+"', '"+date+"', 'Withdraw', '"+enteredamount+"')";
				conn.s.executeUpdate(query);
				//varcha jr sgla correct zl tr khali msg yenar
				
				JOptionPane.showMessageDialog(null,"Rs " + enteredamount + " Withdrawed Successfully");
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				}
			}
			
			}catch (Exception e) {
				
				System.out.println(e);
				
			}
			
		}
		else if(ae.getSource() == back) {
			
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Withdrawl(" ");

	}

}
