package kr.or.dgit.book_project.ui.table;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.book_project.dto.MemberInfo;
import kr.or.dgit.book_project.ui.view.MemberSearchMemberDetailViewFrame;
import kr.or.dgit.book_project.ui.view.MemberSearchMemberPaymentViewFrame;

public abstract class AbsTable<T> extends JPanel {
	
	protected JTable table;	
	private MemberInfoSearchTable pTable;
	protected JPopupMenu popupMenu;
	protected Map<String, Object> map;

	public AbsTable() {
		setLayout(new BorderLayout(0, 0));

		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(table);
		
		add(scrollPane);
	}
	
	public boolean loadData() {
		Object[][] rowData= getRowData();
		// 검색결과가 없을 때, 로드데이터가 넘어가면서 빈 화면이 나오는 것을 전체 목록 보기로 출력
		/*if(rowData.length == 0){
			System.out.println("[loadData] length : 0");
			return false;
			// 이거하니까 테이블에 데이터 한개도 안 남게 되면 테이블 새로고침이 안됨 ㅠㅠ
		}*/
		
		table.setModel(new DefaultTableModel(rowData, getColumn()) {
		
			@Override
			public boolean isCellEditable(int row, int column) {
				// Cell 항목 더블클릭해도 수정되지 않게함
				return false;
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// cell 두개이상 선택 불가. 한개만 선택가능
		CellAlign();
		cellWith();
		return true;
	}

	protected void tableSetWidth(int... width) {
		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < width.length; i++) {
			tcm.getColumn(i).setPreferredWidth(width[i]);
		}
	}

	protected void tableCellAlignment(int align, int... idx) {
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(align);

		TableColumnModel tcm = table.getColumnModel();
		for (int i = 0; i < idx.length; i++) {
			tcm.getColumn(idx[i]).setCellRenderer(dtcr);
		}
	}

	public JTable getTable() {
		return table;
	}
	public void setMap(Map<String, Object> map) {
		// 데이터 검색조건 지정
		this.map = map;
	}

	protected abstract void cellWith();

	protected abstract void CellAlign();

	protected abstract Object[][] getRowData();

	protected abstract Object[] getColumn();

	public abstract T getSelectedObject();
	
	
	

}
