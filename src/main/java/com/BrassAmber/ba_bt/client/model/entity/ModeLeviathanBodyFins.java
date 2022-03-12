package com.BrassAmber.ba_bt.client.model.entity;
// Made with Blockbench 4.1.5
// Exported for Minecraft version 1.17 with Mojang mappings
// Paste this class into your mod and generate all required imports

import com.BrassAmber.ba_bt.BrassAmberBattleTowers;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class ModeLeviathanBodyFins<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BrassAmberBattleTowers.MOD_ID, "modelLeviathanBodyFins"), "main");
	
	private final ModelPart root;
	private final ModelPart finLeft;
	private final ModelPart finRight;

	public ModeLeviathanBodyFins(ModelPart root) {
		this.root = root.getChild("root");
		this.finLeft = root.getChild("fin_left");
		this.finRight = root.getChild("fin_right");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 28).mirror().addBox(6.0F, -6.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 0).addBox(-6.0F, -6.0F, -8.0F, 12.0F, 12.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 28).addBox(-8.0F, -6.0F, -6.0F, 2.0F, 12.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(16, 40).addBox(-6.0F, 6.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F))
		.texOffs(16, 40).mirror().addBox(-6.0F, -8.0F, -6.0F, 12.0F, 2.0F, 12.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.0F, 0.0F));

		PartDefinition fins = body.addOrReplaceChild("fins", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition fin_left = fins.addOrReplaceChild("fin_left", CubeListBuilder.create(), PartPose.offset(8.0F, 0.0F, 0.0F));

		fin_left.addOrReplaceChild("fin_r1", CubeListBuilder.create().texOffs(25, 19).addBox(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.7854F, 0.0F));

		PartDefinition fin_right = fins.addOrReplaceChild("fin_right", CubeListBuilder.create(), PartPose.offset(-8.0F, 0.0F, 0.0F));

		fin_right.addOrReplaceChild("fin_r2", CubeListBuilder.create().texOffs(25, 19).addBox(0.0F, -4.5F, 0.0F, 0.0F, 9.0F, 9.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, buffer, packedLight, packedOverlay);
	}
}