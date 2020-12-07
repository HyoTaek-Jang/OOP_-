package ParkingLotProg_GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryFrame extends BasicFrame {

	private JPanel entryMainPanel = makeBasicPanel();


	JPanel titlePanel = makePanel();
	JPanel contentPanel = makePanel();
	JPanel inputPanel = makePanel();
	
	public EntryFrame()
	{
		super();
		paintedMainPanel();
	}
	
	public void paintedMainPanel() {
		entryMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		inputPanel.removeAll();
		
		JPanel boxPanel = new JPanel();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("1�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("���� ���� �� �뷮�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("�¿���(c), Ʈ��(t), ����(b)", 25));

		JTextField inputField = makeTextField("ex) c 10", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				paintedCarNumPanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedCarNumPanel(input);
			}
		}));

		inputPanel.add(boxPanel);
		entryMainPanel.add(titlePanel);
		entryMainPanel.add(contentPanel);
		entryMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}
	
	public void paintedCarNumPanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		
		contentPanel.add(makeLabel("�Է��Ͻ� ���� "+input+"�Դϴ�.", 35));
		
		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� ��ȣ�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(4�ڸ� ����)", 25));
		
		JTextField inputField = makeTextField("ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				paintedTimePanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedTimePanel(input);
			}
		}));

		inputPanel.add(boxPanel);
		entryMainPanel.add(inputPanel);
		
		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}

	
	public void paintedTimePanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		
		contentPanel.add(makeLabel("�Է��Ͻ� ���� "+input+"�Դϴ�.", 35));
		
		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� �ð��� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(�� �� �� �� ��)", 25));
		
		JTextField inputField = makeTextField("ex) 2020 12 18 10 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				paintedCheckPanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedCheckPanel(input);
			}
		}));

		inputPanel.add(boxPanel);
		entryMainPanel.add(inputPanel);
		
		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}

	
	public void paintedCheckPanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		
		inputPanel.setLayout(new FlowLayout());
		
		contentPanel.add(makeLabel("������ ������ "+input+"�Դϴ�.", 35));
		
		inputPanel.add(makeLabel("������ �Ϸ�Ǿ����ϴ�.", 25));
		
		inputPanel.add(makeButton("�ʱ�ȭ��", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		}));

		entryMainPanel.add(inputPanel);
		
		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}


}
