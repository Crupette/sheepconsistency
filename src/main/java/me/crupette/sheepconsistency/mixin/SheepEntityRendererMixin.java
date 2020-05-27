package me.crupette.sheepconsistency.mixin;

import me.crupette.sheepconsistency.client.SheepShearedFeatureRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.SheepEntityRenderer;
import net.minecraft.client.render.entity.model.SheepEntityModel;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Environment(EnvType.CLIENT)
@Mixin(SheepEntityRenderer.class)
public abstract class SheepEntityRendererMixin extends MobEntityRenderer<SheepEntity, SheepEntityModel<SheepEntity>>{

    public SheepEntityRendererMixin(EntityRenderDispatcher renderManager, SheepEntityModel<SheepEntity> model, float f) {
        super(renderManager, model, f);
    }

    @Inject(at = @At("TAIL"), method = "<init>(Lnet/minecraft/client/render/entity/EntityRenderDispatcher;)V")
    private void init(EntityRenderDispatcher dispatcher, CallbackInfo info){
        this.addFeature(new SheepShearedFeatureRenderer(this));
    }
}
