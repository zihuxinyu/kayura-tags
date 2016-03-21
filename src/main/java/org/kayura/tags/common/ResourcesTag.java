/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.common;

import java.io.IOException;
import java.io.StringWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * ResourcesTag
 *
 * @author liangxia@live.com
 */
public class ResourcesTag extends SimpleTagSupport {

	private String location;

	@Override
	public void doTag() throws JspException, IOException {

		StringWriter sw = new StringWriter();
		this.getJspBody().invoke(sw);
		String content = removeBlank(sw.toString());

		String ctxPath = ((PageContext) this.getJspContext()).getServletContext().getContextPath();
		if (getLocation() != null) {
			setLocation(ctxPath + "/" + getLocation());
		} else {
			setLocation(ctxPath);
		}

		String[] fileNames = content.split("\r");
		if (fileNames != null) {

			JspWriter out = this.getJspContext().getOut();
			for (String name : fileNames) {

				String type = null;
				if (name.endsWith(".css")) {
					type = "text/css";
				} else if (name.endsWith(".js")) {
					type = "text/javascript";
				}

				if (type != null) {
					if (type.equals("text/css") || type.equals("css")) {
						out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"" + getLocation() + "/" + name + "\">\r");
					} else if (type.equals("text/javascript") || type.equals("js")) {
						out.write("<script type=\"text/javascript\" src=\"" + getLocation() + "/" + name + "\"></script>\r");
					}
				}
			}
		}
	}

	static String removeBlank(String str) {

		String dest = "";
		if (str != null) {
			Pattern p = Pattern.compile("\\n|\\t");
			Matcher m = p.matcher(str);
			dest = m.replaceAll("");
		}
		return dest;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
