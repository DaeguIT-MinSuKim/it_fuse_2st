package kr.or.dgit.book_project.ui.component;

import java.awt.GridLayout;
import java.util.List;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.JPanel;
import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.dto.PublisherInfo;
import kr.or.dgit.book_project.service.BookInfoService;
import kr.or.dgit.book_project.service.PublisherInfoService;
import kr.or.dgit.book_project.ui.common.BookCodePanel;
import kr.or.dgit.book_project.ui.common.ComboBoxPanel;
import kr.or.dgit.book_project.ui.common.InputComp;

public class BookInfoBasic extends JPanel {

	private BookCodePanel pBCode;
	private InputComp pBName;
	private InputComp pAuthor;
	private InputComp pPrice;
	private ComboBoxPanel<PublisherInfo> pPName;
	private InputComp pBLendCount;

	public BookInfoBasic() {
		setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panelBSub = new JPanel();
		add(panelBSub);
		panelBSub.setLayout(new GridLayout(6, 0, 0, 10));

		pBCode = new BookCodePanel();
		panelBSub.add(pBCode);

		pBName = new InputComp();
		pBName.setTitle("도  서  명");
		panelBSub.add(pBName);

		pAuthor = new InputComp();
		pAuthor.setTitle("저      자");
		panelBSub.add(pAuthor);

		pPrice = new InputComp();
		pPrice.setTitle("가      격");
		panelBSub.add(pPrice);

		pPName = new ComboBoxPanel();

		PublisherInfoService pis = new PublisherInfoService();
		List<PublisherInfo> list = pis.selectByAll();
		pPName.setComboDate(list);
		pPName.setTitle("출  판  사");
		panelBSub.add(pPName);

		pBLendCount = new InputComp();
		pBLendCount.setTitle("총 대여 횟수");
		panelBSub.add(pBLendCount);
	}

	public BookInfo getObject() {
		String bCode = pBCode.getTfBCode().getText();
		String bSubCode = pBCode.getTfBSubCode().getText();
		int price = Integer.parseInt(pPrice.getTFValue());
		String bName = pBName.getTFValue();
		String author = pAuthor.getTFValue();
		PublisherInfo publisherInfo = pPName.getCombItem();
		int bLendCount = Integer.parseInt(pBLendCount.getTFValue());
		return new BookInfo(bCode, bSubCode, bName, author, publisherInfo, price, bLendCount);

	}

	public void setObject(BookInfo bookinfo) {
		pBCode.setTfBCode(bookinfo.getbCode());
		pBCode.setTfBSubCode(bookinfo.getbSubCode());
		pBName.setTFValue(bookinfo.getbName());
		pAuthor.setTFValue(bookinfo.getAuthor());
		pPName.setSelectedTT(bookinfo.getPublisherInfo());
		pPrice.setTFValue(bookinfo.getPrice() + "");
		pBLendCount.setTFValue(bookinfo.getbLendCount() + "");
	}

	// 출납(반납)때 쓸꺼임 겟
	public PaymentIO getObjectP() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setbCode(pBCode.getTfBCode().getText());
		bookInfo.setbSubCode(pBCode.getTfBSubCode().getText());
		bookInfo.setbName(pBName.getTFValue());
		bookInfo.setAuthor(pAuthor.getTFValue());
		PublisherInfo publisherInfo = pPName.getCombItem();
		bookInfo.setPrice(Integer.parseInt(pPrice.getTFValue()));
		bookInfo.setbLendCount(Integer.parseInt(pBLendCount.getTFValue()));
		return new PaymentIO(bookInfo);
	}

	// 출납(반납)때 쓸꺼임 셋
	public void setObjectP(PaymentIO paymentio) {
		Map<String, Object> param = new HashMap<>();
		param.put("bCode", paymentio.getBookInfo().getbCode());
		param.put("bSubCode", paymentio.getBookInfo().getbSubCode());
		BookInfo bookInfo = BookInfoService.getInstance().selectBookInfoOne(param);
		pBCode.setTfBCode(bookInfo.getbCode());
		pBCode.setTfBSubCode(bookInfo.getbSubCode());
		pBName.setTFValue(bookInfo.getbName());
		pAuthor.setTFValue(bookInfo.getAuthor());
		pPName.setSelectedTT(bookInfo.getPublisherInfo());
		pPrice.setTFValue(bookInfo.getPrice() + "");
		pBLendCount.setTFValue(bookInfo.getbLendCount() + "");
	}

	public BookCodePanel getpBCode() {
		return pBCode;
	}

	public InputComp getpBLendCount() {
		return pBLendCount;
	}

	public void setEnable(boolean enabled) {
		pBCode.getTfBCode().setEnabled(enabled);
		pBCode.getTfBSubCode().setEnabled(enabled);
		pBLendCount.getTF().setEnabled(enabled);
	}
}
