package com.sirhuntpredator.pixelplus.config;

import java.util.List;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import com.sirhuntpredator.pixelplus.PixelPlus;

public class PixelPlusGuiConfig extends GuiConfig {

	public PixelPlusGuiConfig(GuiScreen parentScreen) {
		
	    super(parentScreen, new ConfigElement(ConfigUtils.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),PixelPlus.MODID, true, true, "PixelPlus configuration");
        titleLine2 = "Some extra stuff!";
	}

	public PixelPlusGuiConfig(GuiScreen parentScreen,
			List<IConfigElement> configElements, String modID, String configID,
			boolean allRequireWorldRestart, boolean allRequireMcRestart,
			String title) {
		super(parentScreen, configElements, modID, configID,
				allRequireWorldRestart, allRequireMcRestart, title);
		// TODO Auto-generated constructor stub
	}

	public PixelPlusGuiConfig(GuiScreen parentScreen,
			List<IConfigElement> configElements, String modID,
			boolean allRequireWorldRestart, boolean allRequireMcRestart,
			String title, String titleLine2) {
		super(parentScreen, configElements, modID, allRequireWorldRestart,
				allRequireMcRestart, title, titleLine2);
		// TODO Auto-generated constructor stub
	}

	public PixelPlusGuiConfig(GuiScreen parentScreen,
			List<IConfigElement> configElements, String modID, String configID,
			boolean allRequireWorldRestart, boolean allRequireMcRestart,
			String title, String titleLine2) {
		super(parentScreen, configElements, modID, configID,
				allRequireWorldRestart, allRequireMcRestart, title, titleLine2);
		// TODO Auto-generated constructor stub
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
