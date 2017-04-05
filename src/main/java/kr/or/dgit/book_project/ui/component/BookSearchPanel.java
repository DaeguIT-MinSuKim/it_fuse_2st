package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.ui.common.OptionSearchCmb;
import kr.or.dgit.book_project.ui.common.OptionSearchPanel;
import kr.or.dgit.book_project.ui.common.OptionSearchTF;

public class BookSearchPanel extends JPanel {

	private OptionSearchPanel pBCode;
	private OptionSearchPanel pBName;
	private OptionSearchPanel pCoden;
	private OptionSearchPanel pPublisher;

	public BookSearchPanel() {
		setLayout(new GridLayout(0, 1, 0, 10));

		pBCode = new OptionSearchTF();
		pBCode.setTitle("도서코드");
		add(pBCode);

		pBName = new OptionSearchTF();
		pBName.setTitle("도  서  명");
		add(pBName);

		pCoden = new OptionSearchCmb<String>();
		pCoden.setTitle("분       류");
		add(pCoden);

		pPublisher = new OptionSearchTF();
		pPublisher.setTitle("출  판  사");
		add(pPublisher);

	}

	public Map getValueForSearch() {
		Map<String, Object> param = new HashMap<>();
		if (pBCode.isVaildCheck()) {
			param.put("bCode", ((OptionSearchTF) pBCode).getTfValue());
		}
		if (pBName.isVaildCheck()) {
			param.put("bName", ((OptionSearchTF) pBName).getTfValue());
		}
		if (pCoden.isVaildCheck()) {
			param.put("cName", ((OptionSearchCmb) pCoden).getCombT());
		}
		if (pPublisher.isVaildCheck()) {
			param.put("publisher", ((OptionSearchTF) pPublisher).getTfValue());
		}
		return param;
	}

}
