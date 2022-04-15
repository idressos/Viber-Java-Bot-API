/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot;

import org.json.JSONObject;

public class ViberResponse {
	
	private int status;
	private String statusMessage;
	
	public ViberResponse(int status, String statusMessage) {
		this.status = status;
		this.statusMessage = statusMessage;
	}
	
	public ViberResponse(JSONObject json) {
		status = json.getInt("status");
		statusMessage = json.getString("status_message");
	}
	
	public int getStatus() {
		return status;
	}
	
	public String getStatusMessage() {
		return statusMessage;
	}
	
}