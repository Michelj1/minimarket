package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import entidad.Cliente;
import model.ClienteModel;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmRegistroCliente extends JInternalFrame {
	private JTextField txtNom;
	private JTextField txtTelf;
	private JTextField txtDirec;
	private JTextField txtDni;
	private JTextField txtApe;
	private JComboBox cboPais;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistroCliente frame = new FrmRegistroCliente();
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
	public FrmRegistroCliente() {
		setIconifiable(true);
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Registro de Clientes");
		setBounds(100, 100, 631, 647);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRO CLIENTE");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(190, 46, 263, 34);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(63, 131, 78, 17);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido :");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(63, 177, 78, 17);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI :");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(63, 227, 78, 17);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Tel\u00E9fono :");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(63, 272, 78, 17);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Direcci\u00F3n :");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(63, 318, 78, 17);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Pa\u00EDs :");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(63, 371, 78, 13);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Comprobante :");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(63, 417, 107, 17);
		getContentPane().add(lblNewLabel_7);
		
		txtNom = new JTextField();
		txtNom.setBounds(190, 131, 320, 19);
		getContentPane().add(txtNom);
		txtNom.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(190, 416, 320, 21);
		getContentPane().add(comboBox);
		
		txtTelf = new JTextField();
		txtTelf.setColumns(10);
		txtTelf.setBounds(190, 272, 320, 19);
		getContentPane().add(txtTelf);
		
		txtDirec = new JTextField();
		txtDirec.setColumns(10);
		txtDirec.setBounds(190, 318, 320, 19);
		getContentPane().add(txtDirec);
		
		txtDni = new JTextField();
		txtDni.setColumns(10);
		txtDni.setBounds(190, 227, 320, 19);
		getContentPane().add(txtDni);
		
		txtApe = new JTextField();
		txtApe.setColumns(10);
		txtApe.setBounds(190, 177, 320, 19);
		getContentPane().add(txtApe);
		
		cboPais = new JComboBox();
		cboPais.addItem("Sleccinar");
		cboPais.addItem("Peru");
		cboPais.addItem("Colombia");
		cboPais.setBounds(190, 368, 320, 21);
		getContentPane().add(cboPais);
		
		JButton btnNewButton = new JButton("REGISTRAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar();
			}
		});
		btnNewButton.setIcon(new ImageIcon(FrmRegistroCliente.class.getResource("/iconos/Add.gif")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 21));
		btnNewButton.setBounds(213, 499, 194, 55);
		getContentPane().add(btnNewButton);

	}
	public void mensaje(String ms) {
		JOptionPane.showMessageDialog(this, ms);
	}
	
	private void Registrar() {
		String dni =txtDni.getText();
		String nom =txtNom.getText();
		String ape =txtApe.getText();
		String telf =txtTelf.getText();
		String direc =txtDirec.getText();
		String pais =cboPais.getSelectedItem().toString();
		
		Cliente cli = new Cliente();
		cli.setDni(dni);
		cli.setNombre(nom);
		cli.setApellido(ape);
		cli.setTelefono(telf);
		cli.setDireccion(direc);
		cli.setPais(pais);
		
		ClienteModel model = new ClienteModel();
		int salida = model.registrarCliente(cli);
		
		if (salida > 0) {
			mensaje("Cliente Registrado con exito");

		} else {
			mensaje("Corriga los datos  ingresados");
		}
		
		
		
	}
	
	
}
