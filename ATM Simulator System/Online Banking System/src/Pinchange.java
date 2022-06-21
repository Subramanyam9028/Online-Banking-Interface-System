

import javax.swing.*;

import java.awt.*;// karan ki hyat image class aste.
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
	
	JButton change, back;
	JTextField pin, repin;
	String pinnumber;
	
	Pinchange(String pinnumber){
		
		setLayout(null);
		
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("CHANGE YOUR PIN");
		text.setBounds(220,280,500,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);//image.add()kel karan ki te textb aplyala image chya vr pahije hot
		
		JLabel pintext = new JLabel("New PIN:");
		pintext.setBounds(165,330,180,25);
		pintext.setForeground(Color.WHITE);
		pintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(pintext);
		
		pin = new JTextField();
		pin.setFont(new Font("Raleway", Font.BOLD, 25));
		pin.setBounds(350,330,150,25);
		image.add(pin);

		
		JLabel repintext = new JLabel("Re-enter Your PIN:");
		repintext.setBounds(165,360,180,35);
		repintext.setForeground(Color.WHITE);
		repintext.setFont(new Font("System", Font.BOLD, 16));
		image.add(repintext);
		
		repin = new JTextField();
		repin.setFont(new Font("Raleway", Font.BOLD, 25));
		repin.setBounds(350,360,150,25);
		image.add(repin);


		
		change = new JButton("Change Pin");
		change.setBounds(355,425,150,30);
		change.addActionListener(this);
		image.add(change);
		
		
		back = new JButton("Back");
		back.setBounds(355,460,150,30);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setTitle("ATM INTERFACE");
//		setUndecorated(true);//jr aplyala close ani minimize cha tab pahije nsl trch
		setVisible(true);// he sglyat shevti pahiije karan ki apan je pn changs krto te hechya adi kele trch te honr.
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		
		
		if(ae.getSource() == change) {
			
			String npin = pin.getText();
			String rpin = repin.getText();
			
			if (!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null,"Entered pins doesn't match");
				return;
			}
			
			else if (npin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter PIN");
				return;
				
				
			}
			
			else if (rpin.equals("")) {
				JOptionPane.showMessageDialog(null,"Please enter PIN");
				return;
				
			}
			
			try {
				
				
				Conn conn = new Conn();
				String query1 = "update transaction set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
				String query3 = "update signupthree set pinnumber = '"+rpin+"' where pinnumber = '"+pinnumber+"'";

				conn.s.executeUpdate(query1);
				conn.s.executeUpdate(query2);
				conn.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null,"Pin changed successfully");

				
			}catch(Exception e) {
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
		
		new Pinchange(" ");

	}

}
