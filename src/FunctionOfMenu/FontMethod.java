package FunctionOfMenu;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Frame.Note;
import Frame.jishiben;

class FontMethod implements ItemListener, ActionListener {// 字体的实现方法
	// 创建字体对话框
	final JDialog fontDialog = new JDialog(Note.js, "字体", true);
	JPanel panel_Font = new JPanel();
	JPanel panel_FontShape = new JPanel();
	JPanel panel_FontSize = new JPanel();
	JPanel panel_FontExample = new JPanel();
	JPanel panel_Button = new JPanel();
	JLabel fontKinds = new JLabel("字体");
	JLabel fontShape = new JLabel("字形");
	JLabel fontSize = new JLabel("大小");
	JLabel example = new JLabel("           示                        例                          ");
	JTextField text_FontKinds = new JTextField(15);
	JTextField text_FontShape = new JTextField(7);
	JTextField text_FontSize = new JTextField(5);
	JTextArea exampleFont = new JTextArea(2, 6);
	// 把系统内的字体名称放到字符数组里
	String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	JButton ok = new JButton("确定");
	JButton canel = new JButton("取消");
	List fontKindsList = new List(8, false);
	List fontShapeList = new List(6, false);
	List fontSizeList = new List(6, false);

	FontMethod() {
		exampleFont.setText("  示例文本    ");
		fontDialog.setLocationRelativeTo(Note.js);
		fontDialog.setSize(600, 350);
		// 添加字体种类列表
		for (int i = 0; i < fontNames.length; i++) {
			fontKindsList.add(fontNames[fontNames.length - i - 1]);
		}
		fontKindsList.select(0);// 设定开始的选定状态为第一个
		text_FontKinds.setText(fontKindsList.getSelectedItem());
		fontKindsList.addItemListener(this);
		// 在字体平板上增加字体组件
		panel_Font.setAlignmentX(FlowLayout.LEFT);
		panel_Font.setPreferredSize(new Dimension(210, 200));
		panel_Font.add(fontKinds);
		panel_Font.add(text_FontKinds);
		panel_Font.add(fontKindsList);
		// 添加字形列表
		fontShapeList.add("常规");
		fontShapeList.add("倾斜");
		fontShapeList.add("粗体");
		fontShapeList.add("粗体 倾斜");
		fontShapeList.select(0);// 设定开始的选定状态为第一个
		text_FontShape.setText(fontShapeList.getSelectedItem());
		fontShapeList.addItemListener(this);
		// 在字形平板上增加字形组件
		panel_FontShape.setAlignmentX(FlowLayout.LEFT);
		panel_FontShape.setPreferredSize(new Dimension(150, 200));
		panel_FontShape.add(fontShape);
		panel_FontShape.add(text_FontShape);
		panel_FontShape.add(fontShapeList);

		// 添加字体大小列表
		for (int i = 8; i < 73; i++) {
			fontSizeList.add(String.valueOf(i));
		}
		fontSizeList.select(5);// 设定开始的选定状态为第一个
		text_FontSize.setText(fontSizeList.getSelectedItem());
		fontSizeList.addItemListener(this);
		// 在字体大小平板上增加字体大小组件
		panel_FontSize.setAlignmentX(FlowLayout.LEFT);
		panel_FontSize.setPreferredSize(new Dimension(150, 200));
		panel_FontSize.add(fontSize);
		panel_FontSize.add(text_FontSize);
		panel_FontSize.add(fontSizeList);
		// 在示例平板上添加示例文字的组件
		panel_FontSize.setAlignmentX(FlowLayout.LEFT);
		panel_FontExample.setPreferredSize(new Dimension(30, 130));
		panel_FontExample.add(example);
		panel_FontExample.add(exampleFont);
		// 增加按钮监视器
		ok.addActionListener(this);
		canel.addActionListener(this);
		// 在按钮平板上增加确定和取消按钮
		panel_FontExample.setPreferredSize(new Dimension(200, 150));
		panel_Button.add(ok);
		panel_Button.add(canel);
		fontDialog.setLayout(new FlowLayout());
		fontDialog.add(panel_Font);
		fontDialog.add(panel_FontShape);
		fontDialog.add(panel_FontSize);
		fontDialog.add(panel_FontExample);
		fontDialog.add(panel_Button);
		fontDialog.setVisible(true);
		fontDialog.setResizable(false);
	}

	// 字体监视器的实现
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int style = 0;
		if (fontShapeList.getSelectedItem().equals("常规") == true) {
			style = Font.PLAIN;
		}
		if (fontShapeList.getSelectedItem().equals("斜体") == true) {
			style = Font.ITALIC;
		}
		if (fontShapeList.getSelectedItem().equals("粗体") == true) {
			style = Font.BOLD;
		}
		if (fontShapeList.getSelectedItem().equals("粗体 倾斜") == true) {
			style = Font.BOLD + Font.ITALIC;
		}
		if (e.getSource() == fontKindsList) {
			text_FontKinds.setText(fontKindsList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// 设置示例文字

		}
		if (e.getSource() == fontShapeList) {
			text_FontShape.setText(fontShapeList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// 设置示例文字
		}
		if (e.getSource() == fontSizeList) {
			text_FontSize.setText(fontSizeList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// 设置示例文字
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			jishiben.wb.setFont(exampleFont.getFont());// 如果点击确定，设置文本区内的字体跟示例文字的字体一样
			fontDialog.dispose();
		}
		if (e.getSource() == canel) {// 如果点击退出，则退出对话框
			fontDialog.dispose();
		}
	}
}
