package top.offsetmonkey538.easyitemdespawn.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import top.offsetmonkey538.easyitemdespawn.config.ModConfig;
import top.offsetmonkey538.easyitemdespawn.access.ItemEntityAccess;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin implements ItemEntityAccess {

    @Unique
    private Identifier dropper = null;

    @ModifyConstant(
            method = "tick",
            constant = @Constant(
                    intValue = 6000
            )
    )
    private int modifyDespawnTime(int constant) {
        return ModConfig.globalDespawnTime;
    }

    @Override
    public void setDropper(Entity dropper) {
        this.dropper = Registries.ENTITY_TYPE.getId(dropper.getType());
    }
}
