import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
 
import java.net.HttpURLConnection;

public class SendSMS {
	public static String sendSMS() {
		try {
			// Construct data
			String apiKey = "apikey=" + "92Ty3xk/0Iw-AuJhW3j5isFqUQbVreZAeHCSMOEy8O";
			String message = "&message=" + "This is first demo message";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "918700117804";
			String test = "&test=" + "true";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender + test;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}

class Test{
	public static void main(String ...args){
		System.out.println(SendSMS.sendSMS());
	}
}

//{"errors":[{"code":192,"message":"Messages can only be sent between 9am to 9pm as restricted by TRAI NCCP regulation"}],"status":"failure"}
