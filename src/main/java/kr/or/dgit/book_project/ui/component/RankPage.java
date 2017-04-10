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

public class RankPage extends JPanel {

	private HashMap<String, Object> param;
	private int rank;

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
		lblRank.setFont(new Font("굴림", Font.BOLD, 60));
		pRankNum.add(lblRank);

		JPanel pRankBook = new JPanel();
		pRankBook.setBorder(new EmptyBorder(20, 20, 20, 20));
		pRank.add(pRankBook);
		pRankBook.setLayout(new GridLayout(0, 1, 5, 5));

		JLabel lblBookName = new JLabel(param.get("b_name") + String.format("( %s )", param.get("b_code")));
		lblBookName.setFont(new Font("돋움", Font.PLAIN, 30));
		pRankBook.add(lblBookName);

		JLabel lblAuthor = new JLabel((String) param.get("author"));
		lblAuthor.setFont(new Font("돋움", Font.PLAIN, 18));
		pRankBook.add(lblAuthor);

		JLabel lblPub = new JLabel((String) param.get("publisher") + String.format("( %s )", param.get("p_code")));
		lblPub.setForeground(Color.GRAY);
		lblPub.setFont(new Font("돋움", Font.PLAIN, 16));
		pRankBook.add(lblPub);

		JLabel lblAllCnt = new JLabel(String.format(String.format("총 대여회수 : %s회", param.get("cnt"))));
		lblAllCnt.setForeground(Color.GRAY);
		pRankBook.add(lblAllCnt);
		return pRank;
	}

}
