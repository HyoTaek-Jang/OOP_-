package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ParkingProgram.Car;
import ParkingProgram.Test;


public class ShowPakingLotFrame extends BasicFrame{

	private JPanel showPakingLotMainPanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = new JPanel();
	private JPanel boxPanel;
	private JLabel carInfo;

	public ShowPakingLotFrame() {
		super();		
		showPakingLotMainPanel.setLayout(new BorderLayout());
	}
	
	/*
	if (!cloneParkingLot.isEmpty()) {
		Collections.sort(cloneParkingLot);
		for (Car c : cloneParkingLot) {
			System.out.println(c);
		}
	} else
		System.out.println("�������� ����ֽ��ϴ�.");
	*/

	public void paintedParkingLotPanel() {

		showPakingLotMainPanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		JPanel titleButtonPanel = new JPanel();
		
		titlePanel.add(makeLabel("������ ���� ���α׷� Ver1.0.0", 50));
		titleButtonPanel.add(makeButton("�ʱ�ȭ��", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}}));
		titlePanel.add(titleButtonPanel, BorderLayout.SOUTH);
		titlePanel.setBorder(BorderFactory.createEmptyBorder(90 , 30, 30, 30));
		
		ArrayList<Car> parkingLot = Test.getCloneParkingLot();
		
		if (!parkingLot.isEmpty()) {
			Collections.sort(parkingLot);
			for (Car c : parkingLot) {
				contentPanel.add(makeCarBlock(c));
			}
		} else
			System.out.println("�������� ����ֽ��ϴ�.");


		showPakingLotMainPanel.add(titlePanel,BorderLayout.NORTH);
		showPakingLotMainPanel.add(contentPanel, BorderLayout.CENTER);

		getContentPane().removeAll();
		getContentPane().add(showPakingLotMainPanel);
		revalidate();
		repaint();
	}
	
	public JPanel makeCarBlock(Car c) {
		boxPanel = new JPanel();
		carInfo = makeLabel(c.toString(), 20);
		
		boxPanel.setBackground(Color.GRAY);
		boxPanel.setBorder(BorderFactory.createEmptyBorder(15 , 15, 15, 15));
		
		boxPanel.add(carInfo);
		
		return boxPanel;
	}

}