

import java.awt.*;
import javax.swing.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
	
	
	
	
	JLabel  additionalDet, religion, category, income, education, qualification, occupation, pan,citizen, aadhar, existingAcc;
	
	JTextField   panTextField, aadharTextField ;
	
	JDateChooser dateChooser;
	JRadioButton senior, noSenior,yesexist, noexist;
	ButtonGroup citizenGroup, existingGroup;//male kiva female donhi paiki ekach select karnyasathi
	
	JComboBox religions, categorys, occupations, educations,incomes;
	
	String formNo;
	
	JButton next;
	
	SignupTwo(String formNo){
		
		this.formNo = formNo;
		
		setLayout(null);
		
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		additionalDet = new JLabel("Page 2: Additional Details");
		additionalDet.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDet.setBounds(290, 80, 400, 30);
		add(additionalDet);
		
		religion = new JLabel("Religion:");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100, 140, 100, 30);
		add(religion);
		
		String valReligion[] = {"Hindu","Muslim","Sikh","Christian", "Others"};
		religions = new JComboBox(valReligion);
		religions.setBounds(300,140,400,30);
		religions.setBackground(Color.WHITE);
		add(religions);
		
		
		category = new JLabel("Category:");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100, 190, 150, 30);
		add(category);
		
		String valCategory[] = {"General","OBC","SC","ST", "Others"};
		categorys = new JComboBox (valCategory);
		categorys.setBounds(300,190,400,30);
		categorys.setBackground(Color.WHITE);
		add(categorys);
		
		income = new JLabel("Income:");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100, 240, 200, 30);
		add(income);
		
		String valIncome[] = {"Null","<150000","<250000","<500000", "Aprrox 100000"};
		incomes = new JComboBox (valIncome);
		incomes.setBounds(300,240,200,30);
		incomes.setBackground(Color.WHITE);
		add(incomes);
		
		education = new JLabel("Educational");
		education.setFont(new Font("Raleway", Font.BOLD, 20));
		education.setBounds(100, 310, 200, 30);
		add(education);
		
		String valEducation[] = {"Graduate","Post Graduate","Doctrate","Non Graduate", "Others"};
		educations = new JComboBox (valEducation);
		educations.setBounds(300,340,400,30);
		educations.setBackground(Color.WHITE);
		add(educations);
//		
//		female = new JRadioButton("Female");
//		female.setBounds(400,290,80,30);
//		female.setBackground(Color.WHITE);
//		add(female);
//		
//		others = new JRadioButton("Others");
//		others.setBounds(520,290,80,30);
//		others.setBackground(Color.WHITE);
//		add(others);
		
//		genderGroup = new ButtonGroup();
//		genderGroup.add(male);
//		genderGroup.add(female);
//		genderGroup.add(others);
//
//		
		
		qualification = new JLabel("Qualification:");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100, 340, 200, 30);
		add(qualification);
		
		
		occupation = new JLabel("Occupation:");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100, 390, 200, 30);
		add(occupation);
		
		String valOccupation[] = {"Farmer","Salaried","Self Employed ","Business","Student","Retired","Others"};
		occupations = new JComboBox (valOccupation);
		occupations.setBounds(300,390,400,30);
		occupations.setBackground(Color.WHITE);
		add(occupation);
		
		pan = new JLabel("PAN Number:");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100, 440, 200, 30);
		add(pan);
		
		panTextField = new JTextField();
		panTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		panTextField.setBounds(300,440,400,30);
		add(panTextField);
		
		aadhar = new JLabel("Aadhar No:");
		aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		aadhar.setBounds(100, 490, 200, 30);
		add(aadhar);
		
		aadharTextField = new JTextField();
		aadharTextField.setFont(new Font("Raleway", Font.BOLD, 14));
		aadharTextField.setBounds(300,490,400,30);
		add(aadharTextField);
		
		citizen = new JLabel("Senior Citizen:");
		citizen.setFont(new Font("Raleway", Font.BOLD, 20));
		citizen.setBounds(100, 540, 200, 30);
		add(citizen);
		
		senior = new JRadioButton("Yes");
		senior.setBounds(300,540,80,30);
		senior.setBackground(Color.WHITE);
		add(senior);
		
		noSenior = new JRadioButton("No");
		noSenior.setBounds(400,540,100,30);
		noSenior.setBackground(Color.WHITE);
		add(noSenior);
		
		citizenGroup = new ButtonGroup();
		citizenGroup.add(senior);
		citizenGroup.add(noSenior);
		
		
		
		
		existingAcc = new JLabel("Existing Account:");
		existingAcc.setFont(new Font("Raleway", Font.BOLD, 20));
		existingAcc.setBounds(100, 590, 300, 30);
		add(existingAcc);
		
		yesexist = new JRadioButton("Yes");
		yesexist.setBounds(300,590,80,30);
		yesexist.setBackground(Color.WHITE);
		add(yesexist);
		
		noexist = new JRadioButton("No");
		noexist.setBounds(400,590,100,30);
		noexist.setBackground(Color.WHITE);
		add(noexist);
		
		existingGroup = new ButtonGroup();
		existingGroup.add(yesexist);
		existingGroup.add(noexist);
		
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
		
		String religion = (String)religions.getSelectedItem();//itha getSelectedItem he object return krte mnjun tyala string mde type cast karav lagte
		String category = (String)categorys.getSelectedItem();
		String income = (String)incomes.getSelectedItem();
		String citizen = null;
		if(senior.isSelected()) {
			citizen = "Yes";
			
		}
		else if(noSenior.isSelected()) {
			citizen = "No";
		}
		
		
		String education = (String)educations.getSelectedItem();
		
		String pan = panTextField.getText();
		String aadhar = aadharTextField.getText();
		String occupation = (String)occupations.getSelectedItem();
		String existingAcc = null;
		if(yesexist.isSelected()) {
			existingAcc = "Yes";
			
		}
		else if(noexist.isSelected()) {
			existingAcc = "No";
		}
		
		
		try {
			if(pan.equals("")) {
				JOptionPane.showMessageDialog(null,"PAN No. is Required"); // he sgle validation ahet
			}else {
				//database la call maryachi ahe
				Conn c = new Conn();
				String query = "insert into signuptwo values('"+formNo+"','"+religion+"','"+category+"','"+income+"','"+citizen+"','"+education+"','"+aadhar+"','"+pan+"','"+occupation+"','"+existingAcc+"')";
				c.s.executeUpdate(query);// dml command chalavnysathi mnje insert karnyasathi values in tha table
				
			}
			
//			if(fname.equals("")) {
//				JOptionPane.showMessageDialog(null,"Father's name is Required");
//			}
//			
//			if(dob.equals("")) {
//				JOptionPane.showMessageDialog(null,"Date of birth is Required");
//			}
			
			setVisible(false);
			new Signup3(formNo).setVisible(true);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SignupTwo("");

	}

}
