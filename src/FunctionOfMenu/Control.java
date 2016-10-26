package FunctionOfMenu;
import Frame.Note;
import Frame.jishiben;
import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

public class Control implements ActionListener {
	public static JTextArea wb;
	static int w = 1;
	int fontNumbe;
	public static int intCotrolZhangTaiLan;
	static String name;
	static String dir;
	static JMenuItem chexiao = new JMenuItem();
	static JMenuItem huifu = new JMenuItem();
	public final static JLabel lb = new JLabel();
	FileNameExtensionFilter filter;
	JFileChooser fileDialog;
	static FileDialog file;
	// ---------------创建撤消操作管理器
	static UndoManager undo = new UndoManager();

	public void setJTextArea(JTextArea wb) {
		this.wb = wb;
		wb.getDocument().addUndoableEditListener(undo);
	}

	public void setJMenuItem(JMenuItem chexiao, JMenuItem huifu) {
		Control.chexiao = chexiao;
		Control.huifu = huifu;
	}

	public void actionPerformed(ActionEvent e) {// 菜单项的事件的实现
		String str = e.getActionCommand();
		if (str.equals("打开")) {
			this.open();
		}

		else if (str.equals("新建")) {
			Note.js.setTitle("新建记事本-记事本");
			wb.setText(null);
		}

		else if (str.equals("保存")) {
			this.save();
		} else if (str.equals("另存为")) {
			this.saveas();
		} else if (str.equals("退出")) {
			this.quit();
		} else if (str.equals("撤销")) {
			this.undoMethod();
		} else if (str.equals("恢复")) {
			this.redoMethod();
		} else if (str.equals("复制")) {
			wb.copy();
		} else if (str.equals("剪切")) {
			wb.cut();
		} else if (str.equals("粘贴")) {
			wb.paste();
		} else if (str.equals("删除")) {
			int start = wb.getSelectionStart();
			int end = wb.getSelectionEnd();
			wb.replaceRange("", start, end);// 选中的区域用""替换
		} else if (str.equals("替换")) {
			SubstitutionMethod substitutionmethod = new SubstitutionMethod();
			substitutionmethod.setTextArea(wb);
			substitutionmethod.findmethod();
		} else if (str.equals("全选")) {
			wb.selectAll();
		} else if (str.equals("自动换行")) {
			if (wb.getLineWrap()) {// 最开始的换行状态是true
				wb.setLineWrap(false);
			} else {
				wb.setLineWrap(true);
			}

		} else if (str.equals("字体")) {
			FontMethod fontMethod = new FontMethod();

		} else if (str.equals("状态")) {
			ClassStatus classStatus = new ClassStatus();// 状态类的创建
			Thread tread = new Thread(classStatus);// 此构造方法接受Runnable的子类实例(classStatus)，也就是说可以通过Thread类来启动Runnable实现的多线程
			tread.start();// start()可以协调系统的资源
		} else if (str.equals("关于")) {
			JOptionPane aboutAuthor = new JOptionPane();
			aboutAuthor.showMessageDialog(null, "制作者：张灿龙", "本记事本的编码者", JOptionPane.INFORMATION_MESSAGE);
		} else if (str.equals("查找")) {
			FindMethod find = new FindMethod();

		}
	}

	public void save() {// 菜单项保存的方法
		if (dir == null) {
			file = new FileDialog(Note.js, "保存", FileDialog.SAVE);
			file.setFile("*.txt");// 设置仅获取txt文件
			file.setVisible(true);
		}
		dir = file.getDirectory();// 得到现在的目录
		name = file.getFile();// 得到选择文件的文件名
		Note.js.setTitle(name + "-记事本");
		File newfile = new File(dir, name);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(newfile);// 写入字符流
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// 转化为高级流
			String s = null;
			bufferedWriter.write(solvehuanhang());
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// 设置光标点返回第一位

	}

	public void saveas() {// 菜单项另存为的方法
		file = new FileDialog(Note.js, "另存为", FileDialog.SAVE);
		file.setFile("*.txt");// 设置仅获取txt文件
		file.setVisible(true);
		dir = file.getDirectory();// 得到现在的目录
		name = file.getFile();// 得到选择文件的文件名
		File newfile = new File(dir, name);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(newfile);// 写入字符流
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// 转化为高级流
			bufferedWriter.write(solvehuanhang());
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// 设置光标点返回第一位
	}

