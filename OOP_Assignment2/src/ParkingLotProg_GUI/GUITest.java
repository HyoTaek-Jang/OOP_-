package ParkingLotProg_GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class GUITest {
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new MainFrame();
			frame.setTitle("MainFrame");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		});
	}
}
