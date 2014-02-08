package com.gwt.widget.client;

import java.util.ArrayList;
import java.util.List;

import com.gwt.widget.model.IGroupResult;
import com.gwt.widget.model.IResultItem;
import com.gwt.widget.model.SimpleGroupResult;
import com.gwt.widget.model.SimpleResultItem;

public class DefaultResultFetcher implements IResultFetcher {

	@Override
	public List<IGroupResult> fetchData(String queryString) {
		List<IGroupResult> result = new ArrayList<IGroupResult>();
		for (int i = 0; i < 5; i++) {
			IGroupResult groupResult = new SimpleGroupResult();
			groupResult.setGroupTitle("Group Title - " + (i + 1));
			List<IResultItem> resultPerGroup = new ArrayList<IResultItem>();
			for (int j = 0; j < 5; j++) {
				IResultItem resultItem = new SimpleResultItem();
				resultItem.setDisplayString("Search Result - " + (j + 1));
				resultPerGroup.add(resultItem);
			}
			groupResult.setResultList(resultPerGroup);
			result.add(groupResult);
		}
		return result;
	}

}
