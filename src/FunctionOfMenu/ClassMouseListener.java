package FunctionOfMenu;

import java.awt.BorderLayout;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import Frame.Note;
import Frame.jishiben;

//ÓÒ¼üÊó±êµÄ¼àÊÓÆ÷
public class ClassMouseListener extends MouseAdapter {
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {

		} else if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			jishiben.popupMenu.show(e.getComponent(), e.getX(), e.getY());
		}
	}
}

