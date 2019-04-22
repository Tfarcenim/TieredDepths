package com.tfar.examplemod;

import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import static com.tfar.examplemod.TieredDepths.lists;

@Mod.EventBusSubscriber(modid = TD.MODID)
@Mod(modid = TD.MODID, name = TD.NAME, version = TD.VERSION)
public class TD {
  public static final String MODID = "tiereddepths";
  public static final String NAME = "Tiered Depths";
  public static final String VERSION = "@VERSION@";

  private static Logger logger;

  @EventHandler
  public void preInit(FMLPreInitializationEvent event) {
    logger = event.getModLog();
  }

  @EventHandler
  public void init(FMLInitializationEvent event) {
  }

  @SubscribeEvent
  public static void preventMining(PlayerEvent.BreakSpeed b) {
    EntityPlayer p = b.getEntityPlayer();
    for (CustomClass condition : lists) {
      if (condition.blackListedBlockState.matches(CraftTweakerMC.getBlockState(b.getState()))
              && p.dimension == condition.dimension && condition.minimumMiningLevel >
              p.getHeldItemMainhand().getItem().getHarvestLevel(p.getHeldItemMainhand(), "pickaxe", p, b.getState()) &&
              b.getPos().getY() < condition.maxHeight) {
        b.setNewSpeed(0);
      }
    }
  }
}
