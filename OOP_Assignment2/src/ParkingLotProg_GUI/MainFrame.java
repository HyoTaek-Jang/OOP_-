package ParkingLotProg_GUI;

import javax.swing.JPanel;

public class MainFrame extends BasicFrame {
	public MainFrame() {
		super();

		JPanel titlePanel = new JPanel();
		JPanel contentPanel = new JPanel();
		JPanel inputPanel = new JPanel();

		titlePanel.add(makeLabel("주차장 관리 프로그램 Ver1.0.0", 50));

		contentPanel.add(makeLabel("1.입차 / 2.출차 / 3.주차장보기 / 4.수입보기 / 5.프로그램 종료", 35));
		contentPanel.add(makeLabel("최대 30대까지 수용 가능한 주차장입니다.", 20));

		inputPanel.add(makeLabel("원하는 메뉴를 입력하세요.", 35));
		inputPanel.add(makeTextField("ex) 1", 5, 35));
		inputPanel.add(makeButton("입력", 35));

		add(titlePanel);
		add(contentPanel);
		add(inputPanel);
	}
}
