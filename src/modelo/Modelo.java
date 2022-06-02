package modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.table.DefaultTableModel;

import vistas._1_Bienvenido_a_SportsChoice;
import vistas._10_Configuracion;
import vistas._2_Bienvenido_admin;
import vistas._2_Registrarse;
import vistas._3_Recuperar_Contrasena;
import vistas._4_Nueva_Contrasena;
import vistas._5_Hola_Nombre;
import vistas._6_Tu_perfil;
import vistas._7_Mis_Eventos;
import vistas._8_Foro;
import vistas._91_Crear_Evento;
import vistas._9_Eventos_Disponibles;

public class Modelo {

	private _1_Bienvenido_a_SportsChoice bienvenida;
	private _10_Configuracion configuracion;
	private _2_Bienvenido_admin bienvenidaAdmin;
	private _2_Registrarse registrarse;
	private _3_Recuperar_Contrasena recuperarContrasena;
	private _4_Nueva_Contrasena nuevaContrasena;
	private _5_Hola_Nombre holaNombre;
	private _6_Tu_perfil tuPerfil;
	private _7_Mis_Eventos misEventos;
	private _8_Foro foro;
	private _9_Eventos_Disponibles eventosDisponibles;
	private _91_Crear_Evento crearEvento;

	private String resultado;
	private int fallos;

	// Atributos de la clase
	private String bd; // bd = "proyectoIntegrador"
	private String username; // login = "root"
	private String pwd; // pwd = ""
	private String url; // url = url = "jdbc:mysql://localhost/" + bd;
	private Connection conexion;

	private String usr;
	private String pwdusr;
	private String rol;
	private String estado;

	private Properties config;
	private File miFichero;
	private InputStream entrada;
	private OutputStream salida;
	private String respuesta;
	private final String FILE = "config.ini";

	private DefaultTableModel table;
	private String sqlTablaAdmin = "Select usr, nombre, apellidos, email, estado from users";

