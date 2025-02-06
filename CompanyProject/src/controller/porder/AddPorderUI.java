package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Member;
import model.Porder;
import service.impl.PorderServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField lcdField;
	private JTextField ramField;
	private JTextField mouseField;
	private static Member member = (Member)Tool.read("member.txt");
	private static PorderServiceImpl porderServiceImpl = new PorderServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LCD:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setBounds(92, 100, 46, 15);
		contentPane.add(lblNewLabel);
		
		lcdField = new JTextField();
		lcdField.setBounds(148, 97, 96, 21);
		contentPane.add(lcdField);
		lcdField.setColumns(10);
		
		JLabel lblRam = new JLabel("RAM:");
		lblRam.setHorizontalAlignment(SwingConstants.TRAILING);
		lblRam.setBounds(92, 142, 46, 15);
		contentPane.add(lblRam);
		
		JLabel lblNewLabel_2 = new JLabel("滑鼠:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_2.setBounds(92, 179, 46, 15);
		contentPane.add(lblNewLabel_2);
		
		ramField = new JTextField();
		ramField.setColumns(10);
		ramField.setBounds(148, 139, 96, 21);
		contentPane.add(ramField);
		
		mouseField = new JTextField();
		mouseField.setColumns(10);
		mouseField.setBounds(148, 176, 96, 21);
		contentPane.add(mouseField);
		
		JLabel nameLabel = new JLabel("客戶");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(148, 68, 96, 15);
		contentPane.add(nameLabel);
		nameLabel.setText("客戶: "+member.getName());
		
		JButton addButton = new JButton("新增");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = member.getName();
				int lcd = Integer.parseInt(lcdField.getText());
				int ram = Integer.parseInt(ramField.getText());
				int mouse = Integer.parseInt(mouseField.getText());
				Porder porder = new Porder(name, lcd, ram, mouse);
				porderServiceImpl.addPorder(porder);
			}
		});
		addButton.setBounds(148, 230, 85, 23);
		contentPane.add(addButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 416, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("新增訂單");
		lblNewLabel_1.setBounds(154, 14, 73, 15);
		panel.add(lblNewLabel_1);
		
		JButton returnButton = new JButton("回主頁");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PorderMainUI().setVisible(true);
				dispose();
			}
		});
		returnButton.setBounds(299, 10, 85, 23);
		panel.add(returnButton);
	}
}
