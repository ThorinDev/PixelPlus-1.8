package com.sirhuntpredator.pixelplus.hud;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.client.FMLClientHandler;

import com.sirhuntpredator.pixelplus.PixelPlus;
import com.sirhuntpredator.pixelplus.hud.modular.Element;
import com.sirhuntpredator.pixelplus.hud.modular.GuiUtils;
import com.sirhuntpredator.pixelplus.misc.UUIDFetcher;
import com.sirhuntpredator.pixelplus.misc.UuidHelper;

public class BasicInfoHud extends HudBase {

	public static Boolean isEnabled = /*ChromaPixelConfig.showInfoHUD;*/ true;
	public static Boolean showCoords = /*ChromaPixelConfig.showAdvCoords;*/ true;
	public static String mainColor = /*ChromaPixelConfig.mainColor.substring(0, 2)*/ EnumChatFormatting.BLACK + "";
	public static String itemColor = /*ChromaPixelConfig.itemColor.substring(0, 2)*/EnumChatFormatting.BLACK + "";
	public static List<String> display = new ArrayList<String>();
	public static UUID uuidd;
	public static boolean gotUUID = false;
	
	@Override
	public int id() {
		return 0;
	}

	@Override
	public void render() throws Exception {
		
		ArrayList<String> display = renderlist();
		Minecraft mc = FMLClientHandler.instance().getClient();
		ScaledResolution res = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		int w = 1;
		int h = 15;
		if ((!mc.gameSettings.showDebugInfo) && (mc.inGameHasFocus) && (!(mc.currentScreen instanceof GuiChat)) && isEnabled) {
			FontRenderer fontRendererObj = FMLClientHandler.instance().getClient().fontRendererObj;
			for (int i = 0; i < display.size(); i++) {
				if ((display.get(i) != null) && (!((String)display.get(i)).isEmpty())) {
					fontRendererObj.drawString((String)display.get(i), w, h, 0xffffff);
					h += 10;
				}
			}
		}
	}
	private static int getPlayers()
	{
		/*System.out.println(Minecraft.getMinecraft().getCurrentServerData().toString());
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player == null) {
			return -1;
		}
		NetHandlerPlayClient sendQueue = player.;
		if (sendQueue == null) {
			return -2;
		}
		List<GuiPlayerInfo> playerList = sendQueue.playerInfoList;
		
		if(playerList.size() > 0) {
			return playerList.size();
		}*/
		//TODO
		return -3;
	}

	private static String getTime() {
		return new SimpleDateFormat("h:mm a").format(Calendar.getInstance().getTime());
	}

	private static String compass() {
		try{
			if (Minecraft.getMinecraft().thePlayer != null) {
			float yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
			yaw %= 360;
			if (yaw < 0) {
				yaw += 360;
			}
			yaw = yaw / 90;
			DecimalFormat df = new DecimalFormat("#.#");
			Double m;
			String direction;
			m = Double.valueOf(df.format(yaw));
			if (m <= 0.2) {
				direction = "S";
			} else if (m >= 0.3 && m <= 0.7) {
				direction = "SW";
			} else if (m >= 0.8 && m <= 1.2) {
				direction = "W";
			} else if (m >= 1.3 && m <= 1.7) {
				direction = "NW";
			} else if (m >= 1.8 && m <= 2.2) {
				direction = "N";
			} else if (m >= 2.3 && m <= 2.7) {
				direction = "NE";
			} else if (m >= 2.8 && m <= 3.2) {
				direction = "E";
			} else if (m >= 3.3 && m <= 3.7){
				direction = "SE";
			} else {
				direction = "S";
			}
			return direction;
		}
		
		}
		catch(Throwable e)
		{
			//NOOP
		}
		return "null";
		
	}

