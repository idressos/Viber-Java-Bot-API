/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Keyboard extends RichMedia {
	
	private boolean defaultHeight;
	private int customDefaultHeight;
	private int heightScale = 100;
	private InputFieldState inputFieldState;
	private FavoritesMetadata favoritesMetadata;
	
	public Keyboard(List<Button> buttons, String backgroundColor, boolean defaultHeight, int customDefaultHeight, int heightScale, int buttonsGroupColumns,
					 int buttonsGroupRows, InputFieldState inputFieldState, FavoritesMetadata favoritesMetadata) {
		super(buttonsGroupColumns, buttonsGroupRows, backgroundColor, buttons);
		
		this.defaultHeight = defaultHeight;
		this.customDefaultHeight = customDefaultHeight;
		this.heightScale = heightScale;
		this.inputFieldState = inputFieldState;
		this.favoritesMetadata = favoritesMetadata;
	}
	
	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		
		if(buttonsGroupColumns > 0) json.put("ButtonsGroupColumns", buttonsGroupColumns);
		if(buttonsGroupRows > 0) json.put("ButtonsGroupRows", buttonsGroupRows);
		if(backgroundColor != null) json.put("BgColor", backgroundColor);
		if(defaultHeight) json.put("DefaultHeight", true);
		if(customDefaultHeight > 0) json.put("CustomDefaultHeught", customDefaultHeight);
		if(heightScale > 0) json.put("HeightScale", heightScale);
		if(inputFieldState != null) json.put("InputFieldState", inputFieldState.toString());
		if(favoritesMetadata != null) json.put("FavoritesMetadata", favoritesMetadata.toJson());
		
		JSONArray buttonsArray = new JSONArray();
		for(Button button : buttons) {
			buttonsArray.put(button.toJson());
		}
		json.put("Buttons", buttonsArray);
		
		return json;
	}
	
	public boolean defaultHeight() {
		return defaultHeight;
	}
	
	public int getCustomDefaultHeight() {
		return customDefaultHeight;
	}
	
	public int getHeightScale() {
		return heightScale;
	}
	
	public InputFieldState getInputFieldState() {
		return inputFieldState;
	}
	
	public FavoritesMetadata getFavoritesMetadata() {
		return favoritesMetadata;
	}
	
}