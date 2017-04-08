package kr.or.dgit.book_project.ui.component;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Properties;

import javax.swing.JPanel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.dto.PaymentIO;
import kr.or.dgit.book_project.ui.common.CompPanel;
import kr.or.dgit.book_project.ui.common.InputComp;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.awt.BorderLayout;
import javax.swing.SpringLayout;

public class BookLendMemberDetailDate extends JPanel {

	private InputComp pMCode;
	private InputComp pMName;
	private InputComp pMTel;
	private InputComp pLendDate;
	private CompPanel pReturnDate;
	private SpringLayout springLayout;
	private JDatePickerImpl datePicker;
	private JDatePanelImpl datePanel;
	private UtilDateModel model;

	/**
	 * Create the panel.
	 */
	public BookLendMemberDetailDate() {
		setLayout(new GridLayout(0, 1, 0, 10));
		
		pMCode = new InputComp();
		add(pMCode);
		pMCode.setTitle("회원코드");
		
		pMName = new InputComp();
		add(pMName);
		pMName.setTitle("성명");
		
		pMTel = new InputComp();
		add(pMTel);
		pMTel.setTitle("전화번호");
		
		
		pLendDate = new InputComp();
		pLendDate.setTitle("대 여 일");
		add(pLendDate);
		
		pReturnDate = new CompPanel();
		pReturnDate.setTitle("반 납 일");
		model = new UtilDateModel();
		datePanel = new JDatePanelImpl(model);
		pReturnDate.getpContent().setLayout(new BorderLayout(0, 0));
		datePicker = new JDatePickerImpl(datePanel);
		//springLayout.putConstraint(SpringLayout.NORTH, datePicker.getJFormattedTextField(), -23, SpringLayout.SOUTH, datePicker);
		//springLayout.putConstraint(SpringLayout.SOUTH, datePicker.getJFormattedTextField(), 19, SpringLayout.SOUTH, datePicker);
		//springLayout = (SpringLayout) datePicker.getLayout();
		//pReturnDate.setpContent(datePicker);
		pReturnDate.getpContent().add(datePicker, BorderLayout.CENTER);
		add(pReturnDate);
		/*//달력 창에 오늘날짜 표시
		p.put("text.today", "오늘");
		//입력창 폰트설정
		datePicker.getJFormattedTextField().setFont(new Font("굴림", Font.PLAIN, 12));
		//달력 창 크기 조절
		datePanel.getComponent(0).setPreferredSize(new Dimension(250, 190));
    
        model.setValue(today);
 
		model.setSelected(true);*/
		/*JXDatePicker dxd = new JXDatePicker();
		pReturnDate.getpContent().add(dxd);
		add(pReturnDate);*/

		/*JXDatePicker dxd = new JXDatePicker();
	    panel.add(dxd);*/
	}
	
	public PaymentIO getObject(){
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setmCode(pMCode.getTFValue());
		memberInfo.setmName(pMName.getTFValue());
		memberInfo.setmTel(pMTel.getTFValue());
		String lendDate = pLendDate.getTFValue();
		String returnDate = datePicker.getJFormattedTextField().getText();
		return new PaymentIO(memberInfo, lendDate, returnDate);
	}
	
	public void setObject(PaymentIO paymentio){
		pMCode.setTFValue(paymentio.getMemberInfo().getmCode());
		pMName.setTFValue(paymentio.getMemberInfo().getmName());
		pMTel.setTFValue(paymentio.getMemberInfo().getmTel());
		pLendDate.setTFValue(paymentio.getLendDate());
		// 필요한지 모르겟지만 일딴 뺌
		/*pReturnDate.date(paymentio.getReturnDate());*/
	}
	
	public String returnMsg(){
		return datePicker.getJFormattedTextField().getText();
	}
}
