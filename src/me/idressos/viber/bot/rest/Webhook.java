/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import java.net.URL;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import me.idressos.http.HTTPRequests;
import me.idressos.http.HTTPResponse;

import me.idressos.viber.bot.rest.Callback.Event;

public class Webhook {
	
	private URL url;
	private String authToken;
	private List<Event> eventTypes;
	private boolean sendName;
	private boolean sendPhoto;
	
	public Webhook(URL url, String authToken) {
		this.url = url;
		this.authToken = authToken;
	}
	
	public Webhook(URL url, String authToken, List<Event> eventTypes) {
		this.url = url;
		this.authToken = authToken;
		this.eventTypes = eventTypes;
	}
	
	public Webhook(URL url, String authToken, List<Event> eventTypes, boolean sendName, boolean sendPhoto) {
		this.url = url;
		this.authToken = authToken;
		this.eventTypes = eventTypes;
		this.sendName = sendName;
		this.sendPhoto = sendPhoto;
	}
	
	public HTTPResponse set() throws IOException {
		JSONObject json = new JSONObject();
		json.put("url", url.toString());
		if(this.eventTypes != null) {
			JSONArray eventTypes = new JSONArray();
			for(Event event : this.eventTypes) {
				eventTypes.put(event.toString().toLowerCase());
			}
			
			json.put("event_types", eventTypes);
		}
		json.put("send_name", sendName);
		json.put("send_photo", sendPhoto);
		
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/set_webhook", json.toString());
		
		return response;
	}
	
	public HTTPResponse remove() throws IOException {
		JSONObject json = new JSONObject();
		json.put("url", "");
		
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/set_webhook", json.toString());
		
		return response;
	}
	
	public URL getUrl() {
		return url;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public List<Event> getEventTypes() {
		return eventTypes;
	}
	
	public boolean sendName() {
		return sendName;
	}
	
	public boolean sendPhoto() {
		return sendPhoto;
	}
	
}