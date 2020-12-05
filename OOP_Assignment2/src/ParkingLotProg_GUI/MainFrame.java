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

		titlePanel.add(makeLabel("주차장 관리 프로그램 Ver1.0.0", 50));

		boxPanel_2.add(makeLabel("1.입차 / 2.출차 / 3.주차장보기 / 4.수입보기 / 5.프로그램 종료", 35));
		boxPanel_2.add(makeLabel("최대 30대까지 수용 가능한 주차장입니다.", 20));
		contentPanel.add(boxPanel_2);
		
		boxPanel.add(makeLabel("원하는 메뉴를 입력하세요.", 35));
		boxPanel.add(makeTextField("ex) 1", 5, 35));
		boxPanel.add(makeButton("입력", 35));
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
