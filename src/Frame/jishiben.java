package Frame;

import Frame.Note;

import Frame.jishiben;
import FunctionOfMenu.ClassMouseListener;
import FunctionOfMenu.Control;
import FunctionOfMenu.WinListener;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

public class jishiben extends JFrame {
	// ���ü�����
	Control listener;
	WinListener winListener = new WinListener();
	ClassMouseListener mouseListener = new ClassMouseListener();
	// �����Ҽ������˵�
	public static JPopupMenu popupMenu = new JPopupMenu();
	// �����ı������˵������˵��Ͳ˵���
	public static JTextArea wb = new JTextArea();
	JMenu wj = new JMenu("�ļ�");
	JMenu bj = new JMenu("�༭");
	JMenu gs = new JMenu("��ʽ");
	JMenu ck = new JMenu("�鿴");
	JMenu bz = new JMenu("����");
	JMenuBar cdt = new JMenuBar();
	JMenuItem xinjian = new JMenuItem("�½�");
	JMenuItem baocun = new JMenuItem("����");
	JMenuItem lingcunwei = new JMenuItem("���Ϊ ");
	JMenuItem dakai = new JMenuItem("��");
	JMenuItem tuichu = new JMenuItem("�˳�");
	JMenuItem chexiao = new JMenuItem("����");
	JMenuItem popupMenu_Undo = new JMenuItem("����");
	JMenuItem huifu = new JMenuItem("�ָ�");
	JMenuItem popupMenu_Redo = new JMenuItem("�ָ�");
	JMenuItem fuzhi = new JMenuItem("����");
	JMenuItem popupMenu_Copy = new JMenuItem("����");
	JMenuItem jianqie = new JMenuItem("����");
	JMenuItem popupMenu_Cut = new JMenuItem("����");
	JMenuItem zhantie = new JMenuItem("ճ��");
	JMenuItem popupMenu_Paste = new JMenuItem("ճ��");
	JMenuItem shanchu = new JMenuItem("ɾ��");
	JMenuItem popupMenu_Delete = new JMenuItem("ɾ��");
	JMenuItem chazhao = new JMenuItem("����");
	JMenuItem tihuan = new JMenuItem("�滻");
	JMenuItem quanxuan = new JMenuItem("ȫѡ");
	JMenuItem popupMenu_SelectAll = new JMenuItem("ȫѡ");
	JMenuItem ziti = new JMenuItem("����");
	JMenuItem zhuangtai = new JMenuItem("״̬	");
	JMenuItem guanyu = new JMenuItem("����");
	JRadioButton wrapLine = new JRadioButton("�Զ�����", true);

