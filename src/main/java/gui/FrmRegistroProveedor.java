package gui;


import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class FrmRegistroProveedor extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtRuc;
	private JTextField txtProducto;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroProveedor frame = new FrmRegistroProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmRegistroProveedor() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Proveedor\r\n");
		setBounds(100, 100, 434, 350);
		getContentPane().setLayout(null);
		
		JButton btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnRegistrar.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\minimarket\\src\\main\\resources\\iconos\\Add.gif"));
		btnRegistrar.setBounds(112, 255, 185, 38);
		getContentPane().add(btnRegistrar);
		
		JLabel lblNewLabel = new JLabel("NOMBRE : ");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 70, 79, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("RUC : \r\n");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 95, 56, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DIRECCI\u00D3N : ");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(20, 145, 98, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCTO : ");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(20, 120, 106, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("REGISTRO PROVEEDOR\r\n");
		lblNewLabel_4.setFont(new Font("Arial Black", Font.BOLD, 20));
		lblNewLabel_4.setBounds(65, 24, 291, 19);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("CORREO : ");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(20, 170, 90, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TEL\u00C9FONO : ");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(20, 220, 98, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PA\u00CDS : \r\n");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(20, 195, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(112, 68, 274, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.setBounds(112, 93, 274, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.setBounds(112, 118, 274, 20);
		getContentPane().add(txtProducto);
		txtProducto.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(112, 143, 274, 20);
		getContentPane().add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(112, 168, 274, 20);
		getContentPane().add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JComboBox cboPais = new JComboBox();
		cboPais.setBounds(112, 192, 274, 22);
		getContentPane().add(cboPais);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(112, 218, 274, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

	}
}
