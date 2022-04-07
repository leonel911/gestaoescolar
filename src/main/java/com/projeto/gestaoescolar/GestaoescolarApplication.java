package com.projeto.gestaoescolar;

import com.projeto.gestaoescolar.domain.Endereco;
import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class GestaoescolarApplication implements CommandLineRunner {

	@Autowired
	private UnidadeRepository unidadeRepository;

//	@Autowired
//	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GestaoescolarApplication.class, args);
		System.out.println("BANCO RODANDO!");
	}

	@Override
	public void run(String... args) throws Exception {

		Endereco endLuizote = new Endereco(null, "38414-530", "R. Genarino Cazabona", "Luizote de Freitas", "Uberlândia", "Minas Gerais", 954);
		Endereco endMorumbi = new Endereco(null,  "38407-225", "Av. Felipe Calixto Milken", "Morumbi", "Uberlândia", "Minas Gerais", 137);
		Endereco endLagoinha = new Endereco(null,  " 38408-370",  "R. Cel. Antônio Alves Pereira", "Lagoinha", "Uberlândia", "Minas Gerais", 2660);
		Endereco endTibery = new Endereco(null,  "38405-088", "Av. Europa", "Tibery", "Uberlândia", "Minas Gerais", 175);
		Endereco endMartaHelena = new Endereco(null,  "38402-028", "Av. República do Piratini", "Marta Helena", "Uberlândia", "Minas Gerais",  234);
		Endereco endMansour = new Endereco(null,  "38414-446", "R. Rio Uaupes", "Mansour", "Uberlândia", "Minas Gerais", 36);
		Endereco endPequis = new Endereco(null,  "38421-032 ", "Av. Wilson Rodrigues da Silva","Res. Pequis", "Uberlândia", "Minas Gerais", 880);
		Endereco endJardimCelia = new Endereco(null,  "38413-653 "," R. dos Sininhos","Jardim Célia","Uberlândia", "Minas Gerais", 35);
		Endereco endTapuirama = new Endereco(null,  "38417-000","Av. José Pedro Abalém","Distrito de Uberlândia", "Uberlândia", "Minas Gerais", 1122);
		Endereco endCanaa = new Endereco(null,  "38412-470", "Av. Calixto Felipe Milken","Jardim Canaã" , "Uberlândia", "Minas Gerais",  485);
		Endereco endTocantins = new Endereco(null,  "38415-369","R. Renato José Luís","Tocantins", "Uberlândia", "Minas Gerais",  90);

		Unidade luizote = new Unidade(null, "Naica Luizote", endLuizote, null, 1);
		Unidade morumbi = new Unidade(null, "Naica Morumbi", endMorumbi, null, 2);
		Unidade lagoinha = new Unidade(null, "Naica Lagoinha", endLagoinha, null, 3);
		Unidade tibery = new Unidade(null, "Naica Tibery", endTibery, null, 4);
		Unidade martaHelena = new Unidade(null, "Naica Marta Helena", endMartaHelena, null, 5);
		Unidade mansour = new Unidade(null, "Naica Mansour", endMansour, null, 6);
		Unidade pequis = new Unidade(null, "Naica Pequis", endPequis, null, 7);
		Unidade jardimCelia = new Unidade(null, "Naica Jardim Célia", endJardimCelia, null, 8);
		Unidade tapuirama = new Unidade(null, "Naica Tapuirama", endTapuirama, null, 9);
		Unidade canaa = new Unidade(null, "Naica Canaã", endCanaa, null, 10);
		Unidade tocantins = new Unidade(null, "Naica Tocantins", endTocantins, null, 11);

//		enderecoRepository.saveAll(Arrays.asList(endLuizote, endMorumbi, endLagoinha, endTibery, endMartaHelena, endMansour, endPequis, endJardimCelia, endTapuirama, endCanaa, endTocantins));
		unidadeRepository.saveAll(Arrays.asList(luizote, morumbi, lagoinha, tibery, martaHelena, mansour, pequis, jardimCelia, tapuirama, canaa, tocantins));


	}
}
