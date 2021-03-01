package com.zibmbrazil.eftapi.entities.ammo;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.jsoup.nodes.Element;

import com.zibmbrazil.eftapi.entities.Icon;

@Entity
@Table(name = "tb_ammo")
public class RifleAmmo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@OneToOne
	@JoinTable(name = "tb_ammo_icon", joinColumns = @JoinColumn(name = "ammo_id"), inverseJoinColumns = @JoinColumn(name = "icon_id"))
	private Icon icon;
	private String name;
	private String damage;
	private String penetrationPower;
	private String armorDamage;
	private String accuracy;
	private String recoil;
	private String fragmentationChance;
	private String ricochetChance;
	private String lightBleendingChance;
	private String heavyBleendingChance;
	private String speed;
	private String specialEffect;
	private String soldBy;
	private LocalDateTime dateSync;

	public RifleAmmo() {

	}

	public RifleAmmo(Element element) {
		int linhas = (element.childNodeSize() / 2);
		for (int j = 0; j < linhas; j++) {
			Element coluna = element.child(j);

			setDateSync(LocalDateTime.now());
			switch (j) {
			case 0:
				Icon icon = new Icon();
				icon.setLink(coluna.getElementsByTag("a").attr("href"));
				icon.setTitle(coluna.getElementsByTag("a").attr("title"));
				icon.setUrl(coluna.getElementsByTag("img").get(0).attr("src"));
				icon.setWidth(coluna.getElementsByTag("img").get(0).attr("width"));
				icon.setHeight(coluna.getElementsByTag("img").get(0).attr("height"));
				setIcon(icon);
				break;
			case 1:
				setName(coluna.text());
				break;
			case 2:
				if (coluna.text() != "")
					setDamage(coluna.text());
				break;
			case 3:
				if (coluna.text() != "")
					setPenetrationPower(coluna.text());
				break;
			case 4:
				if (coluna.text() != "")
					setArmorDamage(coluna.text());
				break;
			case 5:
				if (coluna.text() != "")
					setAccuracy(coluna.text());
				break;
			case 6:
				if (coluna.text() != "")
					setRecoil(coluna.getElementsByTag("td").text());
				break;
			case 7:
				if (coluna.text() != "")
					setFragmentationChance(coluna.text().split("%")[0]);
				break;
			case 8:
				if (coluna.text() != "")
					setRicochetChance(coluna.text().split("%")[0]);
				break;
			case 9:
				if (coluna.text() != "")
					setLightBleendingChance(coluna.text());
				break;
			case 10:
				if (coluna.text() != "")
					setHeavyBleendingChance(coluna.text());
				break;
			case 11:
				if (coluna.text() != "")
					setSpeed(coluna.text());
				break;
			case 12:
				if (coluna.text() != "")
					setSpecialEffect(coluna.text());
				break;
			case 13:
				setSoldBy(coluna.toString());
				break;
			default:
				break;
			}
		}

	}

	public RifleAmmo(Long id, Icon icon, String name, String damage, String penetrationPower, String armorDamage,
			String accuracy, String recoil, String fragmentationChance, String ricochetChance, String speed,
			String specialEffect, String soldBy) {
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
		setDateSync(LocalDateTime.now());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LocalDateTime getDateSync() {
		return dateSync;
	}

	public void setDateSync(LocalDateTime dateSync) {
		this.dateSync = dateSync;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RifleAmmo other = (RifleAmmo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getHeavyBleendingChance() {
		return heavyBleendingChance;
	}

	public void setHeavyBleendingChance(String heavyBleendingChance) {
		this.heavyBleendingChance = heavyBleendingChance;
	}

	public String getLightBleendingChance() {
		return lightBleendingChance;
	}

	public void setLightBleendingChance(String lightBleendingChance) {
		this.lightBleendingChance = lightBleendingChance;
	}

}
