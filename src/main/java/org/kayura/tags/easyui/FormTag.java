/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

import org.kayura.tags.types.RawString;

/**
 * FormTag
 *
 * @author liangxia@live.com
 */
public class FormTag extends TagRender {

	private static final long serialVersionUID = 1370013979855555183L;

	private String method = "POST";
	private Boolean novalidate;
	private Boolean ajax;
	private Object queryParams;
	private String url;
	private Boolean multipart;

	@Override
	public String getEasyUITag() {
		return null;
	}

	@Override
	public String getHtmlTag() {
		return "form";
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = new HashMap<String, Object>();

		putMap(map, "novalidate", novalidate);
		putMap(map, "ajax", ajax);
		putMap(map, "url", url);

		if (queryParams instanceof String) {
			queryParams = RawString.make((String) queryParams);
		}
		putMap(map, "queryParams", queryParams);

		return map;
	}

	@Override
	public void doRenderProperty(JspWriter out) throws Exception {

		if (!isEmpty(getMethod())) {
			out.write(" method='" + getMethod() + "'");
		}

		if (multipart != null && multipart.booleanValue()) {
			out.write(" enctype=\"multipart/form-data\"");
		}
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Boolean getNovalidate() {
		return novalidate;
	}

	public void setNovalidate(Boolean novalidate) {
		this.novalidate = novalidate;
	}

	public Boolean getAjax() {
		return ajax;
	}

	public void setAjax(Boolean ajax) {
		this.ajax = ajax;
	}

	public Object getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Object queryParams) {
		this.queryParams = queryParams;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getMultipart() {
		return multipart;
	}

	public void setMultipart(Boolean multipart) {
		this.multipart = multipart;
	}

}
