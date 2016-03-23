/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.jsp.JspWriter;

/**
 * 添加至布面中的页面块 BlockTag
 *
 * @author liangxia@live.com
 */
public class DockTag extends TagRender {

	private static final long serialVersionUID = 9143689507867555830L;

	public static final String REGION_NORTH = "north";
	public static final String REGION_SOUTH = "south";
	public static final String REGION_EAST = "east";
	public static final String REGION_WEST = "west";
	public static final String REGION_CENTER = "center";

	private String title;
	private String region;
	private Boolean border;
	private Boolean split;
	private String iconCls;
	private String href;
	private Boolean collapsible;
	private Integer minWidth;
	private Integer minHeight;
	private Integer maxWidth;
	private Integer maxHeight;

	@Override
	public String getEasyUITag() {
		return null;
	}

	@Override
	public void doRenderProperty(JspWriter out) throws Exception {

	}

	@Override
	public void doRenderBody(JspWriter out) throws Exception {

	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = new HashMap<String, Object>();

		putMap(map, "title", title);
		putMap(map, "region", region);
		putMap(map, "border", border);
		putMap(map, "split", split);
		putMap(map, "iconCls", iconCls);
		putMap(map, "href", href);
		putMap(map, "collapsible", collapsible);
		putMap(map, "minWidth", minWidth);
		putMap(map, "minHeight", minHeight);
		putMap(map, "maxWidth", maxWidth);
		putMap(map, "maxHeight", maxHeight);

		return map;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Boolean getBorder() {
		return border;
	}

	public void setBorder(Boolean border) {
		this.border = border;
	}

	public Boolean getSplit() {
		return split;
	}

	public void setSplit(Boolean split) {
		this.split = split;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Boolean getCollapsible() {
		return collapsible;
	}

	public void setCollapsible(Boolean collapsible) {
		this.collapsible = collapsible;
	}

	public Integer getMinWidth() {
		return minWidth;
	}

	public void setMinWidth(Integer minWidth) {
		this.minWidth = minWidth;
	}

	public Integer getMinHeight() {
		return minHeight;
	}

	public void setMinHeight(Integer minHeight) {
		this.minHeight = minHeight;
	}

	public Integer getMaxWidth() {
		return maxWidth;
	}

	public void setMaxWidth(Integer maxWidth) {
		this.maxWidth = maxWidth;
	}

	public Integer getMaxHeight() {
		return maxHeight;
	}

	public void setMaxHeight(Integer maxHeight) {
		this.maxHeight = maxHeight;
	}

}
