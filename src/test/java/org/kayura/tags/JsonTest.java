/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.tags;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.kayura.tags.easyui.types.Toolbar;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JsonTest
 *
 * @author liangxia@live.com
 */
public class JsonTest {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	static {
		objectMapper.setSerializationInclusion(Include.NON_NULL);
	}

	@Test
	public void test() {

		List<Toolbar> t2 = new ArrayList<Toolbar>();
		json(t2); // List<Toolbar>

		List<String> t3 = new ArrayList<String>();
		json(t3); // List<String>
	}

	public void json(Object value) {
		System.out.println("Object value");
	}

	public void json(List<Toolbar> toolbars) {
		System.out.println("List<Toolbar> value");
	}
}
