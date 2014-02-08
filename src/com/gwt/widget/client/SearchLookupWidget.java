package com.gwt.widget.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Overflow;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.widget.model.IGroupResult;

public class SearchLookupWidget extends Composite {

	private static SearchLookupWidgetUiBinder uiBinder = GWT.create(SearchLookupWidgetUiBinder.class);

	interface SearchLookupWidgetUiBinder extends UiBinder<Widget, SearchLookupWidget> {
	}

	@UiField
	TextBox searchBox;

	@UiField
	PopupPanel resultDialog;

	IResultView resultView;

	IResultFetcher resultFetcher;

	public SearchLookupWidget() {
		initWidget(uiBinder.createAndBindUi(this));

		searchBox.addKeyUpHandler(new KeyUpHandler() {

			@Override
			public void onKeyUp(KeyUpEvent event) {
				List<IGroupResult> listOfResults = resultFetcher.fetchData(searchBox.getValue());
				resultView.setValue(listOfResults);
				resultDialog.clear();
				resultDialog.add(resultView);
				showDialog();
			}
		});
		searchBox.addFocusHandler(new FocusHandler() {

			@Override
			public void onFocus(FocusEvent event) {
				String value = searchBox.getValue();
				if (value != null && value.length() > 0) {
					showDialog();
				}

			}
		});
	}

	private void showDialog() {
		resultDialog.getElement().getStyle().setWidth(362, Unit.PX);
		// resultDialog.getElement().getStyle().setHeight(200, Unit.PX);
		resultDialog.getElement().getStyle().setOverflow(Overflow.AUTO);
		resultDialog.showRelativeTo(searchBox);
	}

	public IResultView getResultView() {
		return resultView;
	}

	public void setResultView(IResultView resultView) {
		this.resultView = resultView;
	}

	public IResultFetcher getResultFetcher() {
		return resultFetcher;
	}

	public void setResultFetcher(IResultFetcher resultFetcher) {
		this.resultFetcher = resultFetcher;
	}

}
