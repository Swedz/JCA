package me.Swedz.jca.web;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import me.Swedz.jca.JCA;

public class Web {
	public static String send(String requestUrl, String method, String payload, int timeout) {
    	    try {
	        URL url = new URL(requestUrl);
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	        connection.setConnectTimeout(timeout);
	        
	        connection.setDoInput(true);
	        connection.setDoOutput(true);
	        connection.setRequestMethod(method.toUpperCase());
	        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
	        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
	        writer.write(payload);
	        writer.close();
	        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	        StringBuffer jsonString = new StringBuffer();
	        String line;
	        while ((line = br.readLine()) != null) {
	                jsonString.append(line);
	        }
	        br.close();
	        connection.disconnect();
	        
		    return jsonString.toString();
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	public static String post(String url, String payload, int timeout) {
	    return send(url+"?api_key=" + JCA.api_key, "POST", payload, timeout);
	}
	
	public static String get(String url, int timeout, boolean key) throws Exception {
    	URL website = new URL(url+"?api_key="+JCA.api_key);
        URLConnection connection = website.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                    connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            response.append(inputLine);
        in.close();
        return response.toString();
	}
	
	public static String put(String url, String payload, int timeout) {
		return send(url+"?api_key=" + JCA.api_key, "PUT", payload, timeout);
	}
	
	public static String delete(String url, int timeout) {
		return send(url+"?api_key=" + JCA.api_key, "DELETE", "{}", timeout);
	}
}
