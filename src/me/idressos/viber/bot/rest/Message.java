/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import java.net.URL;

import org.json.JSONObject;

public class Message {
	
	private MessageType type;
	private String text;
	private String media;
	private Location location;
	private Contact contact;
	private String thumbnail;
	private String fileName;
	private int size;
	private int duration;
	private int stickerId;
	private RichMedia richMedia;
	private String altText;
	
	public Message(String text) {
		this.type = MessageType.TEXT;
		this.text = text;
	}
	
	public Message(String text, URL picture, URL thumbnail) {
		this.type = MessageType.PICTURE;
		this.text = text;
		this.media = picture.toString();
		this.thumbnail = thumbnail.toString();
	}
	
	public Message(URL video, int size, int duration, URL thumbnail) {
		this.type = MessageType.VIDEO;
		this.media = video.toString();
		this.size = size;
		this.duration = duration;
		this.thumbnail = thumbnail.toString();
	}
	
	public Message(URL file, int size, String name) {
		this.type = MessageType.FILE;
		this.media = file.toString();
		this.size = size;
		this.fileName = name;
	}
	
	public Message(Contact contact) {
		this.type = MessageType.CONTACT;
		this.contact = contact;
	}
	
	public Message(Location location) {
		this.type = MessageType.LOCATION;
		this.location = location;
	}
	
	public Message(URL url) {
		this.type = MessageType.URL;
		this.media = url.toString();
	}
	
	public Message(int stickerId) {
		this.type = MessageType.STICKER;
		this.stickerId = stickerId;
	}
	
	public Message(RichMedia richMedia, String altText) {
		this.type = MessageType.RICH_MEDIA;
		
		this.richMedia = richMedia;
		if(!(richMedia instanceof Keyboard)) this.altText = altText;
	}
	
	public Message(JSONObject json) {
		if(json.has("type")) type = MessageType.valueOf(json.getString("type").toUpperCase());
		if(json.has("text")) text = json.getString("text");
		if(json.has("media")) media = json.getString("media");
		if(json.has("location")) location = new Location(json.getJSONObject("location").getDouble("lat"), json.getJSONObject("location").getDouble("lon"));
		if(json.has("contact")) contact = new Contact(json.getJSONObject("contact").getString("name"), json.getJSONObject("contact").getString("phone_number"));
		if(json.has("thumbnail")) thumbnail = json.getString("thumbnail");
		if(json.has("file_name")) fileName = json.getString("file_name");
		if(json.has("size")) size = json.getInt("size");
		if(json.has("duration")) duration = json.getInt("duration");
		if(json.has("sticker_id")) stickerId = json.getInt("sticker_id");
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		
		json.put("type", type.toString().toLowerCase());
		
		switch(type) {
			case TEXT:
				json.put("text", text);
				break;
			case PICTURE:
				json.put("text", text);
				json.put("media", media);
				if(thumbnail != null) json.put("thumbnail", thumbnail);
				break;
			case VIDEO:
				json.put("media", media);
				json.put("size", size);
				if(duration > 0) json.put("duration", duration);
				if(thumbnail != null) json.put("thumbnail", thumbnail);
				break;
			case FILE:
				json.put("media", media);
				json.put("size", size);
				json.put("file_name", fileName);
				break;
			case CONTACT:
				json.put("contact", new JSONObject().put("name", contact.getName()).put("phone_number", contact.getPhoneNumber()));
				break;
			case LOCATION:
				json.put("location", new JSONObject().put("lat", location.getLatitude()).put("lon", location.getLongitude()));
				break;
			case URL:
				json.put("media", media);
				break;
			case STICKER:
				json.put("sticker_id", stickerId);
				break;
			case RICH_MEDIA:
				if(richMedia instanceof Keyboard) {
					json.put("keyboard", richMedia.toJson());
				} else {
					json.put("rich_media", richMedia.toJson());
					if(altText != null) json.put("alt_text", altText);
				}
				
				break;
		}
		
		return json;
	}
	
	public MessageType getType() {
		return type;
	}
	
	public String getText() {
		return text;
	}
	
	public String getMedia() {
		return media;
	}
	
	public Location getLocation() {
		return location;
	}
	
	public Contact getContact() {
		return contact;
	}
	
	public String getThumbnail() {
		return thumbnail;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getStickerId() {
		return stickerId;
	}
	
	public RichMedia getRichMedia() {
		return richMedia;
	}
	
	public String getAltText() {
		return altText;
	}
	
	public static enum MessageType {
		TEXT, PICTURE, VIDEO, FILE, CONTACT, LOCATION, URL, STICKER, RICH_MEDIA
	}
	
	public static class Sender {
		private String name;
		private String avatar;
		
		public Sender(String name) {
			this.name = name;
		}
		
		public Sender(String name, String avatar) {
			this.name = name;
			this.avatar = avatar;
		}
		
		public String getName() {
			return name;
		}
		
		public String getAvatar() {
			return avatar;
		}
	}
	
	public static class Contact {
		private String name;
		private String phoneNumber;
		
		public Contact(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
		
		public String getName() {
			return name;
		}
		
		public String getPhoneNumber() {
			return phoneNumber;
		}
	}
	
	public static class Location {
		private double latitude;
		private double longitude;
		
		public Location(double latitude, double longtitude) {
			this.latitude = latitude;
			this.longitude = longtitude;
		}
		
		public double getLatitude() {
			return latitude;
		}
		
		public double getLongitude() {
			return longitude;
		}
	}
	
}