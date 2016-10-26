package FunctionOfMenu;

import java.awt.BorderLayout;
import java.util.Date;

import Frame.Note;

//实现了Runnable接口的用于显示状态的类，用来实现多线程
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
				currentTime = String.format("%tF,%tH点%tM分%tS秒", nowTime, nowTime, nowTime, nowTime, nowTime, nowTime);// 把时间格式化
				Control.lb.setText("当前字符数为：" + Control.wb.getText().length() + " ," + " (不含空格)当前字符数为："
						+ Control.wb.getText().trim().length() + "," + " 当前行数为：" + Control.wb.getLineCount() + "  ,"
						+ "当前时间为：" + currentTime);
			}

		}
	}
}
