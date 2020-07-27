
package Clases;
import Xml.XML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.util.Properties;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.Properties;
//import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JTextField;
/**
 *
 * @author Adriel
 */
public class Reserva {
    private String asunto;
    private String idSala;
    private String estado;
    private ArrayList<ArrayList<String>> listParticipantes = new ArrayList<ArrayList<String>>();
    private String fechaReserva;
    private String horaReserva;
    private String carnetOrganizador;
    private String ideReserva;
    private String codigoCalificacion;
    private String numCel;
    
public Reserva(String pAsunto, String pIdSala, String pFecha,String pHoraDeLaReserva,String aCarnet, String numeroCelular) throws IOException, JDOMException{
    this.asunto = pAsunto;
    this.idSala = pIdSala;
    this.listParticipantes = listParticipantes;
    this.estado = "Activa";
    this.fechaReserva = pFecha;
    this.horaReserva = pHoraDeLaReserva;
    this.carnetOrganizador = aCarnet;
    setIdeReserva();
    System.out.println(ideReserva);
    setCodigoCalificacion(pIdSala, ideReserva, aCarnet);
    this.numCel = numeroCelular;
}

    public String getNumCel() {
        return numCel;
    }

    public void setNumCel(String numCel) {
        this.numCel = numCel;
    }

    public String getIdeReserva() {
        return ideReserva;
    }

