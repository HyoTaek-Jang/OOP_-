package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class BasicFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 1280;
	private static final int DEFAULT_HEIGHT = 720;
	private JLabel textLabel;
	private JTextField textField;
	private JButton button;
	private JPanel panel;
	
	public BasicFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLayout(new GridLayout(3, 1));
	}

	public JLabel makeLabel(String text, int fontSize) {

		textLabel = new JLabel(text, JLabel.CENTER);
		textLabel.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, fontSize));

		return textLabel;
	}
	
	public JTextField makeTextField(String text, int columnSize, int fontSize) {
		textField = new JTextField(text, columnSize);
		textField.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, fontSize));
		
		return textField;
	}
	
	
	public JButton makeButton(String text, int fontSize) {
		button = new JButton(text);
		button.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, fontSize));
		return button;
	}
	
	public JPanel makePanel() {
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		return panel;
	}

}
