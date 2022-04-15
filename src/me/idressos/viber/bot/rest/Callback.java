/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import org.json.JSONObject;

public class Callback {
	
	private Event event;
	private long timestamp;
	private long messageToken;
	private String chatHostname;
	private User user;
	private User sender;
	private String userId;
	private String description;
	private String type;
	private String context;
	private boolean subscribed;
	private Message message;
	private boolean silent;
	
	public Callback(Event event, long timestamp, long messageToken, String chatHostname, User user, User sender, String userId, String description,
					String type, String context, boolean subscribed, Message message, boolean silent) {
		this.event = event;
		this.timestamp = timestamp;
		this.messageToken = messageToken;
		this.chatHostname = chatHostname;
		this.user = user;
		this.sender = sender;
		this.userId = userId;
		this.description = description;
		this.type = type;
		this.context = context;
		this.subscribed = subscribed;
		this.message = message;
		this.silent = silent;
	}
	
	public Callback(JSONObject json) {
		if(json.has("event")) event = Event.valueOf(json.getString("event").toUpperCase());
		if(json.has("timestamp")) timestamp = json.getLong("timestamp");
		if(json.has("message_token")) messageToken = json.getLong("message_token");
		if(json.has("chat_hostname")) chatHostname = json.getString("chat_hostname");
		if(json.has("user")) user = new User(json.getJSONObject("user"));
		if(json.has("sender")) sender = new User(json.getJSONObject("sender"));
		if(json.has("user_id")) userId = json.getString("user_id");
		if(json.has("desc")) description = json.getString("desc");
		if(json.has("type")) type = json.getString("type");
		if(json.has("context")) context = json.getString("context");
		if(json.has("subscribed")) subscribed = json.getBoolean("subscribed");
		if(json.has("message")) message = new Message(json.getJSONObject("message"));
		if(json.has("silent")) silent = json.getBoolean("silent");
	}
	
	public Event getEvent() {
		return event;
	}
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public long getMessageToken() {
		return messageToken;
	}
	
	public String getChatHostname() {
		return chatHostname;
	}
	
	public User getUser() {
		return user;
	}
	
	public User getSender() {
		return sender;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getType() {
		return type;
	}
	
	public String getContext() {
		return context;
	}
	
	public boolean getSubscribed() {
		return subscribed;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public boolean getSilent() {
		return silent;
	}
	
	public static enum Event {
		WEBHOOK, SUBSCRIBED, UNSUBSCRIBED, CONVERSATION_STARTED, DELIVERED, SEEN, FAILED, MESSAGE
	}
	
}