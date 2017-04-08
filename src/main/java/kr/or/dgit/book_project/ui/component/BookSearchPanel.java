package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.ui.common.OptionSearchCmb;
import kr.or.dgit.book_project.ui.common.OptionSearchPanel;
import kr.or.dgit.book_project.ui.common.OptionSearchTF;
import javax.swing.JButton;

public class BookSearchPanel extends JPanel {

	private OptionSearchPanel pBCode;
	private OptionSearchPanel pBName;
	private OptionSearchPanel pAuthor;
	private OptionSearchPanel pCoden;
	private OptionSearchPanel pPublisher;
	private JPanel pBtn;
	private JButton btnSearch;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel pBtnSub;

	public BookSearchPanel() {
		setLayout(new GridLayout(0, 1, 0, 10));

		pBCode = new OptionSearchTF();
		pBCode.setTitle("도 서 코 드");
		add(pBCode);

		pBName = new OptionSearchTF();
		pBName.setTitle("도   서   명");
		add(pBName);

		pAuthor = new OptionSearchTF();
		pAuthor.setTitle("저          자");
		add(pAuthor);

		pCoden = new OptionSearchCmb<Coden>();

		List<Coden> list = CodenService.getInstance().selectCodenAll();
		((OptionSearchCmb<Coden>) pCoden).setComboDate(list);
		pCoden.setTitle("분          류");
		add(pCoden);

		pPublisher = new OptionSearchTF();
		pPublisher.setTitle("출   판   사");
		add(pPublisher);

		pBtn = new JPanel();
		add(pBtn);
		pBtn.setLayout(new GridLayout(0, 3, 20, 0));

		JPanel panel_1 = new JPanel();
		pBtn.add(panel_1);

		btnSearch = new JButton("검색");
		pBtn.add(btnSearch);

		pBtnSub = new JPanel();
		pBtn.add(pBtnSub);
		pBtnSub.setLayout(new GridLayout(1, 0, 0, 0));

	}

	public Map getValueForSearch() {
		Map<String, Object> param = new HashMap<>();
		if (pBCode.isVaildCheck()) {
			param.put("bCode", ((OptionSearchTF) pBCode).getTfValue());
		}
		if (pBName.isVaildCheck()) {
			param.put("bName", "%" + ((OptionSearchTF) pBName).getTfValue() + "%");
		}
		if (pAuthor.isVaildCheck()) {
			param.put("author", "%" + ((OptionSearchTF) pAuthor).getTfValue() + "%");
		}
		if (pCoden.isVaildCheck()) {
			param.put("cName", ((Coden) ((OptionSearchCmb) pCoden).getCombT()).getcName());
		}
		if (pPublisher.isVaildCheck()) {
			param.put("publisher", "%" + ((OptionSearchTF) pPublisher).getTfValue() + "%");
		}
		return param;
	}

	public void clearAll() {
		((OptionSearchTF) pBCode).clear();
		((OptionSearchTF) pBName).clear();
		((OptionSearchTF) pAuthor).clear();
		((OptionSearchCmb) pCoden).clear();
		((OptionSearchTF) pPublisher).clear();
	}

	public JButton getBtnSearch() {
		return btnSearch;
	}

	public JPanel getpBtnSub() {
		return pBtnSub;
	}

}
