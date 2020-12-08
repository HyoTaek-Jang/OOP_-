package ParkingLotProg_GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ParkingProgram.Car;
import ParkingProgram.Test;


public class EntryFrame extends BasicFrame {

	private JPanel entryMainPanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = makePanel();
	private JPanel inputPanel = makePanel();
	
	private String carInfo;
	private String carNum;
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");



	public EntryFrame() {
		super();
		paintedMainPanel();
	}

	public void paintedMainPanel() {

		entryMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		inputPanel.removeAll();

		JPanel boxPanel = new JPanel();

		titlePanel.add(makeLabel("주차장 관리 프로그램 Ver1.0.0", 50));

		contentPanel.add(makeLabel("1번 입차 기능이 실행됐습니다.", 35));

		boxPanel.add(makeLabel("차량 종류 및 용량을 입력하세요.", 25));
		boxPanel.add(makeLabel("승용차(c), 트럭(t), 버스(b)", 25));

		JTextField inputField = makeTextField("ex) c 10", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				carInfo = t.getText();

				String processedAwnser[] = carInfo.split(" ");

				String kindOfCar = processedAwnser[0];
				int capacity = Integer.parseInt(processedAwnser[1]);
				if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
						&& (capacity > 0 || capacity == 0))) {
					throw new InputMismatchException("오류 : 차량 종류 및 용량이 옳지 않습니다.");
					//다이얼로그 띄우기?
				}

				paintedCarNumPanel(kindOfCar, capacity);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				carInfo = inputField.getText();

				String processedAwnser[] = carInfo.split(" ");

				String kindOfCar = processedAwnser[0];
				int capacity = Integer.parseInt(processedAwnser[1]);
				if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
						&& (capacity > 0 || capacity == 0))) {
					throw new InputMismatchException("오류 : 차량 종류 및 용량이 옳지 않습니다.");
					//다이얼로그 띄우기?
				}

				paintedCarNumPanel(kindOfCar, capacity);
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

	public void paintedCarNumPanel(String kindOfCar, int capacity) {
		inputPanel.removeAll();
		contentPanel.removeAll();

		switch(kindOfCar) {
		case "c":
			kindOfCar = "승용차";
			break;
		case "b":
			kindOfCar = "버스";
			break;
		case "t":
			kindOfCar = "트럭";
			break;
		
		}
		
		contentPanel.add(makeLabel("입력하신 차량종류는 " + kindOfCar +", 용량은 "+ capacity +"입니다.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("차량 번호를 입력하세요.", 25));
		boxPanel.add(makeLabel("(4자리 숫자)", 25));

		JTextField inputField = makeTextField("ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				carNum = t.getText();
				if (carNum.length() != 4)
					throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
				
				for (int i = 0; i < 4; i++) {
					if (!Character.isDigit(carNum.charAt(i)))
						throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
				}

				paintedTimePanel(carNum);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				carNum= inputField.getText();
				if (carNum.length() != 4)
					throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
				
				for (int i = 0; i < 4; i++) {
					if (!Character.isDigit(carNum.charAt(i)))
						throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
				}

				paintedTimePanel(carNum);
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

		contentPanel.add(makeLabel("입력하신 차량번호는 " + input + "입니다.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("입차 시간을 입력하세요.", 25));
		boxPanel.add(makeLabel("(년 월 일 시 분)", 25));

		JTextField inputField = makeTextField("ex) 2020 12 18 10 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String entryTime = t.getText();
				dateFormat.setLenient(false); // 양식에 다른 입력을 받으면 Exception 발생.
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String entryTime = inputField.getText();
				dateFormat.setLenient(false); // 양식에 다른 입력을 받으면 Exception 발생.
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		}));

		inputPanel.add(boxPanel);
		entryMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}

	public void paintedCheckPanel() {
		Car curCar = Test.runEntry(carInfo, carNum, entryDate);
		inputPanel.removeAll();
		contentPanel.removeAll();

		inputPanel.setLayout(new FlowLayout());

		contentPanel.add(makeLabel("입차정보 : " + curCar + "입니다.", 35));

		inputPanel.add(makeLabel("입차가 완료되었습니다.", 25));

		inputPanel.add(makeButton("초기화면", 25, new ActionListener() {

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
