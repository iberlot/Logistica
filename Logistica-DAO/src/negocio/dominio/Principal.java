/*
 * Querido programador:
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 * totalHorasPerdidasAqui = 0
 */
/**
 * @since 13 jun. 2021
 * @user IVANB
 * @name Principal.java
 * @package negocio.dominio
 * @project Logistica-DAO
 */
package negocio.dominio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

/**
 * @author IVANB
 *
 */
public class Principal {

	private Usuarios usuario;

	private ArrayList<Usuarios> usuarios = new ArrayList<>();

	private ArrayList<Sucursales> sucursales = new ArrayList<>();

	private ArrayList<Productos> productos = new ArrayList<>();

	private ArrayList<Transacciones> transacciones = new ArrayList<>();

	private Properties propiedades;

	/**
	 * 
	 */
	public Principal() {

		// TODO Auto-generated constructor stub

	}

	public void cargadatos() {

		usuarios.add(new Usuarios("Ivan", "Berlot", 31343046));
		usuarios.add(new Usuarios("Alguien", "mas", 0));
		usuarios.add(new Usuarios("Julia", "Ponti", 30868615));

		productos.add(new Productos("una cosa", "una cosa", 10));
		productos.add(new Productos("otra cosa", "otra cosa", 20));
		productos.add(new Productos("mas cosa", "mas cosa", 300));
		productos.add(new Productos("chirimbolo", "chirimbolo", 40));
		productos.add(new Productos("cachivache", "cachivache", 50));
		productos.add(new Productos("pendorcho", "pendorcho", 550));
		productos.add(new Productos("americano venoso masizo", "americano venoso masizo", 330));

		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Aca", "Buenos Aires", "Merlo"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Aca tambien", "Buenos Aires", "Merlo"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Y Aca", "Buenos Aires", "Merlo"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "moon", "Sistema solar", "La luna"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sexitas", "Buenos Aires", "Caballito"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "casa", "Buenos Aires", "Lujan"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "El otooto", "Tucuman", "Tucuman"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Acasdasd", "Buenos Aires", "Merlo"));

		for (Sucursales sucursal : sucursales) {

			for (int i = 0; i < ((int) (Math.random() * (15))); i++) {
				sucursal.getProductos().add(productos.get(((int) (Math.random() * ((0 + productos.size()))))));
			}
		}

		usuarios.add(new Usuarios("Ivan", "Berlot", 31343046));
		usuarios.add(new Usuarios("Alguien", "mas", 0));
		usuarios.add(new Usuarios("Julia", "Ponti", 30868615));

		for (int i = 0; i < ((int) (Math.random() * ((5 + 50) - 1))); i++) {

			Calendar f = Calendar.getInstance();

			int a = (int) (1990 + (Math.random() * ((30))));
			int m = (int) (Math.random() * (11));
			int d = (int) (1 + (Math.random() * ((28))));

			f.set(a, m, d);

			transacciones.add(new Transacciones(f, sucursales.get((int) (Math.random() * ((sucursales.size())))),
					sucursales.get((int) (Math.random() * ((sucursales.size())))),
					productos.get((int) (Math.random() * ((productos.size())))),
					usuarios.get((int) (Math.random() * ((usuarios.size())))),
					Transacciones.getTipos()[(int) (Math.random() * ((1 + Transacciones.getTipos().length) - 1))]));
		}

	}

	/**
	 * @return el campo usuario
	 */
	public Usuarios getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario El parametro usuario para setear
	 */
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return el campo usuarios
	 */
	public ArrayList<Usuarios> getUsuarios() {
		return usuarios;
	}

	/**
	 * @param usuarios El parametro usuarios para setear
	 */
	public void setUsuarios(ArrayList<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return el campo sucursales
	 */
	public ArrayList<Sucursales> getSucursales() {
		return sucursales;
	}

	/**
	 * @param sucursales El parametro sucursales para setear
	 */
	public void setSucursales(ArrayList<Sucursales> sucursales) {
		this.sucursales = sucursales;
	}

	/**
	 * @return el campo productos
	 */
	public ArrayList<Productos> getProductos() {
		return productos;
	}

	/**
	 * @param productos El parametro productos para setear
	 */
	public void setProductos(List<Productos> productos) {
		this.productos = (ArrayList<Productos>) productos;
	}

	/**
	 * @return el campo transacciones
	 */
	public ArrayList<Transacciones> getTransacciones() {
		return transacciones;
	}

	/**
	 * @param transacciones El parametro transacciones para setear
	 */
	public void setTransacciones(ArrayList<Transacciones> transacciones) {
		this.transacciones = transacciones;
	}

	/**
	 * @return el campo propiedades
	 */
	public Properties getPropiedades() {
		return propiedades;
	}

	/**
	 * @param propiedades El parametro propiedades para setear
	 */
	public void setPropiedades(Properties propiedades) {
		this.propiedades = propiedades;
	}

	/**
	 * @param dni
	 * @return
	 */
	public boolean buscarDni(long dni) {
		// TODO Auto-generated method stub
		for (Usuarios usuario : usuarios) {
			if (usuario.getDni() == dni) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @param dni
	 * @return
	 */
	public void asignarUsuarioDni(long dni) {
		// TODO Auto-generated method stub
		for (Usuarios usuario : usuarios) {
			if (usuario.getDni() == dni) {
				this.usuario = usuario;
			}
		}
	}
}
