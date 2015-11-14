package com.sirhuntpredator.pixelplus.hud;

import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.FMLClientHandler;

public class HealthHud extends HudBase {


	@Override
	public int id() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public void render() throws Exception {
		
		ArrayList<String> display = renderlist();
		Minecraft mc = FMLClientHandler.instance().getClient();
		ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);

		
		 
		if ((!mc.gameSettings.showDebugInfo) && (mc.inGameHasFocus) && (!(mc.currentScreen instanceof GuiChat))) {
			FontRenderer fontRendererObj = FMLClientHandler.instance().getClient().fontRendererObj;
					fontRendererObj.drawString((String)display.get(0), 450, 20, 0xffffff);
					
				
			}
		}

	
	@Override
	public ArrayList<String> renderlist() throws Exception {
		ArrayList<String> e = new ArrayList<String>();
		float hp = Minecraft.getMinecraft().thePlayer.getHealth();
		String state = "";
		if(hp == 20F)
		{
			state = "Full";
		}
		else if(hp < 20F && hp > 12)
		{
			state = EnumChatFormatting.GREEN + "High";
		}
		else if(hp < 12 && hp > 8)
		{
			state = EnumChatFormatting.YELLOW + "Medium";
		}
		else
		{
			state = EnumChatFormatting.BOLD +""+ EnumChatFormatting.DARK_RED + "Low";
		}
		e.add("Health - " + state);
		return e;
	}

	@Override
	public boolean isModularGui() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EnumGuiType type() {
		// TODO Auto-generated method stub
		return EnumGuiType.TEXT;
	}

}
