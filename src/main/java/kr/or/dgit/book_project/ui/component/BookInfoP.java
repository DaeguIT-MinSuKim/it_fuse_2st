package kr.or.dgit.book_project.ui.component;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.Coden;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.CodenService;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.BookCodePanel;
import kr.or.dgit.book_project.ui.common.ComboBoxPanel;
import kr.or.dgit.book_project.ui.common.InputComp;
import kr.or.dgit.book_project.ui.common.SpinnerPanel;

@SuppressWarnings("serial")
public class BookInfoP extends JPanel {
	protected JTextField tfAddPublisher;
	protected JButton btnBookSearch;
	protected JButton btnAddPublisher;
	private BookCodePanel pBCode;
	private InputComp pAuthor;
	private InputComp pBName;
	private SpinnerPanel pPrice;
	protected ComboBoxPanel pPublisher;
	private JPanel panel_2;
	private JPanel pPubAdd;
	private Coden coden;

	public BookInfoP() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(5, 2, 0, 10));

		JPanel ppBookCode = new JPanel();
		panel.add(ppBookCode);
		ppBookCode.setLayout(new GridLayout(0, 2, 5, 0));

		pBCode = new BookCodePanel();
		ppBookCode.add(pBCode);

		JPanel panel_6 = new JPanel();
		ppBookCode.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 5, 0));

		btnBookSearch = new JButton("도서검색");
		panel_6.add(btnBookSearch);

		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1);

		JPanel ppBName = new JPanel();
		panel.add(ppBName);
		ppBName.setLayout(new GridLayout(0, 2, 5, 0));

		pBName = new InputComp();
		pBName.setTitle("도  서  명");
		ppBName.add(pBName);

		JPanel panel_9 = new JPanel();
		ppBName.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 5, 0));

		pAuthor = new InputComp();
		pAuthor.setTitle("저       자");
		panel_4.add(pAuthor);

		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new GridLayout(0, 2, 5, 0));

		pPrice = new SpinnerPanel();
		pPrice.setValues(0, 0, 500000, 100);
		pPrice.setTitle("가       격");
		panel_5.add(pPrice);

		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);

		panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 5, 0));

		PublisherInfoService pis = new PublisherInfoService();
		List<PublisherInfo> list = pis.selectByAll();
		pPublisher = new ComboBoxPanel();
		pPublisher.setComboDate(list);
		pPublisher.getComboBox().addItem(new PublisherInfo());
		pPublisher.setTitle("출  판  사");
		panel_2.add(pPublisher);

		pPubAdd = new JPanel();

		// showPubAdd();

	}

	public void showPubAdd() {

		panel_2.add(pPubAdd);
		pPubAdd.setLayout(new GridLayout(0, 2, 5, 0));

		tfAddPublisher = new JTextField();
		pPubAdd.add(tfAddPublisher);
		tfAddPublisher.setColumns(10);

		btnAddPublisher = new JButton("추가");
		pPubAdd.add(btnAddPublisher);
		pPubAdd.revalidate();
		pPubAdd.repaint();
	}

	public void hidePubAdd() {
		pPubAdd.removeAll();
		pPubAdd.revalidate();
		pPubAdd.repaint();
	}

	public JTextField getTfAddPublisher() {
		return tfAddPublisher;
	}

	public JButton getBtnBookSearch() {
		return btnBookSearch;
	}

	public JButton getBtnAddPublisher() {
		return btnAddPublisher;
	}

	public void setClear() {
		pBCode.setTfBCode("");
		pBCode.setTfBSubCode("");
		pBName.setTFValue("");
		pAuthor.setTFValue("");
		pPrice.setValue(0);
		pPublisher.setSelected(0);
		if (tfAddPublisher != null) {
			tfAddPublisher.setText("");
		}
	}

	public boolean isVaildCheck() {
		try {
			pBCode.isEmptyCheck();
			pBName.isEmptyCheck();
			pAuthor.isEmptyCheck();
			pBCode.isValidCheck();
			pBName.isValidCheck("^[a-zA-Z가-힣\\s]+$", "한글 또는 영문만 가능");
			pAuthor.isValidCheck("^[a-zA-Z가-힣\\s]+$", "한글 또는 영문만 가능");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}

	}

	public BookInfo getObject() {
		String bCode = pBCode.getTfBCode().getText();
		String bSubCode = pBCode.getTfBSubCode().getText();
		String bName = pBName.getTFValue();
		Map<String, Object> param = new HashMap<>();
		param.put("cCode", pBCode.getTfBCode().getText().charAt(0) + "");
		Coden coden = CodenService.getInstance().selectOne(param);
		String author = pAuthor.getTFValue();
		PublisherInfo publisherInfo = (PublisherInfo) pPublisher.getCombItem();
		int price = (int) pPrice.getValue();
		return new BookInfo(bCode, bSubCode, coden, bName, author, publisherInfo, price);
	}

	public void setObject(BookInfo bookInfo) {
		pBCode.setTfBCode(bookInfo.getbCode());
		pBCode.setTfBSubCode(bookInfo.getbSubCode());
		pBName.setTFValue(bookInfo.getbName());
		pAuthor.setTFValue(bookInfo.getAuthor());
		pPrice.setValue(bookInfo.getPrice());
		pPublisher.setSelectedTT(bookInfo.getPublisherInfo());
		if (tfAddPublisher != null) {
			tfAddPublisher.setText("");
		}
	}

	public ComboBoxPanel getpPublisher() {
		return pPublisher;
	}

	public BookCodePanel getpBCode() {
		return pBCode;
	}

	public InputComp getpBName() {
		return pBName;
	}

	public InputComp getpAuthor() {
		return pAuthor;
	}

	public SpinnerPanel getpPrice() {
		return pPrice;
	}

	public void setCoden(Coden coden) {
		this.coden = coden;
	}
	

}
