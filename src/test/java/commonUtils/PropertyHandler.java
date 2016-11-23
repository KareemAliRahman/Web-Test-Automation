package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyHandler{

   private static PropertyHandler instance = null;

   private Properties props = null;

   private PropertyHandler(){
	   FileInputStream input = null;
	try {
		input = new FileInputStream("src/test/resources/config.properties");
		props = new Properties();
		this.props.load(input);
		input.close();
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e){
		e.printStackTrace();
	}
   }

   public static synchronized PropertyHandler getInstance(){
       if (instance == null)
           instance = new PropertyHandler();
       return instance;
   }

   public String getValue(String propKey){
       return this.props.getProperty(propKey);
   }
}