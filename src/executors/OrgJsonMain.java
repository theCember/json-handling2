package executors;
import org.json.*;
import java.io.*;

public class OrgJsonMain {

	public static String getJsonAsString(String file) throws IOException{
		StringBuilder sb = new StringBuilder();
		String ls = System.getProperty("line.separator");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null){
			sb.append(line);
			sb.append(ls);
		}
		return sb.toString();	
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		try {
			String json = getJsonAsString(args[0]);
			//System.out.println(json);
			JSONTokener jt = new JSONTokener(json);
			JSONObject jo = new JSONObject(jt);
			JSONArray ja = jo.getJSONArray("students");
			for(int i=0;i<ja.length();i++) {
				jo = ja.getJSONObject(i);
				System.out.println("Name: "+jo.getString("studentName"));
				System.out.println("ID: "+jo.getInt("studentID"));
			}
		}catch(IOException e){
			System.err.println("Couldn't read file: " + e.getMessage());
		}catch(JSONException e){
			System.err.println("Couldn't read json: " + e.getMessage());
		}
	}
	

}
