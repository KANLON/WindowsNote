package FunctionOfMenu;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import Frame.Note;

//���ڵļ������¼���ʵ��
public class WinListener extends WindowAdapter {
	public void windowClosing(WindowEvent e) {
		Control tem = new Control();
		tem.quit();
		Note.js.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
