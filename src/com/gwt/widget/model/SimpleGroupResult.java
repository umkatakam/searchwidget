package com.gwt.widget.model;

import java.util.List;

public class SimpleGroupResult implements IGroupResult {

	String groupTitle;

	List<IResultItem> resultList;

	@Override
	public String getGroupTitle() {
		return groupTitle;
	}

	@Override
	public void setGroupTitle(String title) {
		this.groupTitle = title;

	}

	@Override
	public List<IResultItem> getResultList() {
		return resultList;
	}

	@Override
	public void setResultList(List<IResultItem> resultList) {
		this.resultList = resultList;
	}

}
