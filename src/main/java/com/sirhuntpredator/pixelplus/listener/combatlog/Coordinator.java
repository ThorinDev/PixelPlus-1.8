package com.sirhuntpredator.pixelplus.listener.combatlog;

import java.text.NumberFormat;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.CombatEntry;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.google.common.collect.Lists;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class Coordinator 
{
	public static boolean enabled = true;
	public static int getDistance(EntityLivingBase e)
	{
		
		try
		{
			EntityPlayer ep = Minecraft.getMinecraft().thePlayer;
			double x1 = e.posX;
			double x2 = ep.posX;
			double y1 = e.posY;
			double y2 = ep.posY;
			double z1 = e.posZ;
			double z2 = ep.posZ;
			double deltax;
			double deltay;
			double deltaz;
			int delta;
			NumberFormat nf = NumberFormat.getInstance();
			
			deltax = Double.valueOf(nf.format(x1 - x2));
			deltay = Double.valueOf(nf.format(y1 - y2));
			deltaz = Double.valueOf(nf.format(z1 - z2));
			
			delta = (int) (Math.round(deltax /*+ deltay*/ + deltaz) / 2);
			
			if(delta < 0)
			{
				delta *= -1;
			}
			
			delta += 1;
			return delta;
		}
		catch(Exception ex)
		{
			new ChatMessageComposer(ex.toString()).send();
		}
		return 0;
	}
	public static CombatEntry cbe(CombatTracker e)
	{
		  CombatEntry combatentry = null;
	        CombatEntry combatentry1 = null;
	        List combatEntries = Lists.newArrayList();
	        combatEntries = e.combatEntries;
	        byte b0 = 0;
	        float f = 0.0F;

	        for (int i = 0; i < combatEntries.size(); ++i)
	        {
	            CombatEntry combatentry2 = (CombatEntry)combatEntries.get(i);
	            CombatEntry combatentry3 = i > 0 ? (CombatEntry)combatEntries.get(i - 1) : null;

	            if ((combatentry2.getDamageSrc() == DamageSource.fall || combatentry2.getDamageSrc() == DamageSource.outOfWorld) && combatentry2.func_94561_i() > 0.0F && (combatentry == null || combatentry2.func_94561_i() > f))
	            {
	                if (i > 0)
	                {
	                    combatentry = combatentry3;
	                }
	                else
	                {
	                    combatentry = combatentry2;
	                }

	                f = combatentry2.func_94561_i();
	            }

	            if (combatentry2.func_94562_g() != null && (combatentry1 == null || combatentry2.func_94563_c() > (float)b0))
	            {
	                combatentry1 = combatentry2;
	            }
	        }

	        if (f > 5.0F && combatentry != null)
	        {
	            return combatentry;
	        }
	        else if (b0 > 5 && combatentry1 != null)
	        {
	            return combatentry1;
	        }
	        else
	        {
	            return null;
	        }
	}
}
