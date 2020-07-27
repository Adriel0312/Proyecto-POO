package Xml;

import Clases.Sala;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Anderson
 */
public class XML {
    private Document documento;//CREA UNA VARIABLE TIPO DOCUMENTO 
    private Element valores= null;//crea una variable de tipo elemnto 
    private String concatenar;
    
    public void escribirEstudiante(String numeroCel, String nombre, String carnet, String carrera, String correo, String calificacion) throws ParserConfigurationException, IOException, FileNotFoundException, TransformerException, SAXException{
        
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documento = builder.parse("src/aplicacion/archivos/estudiantesDB.xml");
        documento.getDocumentElement().normalize();
        valores = documento.getDocumentElement();
       
        Element estudiante = documento.createElement("estudiantesDB");
        valores.appendChild(estudiante);
        
        Element NumCel = documento.createElement("Celular"); // es un hijo de estudiante
        NumCel.appendChild(documento.createTextNode(numeroCel));//hijo del elemento nombre y es de tipo nodo texto
        estudiante.appendChild(NumCel);//crea al nodo nombre como hijo de estudiante
        
        
        Element Nombre = documento.createElement("Nombre"); // es un hijo de estudiante
        Nombre.appendChild(documento.createTextNode(nombre));//hijo del elemento nombre y es de tipo nodo texto
        estudiante.appendChild(Nombre);//crea al nodo nombre como hijo de estudiante
        
        Element Carnet = documento.createElement("Carnet"); // es un hijo de estudiante
        Carnet.appendChild(documento.createTextNode(carnet));//hijo del elemento carnet y es de tipo nodo texto
        estudiante.appendChild(Carnet);//crea al nodo nombre como hijo de estudiante
        
        Element Carrera = documento.createElement("Carrera"); // es un hijo de estudiante
        Carrera.appendChild(documento.createTextNode(carrera));//hijo del elemento carrera y es de tipo nodo texto
        estudiante.appendChild(Carrera);//crea al nodo nombre como hijo de estudiante
        
        Element Correo = documento.createElement("Correo"); // es un hijo de estudiante
        Correo.appendChild(documento.createTextNode(correo));//hijo del elemento correo y es de tipo nodo texto
        estudiante.appendChild(Correo);//crea al nodo nombre como hijo de estudiante
        
        Element Calificacion = documento.createElement("Calificacion"); // es un hijo de estudiante
        Calificacion.appendChild(documento.createTextNode(calificacion));//hijo del elemento calificacion y es de tipo nodo texto
        estudiante.appendChild(Calificacion);//crea al nodo nombre como hijo de estudiante
        generarXML("src/aplicacion/archivos/estudiantesDB.xml");
    }
  
