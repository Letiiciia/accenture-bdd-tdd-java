package com.validador.cpf.validadorCpf;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.validador.cpf.validadorCpf.models.Cliente;

@SpringBootTest
class ValidadorCpfApplicationTests {

	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("22713965063");
		assertEquals(true, cliente.validarCPF());	
	}

	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("22713965060");
		assertEquals(false, cliente.validarCPF());	
	}

	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("227139650");
		assertEquals(false, cliente.validarCPF());	
	}

	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("227.139.650-63");
		assertEquals(true, cliente.validarCPF());	
	}

	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("227.139.65-63");
		assertEquals(false, cliente.validarCPF());	
	}

	@Test
	void fazendoTesteDeCpfInvalidoComVirgula() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946,220.360-11");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoFinal() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220.360-10 ");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoComeco() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf(" 946.220.360-10");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComEspacoNoMeio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("946.220. 360-10");
		assertEquals(true, cliente.validarCPF());
	}
	
	@Test
	void fazendoTesteDeCpfInvalidoComLetras() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("lll.lll. lll-ll");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComUmaLetra() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("l46.220. 360-10");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComCaratcteresEspeciais() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("%46.220. 360-10");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoComNumeroMaiorQueOnze() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("%46.220. 360-104549");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoDoidoQuePassou() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

	@Test
	void fazendoTesteDeCpfInvalidoVazio() {
		Cliente cliente = new Cliente();
		cliente.setNome("Danilo");
		assertEquals(false, cliente.validarCPF());
	}
}
