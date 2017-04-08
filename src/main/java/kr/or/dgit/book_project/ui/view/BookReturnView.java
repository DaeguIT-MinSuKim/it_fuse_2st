package kr.or.dgit.book_project.ui.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.BookInfoBasic;
import kr.or.dgit.book_project.ui.component.BookLendMemberDetailDate;
import kr.or.dgit.book_project.ui.table.PaymentIoTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookReturnView extends AbsViewPanel {

	private BookInfoBasic pBookinfo;
	private JPanel pMemberinfo;
	private BookLendMemberDetailDate pMemberDetail;
	private JPanel pReturnbtn;
	private JButton btnLend;
	private PaymentIoTable pTabel;

	/**
	 * Create the panel.
	 */
	public BookReturnView() {
		GridLayout gridLayout = (GridLayout) getLayout();
		gridLayout.setVgap(10);
		
		JPanel pContent = new JPanel();
		pMain.add(pContent);
		pContent.setLayout(new GridLayout(0, 2, 0, 0));
		
		pBookinfo = new BookInfoBasic();
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
		pMain.add(pTabel);
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
		PaymentIO paymentio = pTabel.getSelectedObject();
		JOptionPane.showMessageDialog(null, pMemberDetail.returnMsg());
	}
}
