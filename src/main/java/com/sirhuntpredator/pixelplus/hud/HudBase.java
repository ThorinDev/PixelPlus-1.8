package com.sirhuntpredator.pixelplus.hud;

import java.util.ArrayList;

public abstract class HudBase {

	public boolean isEnabled;
	public abstract int id();
	public abstract void render() throws Exception;
	public ArrayList<String> renderlist() throws Exception{
		return null;
	}
	public abstract boolean isModularGui();
	public abstract EnumGuiType type();
}
