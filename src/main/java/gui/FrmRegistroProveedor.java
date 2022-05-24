package gui;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import entidad.Proveedor;
import model.ProveedorModel;
import util.Validaciones;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class FrmRegistroProveedor extends JInternalFrame implements ActionListener, KeyListener {
	private JTextField txtNombre;
	private JTextField txtRuc;
	private JTextField txtProducto;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	private JTextField txtTelefono;
	private JButton btnRegistrar;
	private JComboBox cboPais;

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
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 18));
		btnRegistrar.setIcon(new ImageIcon(FrmRegistroProveedor.class.getResource("/iconos/Add.gif")));
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
		txtNombre.addKeyListener(this);
		txtNombre.setBounds(112, 68, 274, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtRuc = new JTextField();
		txtRuc.addKeyListener(this);
		txtRuc.setBounds(112, 93, 274, 20);
		getContentPane().add(txtRuc);
		txtRuc.setColumns(10);
		
		txtProducto = new JTextField();
		txtProducto.addKeyListener(this);
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
		
		cboPais = new JComboBox<String>();
		cboPais.addItem("[Seleccionar]");
		cboPais.addItem("Perú");
		cboPais.addItem("Argentina");
		cboPais.addItem("Bolivia");
		cboPais.addItem("Chile");
		cboPais.addItem("Uruguay");
		cboPais.addItem("Venezuela");
		cboPais.addItem("Brasil");
		cboPais.addItem("Paraguay");
		cboPais.addItem("España");
		cboPais.addItem("Honduras");
		cboPais.setBounds(112, 192, 274, 22);
		getContentPane().add(cboPais);
		
		txtTelefono = new JTextField();
		txtTelefono.addKeyListener(this);
		txtTelefono.setBounds(112, 218, 274, 20);
		getContentPane().add(txtTelefono);
		txtTelefono.setColumns(10);

	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(e);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent e) {
		String nom = txtNombre.getText().trim();
		String ruc = txtRuc.getText().trim();
		String prod = txtProducto.getText();
		String direc = txtDireccion.getText().trim();
		String correo = txtCorreo.getText().trim();
		String pais = cboPais.getSelectedItem().toString();
		String tele = txtTelefono.getText();
		

		if (!nom.matches(Validaciones.TEXTO)) {
			mensaje("El nombre debe ser de 2 a 20 caracteres");
		} else if (!ruc.matches(Validaciones.RUC)) {
			mensaje("El DNI debe ser de 11 dígitos");
		} else if (!prod.matches(Validaciones.TEXTO)) {
			mensaje("El producto debe ser de 2 a 20 caracteres");
		} else if (!direc.matches(Validaciones.TEXTO_NUMERO)) {
			mensaje("La dirección debe ser de 2 a 40 caracteres");
		}else if (!correo.matches(Validaciones.CORREO)) {
			mensaje("Correo no valido");
		} else if (cboPais.getSelectedIndex() == 0) {
			mensaje("Seleccione un país");
		} else if (!tele.matches(Validaciones.TELEFONO)) {
			mensaje("El teléfono es de 9 dígitos");
		} else {
			Proveedor obj = new Proveedor();
			obj.setNombre(nom);
			obj.setRuc(ruc);
			obj.setProducto(prod);
			obj.setCorreo(correo);
			obj.setPais(pais);
			obj.setTelefono(tele);
			
			ProveedorModel model = new ProveedorModel();
			int salida = model.insertaProveedor(obj);

			if (salida > 0) {
				mensaje("Se insertó correctamente");
				limpiar();
			} else {
				mensaje("Error en el Registro");
			}
			
 
		}
	}
	
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	public void limpiar() {
		txtNombre.setText("");
		txtRuc.setText("");
		txtDireccion.setText("");
		txtTelefono.setText("");
		txtCorreo.setText("");
		cboPais.setSelectedIndex(0);
		txtNombre.requestFocusInWindow();
	}
	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
	}
	public void keyTyped(KeyEvent e) {
		if (e.getSource() == txtTelefono) {
			keyTypedTxtTelefonoJTextField(e);
		}
		if (e.getSource() == txtProducto) {
			keyTypedTxtProductoJTextField(e);
		}
		if (e.getSource() == txtRuc) {
			keyTypedTxtRucJTextField(e);
		}
		if (e.getSource() == txtNombre) {
			keyTypedTxtNombreJTextField(e);
		}
	}
	protected void keyTypedTxtNombreJTextField(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
		}
	}
	protected void keyTypedTxtRucJTextField(KeyEvent e) {
		if (Character.isLetter(e.getKeyChar())) {
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
		}

		String ruc = txtRuc.getText() + e.getKeyChar();
		if (ruc.length() > 11) {
			e.consume();
		}
	}
	protected void keyTypedTxtProductoJTextField(KeyEvent e) {
		if (Character.isDigit(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras");
		}
	}
	protected void keyTypedTxtTelefonoJTextField(KeyEvent e) {
		if (Character.isLetter(e.getKeyChar())) {
			getToolkit().beep();
			e.consume();
			JOptionPane.showMessageDialog(rootPane, "Ingresar solo números");
		}

		String tele = txtTelefono.getText() + e.getKeyChar();
		if (tele.length() > 9) {
			getToolkit().beep();
			e.consume();
		}
	}
}
