package contactbook;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class choosepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choosepage frame = new choosepage();
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
	public choosepage() {
		setTitle("Contact Book - Select Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 418, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton getcontact = new JButton("Get Contact");
		getcontact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			new getcontact().setVisible(true);
			dispose();
			}
		});
		getcontact.setBounds(10, 44, 164, 81);
		contentPane.add(getcontact);
		
		JButton savecontact = new JButton("Save Contact");
		savecontact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new savecontact().setVisible(true);
				dispose();
			}
		});
		savecontact.setBounds(228, 44, 164, 81);
		contentPane.add(savecontact);
	}

}
