package com.sirhuntpredator.pixelplus.misc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import net.minecraft.client.Minecraft;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;
import com.sirhuntpredator.pixelplus.PixelPlus;

public class UuidHelper {

	static int counter;

	private UuidHelper() {}

	public static String getUsernameFormUUID(String uuid) {
		if(PixelPlus.IS_DEBUGGING) {
			long time = System.currentTimeMillis();
			String name = Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(uuid), (String)null), false).getName();
			PixelPlus.instance().logDebug("Took " + (System.currentTimeMillis() - time) + "ms to process UUID. Counter is at " + counter++);
			return name;
		} else {
			return Minecraft.getMinecraft().getSessionService().fillProfileProperties(new GameProfile(UUIDTypeAdapter.fromString(uuid), (String)null), false).getName();
		}
	}

	public static String uuid = "";
	public static String getUUIDFromUsername(final String username) {
		try {
			
			URL uuidgrabber = new URL("https://api.mojang.com/users/profiles/minecraft/" + username);
			BufferedReader br1 = new BufferedReader(new InputStreamReader(uuidgrabber.openStream()));
			String uuidfromweb;
			if ((uuidfromweb = br1.readLine()) != null) {
				uuidfromweb = br1.readLine();
				uuid = UUIDFetcher.getUUIDOf(uuidfromweb.substring(7, 39)).toString();
			}
			br1.close();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		return uuid;
	}
}

