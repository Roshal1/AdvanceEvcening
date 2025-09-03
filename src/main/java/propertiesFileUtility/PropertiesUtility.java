package propertiesFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {

	public String getdatafromPropertiesfile(String key) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream("./ConfigData/ninzaCrmCommondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
		

	}

}
