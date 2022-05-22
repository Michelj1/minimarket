package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class FrmBoletaVenta extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBoletaVenta frame = new FrmBoletaVenta();
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
	public FrmBoletaVenta() {
		setTitle("Boleta de Venta\r\n");
		setIconifiable(true);
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}
