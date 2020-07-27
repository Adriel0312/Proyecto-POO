
package version.pkgfinal;

import Clases.Buscador;
import Xml.XML;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class ReservarSala extends javax.swing.JFrame {
String dia1,mes1,anio,capacidad1,recursos1,formato;
    ArrayList<String> listRecursos = new ArrayList<>();
    ArrayList<String> seleccion = new ArrayList<>();
    ArrayList<ArrayList<String>> filtroGeneral = new ArrayList<ArrayList<String>>();
    DefaultListModel listaHorarios;


    public ReservarSala() {
        initComponents();
        listaHorarios= new DefaultListModel();
        listaSalas.setModel(listaHorarios);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dia = new javax.swing.JComboBox<>();
        mes = new javax.swing.JComboBox<>();
        anno = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        capacidad = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        buscarSalas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaSalas = new javax.swing.JList<>();
        aplicar = new javax.swing.JButton();
        recursos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione el dia que desea filtrar las salas:");

        dia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Día", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaActionPerformed(evt);
            }
        });

        mes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mes", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        anno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Año", "2017", "2018" }));

        jLabel2.setText("Seleccione la capacidad:");

        capacidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Capacidad", "5", "10", "15", "20", "25", "30", "35" }));

        jLabel3.setText("Ingrese los recursos (De ser más de uno separelo con una coma):");

        buscarSalas.setText("Buscar");
        buscarSalas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarSalasActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(listaSalas);

        aplicar.setText("Aplicar");
        aplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarActionPerformed(evt);
            }
        });

        jLabel4.setText("Seleccione horario que desea reservar:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(anno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2)
                                    .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(recursos, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buscarSalas)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addGap(0, 17, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(aplicar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(anno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(capacidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(recursos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscarSalas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aplicar)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarSalasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarSalasActionPerformed
    dia1=dia.getSelectedItem().toString();
    mes1=mes.getSelectedItem().toString();
    anio=anno.getSelectedItem().toString();
    capacidad1=capacidad.getSelectedItem().toString();
    recursos1=recursos.getText().toString();
    if (dia1=="Día" || mes1=="Mes" || anio=="Año"){
         JOptionPane.showMessageDialog(null, "Debe llenar todas las casillas de la fecha");
    }
    else if (capacidad1=="Capacidad"){
        JOptionPane.showMessageDialog(null, "No ingresó la capacidad");
                    
    }
    else{
        Buscador buscar = new Buscador();
        formato= dia1+"/"+mes1+"/"+anio;
       
        try {
            listRecursos = strToArray(recursos1, ",");
            System.err.println(listRecursos);
            if(buscar.validarFecha(formato)){
               if (buscar.BuscarDia(formato)){
                   if (buscar.BuscarCapacidad(capacidad1)){
                       if (recursos1.equals("")){ 
                           XML filtro = new XML();
                            System.err.println(filtroGeneral=filtro.mostrarCapacidad(capacidad1));
                            for (int i = 0; i < filtroGeneral.size(); i++)
                            {
                                listaHorarios.addElement(filtroGeneral.get(i));
                            }
                        }
                        else{
                           if (buscar.buscarRecurso(listRecursos)){
                               XML filtro = new XML();
                               System.err.println(filtroGeneral=filtro.mostrarCapacidad(capacidad1));
                               for (int i = 0; i < filtroGeneral.size(); i++)
                            {
                                listaHorarios.addElement(filtroGeneral.get(i));
                            }
                                }
                           else{
                               JOptionPane.showMessageDialog(null, "No se encontró una sala que cumpla las condiciones!");
                               }
                            }
                   }
                   else{
                       JOptionPane.showMessageDialog(null, "No se encontró una sala que cumpla las condiciones!");
                   }
               }
               else{
                         JOptionPane.showMessageDialog(null, "No se encontró una sala que cumpla las condiciones!");  
                           }
            }
            else{
                JOptionPane.showMessageDialog(null, "Ingreso una fecha invalida!");
            }
            
        } catch (ParseException | IOException | JDOMException | ParserConfigurationException | SAXException ex) {
            Logger.getLogger(ReservarSala.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
                   
        
    
    
    }
    
    
    
    
    }//GEN-LAST:event_buscarSalasActionPerformed
private ArrayList<String> strToArray(String str, String divisor){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(divisor)));
        return list;
    }
    private void diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diaActionPerformed

    private void aplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarActionPerformed
            int pos;
            pos= listaSalas.getSelectedIndex();
            seleccion = (ArrayList<String>) listaHorarios.get(pos);
            System.err.println(seleccion);
            reservaSala ventanaReser;
    try {
        ventanaReser = new reservaSala(seleccion,formato);
        ventanaReser.setTitle("Ventana Calificar");
            ventanaReser.setVisible(true);
            this.setVisible(false);
    } catch (IOException ex) {
        Logger.getLogger(ReservarSala.class.getName()).log(Level.SEVERE, null, ex);
    } catch (JDOMException ex) {
        Logger.getLogger(ReservarSala.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
    }//GEN-LAST:event_aplicarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> anno;
    private javax.swing.JButton aplicar;
    private javax.swing.JButton buscarSalas;
    private javax.swing.JComboBox<String> capacidad;
    private javax.swing.JComboBox<String> dia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaSalas;
    private javax.swing.JComboBox<String> mes;
    private javax.swing.JTextField recursos;
    // End of variables declaration//GEN-END:variables
}
