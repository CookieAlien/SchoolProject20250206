package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import service.impl.MemberServiceImpl;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField nameField;
	private JTextField addressField;
	private JTextField phoneField;
	private JTextField mobileField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 74, 416, 179);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setBounds(29, 43, 29, 18);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setBounds(29, 79, 29, 15);
		panel_1.add(lblNewLabel_1);
		
		usernameField = new JTextField();
		usernameField.setBounds(68, 42, 96, 21);
		panel_1.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(68, 76, 96, 21);
		panel_1.add(passwordField);
		passwordField.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("姓名");
		lblNewLabel_2.setBounds(219, 21, 29, 18);
		panel_1.add(lblNewLabel_2);
		
		nameField = new JTextField();
		nameField.setBounds(258, 20, 96, 21);
		panel_1.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("地址");
		lblNewLabel_2_1.setBounds(219, 49, 29, 18);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("電話");
		lblNewLabel_2_2.setBounds(219, 79, 29, 18);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("手機");
		lblNewLabel_2_3.setBounds(219, 107, 29, 18);
		panel_1.add(lblNewLabel_2_3);
		
		addressField = new JTextField();
		addressField.setColumns(10);
		addressField.setBounds(258, 51, 96, 21);
		panel_1.add(addressField);
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		phoneField.setBounds(258, 76, 96, 21);
		panel_1.add(phoneField);
		
		mobileField = new JTextField();
		mobileField.setColumns(10);
		mobileField.setBounds(258, 106, 96, 21);
		panel_1.add(mobileField);
		
		JButton addMemberButton = new JButton("註冊");
		addMemberButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				if(new MemberServiceImpl().isUsernameTaken(username)) {
					new AddMemberErrorUI().setVisible(true);
					dispose();
				}else {
					String password = passwordField.getText();
					String name = nameField.getText();
					String address = addressField.getText();
					String phone = phoneField.getText();
					String mobile = mobileField.getText();
					new MemberServiceImpl().addMember(new Member(name, username, password, address, phone, mobile));
					new AddMemberSuccessUI().setVisible(true);
					dispose();
				}
			}
		});
		addMemberButton.setBounds(151, 146, 85, 23);
		panel_1.add(addMemberButton);
		
	}

}
