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
	
	private Font font1 = new Font("�޸�����ü", Font.BOLD, 50);
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
		gamename = new JLabel("���ض� �����");
		gamename.setBounds(636, 54, 333, 121);
		gamename.setFont(font1);
		gamename.setForeground(Color.WHITE);
		add(gamename);
		
		help=new JButton("���� ���");
		help.setBounds(67, 575, 163, 55);
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Information();
			}
		});
		add(help);
		
		deletemember = new JButton("ȸ�� Ż��");
		deletemember.setBounds(847, 21, 163, 55);
		deletemember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String query = "DELETE FROM runninggame.user WHERE ID ='" + ID + "'";
					try {
						DBconnect.stmt.executeUpdate(query);
						JOptionPane.showMessageDialog(null, "ȸ�� Ż�� �Ϸ�Ǿ����ϴ�.");
						lc.loginlayout();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			
		});
		add(deletemember);
		
		rank=new JButton("����");
		rank.setBounds(806, 575, 163, 55);
		rank.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new Rankscreen();
			}
		});
		add(rank);
		
		gamestart=new JButton("���� ����");
		gamestart.setBounds(435, 575, 163, 55);
		gamestart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sc2=new Soundclip("ī��Ʈ�ٿ�.mp3", false);
				sc2.start();
				lc.setVisible(false);
				lc.opengamescreen(lc, sc2, ID);
			}
		});
		add(gamestart);
		
		changeuser = new JButton("ȸ������ ����");
		changeuser.setBounds(435, 21, 163, 55);
		changeuser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Changescreen(ID);
			}
			
		});
		add(changeuser);
		
		logout=new JButton("�α׾ƿ�");
		logout.setBounds(14, 26, 163, 55);
		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "�α׾ƿ� �Ǿ����ϴ�.");
				lc.loginlayout();
			}
		});
		add(logout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("Image/�����Ѹ���11.gif"));
		label.setBounds(-37, 242, 348, 439);
		add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("Image/�ı���_��׽ý�_����.png"));
		label_1.setBounds(0, 0, 1024, 768);
		add(label_1);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
