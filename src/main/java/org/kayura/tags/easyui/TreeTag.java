/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import org.kayura.tags.easyui.types.TreeNode;
import org.kayura.tags.types.RawString;

/**
 * EasyUI Tree 组件, 支持 1.4.3 版。
 *
 * @author liangxia@live.com
 */
public class TreeTag extends TagRender {

	private static final long serialVersionUID = 7276686505986997478L;

	private String url;
	private String method;
	private Boolean animate;
	private Boolean checkbox;
	private Boolean cascadeCheck;
	private Boolean onlyLeafCheck;
	private Boolean lines;
	private Boolean dnd;
	private List<TreeNode> data;
	private Map<String, Object> queryParams;
	private String formatter;
	private String filter;
	private String loader;
	private String loadFilter;

	@Override
	public String getEasyUITag() {
		return "tree";
	}

	@Override
	public String getHtmlTag() {
		return "ul";
	}

	@Override
	public String getName() {
		return "";
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = new HashMap<String, Object>();

		if (!isEmpty(method)) {
			String m = method.toUpperCase();
			if (METHOD_POST.equals(m) || METHOD_GET.equals(m)) {
				map.put("method", method);
			}
		}

		map.put("url", url);
		map.put("animate", animate);
		map.put("checkbox", checkbox);
		map.put("cascadeCheck", cascadeCheck);
		map.put("onlyLeafCheck", onlyLeafCheck);
		map.put("lines", lines);
		map.put("dnd", dnd);

		map.put("data", data);
		map.put("queryParams", queryParams);

		if (!isEmpty(formatter)) {
			map.put("formatter", new RawString(formatter));
		}
		if (!isEmpty(filter)) {
			map.put("filter", new RawString(filter));
		}
		if (!isEmpty(loader)) {
			map.put("loader", new RawString(loader));
		}
		if (!isEmpty(loadFilter)) {
			map.put("loadFilter", new RawString(loadFilter));
		}

		return map;
	}

	@Override
	public void doRenderProperty(JspWriter out) {

	}

	@Override
	public void doRenderBody(JspWriter out) {

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

	public List<TreeNode> getData() {
		return data;
	}

	public void setData(List<TreeNode> data) {
		this.data = data;
	}

	public Map<String, Object> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, Object> queryParams) {
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
