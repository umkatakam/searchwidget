package com.gwt.widget.model;

public class SimpleResultItem implements IResultItem {

	String displayString;

	@Override
	public String getDisplayString() {
		return displayString;
	}

	@Override
	public void setDisplayString(String value) {
		this.displayString = value;

	}

}
