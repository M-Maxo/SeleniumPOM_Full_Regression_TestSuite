package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonDataReader {
	
	public String firstname, lastname, email, password;
	
	public void JsonReader() throws FileNotFoundException, IOException, ParseException
	{
		String filePath = System.getProperty("user.dir")+ "/src/test/java/data/userDataJSON.json";
		
		File srcFile = new File(filePath);
		
		JSONParser parser = new JSONParser();   // to parse all contentin json file
		JSONArray  jarray = (JSONArray)parser.parse(new FileReader(srcFile)); // to read all json data in json file
		
		for(Object jsonObj : jarray)
		{
			JSONObject person = (JSONObject) jsonObj;
			
			firstname = (String) person.get("firstName");
			System.out.println(firstname);
			lastname  = (String) person.get("lastName");
			System.out.println(lastname);
			email     = (String) person.get("email");
			System.out.println(email);
			password  = (String) person.get("password");
			System.out.println(password);
		}
		
	}

}
