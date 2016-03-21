/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * BodyTag
 *
 * @author liangxia@live.com
 */
public class BodyTag extends TagRender {

	private static final long serialVersionUID = -7338802774183130605L;
	private static final Log logger = LogFactory.getLog(BodyTag.class);

	private Boolean full = false;

	@Override
	public String getEasyUITag() {
		return "layout";
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> options = new HashMap<String, Object>();
		options.put("full", full);
		return options;
	}

	@Override
	public int doStartTag() {
		JspWriter out = this.pageContext.getOut();
		try {

			out.write("<body");
			if (getFull()) {
				
				if (!isEmpty(getClassStyle())) {
					out.write(" class=\"easyui-" + getEasyUITag() + " " + getClassStyle() + "\"");
				} else {
					out.write(" class=\"easyui-" + getEasyUITag() + "\"");
				}
			} else {
				
				if (!isEmpty(getClassStyle())) {
					out.write(" class=\"" + getClassStyle() + "\"");
				}
				if (!isEmpty(getStyle())) {
					out.write(" style=\"" + getStyle() + "\"");
				}
			}
			out.write(">");

			if (getFull()) {

				out.write("<div data-options=\"region:'center',border:false\"");
				if (!isEmpty(getStyle())) {
					out.write(" style=\"" + getStyle() + "\"");
				}
				out.write(">\r");
			}

		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e);
		}

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {

		JspWriter out = this.pageContext.getOut();
		try {
			if (getFull()) {
				out.write("</div>");
			}
			out.write("</body>\r");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	@Override
	public void doRenderStart(JspWriter writer) {
	}

	@Override
	public void doRenderBody(JspWriter writer) {
	}

	public Boolean getFull() {
		return full;
	}

	public void setFull(Boolean full) {
		this.full = full;
	}

}
