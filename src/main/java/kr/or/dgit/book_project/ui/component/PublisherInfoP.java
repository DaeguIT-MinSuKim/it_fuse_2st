package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.post.PostMain;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.view.PublisherView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.event.MouseListener;

@SuppressWarnings("serial")
public class PublisherInfoP extends JPanel implements ActionListener {

	private InputComp pPCode;
	private InputComp pPublisher;
	private InputComp pPName;
	private InputComp pPTel;
	private static InputComp pPZipCode;
	private InputComp pPAddress;
	private JPanel pBtn;
	public JButton btnPubSave;
	private JButton btnCancel;
	private InputComp pPAddDetail;

	public PublisherInfoP() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelPub = new JPanel();
		add(panelPub);
		panelPub.setLayout(new GridLayout(0, 1, 0, 5));

		pPCode = new InputComp();
		pPCode.setTitle("출판사코드");
		pPCode.getTF().setEnabled(false);
		panelPub.add(pPCode);

		pPublisher = new InputComp();
		pPublisher.setTitle("출 판 사 명");
		panelPub.add(pPublisher);

		pPName = new InputComp();
		pPName.setTitle("담 당 자 명");
		panelPub.add(pPName);

		pPTel = new InputComp();
		pPTel.setTitle("연   락   처");
		panelPub.add(pPTel);

		pPZipCode = new InputComp();
		/* pPZipCode.getTF().addMouseListener(this); */
		pPZipCode.setTitle("우 편 번 호");
		panelPub.add(pPZipCode);

		pPAddress = new InputComp();
		pPAddress.setTitle("주         소");
		panelPub.add(pPAddress);

		pPAddDetail = new InputComp();
		/*
		 * GridBagLayout gbl_pPAddDetail = (GridBagLayout)
		 * pPAddDetail.getLayout(); gbl_pPAddDetail.rowWeights = new
		 * double[]{0.0}; gbl_pPAddDetail.rowHeights = new int[]{50};
		 * gbl_pPAddDetail.columnWeights = new double[]{0.0, 0.0};
		 * gbl_pPAddDetail.columnWidths = new int[]{100, 200};
		 */
		pPAddDetail.setTitle("상 세 주 소");
		panelPub.add(pPAddDetail);

		pBtn = new JPanel();
		panelPub.add(pBtn);

		btnPubSave = new JButton("저장");
		btnPubSave.setHorizontalAlignment(SwingConstants.LEADING);
		btnPubSave.addActionListener(this);
		pBtn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
		pBtn.add(btnPubSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		postSearch();
	}

	public JButton getBtnPubSave() {
		return btnPubSave;
	}

	public void clear() {
		pPCode.setTFValue("");
		pPublisher.setTFValue("");
		pPName.setTFValue("");
		pPTel.setTFValue("");
		pPZipCode.setTFValue("");
		pPAddress.setTFValue("");
		pPAddDetail.setTFValue("");
	}

	/*
	 * public boolean isVaildCheck(){ try{ pPCode.isEmptyCheck();
	 * pPublisher.isEmptyCheck(); pPName.isEmptyCheck();
	 * 
	 * } }
	 */
	private boolean addCheck() {

		/*
		 * if (pPCode.getTFValue().trim().equals("")) {
		 * JOptionPane.showMessageDialog(null, "출판사코드를 입력해주세요");
		 * pPCode.getTF().requestFocus(); return false; } else
		 */ if (pPublisher.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "출판사명을 입력해주세요");
			pPublisher.getTF().requestFocus();
			return false;
		} else if (pPName.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "담당자명을 입력해주세요");
			pPName.getTF().requestFocus();
			return false;
		} else if (!pPTel.getTFValue().trim().matches("^[0-9]{3}-{1}[0-9]{3,4}-{1}[0-9]{4}$")) {
			JOptionPane.showMessageDialog(null, "전화번호를 입력해주세요 000-0000-0000");
			pPTel.getTF().requestFocus();
			return false;
		} else if (!pPZipCode.getTFValue().matches("^[0-9]{5}$")) {
			JOptionPane.showMessageDialog(null, "우편번호를 입력해주세요 5자리");
			pPZipCode.getTF().requestFocus();
			return false;
		} else if (pPAddress.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "주소를 입력해주세요");
			pPAddress.getTF().requestFocus();
			return false;
		} else if (pPAddDetail.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "상세주소를 입력해주세요");
			pPAddDetail.getTF().requestFocus();
			return false;
		} else {

			return true;
		}
	}

	public PublisherInfo getObject() {
		String pCode = pPCode.getTFValue();
		String publisher = pPublisher.getTFValue();
		String pName = pPName.getTFValue();
		String pTel = pPTel.getTFValue();
		String pZipCode = pPZipCode.getTFValue();
		String pAddress = pPAddress.getTFValue();
		String pAddDetail = pPAddDetail.getTFValue();
		return new PublisherInfo(pCode, publisher, pName, pTel, pZipCode, pAddress, pAddDetail);
	}

	public void setObject(PublisherInfo pubItem) {
		pPCode.setTFValue(pubItem.getpCode());
		pPublisher.setTFValue(pubItem.getPublisher());
		pPName.setTFValue(pubItem.getpName());
		pPTel.setTFValue(pubItem.getpTel());
		// pPZipCode.setTFValue(String.valueOf(pubItem.getpZipCode()));
		pPZipCode.setTFValue(pubItem.getpZipCode());
		pPAddress.setTFValue(pubItem.getpAddress());
		pPAddDetail.setTFValue(pubItem.getpAddDetail());
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPubSave) {
			actionPerformedBtnPubSave(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		clear();
		btnPubSave.setText("저장");
	}

	protected void actionPerformedBtnPubSave(ActionEvent e) {
		if (btnPubSave.getText() == "저장") {
			if (addCheck()) {
				PublisherInfoService.getInstance().insertAllPublisherInfo(getObject());
				JOptionPane.showMessageDialog(null, "등록완료");
				clear();
				// 테이블 데이터 새로고침.. loaddata();
				PublisherView.pTable.loadData();
			}
		} else if (btnPubSave.getText() == "수정") {
			if (addCheck()) {
				PublisherInfoService.getInstance().updateSetPublisherInfo(getObject());
				JOptionPane.showMessageDialog(null, "수정완료");
				clear();
				PublisherView.pTable.loadData();
				btnPubSave.setText("저장");
			}
		}
	}

	public void postSearch() {
		PublisherInfoP.getpPZipCode().getTF().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					PostMain post = new PostMain();
					setThisToPost(post);
					post.setVisible(true);
				}
				super.mouseClicked(e);
			}
		});
	}

	public static InputComp getpPZipCode() {
		return pPZipCode;
	}

	@SuppressWarnings("static-access")
	public void setpPZipCode(InputComp pPZipCode) {
		this.pPZipCode = pPZipCode;
	}

	public void setThisToPost(PostMain postMain) {
		postMain.setPublisherInfoP(this);
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == pPZipCode.getTF()) {
			mouseClickedPPZipCodeTF(e);
		}
	}

	protected void mouseClickedPPZipCodeTF(MouseEvent e) {
	}
}
