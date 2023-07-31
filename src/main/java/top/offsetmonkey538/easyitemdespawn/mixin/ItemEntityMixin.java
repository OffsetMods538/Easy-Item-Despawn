package top.offsetmonkey538.easyitemdespawn.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import top.offsetmonkey538.easyitemdespawn.access.ItemEntityAccess;

import static top.offsetmonkey538.easyitemdespawn.EasyItemDespawn.*;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements ItemEntityAccess {

    @Unique
    private Identifier easy_item_despawn$dropper = null;

    @ModifyConstant(
            method = "tick",
            constant = @Constant(
                    intValue = 6000
            )
    )
    private int modifyDespawnTime(int constant) {
        if (easy_item_despawn$dropper == null) return config().globalDespawnTime;
        if (!config().entityDropDespawnTimes.containsKey(easy_item_despawn$dropper.toString())) return config().globalDespawnTime;
        return config().entityDropDespawnTimes.get(easy_item_despawn$dropper.toString());
    }

    @Override
    public void easy_item_despawn$setDropper(Entity dropper) {
        this.easy_item_despawn$dropper = Registries.ENTITY_TYPE.getId(dropper.getType());
    }
}
