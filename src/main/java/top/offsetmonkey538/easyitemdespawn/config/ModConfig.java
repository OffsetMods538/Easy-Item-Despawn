package top.offsetmonkey538.easyitemdespawn.config;

import blue.endless.jankson.Comment;
import java.util.HashMap;
import java.util.Map;
import top.offsetmonkey538.monkeyconfig538.Config;

public class ModConfig extends Config {

     @Comment("This is the despawn time (measured in ticks) for *all* items (even ones not dropped from a death). Only applies for entities that don't have a specified despawn time. Default value = 6000")
     public int globalDespawnTime = 6000;

     public Map<String, Integer> entityDropDespawnTimes = new HashMap<>(Map.of(
             "minecraft:player", 12000
     ));
}
