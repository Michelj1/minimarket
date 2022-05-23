package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entidad.Producto;
import util.MySqlDBConexion;

public class ProductoModel {
	public int ingresarProducto(Producto producto) {
		int salida= -1;
		
		Connection conexion= null;
		PreparedStatement pstm =null;
		try {
			conexion = MySqlDBConexion.getConexion();
			
			String  sql = "insert into producto values(null,?,?,curtime(),?,?,?,?)";
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1,producto.getNombre());
			pstm.setString(2,producto.getCategoria());
			pstm.setString(3,producto.getPrecio());
			pstm.setString(4,producto.getStock());
			pstm.setString(5,producto.getPeso());
			pstm.setString(6,producto.getCantidadPeso());
			
			salida = pstm.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conexion!=null) {
						conexion.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return salida;
	}
	
	public List<Producto> listarProducto(){
		ArrayList<Producto> salida = new ArrayList<Producto>();
		Connection conexion= null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		try {
			
			conexion  = MySqlDBConexion.getConexion();
			
			String sql ="select * from producto";
			pstm =conexion.prepareStatement(sql);
			
			rs  =pstm.executeQuery();
			Producto obj = null;
			while(rs.next()) {
				obj = new Producto();
				obj.setIdProducto(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setCategoria(rs.getString(3));
				obj.setPrecio(rs.getString(5));
				obj.setStock(rs.getString(6));
				obj.setPeso(rs.getString(7));
				obj.setCantidadPeso(rs.getString(8));
				salida.add(obj);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			try {
				if(conexion!=null) {
					conexion.close();
				}
				if (pstm !=null) {
					pstm.close();
				}
					
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		return salida;
	}
	public int eliminarProducto(int idProducto) {
		int salida= -1;
		
		Connection conexion= null;
		PreparedStatement pstm =null;
		try {
			conexion = MySqlDBConexion.getConexion();
			
			String  sql = "delete from producto where idProducto=?";
			pstm = conexion.prepareStatement(sql);
			pstm.setInt(1,idProducto);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conexion!=null) {
						conexion.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return salida;
	}
	
	
	public int actualizararProducto(Producto producto) {
		int salida= -1;
		
		Connection conexion= null;
		PreparedStatement pstm =null;
		try {
			conexion = MySqlDBConexion.getConexion();
			
			String  sql = "update producto set nombre=?,categoria=?,precio=?,stock=?,peso=?,cantidadPeso=? where idProducto=?";
			pstm = conexion.prepareStatement(sql);
			pstm.setString(1,producto.getNombre());
			pstm.setString(2,producto.getCategoria());
			pstm.setString(3,producto.getPrecio());
			pstm.setString(4,producto.getStock());
			pstm.setString(5,producto.getPeso());
			pstm.setString(6,producto.getCantidadPeso());
			pstm.setInt(7, producto.getIdProducto());
			
			salida = pstm.executeUpdate();
	
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
				try {
					if(pstm!=null) {
						pstm.close();
					}
					if(conexion!=null) {
						conexion.close();
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		return salida;
	}
	
}
