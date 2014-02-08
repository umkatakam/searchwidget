package com.gwt.widget.client;

import java.util.List;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwt.widget.model.IGroupResult;

public class DefaultResultView extends Composite implements IResultView {

	private static DefaultResultViewUiBinder uiBinder = GWT.create(DefaultResultViewUiBinder.class);

	interface DefaultResultViewUiBinder extends UiBinder<Widget, DefaultResultView> {
	}

	@UiField
	HTMLPanel basePanel;

	public DefaultResultView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setValue(List<IGroupResult> result) {
		basePanel.clear();
		for (IGroupResult group : result) {
			GroupPanel groupPanel = new GroupPanel();
			groupPanel.ensureDebugId(group.getGroupTitle());
			groupPanel.setValue(group);
			basePanel.add(groupPanel);
		}
	}

	@Override
	public List<IGroupResult> getValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
