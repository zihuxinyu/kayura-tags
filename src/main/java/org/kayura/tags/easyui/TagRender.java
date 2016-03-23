/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.kayura.tags.types.RawString;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * EasyUI 标签库基础渲染器。
 *
 * @author liangxia@live.com
 */
public abstract class TagRender extends BodyTagSupport {

	private static final long serialVersionUID = -2565725992851402935L;
	private static final Log logger = LogFactory.getLog(TagRender.class);
	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		// 不生成值为 null 的属性.
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

	public static final String METHOD_POST = "POST";
	public static final String METHOD_GET = "GET";

	public static final String ANIMATION_SLIDE = "slide";
	public static final String ANIMATION_FADE = "fade";
	public static final String ANIMATION_SHOW = "show";

	private String classStyle;
	private String style;

	public String getName() {
		return "";
	}

	/**
	 * 获取 EasyUI 定义的标签样式名.
	 */
	public abstract String getEasyUITag();

	/**
	 * 获取 EasyUI 标签使用的 HTML 标签名,默认使用 div 标签.
	 */
	public String getHtmlTag() {
		return "div";
	}

	/**
	 * 当生成标签时的用于添加属性，如：&lt;div {动作} &gt;&lt;/div&gt;
	 * 
	 * @param writer
	 */
	public void doRenderProperty(JspWriter out) throws Exception {

	}

	/**
	 * 当生成标签内容时的动作，如：&lt;div&gt;{动作}&lt;/div&gt;
	 * 
	 * @param writer
	 */
	public void doRenderBody(JspWriter out) throws Exception {

	}

	public abstract Map<String, Object> makeOptions();

	public void putMap(Map<String, Object> map, String key, Object value) {
		if (value != null) {
			map.put(key, value);
		}
	}

	public String json(Object value) {
		String s = null;
		try {
			s = objectMapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			if (logger.isErrorEnabled()) {
				logger.error(e.getMessage(), e);
			}
		}
		return s;
	}

	/**
	 * 将 EasyUI 选项参数集转换为字符表示形式.
	 * 
	 * @return
	 */
	public String optionsToString() {

		StringBuilder sb = new StringBuilder("");
		Map<String, Object> map = makeOptions();
		if (map != null) {
			for (Entry<String, Object> o : map.entrySet()) {

				Object v = o.getValue();
				if (v != null) {

					String k = o.getKey();
					if (v instanceof RawString) {
						String sv = ((RawString) v).getValue();
						if (!isEmpty(sv)) {
							sb.append("," + k + ":" + v.toString());
						}
					} else if (v instanceof Integer || v instanceof Boolean) {
						sb.append("," + k + ":" + v);
					} else if (v instanceof String || v instanceof Enum) {
						sb.append("," + k + ":\"" + v + "\"");
					} else if (v instanceof Object) {
						sb.append("," + k + ":").append(json(v));
					}
				}
			}
		}

		if (sb.length() > 0) {
			sb.delete(0, 1);
		}

		return sb.toString();
	}

	protected Boolean isEmpty(String value) {

		return value == null || "".equals(value.trim());
	}

	public void doBeforeStart(JspWriter out) throws Exception {

	}

	public void doAfterEnd(JspWriter out) throws Exception {

	}

	@Override
	public int doStartTag() {

		JspWriter out = this.pageContext.getOut();
		try {
			doBeforeStart(out);

			out.write("<" + this.getHtmlTag());
			if (!isEmpty(getId())) {
				out.write(" id=\"" + getId() + "\"");
			}
			if (getName() == null) {
				if (!isEmpty(getId())) {
					out.write(" name=\"" + getId() + "\"");
				}
			} else if (!isEmpty(getName())) {
				out.write(" name=\"" + getName() + "\"");
			}
			if (!isEmpty(getEasyUITag())) {
				if (!isEmpty(getClassStyle())) {
					out.write(" class=\"easyui-" + getEasyUITag() + " " + getClassStyle().trim() + "\"");
				} else {
					out.write(" class=\"easyui-" + getEasyUITag() + "\"");
				}
			} else {
				if (!isEmpty(getClassStyle())) {
					out.write(" class=\"" + getClassStyle().trim() + "\"");
				}
			}
			doRenderProperty(out);
			if (!isEmpty(getStyle())) {
				out.write(" style=\"" + getStyle() + "\"");
			}
			String options = optionsToString();
			if (!isEmpty(options)) {
				options = options.replace('\'', '"');
				out.write(" data-options='" + options + "'");
			}
			out.write(">");
			doRenderBody(out);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e);
		}

		return EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.pageContext.getOut();
		try {
			out.write("</" + getHtmlTag() + ">\n");
			doAfterEnd(out);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	public String getClassStyle() {
		return this.classStyle;
	}

	public void setClassStyle(String classStyle) {
		this.classStyle = classStyle;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}
