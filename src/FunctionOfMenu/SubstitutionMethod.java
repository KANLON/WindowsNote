package FunctionOfMenu;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Frame.Note;
import Frame.jishiben;

public // 替换的方法
class SubstitutionMethod implements ActionListener {
	JTextArea wb = new JTextArea();
	// 创建替换对话框
	JDialog findWindows = new JDialog(Note.js, "替换");
	// 创建查找对话框组件
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel fingTips = new JLabel("输入查找的内容");
	JLabel substitutionTips = new JLabel("输入替代的内容");
	JTextField findContent = new JTextField(7);
	JTextField substitutionContent = new JTextField(7);
	JButton findDown = new JButton("向下查找");
	JButton substitutionEnter = new JButton("逐个替换");
	JButton substitutionAll = new JButton("全部替换");

	SubstitutionMethod() {

	}

	public void findmethod() {
		// 设置初始状态
		findWindows.setVisible(true);
		findWindows.setLocationRelativeTo(Note.js);// 设置对话框位置居中
		findWindows.setSize(280, 190);
		findWindows.setLayout(new FlowLayout());
		findWindows.setResizable(false);// 设置对话框不可以调整大小
		// 添加组件
		findWindows.add(p1);
		findWindows.add(p2);
		findWindows.add(p3);
		p1.add(fingTips);
		p1.add(findContent);
		p1.add(findDown);
		p2.add(substitutionTips);
		p2.add(substitutionContent);
		p2.add(substitutionEnter);
		p3.add(substitutionAll);
		findDown.addActionListener(this);
		substitutionEnter.addActionListener(this);
		substitutionAll.addActionListener(this);

	}

	public void setTextArea(JTextArea wb1) {
		wb = wb1;
	}

	public void actionPerformed(ActionEvent e) {
		String strTextAreaContent = jishiben.wb.getText();
		String strFindContent = findContent.getText();
		String strSubstitutionContent = substitutionContent.getText();
		if (e.getSource() == findDown) {// 向下查找
			/*
			 * 网上另一个查找的方法， Pattern
			 * p=Pattern.compile(strFindContent);//生成查找内容的简单正则表达式 Matcher
			 * m=p.matcher(strTextAreaContent);//以查找的内容为分隔符，分隔文本区内容
			 * selectionStart=m.start(); int
			 * selectionEnd=selectionStart+strFindContent.length();
			 * strTextAreaContent.substring(selectionEnd);
			 * jishiben.wb.select(selectionStart, selectionEnd);
			 */
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// 得到已选定的文字的索引向下查找匹配的内容的第一字符的索引
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "没找到 " + strFindContent);
				jishiben.wb.setCaretPosition(0);// 设置光标返回文本区开头
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		} else if (e.getSource() == substitutionEnter) {
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// 得到已选定的文字的索引向下查找匹配的内容的第一字符的索引
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "没找到 " + strFindContent);
				jishiben.wb.setCaretPosition(0);// 设置光标返回文本区开头
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
				jishiben.wb.replaceSelection(strSubstitutionContent);
			}
		} else if (e.getSource() == substitutionAll) {
			jishiben.wb.setText(null);
			jishiben.wb.setCaretPosition(0);// 设置光标返回文本区开头
			int x = strTextAreaContent.lastIndexOf(strFindContent, jishiben.wb.getSelectionEnd());// 得到已选定的文字的索引向上反向查找匹配的内容的第一字符的索
			strTextAreaContent.replace(strFindContent, strSubstitutionContent);// 替代全部，并将替代后的文本放到strTextAreaContent
			jishiben.wb.setText(strTextAreaContent);

		}
	}
}
