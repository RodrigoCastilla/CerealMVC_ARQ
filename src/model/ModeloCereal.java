package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ModeloCereal {
    
    private final String ARCHIVO_CEREALES = "cereales.txt";
    private final int NUMERO_CORRECTO_CEREALES = 3;
    private final String NOMBRE_CLASE = "ModeloCereal";
    private Bitacora bitacora;
    private int votosCerealA;
    private int votosCerealB;
    private int votosCerealC;
    private String cerealA;
    private String cerealB;
    private String cerealC;
    
    public ModeloCereal() {
        
        bitacora = new Bitacora();
        bitacora.guardarRegistro("ModeloCereal()", NOMBRE_CLASE);
        leerCereales(ARCHIVO_CEREALES);
        votosCerealA = leerVotos(cerealA + ".txt");
        votosCerealB = leerVotos(cerealB + ".txt");
        votosCerealC = leerVotos(cerealC + ".txt");
        
    }
    
    public void votoCerealA() {
        bitacora.guardarRegistro("votoCerealA()", NOMBRE_CLASE);
        votosCerealA++;
        guardaVoto(cerealA + ".txt");
    }
    
    public void votoCerealB() {
        bitacora.guardarRegistro("votoCerealB()", NOMBRE_CLASE);
        votosCerealB++;
        guardaVoto(cerealB + ".txt");
    }
    
    public void votoCerealC() {
        bitacora.guardarRegistro("votoCerealC()", NOMBRE_CLASE);
        votosCerealC++;
        guardaVoto(cerealC + ".txt");
    }

    public int getVotosCerealA() {
        bitacora.guardarRegistro("getVotosCerealA()", NOMBRE_CLASE);
        return votosCerealA;
    }

    public int getVotosCerealB() {
        bitacora.guardarRegistro("getVotosCerealB()", NOMBRE_CLASE);
        return votosCerealB;
    }

    public int getVotosCerealC() {
        bitacora.guardarRegistro("getVotosCerealC()", NOMBRE_CLASE);
        return votosCerealC;
    }

    public String getCerealA() {
        bitacora.guardarRegistro("getCerealA()", NOMBRE_CLASE);
        return cerealA;
    }

    public String getCerealB() {
        bitacora.guardarRegistro("getCerealB()", NOMBRE_CLASE);
        return cerealB;
    }

    public String getCerealC() {
        bitacora.guardarRegistro("getCerealC()", NOMBRE_CLASE);
        return cerealC;
    }
    
    private void guardaVoto(String archivo) {
        
        bitacora.guardarRegistro("guardaVoto(String archivo)", NOMBRE_CLASE);
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();    
        DateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date fechaHoraActual = new Date();
        String lineaTexto = formatoFecha.format(fechaHoraActual) + "\n";
        
        manejadorArchivo.escribirArchivo(archivo, lineaTexto);
        
    }
    
    private int leerVotos(String archivo) {
        
        bitacora.guardarRegistro("leerVotos(String archivo)", NOMBRE_CLASE);
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos(); 
        
        return manejadorArchivo.leerVotos(archivo);
        
    }
    
    private void leerCereales(String archivo) {
        
        bitacora.guardarRegistro("leerCereales(String archivo)", NOMBRE_CLASE);
        
        ManejadorArchivos manejadorArchivo = new ManejadorArchivos();
        ArrayList<String> cereales = new ArrayList<String>();
        
        cereales = manejadorArchivo.leerCereales(archivo);
        
        if (cereales.size() == NUMERO_CORRECTO_CEREALES) {
            
            cerealA = cereales.get(0);
            cerealB = cereales.get(1);
            cerealC = cereales.get(2);
            
        } else {
            
            System.out.println("Error en el número de cereales en el archivo " + 
                    ARCHIVO_CEREALES);
            System.exit(0);
                        
        }        
        
    }
    
}
