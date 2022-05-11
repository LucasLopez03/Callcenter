package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Contacto{
		
	private String nombre;
	private String apellido;
	private String celular;
	private String mail;
	private String direccion;
	private Integer cp;
	private String localidad;
	private Boolean EsCliente;
	private Boolean DeseaSerLlamadoNuevamente;
	private PROVINCIAS_ENUM provincia;
	private ArrayList<Llamada> listaLlamada;

	public Contacto() {
		this.EsCliente = false;
		this.DeseaSerLlamadoNuevamente = true;
	}

	public Contacto(String nombre, String apellido, String celular, String mail, String direccion, Integer cp,
				String localidad, PROVINCIAS_ENUM provincia) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.celular = celular;
		this.mail = mail;
		this.direccion	= direccion;
		this.cp = cp;
		this.localidad	= localidad;
		this.provincia = provincia;
		this.EsCliente = false;
		this.DeseaSerLlamadoNuevamente = true;
		listaLlamada = new ArrayList<>();
	}
	
	public Boolean registrarNuevaLlamada(Boolean fueExitosa, String observaciones) {
		
		Llamada nuevaLlamada = new Llamada(fueExitosa, observaciones);
		
		listaLlamada.add(nuevaLlamada);
			
		if (fueExitosa = true) {
			this.EsCliente = true;
			this.DeseaSerLlamadoNuevamente = false;
		}else if (fueExitosa = false) {
			this.EsCliente = false;
			this.DeseaSerLlamadoNuevamente = true;
		}
		
		return true;
	}
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + "Apellido: " + apellido + "Celular: " + celular + "Direccion: " + direccion + "Es cliente? " + EsCliente + "Desea ser llamada nuevamente? " + DeseaSerLlamadoNuevamente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Boolean getEsCliente() {
		return EsCliente;
	}

	public void setEsCliente(Boolean esCliente) {
		EsCliente = esCliente;
	}

	public Boolean getDeseaSerLlamadoNuevamente() {
		return DeseaSerLlamadoNuevamente;
	}

	public void setDeseaSerLlamadoNuevamente(Boolean deseaSerLlamadoNuevamente) {
		DeseaSerLlamadoNuevamente = deseaSerLlamadoNuevamente;
	}

	public PROVINCIAS_ENUM getProvincia() {
		return provincia;
	}

	public void setProvincia(PROVINCIAS_ENUM provincia) {
		this.provincia = provincia;
	}

	public ArrayList<Llamada> getListaLlamada() {
		return listaLlamada;
	}

	public void setListaLlamada(ArrayList<Llamada> listaLlamada) {
		this.listaLlamada = listaLlamada;
	}
	
	public static Boolean verificarEMail(String email) {
		
		if(email.contains("@") && email.contains(".")) {
			return true;
		}
		
		return false;
	}

}