	public void open() {// 菜单项打开的方法
		wb.setText("");// 再次打开时，先请空文本区
		file = new FileDialog(Note.js, "打开", FileDialog.LOAD);
		file.setFile("*.txt");// 设置仅获取txt文件
		file.setVisible(true);
		dir = file.getDirectory();// 得到现在的目录
		name = file.getFile();// 得到选择文件的文件名
		File newfile = new File(dir, name);
		try {
			Note.js.setTitle(name + "-记事本");
			FileReader fileReader;
			fileReader = new FileReader(newfile);// 读取字符流
			/*
			 * * ProgressMonitorInputStream in=new
			 * ProgressMonitorInputStream(null,"读取文本文件",fileReader);
			 * ProgressMonitor p=fileReader.getProgressMonitor(); 进度条
			 */

			BufferedReader bufferedReader = new BufferedReader(fileReader);// 转化为高级流
			String s = null;
			while ((s = bufferedReader.readLine()) != null) {// 文本一行一行读取，直到读完了
				wb.append(s + "\n");
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// 设置光标点返回第一位
	}

	public void undoMethod() {// 菜单项撤销的方法
		if (undo.canUndo()) {
			chexiao.setEnabled(true);
			try {
				undo.undo();
			} catch (CannotUndoException ex) {
				System.out.println("Unable to undo: " + ex);
				ex.printStackTrace();
			}
			if (!undo.canUndo()) {
				chexiao.setEnabled(false);
			}
		}
	}

	public void redoMethod() {// 菜单项恢复的方法
		if (undo.canRedo()) {
			huifu.setEnabled(true);
			try {
				undo.redo();
			} catch (CannotUndoException ex) {
				System.out.println("Unable to redo: " + ex);
				ex.printStackTrace();
			}
			if (!undo.canUndo()) {
				huifu.setEnabled(false);
			}
		}
	}

	public void quit() {// 菜单项退出的方法
		if (dir == null) {
			if (wb.getText() == "") {
				System.exit(0);
			}
			String tips = "是否保存";
			int n = JOptionPane.showConfirmDialog(null, tips, "记事本", JOptionPane.YES_NO_CANCEL_OPTION);// 是
																										// 返回0
																										// 否
																										// 返回1
																										// 取消
																										// 返回2
			if (n == 0) {// 点击“是”
				save();
				System.exit(0);
			} else if (n == 1) {// 点击“否”
				System.exit(0);
			} else if (n == 2) {// 点击“取消”
				return;
			}
		}

		else {// 当目录不是空时，即打开了文件时操作
			JTextArea temText = new JTextArea();
			File newfile = new File(dir, name);
			try {
				temText.setText("");
				FileReader fileReader;
				fileReader = new FileReader(newfile);// 读取字符流
				/*
				 * * ProgressMonitorInputStream in=new
				 * ProgressMonitorInputStream(null,"读取文本文件",fileReader);
				 * ProgressMonitor p=fileReader.getProgressMonitor(); 进度条
				 */

				BufferedReader bufferedReader = new BufferedReader(fileReader);// 转化为高级流
				String s = null;
				while ((s = bufferedReader.readLine()) != null) {// 文本一行一行读取，直到读完了
					temText.append(s + "line.separator");
				}
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (temText.getText() == wb.getText() || wb.getText() == null) {// 如果文本区内容与源文件相同或文本区为空则退出窗口
				System.exit(0);
			} else {
				String tips = "是否保存文件";
				int n = JOptionPane.showConfirmDialog(null, tips, "记事本", JOptionPane.YES_NO_CANCEL_OPTION);// 是
																											// 返回0
																											// 否
																											// 返回1
																											// 取消
																											// 返回2
				if (n == 0) {
					save();
					System.exit(0);
				} else if (n == 1) {
					System.exit(0);
				} else if (n == 2) {
					return;
				}
			}
		}

	}

	public String solvehuanhang() {// 解决在Windows系统下或其他系统下的记事本无法显示换行问题
		JTextArea zhongjianwenbenqu = new JTextArea();
		String a[] = wb.getText().split("[\n]");// 以换行符为分隔符
		for (int x = 0; x < a.length; x++) {
			zhongjianwenbenqu.append(a[x]);
			zhongjianwenbenqu.append(System.getProperty("line.separator"));// 添加系统换行符，形成换行效果
		}
		return zhongjianwenbenqu.getText();
	}

}

