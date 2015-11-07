package com.sirhuntpredator.pixelplus.misc;

import java.util.Iterator;
import java.util.List;

import net.minecraft.util.ChatStyle;
import net.minecraft.util.IChatComponent;

public class ChatHelper implements IChatComponent {

	String message = "";
	ChatStyle style = null;
	public ChatHelper(String message)
	{
		this.message = message;
	}
	public ChatHelper(String message, ChatStyle style)
	{
		this.message = message;
		this.style = style;
	}
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IChatComponent setChatStyle(ChatStyle style) {
		// TODO Auto-generated method stub
		style = this.style;
		return this;
	}

	@Override
	public ChatStyle getChatStyle() {
		// TODO Auto-generated method stub
		return style;
	}

	@Override
	public IChatComponent appendText(String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IChatComponent appendSibling(IChatComponent component) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedTextForChat() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUnformattedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFormattedText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getSiblings() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IChatComponent createCopy() {
		// TODO Auto-generated method stub
		return null;
	}

}
