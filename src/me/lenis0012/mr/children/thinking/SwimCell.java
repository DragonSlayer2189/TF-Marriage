package me.lenis0012.mr.children.thinking;

import net.minecraft.server.v1_5_R1.EntityLiving;
import me.lenis0012.mr.children.Child;

public class SwimCell implements BrainCell {
	private Child child;
	private EntityLiving entity;
	
	public SwimCell(Child child) {
		this.child = child;
		this.entity = child.getHandle();
	}
	
	private boolean canExecute() {
		return child.isSpawned() && (entity.G() || entity.I());
	}
	
	@Override
	public void onUpdate() {
		if(this.canExecute()) {
			if(entity.aE().nextFloat() < 0.8F)
				entity.getControllerJump().a();
		}
	}

	@Override
	public void onRemove() {}

	@Override
	public void onCreate() {}

	@Override
	public String getType() {
		return "Swim";
	}
	
	@Override
	public boolean canContinue() {
		return true;
	}
}
