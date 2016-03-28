/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.Map;

import org.kayura.tags.types.RawString;

/**
 * ComboTag
 *
 * @author liangxia@live.com
 */
public class ComboTag extends ValidateBoxTag {

	private static final long serialVersionUID = 1354709622494115600L;

	private Integer width;
	private Integer height;
	private Integer panelWidth;
	private Integer panelHeight;
	private Integer panelMinWidth;
	private Integer panelMaxWidth;
	private Integer panelMinHeight;
	private Integer panelMaxHeight;
	private String panelAlign;
	private Boolean multiple;
	private Boolean selectOnNavigation;
	private String separator;
	private Boolean editable;
	private Boolean disabled;
	private Boolean readonly;
	private Boolean hasDownArrow;
	private String value;

	private String keyHandler;

	private String onShowPanel;
	private String onHidePanel;
	private String onChange;

	@Override
	public String getHtmlTag() {

		if (emptyBody()) {
			return "input";
		} else {
			return "select";
		}
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = super.makeOptions();

		putMap(map, "width", width);
		putMap(map, "height", height);
		putMap(map, "panelWidth", panelWidth);
		putMap(map, "panelHeight", panelHeight);
		putMap(map, "panelMinWidth", panelMinWidth);
		putMap(map, "panelMaxWidth", panelMaxWidth);
		putMap(map, "panelMinHeight", panelMinHeight);
		putMap(map, "panelMaxHeight", panelMaxHeight);
		putMap(map, "panelAlign", panelAlign);
		putMap(map, "multiple", multiple);
		putMap(map, "selectOnNavigation", selectOnNavigation);
		putMap(map, "separator", separator);
		putMap(map, "editable", editable);
		putMap(map, "disabled", disabled);
		putMap(map, "readonly", readonly);
		putMap(map, "hasDownArrow", hasDownArrow);
		putMap(map, "value", value);

		putMap(map, "keyHandler", RawString.make(keyHandler));
		putMap(map, "onShowPanel", RawString.make(onShowPanel));
		putMap(map, "onHidePanel", RawString.make(onHidePanel));
		putMap(map, "onChange", RawString.make(onChange));

		return map;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getPanelWidth() {
		return panelWidth;
	}

	public void setPanelWidth(Integer panelWidth) {
		this.panelWidth = panelWidth;
	}

	public Integer getPanelHeight() {
		return panelHeight;
	}

	public void setPanelHeight(Integer panelHeight) {
		this.panelHeight = panelHeight;
	}

	public Integer getPanelMinWidth() {
		return panelMinWidth;
	}

	public void setPanelMinWidth(Integer panelMinWidth) {
		this.panelMinWidth = panelMinWidth;
	}

	public Integer getPanelMaxWidth() {
		return panelMaxWidth;
	}

	public void setPanelMaxWidth(Integer panelMaxWidth) {
		this.panelMaxWidth = panelMaxWidth;
	}

	public Integer getPanelMinHeight() {
		return panelMinHeight;
	}

	public void setPanelMinHeight(Integer panelMinHeight) {
		this.panelMinHeight = panelMinHeight;
	}

	public Integer getPanelMaxHeight() {
		return panelMaxHeight;
	}

	public void setPanelMaxHeight(Integer panelMaxHeight) {
		this.panelMaxHeight = panelMaxHeight;
	}

	public String getPanelAlign() {
		return panelAlign;
	}

	public void setPanelAlign(String panelAlign) {
		this.panelAlign = panelAlign;
	}

	public Boolean getMultiple() {
		return multiple;
	}

	public void setMultiple(Boolean multiple) {
		this.multiple = multiple;
	}

	public Boolean getSelectOnNavigation() {
		return selectOnNavigation;
	}

	public void setSelectOnNavigation(Boolean selectOnNavigation) {
		this.selectOnNavigation = selectOnNavigation;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public Boolean getEditable() {
		return editable;
	}

	public void setEditable(Boolean editable) {
		this.editable = editable;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public Boolean getReadonly() {
		return readonly;
	}

	public void setReadonly(Boolean readonly) {
		this.readonly = readonly;
	}

	public Boolean getHasDownArrow() {
		return hasDownArrow;
	}

	public void setHasDownArrow(Boolean hasDownArrow) {
		this.hasDownArrow = hasDownArrow;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getKeyHandler() {
		return keyHandler;
	}

	public void setKeyHandler(String keyHandler) {
		this.keyHandler = keyHandler;
	}

	public String getOnShowPanel() {
		return onShowPanel;
	}

	public void setOnShowPanel(String onShowPanel) {
		this.onShowPanel = onShowPanel;
	}

	public String getOnHidePanel() {
		return onHidePanel;
	}

	public void setOnHidePanel(String onHidePanel) {
		this.onHidePanel = onHidePanel;
	}

	public String getOnChange() {
		return onChange;
	}

	public void setOnChange(String onChange) {
		this.onChange = onChange;
	}

}
