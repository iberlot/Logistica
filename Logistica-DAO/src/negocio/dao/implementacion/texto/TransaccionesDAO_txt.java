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
 * @name TransaccionesDAO.java
 * @package negocio.dao
 * @project Logistica-DAO
 */
package negocio.dao.implementacion.texto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import negocio.dao.iDAO;

/**
 * @author IVANB
 *
 */
public class TransaccionesDAO_txt<T> extends TextoDao<T> implements iDAO<T> {

	public TransaccionesDAO_txt(String paramProp) throws FileNotFoundException, IOException {
		super(paramProp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object add(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get(Object elemento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList getLista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveLista(ArrayList lista) {
		// TODO Auto-generated method stub

	}

}
