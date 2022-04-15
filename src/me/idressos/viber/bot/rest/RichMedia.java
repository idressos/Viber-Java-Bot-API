/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot.rest;

import java.net.URL;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class RichMedia {
	
	int buttonsGroupColumns = 6;
	int buttonsGroupRows = 2;
	String backgroundColor;
	List<Button> buttons;
	
	public RichMedia(int buttonsGroupColumns, int buttonsGroupRows, String backgroundColor, List<Button> buttons) {
		this.buttonsGroupColumns = buttonsGroupColumns;
		this.buttonsGroupRows = buttonsGroupRows;
		this.backgroundColor = backgroundColor;
		this.buttons = buttons;
	}
	
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		
		json.put("Type", "rich_media");
		json.put("ButtonsGroupColumns", buttonsGroupColumns);
		json.put("ButtonsGroupRows", buttonsGroupRows);
		json.put("BgColor", backgroundColor);
		
		JSONArray buttonsArray = new JSONArray();
		for(Button button : buttons) {
			buttonsArray.put(button.toJson());
		}
		json.put("Buttons", buttonsArray);
		
		return json;
	}
	
	public int getButtonsGroupColumns() {
		return buttonsGroupColumns;
	}
	
	public int getButtonsGroupRows() {
		return buttonsGroupRows;
	}
	
	public String getBackgroundColor() {
		return backgroundColor;
	}
	
	public List<Button> getButtons() {
		return buttons;
	}
	
	public static class Button {
		private int columns = 6;
		private int rows = 1;
		private String text;
		private ActionType actionType;
		private String actionBody;
		private URL image;
		private TextSize textSize;
		private VerticalAlignment textVAlign;
		private HorizontalAlignment textHAlign;
		private String backgroundColor;
		private boolean silent;
		private BackgroundMediaType backgroundMediaType;
		private URL backgroundMedia;
		private ScaleType backgroundMediaScaleType;
		private ScaleType imageScaleType;
		private boolean backgroundLoop;
		private int[] textPaddings;
		private int textOpacity = 100;
		private OpenURLType openUrlType;
		private OpenURLMediaType openUrlMediaType;
		private String textBgGradientColor;
		private boolean textShouldFit;
		private InternalBrowser internalBrowser;
		private Map map;
		private Frame frame;
		private MediaPlayer mediaPlayer;
		
		public Button(int columns, int rows, String text, ActionType actionType, String actionBody, URL image, TextSize textSize, VerticalAlignment textVAlign,
					  HorizontalAlignment textHAlign, String backgroundColor, boolean silent, BackgroundMediaType backgroundMediaType, URL backgroundMedia,
					  ScaleType backgroundMediaScaleType, ScaleType imageScaleType, boolean backgroundLoop, int[] textPaddings, int textOpacity,
					  OpenURLType openUrlType, OpenURLMediaType openUrlMediaType, String textBgGradientColor, boolean textShouldFit, InternalBrowser internalBrowser,
					  Map map, Frame frame, MediaPlayer mediaPlayer) {
			this.columns = columns;
			this.rows = rows;
			this.text = text;
			this.actionType = actionType;
			this.actionBody = actionBody;
			this.image = image;
			this.textSize = textSize;
			this.textVAlign = textVAlign;
			this.textHAlign = textHAlign;
			this.backgroundColor = backgroundColor;
			this.silent = silent;
			this.backgroundMediaType = backgroundMediaType;
			this.backgroundMedia = backgroundMedia;
			this.backgroundMediaScaleType = backgroundMediaScaleType;
			this.imageScaleType = imageScaleType;
			this.backgroundLoop = backgroundLoop;
			this.textPaddings = textPaddings;
			this.textOpacity = textOpacity;
			this.openUrlType = openUrlType;
			this.openUrlMediaType = openUrlMediaType;
			this.textBgGradientColor = textBgGradientColor;
			this.textShouldFit = textShouldFit;
			this.internalBrowser = internalBrowser;
			this.map = map;
			this.frame = frame;
			this.mediaPlayer = mediaPlayer;
		}
		
		public JSONObject toJson() {
			JSONObject json = new JSONObject();
			
			if(columns > 0) json.put("Columns", columns);
			if(rows > 0) json.put("Rows", rows);
			if(text != null) json.put("Text", text);
			if(actionType != null) json.put("ActionType", actionType.toString().toLowerCase().replace('_', '-'));
			if(actionBody != null) json.put("ActionBody", actionBody);
			if(image != null) json.put("Image", image.toString());
			if(textSize != null) json.put("TextSize", textSize.toString().toLowerCase());
			if(textVAlign != null) json.put("TextVAlign", textVAlign.toString().toLowerCase());
			if(textHAlign != null) json.put("TextHAlign", textHAlign.toString().toLowerCase());
			if(backgroundColor != null) json.put("BgColor", backgroundColor);
			if(silent) json.put("Silent", true);
			if(backgroundMediaType != null) json.put("BgMediaType", backgroundMediaType.toString().toLowerCase());
			if(backgroundMedia != null) json.put("BgMedia", backgroundMedia.toString());
			if(backgroundMediaScaleType != null) json.put("BgMediaScaleType", backgroundMediaScaleType.toString().toLowerCase());
			if(backgroundLoop) json.put("BgLoop", true);
			if(textPaddings != null) json.put("TextPaddings", new JSONArray(textPaddings));
			json.put("TextOpacity", textOpacity);
			if(openUrlType != null) json.put("OpenURLType", openUrlType.toString().toLowerCase());
			if(openUrlMediaType != null) json.put("OpenURLMediaType", openUrlMediaType.toString().toLowerCase().replace('_', '-'));
			if(textBgGradientColor != null) json.put("TextBgGradientColor", textBgGradientColor);
			if(textShouldFit) json.put("TextShouldFit", textShouldFit);
			if(internalBrowser != null) json.put("InternalBrowser", internalBrowser.toJson());
			if(map != null) json.put("Map", map.toJson());
			if(frame != null) json.put("Frame", frame.toJson());
			if(mediaPlayer != null) json.put("MediaPlayer", mediaPlayer.toJson());
			
			return json;
		}
		
		public int getColumns() {
			return columns;
		}
		
		public int getRows() {
			return rows;
		}
		
		public String getText() {
			return text;
		}
		
		public ActionType getActionType() {
			return actionType;
		}
		
		public String getActionBody() {
			return actionBody;
		}
		
		public URL getImage() {
			return image;
		}
		
		public TextSize getTextSize() {
			return textSize;
		}
		
		public VerticalAlignment getTextVAlign() {
			return textVAlign;
		}
		
		public HorizontalAlignment getTextHAlign() {
			return textHAlign;
		}
		
		public String getBackgroundColor() {
			return backgroundColor;
		}
		
		public boolean silent() {
			return silent;
		}
		
		public BackgroundMediaType getBackgroundMediaType() {
			return backgroundMediaType;
		}
		
		public URL getBackgroundMedia() {
			return backgroundMedia;
		}
		
		public ScaleType getBackgroundMediaScaleType() {
			return backgroundMediaScaleType;
		}
		
		public ScaleType getImageScaleType() {
			return imageScaleType;
		}
		
		public boolean backgroundLoop() {
			return backgroundLoop;
		}
		
		public int[] getTextPaddings() {
			return textPaddings;
		}
		
		public int getTextOpacity() {
			return textOpacity;
		}
		
		public OpenURLType getOpenUrlType() {
			return openUrlType;
		}
		
		public OpenURLMediaType getOpenUrlMediaType() {
			return openUrlMediaType;
		}
		
		public String getTextBgGradientColor() {
			return textBgGradientColor;
		}
		
		public boolean textShouldFit() {
			return textShouldFit;
		}
		
		public InternalBrowser getInternalBrowser() {
			return internalBrowser;
		}
		
		public Map getMap() {
			return map;
		}
		
		public Frame getFrame() {
			return frame;
		}
		
		public MediaPlayer getMediaPlayer() {
			return mediaPlayer;
		}
		
		public static class InternalBrowser {
			private ActionButton actionButton;
			private String actionPredefinedUrl;
			private TitleType titleType;
			private String customTitle;
			private Mode mode;
			private FooterType footerType;
			private String actionReplyData;
			
			public InternalBrowser(ActionButton actionButton, String actionPredefinedUrl, TitleType titleType, String customTitle, Mode mode, FooterType footerType,
								   String actionReplyData) {
				this.actionButton = actionButton;
				this.actionPredefinedUrl = actionPredefinedUrl;
				this.titleType = titleType;
				this.customTitle = customTitle;
				this.mode = mode;
				this.footerType = footerType;
				this.actionReplyData = actionReplyData;
			}
			
			public JSONObject toJson() {
				JSONObject json = new JSONObject();
				
				if(actionButton != null) json.put("ActionButton", actionButton.toString().toLowerCase().replace('_', '-'));
				if(actionPredefinedUrl != null) json.put("ActionPredefinedURL", actionPredefinedUrl);
				if(titleType != null) json.put("TitleType", titleType.toString().toLowerCase());
				if(customTitle != null) json.put("CustomTitle", customTitle);
				if(mode != null) json.put("Mode", mode.toString().toLowerCase().replace('_', '-'));
				if(footerType != null) json.put("FooterType", footerType.toString().toLowerCase());
				if(actionReplyData != null) json.put("ActionReplyData", actionReplyData);
				
				return json;
			}
			
			public ActionButton getActionButton() {
				return actionButton;
			}
			
			public String getActionPredefinedUrl() {
				return actionPredefinedUrl;
			}
			
			public TitleType getTitleType() {
				return titleType;
			}
			
			public String getCustomTitle() {
				return customTitle;
			}
			
			public Mode getMode() {
				return mode;
			}
			
			public FooterType getFooterType() {
				return footerType;
			}
			
			public String actionReplyData() {
				return actionReplyData;
			}
			
			public static enum ActionButton {
				FORWARD, SEND, OPEN_EXTERNALLY, SEND_TO_BOT, NONE
			}
			
			public static enum TitleType {
				DOMAIN, DEFAULT
			}
			
			public static enum Mode {
				FULLSCREEN, FULLSCREEN_PORTRAIT, FULLSCREEN_LANDSCAPE, PARTIAL_SIZE
			}
			
			public static enum FooterType {
				DEFAULT, HIDDEN
			}
		}
		
		public static class Map {
			private double latitude;
			private double longitude;
			
			public Map(double latitude, double longitude) {
				this.latitude = latitude;
				this.longitude = longitude;
			}
			
			public JSONObject toJson() {
				JSONObject json = new JSONObject();
				
				json.put("Latitude", latitude);
				json.put("Longitude", longitude);
				
				return json;
			}
			
			public double getLatitude() {
				return latitude;
			}
			
			public double getLongitude() {
				return longitude;
			}
		}
		
		public static class Frame {
			private int borderWidth = 1;
			private String borderColor;
			private int cornerRadius;
			
			public Frame(int borderWidth, String borderColor, int cornerRadius) {
				this.borderWidth = borderWidth;
				this.borderColor = borderColor;
				this.cornerRadius = cornerRadius;
			}
			
			public JSONObject toJson() {
				JSONObject json = new JSONObject();
				
				json.put("BorderWidth", borderWidth);
				if(borderColor != null) json.put("BorderColor", borderColor);
				if(cornerRadius > 0) json.put("CornerRadis", cornerRadius);
				
				return json;
			}
			
			public int getBorderWidth() {
				return borderWidth;
			}
			
			public String getBorderColor() {
				return borderColor;
			}
			
			public int getCornerRadius() {
				return cornerRadius;
			}
		}
		
		public static class MediaPlayer {
			private String title;
			private String subtitle;
			private URL thumbnailUrl;
			private boolean loop;
			
			public MediaPlayer(String title, String subtitle, URL thumbnailUrl, boolean loop) {
				this.title = title;
				this.subtitle = subtitle;
				this.thumbnailUrl = thumbnailUrl;
				this.loop = loop;
			}
			
			public JSONObject toJson() {
				JSONObject json = new JSONObject();
				
				if(title != null) json.put("Title", title);
				if(subtitle != null) json.put("Subtitle", subtitle);
				if(thumbnailUrl != null) json.put("ThumbnailURL", thumbnailUrl.toString());
				if(loop) json.put("Loop", true);
				
				return json;
			}
			
			public String getTitle() {
				return title;
			}
			
			public String getSubtitle() {
				return subtitle;
			}
			
			public URL thumbnailUrl() {
				return thumbnailUrl;
			}
			
			public boolean loop() {
				return loop;
			}
		}
		
		public static enum BackgroundMediaType {
			PICTURE, GIF
		}
		
		public static enum ScaleType {
			CROP, FILL, FIT
		}
		
		public static enum ActionType {
			REPLY, OPEN_URL, LOCATION_PICKER, SHARE_PHONE, NONE
		}
		
		public static enum VerticalAlignment {
			TOP, MIDDLE, BOTTOM
		}
		
		public static enum HorizontalAlignment {
			LEFT, CENTER, RIGHT
		}
		
		public static enum TextSize {
			SMALL, REGULAR, LARGE
		}
		
		public static enum OpenURLType {
			INTERNAL, EXTERNAL
		}
		
		public static enum OpenURLMediaType {
			NOT_MEDIA, VIDEO, GIF, PICTURE
		}
	}
	
	public static class FavoritesMetadata {
		private FavoriteType type;
		private URL url;
		private String title;
		private URL thumbnail;
		private String domain;
		private int width;
		private int height;
		private int minApiVersion;
		private URL alternativeUrl;
		private String alternativeText;
		
		public FavoritesMetadata(FavoriteType type, URL url) {
			this.type = type;
			this.url = url;
		}
		
		public FavoritesMetadata(FavoriteType type, URL url, String title, URL thumbnail, String domain, int width, int height, int minApiVersion,
								 URL alternativeUrl, String alternativeText) {
			this.type = type;
			this.url = url;
			this.title = title;
			this.thumbnail = thumbnail;
			this.domain = domain;
			this.width = width;
			this.height = height;
			this.minApiVersion = minApiVersion;
			this.alternativeUrl = alternativeUrl;
			this.alternativeText = alternativeText;
		}
		
		public JSONObject toJson() {
			JSONObject json = new JSONObject();
			
			json.put("type", type.toString().toLowerCase());
			json.put("url", url.toString());
			if(title != null) json.put("title", title);
			if(thumbnail != null) json.put("thumbnail", thumbnail.toString());
			if(domain != null) json.put("domain", domain);
			if(width > 0) json.put("width", width);
			if(height > 0) json.put("height", height);
			if(minApiVersion > 0) json.put("minApiVersion", minApiVersion);
			if(alternativeUrl != null) json.put("alternativeUrl", alternativeUrl.toString());
			if(alternativeText != null) json.put("alternativeText", alternativeText);
			
			return json;
		}
		
		public FavoriteType getType() {
			return type;
		}
		
		public URL getUrl() {
			return url;
		}
		
		public String getTitle() {
			return title;
		}
		
		public URL getThumbnail() {
			return thumbnail;
		}
		
		public String getDomain() {
			return domain;
		}
		
		public int getWidth() {
			return width;
		}
		
		public int getHeight() {
			return height;
		}
		
		public int getMinApiVersion() {
			return minApiVersion;
		}
		
		public URL getAlternativeUrl() {
			return alternativeUrl;
		}
		
		public String getAlternativeText() {
			return alternativeText;
		}
		
		public static enum FavoriteType {
			GIF, LINK, VIDEO
		}
	}
	
	public static enum InputFieldState {
		REGULAR, MINIMIZED, HIDDEN
	}
	
}