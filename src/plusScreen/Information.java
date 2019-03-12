package plusScreen;



import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Information extends JDialog{
	JLabel infor1, infor2, infor3, infor4, infor6, infor7, infor8, infor9;
	JButton check;
	
	private Font font= new Font("경기천년제목",Font.BOLD,15);
	public Information() {
		setSize(500,600);
		setTitle("게임 방법");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		infor1=new JLabel("장애물을 피하는 게임입니다.");
		infor1.setBounds(89, 93, 297, 30);
		infor1.setHorizontalAlignment(infor1.CENTER);
		infor1.setFont(font);
		getContentPane().add(infor1);
		
		infor2=new JLabel("송곳은 방향키(↑)로 피합니다.");
		infor2.setBounds(89, 135, 297, 30);
		infor2.setHorizontalAlignment(infor2.CENTER);
		infor2.setFont(font);
		getContentPane().add(infor2);
		
		infor3=new JLabel("허들은 방향키(↑)로 피합니다.");
		infor3.setBounds(89, 184, 297, 30);
		infor3.setHorizontalAlignment(infor3.CENTER);
		infor3.setFont(font);
		getContentPane().add(infor3);
		
		infor4=new JLabel("방향키를 꼭 누르셔야 합니다.");
		infor4.setBounds(89, 229, 297, 30);
		infor4.setHorizontalAlignment(infor4.CENTER);
		infor4.setFont(font);
		getContentPane().add(infor4);
		
		infor6=new JLabel("각 장애물을 피할 때마다 점수가 증가됩니다.");
		infor6.setBounds(63, 275, 353, 30);
		infor6.setHorizontalAlignment(infor6.CENTER);
		infor6.setFont(font);
		getContentPane().add(infor6);
		setVisible(true);
		
		infor7=new JLabel("장애물을 피하지 못하거나 제거하지 못하면 HP가 감소합니다.");
		infor7.setBounds(27, 326, 435, 30);
		infor7.setHorizontalAlignment(infor7.CENTER);
		infor7.setFont(font);
		getContentPane().add(infor7);
		setVisible(true);
		
		infor8=new JLabel("HP가 0이 되면 게임은 종료됩니다.");
		infor8.setBounds(97, 368, 297, 30);
		infor8.setHorizontalAlignment(infor8.CENTER);
		infor8.setFont(font);
		getContentPane().add(infor8);
		
		infor9=new JLabel("행운을 빕니다.");
		infor9.setBounds(89, 414, 297, 30);
		infor9.setHorizontalAlignment(infor9.CENTER);
		infor9.setFont(font);
		getContentPane().add(infor9);
		
		setResizable(false);
		setVisible(true);

	}
}
