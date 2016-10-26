package FunctionOfMenu;
import Frame.jishiben;
import Frame.Note;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//查找的方法
public class FindMethod implements ActionListener {
	// 创建查找对话框
	JDialog findWindows = new JDialog(Note.js, "查找");
	// 创建查找对话框组件
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel fingTips = new JLabel("输入要找的内容");
	// JLabel substitutionTips=new JLabel("输入替代的内容");
	// JLabel lb=new JLabel("");
	JTextField findContent = new JTextField(15);
	// JTextField substitutionContent=new JTextField(7);
	JButton findDown = new JButton("向下查找");
	JButton findUp = new JButton("向上查找");
	JButton substitutionEnter = new JButton("替换");

	FindMethod() {
		// 设置初始状态
		findWindows.setVisible(true);
		findWindows.setLocationRelativeTo(Note.js);// 设置对话框位置居中
		findWindows.setSize(280, 110);
		findWindows.setLayout(new FlowLayout());
		findWindows.setResizable(false);
		// 添加组件
		findWindows.add(p1);
		findWindows.add(p2);
		p1.add(fingTips);
		p1.add(findContent);
		p2.add(findDown);
		p2.add(findUp);
		findDown.addActionListener(this);
		substitutionEnter.addActionListener(this);
		findUp.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		String strTextAreaContent = jishiben.wb.getText();
		String strFindContent = findContent.getText();
		if (e.getSource() == findDown) {
			/*
			 * Pattern p=Pattern.compile(strFindContent);//生成查找内容的简单正则表达式
			 * Matcher m=p.matcher(strTextAreaContent);//以查找的内容为分隔符，分隔文本区内容
			 * selectionStart=m.start(); int
			 * selectionEnd=selectionStart+strFindContent.length();
			 * strTextAreaContent.substring(selectionEnd);
			 * jishiben.wb.select(selectionStart, selectionEnd);
			 */
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// 得到已选定的文字的索引向下查找匹配的内容的第一字符的索引
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "没找到 " + strFindContent);
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		} else if (e.getSource() == findUp) {
			int x = strTextAreaContent.lastIndexOf(strFindContent,
					jishiben.wb.getSelectionEnd() - strFindContent.length() - 1);// 得到已选定的文字的索引向上反向查找匹配的内容的第一字符的索引
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "没找到 " + strFindContent);
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		}
	}
}
