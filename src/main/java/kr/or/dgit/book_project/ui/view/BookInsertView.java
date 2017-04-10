package kr.or.dgit.book_project.ui.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.AbsViewPanel;
import kr.or.dgit.book_project.ui.component.BookInfoP;
import kr.or.dgit.book_project.ui.table.BookSearchTable;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

public class BookInsertView extends JPanel implements ActionListener {

	private JButton btnSave;
	private JButton btnCancel;
	private BookInfoP pContent;
	private BookSearchTable pTable;
	private BookSearchViewFrame bookSearchFrame;

	public BookInsertView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_5 = new JPanel();
		add(panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[] { 600, 0 };
		gbl_panel_5.rowHeights = new int[] { 300, 50, 200, 0 };
		gbl_panel_5.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_5.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_5.setLayout(gbl_panel_5);

		pContent = new BookInfoP();
		pContent.getBtnAddPublisher().addActionListener(this);
		pContent.getBtnBookSearch().addActionListener(this);
		GridBagConstraints gbc_pContent = new GridBagConstraints();
		gbc_pContent.weighty = 1.0;
		gbc_pContent.weightx = 1.0;
		gbc_pContent.fill = GridBagConstraints.BOTH;
		gbc_pContent.insets = new Insets(0, 0, 5, 0);
		gbc_pContent.gridx = 0;
		gbc_pContent.gridy = 0;
		panel_5.add(pContent, gbc_pContent);

		JPanel pBtn = new JPanel();
		GridBagConstraints gbc_pBtn = new GridBagConstraints();
		gbc_pBtn.weighty = 1.0;
		gbc_pBtn.weightx = 1.0;
		gbc_pBtn.fill = GridBagConstraints.BOTH;
		gbc_pBtn.insets = new Insets(0, 0, 5, 0);
		gbc_pBtn.gridx = 0;
		gbc_pBtn.gridy = 1;
		panel_5.add(pBtn, gbc_pBtn);
		pBtn.setLayout(new GridLayout(1, 0, 20, 10));

		JPanel panel = new JPanel();
		pBtn.add(panel);

		btnSave = new JButton("저장");
		btnSave.addActionListener(this);
		pBtn.add(btnSave);

		btnCancel = new JButton("취소");
		btnCancel.addActionListener(this);
		pBtn.add(btnCancel);

		JPanel panel_1 = new JPanel();
		pBtn.add(panel_1);

		pTable = new BookSearchTable();
		GridBagConstraints gbc_pTable = new GridBagConstraints();
		gbc_pTable.weighty = 1.0;
		gbc_pTable.weightx = 1.0;
		gbc_pTable.fill = GridBagConstraints.BOTH;
		gbc_pTable.gridx = 0;
		gbc_pTable.gridy = 2;
		panel_5.add(pTable, gbc_pTable);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pContent.getBtnAddPublisher()) {
			actionPerformedPContentBtnAddPublisher(e);
		}
		if (e.getSource() == pContent.getBtnBookSearch()) {
			actionPerformedPContentBtnBookSearch(e);
		}
		if (e.getSource() == btnCancel) {
			actionPerformedBtnCancel(e);
		}
		if (e.getSource() == btnSave) {
			actionPerformedBtnSave(e);
		}
	}

	protected void actionPerformedBtnSave(ActionEvent e) {
		// 모두 입력되었는지 확인 후
		if(pContent.isVaildCheck()){
			pContent.getObject();
			BookInfoService.getInstance().insertBookInfo(pContent.getObject());
			pContent.setClear();
			
			// 하단 테이블에 입력한 데이터 띄우기
			Map<String, Object> param = new HashMap<>();
			param.put("bCode", pContent.getObject().getbCode());
			param.put("bSubCode", pContent.getObject().getbSubCode());
			pTable.setMap(param);
			pTable.loadData();
		}
	}

	protected void actionPerformedBtnCancel(ActionEvent e) {
		pContent.setClear();
	}

	protected void actionPerformedPContentBtnBookSearch(ActionEvent e) {
		if (bookSearchFrame != null){
			// 창 1개만 띄우기
		}
		bookSearchFrame = new BookSearchViewFrame();
		Map<String, Object> param = new HashMap<>();
		param.put("onlyBook", true);
		bookSearchFrame.setTableDate(param);
		bookSearchFrame.setMyMouseListener(pContent);
		bookSearchFrame.addBtn("신규");
		bookSearchFrame.setVisible(true);
	}

	protected void actionPerformedPContentBtnAddPublisher(ActionEvent e) {
		if (pContent.getTfAddPublisher().getText().equals("")) {
			JOptionPane.showMessageDialog(null, "추가할 내용이 없습니다.");
		} else {
			// insert문
			PublisherInfoService pis = new PublisherInfoService();
			PublisherInfo ps = new PublisherInfo();
			ps.setPublisher(pContent.getTfAddPublisher().getText());
			pis.insertPublisherShort(ps);
			List<PublisherInfo> list = pis.selectByAll();

			// 추가후... 추가한 항목을 selected로

			pContent.getpPublisher().getComboBox().removeAllItems(); // 기존목록 지우기
			pContent.getpPublisher().setComboDate(list); // 새 목록 넣기
			// 목록을 넣지 않고 새로 추가된 애만 additem???? 고민중
			// 제일 마지막 출판사 선택하기
			pContent.getpPublisher().setSelected(pis.selectCountAll() - 1);
			pContent.getTfAddPublisher().setText(""); // 텍스트필드 초기화
		}
	}

	public BookInfoP getpContent() {
		return pContent;
	}
}