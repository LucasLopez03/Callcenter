package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestContactos {
	
	@Test
	public void queSePuedaCrearUnCallcenter() {
		Callcenter callcenter = new Callcenter("Oeste Cable Color");
		
		assertNotNull(callcenter);
	}

	@Test
	public void queSePuedaCrearUnContacto() {
		Contacto nuevo = new Contacto("Lucas", "Lopez", "5491144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		
		assertNotNull(nuevo);
	}

	
	@Test
	public void queSePuedaAgregarUnContactoALaListaDeContactosDelCallcenter() {
		Callcenter callcenter = new Callcenter("Oeste Cable Color");
		Contacto nuevo = new Contacto("Lucas", "Lopez", "5491144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		
		callcenter.agregarUnContacto(nuevo);
		valorObtenido  = callcenter.getListaContactos().size();
		
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeNoPuedaAgregarUnContactoALaListaDeContactosDelCallcenterMasDeUnaVez() {
		Callcenter callcenter = new Callcenter("Oeste Cable Color");
		
		Contacto nuevo = new Contacto("Lucas", "Lopez", "5491144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		
		Integer valorEsperado = 1;
		Integer valorObtenido;
		
		callcenter.agregarUnContacto(nuevo);
		callcenter.agregarUnContacto(nuevo);
		
		valorObtenido  = callcenter.getListaContactos().size();
		
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSePuedaRegistrarUnaLlamada() {
		Contacto nuevo = new Contacto("Lucas", "Lopez", "5491144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);

		nuevo.registrarNuevaLlamada(true, "Realizo llamada exitosamente");
		
		assertNotNull(nuevo);
	}
	
	@Test
	public void queSePuedaBuscarUnContacto() {
		Callcenter callcenter = new Callcenter("Oeste Cable Color");
		callcenter.agregarUnNuevoCodigoPostalDeCobertura(1755);
		
		Contacto primerContacto = new Contacto("Lucas", "Lopez", "54 9 1144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		primerContacto.setDeseaSerLlamadoNuevamente(false);
		
		Contacto segundoContacto = new Contacto("Axel", "Veron", "54 9 1144193001", "asasd@gmail.com", "Vogel 1", 1855
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		segundoContacto.setEsCliente(true);
		
		Contacto tercerContacto = new Contacto("Yasmin", "Perez", "549111", "yasperez@gmail.com", "parana 1248", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		
		
		callcenter.agregarUnContacto(primerContacto);
		callcenter.agregarUnContacto(segundoContacto);
		callcenter.agregarUnContacto(tercerContacto);
		
		Boolean esClienteEsperado = false;
		Boolean deseaSerLlamadoEsperado = true;
		Integer	cpEnZonaDeCoberturaEsperado = 1755;

		Contacto contactoObtenido = callcenter.buscarAlCandidato();
		
		Boolean esClienteObtenido = tercerContacto.getEsCliente();
		Boolean deseaSerLlamadoObtenido = tercerContacto.getDeseaSerLlamadoNuevamente();
		Integer	cpEnZonaDeCoberturaObtenido = tercerContacto.getCp();
		
		assertEquals(esClienteEsperado, esClienteObtenido);
		assertEquals(deseaSerLlamadoEsperado, deseaSerLlamadoObtenido);
		assertEquals(cpEnZonaDeCoberturaEsperado, cpEnZonaDeCoberturaObtenido);
		assertEquals(tercerContacto, contactoObtenido);
	}
	
	@Test
	public void queSePuedaBuscarUnContactoConCodigoPostalEnZonaDeCobertura() {
		
		Callcenter nuevoCallcenter = new Callcenter("Oeste Cable Color");
		
		nuevoCallcenter.agregarUnNuevoCodigoPostalDeCobertura(1755);
		
		Contacto nuevo = new Contacto("Lucas", "Lopez", "54 9 1144193001", "lucasaxellopez3@gmail.com", "Vogel 2072", 1755
				, "Rafael Castillo", PROVINCIAS_ENUM.BuenosAires);
		
		nuevoCallcenter.agregarUnContacto(nuevo);
		
		Contacto contactoObtenido = nuevoCallcenter.buscarAlCandidato();
		
		assertEquals(nuevo, contactoObtenido);
	}
	
	
	@Test
	public void queSePuedaAgregarUnCodigoPostalDeCobertura() {
		
		Callcenter nuevoCallcenter = new Callcenter("Oeste Cable Color");
		
		nuevoCallcenter.agregarUnNuevoCodigoPostalDeCobertura(1755);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = nuevoCallcenter.getListaCodigoPostal().size();
		
		assertEquals(valorEsperado, valorObtenido);
	}
	
	@Test
	public void queSeVerifiqueQueUnCodigoPostalEsteEnLaListaDeCobertura() {
		Callcenter nuevoCallcenter = new Callcenter("Oeste Cable Color");
		
		Integer codigoPostal = 1755;
		
		nuevoCallcenter.agregarUnNuevoCodigoPostalDeCobertura(codigoPostal);
		
		Boolean valorObtenido = nuevoCallcenter.verificarCodigoPostalEnCobertura(codigoPostal);
		
		assertTrue(valorObtenido);
	}
	
	@Test
	public void queSePuedaCrearUnMailCorrectamente() {
		Contacto nuevo = new Contacto();
		String email = "lucas@kavak.com";
		
		Boolean valorEsperado = Contacto.verificarEMail(email);

		assertTrue(valorEsperado);
	}

	@Test
	public void queSeNoSePuedaCrearUnMailSinArroba() {
		Contacto nuevo = new Contacto();
		String email = "lucaskavak.com";
		
		Boolean valorEsperado = Contacto.verificarEMail(email);

		assertFalse(valorEsperado);
	}
	
	@Test
	public void queSeNoSePuedaCrearUnMailSinPunto() {
		Contacto nuevo = new Contacto();
		String email = "lucas@kavakcom";
		
		Boolean valorEsperado = Contacto.verificarEMail(email);

		assertFalse(valorEsperado);
	}
	
	@Test
	public void queSeNoSePuedaCrearUnMailSinArrobaYSinPunto() {
		Contacto nuevo = new Contacto();
		String email = "lucaskavakcom";
		
		Boolean valorEsperado = Contacto.verificarEMail(email);

		assertFalse(valorEsperado);
	}

	
}
