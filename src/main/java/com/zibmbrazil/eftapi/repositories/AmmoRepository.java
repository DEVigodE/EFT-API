package com.zibmbrazil.eftapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zibmbrazil.eftapi.entities.ammo.RifleAmmo;

public interface AmmoRepository extends JpaRepository<RifleAmmo, Long> {

	List<RifleAmmo> findAllByOrderByDateSyncAsc();

}
