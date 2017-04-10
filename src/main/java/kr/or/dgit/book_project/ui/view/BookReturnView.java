package kr.or.dgit.book_project.ui.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.service.PaymentIOService;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;
import kr.or.dgit.book_project.ui.component.BookLendMemberDetailDate;
import kr.or.dgit.book_project.ui.table.PaymentIoTable;

public class BookReturnView extends JPanel implements MouseListener {

	private BookInfoBasic pBookinfo;
	private JPanel pMemberinfo;
	private BookLendMemberDetailDate pMemberDetail;
	private JPanel pReturnbtn;
	private JButton btnLend;
	private PaymentIoTable pTabel;

	
	public BookReturnView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 10, 10));
		
		JPanel pContent = new JPanel();
		add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 0, 0));
		
		pBookinfo = new BookInfoBasic();
		pBookinfo.getpBCode().getTfBCode().addMouseListener(this);
		pContent.add(pBookinfo);
		
		pMemberinfo = new JPanel();
		pContent.add(pMemberinfo);
		GridBagLayout gbl_pMemberinfo = new GridBagLayout();
		gbl_pMemberinfo.columnWidths = new int[] {350, 10};
		gbl_pMemberinfo.rowHeights = new int[] {150, 100, 0};
		gbl_pMemberinfo.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pMemberinfo.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		pMemberinfo.setLayout(gbl_pMemberinfo);
		
		pMemberDetail = new BookLendMemberDetailDate();
		pMemberDetail.getpMCode().getTF().addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				mousePressedPMemberDetailPMCodeTF(arg0);
			}
		});
		GridBagConstraints gbc_pMemberDetail = new GridBagConstraints();
		gbc_pMemberDetail.weightx = 1.0;
		gbc_pMemberDetail.weighty = 2.0;
		gbc_pMemberDetail.fill = GridBagConstraints.BOTH;
		gbc_pMemberDetail.insets = new Insets(0, 0, 5, 0);
		gbc_pMemberDetail.gridx = 0;
		gbc_pMemberDetail.gridy = 0;
		
		pMemberinfo.add(pMemberDetail, gbc_pMemberDetail);
		
		pReturnbtn = new JPanel();
		pReturnbtn.setBorder(new EmptyBorder(10, 100, 10, 100));
		GridBagConstraints gbc_pReturnbtn = new GridBagConstraints();
		gbc_pReturnbtn.weighty = 1.0;
		gbc_pReturnbtn.weightx = 1.0;
		gbc_pReturnbtn.fill = GridBagConstraints.BOTH;
		gbc_pReturnbtn.gridx = 0;
		gbc_pReturnbtn.gridy = 1;
		pMemberinfo.add(pReturnbtn, gbc_pReturnbtn);
		pReturnbtn.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnLend = new JButton("반납");
		btnLend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				actionPerformedBtnLend(arg0);
			}
		});
		btnLend.setFont(new Font("굴림", Font.PLAIN, 18));
		pReturnbtn.add(btnLend);
		
		pTabel = new PaymentIoTable();
		pTabel.loadData();
		pTabel.getTable().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mouseClickedPTabelTable(e);
			}
		});
		add(pTabel);
	}

	public void mousePressed(MouseEvent e) {
		if (e.getSource() == pBookinfo.getpBCode().getTfBCode()) {
			pBookinfoPBCodeTfBCodeMousePressed(e);
		}
	}
	
	public PaymentIoTable getpTabel() {
		return pTabel;
	}

	public void setpTabel(PaymentIoTable pTabel) {
		this.pTabel = pTabel;
	}
	
	public BookInfoBasic getpBookinfo() {
		return pBookinfo;
	}

	public BookLendMemberDetailDate getpMemberDetail() {
		return pMemberDetail;
	}

	protected void mouseClickedPTabelTable(MouseEvent e) {
		if(e.getClickCount()== 2){
			pBookinfo.setObjectP(pTabel.getSelectedObject());
			pMemberDetail.setObject(pTabel.getSelectedObject());
		}
	}
	protected void actionPerformedBtnLend(ActionEvent arg0) {
		//JOptionPane.showMessageDialog(null, pMemberDetail.getObject().getReturnDate());
		
		// 반납 버튼 프로시저..이것만되면 슈바 끝인가...
		PaymentIO paymentio = pTabel.getSelectedObject();
		JOptionPane.showMessageDialog(null, pMemberDetail.returnMsg());
		
		PaymentIO bookinfo = pBookinfo.getObjectP();
		PaymentIO memberinfo = pMemberDetail.getObject();
		
		Map<String, Object> param = new HashMap<>();
		param.put("b_code", bookinfo.getBookInfo().getbCode());
		param.put("b_sub_code", bookinfo.getBookInfo().getbSubCode());
		param.put("m_code", memberinfo.getMemberInfo().getmCode());
		// 여기서 막힘
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		//Date date = sdf.parse(param.put("return_date", memberinfo.getReturnDate()));
		//하얗게 불태웟다 도저히 무리다
		param.put("return_date", memberinfo.getReturnDate());
		PaymentIOService.getInstance().updatePaymentIO(param);
		pTabel.loadData();
		JOptionPane.showMessageDialog(null, "반납되었습니다");
		pBookinfo.clear();
		pMemberDetail.clear();
	}
	
	
	protected void pBookinfoPBCodeTfBCodeMousePressed(MouseEvent e) {
		//반납파트에서 눌럿을때 검색
		BookSearchViewFrame bsv = new BookSearchViewFrame();
		Map<String, Object> param = new HashMap<>();
		param.put("isDel", false);
		param.put("isLending", true);
		bsv.setTableDate(param);
		bsv.setBookReturnView(this);
		bsv.setMyMouseListenerPayment(pBookinfo);
		bsv.setVisible(true);
	}
	
	protected void mousePressedPMemberDetailPMCodeTF(MouseEvent arg0) {
		//회원 누르는거
		MemberSearchComboView msc = new MemberSearchComboView();
		msc.loadDate();
		JFrame jf = new JFrame();
		jf.setBounds(200, 200, 500, 500);
		jf.getContentPane().add(msc);
		jf.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
