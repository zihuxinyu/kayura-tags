/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.Map;

/**
 * DataGridTag
 *
 * @author liangxia@live.com
 */
public class DataGridTag extends PanelTag {

	private static final long serialVersionUID = -5756005211714745895L;

	private Object columns;
	private Object frozenColumns;
	private Boolean fitColumns;
	private String resizeHandle;
	private Boolean autoRowHeight;
	private Object toolbar;
	private Boolean striped;
	private String method;
	private Boolean nowrap;
	private String idField;
	private String url;
	private Object data;
	private String loadMsg;
	private Boolean pagination;
	private Boolean rownumbers;
	private Boolean singleSelect;
	private Boolean ctrlSelect;
	private Boolean checkOnSelect;
	private Boolean selectOnCheck;
	private String pagePosition;
	private Integer pageNumber;
	private Integer pageSize;
	private Object pageList;
	private Object queryParams;
	private String sortName;
	private String sortOrder;
	private Boolean multiSort;
	private Boolean remoteSort;
	private Boolean showHeader;
	private Boolean showFooter;
	private Integer scrollbarSize;
	
	private String rowStyler;
	private String loader;
	private String loadFilter;
	
	@Override
	public String getEasyUITag() {
		return "datagrid";
	}

	@Override
	public String getHtmlTag() {
		return "table";
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = super.makeOptions();

		return map;
	}

}
