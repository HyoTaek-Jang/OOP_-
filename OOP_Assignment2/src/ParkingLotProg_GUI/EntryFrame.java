package ParkingLotProg_GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryFrame extends BasicFrame {

	private JPanel entryMainPanel = makeBasicPanel();


	JPanel titlePanel = makePanel();
	JPanel contentPanel = makePanel();
	JPanel inputPanel = makePanel();
	
	public EntryFrame()
	{
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
				String input = t.getText();
				paintedCarNumPanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedCarNumPanel(input);
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
	
	public void paintedCarNumPanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		
		contentPanel.add(makeLabel("입력하신 값은 "+input+"입니다.", 35));
		
		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("차량 번호를 입력하세요.", 25));
		boxPanel.add(makeLabel("(4자리 숫자)", 25));
		
		JTextField inputField = makeTextField("ex) 1234", 5, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				paintedTimePanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedTimePanel(input);
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
		
		contentPanel.add(makeLabel("입력하신 값은 "+input+"입니다.", 35));
		
		JPanel boxPanel = new JPanel();
		boxPanel.add(makeLabel("입차 시간을 입력하세요.", 25));
		boxPanel.add(makeLabel("(년 월 일 시 분)", 25));
		
		JTextField inputField = makeTextField("ex) 2020 12 18 10 10", 17, 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				String input = t.getText();
				paintedCheckPanel(input);
			}
		});
		boxPanel.add(inputField);
		boxPanel.add(makeButton("입력", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String input = inputField.getText();
				paintedCheckPanel(input);
			}
		}));

		inputPanel.add(boxPanel);
		entryMainPanel.add(inputPanel);
		
		getContentPane().removeAll();
		getContentPane().add(entryMainPanel);
		revalidate();
		repaint();
	}

	
	public void paintedCheckPanel(String input) {
		inputPanel.removeAll();
		contentPanel.removeAll();
		
		inputPanel.setLayout(new FlowLayout());
		
		contentPanel.add(makeLabel("입차된 차량은 "+input+"입니다.", 35));
		
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
