package contactbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class getcontact extends JFrame {

	private JPanel contentPane;
	private JTextField fname;
	private JTextField lname;
	private JTextField phno;
	private JTextField address;
	private JTextField email;
	private JTextField nick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					savecontact frame = new savecontact();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public getcontact() {
		setTitle("Contact book - Get Contact");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Get contact information");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 10, 414, 65);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1_0 = new JLabel("First name: ");
		lblNewLabel_1_0.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_0.setBounds(10, 144, 92, 14);
		contentPane.add(lblNewLabel_1_0);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name: ");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 183, 92, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Phone number: ");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_2.setBounds(10, 227, 92, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Address: ");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_3.setBounds(10, 263, 92, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Email: ");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_4.setBounds(10, 303, 92, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Enter Nickname / Firstname of the contact");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setBounds(65, 70, 281, 20);
		contentPane.add(lblNewLabel_1_5);
		
		fname = new JTextField();
		fname.setEditable(false);
		fname.setBounds(112, 141, 204, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		
		lname = new JTextField();
		lname.setEditable(false);
		lname.setColumns(10);
		lname.setBounds(112, 180, 204, 20);
		contentPane.add(lname);
		
		phno = new JTextField();
		phno.setEditable(false);
		phno.setColumns(10);
		phno.setBounds(112, 221, 204, 20);
		contentPane.add(phno);
		
		address = new JTextField();
		address.setEditable(false);
		address.setColumns(10);
		address.setBounds(112, 260, 204, 20);
		contentPane.add(address);
		
		email = new JTextField();
		email.setEditable(false);
		email.setColumns(10);
		email.setBounds(112, 300, 204, 20);
		contentPane.add(email);
		
		nick = new JTextField();
		nick.setColumns(10);
		nick.setBounds(112, 101, 204, 20);
		contentPane.add(nick);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new choosepage().setVisible(true);
			dispose();			}
		});
		btnBack.setBounds(36, 343, 120, 23);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("Get Contact");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/contactbook","root", "");	
				Statement st = conn.createStatement();
				String sql = "select * from contacts";
				ResultSet rs = st.executeQuery(sql);
				int error=0;
				while(rs.next()) {
					String firstnamee=rs.getString("firstname");
					String lastnamee=rs.getString("lastname");
					String ph=rs.getString("phonenumber");
					String addresss=rs.getString("address");
					String emaill=rs.getString("email");
					String nickk=rs.getString("nickname");
					
					if(nickk.equals(nick.getText())||firstnamee.equals(nick.getText())) {
						fname.setText(firstnamee);
						lname.setText(lastnamee);
						phno.setText(ph);
						email.setText(emaill);
						address.setText(addresss);
						error=0;
						break;
					}
					else {
						error=1;
					}
				}
				if(error==1) {
					JOptionPane.showMessageDialog(null, "Contact not found!");
				}

			}
			catch(Exception ex) {
				JOptionPane.showConfirmDialog(null, ex);
			}
			}
		});
		btnNewButton.setBounds(236, 343, 126, 23);
		contentPane.add(btnNewButton);
	}

}
