package com.zibmbrazil.eftapi.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zibmbrazil.eftapi.dto.AmmoDto;
import com.zibmbrazil.eftapi.entities.ammo.RifleAmmo;
import com.zibmbrazil.eftapi.repositories.AmmoRepository;

@Service
public class AmmoService {

	@Autowired
	private AmmoRepository repository;


	@Transactional(readOnly = true)
	public List<RifleAmmo> findAll() {
		List<RifleAmmo> list = repository.findAllByOrderByDateSyncAsc();
		return list;

	}

	@Transactional
	public AmmoDto insert(AmmoDto dto) {
		RifleAmmo ammo = new RifleAmmo(null,
				dto.getIcon(), 
				dto.getName(), 
				dto.getDamage(), 
				dto.getPenetrationPower(),
				dto.getArmorDamage(),
				dto.getAccuracy(),
				dto.getRecoil(),
				dto.getFragmentationChance(),
				dto.getRicochetChance(),
				dto.getSpeed(),
				dto.getSpecialEffect(),
				dto.getSoldBy());
		ammo = repository.save(ammo);
		return new AmmoDto(ammo);
	}

	/*@Transactional
	public OrderDTO setDelivered(Long id) {
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDTO(order);
	}*/

}