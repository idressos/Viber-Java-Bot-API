/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import org.json.JSONObject;

public class User {
	
	private String id;
	private String name;
	private String avatar;
	private String country;
	private String language;
	private String primaryDeviceOs;
	private int apiVersion;
	private String viberVersion;
	private int mobileCountryCode;
	private int mobileNetworkCode;
	private String deviceType;
	
	public User(String id, String name, String avatar, String country, String language, String primaryDeviceOs, int apiVersion, String viberVersion,
				int mobileCountryCode, int mobileNetworkCode, String deviceType) {
		this.id = id;
		this.name = name;
		this.avatar = avatar;
		this.country = country;
		this.language = language;
		this.primaryDeviceOs = primaryDeviceOs;
		this.apiVersion = apiVersion;
		this.viberVersion = viberVersion;
		this.mobileCountryCode = mobileCountryCode;
		this.mobileNetworkCode = mobileNetworkCode;
		this.deviceType = deviceType;
	}
	
	public User(JSONObject json) {
		if(json.has("id")) id = json.getString("id");
		if(json.has("name")) name = json.getString("name");
		if(json.has("avatar")) avatar = json.getString("avatar");
		if(json.has("country")) country = json.getString("country");
		if(json.has("language")) language = json.getString("language");
		if(json.has("primary_device_os")) primaryDeviceOs = json.getString("primary_device_os");
		if(json.has("api_version")) apiVersion = json.getInt("api_version");
		if(json.has("viber_version")) viberVersion = json.getString("viber_version");
		if(json.has("mcc")) mobileCountryCode = json.getInt("mcc");
		if(json.has("mnc")) mobileNetworkCode = json.getInt("mnc");
		if(json.has("device_type")) deviceType = json.getString("device_type");
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAvatar() {
		return avatar;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getLanguage() {
		return language;
	}
	
	public String getPrimaryDeviceOs() {
		return primaryDeviceOs;
	}
	
	public int getApiVersion() {
		return apiVersion;
	}
	
	public String getViberVersion() {
		return viberVersion;
	}
	
	public int getMobileCountryCode() {
		return mobileCountryCode;
	}
	
	public int getMobileNetworkCode() {
		return mobileNetworkCode;
	}
	
	public String getDeviceType() {
		return deviceType;
	}
	
}