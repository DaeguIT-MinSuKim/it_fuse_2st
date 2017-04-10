package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.view.PublisherView;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class PublisherInfoP extends JPanel implements ActionListener {

	private InputComp pPCode;
	private InputComp pPublisher;
	private InputComp pPName;
	private InputComp pPTel;
	private InputComp pPZipCode;
	private InputComp pPAddress;
	private JPanel pBtn;
	public JButton btnPubSave;
	private JButton btnCancel;

	public PublisherInfoP() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelPub = new JPanel();
		add(panelPub);
		panelPub.setLayout(new GridLayout(0, 1, 0, 10));

		pPCode = new InputComp();
		pPCode.setTitle("출판사코드");
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
		pPZipCode.setTitle("우 편 번 호");
		panelPub.add(pPZipCode);

		pPAddress = new InputComp();
		pPAddress.setTitle("주         소");
		panelPub.add(pPAddress);

		pBtn = new JPanel();
		panelPub.add(pBtn);

		btnPubSave = new JButton("저장");
		btnPubSave.addActionListener(this);
		pBtn.add(btnPubSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);
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
	}

	/*
	 * public boolean isVaildCheck(){ try{ pPCode.isEmptyCheck();
	 * pPublisher.isEmptyCheck(); pPName.isEmptyCheck();
	 * 
	 * } }
	 */
	private boolean addCheck() {

		/*if (pPCode.getTFValue().trim().equals("")) {
			JOptionPane.showMessageDialog(null, "출판사코드를 입력해주세요");
			pPCode.getTF().requestFocus();
			return false;
		} else*/ if (pPublisher.getTFValue().trim().equals("")) {
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
		} else {

			return true;
		}
	}

	public PublisherInfo getObject() {
		String pCode = pPCode.getTFValue();
		String publisher = pPublisher.getTFValue();
		String pName = pPName.getTFValue();
		String pTel = pPTel.getTFValue();
		Integer pZipCode = Integer.parseInt(pPZipCode.getTFValue());
		/*String pZipCode = pPZipCode.getTFValue();*/
		String pAddress = pPAddress.getTFValue();
		return new PublisherInfo(pCode, publisher, pName, pTel, pZipCode, pAddress);
	}

	public void setObject(PublisherInfo pubItem) {
		pPCode.setTFValue(pubItem.getpCode());
		pPublisher.setTFValue(pubItem.getPublisher());
		pPName.setTFValue(pubItem.getpName());
		pPTel.setTFValue(pubItem.getpTel());
		pPZipCode.setTFValue(String.valueOf(pubItem.getpZipCode()));
		pPAddress.setTFValue(pubItem.getpAddress());

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
	}

	protected void actionPerformedBtnPubSave(ActionEvent e) {
		if (btnPubSave.getText() == "저장") {
			if (addCheck()) {
				PublisherInfoService.insertAllPublisherInfo(getObject());
				JOptionPane.showMessageDialog(null, "등록완료");
				clear();
				// 테이블 데이터 새로고침.. loaddata();
				PublisherView.pTable.loadData();
			}
		} else if (btnPubSave.getText() == "수정") {
			if (addCheck()) {
				PublisherInfoService.updateSetPublisherInfo(getObject());
				JOptionPane.showMessageDialog(null, "수정완료");
				clear();
				PublisherView.pTable.loadData();
				btnPubSave.setText("저장");
			}
		}
	}
	public void setNoInit() {
		PublisherInfoService pis = new PublisherInfoService();
		PublisherInfoP ps = new PublisherInfoP();
		pis.insertPublisherShort(getObject());
		ps.pPCode.getTF().setEditable(false);
		/*Integer.parseInt(ps.pPZipCode());*/
		/*PublisherInfoService pubInfoSer = new PublisherInfoService();
		pubInfoSer.insertPubliherShort.setTfValue(value);
		pubInfoSer.insertPubliherShort().gettF().setEditable(false);
		pubInfoSer.insertPubliherShort().gettF().requestFocus();		*/
	}
}
