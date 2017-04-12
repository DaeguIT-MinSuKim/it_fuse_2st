package kr.or.dgit.book_project.post;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import kr.or.dgit.book_project.post.dto.Doro;
import kr.or.dgit.book_project.post.service.DoroService;

@SuppressWarnings("serial")
public class ZipTable extends JPanel {
	protected JTable table;
	protected DoroService doroService;

	public ZipTable() {
		setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public void loadData(String sido, String doro) {
		table.setModel(new DefaultTableModel(getRowData(sido, doro), getColumn()) {
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

	public String[] getSelectedObject() {
		int selectedIdx = table.getSelectedRow();
		System.out.println("selectedIdx : "+selectedIdx);
		if (selectedIdx == -1) {
			return null;
		}
		String zipcode = (String) table.getValueAt(selectedIdx, 0);
		String address = (String) table.getValueAt(selectedIdx, 1);

		return new String[] { zipcode, address };
	}

	protected void cellWith() {
		tableSetWidth(50, 200);
	}

	protected void CellAlign() {
		tableCellAlignment(SwingConstants.CENTER, 0);
		tableCellAlignment(SwingConstants.LEFT, 1);
	}

	protected Object[][] getRowData(String sido, String doro) {
		doroService = new DoroService();
		List<Doro> lists = doroService.selectDoroByDoro(sido, doro);
		Object[][] datas = new Object[lists.size()][];
		for (int i = 0; i < datas.length; i++) {
			Doro doro1 = lists.get(i);
			if (doro1.getBuilding2().equals("0")) {
				doro1.setBuilding2("");
			} else {
				doro1.setBuilding2("-" + doro1.getBuilding2());
			}
			datas[i] = doro1.toArray();
		}
		return datas;
	}

	protected Object[] getColumn() {
		return new String[] { "우편번호", "주소" };
	}

	public JTable getTable() {
		return table;
	}

}
