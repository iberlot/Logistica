/*
 * Querido programador:
 * Cuando escribi este codigo, solo Dios y yo sabiamos como funcionaba.
 * Ahora, Solo Dios lo sabe!!!
 * Asi que, si esta tratando de 'optimizar' esta rutina y fracasa (seguramente),
 * por favor, incremente el siguiente contador como una advertencia para el
 * siguiente colega:
 * totalHorasPerdidasAqui = 60
 */
/**
 * @since 13 jun. 2021
 * @user iBerlo <@> iberlot@usal.edu.ar
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
 *
 * Clase prinsipal del sistema. Organiza toda la informacion a ser usada durante
 * la vida del programa.
 *
 * @author iBerlo <@> iberlot@usal.edu.ar
 *
 */
public class Principal {

	/**
	 * @var Usuarios usuario que usa la aplicacion
	 */
	private Usuarios usuario;

	/**
	 * @var ArrayList<Usuarios> usuarios
	 */
	private ArrayList<Usuarios> usuarios = new ArrayList<>();

	/**
	 * @var ArrayList<Sucursales> sucursales
	 */
	private ArrayList<Sucursales> sucursales = new ArrayList<>();

	/**
	 * @var ArrayList<Productos> productos
	 */
	private ArrayList<Productos> productos = new ArrayList<>();

	/**
	 * @var ArrayList<Transacciones> transacciones
	 */
	private ArrayList<Transacciones> transacciones = new ArrayList<>();

	/**
	 * @var Properties propiedades
	 */
	private Properties propiedades;

	/**
	 * Constructor de la clase
	 *
	 */
	public Principal() {

		// TODO Auto-generated constructor stub

	}

	/**
	 * Busca un usuario en la lista en base al numero de documento
	 *
	 * @param dni documento a buscar
	 * @return boolean
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
	 * Asigna un usuario como el que esta usando la aplicacion en base a un numero
	 * de documento
	 *
	 * @param dni documento a buscar
	 */
	public void asignarUsuarioDni(long dni) {
		// TODO Auto-generated method stub
		for (Usuarios usuario : usuarios) {
			if (usuario.getDni() == dni) {
				this.usuario = usuario;
			}
		}
	}

	/**
	 * Carga datos de prueba en el sistema
	 */
	public void cargadatos() {

		usuarios.add(new Usuarios("Super", "Admin", 0));
		usuarios.add(new Usuarios("Profesor", "Programacion", 9));
		usuarios.add(new Usuarios("Kamisama", "Satoshi", 12345678));
		usuarios.add(new Usuarios("Elsa", "Lado", 25361485));
		usuarios.add(new Usuarios("Lucia", "Fernanda", 66600666));
		usuarios.add(new Usuarios("Cosme", "Fulanito", 12457836));
		usuarios.add(new Usuarios("Ivan", "Berlot", 31343046));
		usuarios.add(new Usuarios("Julia", "Ponti", 30868615));

		productos.add(new Productos("una cosa", "una cosa", 10));
		productos.add(new Productos("otra cosa", "otra cosa", 20));
		productos.add(new Productos("mas cosas", "mas cosas", 300));
		productos.add(new Productos("chirimbolo", "chirimbolo", 40));
		productos.add(new Productos("cachivache", "cachivache", 50));
		productos.add(new Productos("pendorcho", "pendorcho", 550));
		productos.add(new Productos("americano venoso masizo", "americano venoso masizo", 330));
		productos.add(new Productos("Aladino", "Pensabas que nunca ibas a encontrarte con la lámpara de Aladino.", 95));
		productos.add(new Productos("peter vertebrado", "No es Peter Pan... Pero parece.", 550));
		productos.add(new Productos("super-super", "Recomendado para expertos.", 125));
		productos.add(new Productos("realistico 8 pulgadas gel", "Compuesto con gel de siliconas súper blando.", 200));
		productos.add(new Productos("brad grande", "Es un pájaro? es un avión?", 340));
		productos.add(new Productos("kactus", "desde la base de Kactus se desprende una saliente", 90));
		productos.add(new Productos("espada jedy", "El placer compartido siempre es mejor.", 200));
		productos.add(new Productos("inexpulsable", "pequeña pausa entre cada esfera", 90));
		productos.add(new Productos("hot finger medieval", "Este hot finger posee unas púas muy suaves", 95));
		productos.add(new Productos("plug chico", "Súper-recontra-clásico", 90));
		productos.add(new Productos("safary comun", "Con una cabeza de león esculpida en su base", 115));

		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Casa", "Buenos Aires", "Lujan"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 1", "Oita", "Oita"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Sucursal 2", "Hiroshima", "Hiroshima"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 3", "Osaka", "Kobe"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Sucursal 4", "Osaka", "Kioto"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 5", "Nagasaki", "Nagasaki"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Sucursal 6", "Nagoya", "Nagoya"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 7", "Osaka", "Osaka"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 8", "Sapporo", "Sapporo"));
		sucursales.add(new Tiendas(Sucursales.siguiente_identificado(), "Sucursal 9", "Sendai", "Sendai"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Sucursal A", "Yokohama", "Yokohama"));
		sucursales.add(new Depositos(Sucursales.siguiente_identificado(), "Sucursal B", "Tokio", "Tokio"));

		usuarios.add(new Usuarios("Super", "Admin", 0));
		usuarios.add(new Usuarios("Profesor", "Programacion", 9));
		usuarios.add(new Usuarios("Kamisama", "Satoshi", 12345678,
				sucursales.get((int) (Math.random() * ((sucursales.size()))))));
		usuarios.add(
				new Usuarios("Elsa", "Lado", 25361485, sucursales.get((int) (Math.random() * ((sucursales.size()))))));
		usuarios.add(new Usuarios("Lucia", "Fernanda", 66600666,
				sucursales.get((int) (Math.random() * ((sucursales.size()))))));
		usuarios.add(new Usuarios("Cosme", "Fulanito", 12457836,
				sucursales.get((int) (Math.random() * ((sucursales.size()))))));
		usuarios.add(new Usuarios("Ivan", "Berlot", 31343046,
				sucursales.get((int) (Math.random() * ((sucursales.size()))))));
		usuarios.add(new Usuarios("Julia", "Ponti", 30868615,
				sucursales.get((int) (Math.random() * ((sucursales.size()))))));

		for (Sucursales sucursal : sucursales) {

			for (int i = 0; i < ((int) (Math.random() * (15))); i++) {
				sucursal.getProductos().add(productos.get(((int) (Math.random() * ((productos.size()))))));
			}
		}

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

}