	public jishiben() {
		init();
		setTitle("�½����±�-���±�");
		setSize(768, 500);
		setLocation(250, 150);
		setVisible(true);
		wb.setLineWrap(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// ���ô���λ�þ���
		// ���ô���ͼ��
		Toolkit tool = this.getToolkit(); // �õ�һ��Toolkit���� Image
		Image myimage = tool.getImage("Icon/���±�ͼ��.jpg"); // ��tool��ȡͼ��
		this.setIconImage(myimage);//����ͼ��
		JScrollPane jsp = new JScrollPane(wb);
		Container c = this.getContentPane();
		c.add(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // ��Ҫʱ����
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // ���Ǵ���
	}

	public void init() {
		// ��Ӳ˵���
		setJMenuBar(cdt);
		wb.setSize(200, 500);
		add(new JScrollPane(wb));
		this.add(wb);
		// ���˵����ڼӲ˵�
		cdt.add(wj);
		cdt.add(bj);
		cdt.add(gs);
		cdt.add(ck);
		cdt.add(bz);
		cdt.add(wb);
		// ���˵��ڼӲ˵���
		wj.add(xinjian);
		wj.add(dakai);
		wj.add(baocun);
		wj.add(lingcunwei);
		wj.addSeparator();// ���ӷָ���
		wj.add(tuichu);
		bj.add(chexiao);
		bj.add(huifu);
		bj.addSeparator();// ���ӷָ���
		bj.add(fuzhi);
		bj.add(jianqie);
		bj.add(zhantie);
		bj.add(shanchu);
		bj.add(quanxuan);
		bj.addSeparator();// ���ӷָ���
		bj.add(chazhao);
		bj.add(tihuan);
		gs.add(wrapLine);
		gs.add(ziti);
		ck.add(zhuangtai);
		bz.add(guanyu);
		add(wb);
		// ���Ҽ������˵�����Ӳ˵���
		popupMenu.add(popupMenu_Undo);
		popupMenu.add(popupMenu_Redo);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_Cut);
		popupMenu.add(popupMenu_Copy);
		popupMenu.add(popupMenu_Paste);
		popupMenu.add(popupMenu_Delete);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_SelectAll);
		// ��������
		dakai.setActionCommand("��");
		xinjian.setActionCommand("�½�");
		baocun.setActionCommand("����");
		lingcunwei.setActionCommand("���Ϊ");
		tuichu.setActionCommand("�˳�");
		chexiao.setActionCommand("����");
		huifu.setActionCommand("�ָ�");
		fuzhi.setActionCommand("����");
		jianqie.setActionCommand("����");
		zhantie.setActionCommand("ճ��");
		shanchu.setActionCommand("ɾ��");
		tihuan.setActionCommand("�滻");
		quanxuan.setActionCommand("ȫѡ");
		wrapLine.setActionCommand("�Զ�����");
		ziti.setActionCommand("����");
		zhuangtai.setActionCommand("״̬");
		guanyu.setActionCommand("����");
		chazhao.setActionCommand("����");
		popupMenu_Undo.setActionCommand("����");
		popupMenu_Redo.setActionCommand("�ָ�");
		popupMenu_Cut.setActionCommand("����");
		popupMenu_Copy.setActionCommand("����");
		popupMenu_Paste.setActionCommand("ճ��");
		popupMenu_Delete.setActionCommand("ɾ��");
		popupMenu_SelectAll.setActionCommand("ȫѡ");
		// ����������
		listener = new Control();
		listener.setJTextArea(wb);
		listener.setJMenuItem(chexiao, huifu);
		// ע�������
		dakai.addActionListener(listener);
		xinjian.addActionListener(listener);
		baocun.addActionListener(listener);
		lingcunwei.addActionListener(listener);
		tuichu.addActionListener(listener);
		chexiao.addActionListener(listener);
		huifu.addActionListener(listener);
		fuzhi.addActionListener(listener);
		jianqie.addActionListener(listener);
		zhantie.addActionListener(listener);
		shanchu.addActionListener(listener);
		quanxuan.addActionListener(listener);
		tihuan.addActionListener(listener);
		wrapLine.addActionListener(listener);
		ziti.addActionListener(listener);
		zhuangtai.addActionListener(listener);
		guanyu.addActionListener(listener);
		chazhao.addActionListener(listener);
		addWindowListener(winListener);
		wb.addMouseListener(mouseListener);
		popupMenu_Undo.addActionListener(listener);
		popupMenu_Redo.addActionListener(listener);
		popupMenu_Cut.addActionListener(listener);
		popupMenu_Copy.addActionListener(listener);
		popupMenu_Paste.addActionListener(listener);
		popupMenu_Delete.addActionListener(listener);
		popupMenu_SelectAll.addActionListener(listener);
		// ���ÿ�ݼ�
		xinjian.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.SHIFT_DOWN_MASK));
		dakai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		baocun.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		lingcunwei.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		tuichu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		chexiao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_MASK));
		huifu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, InputEvent.CTRL_MASK));
		fuzhi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		zhantie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		jianqie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		quanxuan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		shanchu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		chazhao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, InputEvent.CTRL_MASK));
		tihuan.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		zhuangtai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		guanyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_DOWN_MASK));
	}

}
