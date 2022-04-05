package com.projeto.gestaoescolar;

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

	public static void main(String[] args) {
		SpringApplication.run(GestaoescolarApplication.class, args);
		System.out.println("BANCO RODANDO!");
	}

	@Override
	public void run(String... args) throws Exception {

		Unidade luizote = new Unidade(null, "Naica Luizote", " R. Genarino Cazabona, 954 - Luizote de Freitas, Uberlândia - MG, 38414-530", null, 1);
		Unidade morumbi = new Unidade(null, "Naica Morumbi", " Av. Felipe Calixto Milken, 137 - Morumbi, Uberlândia - MG, 38407-225", null, 2);
		Unidade lagoinha = new Unidade(null, "Naica Lagoinha", " R. Cel. Antônio Alves Pereira, 2660 - Lagoinha, Uberlândia - MG, 38408-370 ", null, 3);
		Unidade tibery = new Unidade(null, "Naica Tibery", " Av. Europa, 175 - Tibery, Uberlândia - MG, 38405-088 ", null, 4);
		Unidade martaHelena = new Unidade(null, "Naica Marta Helena", " Av. República do Piratini, 234 - Marta Helena, Uberlândia - MG, 38402-028", null, 5);
		Unidade mansour = new Unidade(null, "Naica Mansour", " R. Rio Uaupes, 36 - Mansour, Uberlândia - MG, 38414-446 ", null, 6);
		Unidade pequis = new Unidade(null, "Naica Pequis", "  Av. Wilson Rodrigues da Silva, 880 - Res. Pequis, Uberlândia - MG, 38421-032 ", null, 7);
		Unidade jardimCelia = new Unidade(null, "Naica Jardim Célia", " R. dos Sininhos, 35 - Jardim Célia, Uberlândia - MG, 38413-653 ", null, 8);
		Unidade tapuirama = new Unidade(null, "Naica Tapuirama", " Av. José Pedro Abalém, 1122 - Distrito de, Uberlândia - MG, 38417-000 ", null, 9);
		Unidade canaa = new Unidade(null, "Naica Canaã", " Sem endereço no momento", null, 10);
		Unidade tocantins = new Unidade(null, "Naica Tocantins", " Sem endereço no momento ", null, 11);

		unidadeRepository.saveAll(Arrays.asList(luizote, morumbi, lagoinha, tibery, martaHelena, mansour, pequis, jardimCelia, tapuirama, canaa, tocantins));


	}
}
