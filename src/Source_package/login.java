package Source_package;

import java.awt.*;

import javax.swing.*;

import org.w3c.dom.DOMImplementationSource;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import java.sql.*;
import java.time.format.ResolverStyle;
import java.awt.event.*;

public class login extends JFrame implements ActionListener,  ItemListener{
	JFrame f;
	JLabel l1, l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1, b2, b3;
	JComboBox jcb;
	int ADMIN=1;
	public login() {
		f = new JFrame("Login");
		f.setBackground(Color.gray);
		f.setLayout(null);
		
		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 30);
		f.add(l1);
		
		l2 = new JLabel("Password");
		l2.setBounds(40, 70, 100, 30);
		f.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		f.add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150, 70, 150, 30);
		f.add(t2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logint.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l3 = new JLabel(i3);
		l3.setBounds(350, 20, 150, 150);
		f.add(l3);
		
		b1 = new JButton("Login");
		b1.setBounds(40, 155, 120, 30);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		f.add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(180, 155, 120, 30);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		f.add(b2);
		
		b3 = new JButton("Register");
		b3.setBounds(40, 210, 120, 30);
		b3.setFont(new Font("serif",Font.BOLD,15));
		b3.addActionListener(this);
		b3.setBackground(Color.orange);
		b3.setForeground(Color.black);
		f.add(b3);
		
		jcb = new JComboBox();
		jcb.addItem("Admin");
		jcb.addItem("Client");
		jcb.setBounds(40,110,100,30);
		f.add(jcb);
		jcb.addItemListener(this);
		f.getContentPane().setBackground(Color.white);
		
		f.setVisible(true);
		f.setSize(600,300);
		f.setLocation(400, 300);
		
		

	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{try {
			Conn c1 = new Conn();
			Conn c2 = new Conn();
			String u = t1.getText();
			String v = t2.getText();
		
			String q = "SELECT * FROM login WHERE username= '"+u+"' and password= '"+v+"'";
						
			ResultSet rs = c1.s.executeQuery(q);
			String check = "SELECT *FROM register WHERE username = '"+u+"' and pass = '"+v+"' ";
			ResultSet rst = c2.s.executeQuery(check);
			if(rs.next() && ADMIN==1)
			{
				//JOptionPane.showMessageDialog(null, "Admin selected");
				new details();///.f.setVisiable(true);
				f.setVisible(false);
			}
			else if (rst.next() && ADMIN==0){
				
				//JOptionPane.showMessageDialog(null, "Client selected");
					new detailsClient();
					f.setVisible(false);
				
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Login");
				f.setVisible(true);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		else if(ae.getSource()==b2)
		{
			f.setVisible(false);
			///Front_Page f =  new Front_Page();
		}
		else if(ae.getSource()==b3)
		{
			f.setVisible(false);
			new Register();
			
		}
		
	}
@Override
	public void itemStateChanged(ItemEvent arg0)
	{
	
		if(jcb.getSelectedIndex()==0)
		{
			//JOptionPane.showMessageDialog(null, "Admin 0 selected");
			ADMIN = 1;
		}
		else if(jcb.getSelectedIndex()==1)
		{
			//JOptionPane.showMessageDialog(null, "Client 1 selected");
			ADMIN = 0;
		}
	}
	public static void main(String[] args) {
		login l = new login();

	}

}
