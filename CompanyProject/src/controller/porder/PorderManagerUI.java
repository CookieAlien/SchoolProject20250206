package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.impl.PorderServiceImpl;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PorderManagerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updateIDField;
	private JTextField lcdField;
	private JTextField ramField;
	private JTextField mouseField;
	private JTextField deleteIDField;
	private static PorderServiceImpl porderServiceImpl = new PorderServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PorderManagerUI frame = new PorderManagerUI();
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
	public PorderManagerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 57, 466, 200);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 446, 150);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		JButton readButton = new JButton("查詢所有訂單");
		readButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(porderServiceImpl.allPorder());
			}
		});
		readButton.setBounds(10, 10, 122, 23);
		panel.add(readButton);
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 267, 466, 150);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("修改訂單");
		lblNewLabel.setBounds(194, 10, 59, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1.setBounds(131, 37, 46, 15);
		panel_1.add(lblNewLabel_1);
		
		updateIDField = new JTextField();
		updateIDField.setBounds(187, 35, 96, 21);
		panel_1.add(updateIDField);
		updateIDField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("LCD:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1.setBounds(10, 71, 46, 15);
		panel_1.add(lblNewLabel_1_1);
		
		lcdField = new JTextField();
		lcdField.setColumns(10);
		lcdField.setBounds(60, 68, 96, 21);
		panel_1.add(lcdField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("RAM:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1.setBounds(154, 71, 36, 15);
		panel_1.add(lblNewLabel_1_1_1);
		
		ramField = new JTextField();
		ramField.setColumns(10);
		ramField.setBounds(194, 68, 96, 21);
		panel_1.add(ramField);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("滑鼠:");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_1_1_1.setBounds(288, 71, 36, 15);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		mouseField = new JTextField();
		mouseField.setColumns(10);
		mouseField.setBounds(331, 68, 96, 21);
		panel_1.add(mouseField);
		
		JButton updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(updateIDField.getText());
				int lcd = Integer.parseInt(lcdField.getText());
				int ram = Integer.parseInt(ramField.getText());
				int mouse = Integer.parseInt(mouseField.getText());
				porderServiceImpl.updatePorder(lcd, ram, mouse, id);
			}
		});
		updateButton.setBounds(180, 117, 85, 23);
		panel_1.add(updateButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(10, 10, 466, 37);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("回主頁");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PorderMainUI().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(353, 10, 85, 23);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("管理訂單");
		lblNewLabel_2.setBounds(200, 14, 46, 15);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(10, 427, 466, 76);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1_2 = new JLabel("id:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel_1_2.setBounds(104, 28, 46, 15);
		panel_3.add(lblNewLabel_1_2);
		
		deleteIDField = new JTextField();
		deleteIDField.setColumns(10);
		deleteIDField.setBounds(157, 25, 96, 21);
		panel_3.add(deleteIDField);
		
		JButton deleteButton = new JButton("刪除");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(deleteIDField.getText());
				porderServiceImpl.deletePorder(id);
			}
		});
		deleteButton.setBounds(29, 24, 85, 23);
		panel_3.add(deleteButton);
	}
}
