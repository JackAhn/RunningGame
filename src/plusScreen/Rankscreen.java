package plusScreen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.plaf.synth.SynthSplitPaneUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import database.DBconnect;

public class Rankscreen extends JDialog implements ActionListener{
	List<Integer> rankscore;
	JTable jt;
	int [] score;
	String[][] tabledata = new String[10][2];
	JScrollPane js;
	int i, j;
	int num=1;
	int rank = 1;
	JButton check;
	public Rankscreen() {
		String[] head = { "순위", "점수" };
		rankscore=new ArrayList<Integer>();
		score=new int[100];
		setSize(400, 400);
		setTitle("피해라 졸라맨 순위");
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		setResizable(false);
		try {
			new DBconnect().DBSetting();
			String query = "SELECT * FROM `rank`";
			ResultSet rs = DBconnect.stmt.executeQuery(query);
			while (rs.next()) {
				int a = rs.getInt("Score");
				if(a==0)
					continue;
				rankscore.add(a);
				num++;
			}
		} catch (Exception e) {

		}
		Collections.sort(rankscore, new changeinteger());
		if(rankscore.size()==0) {
			JOptionPane.showMessageDialog(null, "플레이 데이터가 없습니다.", "에러", JOptionPane.ERROR_MESSAGE);
			return;
		}
		j = 0;
		while (j <  rankscore.size()) {
			String[] data = { rank + "위", rankscore.get(j) + "점" };
			tabledata[j][0] = data[0];
			tabledata[j][1] = data[1];
			rank++;
			j++;
		}

		DefaultTableModel dtm = new DefaultTableModel(tabledata, head) { // 셀 수정 못하게 하는 부분
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		jt = new JTable(dtm);
		js = new JScrollPane(jt);
		js.setBounds(0, 0, 400, 325);
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		TableColumnModel tc = jt.getColumnModel();
		for (int l = 0; l < tc.getColumnCount(); l++) {
			tc.getColumn(l).setCellRenderer(renderer);
		}
		jt.getTableHeader().setReorderingAllowed(false);
		jt.getTableHeader().setResizingAllowed(false);
		jt.setRowHeight(30);
		getContentPane().add(js);
		check=new JButton("확인");
		check.setBounds(147, 337, 100, 20);
		check.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		getContentPane().add(check);
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

class changeinteger implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		return arg1.compareTo(arg0);
	}
	
}
