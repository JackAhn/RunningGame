package gamescreen;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import login.Login;
import plusScreen.Result;
import plusScreen.Soundclip;

public class Gamescreen extends JFrame{
	Login lc2;
	Soundclip sc2;
	CardLayout card;
	String ID;
	
	public Gamescreen(Login lc, Soundclip sc, String id) {
		lc2=lc;
		sc2=sc;
		ID = id;
		setSize(1024,768);
		setTitle("피해라 졸라맨 클라이언트");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(2);
		setLayout(null);
		setResizable(false);
		Playscreen ps = new Playscreen(lc2, sc2, ID);
		ps.addKeyListener(ps);
		ps.setFocusable(true);
		add(ps);
		setVisible(true);
	}
}

class Enemy {
	int x;
	int y;
	int speed;

	Enemy(int x, int y, int speed) {
		this.x = x;
		this.y = y;
		this.speed = speed;
	}

	public void move() {
		x -= speed;
	}
}

class Playscreen extends JPanel implements KeyListener, Runnable{
	int f_width, f_height;
	int x, y;
	int gamescore;
	int hp;
	int enemy_speed;
	int cnt;
	int cunt;
	int cont;
	int sped;
	int ct;
	Gamescreen gs;
	JLabel count;
	Dimension screen;
	JPanel game_count;
	Image[] player;
	Image[] enemy;
	Image background;
	Image buffimage;
	Graphics buffg;
	Thread th;
	Login lc;
	String ID;
	ArrayList Enemy_List = new ArrayList();
	Enemy en;
	boolean KeyUp = false;
	boolean KeyCtrl = false;
	Soundclip sc2, scl;
	JProgressBar health_point;
	private Font font = new Font("경기천년제목", Font.BOLD, 40);
	int t;
	
	public Playscreen(Login loginscreen, Soundclip sc, String id) {
		lc=loginscreen;
		sc2=sc;
		ID = id;
		init();
		setSize(f_width, f_height);
		setLayout(null);
		setVisible(true);
		Start();
	}

	public void init() {
		cnt=1;
		f_width = 1024;
		f_height = 768;
		x = 100;
		y = 480;
		cnt = 0;
		cunt = 0;
		cont = 0;
		ct = 3;
		gamescore = 0;
		sped = 100;
		player = new Image[3];
		player[0] = new ImageIcon("Image/졸라맨1.png").getImage();
		enemy = new Image[3];
		enemy[0] = new ImageIcon("Image/장애물3.png").getImage();
		background = new ImageIcon("Image/게임맵.jpg").getImage();
		gamescore = 0;
		enemy_speed = 25;
		hp = 100;
		t=1;
	}

	public void Start() {
		th = new Thread(this);
		th.start();
	}

	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (true) {
				Enemycontrol();
				Playercontrol();
				HPcontrol();
				repaint();
				Thread.sleep(20);
				cunt++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public void paint(Graphics g) {
		buffimage = createImage(f_width, f_height);
		buffg = buffimage.getGraphics();
		update(g);
	}

	public void update(Graphics g) {
		DrawBackground();
		DrawCharacter();
		DrawEnemy();
		Drawsituation();
		g.drawImage(buffimage, 0, 0, this);
	}

	public void DrawBackground() {
		buffg.clearRect(0, 0, f_width, f_height);
		buffg.drawImage(background, 0, 0, this);
	}

	public void DrawCharacter() {
		buffg.drawImage(player[0], x, y, 100, 200, this);
		if(KeyUp==true) {
			if(t==1) {
				scl=new Soundclip("효과음 마리오 점프 1 (online-audio-converter.com).mp3", false);
				scl.start();
				t++;
			}
			y-=10;
			if(y<200)
				y=480;
		}
		else if(KeyUp==false)
			y=480;
	}

	public void DrawEnemy() {
		for (int i = 0; i < Enemy_List.size(); ++i) {
			en = (Enemy) (Enemy_List.get(i));
			buffg.drawImage(enemy[0], en.x, en.y, this);
		}
	}

	public void Drawsituation() {
		buffg.setFont(font);
		buffg.drawString("Score : " + gamescore, 450, 70);
		buffg.drawString("HP : " + hp, 20, 70);
	}

	public void Playercontrol() {
		if (!hit(x, y, en.x, en.y, player[0], enemy[0]) && (en.x > 98 && en.x < 100)) {
			gamescore += 100;
			scl=new Soundclip("Super mario sound effect.mp3",false);
			scl.start();
		}
	}

	public void Enemycontrol() {
		for (int i = 0; i < Enemy_List.size(); ++i) {
			en = (Enemy) (Enemy_List.get(i));
			en.move();
			if (en.x < -200) {
				Enemy_List.remove(i);
			}
			if (hit(x, y, en.x, en.y, player[0], enemy[0])) {
				Enemy_List.remove(i);
				scl=new Soundclip("폭발.mp3",false);
				scl.start();
				hp -= 20;
				if (gamescore > 0) {
					gamescore -= 100;
				}
			}
		}

		if (cunt % sped == 0) {
			en = new Enemy(f_width + 100, 500, enemy_speed);
			Enemy_List.add(en);
		}
		if(cunt>=5000) {
			enemy_speed+=50;
		}
		else if(cunt>=10000) {
			enemy_speed+=10;
		}
		else if(cunt>=15000) {
			enemy_speed+=10;
		}
		else if(cunt>=20000) {
			enemy_speed+=10;
		}
		else if(cunt>=25000) {
			enemy_speed+=10;
		}
	}
	
	public void HPcontrol() {
		if(hp==0) {
			lc.closegamescreen(lc, sc2);
			new Result(lc, sc2, gamescore, ID);
			th.interrupt();
			hp=100;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp=true;
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp = false;
			t=1;
			break;
		case KeyEvent.VK_CONTROL:
			KeyCtrl = false;
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public boolean hit(int x1, int y1, int x2, int y2, Image img1, Image img2) {
		boolean check = false;
		if (Math.abs((x1 + img1.getWidth(null) / 4) - (x2 + img2.getWidth(null) / 4)) < (img2.getWidth(null) / 4
				+ img1.getWidth(null) / 4)
				&& Math.abs((y1 + img1.getHeight(null) / 4)
						- (y2 + img2.getHeight(null) / 4)) < (img2.getHeight(null) / 4 + img1.getHeight(null) / 4)) {
			check = true;
		} else
			check = false;
		return check;
	}
}