	private static String getCoords(int i) {
		try{
		List<String> coords = new ArrayList<String>();
		Double x,y,z,m;
		float yaw;
		String f;
		DecimalFormat df = new DecimalFormat("#.#");
		if(Minecraft.getMinecraft().thePlayer != null) {
			x = Minecraft.getMinecraft().thePlayer.posX;
			y = Minecraft.getMinecraft().thePlayer.posY;
			z = Minecraft.getMinecraft().thePlayer.posZ;
			yaw = Minecraft.getMinecraft().thePlayer.rotationYaw;
			yaw %= 360;
			if (yaw < 0) {
				yaw += 360;
			}
			coords.clear();
			yaw = yaw / 90;
			m = Double.valueOf(df.format(yaw));
			if (m <= 0.2) {
				f = "Z+";
			} else if (m >= 0.3 && m <= 0.7) {
				f = "X-, Z+";
			} else if (m >= 0.8 && m <= 1.2) {
				f = "X-";
			} else if (m >= 1.3 && m <= 1.7) {
				f = "X-, Z-";
			} else if (m >= 1.8 && m <= 2.2) {
				f = "Z-";
			} else if (m >= 2.3 && m <= 2.7) {
				f = "X+, Z-";
			} else if (m >= 2.8 && m <= 3.2) {
				f = "X+";
			} else if (m >= 3.3 && m <= 3.7){
				f = "X+, Z+";
			} else {
				f = "Z+";
			}
			coords.add(0, df.format(x));
			coords.add(1, df.format(y));
			coords.add(2, df.format(z));
			coords.add(3, "" + m);
			coords.add(4, "" + f);
			return coords.get(i);
		}
		}
		catch(Throwable t)
		{
			//noop
		}
		return "null";
	}
	@Override
	public ArrayList<String> renderlist() throws Exception {
		ArrayList<String> display = new ArrayList();

		for(Element e : GuiUtils.elements)
		{
			if(e.value == "ping")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + getPing());
			}
			else if(e.value == "fps")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + getFPS());
			}
			else if(e.value == "facing")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + compass());
			}
			else if(e.value == "players")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor  +" " + getPlayers());
			}
			else if(e.value == "ip")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + getIP());
			}
			else if(e.value == "time")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + getTime());
			}
			else if(e.value == "ign")
			{
				display.add(EnumChatFormatting.GRAY + "[" + mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + " " + Minecraft.getMinecraft().thePlayer.getName());
			}
			else
			{
				display.add(EnumChatFormatting.GRAY + "[" +mainColor + e.element + EnumChatFormatting.GRAY + "]" + itemColor + e.value);
			}
			
		}
		if(showCoords) {
			display.add(EnumChatFormatting.GRAY + "[" + mainColor + "X" + EnumChatFormatting.GRAY + "] " + itemColor + getCoords(0));
			display.add(EnumChatFormatting.GRAY + "[" + mainColor + "Y" + EnumChatFormatting.GRAY + "] " + itemColor + getCoords(1));
			display.add(EnumChatFormatting.GRAY + "[" + mainColor + "Z" + EnumChatFormatting.GRAY + "] " + itemColor + getCoords(2));
			display.add(EnumChatFormatting.GRAY + "[" + mainColor + "F" + EnumChatFormatting.GRAY + "] " + itemColor + getCoords(3) + EnumChatFormatting.GRAY + " [" + mainColor + getCoords(4) + EnumChatFormatting.GRAY + "]");
		}
		
		//display.add(EnumChatFormatting.GRAY + "[" + mainColor + "IGN" + EnumChatFormatting.GRAY + "] " + EnumChatFormatting.DARK_GREEN + " [" + EnumChatFormatting.GREEN + "CP" + EnumChatFormatting.AQUA + "Admin" + EnumChatFormatting.DARK_GREEN + "] "  + EnumChatFormatting.GREEN + "[VIP] " + itemColor + Minecraft.getMinecraft().thePlayer.getName());
		return display;
	}
	@Override
	public boolean isModularGui() {
		return true;
	}

	@Override
	public EnumGuiType type() {
		return EnumGuiType.TEXT;
	}
	public static UUID getUUID() throws Exception
	{
		String name = FMLClientHandler.instance().getClient().getSession().getUsername();
		gotUUID = true;
		uuidd = UUID.fromString(UUIDFetcher.getUUIDOf(UuidHelper.getUUIDFromUsername(FMLClientHandler.instance().getClient().getSession().getUsername())).toString());
		
		return UUID.fromString(UUIDFetcher.getUUIDOf(UuidHelper.getUUIDFromUsername(FMLClientHandler.instance().getClient().getSession().getUsername())).toString());
	}
	private static String getFPS() {
		String fps = "0";
		try{
			fps = Minecraft.getMinecraft().debug.substring(0, Minecraft.getMinecraft().debug.indexOf(' '));
		}catch(Exception e){}
		return fps;
	}

	public static String getIP() {
		try{
		String ip = "";
		if (Minecraft.getMinecraft().getCurrentServerData().serverIP != null) { 
			ip = "" + Minecraft.getMinecraft().getCurrentServerData().serverIP;
		} else {
			ip = "null";
		}
		return ip;
		}
		catch(Exception e)
		{
			
		}
		return "null";
		
		
	}
	public static int getPing() throws Exception 
	{
		
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if (player == null) {
			return -1;
		}
		
		UUID ud = uuidd;
		if(!gotUUID)
		{
			ud = getUUID();
		}
		else
		{
			ud = uuidd;
		}
		
		NetworkPlayerInfo npi;
		npi = Minecraft.getMinecraft().getNetHandler().getPlayerInfo(ud);
	
			if(npi != null)
			{
				return npi.getResponseTime();
			}
			else
			{
				npi = new NetworkPlayerInfo(Minecraft.getMinecraft().thePlayer.getGameProfile());
				
			}
			return npi.getResponseTime();	
		

	}

}
