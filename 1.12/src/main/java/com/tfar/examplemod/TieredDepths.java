package com.tfar.examplemod;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockStateMatcher;
import net.minecraftforge.fml.common.Mod;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.ArrayList;

import static com.tfar.examplemod.TD.MODID;

@Mod.EventBusSubscriber(modid = MODID)
@SuppressWarnings("unused")
@ZenRegister
@ZenClass("mods.td.TieredDepths")
public class TieredDepths {

  public static ArrayList<CustomClass> lists = new ArrayList<>();

  @ZenMethod
  public static void addBlacklist(IBlockStateMatcher blackListedBlock, int maxHeight, int dimension, int minimumMiningLevel){
    CustomClass clazz = new CustomClass(blackListedBlock, maxHeight, dimension,minimumMiningLevel);
    lists.add(clazz);
  }
}
