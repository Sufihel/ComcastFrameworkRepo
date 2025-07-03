package PractiseDataDrivenTesting;
import java.io.FileReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
public class ReadDataFromJason {

	public static void main(String[] args) throws Throwable, Throwable, Throwable {
		// step1: Parse jason physical file into java object using jason parse class
		JSONParser JSONparser = new JSONParser();
		Object object = JSONparser.parse(new FileReader(
				"C:\\Users\\saif\\Desktop\\sufi\\Tek Pyramid\\DataTransmittingFolder\\appCommonData.json"));

		// Step2: Convert java object into JSONobject using downcasting
		JSONObject map = (JSONObject) object;

		// Step3: Get the value from JSON file using key
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("username"));
		System.out.println(map.get("password"));
		System.out.println(map.get("timeout"));
	}

}
