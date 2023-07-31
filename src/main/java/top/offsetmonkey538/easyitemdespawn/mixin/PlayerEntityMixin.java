package top.offsetmonkey538.easyitemdespawn.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import top.offsetmonkey538.easyitemdespawn.access.ItemEntityAccess;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {

    @Inject(
            method = "dropItem(Lnet/minecraft/item/ItemStack;ZZ)Lnet/minecraft/entity/ItemEntity;",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/ItemEntity;setPickupDelay(I)V"
            ),
            locals = LocalCapture.CAPTURE_FAILHARD
    )
    private void setItemDropperOnDrop(ItemStack stack, boolean throwRandomly, boolean retainOwnership, CallbackInfoReturnable<ItemEntity> cir, double d, ItemEntity itemEntity) {
        Entity thiz = (PlayerEntity) (Object) this;

        if (thiz.isAlive()) return;
        ((ItemEntityAccess) itemEntity).easy_item_despawn$setDropper(thiz);
    }
}
