package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Callcenter {
	
	private String nombre;
	private HashSet<Contacto> listaContactos;
	private List<Integer> listaCodigoPostal;

	public Callcenter(String nombre) {
		this.nombre = nombre;
		listaContactos = new HashSet<>();
		listaCodigoPostal = new ArrayList<>();
	}
	
	public Boolean agregarUnContacto(Contacto nuevo) {
		
		listaContactos.add(nuevo);

		return true;
	}
	
	public Boolean agregarUnNuevoCodigoPostalDeCobertura(Integer nuevoCodigoPostal) {
		
		listaCodigoPostal.add(nuevoCodigoPostal);
		
		return true;
	}
	
	public Boolean verificarCodigoPostalEnCobertura(Integer nuevoCodigoPostal) {
		
		for (Integer cp : listaCodigoPostal) {
			if(cp.equals(nuevoCodigoPostal)) {
				return true;
			}
		}
		
		return false;
	}
	
	public Contacto buscarAlCandidato() {
		
		for (Contacto contacto : listaContactos) {
			if(contacto.getEsCliente()==false && contacto.getDeseaSerLlamadoNuevamente()==true && listaCodigoPostal.contains(contacto.getCp())){
				return contacto;	
			}	
		}
		return null;
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public HashSet<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(HashSet<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	public List<Integer> getListaCodigoPostal() {
		return listaCodigoPostal;
	}

	public void setListaCodigoPostal(List<Integer> listaCodigoPostal) {
		this.listaCodigoPostal = listaCodigoPostal;
	}

}
