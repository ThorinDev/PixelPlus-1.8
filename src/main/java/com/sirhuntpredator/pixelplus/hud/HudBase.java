package com.sirhuntpredator.pixelplus.hud;

import java.util.ArrayList;

public abstract class HudBase {

	public abstract int id();
	public abstract void render();
	public ArrayList<String> renderlist(){
		return null;
	}
	public abstract boolean isModularGui();
	public abstract EnumGuiType type();
}
