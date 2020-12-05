package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MainFrame extends BasicFrame {
	public MainFrame() {
		super();

		JPanel titlePanel = makePanel();
		JPanel contentPanel = makePanel();
		JPanel inputPanel = makePanel();
		
		JPanel boxPanel = new JPanel();
		JPanel boxPanel_2 = new JPanel();

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		boxPanel_2.add(makeLabel("1.���� / 2.���� / 3.�����庸�� / 4.���Ժ��� / 5.���α׷� ����", 35));
		boxPanel_2.add(makeLabel("�ִ� 30����� ���� ������ �������Դϴ�.", 20));
		contentPanel.add(boxPanel_2);
		
		boxPanel.add(makeLabel("���ϴ� �޴��� �Է��ϼ���.", 35));
		boxPanel.add(makeTextField("ex) 1", 5, 35));
		boxPanel.add(makeButton("�Է�", 35));
		inputPanel.add(boxPanel);

		inputPanel.setBackground(Color.CYAN);
		boxPanel.setBackground(Color.DARK_GRAY);
		contentPanel.setBackground(Color.BLUE);
		titlePanel.setBackground(Color.BLACK);

		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
	}
	
}
