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

		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));

		contentPanel.add(makeLabel("1�� ���� ����� ����ƽ��ϴ�.", 35));

		boxPanel.add(makeLabel("���� ���� �� �뷮�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("�¿���(c), Ʈ��(t), ����(b)", 25));

		JTextField inputField = makeTextField("ex) c 10", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				carInfo = t.getText();

				String processedAwnser[] = carInfo.split(" ");

				String kindOfCar = processedAwnser[0];
				int capacity = Integer.parseInt(processedAwnser[1]);
				if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
						&& (capacity > 0 || capacity == 0))) {
					throw new InputMismatchException("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					//���̾�α� ����?
				}

				paintedCarNumPanel(kindOfCar, capacity);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				carInfo = inputField.getText();

				String processedAwnser[] = carInfo.split(" ");

				String kindOfCar = processedAwnser[0];
				int capacity = Integer.parseInt(processedAwnser[1]);
				if (!((kindOfCar.equals("c") || kindOfCar.equals("b") || kindOfCar.equals("t"))
						&& (capacity > 0 || capacity == 0))) {
					throw new InputMismatchException("���� : ���� ���� �� �뷮�� ���� �ʽ��ϴ�.");
					//���̾�α� ����?
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
			kindOfCar = "�¿���";
			break;
		case "b":
			kindOfCar = "����";
			break;
		case "t":
			kindOfCar = "Ʈ��";
			break;
		
		}
		
		contentPanel.add(makeLabel("�Է��Ͻ� ���������� " + kindOfCar +", �뷮�� "+ capacity +"�Դϴ�.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� ��ȣ�� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(4�ڸ� ����)", 25));

		JTextField inputField = makeTextField("ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				carNum = t.getText();
				if (carNum.length() != 4)
					throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
				
				for (int i = 0; i < 4; i++) {
					if (!Character.isDigit(carNum.charAt(i)))
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
				}

				paintedTimePanel(carNum);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				carNum= inputField.getText();
				if (carNum.length() != 4)
					throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
				
				for (int i = 0; i < 4; i++) {
					if (!Character.isDigit(carNum.charAt(i)))
						throw new InputMismatchException("���� : ���� ��ȣ�� �ùٸ��� �ʽ��ϴ�");
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

		contentPanel.add(makeLabel("�Է��Ͻ� ������ȣ�� " + input + "�Դϴ�.", 35));

		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("���� �ð��� �Է��ϼ���.", 25));
		boxPanel.add(makeLabel("(�� �� �� �� ��)", 25));

		JTextField inputField = makeTextField("ex) 2020 12 18 10 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String entryTime = t.getText();
				dateFormat.setLenient(false); // ��Ŀ� �ٸ� �Է��� ������ Exception �߻�.
				try {
					entryDate = dateFormat.parse(entryTime);
					paintedCheckPanel();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("�Է�", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String entryTime = inputField.getText();
				dateFormat.setLenient(false); // ��Ŀ� �ٸ� �Է��� ������ Exception �߻�.
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

		contentPanel.add(makeLabel("�������� : " + curCar + "�Դϴ�.", 35));

		inputPanel.add(makeLabel("������ �Ϸ�Ǿ����ϴ�.", 25));

		inputPanel.add(makeButton("�ʱ�ȭ��", 25, new ActionListener() {

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
