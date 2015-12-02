package com.sirhuntpredator.pixelplus.listener.combatlog;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.CombatEntry;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.event.entity.living.LivingHealEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.google.common.collect.Lists;
import com.sirhuntpredator.pixelplus.misc.ChatMessageComposer;

public class Listener {
	
	@SubscribeEvent
	public void attackEntity(AttackEntityEvent e)
	{
		
		int distance = Coordinator.getDistance((EntityLivingBase) e.target);
		
		if(Coordinator.enabled && !e.entity.worldObj.isRemote)
		{
			new ChatMessageComposer("Attacked " + e.target.getName() + " from " + distance + " blocks away.").send(true);
		}
	}
	
	@SubscribeEvent
	public void heal(LivingHealEvent e)
	{
		if(Coordinator.enabled && !e.entity.worldObj.isRemote)
		{
			new ChatMessageComposer("Healed " + e.amount + " hitpoints of health").send(true);
		}
	}
	
	@SubscribeEvent
	public void attackedByEntity(LivingHurtEvent e)
	{
		
		
		try
		{
			int distance = Coordinator.getDistance(e.entityLiving);
			CombatTracker cb = e.entityLiving.getCombatTracker();
			//CombatEntry combatentry = Coordinator.cbe(cb);
			List combatEntries = Lists.newArrayList();
			combatEntries = cb.combatEntries;
	        CombatEntry combatentry1 = (CombatEntry)combatEntries.get(combatEntries.size() - 1);
	        IChatComponent ichatcomponent = combatentry1.func_151522_h();
			String attacker = ichatcomponent.getUnformattedText();
			
	      if (Coordinator.enabled && e.entity instanceof EntityPlayer && !e.entity.worldObj.isRemote)
	      {
	    	  new ChatMessageComposer("Attacked by " + attacker +  " for " + e.ammount + " hitpoints from " + distance + " blocks away.").send();
	      }
	    }
	    catch (Exception ex) 
		{}
	}

}
