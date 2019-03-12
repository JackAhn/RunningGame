package plusScreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import database.DBconnect;
import gamescreen.Gamescreen;
import login.Login;

public class Result extends JDialog implements ActionListener {

	private Font font = new Font("HY�߰��", Font.PLAIN, 60);
	private Font font2 = new Font("�޸�����ü", Font.PLAIN, 40);
	Login lc2;
	Gamescreen gs;
	int score;
	JButton back;
	JLabel printscore, quest;
	JPanel inside;
	EtchedBorder eborder;
	Soundclip sc, sc2;
	String ID;
	store st;
	int cnt = 0;

	public Result(Login lc, Soundclip sc, int gamescore, String id) {
		lc2 = lc;
		sc2 = sc;
		score = gamescore;
		ID = id;
		eborder = new EtchedBorder(EtchedBorder.RAISED);

		setSize(500, 400);
		setTitle("���� ���");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		setResizable(false);

		inside = new JPanel();
		inside.setLayout(null);
		inside.setBorder(eborder);
		inside.setBounds(21, 24, 443, 306);
		getContentPane().add(inside);

		printscore = new JLabel("���� : " + score);
		printscore.setHorizontalAlignment(printscore.CENTER);
		printscore.setBounds(41, 45, 375, 71);
		printscore.setFont(font);
		inside.add(printscore);

		quest = new JLabel("��� ���ҽ��ϴ�");
		quest.setHorizontalAlignment(quest.CENTER);
		quest.setBounds(72, 167, 322, 49);
		quest.setFont(font2);
		inside.add(quest);

		back = new JButton("���� ȭ������");
		back.setLayout(null);
		back.setBounds(169, 249, 126, 30);
		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				lc.mainlayout(cnt);
				lc.setVisible(true);
			}
		});
		inside.add(back);

		st = new store(ID, score);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}

class store {
	store(String id, int gamescore) {
		String ID = id;
		int score = gamescore;
		try {
			new DBconnect().DBSetting();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
		String command = "INSERT INTO rank (Name, Score) VALUES";
		try {
			DBconnect.stmt.execute("USE runninggame");
			command += "('" + id + "','" + gamescore + "')";
			DBconnect.stmt.executeUpdate(command);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
