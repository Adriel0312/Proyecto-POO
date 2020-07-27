
package version.pkgfinal;

import Clases.Reserva;
import Xml.XML;
import com.sun.jmx.snmp.internal.SnmpSubSystem;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class reservaSala extends javax.swing.JFrame {
    ArrayList<String> seleccion = new ArrayList<>();
    DefaultListModel listaHorarios;
    String date, nombreParticipante,correoElec,asuntoReser,carnetEstu,numeroCelular,fecha1,horaReservacion;
    Reserva reservacion = new Reserva("", "", "", "", "","");
    int cont=0;
    ArrayList<ArrayList<String>> selecc = new ArrayList<ArrayList<String>>();


    public reservaSala(ArrayList<String> selecc, String fecha) throws IOException, JDOMException {
        initComponents();
        
        this.seleccion=selecc;
        this.date=fecha;
        listaHorarios= new DefaultListModel();
        listaDeHorarios.setModel(listaHorarios);
        
        listaParticipantes.setEditable(false);
        
        salaSelec.setEditable(false);
        String Codigo = seleccion.get(0);
        salaSelec.setText(Codigo);
        
        ubic.setEditable(false);
        String Ubic = seleccion.get(1);
        ubic.setText(Ubic);
        
        capacidad.setEditable(false);
        String capac = seleccion.get(2);
        capacidad.setText(capac);

        recursos.setEditable(false);
        String recur = seleccion.get(3);
        recursos.setText(recur);

        estado.setEditable(false);
        String estad = seleccion.get(4);
        estado.setText(estad);

        calificacion.setEditable(false);
        String calif = seleccion.get(5);
        calificacion.setText(calif);
        
        this.fecha1=fecha;
        
        System.out.println(fecha);
        XML xml = new XML();
        for (int i = 0; i < xml.ubicarHoras(selecc.get(0)).size(); i++)
                 {
                 listaHorarios.addElement(xml.ubicarHoras(selecc.get(0)).get(i));
                   }
        
        
        
        
        
   
        
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaDeHorarios = new javax.swing.JList<>();
        aplicarHorario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        salaSelec = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        capacidad = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        ubic = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        recursos = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        estado = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        calificacion = new javax.swing.JTextPane();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        carnet = new javax.swing.JTextField();
        asunto = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane8 = new javax.swing.JScrollPane();
        listaParticipantes = new javax.swing.JTextArea();
        añadir = new javax.swing.JButton();
        reservar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione hora que desea reservar:");

        jScrollPane1.setViewportView(listaDeHorarios);

        aplicarHorario.setText("Aplicar horario");
        aplicarHorario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarHorarioActionPerformed(evt);
            }
        });

        jLabel2.setText("Añadir participantes:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Email:");

        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Datos generales de la sala:");

        jLabel6.setText("Sala seleccionada:");

        jLabel7.setText("Ubicación:");

        jLabel8.setText("Calificación: ");

        jLabel9.setText("Capacidad:");

        jLabel10.setText("Recursos:");

        jLabel12.setText("Estado:");

        jScrollPane2.setViewportView(salaSelec);

        jScrollPane3.setViewportView(capacidad);

        jScrollPane4.setViewportView(ubic);

        jScrollPane5.setViewportView(recursos);

        jScrollPane6.setViewportView(estado);

        jScrollPane7.setViewportView(calificacion);

        jLabel11.setText("Ingrese el carnet del organizador:");

        jLabel13.setText("Ingrese el asunto:");

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        listaParticipantes.setColumns(20);
        listaParticipantes.setRows(5);
        jScrollPane8.setViewportView(listaParticipantes);

        añadir.setText("Añadir");
        añadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirActionPerformed(evt);
            }
        });

        reservar.setText("Reservar Sala");
        reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(aplicarHorario)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textNombre))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(correo)))
                                .addGap(0, 126, Short.MAX_VALUE))
                            .addComponent(jScrollPane8))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(añadir)
                        .addGap(93, 93, 93)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(reservar)
                        .addGap(78, 78, 78))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(asunto, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11)
                            .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(130, 130, 130))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                        .addComponent(jScrollPane7))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aplicarHorario)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(añadir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(asunto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(reservar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void añadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirActionPerformed

        nombreParticipante=textNombre.getText().toString();
        correoElec=correo.getText().toString();
        int y = Integer.parseInt(seleccion.get(2));
        if(nombreParticipante.equals("")){
            JOptionPane.showMessageDialog(null, "No ingresó el nombre del participante");
        }
        else if (correoElec.equals("")){
            JOptionPane.showMessageDialog(null, "No ingresó el correo electrónico");
        }
        
        else{
            if(cont<y){
                if(reservacion.agregarParticipante(nombreParticipante, correoElec)){
                    cont++;
                    listaParticipantes.append("Participante: "+ nombreParticipante+" |  Correo electrónico: "+ correoElec +"\n");
                    textNombre.setText("");
                    correo.setText("");
                    listaParticipantes.setLineWrap(true);
                    System.err.println(reservacion.getListParticipantes());
                    JOptionPane.showMessageDialog(null, "Participante añadido");
                    }
                else{
                    JOptionPane.showMessageDialog(null, "Ingresó un formato invalido en el correo electrónico");
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ya alcanzó el limite de capacidad de la sala!");
            }
            
        }
        
    }//GEN-LAST:event_añadirActionPerformed

    private void reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarActionPerformed
       carnetEstu=carnet.getText().toString();
       asuntoReser=asunto.getText().toString();
       String numeroString;
       String nombreString;
       try{
            if(carnetEstu.equals("")){
                 JOptionPane.showMessageDialog(null, "No ingresó el carnet del estudiante!");
             }
            else if(asuntoReser.equals("")){
                JOptionPane.showMessageDialog(null, "No ingresó el asunto!");
            }
            else{
                XML xml = new XML();
                try {
                    if(xml.validaCarnet(carnetEstu,1)){
                        ArrayList<String> nombre2=xml.numeroCelular(carnetEstu);
                        JOptionPane.showMessageDialog(null, "Si sirve");
                        System.out.println(nombre2);
                        numeroString=nombre2.get(0);
                        nombreString=nombre2.get(1);
                        reservacion.setFechaReserva(fecha1);
                        reservacion.setCodigoCalificacion(seleccion.get(0),reservacion.setIdeReserva(),carnetEstu );
                        ArrayList<String> pba;
                        pba=selecc.get(0);
                        reservacion.setHoraReserva(pba.get(0));
                        reservacion.setAsunto(asuntoReser);
                        reservacion.setCarnetOrganizador(carnetEstu);
                        reservacion.setIdSala(seleccion.get(0));
                        reservacion.setEstado("Activa");
                        reservacion.enviarSms(nombre2.get(0));
                        reservacion.guardarReserva(reservacion);
                        reservacion.enviarCorreo();

                    }
                    else{
                        JOptionPane.showMessageDialog(null, "No sirve");
                    }
                } catch (IOException | JDOMException | ParserConfigurationException | TransformerException | SAXException ex) {
                    Logger.getLogger(reservaSala.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
       }catch (Exception e) {}
    }//GEN-LAST:event_reservarActionPerformed

    private void aplicarHorarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarHorarioActionPerformed
       int pos;
            pos= listaDeHorarios.getSelectedIndex();
           
            selecc.add((ArrayList<String>) listaHorarios.get(pos));
            JOptionPane.showMessageDialog(null, "Horario agregado");
            
    }//GEN-LAST:event_aplicarHorarioActionPerformed

    public ArrayList<String> getSeleccion() {
        return seleccion;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarHorario;
    private javax.swing.JTextField asunto;
    private javax.swing.JButton añadir;
    private javax.swing.JTextPane calificacion;
    private javax.swing.JTextPane capacidad;
    private javax.swing.JTextField carnet;
    private javax.swing.JTextField correo;
    private javax.swing.JTextPane estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JList<String> listaDeHorarios;
    private javax.swing.JTextArea listaParticipantes;
    private javax.swing.JTextPane recursos;
    private javax.swing.JButton reservar;
    private javax.swing.JTextPane salaSelec;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextPane ubic;
    // End of variables declaration//GEN-END:variables
}
