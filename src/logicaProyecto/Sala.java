/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import Xml.XML;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.sql.JDBCType.NULL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class Sala {
    private String codigo;
    private String ubicacion;
    private int capacidad;
    private ArrayList<String>recursos ;
    private String estado="Inactiva";
    private  ArrayList<ArrayList<String>> horario = new ArrayList<ArrayList<String>>();
    private int calificacion = 100;
    


    public Sala (String nombre, String capcidad, String campos, String imagen, String correo, String telefono1, String telefono2, String distrito, String provincia, String canton, String barrio, String contrasenna) throws IOException, JDOMException{
    }


    
    public void calificarSala(int calificacion){
        
    }
    
    public String getEstado() {
        return estado;
    }
    
    public void setEstado(String pEstado) {
        this.estado = pEstado;
    }
    
    public ArrayList <String> guardar(ArrayList <String> lista ){
    recursos=lista;
    return lista;
    }

    public ArrayList<String> getRecursos() {
        return recursos;
    }
    
    public String recursosStr(){
        String listString = "";
        for (String s : getRecursos())
        {
        listString += s + "\t";
        }
        return listString;
    }
    
    public void consultarSala(String pCodigo) throws ParseException, IOException, JDOMException{
        XML salaPorVer = new XML();
        salaPorVer.printearInfoSala(pCodigo,0);
    }
    
    public ArrayList <String> seleccionHorario(){
        return null;
    }

    
    public void setCodigo() throws IOException, JDOMException{
        XML consecutivo = new XML();
        String codigoSala= consecutivo.consecutivoSala("SAL-001",0);
        this.codigo = codigoSala;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setUbicacion(String pUbicacion) {
        this.ubicacion = pUbicacion;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    public void setCapacidad(int pCapacidad) {
        this.capacidad = pCapacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }
    
    public String capacidadStr(){
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(getCapacidad());
        String strI = sb.toString();
        return strI;
    }

    public void setRecursos(ArrayList<String> pRecursos) {
        this.recursos = pRecursos;
    }

   
    public ArrayList<String> seleccionHorarios(String pDia) throws JDOMException, IOException {
       XML leer = new XML();
       if (pDia=="Lunes"){
           int dia=0;
           return leer.seleccionHorario(dia);
       }
       else if(pDia=="Martes"){
           int dia=1;
           return leer.seleccionHorario(dia);
       }
       else if(pDia=="Miercoles"){
           int dia=2;
           return leer.seleccionHorario(dia);
       }
       else if(pDia=="Jueves"){
           int dia=3;
           return leer.seleccionHorario(dia);
       }
       else if(pDia=="Viernes"){
           int dia=4;
           return leer.seleccionHorario(dia);
       }
       else {
           int dia=5;
           return leer.seleccionHorario(dia);
       }
       
    }
    
    
    public ArrayList<ArrayList<String>> getHorario() {
        return horario;
    }

    public boolean setHorario(ArrayList<String> lista) throws JDOMException, IOException {
        if (!horario.contains(lista)){
            horario.add(lista);
            return true;
                    }
        else{
            return false;
        }
    }
    
    public ArrayList<String> consultarHorario(String pDia)throws JDOMException, IOException{
        return seleccionHorarios(pDia);
    }
    
    public int getCalificacion() {
        return calificacion;
    }
    
    public String calificacionStr(){
        StringBuilder string = new StringBuilder();
        string.append("");
        string.append(getCalificacion());
        String calf = string.toString();
        return calf;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

public void agregarSala(Sala nuevaSala) throws ParserConfigurationException, SAXException, IOException, FileNotFoundException, TransformerException, JDOMException{
    XML salaNueva = new XML();        
    //System.out.println(salaNueva);
    salaNueva.escribirSala(nuevaSala.getCodigo(),nuevaSala.getUbicacion(),nuevaSala.capacidadStr(),
    modificarArraySimple(nuevaSala.getRecursos()),nuevaSala.getEstado(),nuevaSala.calificacionStr(),modificarArrayDoble(nuevaSala.getHorario()));//(String) nuevaSala.getHorario().toString()
    }
private ArrayList<ArrayList<String>> modificarArrayDoble(ArrayList<ArrayList<String>> lista){
    System.out.println("lista querida"+ lista);
    return lista;
}
private String modificarArraySimple(ArrayList<String> lista){
    String str="";
    for(int i=0; i<lista.size(); i++){
        str+=(String) lista.get(i);
        str+="-";
        
        System.out.println(lista);
    }
    return str;
}
}
