package kr.or.dgit.book_project.ui.component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import kr.or.dgit.book_project.dto.PaymentIO;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class RankPage extends JPanel {

	private HashMap<String, Object> param;
	private int rank;
	
	

	public RankPage() {
		JPanel pRank = new JPanel();
		pRank.setLayout(new BorderLayout(0, 0));

		JPanel pRankNum = new JPanel();
		pRankNum.setBackground(Color.WHITE);
		pRankNum.setBorder(new LineBorder(new Color(0, 0, 0)));
		pRank.add(pRankNum, BorderLayout.WEST);
		pRankNum.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblRank = new JLabel("  " + rank + "  ");
		lblRank.setBackground(Color.WHITE);
		lblRank.setFont(new Font("돋움", Font.BOLD, 55));
		pRankNum.add(lblRank);

		JPanel pRankBook = new JPanel();
		pRankBook.setBorder(new EmptyBorder(20, 20, 20, 20));
		pRank.add(pRankBook);
		pRankBook.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblBookName = new JLabel(param.get("b_name") + String.format("( %s )", param.get("b_code")));
		lblBookName.setFont(new Font("돋움", Font.PLAIN, 38));
		pRankBook.add(lblBookName);
		
		JPanel panel = new JPanel();
		pRankBook.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblAuthor = new JLabel((String) param.get("author"));
		panel.add(lblAuthor);
		lblAuthor.setFont(new Font("돋움", Font.PLAIN, 30));

		JLabel lblPub = new JLabel((String) param.get("publisher") + String.format("( %s )", param.get("p_code")));
		panel.add(lblPub);
		lblPub.setFont(new Font("돋움", Font.PLAIN, 20));

		JLabel lblAllCnt = new JLabel(String.format(String.format("※ 총 대여회수 : %s회", param.get("cnt"))));
		lblAllCnt.setFont(new Font("돋움", Font.PLAIN, 20));
		pRankBook.add(lblAllCnt);
	}

	public RankPage(int rank, HashMap<String, Object> param) {
		this.rank = rank;
		this.param = param;
	}

	public JPanel setRankBookInfo() {
		JPanel pRank = new JPanel();
		pRank.setLayout(new BorderLayout(0, 0));

		JPanel pRankNum = new JPanel();
		pRank.add(pRankNum, BorderLayout.WEST);
		pRankNum.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblRank = new JLabel("  " + rank + "  ");
		lblRank.setFont(new Font("돋움", Font.BOLD, 55));
		pRankNum.add(lblRank);

		JPanel pRankBook = new JPanel();
		pRankBook.setBorder(new EmptyBorder(20, 20, 20, 20));
		pRank.add(pRankBook);
		pRankBook.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblBookName = new JLabel(param.get("b_name") + String.format("( %s )", param.get("b_code")));
		lblBookName.setFont(new Font("돋움", Font.PLAIN, 38));
		pRankBook.add(lblBookName);

		JLabel lblAuthor = new JLabel((String) param.get("author"));
		lblAuthor.setFont(new Font("돋움", Font.PLAIN, 30));
		pRankBook.add(lblAuthor);

		JLabel lblPub = new JLabel((String) param.get("publisher") + String.format("( %s )", param.get("p_code")));
		lblPub.setFont(new Font("돋움", Font.PLAIN, 20));
		pRankBook.add(lblPub);

		JLabel lblAllCnt = new JLabel(String.format(String.format("총 대여회수 : %s회", param.get("cnt"))));
		lblAllCnt.setFont(new Font("돋움", Font.PLAIN, 20));
		pRankBook.add(lblAllCnt);
		return pRank;
	}

}
