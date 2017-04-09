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

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.service.PaymentIOService;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;
import kr.or.dgit.book_project.ui.component.BookLendMemberDetail;
import kr.or.dgit.book_project.ui.table.BookLendTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class BookLendView extends JPanel implements ActionListener {

	private BookLendTable blv4;
	private BookInfoBasic pBookBasic;
	private BookLendMemberDetail pMemberlendDetail;
	private JButton btnLend;

	public BookLendView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 10, 10));

		JPanel blv1 = new JPanel();
		add(blv1);
		blv1.setLayout(new GridLayout(0, 2, 0, 0));

		pBookBasic = new BookInfoBasic();
		pBookBasic.getpBCode().getTfBCode().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mousePressedPanel_3PBCodeTfBCode(e);
			}
		});

		blv1.add(pBookBasic);

		JPanel blv2 = new JPanel();
		blv1.add(blv2);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 350, 10 };
		gbl_panel_5.rowHeights = new int[] { 150, 100, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		blv2.setLayout(gbl_panel_5);

		pMemberlendDetail = new BookLendMemberDetail();
		pMemberlendDetail.getpMCode().getTF().addMouseListener(new MouseAdapter() {
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
		blv2.add(pMemberlendDetail, gbc_panel_4);

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

		btnLend = new JButton("대여");
		btnLend.addActionListener(this);
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
			pBookBasic.setObject(blv4.getSelectedObject());
		}
	}

	// 도서코드 누르면 관리뜨는거
	protected void mousePressedPanel_3PBCodeTfBCode(MouseEvent e) {
		BookSearchViewFrame bsv = new BookSearchViewFrame();
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("isLending", false);
		bsv.setTableDate(param);
		bsv.setMyMouseListenerPayment(pBookBasic);
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

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLend) {
			btnLendActionPerformed(e);
		}
	}
	//대여 버튼 (프로시저 실행)
	protected void btnLendActionPerformed(ActionEvent e) {
		BookInfo bookinfo = pBookBasic.getObject();
		MemberInfo memberinfo = pMemberlendDetail.getObject();
	
		Map<String, Object> param = new HashMap<>();
		param.put("b_code", bookinfo.getbCode());
		param.put("b_sub_code", bookinfo.getbSubCode());
		param.put("m_code", memberinfo.getmCode());
		PaymentIOService.getInstance().insertPaymentIO(param);
		
		blv4.loadData();
		JOptionPane.showMessageDialog(null, "대여가 되었습니다");
		pBookBasic.clear();
		pMemberlendDetail.clear();
	}

	public BookInfoBasic getpBookBasic() {
		return pBookBasic;
	}

	public BookLendMemberDetail getpMemberlendDetail() {
		return pMemberlendDetail;
	}

	
	
}
