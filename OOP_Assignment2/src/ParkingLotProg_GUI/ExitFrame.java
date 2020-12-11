package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ParkingProgram.Car;
import ParkingProgram.Test;

public class ExitFrame extends BasicFrame {

	private JPanel showPakingLotMainPanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = makePanel();
	private JPanel inputPanel = makePanel();
	private JLabel alertLabel = makeLabel("", 15);
	private JPanel boxPanel = new JPanel();
	private String carNum;
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");
	private Dialog infoDialog;

	public ExitFrame() {
		super();
//		paintedCarNumPanel();
		infoDialog = makeDialog();
		infoDialog.add(alertLabel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(makeButton("확인", 15, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoDialog.setVisible(false);
			}
		}));
		infoDialog.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void paintedCarNumPanel() {

		showPakingLotMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		inputPanel.removeAll();
		boxPanel.removeAll();
		JPanel titleButtonPanel = new JPanel();

		titlePanel.add(makeLabel("주차장 관리 프로그램 Ver1.0.0", 50));
		titleButtonPanel.add(makeButton("초기화면", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		}));
		titlePanel.add(titleButtonPanel, BorderLayout.SOUTH);

		contentPanel.add(makeLabel("2번 출차 기능이 실행됐습니다.", 35));

		boxPanel.add(makeLabel("출차를 원하는 차량 번호를 입력하세요.", 25));
		boxPanel.add(makeLabel("(4자리 숫자)", 25));

		JTextField inputField = makeTextField("Ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JTextField t = (JTextField) e.getSource();
				try {
					carNum = t.getText();

					if (carNum.length() != 4) {
						throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
					}
					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
						}
					}
					if (Test.checkParkingLot(carNum) == -1) {

						throw new IllegalArgumentException("오류 : 입력한 차량이 주차장에 존재하지 않습니다.");
					}
					paintedDatePanel(carNum);

				} catch (InputMismatchException e1) {
					alertLabel.setText("오류 : 차량 번호가 올바르지 않습니다");
					infoDialog.setVisible(true);
					t.requestFocus();
					t.selectAll();
				} catch (IllegalArgumentException e1) {
					alertLabel.setText("오류 : 입력한 차량이 주차장에 존재하지 않습니다.");
					infoDialog.setVisible(true);
					t.requestFocus();
					t.selectAll();
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					carNum = inputField.getText();

					if (carNum.length() != 4) {
						throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
					}
					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("오류 : 차량 번호가 올바르지 않습니다");
						}
					}
					if (Test.checkParkingLot(carNum) == -1) {

						throw new IllegalArgumentException("오류 : 입력한 차량이 주차장에 존재하지 않습니다.");
					}

					paintedDatePanel(carNum);
				} catch (InputMismatchException e1) {
					alertLabel.setText("오류 : 차량 번호가 올바르지 않습니다");
					infoDialog.setVisible(true);
					inputField.requestFocus();
					inputField.selectAll();
				} catch (IllegalArgumentException e1) {
					alertLabel.setText("오류 : 입력한 차량이 주차장에 존재하지 않습니다.");
					infoDialog.setVisible(true);
					inputField.requestFocus();
					inputField.selectAll();
				}
			}
		}));

		inputPanel.add(boxPanel);
		showPakingLotMainPanel.add(titlePanel);
		showPakingLotMainPanel.add(contentPanel);
		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();

		setVisible(true);
		inputField.requestFocus();
		inputField.selectAll();
	}

	public void paintedDatePanel(String carNum) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		boxPanel.removeAll();

		contentPanel.add(makeLabel("출차할 차량번호는 " + carNum + "입니다.", 35));

		boxPanel.add(makeLabel("출차 시간을 입력해주세요.", 25));
		boxPanel.add(makeLabel("(년 월 일 시 분)", 25));

		JTextField inputField = makeTextField("Ex) 2020 12 20 8 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String entryTime = t.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					if (Test.checkPakingTime(carNum, entryDate) < 0)
						throw new ArithmeticException("오류 : 출차시간이 입차시간보다 빠릅니다.");
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("오류 : 날짜 입력이 올바르지 않습니다.");
					infoDialog.setVisible(true);
					t.requestFocus();
					t.selectAll();
				} catch (ArithmeticException e1) {
					alertLabel.setText("오류 : 출차시간이 입차시간보다 빠릅니다.");
					infoDialog.setVisible(true);
					t.requestFocus();
					t.selectAll();
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String entryTime = inputField.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					if (Test.checkPakingTime(carNum, entryDate) < 0)
						throw new ArithmeticException("오류 : 출차시간이 입차시간보다 빠릅니다.");
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("오류 : 날짜 입력이 올바르지 않습니다.");
					infoDialog.setVisible(true);
					inputField.requestFocus();
					inputField.selectAll();
				} catch (ArithmeticException e1) {
					alertLabel.setText("오류 : 출차시간이 입차시간보다 빠릅니다.");
					infoDialog.setVisible(true);
					inputField.requestFocus();
					inputField.selectAll();
				}
			}
		}));

		inputField.requestFocus();
		inputField.selectAll();

		inputPanel.add(boxPanel);
		showPakingLotMainPanel.add(contentPanel);
		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();

		inputField.requestFocus();
		inputField.selectAll();
	}

	public void paintedCheckPanel() {
		inputPanel.removeAll();
		contentPanel.removeAll();

		contentPanel.setLayout(new FlowLayout());
		inputPanel.setLayout(new FlowLayout());

		String exitValue = Test.runExit(carNum, entryDate);
		String processedValue[] = exitValue.split(" ");

		contentPanel.setBorder(BorderFactory.createEmptyBorder(90, 30, 30, 30));
		contentPanel.add(makeLabel("주차시간은 " + processedValue[0] + "시간 " + processedValue[1] + "분입니다.", 35));
		contentPanel.add(makeLabel("주차요금은 " + processedValue[2] + "원입니다.", 35));
		inputPanel.add(makeLabel("출차가 완료되었습니다.", 25));

		showPakingLotMainPanel.add(contentPanel);
		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();

	}

}