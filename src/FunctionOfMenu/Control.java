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
	// ---------------������������������
	static UndoManager undo = new UndoManager();

	public void setJTextArea(JTextArea wb) {
		this.wb = wb;
		wb.getDocument().addUndoableEditListener(undo);
	}

	public void setJMenuItem(JMenuItem chexiao, JMenuItem huifu) {
		Control.chexiao = chexiao;
		Control.huifu = huifu;
	}

	public void actionPerformed(ActionEvent e) {// �˵�����¼���ʵ��
		String str = e.getActionCommand();
		if (str.equals("��")) {
			this.open();
		}

		else if (str.equals("�½�")) {
			Note.js.setTitle("�½����±�-���±�");
			wb.setText(null);
		}

		else if (str.equals("����")) {
			this.save();
		} else if (str.equals("���Ϊ")) {
			this.saveas();
		} else if (str.equals("�˳�")) {
			this.quit();
		} else if (str.equals("����")) {
			this.undoMethod();
		} else if (str.equals("�ָ�")) {
			this.redoMethod();
		} else if (str.equals("����")) {
			wb.copy();
		} else if (str.equals("����")) {
			wb.cut();
		} else if (str.equals("ճ��")) {
			wb.paste();
		} else if (str.equals("ɾ��")) {
			int start = wb.getSelectionStart();
			int end = wb.getSelectionEnd();
			wb.replaceRange("", start, end);// ѡ�е�������""�滻
		} else if (str.equals("�滻")) {
			SubstitutionMethod substitutionmethod = new SubstitutionMethod();
			substitutionmethod.setTextArea(wb);
			substitutionmethod.findmethod();
		} else if (str.equals("ȫѡ")) {
			wb.selectAll();
		} else if (str.equals("�Զ�����")) {
			if (wb.getLineWrap()) {// �ʼ�Ļ���״̬��true
				wb.setLineWrap(false);
			} else {
				wb.setLineWrap(true);
			}

		} else if (str.equals("����")) {
			FontMethod fontMethod = new FontMethod();

		} else if (str.equals("״̬")) {
			ClassStatus classStatus = new ClassStatus();// ״̬��Ĵ���
			Thread tread = new Thread(classStatus);// �˹��췽������Runnable������ʵ��(classStatus)��Ҳ����˵����ͨ��Thread��������Runnableʵ�ֵĶ��߳�
			tread.start();// start()����Э��ϵͳ����Դ
		} else if (str.equals("����")) {
			JOptionPane aboutAuthor = new JOptionPane();
			aboutAuthor.showMessageDialog(null, "�����ߣ��Ų���", "�����±��ı�����", JOptionPane.INFORMATION_MESSAGE);
		} else if (str.equals("����")) {
			FindMethod find = new FindMethod();

		}
	}

	public void save() {// �˵����ķ���
		if (dir == null) {
			file = new FileDialog(Note.js, "����", FileDialog.SAVE);
			file.setFile("*.txt");// ���ý���ȡtxt�ļ�
			file.setVisible(true);
		}
		dir = file.getDirectory();// �õ����ڵ�Ŀ¼
		name = file.getFile();// �õ�ѡ���ļ����ļ���
		Note.js.setTitle(name + "-���±�");
		File newfile = new File(dir, name);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(newfile);// д���ַ���
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// ת��Ϊ�߼���
			String s = null;
			bufferedWriter.write(solvehuanhang());
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// ���ù��㷵�ص�һλ

	}

	public void saveas() {// �˵������Ϊ�ķ���
		file = new FileDialog(Note.js, "���Ϊ", FileDialog.SAVE);
		file.setFile("*.txt");// ���ý���ȡtxt�ļ�
		file.setVisible(true);
		dir = file.getDirectory();// �õ����ڵ�Ŀ¼
		name = file.getFile();// �õ�ѡ���ļ����ļ���
		File newfile = new File(dir, name);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(newfile);// д���ַ���
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);// ת��Ϊ�߼���
			bufferedWriter.write(solvehuanhang());
			bufferedWriter.close();
			fileWriter.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// ���ù��㷵�ص�һλ
	}

	public void open() {// �˵���򿪵ķ���
		wb.setText("");// �ٴδ�ʱ��������ı���
		file = new FileDialog(Note.js, "��", FileDialog.LOAD);
		file.setFile("*.txt");// ���ý���ȡtxt�ļ�
		file.setVisible(true);
		dir = file.getDirectory();// �õ����ڵ�Ŀ¼
		name = file.getFile();// �õ�ѡ���ļ����ļ���
		File newfile = new File(dir, name);
		try {
			Note.js.setTitle(name + "-���±�");
			FileReader fileReader;
			fileReader = new FileReader(newfile);// ��ȡ�ַ���
			/*
			 * * ProgressMonitorInputStream in=new
			 * ProgressMonitorInputStream(null,"��ȡ�ı��ļ�",fileReader);
			 * ProgressMonitor p=fileReader.getProgressMonitor(); ������
			 */

			BufferedReader bufferedReader = new BufferedReader(fileReader);// ת��Ϊ�߼���
			String s = null;
			while ((s = bufferedReader.readLine()) != null) {// �ı�һ��һ�ж�ȡ��ֱ��������
				wb.append(s + "\n");
			}
			bufferedReader.close();
			fileReader.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wb.setCaretPosition(0);// ���ù��㷵�ص�һλ
	}

	public void undoMethod() {// �˵�����ķ���
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

	public void redoMethod() {// �˵���ָ��ķ���
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

	public void quit() {// �˵����˳��ķ���
		if (dir == null) {
			if (wb.getText() == "") {
				System.exit(0);
			}
			String tips = "�Ƿ񱣴�";
			int n = JOptionPane.showConfirmDialog(null, tips, "���±�", JOptionPane.YES_NO_CANCEL_OPTION);// ��
																										// ����0
																										// ��
																										// ����1
																										// ȡ��
																										// ����2
			if (n == 0) {// ������ǡ�
				save();
				System.exit(0);
			} else if (n == 1) {// �������
				System.exit(0);
			} else if (n == 2) {// �����ȡ����
				return;
			}
		}

		else {// ��Ŀ¼���ǿ�ʱ���������ļ�ʱ����
			JTextArea temText = new JTextArea();
			File newfile = new File(dir, name);
			try {
				temText.setText("");
				FileReader fileReader;
				fileReader = new FileReader(newfile);// ��ȡ�ַ���
				/*
				 * * ProgressMonitorInputStream in=new
				 * ProgressMonitorInputStream(null,"��ȡ�ı��ļ�",fileReader);
				 * ProgressMonitor p=fileReader.getProgressMonitor(); ������
				 */

				BufferedReader bufferedReader = new BufferedReader(fileReader);// ת��Ϊ�߼���
				String s = null;
				while ((s = bufferedReader.readLine()) != null) {// �ı�һ��һ�ж�ȡ��ֱ��������
					temText.append(s + "line.separator");
				}
				bufferedReader.close();
				fileReader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (temText.getText() == wb.getText() || wb.getText() == null) {// ����ı���������Դ�ļ���ͬ���ı���Ϊ�����˳�����
				System.exit(0);
			} else {
				String tips = "�Ƿ񱣴��ļ�";
				int n = JOptionPane.showConfirmDialog(null, tips, "���±�", JOptionPane.YES_NO_CANCEL_OPTION);// ��
																											// ����0
																											// ��
																											// ����1
																											// ȡ��
																											// ����2
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

	public String solvehuanhang() {// �����Windowsϵͳ�»�����ϵͳ�µļ��±��޷���ʾ��������
		JTextArea zhongjianwenbenqu = new JTextArea();
		String a[] = wb.getText().split("[\n]");// �Ի��з�Ϊ�ָ���
		for (int x = 0; x < a.length; x++) {
			zhongjianwenbenqu.append(a[x]);
			zhongjianwenbenqu.append(System.getProperty("line.separator"));// ���ϵͳ���з����γɻ���Ч��
		}
		return zhongjianwenbenqu.getText();
	}

}

