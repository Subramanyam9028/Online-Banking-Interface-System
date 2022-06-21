
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*; //ResultSet class hyat asto


public class Ministatement extends JFrame{
	
	
	String pinnumber;
	
	Ministatement(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,500,400,60);
		add(balance);
		
		
		JLabel bank = new JLabel("Subramanyam's Bank");
		bank.setBounds(130,20,150,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		try {
			
			Conn c = new Conn();
			
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				card.setText("Card Number : " + rs.getString("cardnumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
				
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
		try {
			Conn c = new Conn();
			
			int bal = 0;
			
			ResultSet rs = c.s.executeQuery("select * from transaction where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				
				mini.setText(mini.getText() +  "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><b><html> " );
				
				if(rs.getString("type").equals("Deposit")) {
						
					bal += Integer.parseInt(rs.getString("amount"));
					}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));

				}
				
			}
			
			balance.setText("Your Current Account Balance Is Rs " + bal + ". Thank You For Visiting !");
			
		}catch(Exception e) {
			System.out.println(e);
			
		}
		
		
		
		
		
		
		
		
		
		setSize(450,600);
		setLocation(20,20);
		setTitle("ATM INTERFACE");
		getContentPane().setBackground(Color.WHITE);//background colour change he awt package mde aste
//		setUndecorated(true);//jr aplyala close ani minimize cha tab pahije nsl trch
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Ministatement("");

	}

}
