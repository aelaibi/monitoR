package ma.neoxia.message.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class RestClient {

	@Test
	public void test() {
		//fail("Not yet implemented");
		try {

			URL url = new URL(
					"http://localhost:8080/message/rest/rsmessage/add");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");

			String input = "{         \"mb\": {             \"@type\": \"WARNING\",             \"dateEnvoi\": {                 \"$\": \"2013-01-18T00:00:00Z\"             },             \"dateServer\": {                 \"$\": \"2013-01-18T00:00:00Z\"             },             \"description\": {                 \"$\": \"aaaa\"             },             \"idApplication\": {                 \"$\": \"1\"             },             \"idDomaine\": {                 \"$\": \"1\"             },             \"idMessage\": {                 \"$\": \"1\"             },             \"message\": {                 \"$\": \"aaaa\"             },             \"nomApplication\": {                 \"$\": \"sysmonitor\"             },             \"nomDomaine\": {                 \"$\": \"domaine 1\"             }         }     }";

			OutputStream os = conn.getOutputStream();
			os.write(input.getBytes());
			os.flush();

			if (conn.getResponseCode() != HttpURLConnection.HTTP_CREATED) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}
