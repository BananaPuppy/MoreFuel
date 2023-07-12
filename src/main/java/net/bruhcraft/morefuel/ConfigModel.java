package net.bruhcraft.morefuel;

import io.wispforest.owo.config.annotation.Config;
import io.wispforest.owo.config.annotation.Modmenu;

import java.util.Arrays;
import java.util.List;

@Modmenu(modId = "morefuel")
@Config(name = "MoreFuel", wrapperName = "MyConfig")
public class ConfigModel {
    public List<String> FuelItems = Arrays.asList("minecraft:magma_block 1600", "minecraft:black_bed 1200", "minecraft:blue_bed 1200", "minecraft:brown_bed 1200", "minecraft:cyan_bed 1200", "minecraft:grey_bed 1200", "minecraft:green_bed 1200", "minecraft:light_blue_bed 1200", "minecraft:light_grey_bed 1200", "minecraft:lime_bed 1200", "minecraft:magenta_bed 1200", "minecraft:orange_bed 1200", "minecraft:pink_bed 1200", "minecraft:purple_bed 1200", "minecraft:red_bed 1200", "minecraft:white_bed 1200", "minecraft:yellow_bed 1200");

}
