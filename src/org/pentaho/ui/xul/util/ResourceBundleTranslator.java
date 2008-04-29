package org.pentaho.ui.xul.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.pentaho.ui.xul.impl.XulWindowContainer;



public class ResourceBundleTranslator {
	private static final Log logger = LogFactory.getLog(ResourceBundleTranslator.class);

	public static String translate(InputStream input, ResourceBundle bundle) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		
		StringBuffer buf = new StringBuffer();
		String line;
		while((line = reader.readLine()) != null){
			buf.append(line);
		}

		String template = buf.toString();
		
		Pattern pattern = Pattern.compile("\\$\\{([^\\}]*)\\}");
		
		 Matcher m = pattern.matcher(template);
		 StringBuffer sb = new StringBuffer();
		 while (m.find()) {
		     m.appendReplacement(sb, ResourceBundleTranslator.getTranslatedValue(m.group(1), bundle));
		 }
		 m.appendTail(sb);
		 
		return sb.toString();
	}
	
	private static String getTranslatedValue(	String key, ResourceBundle bundle){
		System.out.println(key);

		try{
			return bundle.getString(key);
		} catch(MissingResourceException e){
			logger.info(String.format("Translation Error: Missing key from ResourceBundle (%s)", key));
			return key;
		}
	}
}