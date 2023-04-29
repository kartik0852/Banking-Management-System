package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewUser2 extends JFrame implements ActionListener {

	JTextField upan, uadhar;
	JButton next;
	JRadioButton syes, sno,eyes,eno;
	JComboBox religionBox,categoryBox,incomeBox,educationBox,occupationBox;
	String formno;

	public NewUser2(String formno) {
		this.formno=formno;
		
		setLayout(null);
		
		setTitle("New User Account Application Form - Page: 2");
		
		JLabel additionalDetails = new JLabel("Page 1: Additional Details");
		additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails);
		
		// Religion
		JLabel religion = new JLabel("Religion :");
		religion.setFont(new Font("Raleway", Font.BOLD, 20));
		religion.setBounds(100,140,100,30);
		add(religion);
		
		String varreligion[] = {"Not Selected","Hindu","Sikh","Christian","Muslim","Others"}; 
		
		religionBox = new JComboBox(varreligion); 
		religionBox.setBounds(290,140,400,30);
		add(religionBox);
		
		// Category
		JLabel category = new JLabel("Category :");
		category.setFont(new Font("Raleway", Font.BOLD, 20));
		category.setBounds(100,180,200,30);
		add(category);
		
		String varCategory[] = {"Not Selected","General","Obc","Sc","St","Others"}; 
		
		categoryBox = new JComboBox(varCategory); 
		categoryBox.setBounds(290,180,400,30);
		add(categoryBox);
		
		// Income
		JLabel income = new JLabel("Income :");
		income.setFont(new Font("Raleway", Font.BOLD, 20));
		income.setBounds(100,220,200,30);
		add(income);
		
		String varincome[] = {"Not Selected","Null","< 1,99,999","< 5,00,000","Upto 10,00,000"}; 
		
		incomeBox = new JComboBox(varincome); 
		incomeBox.setBounds(290,220,400,30);
		add(incomeBox);
		

		// Qualification
		JLabel qualification = new JLabel("Qualification :");
		qualification.setFont(new Font("Raleway", Font.BOLD, 20));
		qualification.setBounds(100,260,200,30);
		add(qualification);
		
		String vareducation[] = {"Not Selected","Non-Graduate","Graduate","Post Graduate","Others"}; 
		
		educationBox = new JComboBox(vareducation); 
		educationBox.setBounds(290,260,400,30);
		add(educationBox);
		
		// Occupation
		JLabel occupation = new JLabel("Occupation :");
		occupation.setFont(new Font("Raleway", Font.BOLD, 20));
		occupation.setBounds(100,300,200,30);
		add(occupation);
		
		String varoccupation[] = {"Not Selected","Salaried","Self-Employed","Buisnessman","Student","Retire","Others"}; 
		
		occupationBox = new JComboBox(varoccupation); 
		occupationBox.setBounds(290,300,400,30);
		add(occupationBox);
		
		
		// Pan No
		JLabel pan = new JLabel("Pan No :");
		pan.setFont(new Font("Raleway", Font.BOLD, 20));
		pan.setBounds(100,340,200,30);
		add(pan);
		
		upan = new JTextField();
		upan.setBounds(290,340,400,30);
		upan.setFont(new Font("Raleway", Font.BOLD, 20));
		add(upan);
		
		// Adhar No
		JLabel adhar = new JLabel("Adhar No :");
		adhar.setFont(new Font("Raleway", Font.BOLD, 20));
		adhar.setBounds(100,380,200,30);
		add(adhar);
		
		uadhar = new JTextField();
		uadhar.setBounds(290,380,400,30);
		uadhar.setFont(new Font("Raleway", Font.BOLD, 20));
		add(uadhar);
		
		// Senior Citizen
		JLabel seniorCitizens = new JLabel("Senior Citizen :");
		seniorCitizens.setFont(new Font("Raleway", Font.BOLD, 20));
		seniorCitizens.setBounds(100,420,200,30);
		add(seniorCitizens);
		
		syes = new JRadioButton("Yes");
		syes.setBackground(Color.WHITE);
		syes.setBounds(290, 420, 60,30);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(360,420,80,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorButton = new ButtonGroup();
		seniorButton.add(syes);
		seniorButton.add(sno);
		
		// Exisiting Account
		JLabel exisiting = new JLabel("Exisiting Account :");
		exisiting.setFont(new Font("Raleway", Font.BOLD, 20));
		exisiting.setBounds(100,460,200,30);
		add(exisiting);
		
		eyes = new JRadioButton("Yes");
		eyes.setBackground(Color.WHITE);
		eyes.setBounds(290, 460, 60,30);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(360,460,80,30);
		eno.setBackground(Color.WHITE);
		add(eno);
		
		ButtonGroup accountButton = new ButtonGroup();
		accountButton.add(eyes);
		accountButton.add(eno);;
		
		// Create "next" button
		next = new JButton("Next");
		next.setBackground(Color.darkGray);
		next.setFont(new Font("Raleway", Font.BOLD,16));
		next.setForeground(Color.WHITE);
		next.setBounds(380, 560,90,40);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(new Color(255,232,214));
		
		setSize(850, 700);
		setBackground(Color.GRAY);
		setLocation(350,10);
		setUndecorated(true);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 String religion = (String) religionBox.getSelectedItem();
		 String category = (String) categoryBox.getSelectedItem();
		 String income   = (String) incomeBox.getSelectedItem();
		 String education = (String) educationBox.getSelectedItem();
		 String occupation = (String) occupationBox.getSelectedItem();
		 String panno = upan.getText();
		 String adhar = uadhar.getText();
		 String seniorcitizen = null;
		 if(syes.isSelected()) {
			 seniorcitizen = "Yes";
		 }
		 else if(sno.isSelected()) {
			 seniorcitizen = "No";
		 }

		 String existingaccount = null;
		 if(eyes.isSelected()) {
			 existingaccount = "Yes";
		 }
		 else if(eno.isSelected()) {
			 existingaccount = "No";
		 }

		 try {
			 Conn c = new Conn();
			 String query = "insert into newuser2 values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"',"
			 		+ "'"+occupation+"','"+panno+"','"+adhar+"','"+seniorcitizen+"','"+existingaccount+"')";
			 c.s.executeUpdate(query);
			 
			 setVisible(false);
			 new NewUser3(formno).setVisible(true);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
		 
	}
	
	public static void main(String[] args) {
		new NewUser2("");
	}


	
}
