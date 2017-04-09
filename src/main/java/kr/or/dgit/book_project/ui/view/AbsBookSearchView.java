package kr.or.dgit.book_project.ui.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import kr.or.dgit.book_project.dto.BookInfo;
import kr.or.dgit.book_project.ui.component.BookSearchPanel;
import kr.or.dgit.book_project.ui.table.AbsTable;
import kr.or.dgit.book_project.ui.table.BookSearchTable;

public abstract class AbsBookSearchView extends JPanel implements ActionListener {

	protected AbsTable<BookInfo> pTable;
	protected BookSearchPanel pContent;
	protected Map<String, Object> map;
	protected BookInsertView bookInsertView;
	protected JPopupMenu popupMenu;

	public AbsBookSearchView() {
		setBorder(new EmptyBorder(20, 20, 20, 20));

		pContent = new BookSearchPanel();
		pContent.getBtnSearch().addActionListener(this);
		setLayout(new GridLayout(0, 1, 0, 20));
		add(pContent);

		pTable = new BookSearchTable();

		System.out.println("abs에서 테이블 set 전" + pTable);
		add(pTable);
	}

	public AbsTable<BookInfo> getpTable() {
		return pTable;
	}
	public void setpTable(AbsTable<BookInfo> pTable) {
		this.pTable = pTable;
		System.out.println("abs에서 테이블 set 후" + this.pTable);
	}
	
	public BookSearchPanel getpContent() {
		return pContent;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void loadTable() {
		pTable.setMap(map);
		System.out.println("abs에서 맵" + map);
		pTable.loadData();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == pContent.getBtnSearch()) {
			actionPerformedPContentBtnSearch(e);
		}
	}

	protected void actionPerformedPContentBtnSearch(ActionEvent e) {
		Map<String, Object> param = pContent.getValueForSearch();
		if (param.isEmpty()) {
			// 검색 조건이 체크되어있지 않은 경우
			pTable.setMap(map);
			pTable.loadData();
			JOptionPane.showMessageDialog(null, "검색하고 싶은 항목을 선택해주세요");
		} else {
			// 검색하기

			for (String key : map.keySet()) {
				// 대여중인지.. 폐기된 도서인지.... 
				// 창을 띄울떄 사용된 기본조건을 검색조건으로 추가합니다.
				param.put(key, map.get(key));
			}

			pTable.setMap(param);
			pTable.loadData();
			pContent.clearAll();
		}
	}

	protected void addPopupMenu() {
		(pTable.getTable()).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					createPopupMenu();
					popupMenu.show(pTable.getTable(), e.getX(), e.getY());
					// show(활성화될 컴포넌트, X좌표, Y좌표)
				}
			}
		});
	}

	protected abstract void createPopupMenu();

	
}