    public String printearInfoEstudiante(String dato,int num)throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/estudiantesDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String infoEstudiante = null;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==1){ide = campo.getChildTextTrim("Carnet");}
            if (ide==null){}
            else {datos.add(ide);}
        }
        for (int i=0 ; i<datos.size();i++){
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                org.jdom2.Element estudianteIngresado;
                estudianteIngresado = (org.jdom2.Element)list.get(i);
                String nombre = estudianteIngresado.getChildTextTrim("Nombre");
                String carnet = estudianteIngresado.getChildTextTrim("Carnet");
                String carrera = estudianteIngresado.getChildTextTrim("Carrera");
                String correo = estudianteIngresado.getChildTextTrim("Correo");
                String calificacion = estudianteIngresado.getChildTextTrim("Calificacion");
                
                infoEstudiante = nombre + "\n\n" + carnet +"\n\n"+ carrera +"\n\n"+
                        correo + "\n\n"+ calificacion+ "\n\n";
                
                //System.out.println(infoEstudiante);
            }
        }
        System.out.println(infoEstudiante);
        return infoEstudiante;
    }
    public ArrayList<ArrayList<String>> printearInfoReservas(String dato,int num)throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/reservasDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        String infoReserva = null;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==1){ide = campo.getChildTextTrim("CarnetOrganizador");}
            if (ide==null){}
            else {datos.add(ide);}
        }
        for (int i=0 ; i<datos.size();i++){
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                ArrayList<String> temporal = new ArrayList<String>();
                org.jdom2.Element reservaAMostrar;
                reservaAMostrar = (org.jdom2.Element)list.get(i);
                String ideReserva = reservaAMostrar.getChildTextTrim("IdeReserva");
                String fechaReserva = reservaAMostrar.getChildTextTrim("FechaDeReserva");
                String horaReserva = reservaAMostrar.getChildTextTrim("HoraDeLaReserva");
                String asunto = reservaAMostrar.getChildTextTrim("Asunto");
                String carnetOrganizador = reservaAMostrar.getChildTextTrim("CarnetOrganizador");
                String codigoCalificaion = reservaAMostrar.getChildTextTrim("CodigoCalificacion");
                String codigoSala = reservaAMostrar.getChildTextTrim("CodigoSala");
                String estado = reservaAMostrar.getChildTextTrim("Estado");
                String participantes = reservaAMostrar.getChildTextTrim("Participantes");
                ArrayList<String> arrayParticipantes = strToArray(participantes,"-");
                
                temporal.add(ideReserva);
                temporal.add(fechaReserva);
                temporal.add(horaReserva);
                temporal.add(asunto);
                temporal.add(carnetOrganizador);
                temporal.add(codigoCalificaion);
                temporal.add(codigoSala);
                temporal.add(estado);
                /*= ideReserva + "\n\n" + fechaReserva +"\n\n"+ horaReserva +"\n\n"+
                        asunto + "\n\n"+ carnetOrganizador +"\n\n"+ codigoCalificaion +"\n\n"+ 
                        codigoSala +"\n\n"+ estado +"\n\n";*/
                
                for(i=0; i<arrayParticipantes.size();i++){
                    String participanteString;
                    participanteString = arrayParticipantes.get(i);
                
                    temporal.add(participanteString);
                }
                res.add(temporal);
                
                //System.out.println(infoEstudiante);
            }else{}
        }System.out.println(res+"ESTE ES");return res;
    }
    
    public List verInfoXML(String nombre) throws IOException, JDOMException{
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File(nombre);//Abre el archivo xml estudiantesDB.xml
        List list = null;//Asigna una lista en NULL
        try {
            org.jdom2.Document document = (org.jdom2.Document) builder.build( xmlFile );
            org.jdom2.Element raiz = document.getRootElement();//Obtiene el elemento Raiz
            list = raiz.getChildren();//Obtiene los hijos de ese elemento raiz
            
            return list;//Retorna la lista
            
        } catch (JDOMException e) {
            
        }return list;
    }
   
    public boolean ingresaEstudiante(String cel , String nombre, String carnet, String carrera, String correo, String calificacion) throws IOException, FileNotFoundException, TransformerException, SAXException, ParserConfigurationException, JDOMException{
        boolean valida1;
        valida1=validaCarnet(carnet,1);
        if (valida1==true){
            System.out.println("Error Existe un estudiante con este carnet");
            return false;}
        else{
            escribirEstudiante(cel,nombre, carnet, carrera, correo, calificacion);
            return true;
        }
    }
        
    public boolean validaCarnet(String dato, int num) throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/estudiantesDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==1){ide = campo.getChildTextTrim("Carnet");}
            if (ide==null){}
            else {datos.add(ide);}
        }
        for (int i=0 ; i<datos.size();i++){
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    
   
    
    /**
     * Se encarga de retornar todos los valores de todas las salas registradas y guardadas en el xml salas.xml
     * @return Una matriz de listas que contienen los datos de cada sala
     * @throws IOException
     * @throws JDOMException 
     */
    public ArrayList<ArrayList<String>> retSalas() throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        ArrayList<ArrayList<String>> datosGen = new ArrayList<ArrayList<String>>(); 
        org.jdom2.Element campo;
        int num =0;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            ArrayList<String> datosSala = new ArrayList<>();
            campo = (org.jdom2.Element)list.get(j);
            datosSala.add(campo.getChildTextTrim("Codigo"));
            datosSala.add(campo.getChildTextTrim("Ubicacion"));
            datosSala.add(campo.getChildTextTrim("Capacidad"));
            datosSala.add(campo.getChildTextTrim("Recursos"));
            datosSala.add(campo.getChildTextTrim("Estado"));
            datosSala.add(campo.getChildTextTrim("Calificacion"));
            datosSala.add(campo.getChildTextTrim("Horario"));
            datosGen.add(datosSala);
        }
        return  datosGen;
    }
    
    public ArrayList<String> seleccionHorario(int Dia) throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/horariosDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String dia=null;
        String hora1=null;
        String hora2=null;
        Sala pba = new Sala("",0);   
        
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (j==Dia){dia = campo.getChildTextTrim("Dia");
                   hora1=campo.getChildTextTrim("HoraInicio");
                   hora2=campo.getChildText("HoraFinal");
                   datos.add(dia);
                   datos.add(hora1);
                   datos.add(hora2);
                   //System.out.println("Datos guardados");
                   //return datos;
               //}
               //else if(input.equals("B")){
                   //System.out.println(input);
                   hora1=campo.getChildTextTrim("HoraInicio2");
                   hora2=campo.getChildText("HoraFinal2");
                   datos.add(dia);
                   datos.add(hora1);
                   datos.add(hora2);
                   //System.out.println("Datos guardados");
                   //return datos;
               //}
               //else{
                 //  System.out.println("No ingreso la letra correcta");
                   
               //}
            }
        }
        return datos;
    }
    
    
   
    
    
    
    public void escribirSala(String codigo, String ubicacion, String capacidad, String recursos, String estado, String calificacion, ArrayList<ArrayList<String>> horario) throws ParserConfigurationException, IOException, FileNotFoundException, TransformerException, SAXException{
 
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documento = builder.parse("src/aplicacion/archivos/salasDB.xml");
        documento.getDocumentElement().normalize();
        valores = documento.getDocumentElement();
        
        Element salas = documento.createElement("salasDB");
        valores.appendChild(salas);
        
        Element Codigo = documento.createElement("Codigo"); // es un hijo de estudiante
        Codigo.appendChild(documento.createTextNode(codigo));//hijo del elemento nombre y es de tipo nodo texto
        salas.appendChild(Codigo);//crea al nodo nombre como hijo de estudiante
        
        Element Ubicacion = documento.createElement("Ubicacion"); // es un hijo de estudiante
        Ubicacion.appendChild(documento.createTextNode(ubicacion));//hijo del elemento carnet y es de tipo nodo texto
        salas.appendChild(Ubicacion);//crea al nodo nombre como hijo de estudiante
        
        Element Capacidad = documento.createElement("Capacidad"); // es un hijo de estudiante
        Capacidad.appendChild(documento.createTextNode(capacidad));//hijo del elemento carrera y es de tipo nodo texto
        salas.appendChild(Capacidad);//crea al nodo nombre como hijo de estudiante
        
        Element Recursos = documento.createElement("Recursos"); // es un hijo de estudiante
        Recursos.appendChild(documento.createTextNode(recursos));//hijo del elemento correo y es de tipo nodo texto
        salas.appendChild(Recursos);//crea al nodo nombre como hijo de estudiante
        
        Element Estado = documento.createElement("Estado"); // es un hijo de estudiante
        Estado.appendChild(documento.createTextNode(estado));//hijo del elemento calificacion y es de tipo nodo texto
        salas.appendChild(Estado);//crea al nodo nombre como hijo de estudiante
        
        Element Calificacion = documento.createElement("Calificacion"); // es un hijo de estudiante
        Calificacion.appendChild(documento.createTextNode(calificacion));//hijo del elemento calificacion y es de tipo nodo texto
        salas.appendChild(Calificacion);//crea al nodo nombre como hijo de estudiante
        
        ArrayList<String> etiquetasHorario = new ArrayList<>();
        etiquetasHorario.add("Dia");
        etiquetasHorario.add("HoraInicio");
        etiquetasHorario.add("HoraFinal");
        
        for ( int j = 0; j < horario.size(); j++ ){
            for ( int i = 0; i < horario.get(j).size(); i++ ){
                ArrayList<String> sublista = horario.get(j);
                System.out.println(sublista.get(i));
                String posAIngresar;
                posAIngresar = sublista.get(i);
                    Element Horario = documento.createElement(etiquetasHorario.get(i)+j); // es un hijo de estudiante
                    Horario.appendChild(documento.createTextNode(posAIngresar));//hijo del elemento calificacion y es de tipo nodo texto
                    salas.appendChild(Horario);//crea al nodo nombre como hijo de estudiante
                }
            }
        generarXML("src/aplicacion/archivos/salasDB.xml");
    }
    
    /**
     * Se encarga de sobre escribir los datos de ubicaion, recursos y estado de una sala en particular
     * @param codigo Identificador de la sala
     * @param ubicacion Valor a ingresar en ubicacion
     * @param recursos Valor a ingresar en recursos
     * @param estado Valor a ingresar en estado
     * @throws SAXException
     * @throws IOException
     * @throws JDOMException
     * @throws ParserConfigurationException
     * @throws XPathExpressionException
     * @throws TransformerConfigurationException 
     */
    public void sobreEscribirSala(String codigo, String ubicacion, String recursos, String estado) throws SAXException, IOException, JDOMException, ParserConfigurationException, XPathExpressionException, TransformerConfigurationException{
        //Saca toda la info del XML de salas(Funcion de Angelo)
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        org.jdom2.Element campo;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            //Obtiene el codigo de la sal que se encuentra en "Campo"
            ide = campo.getChildTextTrim("Codigo");
            //Compara que sea el mismo que el que quiero modificar
            System.err.println("iguales? :"+ide+"=="+codigo+" = "+ide.equals(codigo));
            if (ide.equals(codigo)){
                try {
                    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource("src/aplicacion/archivos/salasDB.xml"));
                    XPath xpath = XPathFactory.newInstance().newXPath();
                    //Asigna a ub(ubicaion) un NodeList(no se que es), pero como que envia el nodo o algo asi para poder
                    //modificarlo
                    //Hace lo mismo con es(estado) y rec(recursos)
                    NodeList ub = (NodeList)xpath.evaluate
                                ("//salasDB/"+"Ubicacion"+"[text()="+"'"+campo.getChildTextTrim("Ubicacion")+"']", doc, XPathConstants.NODESET);
                                //System.out.println(ub.item(1));
                    NodeList es = (NodeList)xpath.evaluate
                                ("//salasDB/"+"Estado"+"[text()="+"'"+campo.getChildTextTrim("Estado")+"']", doc, XPathConstants.NODESET);
                    NodeList rec = (NodeList)xpath.evaluate
                                ("//salasDB/"+"Recursos"+"[text()="+"'"+campo.getChildTextTrim("Recursos")+"']", doc, XPathConstants.NODESET);
                    //Esto se encarga de iterar sobre el nodo(para que no se pero funciona)
                    for (int idx = 0; idx < ub.getLength(); idx++) {
                        //Aqui le asigna ya el valor que yo haya ingresado
                        System.out.println(ub.item(idx));
                        ub.item(idx).setTextContent(ubicacion);}
                    for (int idx1 = 0; idx1 < es.getLength(); idx1++) {
                        //Aqui le asigna ya el valor que yo haya ingresado
                        es.item(idx1).setTextContent(estado);}
                    for (int idx2 = 0; idx2 < rec.getLength(); idx2++) {
                        //Aqui le asigna ya el valor que yo haya ingresado
                        rec.item(idx2).setTextContent(recursos);}
                    //Este bloque se encarga de sobre escribir el archivo con los cambios realizados
                    Transformer xformer = TransformerFactory.newInstance().newTransformer();
                    xformer.transform(new DOMSource(doc), new StreamResult(new File("src/aplicacion/archivos/salasDB.xml")));
                    //
                } catch (TransformerException ex) {
                    Logger.getLogger(XML.class.getName()).log(Level.SEVERE, null, ex);
                }
                }else{}
            }
    }

    public String consecutivoSala(String dato,int num)throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==0){
                ide = campo.getChildTextTrim("Codigo");
            }
            if (ide==null){}
            else {
                datos.add(ide);
            }
        }
        for (int i=0 ; i<datos.size();i++){
            //System.out.println(datos.get(i));
            //System.out.println(dato);
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                org.jdom2.Element codigoIngresado;
                codigoIngresado = (org.jdom2.Element)list.get(i);
                int largo;
                largo = dato.length();
                String parteNumerica= dato.substring(5,largo);
                int convertida=Integer.parseInt(parteNumerica);
                convertida+=1;
                //System.out.println(convertida);
                if (convertida<= 9 ){
                    String alfaNumerico="SAL-00";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    //System.out.println(concatenar);
                }
                else if(convertida<=99){
                    String alfaNumerico="SAL-0";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    
                    //System.out.println(concatenar);
                }
                else{
                    String alfaNumerico="SAL-";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    //System.out.println(concatenar);
                        }
                
                //datos.set(i, concatenar);
                
            }
        }
        return concatenar;
    }
    
    public ArrayList<String> printearInfoSala(String dato,int num)throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String ide=null;
        ArrayList<String> temporal2 = new ArrayList<String>(); 
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==0){
                ide = campo.getChildTextTrim("Codigo");
            }
            if (ide==null){}
            else {
                datos.add(ide);
            }
        }
        for (int i=0 ; i<datos.size();i++){
            //ArrayList<String> temporal2 = new ArrayList<String>(); 
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                campo = (org.jdom2.Element)list.get(i);
                org.jdom2.Element salaSeleccionada;
                salaSeleccionada = (org.jdom2.Element)list.get(i);
                String salas= salaSeleccionada.toString();
                String codigo = salaSeleccionada.getChildTextTrim("Codigo");
                String ubicacion = salaSeleccionada.getChildTextTrim("Ubicacion");
                String capacidad = salaSeleccionada.getChildTextTrim("Capacidad");
                String recursos = salaSeleccionada.getChildTextTrim("Recursos");
                String estado = salaSeleccionada.getChildTextTrim("Estado");
                String calificacion = salaSeleccionada.getChildTextTrim("Calificacion");
                temporal2.add(codigo);
                temporal2.add(ubicacion);
                temporal2.add(capacidad);
                temporal2.add(recursos);
                temporal2.add(estado);
                temporal2.add(calificacion);
                
                for (int n=0 ; n<salaSeleccionada.getContentSize();n++){
                    try {
                        ide = campo.getChildTextTrim("Dia"+n);
                        if (ide.toLowerCase().equals(dato.toLowerCase())){
                        }
                        else{
                            String dia = salaSeleccionada.getChildTextTrim("Dia"+n);
                            String horainicio = salaSeleccionada.getChildTextTrim("HoraInicio"+n);
                            String horafinal = salaSeleccionada.getChildTextTrim("HoraFinal"+n);
                            temporal2.add(dia);
                            temporal2.add(horainicio);
                            temporal2.add(horafinal);
                        }
                    } catch (Exception e) {}
                }
            }
        }
         return temporal2;
    }
    
    
    
    
    public ArrayList<ArrayList<String>> mostrarHoras(String dato)throws IOException, JDOMException{ 
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        org.jdom2.Element campo;
        String ide = null;
        String estadoSala = null;
        ArrayList<ArrayList<String>> temporal = new ArrayList<ArrayList<String>>();
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            estadoSala = campo.getChildTextTrim("Estado");
            int cont=0;
            if(estadoSala.equals("Activa")){
                for ( int i = 0; i < campo.getContentSize(); i++ ){//Recorrer cada nodo
                    ArrayList<String> temporal2 = new ArrayList<String>(); 
                    try {
                        ide = campo.getChildTextTrim("Dia"+i);
                        if (ide.toLowerCase().equals(dato.toLowerCase())){                        
                            String codigo = campo.getChildTextTrim("Codigo");
                            String ubicacion = campo.getChildTextTrim("Ubicacion");
                            String capacidad = campo.getChildTextTrim("Capacidad");
                            String recursos = campo.getChildTextTrim("Recursos");
                            String estado = campo.getChildTextTrim("Estado");
                            String calificacion = campo.getChildTextTrim("Calificacion");
                            String dia = campo.getChildTextTrim("Dia"+i);
                            String horainicio = campo.getChildTextTrim("HoraInicio"+i);
                            String horafinal = campo.getChildTextTrim("HoraFinal"+i);
                            if (cont==0){
                                temporal2.add(codigo);
                                temporal2.add(ubicacion);
                                temporal2.add(capacidad);
                                temporal2.add(recursos);
                                temporal2.add(estado);
                                temporal2.add(calificacion);
                                temporal2.add(dia);
                                temporal2.add(horainicio);
                                temporal2.add(horafinal+" ......");
                                temporal.add(temporal2);
                                cont++;
                            }else{}
                        }else{}
                    }catch (Exception e) {} 
                }
            }
        }   
        if(dato.equals("domingo")){
            ArrayList<String> temporal2 = new ArrayList<String>();
            temporal2.add("Domingo");
            temporal.add(temporal2);
            return temporal;
        }else{
            return temporal;
        }        
    }
    
    
    public ArrayList<ArrayList<String>> ubicarHoras(String dato)throws IOException, JDOMException{ 
        List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
        org.jdom2.Element campo;
        String ide = null;
        ArrayList<ArrayList<String>> temporal = new ArrayList<ArrayList<String>>();
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
                for ( int i = 0; i < campo.getContentSize(); i++ ){//Recorrer cada nodo
                    ArrayList<String> temporal2 = new ArrayList<String>(); 
                    try {
                        ide = campo.getChildTextTrim("Codigo");
                        String pba = campo.getChildTextTrim("Dia"+i);
                        if (ide.toLowerCase().equals(dato.toLowerCase())){
                        if (pba.toLowerCase().equals(dato.toLowerCase())){
                            
                        }
                        else{
                            String dia = campo.getChildTextTrim("Dia"+i);
                            String horainicio = campo.getChildTextTrim("HoraInicio"+i);
                            String horafinal = campo.getChildTextTrim("HoraFinal"+i);
                                temporal2.add(dia);
                                temporal2.add(horainicio);
                                temporal2.add(horafinal);
                                temporal.add(temporal2);
                            }
                        }
                    }catch (Exception e) {} 
                }

        }   
        return temporal;
        
        
    
    }
    public ArrayList<String> numeroCelular(String dato)throws IOException, JDOMException{ 
        List list=verInfoXML("src/aplicacion/archivos/estudiantesDB.xml");
        org.jdom2.Element campo;
        String ide = null;
        String numero= null;
        ArrayList<String> temporal2 = new ArrayList<>(); 
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
                for ( int i = 0; i < campo.getContentSize(); i++ ){//Recorrer cada nodo
                    
                    try {
                        ide = campo.getChildTextTrim("Carnet");
                        String pba = campo.getChildTextTrim("Celular");
                        if (ide.toLowerCase().equals(dato.toLowerCase())){
                            numero = campo.getChildTextTrim("Celular");
                            ide = campo.getChildTextTrim("Nombre");
                            temporal2.add(numero);
                            temporal2.add(ide);
                            System.out.println("tem2 :"+temporal2);
                            }
                    }catch (Exception e) {} 
                }

        }   
        return temporal2;
        
        
    
    }
    
  

    public ArrayList<ArrayList<String>> mostrarCapacidad(String dato)throws IOException, JDOMException{ 
            List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
            org.jdom2.Element campo;
            ArrayList<ArrayList<String>> temporal = new ArrayList<ArrayList<String>>();
            String ide=null;
            String estadoSala=null;
            
            for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
                
                ArrayList<String> temporal2 = new ArrayList<String>(); 
                campo = (org.jdom2.Element)list.get(j);
                ide = campo.getChildTextTrim("Capacidad");
                estadoSala = campo.getChildTextTrim("Estado");
                if(estadoSala.equals("Activa")){
                if (ide.toLowerCase().equals(dato.toLowerCase())){
                    String codigo = campo.getChildTextTrim("Codigo");
                    String ubicacion = campo.getChildTextTrim("Ubicacion");
                    String capacidad = campo.getChildTextTrim("Capacidad");
                    String recursos = campo.getChildTextTrim("Recursos");
                    String estado = campo.getChildTextTrim("Estado");
                    String calificacion = campo.getChildTextTrim("Calificacion");
                    temporal2.add(codigo);
                    temporal2.add(ubicacion);
                    temporal2.add(capacidad);
                    temporal2.add(recursos);
                    temporal2.add(estado);
                    temporal2.add(calificacion);
                    String dia = campo.getChildTextTrim("Dia0");
                    String horainicio = campo.getChildTextTrim("HoraInicio0");
                    String horafinal = campo.getChildTextTrim("HoraFinal0");   
                    temporal2.add(dia);
                    temporal2.add(horainicio);
                    temporal2.add(horafinal+" ......");
                    temporal.add(temporal2);
                }
                else{
                    }   
            }
            }
            return temporal;
    }
    
    
    
    
    
    private ArrayList<String> strToArray(String str, String divisor){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(divisor)));
        return list;
    }
    

    public ArrayList<ArrayList<String>> mostrarRecursos(ArrayList<String> dato)throws IOException, JDOMException{ 
            List list=verInfoXML("src/aplicacion/archivos/salasDB.xml");
            org.jdom2.Element campo;
            String ide=null;
            ArrayList<ArrayList<String>> temporal = new ArrayList<ArrayList<String>>();
            String estadoSala = null;
            for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
                campo = (org.jdom2.Element)list.get(j);
                ide = campo.getChildTextTrim("Recursos");
                ArrayList<String> listaRecursos = strToArray(ide,"-");
                ArrayList<String> temporal2 = new ArrayList<String>();
                int cont =0;
                for ( int i = 0; i < listaRecursos.size(); i++ ){//Recorrer cada nodo 
                    //ArrayList<String> temporal2 = new ArrayList<String>();
                    estadoSala = campo.getChildTextTrim("Estado");
                    //int cont=0;
                    if(estadoSala.equals("Activa")){
                        for( int n = 0; n < dato.size(); n++ ){
                            if(cont==0){
                                if (listaRecursos.get(i).toLowerCase().equals(dato.get(n).toLowerCase())){
                                    cont++;
                                    String codigo = campo.getChildTextTrim("Codigo");
                                    String ubicacion = campo.getChildTextTrim("Ubicacion");
                                    String capacidad = campo.getChildTextTrim("Capacidad");
                                    String estado = campo.getChildTextTrim("Estado");
                                    String calificacion = campo.getChildTextTrim("Calificacion");
                                    temporal2.add(codigo);
                                    temporal2.add(ubicacion);
                                    temporal2.add(capacidad);
                                    String str="";
                                    for(int p=0; p<listaRecursos.size(); p++){
                                        str+=(String) listaRecursos.get(p);
                                        str+="-";}
                                        temporal2.add(str);
                                        temporal2.add(estado);
                                        temporal2.add(calificacion);
                                        String dia = campo.getChildTextTrim("Dia0");
                                        String horainicio = campo.getChildTextTrim("HoraInicio0");
                                        String horafinal = campo.getChildTextTrim("HoraFinal0");   
                                        temporal2.add(dia);
                                        temporal2.add(horainicio);
                                        temporal2.add(horafinal+ " ......");
                                        temporal.add(temporal2);
                                }else{}
                            }else{}
                        }
                    }else{}
                }
            }
             return temporal;
    }
    
    public void guardarReserva(String pIdeReserva ,String pFechaReserva, String pHoraReserva, String pAsunto, String pCodigo, String pEstado,
            String pParticipantes,String pCodigoCalificacion,String carnetOrganizador) throws ParserConfigurationException, IOException, FileNotFoundException, TransformerException, SAXException{
        
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factoria.newDocumentBuilder();
        documento = builder.parse("src/aplicacion/archivos/reservasDB.xml");
        documento.getDocumentElement().normalize();
        valores = documento.getDocumentElement();
       
        Element salas = documento.createElement("reservasDB");
        valores.appendChild(salas);
               
        Element IdeReserva = documento.createElement("IdeReserva"); // es un hijo de estudiante
        IdeReserva.appendChild(documento.createTextNode(pIdeReserva));//hijo del elemento nombre y es de tipo nodo texto
        salas.appendChild(IdeReserva);//crea al nodo nombre como hijo de estudiante
        
        Element Fecha = documento.createElement("FechaDeReserva"); // es un hijo de estudiante
        Fecha.appendChild(documento.createTextNode(pFechaReserva));//hijo del elemento nombre y es de tipo nodo texto
        salas.appendChild(Fecha);//crea al nodo nombre como hijo de estudiante
        
        Element Hora = documento.createElement("HoraDeLaReserva"); // es un hijo de estudiante
        Hora.appendChild(documento.createTextNode(pHoraReserva));//hijo del elemento carnet y es de tipo nodo texto
        salas.appendChild(Hora);//crea al nodo nombre como hijo de estudiante
        
        Element Asunto = documento.createElement("Asunto"); // es un hijo de estudiante
        Asunto.appendChild(documento.createTextNode(pAsunto));//hijo del elemento carrera y es de tipo nodo texto
        salas.appendChild(Asunto);//crea al nodo nombre como hijo de estudiante
        
        Element CarnetOrganizador = documento.createElement("CarnetOrganizador"); // es un hijo de estudiante
        CarnetOrganizador.appendChild(documento.createTextNode(carnetOrganizador));//hijo del elemento carrera y es de tipo nodo texto
        salas.appendChild(CarnetOrganizador);//crea al nodo nombre como hijo de estudiante
        
        Element CodigoCalificacion = documento.createElement("CodigoCalificacion"); // es un hijo de estudiante
        CodigoCalificacion.appendChild(documento.createTextNode(pCodigoCalificacion));//hijo del elemento correo y es de tipo nodo texto
        salas.appendChild(CodigoCalificacion);//crea al nodo nombre como hijo de estudiante
        
        Element Codigo = documento.createElement("CodigoSala"); // es un hijo de estudiante
        Codigo.appendChild(documento.createTextNode(pCodigo));//hijo del elemento correo y es de tipo nodo texto
        salas.appendChild(Codigo);//crea al nodo nombre como hijo de estudiante
        
        Element Estado = documento.createElement("Estado"); // es un hijo de estudiante
        Estado.appendChild(documento.createTextNode(pEstado));//hijo del elemento calificacion y es de tipo nodo texto
        salas.appendChild(Estado);//crea al nodo nombre como hijo de estudiante
        
        Element Participantes = documento.createElement("Participantes"); // es un hijo de estudiante
        Participantes.appendChild(documento.createTextNode(pParticipantes));//hijo del elemento calificacion y es de tipo nodo texto
        salas.appendChild(Participantes);//crea al nodo nombre como hijo de estudiante
        
        generarXML("src/aplicacion/archivos/reservasDB.xml");
    } 
    
    public String buscarCodigoCalificacion(String Codigo) throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/estudiantesDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String infoEstudiante = null;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            ide = campo.getChildTextTrim("CodigoCalificacion");
            datos.add(ide);
        }for(int i = 0; i <datos.size(); i++){
            if (datos.get(i).toLowerCase().equals(Codigo.toLowerCase())){
                org.jdom2.Element reservaACalificar;
                reservaACalificar = (org.jdom2.Element)list.get(i);
                String nombre = reservaACalificar.getChildTextTrim("CodigoCalificacion");
                
            
        }
            
    }
        return null;
    }
    
    public String consecutivoReserva(String dato,int num)throws IOException, JDOMException{
        List list=verInfoXML("src/aplicacion/archivos/reservasDB.xml");
        ArrayList<String> datos = new ArrayList<>();
        org.jdom2.Element campo;
        String ide=null;
        for ( int j = 0; j < list.size(); j++ ){//Recorrer cada nodo
            campo = (org.jdom2.Element)list.get(j);
            if (num==0){
                ide = campo.getChildTextTrim("IdeReserva");
            }
            if (ide==null){}
            else {
                datos.add(ide);
            }
        }
        for (int i=0 ; i<datos.size();i++){
            //System.out.println(datos.get(i));
            //System.out.println(dato);
            if (datos.get(i).toLowerCase().equals(dato.toLowerCase())){
                org.jdom2.Element codigoIngresado;
                codigoIngresado = (org.jdom2.Element)list.get(i);
                int largo;
                largo = dato.length();
                String parteNumerica= dato.substring(5,largo);
                int convertida=Integer.parseInt(parteNumerica);
                convertida+=1;
                //System.out.println(convertida);
                if (convertida<= 9 ){
                    String alfaNumerico="RES-00";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    //System.out.println(concatenar);
                }
                else if(convertida<=99){
                    String alfaNumerico="RES-0";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    
                    //System.out.println(concatenar);
                }
                else{
                    String alfaNumerico="RES-";
                    concatenar = alfaNumerico + convertida;
                    dato=concatenar;
                    //System.out.println(concatenar);
                        }
                
                //datos.set(i, concatenar);
                
            }
        }
        return concatenar;
    }
    
    public void generarXML(String nombre) throws TransformerConfigurationException, FileNotFoundException, IOException, TransformerException{
        
        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
        
        Source source = new DOMSource(documento);
        File file=new File(nombre);
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);
        Result resultado = new StreamResult(pw);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(source,resultado);
    }

    public Object mostrarRecursos(String pRecursos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
