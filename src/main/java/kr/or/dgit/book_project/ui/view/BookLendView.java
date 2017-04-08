package kr.or.dgit.book_project.ui.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;
import kr.or.dgit.book_project.ui.component.BookLendMemberDetail;
import kr.or.dgit.book_project.ui.table.BookLendTable;
import javax.swing.JLabel;

public class BookLendView extends JPanel {

	private BookLendTable blv4;
	private BookInfoBasic panel_3;
	private BookLendMemberDetail panel_4;

	public BookLendView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 10, 10));

		JPanel blv1 = new JPanel();
		add(blv1);
		blv1.setLayout(new GridLayout(0, 2, 0, 0));

		panel_3 = new BookInfoBasic();
		panel_3.getpBCode().getTfBCode().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedPanel_3PBCodeTfBCode(e);
			}
		});

		blv1.add(panel_3);

		JPanel blv2 = new JPanel();
		blv1.add(blv2);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 350, 10 };
		gbl_panel_5.rowHeights = new int[] { 150, 100, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		blv2.setLayout(gbl_panel_5);

		panel_4 = new BookLendMemberDetail();
		panel_4.getpMCode().getTF().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mousePressedPanel_4PMCodeTF(arg0);
			}
		});
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.weighty = 2.0;
		gbc_panel_4.weightx = 1.0;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		blv2.add(panel_4, gbc_panel_4);

		JPanel blv3 = new JPanel();
		blv3.setBorder(new EmptyBorder(20, 100, 20, 100));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		blv2.add(blv3, gbc_panel_2);
		blv3.setLayout(new GridLayout(1, 1, 10, 0));

		JButton btnLend = new JButton("대여");
		btnLend.setFont(new Font("굴림", Font.PLAIN, 18));
		blv3.add(btnLend);

		blv4 = new BookLendTable();
		blv4.loadData();
		blv4.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedBlv4Table(e);
			}
		});

		add(blv4);
	}

	protected void mouseClickedBlv4Table(MouseEvent e) {
		if (e.getClickCount() == 2) {
			panel_3.setObject(blv4.getSelectedObject());
		}
	}

	// 도서코드 누르면 관리뜨는거
	protected void mousePressedPanel_3PBCodeTfBCode(MouseEvent e) {
		BookSearchViewFrame bsv = new BookSearchViewFrame();
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("isLending", false);
		bsv.setTableDate(param);
		bsv.setVisible(true);
		
		
		/*//반납부분 검색창 띄우기
		BookSearchViewFrame bsv = new BookSearchViewFrame();
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("isLending", true);
		bsv.setTableDate(param);
		bsv.setVisible(true);*/
	}

	// 회원코드 누르면 관리뜨는거
	protected void mousePressedPanel_4PMCodeTF(MouseEvent arg0) {
		MemberSearchComboView msc = new MemberSearchComboView();
		msc.loadDate();
		JFrame jf = new JFrame();
		msc.setMyMouseListener(this, jf);
		jf.setBounds(100, 100, 400, 500);
		jf.getContentPane().add(msc);
		jf.setVisible(true);
	}

	public BookLendMemberDetail getPanel_4() {
		return panel_4;
	}
}
