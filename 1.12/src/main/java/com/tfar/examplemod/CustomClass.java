package com.tfar.examplemod;

import crafttweaker.api.block.IBlockStateMatcher;

public class CustomClass {

  protected IBlockStateMatcher blackListedBlockState;
  protected int maxHeight;
  protected int dimension;
  protected int minimumMiningLevel;

  public CustomClass(IBlockStateMatcher blackListedBlock, int maxHeight, int dimension, int minimumMiningLevel) {
    this.blackListedBlockState = blackListedBlock;
    this.maxHeight = maxHeight;
    this.dimension = dimension;
    this.minimumMiningLevel = minimumMiningLevel;
  }
}


