
package version.pkgfinal;

import Xml.XML;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import static java.util.Optional.empty;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import Clases.Sala;
import java.util.Arrays;
import org.jdom2.JDOMException;
import org.omg.CORBA.Object;
import org.xml.sax.SAXException;


public class ventSala extends javax.swing.JFrame {
    DefaultListModel modeloLista;
    DefaultListModel listaHorarios;
    String elementos="";
    String seleccionRecursos, seleccionCapacidad, ubic, dia, recursos,codigos;
    int numEntero;
    int pos;
    List<String> dias = new ArrayList<String>();
    List<String> temp1 = new ArrayList<String>();
    private  ArrayList<ArrayList<String>> horario1 = new ArrayList<ArrayList<String>>();
    Sala salaNueva = new Sala("limon", 20);



    public ventSala() throws IOException, JDOMException, ParserConfigurationException, SAXException, FileNotFoundException, TransformerException {
        initComponents();
        Sala pba = new Sala("limon", 20);
        codigo.setEditable(false);
        String Codigo = pba.getCodigo();
        codigo.setText(Codigo);
        
        
        String Calificacion = "100";
        calificacion.setEditable(false);
        calificacion.setText(Calificacion);
        modeloLista= new DefaultListModel();
        listaRecus.setModel(modeloLista);
        listaHorarios= new DefaultListModel();
        listaHora.setModel(listaHorarios);
    }




    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        capacidad = new javax.swing.JComboBox<>();
        ubicacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        horario = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JScrollPane();
        codigo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        calificacion = new javax.swing.JTextPane();
        jButton1 = new javax.swing.JButton();
        Recursos = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        listaRecus = new javax.swing.JList<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        listaHora = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Agregar Sala");

        jLabel2.setText("Anote los recursos:");

        jLabel3.setText("Seleccione capacidad:");

        capacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capacidad", "5", "10", "15", "25", "30", "35" }));

        jLabel4.setText("Ingrese la ubicación:");

        jLabel5.setText("Seleccione un día:");

        horario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dias", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado" }));
        horario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarioActionPerformed(evt);
            }
        });

        jLabel6.setText("Calificación de sala:");

        jLabel7.setText("Codigo de sala:");

        txtcodigo.setEnabled(false);
        txtcodigo.setViewportView(codigo);

        calificacion.setBackground(new java.awt.Color(255, 255, 255));
        calificacion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        calificacion.setEnabled(false);
        jScrollPane2.setViewportView(calificacion);

        jButton1.setText("Registrar Sala");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        listaRecus.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane4.setViewportView(listaRecus);

        jButton2.setText("Agregar recurso");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Agregar horario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jScrollPane6.setViewportView(listaHora);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(50, 50, 50)))
                        .addGap(51, 51, 51))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Recursos, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel4))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Recursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addGap(1, 1, 1)
                .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addContainerGap(49, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        seleccionCapacidad=capacidad.getSelectedItem().toString();
        ubic=ubicacion.getText().toString();
        dia=horario.getSelectedItem().toString();
        recursos=Recursos.getText().toString();
        int pos= listaHora.getSelectedIndex();
        
        if(seleccionCapacidad=="Capacidad"){
           JOptionPane.showMessageDialog(null, "Seleccione la capacidad!");   
        }
        else if (ubic.equals("")){
            JOptionPane.showMessageDialog(null, "Ingrese la ubicación!");  
        }
        else if (dia == "Dias"){
            listaHorarios.removeAllElements();
            JOptionPane.showMessageDialog(null, "Seleccione un dia!"); 
        }
        else if(modeloLista.getSize()==0){
            JOptionPane.showMessageDialog(null, "Agregue recursos!");
            
        }
        else if (pos < 0){
        JOptionPane.showMessageDialog(null, "Seleccione algun horario!");
    }
        
        else{
            XML xml = new XML();
            
            try {
                
                salaNueva.guardar((ArrayList<java.lang.String>) temp1);
                salaNueva.setCapacidad(Integer.parseInt((String) seleccionCapacidad ));
                salaNueva.setUbicacion(ubic);
                salaNueva.agregarSala(salaNueva);
            JOptionPane.showMessageDialog(null, "PRUEBA");
            } catch (ParserConfigurationException | SAXException | IOException | TransformerException | JDOMException ex) {
                Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        recursos=Recursos.getText();
        recursos = recursos.substring(0,1).toUpperCase() + recursos.substring(1).toLowerCase();
        if (recursos.equals("")){
            JOptionPane.showMessageDialog(null, "Agregue un recurso");
        }
        
        else if (!temp1.contains(recursos)){
            temp1.add(recursos);
            modeloLista.addElement(recursos);
            temp1.add(recursos);
        }
        else{
            
            JOptionPane.showMessageDialog(null, "Ya agregó ese recurso");
            
        }
        
        
        Recursos.setText("");
        
        
        
        
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    
 
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
             ArrayList<ArrayList<String>> horasSeleccionadas = new ArrayList<ArrayList<String>>();
            int pos;
            pos= listaHora.getSelectedIndex();
            String seleccion;
            seleccion = (java.lang.String) listaHorarios.get(pos);
            ArrayList List = strToArray(seleccion,",");
            
            if (salaNueva.setHorario(List)){
                JOptionPane.showMessageDialog(null, "Horario agregado");
            }
            else{
                JOptionPane.showMessageDialog(null, "Ya seleccionó ese horario");
            }
        } catch (IOException ex) {
            Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JDOMException ex) {
            Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        

         
    }//GEN-LAST:event_jButton4ActionPerformed


private ArrayList<String> strToArray(String str, String divisor){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(divisor)));
        return list;
    }           



    private void horarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarioActionPerformed

        dia=horario.getSelectedItem().toString(); 
        if (dia=="Dias"){
            listaHorarios.removeAllElements();
            JOptionPane.showMessageDialog(null, "Seleccione un día!");
            
        }
        else{
            
            if (listaHorarios.getSize()>0){
                listaHorarios.removeAllElements();
                
                Sala sala;
                try {
                    sala = new Sala(ubic, numEntero);
                    dias=(sala.consultarHorario(dia));
                String horario1 = dias.get(0)+", "+ dias.get(1)+", "+ dias.get(2);
                String horario2 = dias.get(3)+", "+ dias.get(4)+", "+ dias.get(5);
                listaHorarios.addElement(horario1);
                listaHorarios.addElement(horario2);
                } catch (IOException ex) {
                    Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JDOMException ex) {
                    Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                
            }
            else{
                Sala sala;
                try {
                    sala = new Sala(ubic, numEntero);
                    dias=(sala.seleccionHorarios(dia));
                } catch (IOException ex) {
                    Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JDOMException ex) {
                    Logger.getLogger(ventSala.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                String horario1 = dias.get(0)+", "+ dias.get(1)+", "+ dias.get(2);
                String horario2 = dias.get(3)+", "+ dias.get(4)+", "+ dias.get(5);
                listaHorarios.addElement(horario1);
                listaHorarios.addElement(horario2);
                
            }
            
        }                       

    }//GEN-LAST:event_horarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Recursos;
    private javax.swing.JTextPane calificacion;
    private javax.swing.JComboBox<String> capacidad;
    private javax.swing.JTextPane codigo;
    private javax.swing.JComboBox<String> horario;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> listaHora;
    private javax.swing.JList<String> listaRecus;
    private javax.swing.JScrollPane txtcodigo;
    private javax.swing.JTextField ubicacion;
    // End of variables declaration//GEN-END:variables
}
