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

public // �滻�ķ���
class SubstitutionMethod implements ActionListener {
	JTextArea wb = new JTextArea();
	// �����滻�Ի���
	JDialog findWindows = new JDialog(Note.js, "�滻");
	// �������ҶԻ������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JLabel fingTips = new JLabel("������ҵ�����");
	JLabel substitutionTips = new JLabel("�������������");
	JTextField findContent = new JTextField(7);
	JTextField substitutionContent = new JTextField(7);
	JButton findDown = new JButton("���²���");
	JButton substitutionEnter = new JButton("����滻");
	JButton substitutionAll = new JButton("ȫ���滻");

	SubstitutionMethod() {

	}

	public void findmethod() {
		// ���ó�ʼ״̬
		findWindows.setVisible(true);
		findWindows.setLocationRelativeTo(Note.js);// ���öԻ���λ�þ���
		findWindows.setSize(280, 190);
		findWindows.setLayout(new FlowLayout());
		findWindows.setResizable(false);// ���öԻ��򲻿��Ե�����С
		// ������
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
		if (e.getSource() == findDown) {// ���²���
			/*
			 * ������һ�����ҵķ����� Pattern
			 * p=Pattern.compile(strFindContent);//���ɲ������ݵļ�������ʽ Matcher
			 * m=p.matcher(strTextAreaContent);//�Բ��ҵ�����Ϊ�ָ������ָ��ı�������
			 * selectionStart=m.start(); int
			 * selectionEnd=selectionStart+strFindContent.length();
			 * strTextAreaContent.substring(selectionEnd);
			 * jishiben.wb.select(selectionStart, selectionEnd);
			 */
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// �õ���ѡ�������ֵ��������²���ƥ������ݵĵ�һ�ַ�������
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "û�ҵ� " + strFindContent);
				jishiben.wb.setCaretPosition(0);// ���ù�귵���ı�����ͷ
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		} else if (e.getSource() == substitutionEnter) {
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// �õ���ѡ�������ֵ��������²���ƥ������ݵĵ�һ�ַ�������
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "û�ҵ� " + strFindContent);
				jishiben.wb.setCaretPosition(0);// ���ù�귵���ı�����ͷ
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
				jishiben.wb.replaceSelection(strSubstitutionContent);
			}
		} else if (e.getSource() == substitutionAll) {
			jishiben.wb.setText(null);
			jishiben.wb.setCaretPosition(0);// ���ù�귵���ı�����ͷ
			int x = strTextAreaContent.lastIndexOf(strFindContent, jishiben.wb.getSelectionEnd());// �õ���ѡ�������ֵ��������Ϸ������ƥ������ݵĵ�һ�ַ�����
			strTextAreaContent.replace(strFindContent, strSubstitutionContent);// ���ȫ���������������ı��ŵ�strTextAreaContent
			jishiben.wb.setText(strTextAreaContent);

		}
	}
}
