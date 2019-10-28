package com.ayya.sport.utils;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class JsonUtils {

	public List<Object> listToJson(List<Object> o) {
		if (o.size() > 0) {
			System.out.println();
		}
		return o;
	}

	public Object toJson(Object o) {
		return o;
	}

}
