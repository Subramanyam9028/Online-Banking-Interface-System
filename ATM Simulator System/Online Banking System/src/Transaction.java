
import javax.swing.*;



import java.awt.*;// karan ki hyat image class aste.
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener{
	
	JButton deposit, withdraw, ministate, pinchange, fastcash, balance, exit;
	String pinnumber;
	
	Transaction(String pinnumber){
		
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please select Your Transaction");
		text.setBounds(220,280,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);//image.add()kel karan ki te textb aplyala image chya vr pahije hot
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,390,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdraw = new JButton("Cash Withdraw");
		withdraw.setBounds(355,390,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
//		fastcash = new JButton("Fast Cash");
//		fastcash.setBounds(170,425,150,30);
//		fastcash.addActionListener(this);
//		image.add(fastcash);
		
		ministate = new JButton("Mini Statement");
		ministate.setBounds(355,425,150,30);
		ministate.addActionListener(this);
		image.add(ministate);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(170,460,150,30);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(170,425,150,30);
		balance.addActionListener(this);
		image.add(balance);
		
		
		exit = new JButton("Exit");
		exit.setBounds(355,460,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
		setSize(900,900);
		setLocation(300,0);
		setTitle("ATM INTERFACE");
//		setUndecorated(true);//jr aplyala close ani minimize cha tab pahije nsl trch
		setVisible(true);// he sglyat shevti pahiije karan ki apan je pn changs krto te hechya adi kele trch te honr.
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == exit) {
			
			System.exit(0);
		}
		else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
			
	}else if(ae.getSource() == withdraw) {
		setVisible(false);
		new Withdrawl(pinnumber).setVisible(true);
		
}
	else if(ae.getSource() == pinchange) {
		setVisible(false);
		new Pinchange(pinnumber).setVisible(true);
	}
		
	else if(ae.getSource() == balance) {
		setVisible(false);
		
		
		new BalanceEnquiry(pinnumber).setVisible(true);
	}
	else if(ae.getSource() == ministate) {
		
//		setVisible(false); karan ki mla atm pn pahije ani statement pn
		
		new Ministatement(pinnumber).setVisible(true);
	}
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Transaction(" ");

	}

}
