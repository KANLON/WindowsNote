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

class FontMethod implements ItemListener, ActionListener {// �����ʵ�ַ���
	// ��������Ի���
	final JDialog fontDialog = new JDialog(Note.js, "����", true);
	JPanel panel_Font = new JPanel();
	JPanel panel_FontShape = new JPanel();
	JPanel panel_FontSize = new JPanel();
	JPanel panel_FontExample = new JPanel();
	JPanel panel_Button = new JPanel();
	JLabel fontKinds = new JLabel("����");
	JLabel fontShape = new JLabel("����");
	JLabel fontSize = new JLabel("��С");
	JLabel example = new JLabel("           ʾ                        ��                          ");
	JTextField text_FontKinds = new JTextField(15);
	JTextField text_FontShape = new JTextField(7);
	JTextField text_FontSize = new JTextField(5);
	JTextArea exampleFont = new JTextArea(2, 6);
	// ��ϵͳ�ڵ��������Ʒŵ��ַ�������
	String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	JButton ok = new JButton("ȷ��");
	JButton canel = new JButton("ȡ��");
	List fontKindsList = new List(8, false);
	List fontShapeList = new List(6, false);
	List fontSizeList = new List(6, false);

	FontMethod() {
		exampleFont.setText("  ʾ���ı�    ");
		fontDialog.setLocationRelativeTo(Note.js);
		fontDialog.setSize(600, 350);
		// ������������б�
		for (int i = 0; i < fontNames.length; i++) {
			fontKindsList.add(fontNames[fontNames.length - i - 1]);
		}
		fontKindsList.select(0);// �趨��ʼ��ѡ��״̬Ϊ��һ��
		text_FontKinds.setText(fontKindsList.getSelectedItem());
		fontKindsList.addItemListener(this);
		// ������ƽ���������������
		panel_Font.setAlignmentX(FlowLayout.LEFT);
		panel_Font.setPreferredSize(new Dimension(210, 200));
		panel_Font.add(fontKinds);
		panel_Font.add(text_FontKinds);
		panel_Font.add(fontKindsList);
		// ��������б�
		fontShapeList.add("����");
		fontShapeList.add("��б");
		fontShapeList.add("����");
		fontShapeList.add("���� ��б");
		fontShapeList.select(0);// �趨��ʼ��ѡ��״̬Ϊ��һ��
		text_FontShape.setText(fontShapeList.getSelectedItem());
		fontShapeList.addItemListener(this);
		// ������ƽ���������������
		panel_FontShape.setAlignmentX(FlowLayout.LEFT);
		panel_FontShape.setPreferredSize(new Dimension(150, 200));
		panel_FontShape.add(fontShape);
		panel_FontShape.add(text_FontShape);
		panel_FontShape.add(fontShapeList);

		// ��������С�б�
		for (int i = 8; i < 73; i++) {
			fontSizeList.add(String.valueOf(i));
		}
		fontSizeList.select(5);// �趨��ʼ��ѡ��״̬Ϊ��һ��
		text_FontSize.setText(fontSizeList.getSelectedItem());
		fontSizeList.addItemListener(this);
		// �������Сƽ�������������С���
		panel_FontSize.setAlignmentX(FlowLayout.LEFT);
		panel_FontSize.setPreferredSize(new Dimension(150, 200));
		panel_FontSize.add(fontSize);
		panel_FontSize.add(text_FontSize);
		panel_FontSize.add(fontSizeList);
		// ��ʾ��ƽ�������ʾ�����ֵ����
		panel_FontSize.setAlignmentX(FlowLayout.LEFT);
		panel_FontExample.setPreferredSize(new Dimension(30, 130));
		panel_FontExample.add(example);
		panel_FontExample.add(exampleFont);
		// ���Ӱ�ť������
		ok.addActionListener(this);
		canel.addActionListener(this);
		// �ڰ�ťƽ��������ȷ����ȡ����ť
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

	// �����������ʵ��
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		int style = 0;
		if (fontShapeList.getSelectedItem().equals("����") == true) {
			style = Font.PLAIN;
		}
		if (fontShapeList.getSelectedItem().equals("б��") == true) {
			style = Font.ITALIC;
		}
		if (fontShapeList.getSelectedItem().equals("����") == true) {
			style = Font.BOLD;
		}
		if (fontShapeList.getSelectedItem().equals("���� ��б") == true) {
			style = Font.BOLD + Font.ITALIC;
		}
		if (e.getSource() == fontKindsList) {
			text_FontKinds.setText(fontKindsList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// ����ʾ������

		}
		if (e.getSource() == fontShapeList) {
			text_FontShape.setText(fontShapeList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// ����ʾ������
		}
		if (e.getSource() == fontSizeList) {
			text_FontSize.setText(fontSizeList.getSelectedItem());
			exampleFont.setFont(
					new Font(fontKindsList.getSelectedItem(), style, Integer.valueOf(fontSizeList.getSelectedItem())));// ����ʾ������
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ok) {
			jishiben.wb.setFont(exampleFont.getFont());// ������ȷ���������ı����ڵ������ʾ�����ֵ�����һ��
			fontDialog.dispose();
		}
		if (e.getSource() == canel) {// �������˳������˳��Ի���
			fontDialog.dispose();
		}
	}
}
