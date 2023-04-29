package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener {

	JButton deposit,withdrawl,fastcash,ministatement,pinchange,balanceenquiry,exit;
	String pinnumber;
	
	public Transaction(String pinnumber) {
		
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		JLabel text = new JLabel("Please select your Transaction");
		text.setBounds(180,250,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(140,321,125,26);
		deposit.addActionListener(this);
		image.add(deposit);
		
		fastcash = new JButton("Fast Cash");
		fastcash.setBounds(140,349,125,26);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		withdrawl = new JButton("Cash Withdraw");
		withdrawl.setBounds(140,377,125,26);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		ministatement = new JButton("Mini Statement");
		ministatement.setBounds(140,405,125,26);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		pinchange = new JButton("Pin Change");
		pinchange.setBounds(335,321,125,26);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balanceenquiry = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(335,349,125,26);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit= new JButton("Exit");
		exit.setBounds(335,377,125,26);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(800,700);
		setLocation(250,0);
//		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			setVisible(false);
			new Login().setVisible(true);
		}
		
		else if (e.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == withdrawl) {
			setVisible(false);
			new Withdraw(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == pinchange) {
			setVisible(false);
			new PinChange(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == balanceenquiry) {
			setVisible(false);
			new BalanceEnquiry(pinnumber).setVisible(true);
		}
		
		else if (e.getSource() == ministatement) {
			new MiniStatement (pinnumber).setVisible(true);
		}
		
		
	}
	
	public static void main(String[] args) {
		new Transaction("");
	}

	
}
