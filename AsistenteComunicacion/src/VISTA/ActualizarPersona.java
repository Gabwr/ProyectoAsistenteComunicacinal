package VISTA;

import CONTROLADOR.ServicioPersona;
import DAO.PersonaMetodos;
import MODELO.Persona;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Kathy
 */
public class ActualizarPersona extends javax.swing.JInternalFrame {
    private MenuAdministrativo menuAdmin;
     private Persona persona ;
    public ActualizarPersona(MenuAdministrativo menuAdmin, int id) {   
        initComponents();initComponents();
        persona= new ServicioPersona().getpersona(id);
        cargartutores();
        llenarCampos();
        this.menuAdmin = menuAdmin; 

    }
    
        private List<Persona> listatutores = ServicioPersona.ListaTutores();
    
    public void cargartutores(){
    DefaultComboBoxModel model = new DefaultComboBoxModel<>();
    model.addElement("Seleccionar");
        for (Persona persona : listatutores) {
            model.addElement(persona.getNombre());
        }
        cbtutores.setModel(model);
    }
    
    public void mostrarImagenDesdeBytes(byte[] imagenBytes){
    if (imagenBytes != null && imagenBytes.length > 0) {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
            BufferedImage imagenBuffer = ImageIO.read(bis);

            if (imagenBuffer != null) {
                SwingUtilities.invokeLater(() -> {
                    if (JLabelimg.getWidth() > 0 && JLabelimg.getHeight() > 0) {
                        int labelWidth = JLabelimg.getWidth();
                        int labelHeight = JLabelimg.getHeight();

                        Image imagenEscalada = imagenBuffer.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);

                        ImageIcon icono = new ImageIcon(imagenEscalada);
                        JLabelimg.setIcon(icono);
                    } else {
                        System.out.println("El JLabel aún no tiene un tamaño definido.");
                    }
                });
            } else {
                System.out.println("No se pudo convertir la imagen.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("El array de bytes está vacío o es nulo.");
    }
}

 
        public boolean comprobar(){
        if(txtnombre.getText().isEmpty()){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacio para el ingreso");
            return false;
        }else if(cbperfiles.getSelectedIndex() == 0){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "El nuevo usuario necesita asignarle un perfil para el iingreso");
            return false;
        }else if(JLabelimg.getIcon() == null){
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "Cargue una imgen para poder continuar con el ingreso");
            return false;
        }
        return true;
        }
    
    private void llenarCampos() {
        txtnombre.setText(persona.getNombre());
        cbperfiles.setSelectedIndex(persona.getIdPerfil());
        if(persona.getIdPerfil()==3){
        cbtutores.setVisible(true);
        txtselectpac.setVisible(true);
        Persona tutor;
        for(Persona comparada:listatutores){
            tutor=ServicioPersona.getTutor(persona.getIdPersona());
           if(tutor.getIdPersona()==comparada.getIdPersona()) {
               cbtutores.setSelectedItem(tutor.getNombre());
               break;
           }
        }
        }
        mostrarImagenDesdeBytes(persona.getImg());   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbperfiles = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        SubirImagen = new javax.swing.JButton();
        JLabelimg = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbtutores = new javax.swing.JComboBox<>();
        txtselectpac = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(224, 98, 4));

        jLabel1.setText("Nombre:");

        cbperfiles.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Administrador", "Tutor", "Paciente" }));
        cbperfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbperfilesActionPerformed(evt);
            }
        });

        jLabel2.setText("Perfil:");

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        SubirImagen.setText("Seleccionar Imagen");
        SubirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirImagenActionPerformed(evt);
            }
        });

        JLabelimg.setPreferredSize(new java.awt.Dimension(354, 472));
        JLabelimg.setVerifyInputWhenFocusTarget(false);

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Actualizar un Usuario");

        cbtutores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        cbtutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtutoresActionPerformed(evt);
            }
        });

        txtselectpac.setText("Seleccione un tutor para el paciente:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(btnActualizar)
                        .addGap(175, 175, 175)
                        .addComponent(btnsalir))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(SubirImagen)
                                .addGap(81, 81, 81)
                                .addComponent(JLabelimg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel2)
                                .addGap(36, 36, 36)
                                .addComponent(cbperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtselectpac)
                                .addGap(46, 46, 46)
                                .addComponent(cbtutores, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(cbperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtselectpac))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(JLabelimg, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(SubirImagen)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnActualizar)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnsalir)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubirImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubirImagenActionPerformed
javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
fileChooser.setFileFilter(new FileNameExtensionFilter("Imágenes (JPG, JPEG, PNG, GIF, BMP)", "jpg", "jpeg", "png", "gif", "bmp"));

int seleccion = fileChooser.showOpenDialog(this);
if (seleccion == javax.swing.JFileChooser.APPROVE_OPTION) {
    File archivoSeleccionado = fileChooser.getSelectedFile();
    String rutaArchivo = archivoSeleccionado.getAbsolutePath();
    System.out.println("Ruta seleccionada: " + rutaArchivo);

    try {
        Image img = ImageIO.read(archivoSeleccionado);
        if (img != null) {
            ImageIcon icono = new ImageIcon(img.getScaledInstance(JLabelimg.getWidth(), JLabelimg.getHeight(), Image.SCALE_SMOOTH));
            JLabelimg.setIcon(icono);
        } else {
            System.out.println("No se pudo leer la imagen.");
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
} else {
    System.out.println("No se seleccionó ningún archivo.");
}
    }//GEN-LAST:event_SubirImagenActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnsalirActionPerformed

        public byte[] obtenerBytes() {
    ImageIcon icono = (ImageIcon) JLabelimg.getIcon();
    Image img = icono.getImage();
    BufferedImage bufferedImage = new BufferedImage(
        img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
    bufferedImage.getGraphics().drawImage(img, 0, 0, null);
    
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
        ImageIO.write(bufferedImage, "png", baos);
        return baos.toByteArray();
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
    }
        
    public boolean soniguales(Persona person){
        if(person.getNombre().equalsIgnoreCase(persona.getNombre())&&person.getIdPerfil()==persona.getIdPerfil()
                &&person.getImg().equals(persona.getImg())){
            return true;
        }else{
            return false;
        }
    }
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
            if(comprobar()){
                Persona person= new Persona();
                person.setNombre(txtnombre.getText());
                person.setIdPerfil(cbperfiles.getSelectedIndex());
                person.setImg(obtenerBytes());
        
        if(person.getIdPerfil()==3){
        if (cbtutores.getSelectedIndex() == 0) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El nuevo usuario paciente necesita un tutor que este a su cargo");
        }else{
        if(ServicioPersona.actualizartutor(persona.getIdPersona(), tutorSeleccionado.getIdPersona())){
            JOptionPane.showMessageDialog(null, "El usuario no recibio modificaciones");
           }else if(soniguales(person)){
          JOptionPane.showMessageDialog(null, "El usuario no recibio modificaciones");  
            }else if(ServicioPersona.ActivarPersona(person)){
            JOptionPane.showMessageDialog(null, "Usuario correctamente Actualizado");
            }
        
        menuAdmin.consultarDatos();
        }
        }else{
        if(soniguales(person)){
          JOptionPane.showMessageDialog(null, "El usuario no recibio modificaciones");  
        }else if(ServicioPersona.ActualizarPersona(person)){
        JOptionPane.showMessageDialog(null, "Usuario correctamente Actualizado");
        menuAdmin.consultarDatos();
        }
        }
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed
private Persona tutorSeleccionado;
    private void cbtutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtutoresActionPerformed
        if(cbtutores.getSelectedIndex() > 0 && !ServicioPersona.getTutor(persona.getIdPersona()).getNombre().equals(cbtutores.getSelectedItem().toString())) {
            tutorSeleccionado = listatutores.get(cbtutores.getSelectedIndex() - 1);
            List<Persona> listapacientes = new ServicioPersona().ListaPacientes(tutorSeleccionado);
            if(listapacientes.size() == 3){
                JOptionPane.showMessageDialog(null, "El tutor ya tiene 3 pacientes asignados.");
                cbtutores.setSelectedIndex(0);
            }
        } else {
            tutorSeleccionado = null;
        }
    }//GEN-LAST:event_cbtutoresActionPerformed

    private void cbperfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbperfilesActionPerformed
              if(cbperfiles.getSelectedIndex()==3){
            cbtutores.setVisible(true);
            txtselectpac.setVisible(true);
        }else{
          cbtutores.setVisible(false);
          txtselectpac.setVisible(false);
        }
    }//GEN-LAST:event_cbperfilesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelimg;
    private javax.swing.JButton SubirImagen;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbperfiles;
    private javax.swing.JComboBox<String> cbtutores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JLabel txtselectpac;
    // End of variables declaration//GEN-END:variables

}
