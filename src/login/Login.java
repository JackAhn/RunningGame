package login;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import database.DBconnect;
import database.Haveuser;
import gamescreen.Gamescreen;
import gamescreen.Mainscreen;
import plusScreen.Newuser;
import plusScreen.Soundclip;

public class Login extends JFrame implements ActionListener {

	private Font font1 = new Font("�޸�����ü", Font.BOLD, 50);
	private Font font2 = new Font("�޸�����ü", Font.PLAIN, 30);
	private Font font3 = new Font("����", Font.ITALIC, 15);
	String id;
	String nickname;
	EtchedBorder eborder;
	JPanel panel, bguse, login, main, game;
	JLabel lblID, lbpw, lblLogin, bg, lblNewLabel;
	JTextField Jtid;
	JPasswordField Jtpw;
	JButton lg, newuser;
	Soundclip sc;
	Gamescreen gs;
	CardLayout card = new CardLayout();
	Haveuser hu=new Haveuser();
	Login lc;
	int cnt;

	public Login() {
		init();
		setTitle("���ض� �����");
		setSize(1024, 768);
		getContentPane().setLayout(card);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		setResizable(false);
		login = new JPanel();
		login.setSize(1024, 768);
		getContentPane().add("login", login);
		
		eborder = new EtchedBorder(EtchedBorder.RAISED);
		login.setLayout(new CardLayout(0, 0));
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 1018, 733);
		panel_1.setBackground(Color.WHITE);
		login.add(panel_1);
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("Image/DS_index.jpg"));
		lblNewLabel.setBounds(101, 0, 794, 267);
		panel_1.add(lblNewLabel);
		panel = new JPanel();
		panel.setBounds(237, 334, 535, 319);
		panel_1.add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBorder(eborder);

		lblLogin = new JLabel("Login");
		lblLogin.setFont(font1);
		lblLogin.setBounds(213, 22, 130, 60);
		panel.add(lblLogin);

		lblID = new JLabel("ID : ");
		lblID.setFont(font2);
		lblID.setBounds(127, 123, 80, 40);
		panel.add(lblID);

		Jtid = new JTextField();
		Jtid.setHorizontalAlignment(JTextField.CENTER);
		Jtid.setFont(font3);
		Jtid.setBounds(192, 125, 200, 30);
		panel.add(Jtid);

		lbpw = new JLabel("password : ");
		lbpw.setFont(font2);
		lbpw.setBounds(37, 170, 150, 60);
		panel.add(lbpw);

		Jtpw = new JPasswordField();
		Jtpw.setHorizontalAlignment(JTextField.CENTER);
		Jtpw.setBounds(191, 184, 200, 30);
		panel.add(Jtpw);

		lg = new JButton("�α���");
		lg.setBounds(402, 126, 100, 89);
		lg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				cnt=0;
				id = Jtid.getText().trim();
				String pw = Jtpw.getText().trim();
				String query = "SELECT Name, PASSWORD FROM runninggame.user WHERE ID ='" + id + "'";
				try {
					new DBconnect().DBSetting();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "������ ���ӵ��� �ʾҽ��ϴ�.");
				}
				try {
					ResultSet rs = DBconnect.stmt.executeQuery(query);
					while (rs.next()) {
						if (pw.equals(rs.getString("PASSWORD"))) {
							hu.setid(id);
							JOptionPane.showMessageDialog(null, rs.getString("Name") + "��, ȯ���մϴ�");
							Jtid.setText("");
							Jtpw.setText("");
							cnt++;
							mainlayout(cnt);
						}
					}
					if (!rs.next()&&cnt==0) {
						JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
						Jtid.setText("");
						Jtpw.setText("");
					}
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "������ ������ ���� �ʾҽ��ϴ�.");
					e.printStackTrace();
				}
			}
		});
		panel.add(lg);

		newuser = new JButton("ȸ������");
		newuser.setBounds(230, 258, 100, 30);
		newuser.addActionListener(this);
		panel.add(newuser);

		setResizable(false);
		setVisible(true);
	}
	
	public void init() {
		sc = new Soundclip(
				"�ϻ���(daily BGM)(�ηγ��� ��Ʋ���� - Sunbathing) (online-audio-converter.com).mp3",true);
		sc.start();
		cnt=0;
	}

	public static void main(String[] args) {
		new Login();
	}

	public void mainlayout(int cnt) {
		getContentPane().add("main", new Mainscreen(this, sc, hu.getid()));
		sc.close();
		sc=new Soundclip("Cookie Run Main theme Background Music version 2 ��Ű�� ���� ������� ����2 (online-audio-converter.com).mp3", true);
		sc.start();
		card.show(this.getContentPane(), "main");
	}

	public void loginlayout() {
		sc.close();
		sc = new Soundclip(
				"�ϻ���(daily BGM)(�ηγ��� ��Ʋ���� - Sunbathing) (online-audio-converter.com).mp3",true);
		sc.start();
		card.show(this.getContentPane(), "login");
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		new Newuser();
	}
	
	public void closegamescreen(Login lc, Soundclip sc) {
		Login lc2 = lc;
		Soundclip scl, sc2 = sc;
		sc2.close();
		gs.setVisible(false);
		scl=new Soundclip("ȿ���� ������ �״¼Ҹ� 1.mp3",false);
		scl.start();
	}
	
	public void opengamescreen(Login lc, Soundclip sc, String id) {
		Login lc2 = lc;
		Soundclip sc2 = sc;
		String ID = id;
		gs = new Gamescreen(lc2, sc2, ID);
	}
}
