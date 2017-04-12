package kr.or.dgit.book_project.ui;

import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kr.or.dgit.book_project.ui.view.CodenChartView;
import kr.or.dgit.book_project.ui.view.RankPageView;
import kr.or.dgit.book_project.ui.view.RankPageViewCombo;

public class SubMenuPage3 extends JTabbedPane implements ChangeListener {

	private JPanel pAccBest;
	private JPanel pMonthBest;
	private JPanel pPartBest;
	private JPanel pMonthPartBest;
	private JPanel pPartRate;
	private JPanel pLendPartRate;

	public SubMenuPage3() {

		addChangeListener(this);
		pAccBest = new JPanel();
		addTab("누적 순위", null, pAccBest, null);

		pMonthBest = new JPanel();
		addTab("지난달 순위", null, pMonthBest, null);

		pPartBest = new JPanel();
		addTab("분야별 누적 순위", null, pPartBest, null);

		pMonthPartBest = new JPanel();
		addTab("분야별 지난달 순위", null, pMonthPartBest, null);

		pPartRate = new JPanel();
		addTab("도서 분야별 보유 비율", null, pPartRate, null);

		pLendPartRate = new JPanel();
		addTab("도서 분야별 대여 비율", null, pLendPartRate, null);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == this) {
			// 선택된 탭의 idx를 넘겨줌
			stateChangedThis(this.getSelectedIndex());
		}
	}

	private void stateChangedThis(int idx) {
		if (this.getTitleAt(idx).equals("누적 순위")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pAccBest.setLayout(new GridLayout(0, 1, 0, 0));
			pAccBest.removeAll();
			Map<String, Object> param = new HashMap<>();
			pAccBest.add(makeNewRankInfo(param, false));
		} else if (this.getTitleAt(idx).equals("지난달 순위")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pMonthBest.setLayout(new GridLayout(0, 1, 0, 0));
			pMonthBest.removeAll();
			Map<String, Object> param = new HashMap<>();
			param.put("lendDate1", "2017-03-01");
			param.put("lendDate2", "2017-04-01");
			pMonthBest.add(makeNewRankInfo(param, false));
		} else if (this.getTitleAt(idx).equals("분야별 누적 순위")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pPartBest.setLayout(new GridLayout(0, 1, 0, 0));
			pPartBest.removeAll();
			Map<String, Object> param = new HashMap<>();
			pPartBest.add(makeNewRankInfo(param, true));
		} else if (this.getTitleAt(idx).equals("분야별 지난달 순위")) {
			// 선택된 탭의 제목에 따라서 조건 지정
			pMonthPartBest.setLayout(new GridLayout(0, 1, 0, 0));
			pMonthPartBest.removeAll();
			Map<String, Object> param = new HashMap<>();
			param.put("lendDate1", "2017-03-01");
			param.put("lendDate2", "2017-04-01");
			pMonthPartBest.add(makeNewRankInfo(param, true));
		} else if (this.getTitleAt(idx).equals("도서 분야별 보유 비율")) {
			pPartRate.setLayout(new GridLayout(0, 1, 0, 0));
			// pPartRate.removeAll();
			CodenChartView cv = new CodenChartView();
			if (pPartRate.getComponentCount() == 0) {
				pPartRate.add(cv);
			}
			// pPartRate.revalidate();
			// pPartRate.repaint();
		}
	}

	public RankPageView makeNewRankInfo(Map<String, Object> param, boolean isComboBox) {

		if (!isComboBox) {
			// 콤보박스 아닐시
			RankPageView rankPageView = new RankPageView();
			// accBest.setViewTitle("누적 순위");
			rankPageView.setParam(param);
			rankPageView.setRankInfo();
			return rankPageView;
		} else {
			// 콤보박스 일시
			RankPageView rankPageViewCombo = new RankPageViewCombo();
			// monthPartBest.setViewTitle("분야별 지난달 순위");
			rankPageViewCombo.setParam(param);
			rankPageViewCombo.setRankInfo();
			return rankPageViewCombo;
		}
	}
}
