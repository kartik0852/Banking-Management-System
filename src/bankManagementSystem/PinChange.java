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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class PinChange extends JFrame implements ActionListener {
	
	JPasswordField newpinText,repinText;
	JButton change, back;
	String pinnumber;
	
	public PinChange(String pinnumber) {
		this.pinnumber=pinnumber;
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(800, 780, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,800,700);
		add(image);
		
		
		
		JLabel text = new JLabel("Change Your Pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		text.setBounds(220,210,290,20);
		image.add(text);
		
		JLabel newpin = new JLabel("Enter New Pin");
		newpin.setForeground(Color.WHITE);
		newpin.setFont(new Font("System", Font.BOLD,16));
		newpin.setBounds(140,300,125,26);
		image.add(newpin);
		
		JLabel repin = new JLabel("Re-Enter New Pin");
		repin.setForeground(Color.WHITE);
		repin.setFont(new Font("System", Font.BOLD,16));
		repin.setBounds(140,330,155,26);
		image.add(repin);
		
		newpinText = new JPasswordField();
		newpinText.setBounds(300,300,150,26);
		newpinText.setFont(new Font("Raleway", Font.BOLD, 20));
		image.add(newpinText);
		
		repinText = new JPasswordField();
		repinText.setBounds(300,330,150,26);
		repinText.setFont(new Font("Raleway", Font.BOLD, 20));
		image.add(repinText);
		
		
		back= new JButton("Back");
		back.setBounds(132,385,100,30);
		back.addActionListener(this);
		image.add(back);
		
		change = new JButton("Change Pin");
		change.setBounds(350,385,100,30);
		change.addActionListener(this);
		image.add(change);
		
		setSize(800,700);
		setLocation(250,0);
//		setUndecorated(true);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == change) {
		
		try {
			String npin = newpinText.getText();
			String rpin = repinText.getText();
			
			if (!npin.equals(rpin)) {
				JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
				return;
			}
			
			else if (npin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter New Pin");
				return;
			}
			
			else if (rpin.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Re-Enter New Pin");
				return;
			}
			
			Conn c = new Conn();
			String query1 = "update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			String query2 = "update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			String query3 = "update newuser3 set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
			
			c.s.executeUpdate(query1);
			c.s.executeUpdate(query2);
			c.s.executeUpdate(query3);
			
			JOptionPane.showMessageDialog(null, "PIN Changed successfulyy");
			
			setVisible(false);
			new Transaction(rpin).setVisible(true);;
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
		}
	}
	
		else {
			setVisible(false);
			new Transaction(pinnumber).setVisible(true);
		}
		
	}

	
	
	public static void main(String[] args) {
		new PinChange("").setVisible(true);
	}

	
}
