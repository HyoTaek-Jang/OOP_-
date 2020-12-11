package ParkingLotProg_GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainFrame extends BasicFrame {

	private EntryFrame entryFrame = new EntryFrame();
	private ExitFrame exitFrame = new ExitFrame();
	private ShowPakingLotFrame showParkingLotFrame = new ShowPakingLotFrame();
	private JTextField inputField;

	public MainFrame() {
		super();
		setLayout(new GridLayout(3, 1));

		JPanel titlePanel = makePanel();
		JPanel contentPanel = makePanel();
		JPanel inputPanel = makePanel();

		JPanel boxPanel = new JPanel();
		JPanel boxPanel_2 = new JPanel();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		boxPanel_2.add(makeLabel("1.���� / 2.���� / 3.�����庸�� / 4.���Ժ��� / 5.���α׷� ����", 35));
		boxPanel_2.add(makeLabel("�ִ� 30����� ���� ������ �������Դϴ�.", 20));
		contentPanel.add(boxPanel_2);

		inputField = makeTextField("Ex) 1", 5, 35, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				moveFrame(input);
			}
		});
		boxPanel.add(makeLabel("���ϴ� �޴��� �Է��ϼ���.", 35));
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 35, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				moveFrame(input);
			}
		}));
		

		inputPanel.add(boxPanel);
		
		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
		
		setVisible(true);
		
		inputField.selectAll();
		

	}

	public void moveFrame(String input) {
		switch (input) {
		case "1":
			inputField.setText("Ex) 1");
			entryFrame.paintedMainPanel();
			entryFrame.setVisible(true);
			break;
		case "2":
			inputField.setText("Ex) 1");
			exitFrame.paintedCarNumPanel();
			exitFrame.setVisible(true);
			break;
		case "3":
			inputField.setText("Ex) 1");
			showParkingLotFrame.paintedParkingLotPanel();
			showParkingLotFrame.setVisible(true);
			break;
		}
	}

}
