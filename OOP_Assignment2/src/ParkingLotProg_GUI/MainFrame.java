package ParkingLotProg_GUI;

import javax.swing.JPanel;

public class MainFrame extends BasicFrame {
	public MainFrame() {
		super();

		JPanel titlePanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel inputPanel = new JPanel();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("1.���� / 2.���� / 3.�����庸�� / 4.���Ժ��� / 5.���α׷� ����", 35));
		contentPanel.add(makeLabel("�ִ� 30����� ���� ������ �������Դϴ�.", 20));

		inputPanel.add(makeLabel("���ϴ� �޴��� �Է��ϼ���.", 35));
		inputPanel.add(makeTextField("ex) 1", 5, 35));
		inputPanel.add(makeButton("�Է�", 35));

		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
	}
}
