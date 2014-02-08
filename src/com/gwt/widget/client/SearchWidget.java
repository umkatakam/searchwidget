package com.gwt.widget.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class SearchWidget implements EntryPoint {

	@Override
	public void onModuleLoad() {
		RootPanel.get().add(getSearchWidget());

	}

	private SearchLookupWidget getSearchWidget() {
		SearchLookupWidget searchLookupWidget = new SearchLookupWidget();
		searchLookupWidget.setResultView(new DefaultResultView());
		searchLookupWidget.setResultFetcher(new DefaultResultFetcher());
		return searchLookupWidget;
	}

}
