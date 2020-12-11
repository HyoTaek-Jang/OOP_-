package ParkingLotProg_GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import ParkingProgram.Test;

public class ShowIncomeFrame extends BasicFrame {
	
	private JPanel showIncomePanel = makeBasicPanel();

	private JPanel titlePanel = makePanel();
	private JPanel contentPanel = new JPanel();
	
	public ShowIncomeFrame(){
		super();
		showIncomePanel.setLayout(new BorderLayout());
	}

	public void showIncomePanel() {
		showIncomePanel.removeAll();
		titlePanel.removeAll();
		contentPanel.removeAll();
		JPanel titleButtonPanel = new JPanel();
		titleButtonPanel.setBorder(BorderFactory.createEmptyBorder(30 , 30, 30, 30));
		
		titlePanel.add(makeLabel("현재 주차장 총 수입 보기", 50));
		titleButtonPanel.add(makeButton("초기화면", 25, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}}));
		titlePanel.add(titleButtonPanel, BorderLayout.SOUTH);
		titlePanel.setBorder(BorderFactory.createEmptyBorder(90 , 30, 30, 30));

		contentPanel.add(makeLabel(Test.showIncome(), 35));
		contentPanel.setBorder(BorderFactory.createEmptyBorder(90 , 30, 30, 30));


		showIncomePanel.add(titlePanel,BorderLayout.NORTH);
		showIncomePanel.add(contentPanel, BorderLayout.CENTER);

		getContentPane().removeAll();
		getContentPane().add(showIncomePanel);
		revalidate();
		repaint();
	}

}
