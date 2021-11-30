package moriyashiine.anthropophagy.common.component.entity;

import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import moriyashiine.anthropophagy.common.registry.ModComponents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

public class CannibalComponent implements ServerTickingComponent {
	private static final Map<Predicate<PlayerEntity>, Set<Pair<EntityAttribute, EntityAttributeModifier>>> ATTRIBUTE_MAP;
	
	static {
		ATTRIBUTE_MAP = new HashMap<>();
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 90, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("cce7af90-8887-4b43-a3b0-3265ab5a1b27"), "Cannibal modifier", 6, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("b7657ce5-e362-4cac-baba-9661ca780047"), "Cannibal modifier", 1, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("4fd0fcf3-a827-4ad0-8318-07fafaf3126e"), "Cannibal modifier", 14, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("006731ce-988c-4d8d-921a-0e812ff6e52a"), "Cannibal modifier", 1 / 20f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 80 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 90, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("500d09c9-efbe-4ac4-95f0-0535a087e4b6"), "Cannibal modifier", 5, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("b15887df-6a68-4446-9b0e-c6b45744255c"), "Cannibal modifier", 0.8, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("29e088db-9aa8-4c8a-88b6-f519ef822326"), "Cannibal modifier", 12, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("7c2d047f-f666-43a1-882b-ad751e7d5800"), "Cannibal modifier", 1 / 25f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 70 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 80, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("519e0e77-b8a8-4b76-980b-4f407b5afca7"), "Cannibal modifier", 4, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("6fa06abe-f5df-4542-8ed5-d478a3b268d7"), "Cannibal modifier", 0.6, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("301ccf45-24c8-4a79-9506-28bf6da92046"), "Cannibal modifier", 10, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("e4be7101-30a6-417c-917b-4a54ccc53f33"), "Cannibal modifier", 1 / 30f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 60 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 70, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("31187db9-4b70-4f79-98c8-2aec225dcae1"), "Cannibal modifier", 3, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("2ba3906b-5d20-4729-a3df-aa59cef97667"), "Cannibal modifier", 0.4, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("b58654a4-9229-4f05-aa89-02d7fa5f98d5"), "Cannibal modifier", 8, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("26f4947b-9cd6-42c2-ac0d-a35f53f00c8a"), "Cannibal modifier", 1 / 40f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 50 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 60, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("26f4947b-9cd6-42c2-ac0d-a35f53f00c8a"), "Cannibal modifier", 2, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(UUID.fromString("34c73848-3a6b-405a-b0b3-eabfd7d93dbd"), "Cannibal modifier", 0.2, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("144088ca-bfaa-4f80-8de4-abbf5bd7bfec"), "Cannibal modifier", 6, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("d8534bfb-ed44-4317-8c91-f5228f8487ed"), "Cannibal modifier", 1 / 50f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 40 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 50, Set.of(new Pair<>(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(UUID.fromString("95258be5-d00d-4687-b130-80824b67536f"), "Cannibal modifier", 1, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("0922bf38-ba6f-4b8c-af14-c49f436c234e"), "Cannibal modifier", 4, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("329b23b3-4c34-4478-8dd2-1ac2d83abd0b"), "Cannibal modifier", 1 / 60f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 30 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 40, Set.of(new Pair<>(EntityAttributes.GENERIC_ARMOR, new EntityAttributeModifier(UUID.fromString("80788884-36e7-46c2-bdc6-9c901c8368b3"), "Cannibal modifier", 2, EntityAttributeModifier.Operation.ADDITION)), new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("44806f98-91fb-41df-9554-662930ef838e"), "Cannibal modifier", 1 / 70f, EntityAttributeModifier.Operation.ADDITION))));
		ATTRIBUTE_MAP.put(player -> ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() >= 20 && ModComponents.CANNIBAL_COMPONENT.get(player).getCannibalLevel() < 30, Set.of(new Pair<>(EntityAttributes.GENERIC_MOVEMENT_SPEED, new EntityAttributeModifier(UUID.fromString("92118505-869f-437e-981f-fc238ed8633c"), "Cannibal modifier", 1 / 80f, EntityAttributeModifier.Operation.ADDITION))));
	}
	
	private final PlayerEntity obj;
	private boolean tethered = false;
	private int cannibalLevel = 0, hungerTimer = 0;
	
	public CannibalComponent(PlayerEntity obj) {
		this.obj = obj;
	}
	
	@Override
	public void readFromNbt(NbtCompound tag) {
		setTethered(tag.getBoolean("Tethered"));
		setCannibalLevel(tag.getInt("CannibalLevel"));
		setHungerTimer(tag.getInt("HungerTimer"));
	}
	
	@Override
	public void writeToNbt(NbtCompound tag) {
		tag.putBoolean("Tethered", isTethered());
		tag.putInt("CannibalLevel", getCannibalLevel());
		tag.putInt("HungerTimer", getHungerTimer());
	}
	
	@Override
	public void serverTick() {
		if (getCannibalLevel() >= 30) {
			obj.dropStack(obj.getEquippedStack(EquipmentSlot.LEGS).split(1));
		}
		if (getCannibalLevel() >= 50) {
			obj.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 410, 0, true, false));
			obj.dropStack(obj.getEquippedStack(EquipmentSlot.HEAD).split(1));
		}
		if (getCannibalLevel() >= 70) {
			obj.dropStack(obj.getEquippedStack(EquipmentSlot.FEET).split(1));
		}
		if (getCannibalLevel() >= 90) {
			obj.dropStack(obj.getEquippedStack(EquipmentSlot.CHEST).split(1));
		}
		if (getHungerTimer() > 0) {
			setHungerTimer(getHungerTimer() - 1);
			obj.getHungerManager().setFoodLevel(Math.max(obj.getHungerManager().getFoodLevel() - 1, 0));
		}
	}
	
	public boolean isTethered() {
		return tethered;
	}
	
	public void setTethered(boolean tethered) {
		this.tethered = tethered;
	}
	
	public int getCannibalLevel() {
		return cannibalLevel;
	}
	
	public void setCannibalLevel(int cannibalLevel) {
		this.cannibalLevel = cannibalLevel;
	}
	
	public int getHungerTimer() {
		return hungerTimer;
	}
	
	public void setHungerTimer(int hungerTimer) {
		this.hungerTimer = hungerTimer;
	}
	
	public void updateAttributes(PlayerEntity obj) {
		for (Predicate<PlayerEntity> predicate : ATTRIBUTE_MAP.keySet()) {
			for (Pair<EntityAttribute, EntityAttributeModifier> modifierPair : ATTRIBUTE_MAP.get(predicate)) {
				if (predicate.test(obj)) {
					if (!obj.getAttributeInstance(modifierPair.getLeft()).hasModifier(modifierPair.getRight())) {
						obj.getAttributeInstance(modifierPair.getLeft()).addPersistentModifier(modifierPair.getRight());
					}
				}
				else {
					if (obj.getAttributeInstance(modifierPair.getLeft()).hasModifier(modifierPair.getRight())) {
						obj.getAttributeInstance(modifierPair.getLeft()).removeModifier(modifierPair.getRight());
					}
				}
			}
		}
	}
}
