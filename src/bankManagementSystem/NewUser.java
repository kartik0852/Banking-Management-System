package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class NewUser extends JFrame implements ActionListener {

	JTextField uname,ufname,uemail,uaddress,ucity,ustate,upincode;
	JButton next;
	JRadioButton male, female,others,married,unmarried;
	JDateChooser dateChooser;
	JLabel formno;
	long random;
	
	public NewUser() {
		
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong() % 9000L) + 1000L);
		
		formno = new JLabel("Application Form No. "+random);
		formno.setFont(new Font("Raleway", Font.BOLD, 38));
		formno.setBounds(180,20,600,40);
		add(formno);
		
		JLabel personalDetails = new JLabel("Page 1: Personal Details");
		personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personalDetails.setBounds(290,80,400,30);
		add(personalDetails);
		
		// Name
		JLabel name = new JLabel("Name :");
		name.setFont(new Font("Raleway", Font.BOLD, 20));
		name.setBounds(100,140,100,30);
		add(name);
		
		uname = new JTextField();
		uname.setBounds(260,140,400,30);
		uname.setFont(new Font("Raleway", Font.BOLD, 20));
		add(uname);
		
		// Father's name
		JLabel fname = new JLabel("Father's Name :");
		fname.setFont(new Font("Raleway", Font.BOLD, 20));
		fname.setBounds(100,180,200,30);
		add(fname);
		
		ufname = new JTextField();
		ufname.setBounds(260,180,400,30);
		ufname.setFont(new Font("Raleway", Font.BOLD, 20));
		add(ufname);
		
		// Date of Birth
		JLabel dob = new JLabel("Date of Birth :");
		dob.setFont(new Font("Raleway", Font.BOLD, 20));
		dob.setBounds(100,220,200,30);
		add(dob);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(260, 220, 400,30);
		dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));
		add(dateChooser);
		
		
		// Gender
		JLabel gender = new JLabel("Gender :");
		gender.setFont(new Font("Raleway", Font.BOLD, 20));
		gender.setBounds(100,260,200,30);
		add(gender);
		//set radio button
		male = new JRadioButton("Male");
		male.setBackground(Color.WHITE);
		male.setBounds(260, 260, 60,30);
		add(male);
		
		female = new JRadioButton("Female");
		female.setBounds(330,260,80,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		others = new JRadioButton("Others");
		others.setBounds(420,260,80,30);
		others.setBackground(Color.WHITE);
		add(others);
		
		ButtonGroup genderButton = new ButtonGroup();
		genderButton.add(male);
		genderButton.add(female);
		genderButton.add(others);
		
		
		// Email
		JLabel email = new JLabel("Email :");
		email.setFont(new Font("Raleway", Font.BOLD, 20));
		email.setBounds(100,300,200,30);
		add(email);
		
		uemail = new JTextField();
		uemail.setBounds(260,300,400,30);
		uemail.setFont(new Font("Raleway", Font.BOLD, 20));
		add(uemail);
		
		// Marital Status
		JLabel marital = new JLabel("Marital Status :");
		marital.setFont(new Font("Raleway", Font.BOLD, 20));
		marital.setBounds(100,340,200,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(260,340,80,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(350,340,90,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		ButtonGroup maritalButton = new ButtonGroup();
		maritalButton.add(married);
		maritalButton.add(unmarried);
		
		
		
		// Address
		JLabel address = new JLabel("Address :");
		address.setFont(new Font("Raleway", Font.BOLD, 20));
		address.setBounds(100,380,200,30);
		add(address);
		
		uaddress = new JTextField();
		uaddress.setBounds(260,380,400,30);
		uaddress.setFont(new Font("Raleway", Font.BOLD, 20));
		add(uaddress);
		
		// City
		JLabel city = new JLabel("City :");
		city.setFont(new Font("Raleway", Font.BOLD, 20));
		city.setBounds(100,420,200,30);
		add(city);
		
		ucity = new JTextField();
		ucity.setBounds(260,420,400,30);
		ucity.setFont(new Font("Raleway", Font.BOLD, 20));
		add(ucity);
		
		//State
		JLabel state = new JLabel("State :");
		state.setFont(new Font("Raleway", Font.BOLD, 20));
		state.setBounds(100,460,200,30);
		add(state);
		
		ustate = new JTextField();
		ustate.setBounds(260,460,400,30);
		ustate.setFont(new Font("Raleway", Font.BOLD, 20));
		add(ustate);
		
		// Pincode
		JLabel pincode = new JLabel("Pin Code :");
		pincode.setFont(new Font("Raleway", Font.BOLD, 20));
		pincode.setBounds(100,500,200,30);
		add(pincode);
		
		upincode = new JTextField();
		upincode.setBounds(260,500,400,30);
		upincode.setFont(new Font("Raleway", Font.BOLD, 20));
		add(upincode);
		
		// Create "next" button
		next = new JButton("Next");
		next.setBackground(Color.darkGray);
		next.setFont(new Font("Raleway", Font.BOLD,16));
		next.setForeground(Color.WHITE);
		next.setBounds(380, 570,90,40);
		next.addActionListener(this);
		add(next);
		
		
		
		getContentPane().setBackground(new Color(255,232,214));
		
		setSize(850, 700);
		setLocation(350,10);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 String formno ="" + random;	// long
		 String name = uname.getText();
		 String fname = ufname.getText();
		 String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		 String address = uaddress.getText();
		 String city = ucity.getText();
		 String state = ustate.getText();
		 String pin = upincode.getText();
		 String email = uemail.getText();
		 
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
		 
		 String marital = null;
		 if(married.isSelected()) {
			 marital = "Married";
		 }
		 else if(unmarried.isSelected()) {
			 marital = "Unmarried";
		 }
		 
		 
		 
		 try {
			 //Create validation if we not enter name and click on next button , so it shows an pop with "Name is Required"
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null, "Name is Required");
			}
			else {
				Conn c = new Conn();
				String query = "insert into newuser values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"',"
						+ "'"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new NewUser2(formno).setVisible(true);
				
			}
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		 
	}
	
	public static void main(String[] args) {
		new NewUser();
	}


	
}
