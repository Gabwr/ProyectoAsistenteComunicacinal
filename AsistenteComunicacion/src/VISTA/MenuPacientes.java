package VISTA;

import CONTROLADOR.ServicioPersona;
import MODELO.Persona;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class MenuPacientes extends javax.swing.JFrame {

    private Persona person;
    private Persona pacienteSeleccionado;
    private List<Persona> pacientes;
    public MenuPacientes(int id) {
        initComponents();
        img1.setText("");
        img2.setText("");
        img3.setText("");
        nm1.setText("");
        nm2.setText("");
        nm3.setText("");
        CrearPersonas(id);
    }
    
    public void CrearPersonas(int id){
        person = ServicioPersona.getpersona(id);
        pacientes = ServicioPersona.ListaPacientes(person);
        if (pacientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "lista vacia");
            return;
        } else {
            
        }
        int num=0;
        for(Persona paciente:pacientes){
            if (num == 0) setImagenPaciente(img1, nm1, paciente);
            else if (num == 1) setImagenPaciente(img2, nm2, paciente);
            else if (num == 2) setImagenPaciente(img3, nm3, paciente);
            num++;
            
        }
    }
    
private void setImagenPaciente(JLabel label, JLabel nombre, Persona paciente) {
    byte[] imagenBytes = paciente.getImg();
    if (imagenBytes != null && imagenBytes.length > 0) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
            BufferedImage imagenBuffer = ImageIO.read(bis);
            if (imagenBuffer != null) {
                Image imagenEscalada = imagenBuffer.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenEscalada));
                nombre.setText(paciente.getNombre());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Paciente1Pj = new javax.swing.JPanel();
        img1 = new javax.swing.JLabel();
        nm1 = new javax.swing.JLabel();
        Paciente2Pj = new javax.swing.JPanel();
        img2 = new javax.swing.JLabel();
        nm2 = new javax.swing.JLabel();
        Paciente3Pj = new javax.swing.JPanel();
        img3 = new javax.swing.JLabel();
        nm3 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(224, 98, 4));
        jPanel4.setPreferredSize(new java.awt.Dimension(250, 500));

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("SELECCIONE UN PACIENTE:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jLabel1)
                .addContainerGap(299, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(19, 19, 19))
        );

        Paciente1Pj.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Paciente1Pj.setPreferredSize(new java.awt.Dimension(280, 280));
        Paciente1Pj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Paciente1PjMouseClicked(evt);
            }
        });

        img1.setText("Imagen1");
        img1.setPreferredSize(new java.awt.Dimension(254, 272));
        img1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img1MouseClicked(evt);
            }
        });

        nm1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm1.setText("Paciente 1");
        nm1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nm1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Paciente1PjLayout = new javax.swing.GroupLayout(Paciente1Pj);
        Paciente1Pj.setLayout(Paciente1PjLayout);
        Paciente1PjLayout.setHorizontalGroup(
            Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente1PjLayout.createSequentialGroup()
                .addGroup(Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Paciente1PjLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(nm1))
                    .addGroup(Paciente1PjLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        Paciente1PjLayout.setVerticalGroup(
            Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente1PjLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(img1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nm1)
                .addContainerGap())
        );

        Paciente2Pj.setPreferredSize(new java.awt.Dimension(280, 280));
        Paciente2Pj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Paciente2PjMouseClicked(evt);
            }
        });

        img2.setText("Imagen2");
        img2.setPreferredSize(new java.awt.Dimension(180, 190));
        img2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img2MouseClicked(evt);
            }
        });

        nm2.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm2.setText("Paciente 2");
        nm2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nm2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Paciente2PjLayout = new javax.swing.GroupLayout(Paciente2Pj);
        Paciente2Pj.setLayout(Paciente2PjLayout);
        Paciente2PjLayout.setHorizontalGroup(
            Paciente2PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente2PjLayout.createSequentialGroup()
                .addGroup(Paciente2PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Paciente2PjLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(nm2))
                    .addGroup(Paciente2PjLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        Paciente2PjLayout.setVerticalGroup(
            Paciente2PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente2PjLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(img2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nm2)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        Paciente3Pj.setPreferredSize(new java.awt.Dimension(260, 280));
        Paciente3Pj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Paciente3PjMouseClicked(evt);
            }
        });

        img3.setText("Imagen3");
        img3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                img3MouseClicked(evt);
            }
        });

        nm3.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm3.setText("Paciente 3");
        nm3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nm3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout Paciente3PjLayout = new javax.swing.GroupLayout(Paciente3Pj);
        Paciente3Pj.setLayout(Paciente3PjLayout);
        Paciente3PjLayout.setHorizontalGroup(
            Paciente3PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente3PjLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(nm3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Paciente3PjLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        Paciente3PjLayout.setVerticalGroup(
            Paciente3PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente3PjLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(img3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nm3)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Paciente1Pj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Paciente2Pj, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Paciente3Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(349, 349, 349)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Paciente1Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Paciente2Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Paciente3Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 877, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Paciente1PjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Paciente1PjMouseClicked
        pacienteSeleccionado=pacientes.get(0);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Paciente1PjMouseClicked

    private void Paciente2PjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Paciente2PjMouseClicked
        pacienteSeleccionado=pacientes.get(1);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Paciente2PjMouseClicked

    private void Paciente3PjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Paciente3PjMouseClicked
        pacienteSeleccionado=pacientes.get(2);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Paciente3PjMouseClicked

    private void img1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img1MouseClicked
       pacienteSeleccionado=pacientes.get(0);
       Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
       Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_img1MouseClicked

    private void img2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img2MouseClicked
       pacienteSeleccionado=pacientes.get(1);
       Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
       Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_img2MouseClicked

    private void img3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_img3MouseClicked
        pacienteSeleccionado=pacientes.get(2);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_img3MouseClicked

    private void nm1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nm1MouseClicked
       pacienteSeleccionado=pacientes.get(0);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
       Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_nm1MouseClicked

    private void nm2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nm2MouseClicked
       pacienteSeleccionado=pacientes.get(1);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
       Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_nm2MouseClicked

    private void nm3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nm3MouseClicked
       pacienteSeleccionado=pacientes.get(2);
        Acciones Paciente = new Acciones(pacienteSeleccionado.getIdPersona(),person.getIdPersona());
       Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_nm3MouseClicked

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        MenuInicio regreso = new MenuInicio(person.getIdPersona());
        regreso.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Paciente1Pj;
    private javax.swing.JPanel Paciente2Pj;
    private javax.swing.JPanel Paciente3Pj;
    private javax.swing.JLabel img1;
    private javax.swing.JLabel img2;
    private javax.swing.JLabel img3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JLabel nm1;
    private javax.swing.JLabel nm2;
    private javax.swing.JLabel nm3;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
