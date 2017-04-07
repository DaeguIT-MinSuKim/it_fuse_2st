package kr.or.dgit.book_project.ui.common;

import javax.swing.JPanel;

import java.util.List;

import javax.swing.JComboBox;

public class OptionSearchCmb<T> extends OptionSearchPanel {

	protected JComboBox comboBox;
	
	public OptionSearchCmb() {
		
		comboBox = new JComboBox();
		panel.add(comboBox);

	}
	public void setComboDate(List<T> items) {
		for (T t : items) {
			comboBox.addItem(t);
		}
	}

	public JComboBox<T> getComboBox() {
		return comboBox;
	}

	public T getCombT() {
		return (T) comboBox.getSelectedItem();
	}

	public void setComboBox(T item) {
		comboBox.addItem(item);
		comboBox.setSelectedIndex(0);
	}

	public void setSelected(int i) {
		comboBox.setSelectedIndex(i);
	}

	public void setSelectedTT(T item) {
		comboBox.setSelectedItem(item);
	}
	public void clear(){
		chbTitle.setSelected(false);
		comboBox.setSelectedIndex(0);
	}

	
}
