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

		titlePanel.add(makeLabel("주차장 관리 프로그램 Ver1.0.0", 50));

		contentPanel.add(makeLabel("1번 입차 기능이 실행됐습니다.", 35));

		boxPanel.add(makeLabel("차량 종류 및 용량을 입력하세요.", 35));
		boxPanel.add(makeLabel("승용차(c), 트럭(t), 버스(b)", 35));

		inputPanel.add(boxPanel);
		inputPanel.add(makeTextField("ex) c 10", 5, 35));
		inputPanel.add(makeButton("입력", 35));

		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
	}

}
