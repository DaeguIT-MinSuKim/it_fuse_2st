package kr.or.dgit.book_project.ui.component;

import javax.swing.JPanel;

import kr.or.dgit.book_project.ui.common.OptionSearchTF;

import java.awt.GridLayout;

public class MemberSearchPanel extends JPanel {

	public MemberSearchPanel() {
		setLayout(new GridLayout(0, 1, 0, 10));

		OptionSearchTF pMCode = new OptionSearchTF();
		pMCode.setTitle("회원코드");
		add(pMCode);

		OptionSearchTF pMName = new OptionSearchTF();
		pMName.setTitle("성      명");
		add(pMName);

		OptionSearchTF pMTel = new OptionSearchTF();
		pMTel.setTitle("전화번호");
		add(pMTel);
	}
}
