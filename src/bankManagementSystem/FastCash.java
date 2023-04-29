package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FastCash extends JFrame implements ActionListener {

	JButton hundred,fivehundred ,onethounsand,twothousand,fivethousand,tenthounsand,exit;
	String pinnumber;
	
	public FastCash(String pinnumber) {
		
		this.pinnumber=pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		JLabel text = new JLabel("Select withraw amount");
		text.setBounds(215,250,700,35);
		text.setForeground(Color.white);
		text.setFont(new Font("System",Font.BOLD,16));
		image.add(text);
		
		hundred = new JButton("Rs 100");
		hundred.setBounds(140,321,125,26);
		hundred.addActionListener(this);
		image.add(hundred);
		
		fivehundred = new JButton("Rs 500");
		fivehundred.setBounds(140,349,125,26);
		fivehundred.addActionListener(this);
		image.add(fivehundred);
		
		onethounsand = new JButton("Rs 1000");
		onethounsand.setBounds(140,377,125,26);
		onethounsand.addActionListener(this);
		image.add(onethounsand);
		
		twothousand = new JButton("Rs 2000");
		twothousand.setBounds(140,405,125,26);
		twothousand.addActionListener(this);
		image.add(twothousand);
		
		fivethousand = new JButton("Rs 5000");
		fivethousand.setBounds(335,321,125,26);
		fivethousand.addActionListener(this);
		image.add(fivethousand);
		
		tenthounsand = new JButton("Rs 10000");
		tenthounsand.setBounds(335,349,125,26);
		tenthounsand.addActionListener(this);
		image.add(tenthounsand);
		
		exit= new JButton("Back");
		exit.setBounds(335,377,125,26);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(800,700);
		setLocation(250,0);
		setUndecorated(true);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == exit) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		else {
			
			String amount = ((JButton) e.getSource()).getText().substring(3); //Rs 500
			Conn c = new Conn();
			
			try {
				ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
				int balance = 0;
				
				while(rs.next()) {
					if (rs.getString("type").equals("Deposite")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}
					else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				
				if (e.getSource() != exit && balance < Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null, "Insufucient Balance");
					return;
				}
				
				
				Date date = new Date();
				String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
				c.s.executeUpdate(query);
				JOptionPane.showMessageDialog(null, "Rs "+ amount+" Debited Successfully");
				
				setVisible(false);
				new Transaction(pinnumber).setVisible(true);
				
			} catch (Exception e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
		}
	}
	
	public static void main(String[] args) {
		new FastCash("");
	}

	
}
