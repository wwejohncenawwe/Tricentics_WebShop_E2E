package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

	public Properties pro;
	public FileInputStream fi;

	public ReadConfig() {
		File f = new File("C:\\Users\\Mani\\IDE Workspace\\Webshop\\src\\test\\resources\\configuration\\config.properties");
		try {
			 fi = new FileInputStream(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		pro = new Properties();
		try {
			pro.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getApplicationUrl() {
		String url = pro.getProperty("url");
		return url;
	}

	public String getBrowser() {
		String browser = pro.getProperty("browser");
		return browser;
	}
}
