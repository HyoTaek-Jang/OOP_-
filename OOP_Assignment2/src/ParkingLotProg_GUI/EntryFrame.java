package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class EntryFrame extends BasicFrame {

	public EntryFrame() {
		super();

		JPanel titlePanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel inputPanel = new JPanel();
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new BorderLayout());
		boxPanel.setBackground(Color.BLUE);
		boxPanel.setSize(1500, 500);
		titlePanel.setBackground(Color.BLACK);
		contentPanel.setBackground(Color.RED);
		inputPanel.setBackground(Color.CYAN);

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("1�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("���� ���� �� �뷮�� �Է��ϼ���.", 35));
		boxPanel.add(makeLabel("�¿���(c), Ʈ��(t), ����(b)", 35));

		inputPanel.add(boxPanel);
		inputPanel.add(makeTextField("ex) c 10", 5, 35));
		inputPanel.add(makeButton("�Է�", 35));

		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
	}

}
