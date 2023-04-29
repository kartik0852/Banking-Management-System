package bankManagementSystem;

import java.awt.Color;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame {

	public MiniStatement(String pinnumber) {
		setTitle("Set Title");
		
		setLayout(null);
		
		JLabel mini = new JLabel();
		add(mini);
		
		JLabel bank = new JLabel("State Bank of India");
		bank.setBounds(140,20,150,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,50,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			
			Conn c = new Conn();
			
			ResultSet rs = c.s.executeQuery("select * from login where pin = '"+pinnumber+"'");
			while(rs.next()) {
				card.setText("Card Number : "+rs.getString("card_number").substring(0,4)+"XXXXXXXX"+rs.getString("card_number").substring(12));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		try {
			
			Conn c = new Conn();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
			
			while(rs.next()) {
				mini.setText(mini.getText() +"<html>"+rs.getString("date")+ " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp "+ rs.getString("type")+ " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp "+rs.getString("amount")+"<br><br><html>");
				
				if (rs.getString("type").equals("Deposite")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}
				else {
					bal -= Integer.parseInt(rs.getString("amount"));
				}
				
				balance.setText("Your Current Account balance is Rs "+ bal);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		mini.setBounds(20,60,400,500);
		
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new MiniStatement("");
	}
}
