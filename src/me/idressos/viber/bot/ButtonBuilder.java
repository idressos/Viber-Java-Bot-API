/* This file is part of Viber Java Bot API.

Viber Java Bot API is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.

Viber Java Bot API is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.

You should have received a copy of the GNU General Public License along with Viber Java Bot API. If not, see <https://www.gnu.org/licenses/>. */

package me.idressos.viber.bot;

import java.net.URL;

import me.idressos.viber.bot.rest.RichMedia.Button;

import me.idressos.viber.bot.rest.RichMedia.Button.TextSize;

import me.idressos.viber.bot.rest.RichMedia.Button.ScaleType;
import me.idressos.viber.bot.rest.RichMedia.Button.ActionType;
import me.idressos.viber.bot.rest.RichMedia.Button.OpenURLType;
import me.idressos.viber.bot.rest.RichMedia.Button.OpenURLMediaType;
import me.idressos.viber.bot.rest.RichMedia.Button.BackgroundMediaType;

import me.idressos.viber.bot.rest.RichMedia.Button.Map;
import me.idressos.viber.bot.rest.RichMedia.Button.Frame;
import me.idressos.viber.bot.rest.RichMedia.Button.MediaPlayer;
import me.idressos.viber.bot.rest.RichMedia.Button.InternalBrowser;

import me.idressos.viber.bot.rest.RichMedia.Button.VerticalAlignment;
import me.idressos.viber.bot.rest.RichMedia.Button.HorizontalAlignment;

public class ButtonBuilder {
	
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
	
	public Button build() {
		return new Button(
					columns, rows, text, actionType, actionBody, image, textSize, textVAlign,
					textHAlign, backgroundColor, silent, backgroundMediaType, backgroundMedia,
					backgroundMediaScaleType, imageScaleType, backgroundLoop, textPaddings, textOpacity,
					openUrlType, openUrlMediaType, textBgGradientColor, textShouldFit, internalBrowser,
					map,frame, mediaPlayer);
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
	
	public boolean getSilent() {
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
	
	public boolean getBackgroundLoop() {
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
	
	public boolean getTextShouldFit() {
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
	
	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	
	public void setActionBody(String actionBody) {
		this.actionBody = actionBody;
	}
	
	public void setImage(URL image) {
		this.image = image;
	}
	
	public void setTextSize(TextSize textSize) {
		this.textSize = textSize;
	}
	
	public void setTextVAlign(VerticalAlignment textVAlign) {
		this.textVAlign = textVAlign;
	}
	
	public void setTextHAlign(HorizontalAlignment textHAlign) {
		this.textHAlign = textHAlign;
	}
	
	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
	
	public void setSilent(boolean silent) {
		this.silent = silent;
	}
	
	public void setBackgroundMediaType(BackgroundMediaType backgroundMediaType) {
		this.backgroundMediaType = backgroundMediaType;
	}
	
	public void setBackgroundMedia(URL backgroundMedia) {
		this.backgroundMedia = backgroundMedia;
	}
	
	public void setBackgroundMediaScaleType(ScaleType backgroundMediaScaleType) {
		this.backgroundMediaScaleType = backgroundMediaScaleType;
	}
	
	public void setImageScaleType(ScaleType imageScaleType) {
		this.imageScaleType = imageScaleType;
	}
	
	public void setBackgroundLoop(boolean backgroundLoop) {
		this.backgroundLoop = backgroundLoop;
	}
	
	public void setTextPaddings(int[] textPaddings) {
		this.textPaddings = textPaddings;
	}
	
	public void setTextOpacity(int textOpacity) {
		this.textOpacity = textOpacity;
	}
	
	public void setOpenUrlType(OpenURLType openUrlType) {
		this.openUrlType = openUrlType;
	}
	
	public void setOpenUrlMediaType(OpenURLMediaType openUrlMediaType) {
		this.openUrlMediaType = openUrlMediaType;
	}
	
	public void setTextBgGradientColor(String textBgGradientColor) {
		this.textBgGradientColor = textBgGradientColor;
	}
	
	public void setTextShouldFit(boolean textShouldFit) {
		this.textShouldFit = textShouldFit;
	}
	
	public void setInternalBrowser(InternalBrowser internalBrowser) {
		this.internalBrowser = internalBrowser;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public void setMediaPlayer(MediaPlayer mediaPlayer) {
		this.mediaPlayer = mediaPlayer;
	}
	
}