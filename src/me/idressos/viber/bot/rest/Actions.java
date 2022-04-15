/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import java.util.Map;
import java.util.List;
import java.util.HashMap;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

import me.idressos.http.HTTPRequests;
import me.idressos.http.HTTPResponse;

import me.idressos.viber.bot.rest.Message.Sender;

public class Actions {
	
	public static HTTPResponse sendMessage(String authToken, String receiverId, Sender sender, Message message, String trackingData, int minApiVersion) throws IOException {
		JSONObject json = message.toJson();
		json.put("receiver", receiverId);
		json.put("sender", sender.getAvatar() != null ? new JSONObject().put("name", sender.getName()).put("avatar", sender.getAvatar()) : new JSONObject().put("name", sender.getName()));
		if(trackingData != null) json.put("tracking_data", trackingData);
		if(minApiVersion > 0) json.put("min_api_version", minApiVersion);
		
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/send_message", json.toString());
		
		return response;
	}
	
	public static HTTPResponse broadcastMessage(String authToken, List<String> broadcastList, Sender sender, Message message, int minApiVersion) throws IOException {
		JSONObject json = message.toJson();
		json.put("broadcast_list", new JSONArray(broadcastList));
		json.put("sender", sender.getAvatar() != null ? new JSONObject().put("name", sender.getName()).put("avatar", sender.getAvatar()) : new JSONObject().put("name", sender.getName()));
		if(minApiVersion > 0) json.put("min_api_version", minApiVersion);
		
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/broadcast_message", json.toString());
		
		return response;
	}
	
	public static HTTPResponse getAccountInfo(String authToken) throws IOException {
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/get_account_info", "{}");
		
		return response;
	}
	
	public static HTTPResponse getUserDetails(String authToken, String id) throws IOException {
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/get_user_details", new JSONObject().put("id", id).toString());
		
		return response;
	}
	
	public static HTTPResponse getOnline(String authToken, List<String> ids) throws IOException {
		Map<String, String> requestProperties = new HashMap<String, String>();
		requestProperties.put("X-Viber-Auth-Token", authToken);
		requestProperties.put("Content-Type", "application/json; UTF-8");
		requestProperties.put("Accept", "application/json");
		
		HTTPResponse response = HTTPRequests.post(requestProperties, "https://chatapi.viber.com/pa/get_online", new JSONObject().put("ids", new JSONArray(ids)).toString());
		
		return response;
	}
	
}