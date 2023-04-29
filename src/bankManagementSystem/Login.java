package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
	//Define Jbutton globally
	JButton login, newuser, resetButton, exit;
	JTextField cardField;
	JPasswordField pinField;
	
	//Creating Constructor
	public Login() {
		
		setTitle("ATM");	// set the name of title
		
		setLayout(null);	// here we do null so we can set our icon in the frame where we want
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));	// take the icons using IMAGEICON class
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);		// resize the icon size
		ImageIcon i3 = new ImageIcon(i2); // here we again assign the image in the Imageicon constructor 
		JLabel label = new JLabel(i3);		//using this for set the icon
		label.setBounds(340, 10 , 100, 100);	// set the location of icon in the frame using setBound 
		add(label);	// add to display on the frame
		
		// Mainly use of Jlabel to write anything in the frame
		JLabel welcome = new JLabel("Welcome to ATM");
		welcome.setBounds(270, 110, 500, 40);	// set the text where we want to set
		welcome.setFont(new Font("Osward",Font.BOLD, 30 ));
		add(welcome);	// display the text
		
		
		
		// Using Jlable to print CARDNO 
		JLabel cardno = new JLabel("ATM CARD NO :");
		cardno.setBounds(110, 160, 500, 30);	// set the text where we want to set
		cardno.setFont(new Font("Raleway",Font.BOLD, 24 ));
		add(cardno);	// display the text
		
		// Creating a empty box where user enter Card no and pin
		cardField = new JTextField();
		cardField.setBounds(300,160,350, 30);
		cardField.setFont(new Font("Arial",Font.PLAIN, 16 ));
		add(cardField);
		
		// Using Jlable to print to PIN
		JLabel pin = new JLabel("ATM PIN :");
		pin.setBounds(180, 220, 500, 30);	// set the text where we want to set
		pin.setFont(new Font("Raleway",Font.BOLD, 24 ));
		add(pin);	// display the text
		
		// Creating a empty box using JTextField where user enter Card no and pin
		pinField = new JPasswordField();
		pinField.setBounds(300,220,350, 30);
		pinField.setFont(new Font("Arial",Font.PLAIN, 16 ));
		add(pinField);
		
		
		JLabel forgot = new JLabel("Forgot Password?");
		forgot.setBounds(300, 290, 500, 30);	// set the text where we want to set
		forgot.setFont(new Font("Raleway",Font.BOLD, 14 ));
		add(forgot);	// display the text
		
		
		// Creating button using Jbutton
		login = new JButton("Login");
		login.setBounds(300,260,100, 30);
		login.addActionListener(this);
		add(login);
		
		
		resetButton = new JButton("Reset");
		resetButton.setBounds(410,260,100, 30);
		resetButton.addActionListener(this);
		add(resetButton);
		
		
		// Creating button using Jbutton
		newuser = new JButton("New User");
		newuser.setBounds(520,260,100, 30);
		newuser.addActionListener(this);
		add(newuser);
		
		exit = new JButton("EXIT");
		exit.setBounds(330,400,105,30);
		exit.addActionListener(this);
		add(exit);
		
		getContentPane().setBackground(new Color(255,232,214));
		
		setSize(800, 480);	//set the size of the frame
		setLocation(10,10);	// set the location of frame, so it open on the screen where we want
		setUndecorated(true);
		setVisible(true);	//it display the frame , size of 800X400
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
				
		if (e.getSource() == resetButton) {
			cardField.setText("");
			pinField.setText("");
		}
		else if(e.getSource() == login) {
			
			Conn c = new Conn();
			String cardnumber = cardField.getText();
			String pinnumber = pinField.getText();
			String query = "select * from login where card_number = '"+cardnumber+"' and pin = '"+pinnumber+"'";
			
			try {
				ResultSet rs = c.s.executeQuery(query);
				if (rs.next()) {
					setVisible(false);
					
					new Transaction(pinnumber).setVisible(true);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin");
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
			
		}
		else if(e.getSource() == newuser) {
			
			setVisible(false);	// here we take setVisible(false), so if we click on newuser button , login frame close automatically
			
			new NewUser().setVisible(true);	// and here we create an object of NewUser , so it call the constructor of NewUser class
											// and setVisible(true), so after click on newuser in login page , so login page close and new user page is open
		}
		else if(e.getSource()==exit){
			System.exit(0);
		}

		
	}
	
	public static void main(String[] args) {
		new Login();
	}

	
	

}
