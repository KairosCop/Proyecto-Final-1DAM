import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;

public class _7_Mis_Eventos extends JFrame {

	private JPanel panel;
	private JButton btnPregunta, btnHome, btnAbandonar, btnIrAlForo;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblMisEventos;

	private Controlador miControlador;
	private Modelo miModelo;
	private JLabel lblFondo;

	public _7_Mis_Eventos() {
		setTitle("MIS EVENTOS");
		setResizable(false);
		setBounds(140, 50, 850, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		panel = new JPanel();
		panel.setBackground(new Color(255, 235, 205));
		panel.setBounds(0, 0, 1266, 693);
		getContentPane().add(panel);
		panel.setLayout(null);

		lblMisEventos = new JLabel("MIS EVENTOS");
		lblMisEventos.setFont(new Font("Dubai", Font.BOLD, 30));
		lblMisEventos.setBounds(327, 8, 192, 54);
		panel.add(lblMisEventos);

		btnAbandonar = new JButton("ABANDONAR");
		btnAbandonar.setBorder(null);
		btnAbandonar.setEnabled(false);
		btnAbandonar.setBackground(new Color(176, 196, 222));
		btnAbandonar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		btnAbandonar.setFont(new Font("Dubai", Font.BOLD, 15));
		btnAbandonar.setBounds(457, 591, 162, 56);
		panel.add(btnAbandonar);

		btnPregunta = new JButton("");
		btnPregunta.setBorder(null);
		btnPregunta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPregunta.setBackground(new Color(255, 204, 153));
		btnPregunta.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/pregunta-32x32.png")));
		// Hacen que el bot�n sea transparente.
		btnPregunta.setOpaque(false);
		btnPregunta.setContentAreaFilled(false);
		btnPregunta.setBorderPainted(false);
		// Cambia el puntero del rator a pointer cursor.
		btnPregunta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		btnPregunta.setForeground(new Color(0, 0, 0));
		btnPregunta.setBounds(528, 8, 32, 52);
		panel.add(btnPregunta);

		btnHome = new JButton("");
		btnHome.setBorder(null);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(7, 5);
			}
		});
		btnHome.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/home-icon.png")));
		btnHome.setBounds(700, 38, 45, 44);
		panel.add(btnHome);
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		btnHome.setBorderPainted(false);
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Dubai", Font.PLAIN, 15));
		scrollPane.setBounds(106, 93, 640, 476);
		panel.add(scrollPane);

		table = new JTable();
		table.setToolTipText("");
		table.setFocusTraversalKeysEnabled(false);
		table.setIntercellSpacing(new Dimension(0, 0));
		table.setSurrendersFocusOnKeystroke(true);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		table.setShowVerticalLines(false);
		table.setRowHeight(50);
		table.setFont(new Font("Dubai", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Baloncesto", "Enrique Blas", "27/05/2022", "17:00", "Avanzado", "8" },
						{ "Padel", "Galapagar Sports", "20/08/2022", "18:00", "Principiante", "4" },
						{ "F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Medio", "11" },
						{ "Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Avanzado", "2" },
						{ "Padel", "Enrique Blas", "12/09/2022", "19:00", "Principiante", "4" },
						{ "F\u00FAtbol", "La Granadilla", "03/05/2022", "17:00", "Avanzado", "8" },
						{ "F\u00FAtbol", "El Torre\u00F3n", "03/08/2022", "16:00", "Medio", "12" },
						{ "Tenis", "Principe Felipe", "28/08/2022", "17:00", "Avanzado", "4" },
						{ "Baloncesto", "Gal-full Stadium", "10/08/2022", "16:00", "Medio", "12" },
						{ "Baloncesto", "Enrique Blas", "03/05/2022", "19:00", "Medio", "12" },
						{ "Tenis", "El Torre\u00F3n", "10/05/2022", "19:00", "Principiante", null }, },
				new String[] { "Deporte", "Polideportivo", "Fecha", "Hora", "Nivel", "N\u00BA Usuarios" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(59);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(63);
		table.getColumnModel().getColumn(3).setPreferredWidth(37);
		table.getColumnModel().getColumn(4).setPreferredWidth(62);
		table.getColumnModel().getColumn(5).setPreferredWidth(68);
		scrollPane.setViewportView(table);

		btnIrAlForo = new JButton("IR AL FORO");
		btnIrAlForo.setBorder(null);
		btnIrAlForo.setEnabled(false);
		btnIrAlForo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIrAlForo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				miControlador.cambiarPantalla(7, 8);
			}
		});
		btnIrAlForo.setFont(new Font("Dubai", Font.BOLD, 15));
		btnIrAlForo.setBounds(240, 591, 162, 56);
		btnIrAlForo.setBackground(new Color(176, 196, 222));
		panel.add(btnIrAlForo);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(_7_Mis_Eventos.class.getResource("/images/fondo_pelotas_5 (1).png")));
		lblFondo.setBounds(-93, 0, 939, 683);
		panel.add(lblFondo);
	}
	
	public void setMiControlador(Controlador miControlador) {
		this.miControlador = miControlador;
	}

	public void setMiModelo(Modelo miModelo) {
		this.miModelo = miModelo;
	}
}
