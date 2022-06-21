
import javax.swing.*;



import java.sql.*; //ResultSet class hyat asto
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener{//ActionListener ha ek interface class ahe.techymul kalnar ki button press kely
	
	JButton login, clear, signup;//global declaration to use in any functions
	JTextField cardTextField;
	JPasswordField pinTextField; //JPasswordField class ha pin la disu det nahi enter krtana
	
	Login(){
		
		setTitle("ATM Simulator System");
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));//image load zali
		
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);//image size kami jast.
		ImageIcon i3 = new ImageIcon(i2);//size kmi krun punha load zali
		JLabel label = new JLabel(i3);//frame vr show hoil image
		add(label);//frame vr add
		
		setLayout(null);  //karan ki bydefault centre la align hote image. Ata kahi pn add krtana tyachi location dyavi lagnar by using setBounds
		label.setBounds(70,10,100,100);//hya position la align karnyasathi.
		
		getContentPane().setBackground(Color.WHITE);//background colour change
		
		JLabel text = new JLabel("Welcome to ATM ");//frame vr kahi matter takych asl tr
		text.setFont(new Font("Osward",Font.BOLD,38));//Osward mnje style ani 38 mnje text size
		text.setBounds(200, 40, 400, 40);
		add(text);
		
		JLabel cardNumber = new JLabel("CARD NUMBER:");
		cardNumber.setFont(new Font("Raleway",Font.BOLD,25));
		cardNumber.setBounds(120, 150, 300, 40);
		add(cardNumber);
		
		cardTextField = new JTextField();//frame vr input box takte
		cardTextField.setBounds(330,150,300,40);
		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(120, 220, 250, 40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setBounds(330,220,300,40);
		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
		add(pinTextField);
		
		login = new JButton("SIGN IN");//JButton class used to show button for login on frame
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.setBounds(330,300,100,30);
		login.addActionListener(this);
		add(login);
		
		clear = new JButton("CLEAR");//JButton class used to show button for login on frame
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.setBounds(450,300,100,30);
		clear.addActionListener(this);
		add(clear);
		
		signup = new JButton("SIGN UP");//JButton class used to show button for login on frame
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		signup.setBounds(570,300,100,30);
		signup.addActionListener(this);
		add(signup);
		
		
		
		setLocation(350,200);
		setSize(800,400);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) { //hya function mul samajnar ki kont button press kely
	
	//actionPerformed hi method ActionListener hya class mde adich declare asnar but ithe ti define karav lagnar
		String cardnumber = cardTextField.getText();
		String pinnumber = pinTextField.getText();
		
		if(ae.getSource()== clear) {
			
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(ae.getSource()== login) {
			if (pinnumber.equals("")) {
				
				JOptionPane.showMessageDialog(null,"Please Enter Pin Number"); 
			}
			
			
			else {
				Conn conn1 = new Conn();
			
				String query = "select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
			
			try {
				
				ResultSet rs = conn1.s.executeQuery(query);   //select hi ek ddl command aslymul apan ithe executeQuery func use kel
				if (rs.next()) { //perticular enter kelela data ahe ka ani to nighun hya rs result mde alay ka?
					
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					
				}else {
					
					JOptionPane.showMessageDialog(null,"Invalid User !"); 
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			
			}
		}
		else if(ae.getSource()== signup){
			
			setVisible(false);
			new SignupOne().setVisible(true);
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Login();

	}

}
