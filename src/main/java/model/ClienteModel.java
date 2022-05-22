package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.util.logging.Logger;

import entidad.Cliente;
import util.MySqlDBConexion;

public class ClienteModel {

	private static Logger Log = Logger.getLogger(ClienteModel.class.getName());

	public int registrarCliente(Cliente cli) {
		int salida = -1;
		
		Connection conn= null;
		PreparedStatement pstm= null;
		try {
			//Se crea la conexcion
			conn = MySqlDBConexion.getConexion();
			
			//Se prepara el sql
			String sql = "insert into cliente value(?,?,?,?,?,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,cli.getDni());
			pstm.setString(2,cli.getNombre());
			pstm.setString(3,cli.getApellido());
			pstm.setString(4,cli.getTelefono());
			pstm.setString(5,cli.getDireccion());
			pstm.setString(6,cli.getPais());
			
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
}