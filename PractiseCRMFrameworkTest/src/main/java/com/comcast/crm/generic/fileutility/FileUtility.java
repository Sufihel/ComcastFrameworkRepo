package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	public String getdatafrompropertiesfile(String key) throws Throwable {
		FileInputStream fileInputStream = new FileInputStream("./configAppData/commondata.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String data = properties.getProperty(key);
		return data;

	}
}
