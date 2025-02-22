package VISTA;

import CONTROLADOR.ServicioPersona;
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
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class IngresoPersona extends javax.swing.JInternalFrame {
    private MenuAdministrativo menuAdmin;    
    public IngresoPersona(MenuAdministrativo menuAdmin) {  
        initComponents();
        this.menuAdmin = menuAdmin; 
        cargartutores();
        cbtutores.setVisible(false);
        txtselectpac.setVisible(false);
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
    
    private String rutaArchivo = null;


    public boolean comprobar() {
    String nombre = txtnombre.getText().trim();

    if (nombre.isEmpty()) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El campo nombre no puede estar vacío para el ingreso");
        return false;
    }
    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El nombre solo puede contener letras y espacios");
        return false;
    }
    if (nombre.length() > 40) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El nombre no puede tener más de 40 caracteres");
        return false;
    }
    if (cbperfiles.getSelectedIndex() == 0) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El nuevo usuario necesita asignarle un perfil para el ingreso");
        return false;
    }
    
    if (JLabelimg.getIcon() == null) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "Cargue una imagen para poder continuar con el ingreso");
        return false;
    }

    return true;
}

    
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbperfiles = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        Ingreso = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();
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

        Ingreso.setText("Ingresar");
        Ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresoActionPerformed(evt);
            }
        });

        Regresar.setText("Salir");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        SubirImagen.setText("Seleccionar Imagen");
        SubirImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirImagenActionPerformed(evt);
            }
        });

        JLabelimg.setPreferredSize(new java.awt.Dimension(354, 472));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Cambiar Contrasenia");

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
                        .addGap(117, 117, 117)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtselectpac)
                                .addGap(46, 46, 46)
                                .addComponent(cbtutores, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(SubirImagen))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(39, 39, 39))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Ingreso)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Regresar)
                                        .addComponent(JLabelimg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbperfiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtutores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtselectpac))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SubirImagen)
                        .addGap(87, 87, 87)
                        .addComponent(Ingreso)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLabelimg, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Regresar)
                        .addGap(20, 20, 20))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
   this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    public String crearUser(){

    String nombreCompleto = txtnombre.getText().trim();

    String[] partes = nombreCompleto.split("\\s+");

    if (partes.length < 2) {
        return "";  
    }
    
    String inicial = partes[0].substring(0, 1).toUpperCase(); 
    String apellido = partes[1].toLowerCase();
    return inicial+apellido+ServicioPersona.userExiste(inicial+apellido);
    }
    
    private void IngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresoActionPerformed
   
    if(comprobar()){
    Persona person= new Persona();
        person.setNombre(txtnombre.getText());
        person.setIdPerfil(cbperfiles.getSelectedIndex());
        person.setImg(obtenerBytes());
        person.setUsuario(crearUser());
        person.setContrasenia(ServicioPersona.encriptar(person.getUsuario()));
        person.setIdPersona(ServicioPersona.ListaPersona().size()+1);
        if(person.getIdPerfil()==3){
        if (cbtutores.getSelectedIndex() == 0) {
        Toolkit.getDefaultToolkit().beep();
        JOptionPane.showMessageDialog(null, "El nuevo usuario paciente necesita un tutor que este a su cargo");
        }else{
        if(ServicioPersona.asignartutor(person.getIdPersona(), tutorSeleccionado.getIdPersona())
                &&ServicioPersona.InsertarPersona(person)){
        JOptionPane.showMessageDialog(null, "Usuario correctamente Ingresado");
        menuAdmin.consultarDatos();
        this.dispose();
        }
        }
        
        }else{
        if(ServicioPersona.InsertarPersona(person)){
        JOptionPane.showMessageDialog(null, "Usuario correctamente Ingresado");
        menuAdmin.consultarDatos();
        this.dispose();
        }
        
        }
        
       }
    
    }//GEN-LAST:event_IngresoActionPerformed

    private void cbperfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbperfilesActionPerformed
        if(cbperfiles.getSelectedIndex()==3){
            cbtutores.setVisible(true);
            txtselectpac.setVisible(true);
        }else{
          cbtutores.setVisible(false);
          txtselectpac.setVisible(false);
        }
    }//GEN-LAST:event_cbperfilesActionPerformed

    private Persona tutorSeleccionado;
    private void cbtutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtutoresActionPerformed
    if(cbtutores.getSelectedIndex() > 0) {
        tutorSeleccionado = listatutores.get(cbtutores.getSelectedIndex() - 1);
        List<Persona> listapacientes = new ServicioPersona().ListaPacientes(tutorSeleccionado);
        if(listapacientes.size() >= 3){
            JOptionPane.showMessageDialog(null, "El tutor ya tiene 3 pacientes asignados.");
            cbtutores.setSelectedIndex(0);
            tutorSeleccionado = null; // Opcional: reiniciar la variable
        }
    } else {
        tutorSeleccionado = null;
    }
    }//GEN-LAST:event_cbtutoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Ingreso;
    private javax.swing.JLabel JLabelimg;
    private javax.swing.JButton Regresar;
    private javax.swing.JButton SubirImagen;
    private javax.swing.JComboBox<String> cbperfiles;
    private javax.swing.JComboBox<String> cbtutores;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JLabel txtselectpac;
    // End of variables declaration//GEN-END:variables
}
