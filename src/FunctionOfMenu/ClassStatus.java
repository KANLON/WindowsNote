package FunctionOfMenu;

import java.awt.BorderLayout;
import java.util.Date;

import Frame.Note;

//ʵ����Runnable�ӿڵ�������ʾ״̬���࣬����ʵ�ֶ��߳�
public class ClassStatus implements Runnable {
	public void run() {
		String currentTime;
		Date nowTime;
		if (Control.intCotrolZhangTaiLan == 1) {
			Control.lb.setVisible(false);
			Control.intCotrolZhangTaiLan = 0;
		} else if (Control.intCotrolZhangTaiLan == 0) {
			Control.intCotrolZhangTaiLan = 1;
			Note.js.add(Control.lb, BorderLayout.SOUTH);
			Control.lb.setVisible(true);
			while (true) {
				nowTime = new Date();
				currentTime = String.format("%tF,%tH��%tM��%tS��", nowTime, nowTime, nowTime, nowTime, nowTime, nowTime);// ��ʱ���ʽ��
				Control.lb.setText("��ǰ�ַ���Ϊ��" + Control.wb.getText().length() + " ," + " (�����ո�)��ǰ�ַ���Ϊ��"
						+ Control.wb.getText().trim().length() + "," + " ��ǰ����Ϊ��" + Control.wb.getLineCount() + "  ,"
						+ "��ǰʱ��Ϊ��" + currentTime);
			}

		}
	}
}
