
package version.pkgfinal;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import logicaProyecto.Estudiante;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;


public class ventEstudiante extends javax.swing.JFrame {
    private JComboBox combo1;
    String seleccionCarrera;
    String nombre;
    String celular;
    String numCarnet;
    String correo;

    public ventEstudiante() {
        initComponents();
    }
    
    
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        carrerasBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        nombreEstudiante = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        numeroCelular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        carnet = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Seleccione una carrera:");

        jLabel2.setText("Registro de estudiante");

        carrerasBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Carrera", "Administración de Empresas", "Administración de Tecnologías de Información", "Educación Técnica", "Enseñanza de la Matemática asistida por computadora", "Gestión en turismo sostenible", "Ingeniería Agrícola", "Ingeniería en Agronegocios", "Ingeniería Ambiental", "Ingeniería en Biotecnología", "Ingeniería en Computación", "Ingeniería en Computadores", "Ingeniería en Construcción", "Ingeniería en Diseno Industrial", "Ingeniería en Electrónica", "Ingeniería en Mantenimiento Industrial", "Ingeniería en Materiales", "Ingeniería en Producción Industrial", "Ingeniería en Seguridad Laboral e Higiene Ambiental", "Ingeniería Forestal", "Ingenieria Mecatrónica" }));
        carrerasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrerasBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Registrar estudiante");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        nombreEstudiante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreEstudianteActionPerformed(evt);
            }
        });

        jLabel3.setText("Ingrese el nombre del estudiante:");

        jLabel4.setText("Ingrese el número celular:");

        numeroCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numeroCelularActionPerformed(evt);
            }
        });

        jLabel5.setText("Ingrese el carnet:");

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });

        jLabel6.setText("Ingrese el email:");

        carnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carnetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(56, 56, 56)
                            .addComponent(jLabel2))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(carrerasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1))
                    .addComponent(jLabel6)
                    .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(carrerasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombreEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numeroCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(carnet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void carrerasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrerasBoxActionPerformed

    }//GEN-LAST:event_carrerasBoxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        seleccionCarrera=carrerasBox.getSelectedItem().toString();
        nombre=nombreEstudiante.getText().toString();
        celular=numeroCelular.getText().toString();
        numCarnet=carnet.getText().toString();
        correo=email.getText().toString();
        if (seleccionCarrera=="Carrera"){
            JOptionPane.showMessageDialog(null, "Seleccione una carrera!");
        }
        else if(nombre.equals("")){
            JOptionPane.showMessageDialog(null, "Espacio nombre en blanco");
        }
        else if(celular.equals("")){
            JOptionPane.showMessageDialog(null, "Espacio numero celular en blanco");
        }
        else if(numCarnet.equals("")){
            JOptionPane.showMessageDialog(null, "Espacio numero de carnet en blanco");
        }
        else if(correo.equals("")){
            JOptionPane.showMessageDialog(null, "Espacio correo electrónico en blanco");
        }
        else{
            if (validarEmailFuerte(correo)){
            if (celular.matches("^-?\\d+$") && numCarnet.matches("^-?\\d+$")){
                Estudiante estudiante = new Estudiante(celular,nombre, numCarnet,seleccionCarrera,correo,celular);
                try {
                    if (estudiante.agregarEstudiante(estudiante)){
                        nombreEstudiante.setText("");
                        numeroCelular.setText("");
                        carnet.setText("");
                        email.setText("");
                        carrerasBox.setSelectedItem("Carrera");
                                                

                        JOptionPane.showMessageDialog(null, "Datos registrados");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ya existe un estudiante con ese carnet!");

                    }
                } catch (ParserConfigurationException ex) {
                    Logger.getLogger(ventEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SAXException ex) {
                    Logger.getLogger(ventEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(ventEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (TransformerException ex) {
                    Logger.getLogger(ventEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JDOMException ex) {
                    Logger.getLogger(ventEstudiante.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
            else{
                JOptionPane.showMessageDialog(null, "No ingresó digitos en las casillas correspondientes!");
            }   
                        }
            else{
                JOptionPane.showMessageDialog(null, "Formato de correo incorrecto!");
            }
                
          
        }
                    
            
    }//GEN-LAST:event_jButton1ActionPerformed

    
public static boolean validarEmailFuerte(String email){
        
        String regex = "^[\\w!#$%&'+/=?`{|}~^-]+(?:\\.[\\w!#$%&'+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
 
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    
    private void nombreEstudianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreEstudianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreEstudianteActionPerformed

    private void numeroCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numeroCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroCelularActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void carnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carnetActionPerformed

 


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField carnet;
    private javax.swing.JComboBox<String> carrerasBox;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField nombreEstudiante;
    private javax.swing.JTextField numeroCelular;
    // End of variables declaration//GEN-END:variables
}
