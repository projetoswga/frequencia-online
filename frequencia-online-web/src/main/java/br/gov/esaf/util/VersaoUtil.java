package br.gov.esaf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component("versaoUtil")
public class VersaoUtil {

	public Properties getProperties() {
		InputStream in = getClass().getClassLoader().getResourceAsStream("frequencia.properties");
		Properties properties = new Properties();
		try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

	public String getVersao() {
		return getProperties().getProperty("build.version");
	}

	public String getHora() {
		return getProperties().getProperty("build.timestamp");
	}
}
