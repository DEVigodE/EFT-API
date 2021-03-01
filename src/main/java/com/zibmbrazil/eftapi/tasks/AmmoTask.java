package com.zibmbrazil.eftapi.tasks;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.zibmbrazil.eftapi.controllers.AmmoController;

@Component
public class AmmoTask {

	private static final Logger log = LoggerFactory.getLogger(AmmoTask.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Autowired
	AmmoController ammoController;

	/*@Scheduled(fixedRate = 10000)
	public void reportCurrentTime() throws IOException {
		log.info("ATUALIZANDO DADOS AMMO -> {}", dateFormat.format(new Date()));

		System.out.println(new Gson().toJson(ammoController.findAll()));

	}*/

}