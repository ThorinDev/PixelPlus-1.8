package com.sirhuntpredator.pixelplus.config;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

import com.sirhuntpredator.pixelplus.PixelPlus;

public class PixelPlusGuiConfig extends GuiConfig {

	public PixelPlusGuiConfig(GuiScreen parentScreen) {
		
	    super(parentScreen, new ConfigElement(ConfigUtils.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),PixelPlus.MODID, true, true, "PixelPlus configuration");
        titleLine2 = "Some WIP extra stuff!";
        allowUserInput = true;
	}

	
	@Override
	public void initGui() {
		// TODO Auto-generated method stub
		super.initGui();
	}
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		// TODO Auto-generated method stub
		super.drawScreen(mouseX, mouseY, partialTicks);
	}
	@Override
	protected void actionPerformed(GuiButton button) {
		
		super.actionPerformed(button);
	}
	
	

}
