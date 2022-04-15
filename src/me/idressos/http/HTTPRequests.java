/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.http;

import java.util.Map;

import java.net.URL;
import java.net.HttpURLConnection;

import java.io.IOException;
import java.io.OutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.nio.charset.StandardCharsets;

public class HTTPRequests {
	
	public static HTTPResponse get(Map<String, String> requestProperties, String url) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		connection.setRequestMethod("GET");
		if(requestProperties != null ) {
			for(String key : requestProperties.keySet()) {
				connection.addRequestProperty(key, requestProperties.get(key));
			}
		}
		
		try(BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
			String inputLine;
			StringBuffer responseBody = new StringBuffer();
			
			while((inputLine = inputReader.readLine()) != null) {
				responseBody.append(inputLine);
			}
			
			return new HTTPResponse(connection.getResponseCode(), connection.getResponseMessage(), responseBody.toString());
		}
	}
	
	public static HTTPResponse post(Map<String, String> requestProperties, String url, String body) throws IOException {
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		
		connection.setRequestMethod("POST");
		if(requestProperties != null) {
			for(String key : requestProperties.keySet()) {
				connection.addRequestProperty(key, requestProperties.get(key));
			}
		}
		
		connection.setDoOutput(true);
		try(OutputStream outputStream = connection.getOutputStream()) {
			byte[] output = body.getBytes(StandardCharsets.UTF_8);
			outputStream.write(output, 0, output.length);			
		}
		
		try(BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
			String inputLine;
			StringBuffer responseBody = new StringBuffer();
			
			while((inputLine = inputReader.readLine()) != null) {
				responseBody.append(inputLine);
			}
			
			return new HTTPResponse(connection.getResponseCode(), connection.getResponseMessage(), responseBody.toString());
		}
	}
	
}