import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class _4_Nueva_Contrase�a {

	private JFrame frame;
	private JPanel panel;
	private JLabel lblRecuperarContrase�a;
	private JTextField txtNuevaContrase�a;
	private JLabel lblNuevaContrasea;
	private JTextField txtRepetirContrase�a;
	private JLabel lblRepetirContrasea;
	private JLabel lblConsejoTitulo;
	private JLabel lblConsejo1;
	private JLabel lblYMinsculasNmeros;
	private JLabel lblParaHacerlaMs;
	private JButton btnFlecha;

	/**
	 * Launch the application.
	 */
	public static void Nueva() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					_4_Nueva_Contrase�a window = new _4_Nueva_Contrase�a();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public _4_Nueva_Contrase�a() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(140, 50, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblRecuperarContrase�a = new JLabel("NUEVA CONTRASE\u00D1A");
		lblRecuperarContrase�a.setFont(new Font("Dubai", Font.BOLD, 30));
		lblRecuperarContrase�a.setBounds(479, 17, 308, 60);
		panel.add(lblRecuperarContrase�a);
		
		JButton btnValidar = new JButton("ACTUALIZAR");
		btnValidar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnValidar.setBackground(new Color(176, 196, 222));
		btnValidar.setBounds(779, 589, 162, 56);
		btnValidar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnValidar);
		
		txtNuevaContrase�a = new JTextField();
		txtNuevaContrase�a.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtNuevaContrase�a.setColumns(10);
		txtNuevaContrase�a.setBounds(468, 145, 336, 40);
		panel.add(txtNuevaContrase�a);
		
		lblNuevaContrasea = new JLabel("Nueva contrase\u00F1a:");
		lblNuevaContrasea.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblNuevaContrasea.setBounds(336, 144, 122, 44);
		panel.add(lblNuevaContrasea);
		
		txtRepetirContrase�a = new JTextField();
		txtRepetirContrase�a.setFont(new Font("Dubai", Font.PLAIN, 16));
		txtRepetirContrase�a.setColumns(10);
		txtRepetirContrase�a.setBounds(468, 232, 336, 40);
		panel.add(txtRepetirContrase�a);
		
		lblRepetirContrasea = new JLabel("Repetir contrase\u00F1a:");
		lblRepetirContrasea.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 15));
		lblRepetirContrasea.setBounds(336, 231, 128, 44);
		panel.add(lblRepetirContrasea);
		
		lblConsejoTitulo = new JLabel("Consejo:");
		lblConsejoTitulo.setFont(new Font("Dubai", Font.BOLD, 15));
		lblConsejoTitulo.setBounds(401, 319, 67, 44);
		panel.add(lblConsejoTitulo);
		
		lblConsejo1 = new JLabel("La contrase\u00F1a debe contener al menos 6 caracteres.");
		lblConsejo1.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblConsejo1.setBounds(468, 331, 432, 21);
		panel.add(lblConsejo1);
		
		lblYMinsculasNmeros = new JLabel("y min\u00FAsculas, n\u00FAmeros y s\u00EDmbolos como ! \" ? $ %. ");
		lblYMinsculasNmeros.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblYMinsculasNmeros.setBounds(468, 376, 432, 21);
		panel.add(lblYMinsculasNmeros);
		
		lblParaHacerlaMs = new JLabel("Para hacerla m\u00E1s fuerte se recomienda utilizar may\u00FAsculas");
		lblParaHacerlaMs.setFont(new Font("Dubai", Font.PLAIN, 15));
		lblParaHacerlaMs.setBounds(462, 354, 465, 21);
		panel.add(lblParaHacerlaMs);
		
		btnFlecha = new JButton("");
		btnFlecha.setIcon(new ImageIcon(_4_Nueva_Contrase�a.class.getResource("/images/back-arrow-icon-10.png")));
		btnFlecha.setOpaque(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setBounds(308, 589, 106, 56);
		panel.add(btnFlecha);
	}
}
