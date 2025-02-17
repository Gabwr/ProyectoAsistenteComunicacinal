/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;

import CONTROLADOR.ObjetoServicio;
import MODELO.Objeto;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SubirImagenes extends javax.swing.JFrame {
private String rutaArchivo = null;
private int idAccion = 0;

   
    public SubirImagenes() {
        initComponents();
        cargarObjetosDesdeMongo();
       
    }
    
 private List<Objeto> cargarObjetosDesdeMongo() {
    return ObjetoServicio.CargarObjeto(); 
}
private int contarObjetos() {
    List<Objeto> objetos = cargarObjetosDesdeMongo();
    return (objetos != null) ? objetos.size() : 0; 
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCBAccion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        bttExploradorArchivos = new javax.swing.JButton();
        bttSubir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCBAccion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Comer", "Beber", "Molestia", "Baño" }));
        jCBAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBAccionActionPerformed(evt);
            }
        });

        jLabel1.setText("Suba la imagen en formato jpg");

        bttExploradorArchivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/imagen_2025-02-17_095722923.png"))); // NOI18N
        bttExploradorArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttExploradorArchivosActionPerformed(evt);
            }
        });

        bttSubir.setText("Subir");
        bttSubir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSubirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Historic", 1, 18)); // NOI18N
        jLabel2.setText("Cargar Objetos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBAccion, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(37, 37, 37)
                                .addComponent(bttExploradorArchivos, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(bttSubir)))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(35, 35, 35)
                .addComponent(jCBAccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bttExploradorArchivos)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(bttSubir)
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBAccionActionPerformed
        String accionSeleccionada = (String) jCBAccion.getSelectedItem();
    switch (accionSeleccionada) {
        case "Comer":
            idAccion = 1;
            break;
        case "Beber":
            idAccion = 2;
            break;
        case "Molestia":
            idAccion = 3;
            break;
        case "Baño":
            idAccion = 4;
            break;
        default:
            idAccion = 0;
    }
    System.out.println("Acción seleccionada: " + accionSeleccionada + " (ID: " + idAccion + ")");

    }//GEN-LAST:event_jCBAccionActionPerformed

    private void bttSubirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSubirActionPerformed
     if (rutaArchivo == null || rutaArchivo.isEmpty()) {
        System.out.println("Debe seleccionar una imagen antes de subir.");
        return;
    }
    if (idAccion == 0) {
        System.out.println("Debe seleccionar una acción válida.");
        return;
    }

    int idObjeto = contarObjetos() + 1; 
    Path rutaImagen = Paths.get(rutaArchivo).toAbsolutePath();
    
    ObjetoServicio.guardarImagenEnMongo(idAccion, idObjeto, rutaImagen.toString());
    System.out.println("Imagen subida correctamente. Nuevo ID: " + idObjeto);
    }//GEN-LAST:event_bttSubirActionPerformed

    private void bttExploradorArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttExploradorArchivosActionPerformed
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
    fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes JPG", "jpg"));

    int seleccion = fileChooser.showOpenDialog(this);
    if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
        File archivoSeleccionado = fileChooser.getSelectedFile();
        rutaArchivo = archivoSeleccionado.getAbsolutePath();
        System.out.println("Ruta seleccionada: " + rutaArchivo);
    } else {
        System.out.println("No se seleccionó ningún archivo.");
    }
    }//GEN-LAST:event_bttExploradorArchivosActionPerformed

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
            java.util.logging.Logger.getLogger(SubirImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SubirImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SubirImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SubirImagenes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SubirImagenes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttExploradorArchivos;
    private javax.swing.JButton bttSubir;
    private javax.swing.JComboBox<String> jCBAccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
