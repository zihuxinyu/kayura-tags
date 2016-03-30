/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kayura.tags.types.RawString;
import org.kayura.tags.types.TagUtils;

/**
 * ComboTreeTag
 *
 * @author liangxia@live.com
 */
public class ComboTreeTag extends ComboTag {

	private static final long serialVersionUID = 8115052203978775212L;
	private static final Log logger = LogFactory.getLog(ComboTreeTag.class);

	private Boolean editable;

	private String url;
	private String method;
	private Boolean animate;
	private Boolean checkbox;
	private Boolean cascadeCheck;
	private Boolean onlyLeafCheck;
	private Boolean lines;
	private Boolean dnd;
	private Object data;
	private Object queryParams;
	private String formatter;
	private String filter;
	private String loader;
	private String loadFilter;

	@Override
	public String getEasyUITag() {
		return "combotree";
	}
	
	@Override
	public Boolean emptyBody() {

		return !isEmpty(url) || data != null;
	}
	
	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = super.makeOptions();

		putMap(map, "editable", editable);

		if (!isEmpty(method)) {
			if (TagUtils.METHOD_POST.equals(method.toUpperCase()) || 
				TagUtils.METHOD_GET.equals(method.toUpperCase())) {
				putMap(map, "method", method);
			} else {
				if (logger.isErrorEnabled()) {
					logger.error("定义的 method 值: " + method + " 无效。");
				}
			}
		}

		putMap(map, "url", url);
		putMap(map, "animate", animate);
		putMap(map, "checkbox", checkbox);
		putMap(map, "cascadeCheck", cascadeCheck);
		putMap(map, "onlyLeafCheck", onlyLeafCheck);
		putMap(map, "lines", lines);
		putMap(map, "dnd", dnd);

		if (data instanceof String) {
			data = RawString.make((String) data);
		}
		putMap(map, "data", data);

		if (queryParams instanceof String) {
			queryParams = RawString.make((String) queryParams);
		}
		putMap(map, "queryParams", queryParams);

		putMap(map, "formatter", RawString.make(formatter));
		putMap(map, "filter", RawString.make(filter));
		putMap(map, "loader", RawString.make(loader));
		putMap(map, "loadFilter", RawString.make(loadFilter));

		return map;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Boolean getAnimate() {
		return animate;
	}

	public void setAnimate(Boolean animate) {
		this.animate = animate;
	}

	public Boolean getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(Boolean checkbox) {
		this.checkbox = checkbox;
	}

	public Boolean getCascadeCheck() {
		return cascadeCheck;
	}

	public void setCascadeCheck(Boolean cascadeCheck) {
		this.cascadeCheck = cascadeCheck;
	}

	public Boolean getOnlyLeafCheck() {
		return onlyLeafCheck;
	}

	public void setOnlyLeafCheck(Boolean onlyLeafCheck) {
		this.onlyLeafCheck = onlyLeafCheck;
	}

	public Boolean getLines() {
		return lines;
	}

	public void setLines(Boolean lines) {
		this.lines = lines;
	}

	public Boolean getDnd() {
		return dnd;
	}

	public void setDnd(Boolean dnd) {
		this.dnd = dnd;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Object getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Object queryParams) {
		this.queryParams = queryParams;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public String getFilter() {
		return filter;
	}

	public void setFilter(String filter) {
		this.filter = filter;
	}

	public String getLoader() {
		return loader;
	}

	public void setLoader(String loader) {
		this.loader = loader;
	}

	public String getLoadFilter() {
		return loadFilter;
	}

	public void setLoadFilter(String loadFilter) {
		this.loadFilter = loadFilter;
	}

}
