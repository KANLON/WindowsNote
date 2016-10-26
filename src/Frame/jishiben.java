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
	// 设置监视器
	Control listener;
	WinListener winListener = new WinListener();
	ClassMouseListener mouseListener = new ClassMouseListener();
	// 定义右键弹出菜单
	public static JPopupMenu popupMenu = new JPopupMenu();
	// 定义文本区、菜单条、菜单和菜单项
	public static JTextArea wb = new JTextArea();
	JMenu wj = new JMenu("文件");
	JMenu bj = new JMenu("编辑");
	JMenu gs = new JMenu("格式");
	JMenu ck = new JMenu("查看");
	JMenu bz = new JMenu("帮助");
	JMenuBar cdt = new JMenuBar();
	JMenuItem xinjian = new JMenuItem("新建");
	JMenuItem baocun = new JMenuItem("保存");
	JMenuItem lingcunwei = new JMenuItem("另存为 ");
	JMenuItem dakai = new JMenuItem("打开");
	JMenuItem tuichu = new JMenuItem("退出");
	JMenuItem chexiao = new JMenuItem("撤销");
	JMenuItem popupMenu_Undo = new JMenuItem("撤销");
	JMenuItem huifu = new JMenuItem("恢复");
	JMenuItem popupMenu_Redo = new JMenuItem("恢复");
	JMenuItem fuzhi = new JMenuItem("复制");
	JMenuItem popupMenu_Copy = new JMenuItem("复制");
	JMenuItem jianqie = new JMenuItem("剪切");
	JMenuItem popupMenu_Cut = new JMenuItem("剪切");
	JMenuItem zhantie = new JMenuItem("粘贴");
	JMenuItem popupMenu_Paste = new JMenuItem("粘贴");
	JMenuItem shanchu = new JMenuItem("删除");
	JMenuItem popupMenu_Delete = new JMenuItem("删除");
	JMenuItem chazhao = new JMenuItem("查找");
	JMenuItem tihuan = new JMenuItem("替换");
	JMenuItem quanxuan = new JMenuItem("全选");
	JMenuItem popupMenu_SelectAll = new JMenuItem("全选");
	JMenuItem ziti = new JMenuItem("字体");
	JMenuItem zhuangtai = new JMenuItem("状态	");
	JMenuItem guanyu = new JMenuItem("关于");
	JRadioButton wrapLine = new JRadioButton("自动换行", true);

	public jishiben() {
		init();
		setTitle("新建记事本-记事本");
		setSize(768, 500);
		setLocation(250, 150);
		setVisible(true);
		wb.setLineWrap(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// 设置窗口位置居中
		// 设置窗口图标
		Toolkit tool = this.getToolkit(); // 得到一个Toolkit对象 Image
		Image myimage = tool.getImage("Icon/记事本图标.jpg"); // 由tool获取图像
		this.setIconImage(myimage);//设置图标
		JScrollPane jsp = new JScrollPane(wb);
		Container c = this.getContentPane();
		c.add(jsp);
		jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 需要时出现
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // 总是存在
	}

	public void init() {
		// 添加菜单条
		setJMenuBar(cdt);
		wb.setSize(200, 500);
		add(new JScrollPane(wb));
		this.add(wb);
		// 往菜单条内加菜单
		cdt.add(wj);
		cdt.add(bj);
		cdt.add(gs);
		cdt.add(ck);
		cdt.add(bz);
		cdt.add(wb);
		// 往菜单内加菜单项
		wj.add(xinjian);
		wj.add(dakai);
		wj.add(baocun);
		wj.add(lingcunwei);
		wj.addSeparator();// 增加分隔线
		wj.add(tuichu);
		bj.add(chexiao);
		bj.add(huifu);
		bj.addSeparator();// 增加分隔线
		bj.add(fuzhi);
		bj.add(jianqie);
		bj.add(zhantie);
		bj.add(shanchu);
		bj.add(quanxuan);
		bj.addSeparator();// 增加分隔线
		bj.add(chazhao);
		bj.add(tihuan);
		gs.add(wrapLine);
		gs.add(ziti);
		ck.add(zhuangtai);
		bz.add(guanyu);
		add(wb);
		// 往右键弹出菜单里添加菜单项
		popupMenu.add(popupMenu_Undo);
		popupMenu.add(popupMenu_Redo);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_Cut);
		popupMenu.add(popupMenu_Copy);
		popupMenu.add(popupMenu_Paste);
		popupMenu.add(popupMenu_Delete);
		popupMenu.addSeparator();
		popupMenu.add(popupMenu_SelectAll);
		// 设置命令
		dakai.setActionCommand("打开");
		xinjian.setActionCommand("新建");
		baocun.setActionCommand("保存");
		lingcunwei.setActionCommand("另存为");
		tuichu.setActionCommand("退出");
		chexiao.setActionCommand("撤销");
		huifu.setActionCommand("恢复");
		fuzhi.setActionCommand("复制");
		jianqie.setActionCommand("剪切");
		zhantie.setActionCommand("粘贴");
		shanchu.setActionCommand("删除");
		tihuan.setActionCommand("替换");
		quanxuan.setActionCommand("全选");
		wrapLine.setActionCommand("自动换行");
		ziti.setActionCommand("字体");
		zhuangtai.setActionCommand("状态");
		guanyu.setActionCommand("关于");
		chazhao.setActionCommand("查找");
		popupMenu_Undo.setActionCommand("撤销");
		popupMenu_Redo.setActionCommand("恢复");
		popupMenu_Cut.setActionCommand("剪切");
		popupMenu_Copy.setActionCommand("复制");
		popupMenu_Paste.setActionCommand("粘贴");
		popupMenu_Delete.setActionCommand("删除");
		popupMenu_SelectAll.setActionCommand("全选");
		// 创建监视器
		listener = new Control();
		listener.setJTextArea(wb);
		listener.setJMenuItem(chexiao, huifu);
		// 注册监视器
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
		// 设置快捷键
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
