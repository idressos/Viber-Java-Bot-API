/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.http;

public class HTTPResponse {
	
	private int code;
	private String message;
	private String body;
	
	public HTTPResponse(int code, String message, String body) {
		this.code = code;
		this.message = message;
		this.body = body;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getBody() {
		return body;
	}
	
}