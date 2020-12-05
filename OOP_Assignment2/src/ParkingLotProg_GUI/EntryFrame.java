package ParkingLotProg_GUI;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryFrame extends BasicFrame {

	private JPanel entryMainPanel = makeBasicPanel();
	private JPanel entryCarNumPanel = makeBasicPanel();
	private JPanel entryTimePanel = makeBasicPanel();
	private JPanel entryCheckPanel = makeBasicPanel();
	private JPanel basicPanel = makeBasicPanel();

	public EntryFrame()
	{
		super();

		JPanel titlePanel = makePanel();
		JPanel contentPanel = makePanel();
		JPanel inputPanel = makePanel();
		JPanel boxPanel = new JPanel();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("1�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("���� ���� �� �뷮�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("�¿���(c), Ʈ��(t), ����(b)", 25));

		JTextField inputField = makeTextField("ex) 1", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
			}
		}));

		inputPanel.add(boxPanel);
		basicPanel.add(titlePanel);
		basicPanel.add(contentPanel);
		basicPanel.add(inputPanel);

		getContentPane().add(basicPanel);
		revalidate();
		repaint();
	}

}
