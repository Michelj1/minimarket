package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

import entidad.Proveedor;
import util.MySqlDBConexion;

public class ProveedorModel {
	
	private static Logger log = Logger.getLogger(ProveedorModel.class.getName());
	
	// Registra Proveedor

		public int insertaProveedor(Proveedor obj) {

			int salida = -1;

			Connection conn = null;
			PreparedStatement pstm = null;
			try {

				// Se crea la conexion
				conn = MySqlDBConexion.getConexion();

				// Se prepara el sql

				String sql = "insert into proveedor value(null,?,?,?,?,?,?,?,curtime())";
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, obj.getNombre());
				pstm.setString(2, obj.getRuc());
				pstm.setString(3, obj.getProducto());
				pstm.setString(4, obj.getDireccion());
				pstm.setString(5, obj.getCorreo());
				pstm.setString(6, obj.getPais());
				pstm.setString(7, obj.getTelefono());
				

				log.info(">>> " + pstm);

				// 3 Ejecutamos a la base de datos
				// Retorna la cantidad de registrados en salida
				salida = pstm.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (pstm != null)
						pstm.close();
					if (conn != null)
						conn.close();
				} catch (Exception e2) {

				}
			}
			log.info(">>> Fin >>> insertaProveedor");
			return salida;
		}

}
