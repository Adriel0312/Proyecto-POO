/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Xml.XML;
import static com.oracle.webservices.internal.api.EnvelopeStyle.Style.XML;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

/**
 *
 * @author gollo33
 */
public class Buscador {
    private String fecha;
    private String capacidad;
    private ArrayList<String> recursos;
    
    public Buscador(){
    this.fecha= fecha;
    this.capacidad= capacidad;
    this.recursos= recursos;
    }

    public boolean BuscarDia(String pfecha) throws ParseException, IOException, JDOMException, ParserConfigurationException, SAXException{
        String fechaIngresada= pfecha;
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");
        try {
            format1.setLenient(false);
            Date dt1=format1.parse(fechaIngresada);
            DateFormat format2=new SimpleDateFormat("EEEE");
            String diaFinal=format2.format(dt1);
            fecha= diaFinal;
   
            XML fechaDeTrabajo = new XML();
            ArrayList<ArrayList<String>> selecc = new ArrayList<ArrayList<String>>();
            selecc= fechaDeTrabajo.mostrarHoras(fecha);
            ArrayList<String> pba;
            pba=selecc.get(0);
        
            if(selecc.isEmpty()){
                return false;
        }
            
            else if("Domingo".equals(pba.get(0))){
                return false;
                
            }
            else{
                fechaDeTrabajo.mostrarHoras(fecha);
                return true;
            }
            
        } 
        catch (Exception e) {
            XML fechaDeTrabajo = new XML();
            ArrayList<ArrayList<String>> selecc = new ArrayList<ArrayList<String>>();
            selecc= fechaDeTrabajo.mostrarHoras(fecha);
            if(selecc.isEmpty()){
                        return false;
            }
            else{
                return false;
            }
            
        }
    }
    public boolean buscarRecurso(ArrayList pRecursos) throws ParseException, IOException, JDOMException{
        XML recursosSala = new XML();
        if (recursosSala.mostrarRecursos(pRecursos).isEmpty()){
            return false;
        }
        else{
            recursosSala.mostrarRecursos(pRecursos);
            return true;
    }
    }
        

    
    
    public boolean BuscarCapacidad(String pCapacidad) throws ParseException, IOException, JDOMException{
        XML recursosSala = new XML();
        if (recursosSala.mostrarCapacidad(pCapacidad).size()==0){
            return false;
        }
        else{
            recursosSala.mostrarCapacidad(pCapacidad);
            return true;
            
        }
    }
    
    public boolean validarFecha(String afechaIngresada){
        String parteNumericaDia= afechaIngresada.substring(0,2);
        int diaBusqueda = Integer.parseInt(parteNumericaDia);
        String parteNumericaMes= afechaIngresada.substring(3,5);
        int mesBusqueda = Integer.parseInt(parteNumericaMes);
        String parteNumericaAño= afechaIngresada.substring(6,10);
        int añoBusqueda = Integer.parseInt(parteNumericaAño);
        Calendar c1 = Calendar.getInstance();
        String diaHoyS;
        String mesHoyS;
        String añoHoys;
        diaHoyS = Integer.toString(c1.get(Calendar.DATE));
        int diaHoy = Integer.parseInt(diaHoyS);
        mesHoyS = Integer.toString(c1.get(Calendar.MONTH));
        int mesHoy = Integer.parseInt(mesHoyS);
        añoHoys = Integer.toString(c1.get(Calendar.YEAR));
        int añoHoy= Integer.parseInt(añoHoys);
        if(añoHoy > añoBusqueda){
            return false;
        }
        else if(añoHoy == añoBusqueda){
            if(mesHoy+1 > mesBusqueda){
                return false;
            }else if(mesHoy+1 == mesBusqueda){
                if(diaHoy > diaBusqueda){
                    return false;
                }else{
                    return true;}
            }else{
                return true;}    
        }else{
            return true;}
    }
    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public ArrayList<String> getRecursos() {
        return recursos;
    }

    public void setRecursos(ArrayList<String> recursos) {
        this.recursos = recursos;
    }
    
    
    
}