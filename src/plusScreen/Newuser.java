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
	private Font font1 = new Font("HY견고딕", Font.PLAIN, 50);
	private Font font2 = new Font("휴먼편지체", Font.ITALIC, 15);
	private Font font3 = new Font("휴먼모음T", Font.PLAIN, 20);
	private Font font4 = new Font("굴림", Font.ITALIC, 15);
	private Font font5 = new Font("휴먼편지체", Font.BOLD, 15);
	private JButton check;

	public Newuser() {

		setSize(500, 500);
		setTitle("회원가입");
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

		title = new JLabel("회원가입");
		title.setBounds(145, 12, 212, 58);
		getContentPane().add(title);
		title.setFont(font1);

		another = new JLabel("함께 게임을 즐겨요!");
		another.setBounds(185, 47, 212, 58);
		another.setFont(font2);
		getContentPane().add(another);

		name = new JLabel("닉네임");
		name.setFont(new Font("휴먼모음T", Font.PLAIN, 20));
		name.setBounds(45, 38, 150, 50);
		panel.add(name);

		nametext = new JTextField();
		nametext.setColumns(10);
		nametext.setHorizontalAlignment(nametext.CENTER);
		nametext.setFont(font4);
		nametext.setBounds(158, 49, 150, 30);
		panel.add(nametext);

		ex1 = new JLabel("※닉네임은 최소 2자에서 최대 10자까지 가능합니다");
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
		idtext.setFont(new Font("굴림", Font.ITALIC, 15));
		idtext.setColumns(10);
		idtext.setBounds(160, 116, 150, 30);
		panel.add(idtext);

		ex2 = new JLabel("※ID는 최소 4자에서 최대 12자까지 가능합니다");
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

		ex3 = new JLabel("※Password는 최소 6자에서 최대 20자까지 가능합니다");
		ex3.setBounds(6, 219, 500, 50);
		ex3.setFont(font5);
		ex3.setForeground(Color.RED);
		panel.add(ex3);

		check = new JButton("확인");
		check.setBounds(144, 273, 94, 30);
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = nametext.getText();
				String id = idtext.getText();
				String pw = pwtext.getText();
				if (name.length() > 10) {
					JOptionPane.showMessageDialog(null, "닉네임이 너무 깁니다.");
					nametext.setText("");
					return;
				} else if (name.length() == 0) {
					JOptionPane.showMessageDialog(null, "닉네임을 입력해 주세요.");
					return;
				} else if (name.length() < 2) {
					JOptionPane.showMessageDialog(null, "닉네임이 너무 짧습니다.");
					nametext.setText("");
					return;
				} else if (id.length() > 12) {
					JOptionPane.showMessageDialog(null, "id가 너무 깁니다.");
					idtext.setText("");
					return;
				} else if (id.length() == 0) {
					JOptionPane.showMessageDialog(null, "id를 입력해 주세요.");
					return;
				} else if (id.length() < 4) {
					JOptionPane.showMessageDialog(null, "id가 너무 짧습니다.");
					idtext.setText("");
					return;
				} else if (pw.length() > 20) {
					JOptionPane.showMessageDialog(null, "비밀번호가 너무 깁니다.");
					pwtext.setText("");
					return;
				} else if (pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "비밀번호를 입력해 주세요.");
					return;
				} else if (pw.length() < 6) {
					JOptionPane.showMessageDialog(null, "비밀번호가 너무 짧습니다.");
					pwtext.setText("");
					return;
				} else {
					Storeuser st = new Storeuser();
					if (st.store(name, id, pw) == 1) {
						JOptionPane.showMessageDialog(null, name + "님, 회원가입 하신 것을 환영합니다!");
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