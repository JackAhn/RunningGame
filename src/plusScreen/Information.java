package plusScreen;



import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class Information extends JDialog{
	JLabel infor1, infor2, infor3, infor4, infor6, infor7, infor8, infor9;
	JButton check;
	
	private Font font= new Font("���õ������",Font.BOLD,15);
	public Information() {
		setSize(500,600);
		setTitle("���� ���");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		infor1=new JLabel("��ֹ��� ���ϴ� �����Դϴ�.");
		infor1.setBounds(89, 93, 297, 30);
		infor1.setHorizontalAlignment(infor1.CENTER);
		infor1.setFont(font);
		getContentPane().add(infor1);
		
		infor2=new JLabel("�۰��� ����Ű(��)�� ���մϴ�.");
		infor2.setBounds(89, 135, 297, 30);
		infor2.setHorizontalAlignment(infor2.CENTER);
		infor2.setFont(font);
		getContentPane().add(infor2);
		
		infor3=new JLabel("����� ����Ű(��)�� ���մϴ�.");
		infor3.setBounds(89, 184, 297, 30);
		infor3.setHorizontalAlignment(infor3.CENTER);
		infor3.setFont(font);
		getContentPane().add(infor3);
		
		infor4=new JLabel("����Ű�� �� �����ž� �մϴ�.");
		infor4.setBounds(89, 229, 297, 30);
		infor4.setHorizontalAlignment(infor4.CENTER);
		infor4.setFont(font);
		getContentPane().add(infor4);
		
		infor6=new JLabel("�� ��ֹ��� ���� ������ ������ �����˴ϴ�.");
		infor6.setBounds(63, 275, 353, 30);
		infor6.setHorizontalAlignment(infor6.CENTER);
		infor6.setFont(font);
		getContentPane().add(infor6);
		setVisible(true);
		
		infor7=new JLabel("��ֹ��� ������ ���ϰų� �������� ���ϸ� HP�� �����մϴ�.");
		infor7.setBounds(27, 326, 435, 30);
		infor7.setHorizontalAlignment(infor7.CENTER);
		infor7.setFont(font);
		getContentPane().add(infor7);
		setVisible(true);
		
		infor8=new JLabel("HP�� 0�� �Ǹ� ������ ����˴ϴ�.");
		infor8.setBounds(97, 368, 297, 30);
		infor8.setHorizontalAlignment(infor8.CENTER);
		infor8.setFont(font);
		getContentPane().add(infor8);
		
		infor9=new JLabel("����� ���ϴ�.");
		infor9.setBounds(89, 414, 297, 30);
		infor9.setHorizontalAlignment(infor9.CENTER);
		infor9.setFont(font);
		getContentPane().add(infor9);
		
		setResizable(false);
		setVisible(true);

	}
}
