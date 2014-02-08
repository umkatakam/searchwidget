package com.gwt.widget.client;

import java.util.List;

import com.gwt.widget.model.IGroupResult;

public interface IResultFetcher {

	List<IGroupResult> fetchData(String queryString);

}