	public Modelo() {
		config = new Properties();
		try {
			miFichero = new File(FILE);
			if (miFichero.exists()) {
				entrada = new FileInputStream(miFichero);
				config.load(entrada);
			} else {
				System.err.println("Fichero no encontrado");
				System.exit(1);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	// Constructor que crea la conexion
	public void Conexion() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion = DriverManager.getConnection(config.getProperty("url"), config.getProperty("username"), config.getProperty("pwd"));
			System.out.println(" - Conexion con MySQL establecida -\n");
		} catch (ClassNotFoundException e) {
			System.out.println(" -> Driver JDBC no encontrado \n");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(" -> Error de Conexión a la BD \n");
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(" -> Error general de conexión \n");
			e.printStackTrace();
		}
		tablaAdmin();
	}

	public void setBienvenida(_1_Bienvenido_a_SportsChoice bienvenida) {
		this.bienvenida = bienvenida;
	}

	public void setConfiguracion(_10_Configuracion configuracion) {
		this.configuracion = configuracion;
	}

	public void setBienvenidaAdmin(_2_Bienvenido_admin bienvenidaAdmin) {
		this.bienvenidaAdmin = bienvenidaAdmin;
	}

	public void setRegistrarse(_2_Registrarse registrarse) {
		this.registrarse = registrarse;
	}

	public void setRecuperarContrasena(_3_Recuperar_Contrasena recuperarContrasena) {
		this.recuperarContrasena = recuperarContrasena;
	}

	public void setNuevaContrasena(_4_Nueva_Contrasena nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}

	public void setHolaNombre(_5_Hola_Nombre holaNombre) {
		this.holaNombre = holaNombre;
	}

	public void setTuPerfil(_6_Tu_perfil tuPerfil) {
		this.tuPerfil = tuPerfil;
	}

	public void setMisEventos(_7_Mis_Eventos misEventos) {
		this.misEventos = misEventos;
	}

	public void setForo(_8_Foro foro) {
		this.foro = foro;
	}

	public void setEventosDisponibles(_9_Eventos_Disponibles eventosDisponibles) {
		this.eventosDisponibles = eventosDisponibles;
	}

	public void setCrearEvento(_91_Crear_Evento crearEvento) {
		this.crearEvento = crearEvento;
	}

	public String getResultado() {
		return this.resultado;
	}

	public String getRol() {
		return rol;
	}

	public String getEstado() {
		return estado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	private String LoginSQL(String query, String usr, String nombreColumna) {
		String aux = "";
		try {
			PreparedStatement pstmt = conexion.prepareStatement(query);
			pstmt.setString(1, usr);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				aux = rset.getString(nombreColumna);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		return aux;
	}

	public void login(String usr, String pwd) {
		Conexion();
		this.usr = LoginSQL("SELECT usr FROM users WHERE usr=?", usr, "usr");
		this.pwdusr = LoginSQL("SELECT pwd FROM users WHERE usr=?", usr, "pwd");
		this.rol = LoginSQL("SELECT rol FROM users WHERE usr=?", usr, "rol");
		this.estado = LoginSQL("SELECT estado FROM users WHERE usr=?", usr, "estado");

		if (this.estado.equals("inactivo")) {
			fallos++;
			if (fallos == 3) {
				resultado = "Cerrar";
				bienvenida.actualizar();
			} else {
				bienvenida.inactivoError();
			}
		} else {
			if (this.usr.equals(usr) && this.pwdusr.equals(pwd)) {
				resultado = "Correcto";
				fallos = 0;
				bienvenida.actualizar();
			} else {
				fallos++;
				if (fallos == 3) {
					resultado = "Cerrar";
					bienvenida.actualizar();
				} else {
					resultado = "Incorrecto";
					bienvenida.actualizar();
				}
			}
		}
	}

	private void tablaAdmin() {
		table = new DefaultTableModel();
		int numColumnas = getNumColumnas(sqlTablaAdmin);
		Object[] contenido = new Object[numColumnas];
		PreparedStatement pstmt;
		try {
			pstmt = conexion.prepareStatement(sqlTablaAdmin);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			for (int i = 0; i < numColumnas; i++) {
				table.addColumn(rsmd.getColumnName(i + 1));
			}
			while (rset.next()) {
				for (int col = 1; col <= numColumnas; col++) {
					contenido[col - 1] = rset.getString(col);
				}
				table.addRow(contenido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private int getNumColumnas(String sql) {
		int num = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			ResultSetMetaData rsmd = rset.getMetaData();
			num = rsmd.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	private int getNumFilas(String sql) {
		int numFilas = 0;
		try {
			PreparedStatement pstmt = conexion.prepareStatement(sql);
			ResultSet rset = pstmt.executeQuery();
			while (rset.next())
				numFilas++;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return numFilas;
	}

	public DefaultTableModel getTabla() {
		return table;
	}

	public void guardar(String key, String valor) {
		try {
			config.setProperty(url, valor);
			config.setProperty(username, valor);
			config.setProperty(pwd, valor);
			salida = new FileOutputStream(miFichero);
			config.store(salida, "Ultima operacion: Guardado");
			respuesta = "Guardado";
		} catch (IOException e) {
			e.printStackTrace();
		}
		configuracion.actualizar();
	}

	public void borrar(String key) {
		if (!config.containsKey(key)) {
			respuesta = "No Encontrado";
		} else {
			config.remove(key);
			try {
				salida = new FileOutputStream(miFichero);
				config.store(salida, "Ultima operacion: Borrado");
				respuesta = "Borrado";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		configuracion.actualizar();
	}

	public void comprobar(String key) {
		String valor = config.getProperty(key);
		if (valor == null) {
			respuesta = "No Encontrado";
		} else {
			respuesta = valor;
		}
		configuracion.actualizar();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}