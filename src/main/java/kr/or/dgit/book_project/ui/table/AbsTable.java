package kr.or.dgit.book_project.ui.table;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public abstract class AbsTable<T> extends JPanel {
	protected JTable table;
	private JPopupMenu popupMenu;

	public AbsTable() {
		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3) {
					popupMenu.show(table, e.getX(), e.getY());
				}
			}

		});
		createPopupMenu();
	}

	
	

	public boolean loadData() {
		Object[][] rowData= getRowData();
		
		// 검색결과가 없을 때, 로드데이터가 넘어가면서 빈 화면이 나오는 것을 전체 목록 보기로 출력
		if(rowData.length == 0){
			System.out.println("[loadData] length : 0");
			return false;
		}
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
	
	protected abstract void createPopupMenu();
	
	/*private JPopupMenu createPopupMenu() {
		popupMenu = new JPopupMenu();

		JMenuItem updateItem = new JMenuItem("수정");
		updateItem.addActionListener(new ActionListener() {
		

			@Override
			public void actionPerformed(ActionEvent e) {
				T t = getSelectedObject();
				if (t == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				updateData(t);
			}
		});
		popupMenu.add(updateItem);

		JMenuItem deleteItem = new JMenuItem("삭제");
		deleteItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				T t = getSelectedObject();
				if (t == null) {
					JOptionPane.showMessageDialog(null, "데이터를 선택하세요");
					return;
				}
				int res = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까", "", JOptionPane.YES_NO_OPTION);
				if (res != 0) {
					JOptionPane.showMessageDialog(null, "취소하였습니다");
					return;
				}

				deleteItem(t);
				loadData();
				JOptionPane.showMessageDialog(null, "삭제되었습니다");

			}

		});
		popupMenu.add(deleteItem);

		return null;
	}*/

	protected abstract void updateData(T t);

	protected abstract void deleteItem(T t);

	protected abstract void cellWith();

	protected abstract void CellAlign();

	protected abstract Object[][] getRowData();

	protected abstract Object[] getColumn();

	public abstract T getSelectedObject();

}
