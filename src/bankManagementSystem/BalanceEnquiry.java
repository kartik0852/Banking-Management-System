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

public class BalanceEnquiry extends JFrame implements ActionListener {

	JButton back;
	String pinnumber; 
	
	public BalanceEnquiry(String pinnumber) {
		
		this.pinnumber = pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 800, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		back = new JButton("Back");
		back.setBounds(350,388,100,30);
		back.addActionListener(this);
		image.add(back);
		
		
		Conn c = new Conn();
		int balance = 0;
		
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			
			while(rs.next()) {
				if (rs.getString("type").equals("Deposite")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}
				else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
			}
			catch (Exception e2) {
				System.out.println(e2);
			}
		
		JLabel text = new JLabel("Your Current amount balance is");
		text.setForeground(Color.white);
		text.setFont(new Font("Raleway",Font.BOLD, 16 ));
		text.setBounds(150,200,300,30);
		image.add(text);
		
		JLabel text2 = new JLabel("Rs = "+balance);
		text2.setForeground(Color.white);
		text2.setFont(new Font("Raleway",Font.BOLD, 16 ));
		text2.setBounds(200,250,300,30);
		image.add(text2);
		
		
		setSize(800,700);
		setLocation(250,0);
//		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		setVisible(false);
		new Transaction(pinnumber).setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}

	
}
