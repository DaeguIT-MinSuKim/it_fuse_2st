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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.FlowLayout;
import javax.swing.border.MatteBorder;

public class RankPage extends JPanel {

	private HashMap<String, Object> param;
	private int rank;

	public RankPage() {
		JPanel pRank = new JPanel();
		pRank.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 255, 255)));
	}

	public RankPage(int rank, HashMap<String, Object> param) {
		this.rank = rank;
		this.param = param;
	}

	public JPanel setRankBookInfo() {
		JPanel pRank = new JPanel();
		pRank.setBorder(new MatteBorder(3, 0, 0, 0, (Color) new Color(255, 255, 255)));
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

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pRankBook.add(panel_1);

		JLabel lblBookName = new JLabel((String) param.get("b_name"));
		panel_1.add(lblBookName);
		lblBookName.setFont(new Font("돋움", Font.BOLD, 26));

		JLabel lblBookCode = new JLabel(String.format("( %s )", param.get("b_code")));
		lblBookCode.setFont(new Font("돋움", Font.BOLD, 18));
		panel_1.add(lblBookCode);

		JPanel panel = new JPanel();
		pRankBook.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JLabel lblAuthor = new JLabel(String.format("지은이: %s   ", (String) param.get("author")));
		lblAuthor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAuthor.setFont(new Font("돋움", Font.BOLD, 22));
		panel.add(lblAuthor);

		JLabel lblPub = new JLabel(
				String.format(" |    %s ( %s )", (String) param.get("publisher"), param.get("p_code")));
		lblPub.setHorizontalAlignment(SwingConstants.LEFT);
		lblPub.setFont(new Font("돋움", Font.PLAIN, 18));
		panel.add(lblPub);

		JLabel lblAllCnt = new JLabel(String.format(String.format("※ 총 대여회수 : %s회", param.get("cnt"))));
		lblAllCnt.setFont(new Font("돋움", Font.PLAIN, 16));
		pRankBook.add(lblAllCnt);
		return pRank;
	}

}
