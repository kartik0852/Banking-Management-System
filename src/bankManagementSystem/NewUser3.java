package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class NewUser3 extends JFrame implements ActionListener {
	
	JRadioButton savingAccount,fixedAccount,currentAccount,reccuringAccount;
	JCheckBox atmCard,netBanking,mobileBanking,emailSms,chequeBook,eStatement,confirm;
	JButton submit, cancel;
	String formno;
	
	
	public NewUser3(String formno) {
		this.formno=formno;
		
		JLabel accountDeatial = new JLabel("Page 3 : Account Details");
		accountDeatial.setFont(new Font("Raleway", Font.BOLD,22));
		accountDeatial.setBounds(300,40,400,40);
		add(accountDeatial);
		
		JLabel accountType = new JLabel("Account Type");
		accountType.setFont(new Font("Raleway", Font.BOLD,22));
		accountType.setBounds(100,100,200,30);
		add(accountType);
		
		savingAccount = new JRadioButton("Saving Account");
		savingAccount.setFont(new Font("Raleway", Font.PLAIN,15));
		savingAccount.setBackground(new Color(142,202,230));
		savingAccount.setBounds(100, 130, 150,25);
		add(savingAccount);
		
		fixedAccount = new JRadioButton("Fixed Deposit Account");
		fixedAccount.setFont(new Font("Raleway", Font.PLAIN,15));
		fixedAccount.setBackground(new Color(142,202,230));
		fixedAccount.setBounds(250, 130, 220,25);
		add(fixedAccount);
		
		currentAccount = new JRadioButton("Current Account");
		currentAccount.setFont(new Font("Raleway", Font.PLAIN,15));
		currentAccount.setBackground(new Color(142,202,230));
		currentAccount.setBounds(100, 160, 150,25);
		add(currentAccount);
		
		reccuringAccount = new JRadioButton("Recurring Deposit Account");
		reccuringAccount.setFont(new Font("Raleway", Font.PLAIN,15));
		reccuringAccount.setBackground(new Color(142,202,230));
		reccuringAccount.setBounds(250, 160, 220,25);
		add(reccuringAccount);
		
		ButtonGroup accountButton = new ButtonGroup();
		accountButton.add(savingAccount);
		accountButton.add(currentAccount);
		accountButton.add(fixedAccount);
		accountButton.add(reccuringAccount);

		
		JLabel cardNo = new JLabel("Card Number ");
		cardNo.setFont(new Font("Raleway", Font.BOLD,22));
		cardNo.setBounds(100,200,200,20);
		add(cardNo);
		
		JLabel number = new JLabel("XXXX-XXXX-XXXX-1234");
		number.setFont(new Font("Raleway", Font.PLAIN,22));
		number.setBounds(290,210,300,20);
		add(number);
		
		JLabel cardDetails = new JLabel("Your 16 Digit Card Number");
		cardDetails.setFont(new Font("Raleway", Font.PLAIN,12));
		cardDetails.setBounds(100,220,300,20);
		add(cardDetails);
		
		JLabel pin = new JLabel("PIN ");
		pin.setFont(new Font("Raleway", Font.BOLD,22));
		pin.setBounds(100,270,60,20);
		add(pin);
		
		JLabel pinnumber = new JLabel("XXXX");
		pinnumber.setFont(new Font("Raleway", Font.PLAIN,22));
		pinnumber.setBounds(290,280,80,20);
		add(pinnumber);
		
		JLabel pindetails = new JLabel("Your 4 Digit Password");
		pindetails.setFont(new Font("Raleway", Font.PLAIN,12));
		pindetails.setBounds(100,290,150,20);
		add(pindetails);
		
		JLabel service= new JLabel("Service Required : ");
		service.setFont(new Font("Raleway", Font.BOLD,22));
		service.setBounds(100,330,200,20);
		add(service);
		
		atmCard = new JCheckBox("ATM Card");
		atmCard.setFont(new Font("Raleway", Font.BOLD,16));
		atmCard.setBackground(new Color(142,202,230));
		atmCard.setBounds(100,360,100,20);
		add(atmCard);
		
		netBanking = new JCheckBox("Net Banking");
		netBanking.setFont(new Font("Raleway", Font.BOLD,16));
		netBanking.setBackground(new Color(142,202,230));
		netBanking.setBounds(270,360,130,20);
		add(netBanking);
		
		mobileBanking = new JCheckBox("Mobile Banking");
		mobileBanking.setFont(new Font("Raleway", Font.BOLD,16));
		mobileBanking.setBackground(new Color(142,202,230));
		mobileBanking.setBounds(415,360,150,20);
		add(mobileBanking);
		
		emailSms = new JCheckBox("Email & Sms Alert");
		emailSms.setFont(new Font("Raleway", Font.BOLD,16));
		emailSms.setBackground(new Color(142,202,230));
		emailSms.setBounds(100,390,170,20);
		add(emailSms);
		
		chequeBook = new JCheckBox("Cheque Book");
		chequeBook.setFont(new Font("Raleway", Font.BOLD,16));
		chequeBook.setBackground(new Color(142,202,230));
		chequeBook.setBounds(270,390,130,20);
		add(chequeBook);
		
		eStatement = new JCheckBox("E-Statement");
		eStatement.setFont(new Font("Raleway", Font.BOLD,16));
		eStatement.setBackground(new Color(142,202,230));
		eStatement.setBounds(415,390,150,20);
		add(eStatement);
		
		confirm = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
		confirm.setFont(new Font("Raleway", Font.PLAIN,13));
		confirm.setBackground(new Color(142,202,230));
		confirm.setBounds(100,430,550,20);
		add(confirm);
		
		submit = new JButton("Submit");
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.setFont(new Font("Raleway", Font.BOLD, 14));
		submit.setBounds(220,520,100,40);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.setFont(new Font("Raleway", Font.BOLD, 14));
		cancel.setBounds(500,520,100,40);
		cancel.addActionListener(this);
		add(cancel);
		
		setLayout(null);
		getContentPane().setBackground(new Color(255,232,214));
		
		setSize(850, 700);
		setBackground(Color.GRAY);
		setLocation(300,10);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==submit) {
			String accountType = null;
			if(savingAccount.isSelected()) {
				accountType = "Saving Account";
			}
			else if (currentAccount.isSelected()) {
				accountType = "Current Account";
			}
			else if (fixedAccount.isSelected()) {
				accountType = "Fixed Deposit Account";
			}
			else if (reccuringAccount.isSelected()) {
				accountType = "Recurring Deposit Account";
			}
			
			
			Random ran = new Random();
			String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L)+5040936000000000L);
			String pinnumber = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
			
			String facility = "";
			if(atmCard.isSelected()) {
				facility = facility + " Atm Card";
			}
			else if (netBanking.isSelected()) {
				facility = facility + " Internet Banking";
			}
			else if (mobileBanking.isSelected()) {
				facility = facility + " Mobile Banking";
			}
			else if (emailSms.isSelected()) {
				facility = facility + " Email & Sms Alert";
			}
			else if (chequeBook.isSelected()) {
				facility = facility + " Cheque Book";
			}
			else if (eStatement.isSelected()) {
				facility = facility + " E-Statement";
			}
			
			try {
				if(accountType.equals("")) {
					JOptionPane .showMessageDialog(null, "Account Type is Required");
				}
				else {
					Conn c = new Conn();
					String query = "insert into newuser3 values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
					String query2 = "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
					c.s.executeUpdate(query);
					c.s.executeUpdate(query2);
					
					JOptionPane.showMessageDialog(null, "Card Number : "+ cardnumber+" \n Pin : "+pinnumber);
					System.out.println("Card Number : "+cardnumber+"\nPin Number : "+pinnumber);
				}
				
				
				setVisible(false);
				
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
			new Login().setVisible(true);
		}
		else if (e.getSource()==cancel) {
			setVisible(false);
			new Login().setVisible(true);
			
		}
		
		
	}
	
	public static void main(String[] args) {
		new NewUser3("");
	}

	

}
