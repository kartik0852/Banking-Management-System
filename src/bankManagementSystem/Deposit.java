package bankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame implements ActionListener {

	JTextField amount;
	JButton deposit,back;
	String pinnumber;
	
	
	public Deposit(String pinnumber) {
		this.pinnumber=pinnumber;
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 730, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to deposit");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(156,220,290,20);
		image.add(text);
	
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD, 22));
		amount.setBounds(200,260,200,30);
		image.add(amount);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(335,321,125,26);
		deposit.addActionListener(this);
		image.add(deposit);
		
		back = new JButton("Back");
		back.setBounds(335,349,125,26);
		back.addActionListener(this);
		image.add(back);
		
		setSize(800,700);
		setLocation(250,0);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == deposit){
			String number = amount.getText();
			Date date = new Date();
			if (number.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
			}
			else {
				try {
					Conn c = new Conn();
					String query = "insert into bank values('"+pinnumber+"','"+date+"','Deposite','"+number+"')";
					c.s.executeUpdate(query);
					JOptionPane.showMessageDialog(null, "Rs "+number+" Deposited successfully");
					
					setVisible(false);
					new Transaction(pinnumber).setVisible(true);
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2);
				}
			}
					
			
		}
		else if(e.getSource()==back) {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);;
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new Deposit("");
	}

	
}
