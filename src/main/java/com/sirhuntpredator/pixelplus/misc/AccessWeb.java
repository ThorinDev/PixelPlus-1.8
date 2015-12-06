package com.sirhuntpredator.pixelplus.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class AccessWeb {

	
		public static void sendGet(String USER_AGENT, String url) throws Exception
		{
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", USER_AGENT);
			int responseCode = con.getResponseCode();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		}
		public static String downloadFile(String url) throws IOException
		{
			URL url2 = new URL(url);
			URLConnection urlConnection = url2.openConnection();
			urlConnection.setConnectTimeout(1000);
			urlConnection.setReadTimeout(1000);
			BufferedReader breader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	
			StringBuilder stringBuilder = new StringBuilder();
	
			String line;
			while((line = breader.readLine()) != null) {
				stringBuilder.append(line);
			}
	
			return stringBuilder.toString();
		}
	

}
