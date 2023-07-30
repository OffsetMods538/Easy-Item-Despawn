package top.offsetmonkey538.easyitemdespawn.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import top.offsetmonkey538.easyitemdespawn.access.ItemEntityAccess;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Inject(
            method = "dropStack(Lnet/minecraft/item/ItemStack;F)Lnet/minecraft/entity/ItemEntity;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/ItemEntity;setToDefaultPickupDelay()V"
            ),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void setItemDropperOnDrop(ItemStack stack, float yOffset, CallbackInfoReturnable<ItemEntity> cir, ItemEntity itemEntity) {
        ((ItemEntityAccess) itemEntity).setDropper((Entity) (Object) this);
    }
}
