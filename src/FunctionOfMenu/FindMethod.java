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

//���ҵķ���
public class FindMethod implements ActionListener {
	// �������ҶԻ���
	JDialog findWindows = new JDialog(Note.js, "����");
	// �������ҶԻ������
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JLabel fingTips = new JLabel("����Ҫ�ҵ�����");
	// JLabel substitutionTips=new JLabel("�������������");
	// JLabel lb=new JLabel("");
	JTextField findContent = new JTextField(15);
	// JTextField substitutionContent=new JTextField(7);
	JButton findDown = new JButton("���²���");
	JButton findUp = new JButton("���ϲ���");
	JButton substitutionEnter = new JButton("�滻");

	FindMethod() {
		// ���ó�ʼ״̬
		findWindows.setVisible(true);
		findWindows.setLocationRelativeTo(Note.js);// ���öԻ���λ�þ���
		findWindows.setSize(280, 110);
		findWindows.setLayout(new FlowLayout());
		findWindows.setResizable(false);
		// ������
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
			 * Pattern p=Pattern.compile(strFindContent);//���ɲ������ݵļ�������ʽ
			 * Matcher m=p.matcher(strTextAreaContent);//�Բ��ҵ�����Ϊ�ָ������ָ��ı�������
			 * selectionStart=m.start(); int
			 * selectionEnd=selectionStart+strFindContent.length();
			 * strTextAreaContent.substring(selectionEnd);
			 * jishiben.wb.select(selectionStart, selectionEnd);
			 */
			int x = strTextAreaContent.indexOf(strFindContent, jishiben.wb.getSelectionEnd());// �õ���ѡ�������ֵ��������²���ƥ������ݵĵ�һ�ַ�������
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "û�ҵ� " + strFindContent);
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		} else if (e.getSource() == findUp) {
			int x = strTextAreaContent.lastIndexOf(strFindContent,
					jishiben.wb.getSelectionEnd() - strFindContent.length() - 1);// �õ���ѡ�������ֵ��������Ϸ������ƥ������ݵĵ�һ�ַ�������
			if (x == -1) {
				JOptionPane.showConfirmDialog(null, "û�ҵ� " + strFindContent);
			} else {
				jishiben.wb.setSelectionStart(x);
				jishiben.wb.setSelectionEnd(x + strFindContent.length());
			}
		}
	}
}
