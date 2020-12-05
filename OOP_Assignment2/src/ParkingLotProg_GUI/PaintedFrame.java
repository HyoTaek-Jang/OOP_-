package ParkingLotProg_GUI;

import java.awt.Component;

import javax.swing.JFrame;

public class PaintedFrame extends JFrame {
	private static final int DEFAULT_WIDTH = 1280;
	private static final int DEFAULT_HEIGHT = 720;
	private MainFrame mainFrame = new MainFrame();
	private EntryFrame entryFrame = new EntryFrame();

	public PaintedFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		//paintPanel(mainFrame.getPanel());
	}

	public void paintPanel(Component component) {
		getContentPane().add(component);
		revalidate();
		repaint();

	}
}


// 현재 사용 안함.