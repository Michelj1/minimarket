package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import entidad.Cliente;
import util.MySqlDBConexion;
//EMANUEL
public class ClienteModel {

	private static Logger Log = Logger.getLogger(ClienteModel.class.getName());

	public int registrarCliente(Cliente cli) {
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			//Se crea la conexcion
			conn = MySqlDBConexion.getConexion();
			
			//Se prepara el sql server
			String sql = "insert into cliente value(?,?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cli.getDni());
			pstm.setString(2,cli.getNombre());
			pstm.setString(3,cli.getApellido());
			pstm.setString(4,cli.getTelefono());
			pstm.setString(5,cli.getDireccion());
			pstm.setString(6,cli.getPais());
			pstm.setString(7,cli.getComprobante());
			
			Log.info(">>>"+pstm);
			
			salida= pstm.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) 
					pstm.close();
				if (conn!=null) 
					conn.close();	
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return salida;
	}
	public int eliminacliente(int idCliente) {

		Logger log = Logger.getLogger(ClienteModel.class.getName());

		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// PASO 1 : CREAR LA CONEXION
			conn = MySqlDBConexion.getConexion();
			// PASO 2 : SE PREPARA EL SQL
			String sql = "delete from cliente where idCliente = ?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, idCliente);

			log.info(">>>" + pstm);

			// PASO 3 : EJECUTAMOS A LA BASE DE DATOS
			// RETORNA LA CANTIDAD DE RESGISTRADOS EN SALIDA
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

		return salida;
	}
	public int actualizacliente(Cliente obj) {

		Logger log = Logger.getLogger(ClienteModel.class.getName());

		int salida = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			// PASO 1 : CREAR LA CONEXION
			conn = MySqlDBConexion.getConexion();
			// PASO 2 : SE PREPARA EL SQL
			String sql = "update cliente set nombre=?,apellido=?,dni=?,telefono=?,direccion=?,pais=?,comprobante=? where idCliente=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getApellido());
			pstm.setString(3, obj.getDni());
			pstm.setString(4, obj.getTelefono());
			pstm.setString(5, obj.getDireccion());
			pstm.setString(6, obj.getPais());
			pstm.setString(7, obj.getComprobante());
			pstm.setInt(8, obj.getIdCliente());

			log.info(">>>" + pstm);

			// PASO 3 : EJECUTAMOS A LA BASE DE DATOS
			// RETORNA LA CANTIDAD DE RESGISTRADOS EN SALIDA
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

		return salida;
	}
	public List<Cliente> listaCliente() {
		ArrayList<Cliente> salida = new ArrayList<Cliente>();
		
		Connection conn= null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		try {
			// PASO 1 : CREAR LA CONEXION
			conn = MySqlDBConexion.getConexion();
			
			// PASO 2 : SE PREPARA EL SQL
			String sql = "select * from Cliente";
			pstm = conn.prepareStatement(sql);
			
			// PASO 3 : EJECUTAMOS A LA BASE DE DATOS
			rs = pstm.executeQuery();
			Cliente obj = null;
			while(rs.next()) {
				obj= new Cliente();
				obj.setIdCliente(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellido(rs.getString(3));
				obj.setDni(rs.getString(4));
				obj.setTelefono(rs.getString(5));
				obj.setDireccion(rs.getString(6));
				obj.setPais(rs.getString(7));
				obj.setComprobante(rs.getString(8));
				salida.add(obj);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) 
					pstm.close();
				if (conn!=null) 
					conn.close();	
			} catch (Exception e2) {}
		}
		return salida;
	}

}