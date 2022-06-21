
import java.awt.*;

import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
	
	
	
	Random ran;
	long random;
	JLabel formNo, personalDet, name, fname, dob, gender, email, marital, address, city, state, pincode;
	
	JTextField nameTextField, fnameTextField, dobTextField, genderTextField, emailTextField, maritalTextField, addressTextField, cityTextField, stateTextField, pincodeTextField ;
	
	JDateChooser dateChooser;
	JRadioButton male, female, married, unmarried, others;
	ButtonGroup genderGroup, maritalGroup;//male kiva female donhi paiki ekach select karnyasathi
	
	JButton next;
	
	SignupOne(){
		
		setLayout(null);
		
		ran = new Random();
		random= Math.abs((ran.nextLong()) % 9000L + 1000L);
		
		formNo = new JLabel("APPLICATION FORM NO."+ random );
		formNo.setFont(new Font("Raleway", Font.BOLD, 38));
		formNo.setBounds(140, 20, 600, 40);
		add(formNo);
		
		personalDet = new JLabel("Page 1: Personal Details");
		personalDet.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDet.setBounds(290, 80, 400, 30);
		add(personalDet);
		
		name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100, 140, 100, 30);
		add(name);
		
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		nameTextField.setBounds(300,140,400,30);
		add(nameTextField);
		
		fname = new JLabel("Surname:");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100, 190, 150, 30);
		add(fname);
		
		fnameTextField = new JTextField();
		fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		fnameTextField.setBounds(300,190,400,30);
		add(fnameTextField);
		
		dob = new JLabel("Date Of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100, 240, 200, 30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,200,30);
		add(dateChooser);
		dateChooser.setForeground(Color.black);
		
		gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100, 290, 100, 30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(400,290,80,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		others = new JRadioButton("Others");
		others.setBounds(520,290,80,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(others);

		
		
		email = new JLabel("Email:");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100, 340, 100, 30);
		add(email);
		
		emailTextField = new JTextField();
		emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		emailTextField.setBounds(300,340,400,30);
		add(emailTextField);
		
		marital = new JLabel("Marital Status:");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100, 390, 200, 30);
		add(marital);
		
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,80,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(400,390,100,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		maritalGroup = new ButtonGroup();
		maritalGroup.add(married);
		maritalGroup.add(unmarried);
		
		
		address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100, 440, 100, 30);
		add(address);
		
		addressTextField = new JTextField();
		addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		addressTextField.setBounds(300,440,400,30);
		add(addressTextField);
		
		city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100, 490, 100, 30);
		add(city);
		
		cityTextField = new JTextField();
		cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		cityTextField.setBounds(300,490,400,30);
		add(cityTextField);
		
		state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100, 540, 100, 30);
		add(state);
		
		stateTextField = new JTextField();
		stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		stateTextField.setBounds(300,540,400,30);
		add(stateTextField);
		
		pincode = new JLabel("Pincode:");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100, 590, 100, 30);
		add(pincode);
		
		pincodeTextField = new JTextField();
		pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		pincodeTextField.setBounds(300,590,400,30);
		add(pincodeTextField);

		next = new JButton("Next");
		next.setBounds(400,650,80,30);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14   ));
		next.addActionListener(this);// he mnte ki next button dablyvr action de
		add(next);
		
		getContentPane().setBackground(Color.white);
		setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2");
		setSize(800,750);
		setLocation(350,10);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		//database mde srv kahi string chya form mde takych
		
		String formNo = "" + random; //double quot lavl ki konti pn long kiva int value string mde convet hote concat houn.
		String name = nameTextField.getText();
		String fname = fnameTextField.getText();
		String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
			
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		else if(others.isSelected()) {
			gender = "Others";
		}
		
		String email = emailTextField.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}
		else if(unmarried.isSelected()) {
			marital = "Unmarried";
				
		}
		
		String address = addressTextField.getText();
		String city = cityTextField.getText();
		String state = stateTextField.getText();
		String pin = pincodeTextField.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,"Name is Required"); // he sgle validation ahet
			}else {
				//database la call maryachi ahe
				Conn c = new Conn();
				String query = "insert into signup values('"+formNo+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
				c.s.executeUpdate(query);// dml command chalavnysathi mnje insert karnyasathi values in tha table
				
				
				setVisible(false);//jr usr cha data successfully ala tr he run hoil ani next page vr jail
				new SignupTwo(formNo).setVisible(true);
			}
			
//			if(fname.equals("")) {
//				JOptionPane.showMessageDialog(null,"Father's name is Required");
//			}
//			
//			if(dob.equals("")) {
//				JOptionPane.showMessageDialog(null,"Date of birth is Required");
//			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupOne();

	}

}
