package com.zibmbrazil.eftapi.dto;

import com.zibmbrazil.eftapi.entities.Icon;
import com.zibmbrazil.eftapi.entities.ammo.RifleAmmo;

public class AmmoDto {
	private Long id;
	private Icon icon;
	private String name;
	private String damage;
	private String penetrationPower;
	private String armorDamage;
	private String accuracy;
	private String recoil;
	private String fragmentationChance;
	private String ricochetChance;
	private String speed;
	private String specialEffect;
	private String soldBy;

	public AmmoDto() {
	}

	public AmmoDto(Long id, Icon icon, String name, String damage, String penetrationPower, String armorDamage, String accuracy,
			String recoil, String fragmentationChance, String ricochetChance, String speed, String specialEffect,
			String soldBy) {
		super();
		this.id = id;
		this.icon = icon;
		this.name = name;
		this.damage = damage;
		this.penetrationPower = penetrationPower;
		this.armorDamage = armorDamage;
		this.accuracy = accuracy;
		this.recoil = recoil;
		this.fragmentationChance = fragmentationChance;
		this.ricochetChance = ricochetChance;
		this.speed = speed;
		this.specialEffect = specialEffect;
		this.soldBy = soldBy;
	}

	public AmmoDto(RifleAmmo ammo) {
		super();
		this.id = ammo.getId();
		this.icon = ammo.getIcon();
		this.name = ammo.getName();
		this.damage = ammo.getDamage();
		this.penetrationPower = ammo.getPenetrationPower();
		this.armorDamage = ammo.getArmorDamage();
		this.accuracy = ammo.getAccuracy();
		this.recoil = ammo.getRecoil();
		this.fragmentationChance = ammo.getFragmentationChance();
		this.ricochetChance = ammo.getRicochetChance();
		this.speed = ammo.getSpeed();
		this.specialEffect = ammo.getSpecialEffect();
		this.soldBy = ammo.getSoldBy();
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDamage() {
		return damage;
	}

	public void setDamage(String damage) {
		this.damage = damage;
	}

	public String getPenetrationPower() {
		return penetrationPower;
	}

	public void setPenetrationPower(String penetrationPower) {
		this.penetrationPower = penetrationPower;
	}

	public String getArmorDamage() {
		return armorDamage;
	}

	public void setArmorDamage(String armorDamage) {
		this.armorDamage = armorDamage;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getRecoil() {
		return recoil;
	}

	public void setRecoil(String recoil) {
		this.recoil = recoil;
	}

	public String getFragmentationChance() {
		return fragmentationChance;
	}

	public void setFragmentationChance(String fragmentationChance) {
		this.fragmentationChance = fragmentationChance;
	}

	public String getRicochetChance() {
		return ricochetChance;
	}

	public void setRicochetChance(String ricochetChance) {
		this.ricochetChance = ricochetChance;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public String getSpecialEffect() {
		return specialEffect;
	}

	public void setSpecialEffect(String specialEffect) {
		this.specialEffect = specialEffect;
	}

	public String getSoldBy() {
		return soldBy;
	}

	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