    public String setIdeReserva() throws IOException, JDOMException {
        XML consecutivo = new XML();
        String codigoReserva= consecutivo.consecutivoReserva("RES-001",0);
        System.out.println(codigoReserva+"final");
        this.ideReserva = codigoReserva;
        return ideReserva;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setCodigoCalificacion(String codigoCalificacion) {
        this.codigoCalificacion = codigoCalificacion;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public void setListParticipantes(ArrayList<ArrayList<String>> listParticipantes) {
        this.listParticipantes = listParticipantes;
    }

    public void setCarnetOrganizador(String carnetOrganizador) {
        this.carnetOrganizador = carnetOrganizador;
    }

    public void setIdeReserva(String ideReserva) {
        this.ideReserva = ideReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getCodigoCalificacion() {
        return codigoCalificacion;
    }

    public void verificarCarnet(){
    
    }
    
    public void setCodigoCalificacion(String codigoSala,String ideReserva,String carnet) {
        String CodigoCalificaion= codigoSala+"-"+ideReserva+"-"+carnet;
        System.out.println(CodigoCalificaion);
        this.codigoCalificacion = CodigoCalificaion;
    }
    
    public static boolean validarEmailFuerte(String email){
        
        String regex = "^[\\w!#$%&'+/=?`{|}^-]+(?:\\.[\\w!#$%&'+/=?`{|}^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    /**
     *
     */
    public boolean agregarParticipante(String pNombre,String pCorreo){
        if(validarEmailFuerte(pCorreo)){
            //participante nuevoParticipante = new participante(pNombre, pCorreo);
            ArrayList<String> participante = new ArrayList<>();
            participante.add(pNombre);
            participante.add(pCorreo);
            //ArrayList<ArrayList<String>> nuevo = new ArrayList<>();
            //System.out.println(participante);
            //nuevo.add(participante);
            listParticipantes.add(participante);
            return true;
        }else{
            System.err.println("Formato de correo no valido");
            return false;}
    }
    
    public boolean verificarEstudiante() throws IOException, JDOMException{
        XML validaCarnet = new XML();
        boolean existe = validaCarnet.validaCarnet(carnetOrganizador,1);
        return existe;
    }
    
    public void guardarReserva(Reserva nuevaReserva) throws ParserConfigurationException, IOException, FileNotFoundException, TransformerException, SAXException{
        XML reservaNueva = new XML();
        reservaNueva.guardarReserva(nuevaReserva.getIdeReserva(),nuevaReserva.getFechaReserva(),nuevaReserva.getHoraReserva(),nuevaReserva.getAsunto(),
                nuevaReserva.getIdSala(),nuevaReserva.getEstado(),modificarArrayDoble(listParticipantes),nuevaReserva.getCodigoCalificacion(),nuevaReserva.getCarnetOrganizador());
    }
    
    private String modificarArrayDoble(ArrayList<ArrayList<String>> lista){
    String str="";
    for(int i=0; i<lista.size(); i++){
        str+=(String) lista.get(i).toString();
        str+="-";
    }
    return str;
    }
    
    public String getAsunto() { // obtengo info
        return asunto;
    }

    public String getIdSala() { // obtengo info
        return idSala;
    }

    public String getEstado() { // obtengo info
        return estado;
    }

    public String getCarnetOrganizador() {
        return carnetOrganizador;
    }

    public ArrayList<ArrayList<String>> getListParticipantes() {
        return listParticipantes;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    /*public ArrayList<String> getInformacionReserva() { //hacer un for para que muestre los datos del arreglo
        return informacionReserva;
    }*/

    public String getFechaReserva() { //hacer un for para que muestre los datos del arreglo
        return fechaReserva;
    }

    public void setEstado(String estado) { // cambiar el string de estado
        this.estado = estado;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
    
    private void agregarReserva() { //agregar al arraylist de Reserva
    
    }
   
    public void enviarCorreo() { 
        //Correo email = new Correo("smtp.gmail.com", "biblioteca01.tec@gmail.com", "biblioteca","adriel369@gmail.com", "biblioteca01.tec@gmail.com","Prueba Correo","Prueba de correo \n Proyecto biblioteca");
        try {
            for ( int j = 0; j < listParticipantes.size(); j++ ){
             for ( int i = 0; i < listParticipantes.get(j).size(); j++ ){
                 try{
                    ArrayList<String> lista;
                    lista=listParticipantes.get(j);
                    boolean depuracion = false;
                    Properties props = System.getProperties();
                    props.put("mail.smtp.starttls.enable", "true");
                    props.put("mail.smtp.host", "smtp.gmail.com");
                    props.put("mail.smtp.port", "587");
                    props.put("mail.smtp.auth", "true");
                    props.put("mail.smtp.starttls.required", "true");

                    java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
                    Session mailSession = Session.getDefaultInstance(props, null);


                    mailSession.setDebug(depuracion);
                    javax.mail.Message msg = new MimeMessage(mailSession);
                    msg.setFrom(new InternetAddress("biblioteca01.tec@gmail.com"));
                    InternetAddress[] address = {new InternetAddress(lista.get(1))};
                    msg.setRecipients(javax.mail.Message.RecipientType.TO, address);


                    msg.setSubject(asunto); msg.setSentDate(new Date());
                    msg.setText("PRUEBA DESDE EL CODIGO");

                   Transport transport=mailSession.getTransport("smtp");
                   transport.connect("smtp.gmail.com", "biblioteca01.tec@gmail.com", "biblioteca");
                   transport.sendMessage(msg, msg.getAllRecipients());
                   transport.close();
                   System.out.println("Mensaje enviado!");
                }catch(MessagingException ex)
                {
                    System.out.println(ex);
                }
             }
        
         }
        } catch (Exception e) {}
    }   
      
     
    public void enviarSms(String numCelular) throws IOException, JDOMException { // implementar clase sms
        String nombre;
        XML xml = new XML();
        nombre=xml.numeroCelular(getCarnetOrganizador()).get(1);
        try {
             String ACCOUNT_SID = "ACcc98c7a5a8225181d603eb51b86609b2";
            String AUTH_TOKEN = "79ae7fa2b2da7f14986b3064c9ca13d7";


            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            
            Message message = Message.creator(new PhoneNumber("+506"+numCelular), new PhoneNumber("+18589240464"),
                    "Organizador: "+nombre+" usted ha reservado una sala. Este es el codigo de calificación: "+getCodigoCalificacion()).create();

            JOptionPane.showMessageDialog(null, "Mensaje enviado");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al intentar enviar el mensaje!");
        }
    
   

    }

    public void setParticipantes(String participantes,String correoParticipante) { // esta info se guarda en el arraylist participantes
    }
    
    public boolean confirmarFecha(ArrayList pFechaHorario) throws ParseException{
        String dia = (String) pFechaHorario.get(0);
        //String fechaIngresada= pfecha;
        SimpleDateFormat format1=new SimpleDateFormat("dd/MM/yyyy");//formato obligatorio.ejm:01/05/2017.
            format1.setLenient(false);
            Date dt1=format1.parse(fechaReserva);
            DateFormat format2=new SimpleDateFormat("EEEE");
            String diaFinal=format2.format(dt1);
            if(diaFinal.toLowerCase().equals(dia.toLowerCase())){
                System.out.println("Exito");
                return true;

            } 
            else{
                System.err.println("La fecha en la que desea reservar no coninside con el dia en el que quiere realizar la reserva");
                return false;
            }
    }
        
}
