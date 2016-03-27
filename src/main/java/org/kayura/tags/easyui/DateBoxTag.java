/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.easyui;

import java.util.Map;

import org.kayura.tags.types.RawString;

/**
 * DateBox
 *
 * @author liangxia@live.com
 */
public class DateBoxTag extends ComboTag {

	private static final long serialVersionUID = 6731391328830047501L;

	private Integer panelWidth;
	private Integer panelHeight;
	private String currentText;
	private String closeText;
	private String okText;
	private Boolean disabled;

	private String buttons;

	private String sharedCalendar;
	private String formatter;
	private String parser;

	private String onSelect;

	@Override
	public String getEasyUITag() {
		return "datebox";
	}

	@Override
	public Map<String, Object> makeOptions() {

		Map<String, Object> map = super.makeOptions();

		putMap(map, "panelWidth", panelWidth);
		putMap(map, "panelHeight", panelHeight);
		putMap(map, "closeText", closeText);
		putMap(map, "okText", okText);
		putMap(map, "disabled", disabled);

		putMap(map, "buttons", RawString.make(buttons));

		putMap(map, "sharedCalendar", RawString.make(sharedCalendar));
		putMap(map, "formatter", RawString.make(formatter));
		putMap(map, "parser", RawString.make(parser));

		putMap(map, "onSelect", RawString.make(onSelect));

		return map;
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

	public String getCurrentText() {
		return currentText;
	}

	public void setCurrentText(String currentText) {
		this.currentText = currentText;
	}

	public String getCloseText() {
		return closeText;
	}

	public void setCloseText(String closeText) {
		this.closeText = closeText;
	}

	public String getOkText() {
		return okText;
	}

	public void setOkText(String okText) {
		this.okText = okText;
	}

	public Boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(Boolean disabled) {
		this.disabled = disabled;
	}

	public String getButtons() {
		return buttons;
	}

	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	public String getSharedCalendar() {
		return sharedCalendar;
	}

	public void setSharedCalendar(String sharedCalendar) {
		this.sharedCalendar = sharedCalendar;
	}

	public String getFormatter() {
		return formatter;
	}

	public void setFormatter(String formatter) {
		this.formatter = formatter;
	}

	public String getParser() {
		return parser;
	}

	public void setParser(String parser) {
		this.parser = parser;
	}

	public String getOnSelect() {
		return onSelect;
	}

	public void setOnSelect(String onSelect) {
		this.onSelect = onSelect;
	}

}
