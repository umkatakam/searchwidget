package com.gwt.widget.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.LIElement;
import com.google.gwt.dom.client.UListElement;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.widget.model.IGroupResult;
import com.gwt.widget.model.IResultItem;

public class GroupPanel extends Composite {

	private static GroupPanelUiBinder uiBinder = GWT.create(GroupPanelUiBinder.class);

	interface GroupPanelUiBinder extends UiBinder<Widget, GroupPanel> {
	}

	@UiField
	HTMLPanel header;

	@UiField
	UListElement unorderedListElement;

	public GroupPanel() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setValue(IGroupResult result) {
		header.getElement().setInnerText(result.getGroupTitle());
		for (IResultItem item : result.getResultList()) {
			LIElement liElement = Document.get().createLIElement();
			liElement.setInnerText(item.getDisplayString());
			unorderedListElement.appendChild(liElement);
		}
	}

	@Override
	protected void onEnsureDebugId(String baseID) {
		header.ensureDebugId("header" + baseID);
	}
}
