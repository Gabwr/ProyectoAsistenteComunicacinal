/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROLADOR.AccionServicio;
import MODELO.Accion;
import AppPackage.AnimationClass;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Acciones extends javax.swing.JFrame {

    private List<Accion> acciones = null;
    private int indiceActual = 0;
    private Timer timer;
    private boolean sliderActivo = true;
    public static String _idAccion = null;

     
    public Acciones() {
        initComponents();
        cargarAcciones();
        mostrarImagenActual();
        cargarid();
//        idAccion.setVisible(false);
       
    }
    private void cargarAcciones() {
        acciones = AccionServicio.CargarAccion();
    }

    private void mostrarImagenActual() {
        if (acciones != null && !acciones.isEmpty() && indiceActual >= 0 && indiceActual < acciones.size()) {
            try {
                byte[] imagenBytes = acciones.get(indiceActual).getImagen();
                if (imagenBytes != null) {
                    ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                    Image img = ImageIO.read(bis);
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(jLIMAGENES.getWidth(), jLIMAGENES.getHeight(), Image.SCALE_SMOOTH));
                    jLIMAGENES.setIcon(icon);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void cargarid() {
    if (acciones != null && !acciones.isEmpty() && indiceActual >= 0 && indiceActual < acciones.size()) {
        Accion accionActual = acciones.get(indiceActual);
        int id = accionActual.getIdAccion();

        if (id > 0) {
            idAccion.setText("ID: " + id);
            _idAccion = String.valueOf(id); 
        } else {
            idAccion.setText("ID no disponible");
            _idAccion = null;
        }
        System.out.println("ID Actual: " + _idAccion); 
    }
}

    private void iniciarSlider() {
    timer = new Timer(3000, new ActionListener() { // Cada 3 segundos
        @Override
        public void actionPerformed(ActionEvent e) {
            if (indiceActual < acciones.size() - 1) {
                indiceActual++;
            } else {
                indiceActual = 0; // Vuelve al inicio
            }
            mostrarImagenActual();
        }
    });
    timer.start();
}
    private void siguienteImagen() {
    if (indiceActual < acciones.size() - 1) {
        indiceActual++;
    } else {
        indiceActual = 0;
    }
    mostrarImagenActual();
    cargarid();
}

private void anteriorImagen() {
    if (indiceActual > 0) {
        indiceActual--;
    } else {
        indiceActual = acciones.size() - 1; 
    }
    mostrarImagenActual();
    cargarid();
}




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLIMAGENES = new javax.swing.JLabel();
        Left = new javax.swing.JLabel();
        Rigth = new javax.swing.JLabel();
        idAccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMRegresar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 51, 0));
        jPanel1.setForeground(new java.awt.Color(204, 51, 0));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLIMAGENES.setText("jLabel1");
        jLIMAGENES.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jLIMAGENESMouseWheelMoved(evt);
            }
        });
        jLIMAGENES.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLIMAGENESMouseClicked(evt);
            }
        });

        Left.setFont(new java.awt.Font("Segoe UI", 0, 2)); // NOI18N
        Left.setForeground(new java.awt.Color(204, 51, 0));
        Left.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen_2025-02-16_164430090 (1).png"))); // NOI18N
        Left.setText("jLabel1");
        Left.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LeftMouseClicked(evt);
            }
        });

        Rigth.setFont(new java.awt.Font("Segoe UI", 0, 2)); // NOI18N
        Rigth.setForeground(new java.awt.Color(204, 51, 0));
        Rigth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen_2025-02-16_163044817.png"))); // NOI18N
        Rigth.setText("jLabel1");
        Rigth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RigthMouseClicked(evt);
            }
        });

        idAccion.setText("queso");

        jLabel1.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLabel1.setText("ACCIONES");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(idAccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(Left)))
                .addGap(36, 36, 36)
                .addComponent(jLIMAGENES, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(Rigth)
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(525, 525, 525))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(idAccion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rigth)
                            .addComponent(Left)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLIMAGENES, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(315, Short.MAX_VALUE))
        );

        jMenu1.setText("File");

        jMRegresar.setText("Regresar");
        jMRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMRegresarActionPerformed(evt);
            }
        });
        jMenu1.add(jMRegresar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMRegresarActionPerformed
       MenuPacienteSeleccionado Paciente = new MenuPacienteSeleccionado();
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMRegresarActionPerformed

    private void jLIMAGENESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLIMAGENESMouseClicked
        Objetos objeto = new Objetos();
        objeto.setVisible(true);
        setVisible(false);

    }//GEN-LAST:event_jLIMAGENESMouseClicked

    private void jLIMAGENESMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLIMAGENESMouseWheelMoved
           if (sliderActivo && timer != null) {
        timer.stop(); 
    }
    siguienteImagen();
    if (!sliderActivo) {
        iniciarSlider(); 
    }
               
    }//GEN-LAST:event_jLIMAGENESMouseWheelMoved

    private void LeftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeftMouseClicked
         if (sliderActivo && timer != null) {
        timer.stop(); 
    }
    siguienteImagen();
    if (!sliderActivo) {
        iniciarSlider(); 
    }
    }//GEN-LAST:event_LeftMouseClicked

    private void RigthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RigthMouseClicked
        if (sliderActivo && timer != null) {
        timer.stop(); 
    }
    anteriorImagen();
    if (!sliderActivo) {
        iniciarSlider(); 
    }
    }//GEN-LAST:event_RigthMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Left;
    private javax.swing.JLabel Rigth;
    private javax.swing.JLabel idAccion;
    private javax.swing.JLabel jLIMAGENES;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMRegresar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
