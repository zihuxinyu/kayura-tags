/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags.types;

/**
 * RawString
 *
 * @author liangxia@live.com
 */
public class RawString {

	private String value;

	public RawString() {

	}

	public RawString(String value) {
		this.setValue(value);
	}

	@Override
	public String toString() {
		return getValue();
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
