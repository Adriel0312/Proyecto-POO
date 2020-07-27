package logicaProyecto;

import Xml.XML;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import jdk.internal.util.xml.impl.Input;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class Estudiante {
    private String nombre;
    private String carnet;
    private String carrera;
    private String correoElectronico;
    private String calificacion;
    private String numeroCelular;

    
    public Estudiante(String numerocel, String nombre, String carnet,String carrera,String correoElectronico,String numeroCelular){
        this.nombre = nombre;
        this.carnet = carnet;
        this.carrera = carrera;
        this.correoElectronico = correoElectronico;
        this.calificacion = "100";
        this.numeroCelular = numerocel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCarnet() {
        return carnet;
    }

    public String getCarrera() {
        return carrera;
    }
   
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String puntosPerdidos) {
        int nota=Integer.parseInt(calificacion)  - Integer.parseInt(puntosPerdidos);
        this.calificacion =String.valueOf(nota);
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    
    public boolean agregarEstudiante(Estudiante nuevoEstudiante) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, TransformerException, JDOMException{
        XML estudianteNuevo = new XML();
        return estudianteNuevo.ingresaEstudiante(nuevoEstudiante.getNumeroCelular(),nuevoEstudiante.getNombre(),nuevoEstudiante.getCarnet(),nuevoEstudiante.getCarrera(),
        nuevoEstudiante.getCorreoElectronico(),nuevoEstudiante.getCalificacion());
    }
    
    public void verHistorialEstudiante(Estudiante estudiante)throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, TransformerException, JDOMException{
    XML infoEstudiante = new XML();
    
    infoEstudiante.printearInfoEstudiante(estudiante.getCarnet(),1);
    }
}