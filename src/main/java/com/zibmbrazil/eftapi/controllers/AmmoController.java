package com.zibmbrazil.eftapi.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.zibmbrazil.eftapi.dto.AmmoDto;
import com.zibmbrazil.eftapi.entities.Icon;
import com.zibmbrazil.eftapi.entities.ammo.RifleAmmo;
import com.zibmbrazil.eftapi.services.AmmoService;

import java.io.IOException;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@RestController
@RequestMapping(value = "/tarkov")
public class AmmoController {

	Document doc = null;

	@Autowired
	private AmmoService service;

	@GetMapping
	public ResponseEntity<List<RifleAmmo>> findAll() throws IOException {

		List<RifleAmmo> tabela = new ArrayList<RifleAmmo>();

		try {
			doc = Jsoup.connect("https://escapefromtarkov.gamepedia.com/5.45x39mm").get();
		} catch (HttpStatusException ex) {
			System.out.println("Erro ao pegar HTML");
		}

		Elements linhasDaTabela = doc.select("table").first().children().get(0).getElementsByTag("tr");

		for (int i = 1; i < linhasDaTabela.size() - 1; i++) {

			Element colunas = linhasDaTabela.get(i);

			tabela.add(new RifleAmmo(colunas));
		}

		return ResponseEntity.ok().body(tabela);
	}

	@GetMapping("/list/{nome}")
	public ResponseEntity<List<RifleAmmo>> setDelivered(@PathVariable String nome) throws IOException {
		doc = null;

		List<RifleAmmo> tabela = new ArrayList<RifleAmmo>();
		
		String url = "https://escapefromtarkov.gamepedia.com/" + nome ;

		try {
			doc = Jsoup.connect(url).get();
		} catch (HttpStatusException ex) {
			System.out.println("Erro ao pegar HTML");
		}
		Elements linhasDaTabela = doc.select("table").first().children().get(0).getElementsByTag("tr");

		for (int i = 1; i < linhasDaTabela.size() - 1; i++) {

			Element colunas = linhasDaTabela.get(i);

			tabela.add(new RifleAmmo(colunas));
		}

		return ResponseEntity.ok().body(tabela);
	}

	@PostMapping
	public ResponseEntity<AmmoDto> insert(@RequestBody AmmoDto dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
}
