package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import ParkingProgram.Car;
import ParkingProgram.Test;

public class EntryFrame extends BasicFrame {

	private JPanel showPakingLotMainPanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = makePanel();
	private JPanel inputPanel = makePanel();
	private JLabel alertLabel = makeLabel("", 15);

	private String carInfo;
	private String carNum;
	private Date entryDate;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm");
	private Dialog infoDialog;

	public EntryFrame() {
		super();
//		paintedMainPanel();
		infoDialog = makeDialog();
		infoDialog.add(alertLabel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(makeButton("Ȯ��", 15, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infoDialog.setVisible(false);
			}
		}));
		infoDialog.add(buttonPanel, BorderLayout.SOUTH);
	}

	public void paintedMainPanel() {

		showPakingLotMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		inputPanel.removeAll();

		JPanel boxPanel = new JPanel();

		JPanel titleButtonPanel = new JPanel();
		
		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));
		titleButtonPanel.add(makeButton("�ʱ�ȭ��", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}}));
		titlePanel.add(titleButtonPanel, BorderLayout.SOUTH);

		contentPanel.add(makeLabel("1�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("���� ���� �� �뷮�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("�¿���(c), Ʈ��(t), ����(b)", 25));

		JTextField inputField = makeTextField("Ex) c 10", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String kindOfCar = null;
				int capacity = 0;
				try {
					JTextField field = (JTextField) e.getSource();
					carInfo = field.getText();

					String processedAwnser[] = carInfo.split(" ");

					kindOfCar = processedAwnser[0];
					capacity = Integer.parseInt(processedAwnser[1]);
					if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
							&& (capacity > 0 || capacity == 0))) {
						throw new InputMismatchException("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					}
					paintedCarNumPanel(kindOfCar, capacity);
				} catch (Exception e1) {
					alertLabel.setText("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
				}

			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String kindOfCar = null;
				int capacity = 0;
				try {
					carInfo = inputField.getText();

					String processedAwnser[] = carInfo.split(" ");

					kindOfCar = processedAwnser[0];
					capacity = Integer.parseInt(processedAwnser[1]);
					if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
							&& (capacity > 0 || capacity == 0))) {
						throw new InputMismatchException("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					}
					paintedCarNumPanel(kindOfCar, capacity);
				} catch (Exception e1) {
					alertLabel.setText("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
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
	}

	public void paintedCarNumPanel(String kindOfCar, int capacity) {
		inputPanel.removeAll();
		contentPanel.removeAll();

		switch (kindOfCar) {
		case "c":
			kindOfCar = "�¿���";
			break;
		case "b":
			kindOfCar = "����";
			break;
		case "t":
			kindOfCar = "Ʈ��";
			break;

		}

		contentPanel.add(makeLabel("�Է��Ͻ� ���������� " + kindOfCar + ", �뷮�� " + capacity + "�Դϴ�.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� ��ȣ�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(4�ڸ� ����)", 25));

		JTextField inputField = makeTextField("Ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					JTextField t = (JTextField) e.getSource();
					carNum = t.getText();
					if (carNum.length() != 4) {
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					}

					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
						}
					}

					paintedTimePanel(carNum);

				} catch (InputMismatchException e1) {
					alertLabel.setText("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					infoDialog.setVisible(true);
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					carNum = inputField.getText();
					if (carNum.length() != 4) {
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					}

					for (int i = 0; i < 4; i++) {
						if (!Character.isDigit(carNum.charAt(i))) {
							throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
						}
					}

					paintedTimePanel(carNum);

				} catch (InputMismatchException e1) {
					alertLabel.setText("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
					infoDialog.setVisible(true);
				}
			}
		}));

		inputPanel.add(boxPanel);
		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();
	}

	public void paintedTimePanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();

		contentPanel.add(makeLabel("�Է��Ͻ� ������ȣ�� " + input + "�Դϴ�.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� �ð��� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(�� �� �� �� ��)", 25));

		JTextField inputField = makeTextField("Ex) 2020 12 18 10 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String entryTime = t.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("���� : ��¥ �Է��� �ùٸ��� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
					e1.printStackTrace();
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String entryTime = inputField.getText();
				dateFormat.setLenient(false);
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					alertLabel.setText("���� : ��¥ �Է��� �ùٸ��� �ʽ��ϴ�.");
					infoDialog.setVisible(true);
					e1.printStackTrace();
				}
			}
		}));

		inputPanel.add(boxPanel);
		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();
	}

	public void paintedCheckPanel() {
		Car curCar = Test.runEntry(carInfo, carNum, entryDate);
		inputPanel.removeAll();
		contentPanel.removeAll();

		inputPanel.setLayout(new FlowLayout());

		contentPanel.add(makeLabel("�������� : " + curCar + "�Դϴ�.", 35));

		inputPanel.add(makeLabel("������ �Ϸ�Ǿ����ϴ�.", 25));

		showPakingLotMainPanel.add(inputPanel);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();
	}

}
