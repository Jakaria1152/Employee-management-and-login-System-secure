package Source_package;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.security.PublicKey;

public class detailsClient implements ActionListener {
	JFrame f;
	JLabel l1,l2;
	JButton b1,b2,b3,b4;
	
	public detailsClient() {
		f = new JFrame("Employee Details");
		f.setBackground(Color.white);
		f.setLayout(null);
		
		l1 = new JLabel();
		l1.setBounds(0, 0, 700, 500);
		l1.setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/details.jpg"));
		l1.setIcon(i1);
		f.add(l1);
		
		l2 = new JLabel("Employee Details");
		l2.setBounds(430, 20, 200, 40);
		l2.setFont(new Font("serif",Font.BOLD,25));
		l2.setForeground(Color.black);
		f.add(l2);
		
		b1 = new JButton("View");
		b1.setBounds(420,80,100,40);
		b1.setFont(new Font("serif",Font.BOLD,15));
		b1.addActionListener(this);
		l1.add(b1);
		
		
		b2 = new JButton("Update");
		b2.setBounds(530, 80, 100, 40);
		b2.setFont(new Font("serif",Font.BOLD,15));
		b2.addActionListener(this);
		l1.add(b2);
		
		
		
		f.setVisible(true);
		f.setSize(700,500);
		f.setLocation(450, 200);
	}
		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource() == b1)
			{
				f.setVisible(false);
				new View_EmployeeClient();
			}
			if(ae.getSource()==b2)
			{
				f.setVisible(false);
				new Search_EmployeeClient();
			}
			
		}
	

	public static void main(String[] args) {
		detailsClient d = new detailsClient();

	}

}
