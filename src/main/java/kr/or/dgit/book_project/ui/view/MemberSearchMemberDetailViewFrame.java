package kr.or.dgit.book_project.ui.view;

import kr.or.dgit.book_project.ui.common.InformDetailPanel;
import kr.or.dgit.book_project.ui.component.MemberInfoP;

public class MemberSearchMemberDetailViewFrame extends InformDetailPanel {

	private MemberInfoP memberInfoP;

	public MemberSearchMemberDetailViewFrame() {

		memberInfoP = new MemberInfoP();
		pContent.add(memberInfoP);
		setOption("- 회원정보 -", "탈퇴");
	}

	public MemberInfoP getPanel() {
		return memberInfoP;
	}

}
