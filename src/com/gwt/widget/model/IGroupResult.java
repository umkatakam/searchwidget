package com.gwt.widget.model;

import java.util.List;

public interface IGroupResult {

	String getGroupTitle();

	void setGroupTitle(String title);

	List<IResultItem> getResultList();

	void setResultList(List<IResultItem> resultList);

}
