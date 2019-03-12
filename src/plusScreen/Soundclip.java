package plusScreen;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;
import login.Login;

public class Soundclip extends Thread {
	private Player player;
	private boolean loop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public Soundclip(String name, boolean isLoop) {
		try {
			this.loop = isLoop;
			file = new File(Login.class.getResource("../music/"+name).toURI());
			fis = new FileInputStream(file);
			bis=new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}

	public void close() {
		loop = false;
		player.close();
		this.interrupt();
	}

	@Override
	public void run() {
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (loop);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
