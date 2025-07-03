package com.comcast.crm.generic.fileutility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JasonUtility {
	public String getdatafromjasonfile(String key) throws Throwable {
		JSONParser parser = new JSONParser();
		Object object = parser.parse(new FileReader("./configAppData/appCommonData.json"));
		JSONObject mapJsonObject = (JSONObject) object;
		String dataString = mapJsonObject.get(key).toString();
		return dataString;

	}

}
