package plusScreen;

import database.Storeuser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

public class Newuser extends JDialog implements ActionListener {

	private JPanel panel;
	private JLabel title, another, name, id, pw, ex1, ex2, ex3;
	private JTextField idtext, nametext;
	private JPasswordField pwtext;
	private Font font1 = new Font("HY�߰��", Font.PLAIN, 50);
	private Font font2 = new Font("�޸�����ü", Font.ITALIC, 15);
	private Font font3 = new Font("�޸ո���T", Font.PLAIN, 20);
	private Font font4 = new Font("����", Font.ITALIC, 15);
	private Font font5 = new Font("�޸�����ü", Font.BOLD, 15);
	private JButton check;

	public Newuser() {

		setSize(500, 500);
		setTitle("ȸ������");
		setDefaultCloseOperation(2);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);

		panel = new JPanel();
		panel.setBounds(62, 93, 371, 326);
		panel.setLayout(null);
		panel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);

		title = new JLabel("ȸ������");
		title.setBounds(145, 12, 212, 58);
		getContentPane().add(title);
		title.setFont(font1);

		another = new JLabel("�Բ� ������ ��ܿ�!");
		another.setBounds(185, 47, 212, 58);
		another.setFont(font2);
		getContentPane().add(another);

		name = new JLabel("�г���");
		name.setFont(new Font("�޸ո���T", Font.PLAIN, 20));
		name.setBounds(45, 38, 150, 50);
		panel.add(name);

		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setHorizontalAlignment(nametext.CENTER);
		nametext.setFont(font4);
		nametext.setBounds(158, 49, 150, 30);
		panel.add(nametext);

		ex1 = new JLabel("�شг����� �ּ� 2�ڿ��� �ִ� 10�ڱ��� �����մϴ�");
		ex1.setBounds(20, 72, 500, 50);
		ex1.setFont(font5);
		ex1.setForeground(Color.RED);
		panel.add(ex1);

		id = new JLabel("ID");
		id.setBounds(56, 111, 70, 40);
		id.setFont(font3);
		panel.add(id);

		idtext = new JTextField();
		idtext.setHorizontalAlignment(SwingConstants.CENTER);
		idtext.setFont(new Font("����", Font.ITALIC, 15));
		idtext.setColumns(10);
		idtext.setBounds(160, 116, 150, 30);
		panel.add(idtext);

		ex2 = new JLabel("��ID�� �ּ� 4�ڿ��� �ִ� 12�ڱ��� �����մϴ�");
		ex2.setBounds(29, 145, 500, 50);
		ex2.setFont(font5);
		ex2.setForeground(Color.RED);
		panel.add(ex2);

		pw = new JLabel("Password");
		pw.setBounds(24, 188, 101, 40);
		pw.setFont(font3);
		panel.add(pw);

		pwtext = new JPasswordField();
		pwtext.setColumns(10);
		pwtext.setBounds(158, 194, 150, 30);
		pwtext.setHorizontalAlignment(pwtext.CENTER);
		pwtext.setFont(font4);
		panel.add(pwtext);

		ex3 = new JLabel("��Password�� �ּ� 6�ڿ��� �ִ� 20�ڱ��� �����մϴ�");
		ex3.setBounds(6, 219, 500, 50);
		ex3.setFont(font5);
		ex3.setForeground(Color.RED);
		panel.add(ex3);

		check = new JButton("Ȯ��");
		check.setBounds(144, 273, 94, 30);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = nametext.getText();
				String id = idtext.getText();
				String pw = pwtext.getText();
				if (name.length() > 10) {
					JOptionPane.showMessageDialog(null, "�г����� �ʹ� ��ϴ�.");
					nametext.setText("");
					return;
				} else if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "�г����� �Է��� �ּ���.");
					return;
				} else if (name.length() < 2) {
					JOptionPane.showMessageDialog(null, "�г����� �ʹ� ª���ϴ�.");
					nametext.setText("");
					return;
				} else if (id.length() > 12) {
					JOptionPane.showMessageDialog(null, "id�� �ʹ� ��ϴ�.");
					idtext.setText("");
					return;
				} else if (id.length() == 0) {
					JOptionPane.showMessageDialog(null, "id�� �Է��� �ּ���.");
					return;
				} else if (id.length() < 4) {
					JOptionPane.showMessageDialog(null, "id�� �ʹ� ª���ϴ�.");
					idtext.setText("");
					return;
				} else if (pw.length() > 20) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ʹ� ��ϴ�.");
					pwtext.setText("");
					return;
				} else if (pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �Է��� �ּ���.");
					return;
				} else if (pw.length() < 6) {
					JOptionPane.showMessageDialog(null, "��й�ȣ�� �ʹ� ª���ϴ�.");
					pwtext.setText("");
					return;
				} else {
					Storeuser st = new Storeuser();
					if (st.store(name, id, pw) == 1) {
						JOptionPane.showMessageDialog(null, name + "��, ȸ������ �Ͻ� ���� ȯ���մϴ�!");
						setVisible(false);
						dispose();
					}
				}
			}
		});
		panel.add(check);
	}

	public static void main(String[] args) {
		new Newuser();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}