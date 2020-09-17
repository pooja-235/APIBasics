package files;

import io.restassured.path.json.JsonPath;

public class ReUseableMethods {
	public static JsonPath rawJson(String response) {
		JsonPath js=new JsonPath(response);
		return js;
	}

}
