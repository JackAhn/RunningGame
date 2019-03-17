package gamescreen;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import database.DBconnect;
import login.Login;
import plusScreen.Changescreen;
import plusScreen.Information;
import plusScreen.Rankscreen;
import plusScreen.Soundclip;

public class Mainscreen extends JPanel implements ActionListener{
	
	private Font font1 = new Font("휴먼편지체", Font.BOLD, 50);
	JLabel gamename, welcome;
	JButton help, gamestart, rank, logout, deletemember, changeuser;
	Login lc;
	Soundclip sc2;
	Gamescreen gs;
	String ID;

	public Mainscreen(Login loginscreen, Soundclip sc, String id) {
		setSize(1024,768);
		setBackground(Color.WHITE);
		setLayout(null);

		lc = loginscreen;
		sc2 = sc;
		ID = id;
		gamename = new JLabel("피해라 졸라맨");
		gamename.setBounds(636, 54, 333, 121);
		gamename.setFont(font1);
		gamename.setForeground(Color.WHITE);
		add(gamename);
		
		help=new JButton("게임 방법");
		help.setBounds(67, 575, 163, 55);
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Information();
			}
		});
		add(help);
		
		deletemember = new JButton("회원 탈퇴");
		deletemember.setBounds(847, 21, 163, 55);
		deletemember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM runninggame.user WHERE ID ='" + ID + "'";
					try {
						DBconnect.stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "회원 탈퇴가 완료되었습니다.");
						lc.loginlayout();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
		});
		add(deletemember);
		
		rank=new JButton("순위");
		rank.setBounds(806, 575, 163, 55);
		rank.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Rankscreen();
			}
		});
		add(rank);
		
		gamestart=new JButton("게임 시작");
		gamestart.setBounds(435, 575, 163, 55);
		gamestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sc2=new Soundclip("카운트다운.mp3", false);
				sc2.start();
				lc.setVisible(false);
				lc.opengamescreen(lc, sc2, ID);
			}
		});
		add(gamestart);
		
		changeuser = new JButton("회원정보 수정");
		changeuser.setBounds(435, 21, 163, 55);
		changeuser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Changescreen(ID);
			}
			
		});
		add(changeuser);
		
		logout=new JButton("로그아웃");
		logout.setBounds(14, 26, 163, 55);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				lc.loginlayout();
			}
		});
		add(logout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Image/날씬한몸매11.gif"));
		label.setBounds(-37, 242, 348, 439);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Image/파괴된_헤네시스_공원.png"));
		label_1.setBounds(0, 0, 1024, 768);
		add(label_1);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
