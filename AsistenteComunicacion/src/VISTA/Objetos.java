/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTA;
import CONTROLADOR.AccionServicio;
import MODELO.Objeto;
import AppPackage.AnimationClass;
import CONTROLADOR.ObjetoServicio;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Objetos extends javax.swing.JFrame {

  private List<Objeto> objetos = null;
    private int indiceActual = 0;
    private Timer timer;
    private boolean sliderActivo = true;
    int _iddAccion = 0;
    
    public Objetos() {
        _iddAccion = Acciones._idAccion; 
        initComponents();
        this.setLocationRelativeTo(null);
        cargarObjetos(); 
        mostrarImagenActual(); 
        cargarid();
        IdAccion.setText(String.valueOf(_iddAccion));
        IdAccion.setVisible(false);
    }
    private void cargarObjetos() {
  
    if (objetos == null) {
        objetos = new ArrayList<>(); 
    }
    
    objetos = ObjetoServicio.CargarObjetosPorAccion(_iddAccion); 
}


  private void mostrarImagenActual() {
    if (objetos != null && !objetos.isEmpty() && indiceActual >= 0 && indiceActual < objetos.size()) {
        try {
            Objeto objetoActual = objetos.get(indiceActual);
            String nombreObjeto = objetoActual.getObjetoNombre();
            
            System.out.println("Nombre obtenido: " + nombreObjeto); // Verificar si el nombre llega

            if (nombreObjeto != null && !nombreObjeto.trim().isEmpty()) {
                jLNombreObj.setText(nombreObjeto); // Asignar el nombre al JLabel
            } else {
                System.out.println("No se encontró un nombre para la imagen.");
                jLNombreObj.setText("Nombre no disponible");
            }

            byte[] imagenBytes = objetoActual.getImagen();
            if (imagenBytes != null && imagenBytes.length > 0) {
                System.out.println("Cargando imagen...");
                ByteArrayInputStream bis = new ByteArrayInputStream(imagenBytes);
                Image img = ImageIO.read(bis);
                if (img == null) {
                    System.out.println("Error al leer la imagen.");
                } else {
                    ImageIcon icon = new ImageIcon(img.getScaledInstance(jLIMAGENES.getWidth(), jLIMAGENES.getHeight(), Image.SCALE_SMOOTH));
                    jLIMAGENES.setIcon(icon);
                }
            } else {
                System.out.println("No se encontraron datos de imagen.");
            }
        } catch (IOException e) {
            System.out.println("Error al leer la imagen.");
            e.printStackTrace();
        }
    } else {
        System.out.println("No hay objetos disponibles o índice fuera de rango.");
    }
}





    private void cargarid() {
        if (objetos != null && !objetos.isEmpty() && indiceActual >= 0 && indiceActual < objetos.size()) {
            Objeto objetoActual = objetos.get(indiceActual);
            int idObjeto = objetoActual.getIdObjeto(); // Obtener idObjeto
            if (idObjeto > 0) {
                
                _iddAccion = idObjeto;
            } else {
                
                _iddAccion = -1;
            }
            System.out.println("ID Actual: " + _iddAccion);
        }
    }

    private void iniciarSlider() {
        timer = new Timer(3000, new ActionListener() { // Cada 3 segundos
            @Override
            public void actionPerformed(ActionEvent e) {
                if (indiceActual < objetos.size() - 1) {
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
        if (indiceActual < objetos.size() - 1) {
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
            indiceActual = objetos.size() - 1;
        }
        mostrarImagenActual();
        cargarid();
    }
private void mostrarDatosObjeto(Objeto objeto) {
    
    jLNombreObj.setText(objeto.getObjetoNombre());
   
    if (objeto.getImagen() != null && objeto.getImagen().length > 0) {
        ImageIcon icon = new ImageIcon(objeto.getImagen());
        Image imagen = icon.getImage().getScaledInstance(jLIMAGENES.getWidth(), jLIMAGENES.getHeight(), Image.SCALE_SMOOTH);
        jLIMAGENES.setIcon(new ImageIcon(imagen));
    } else {
        jLIMAGENES.setIcon(null); 
    }
}

    
       
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLIMAGENES = new javax.swing.JLabel();
        Left = new javax.swing.JLabel();
        Rigth = new javax.swing.JLabel();
        IdAccion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        regresar = new javax.swing.JButton();
        jLNombreObj = new javax.swing.JLabel();
        jTBuscarObjeto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMRegresar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

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

        jLabel1.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLabel1.setText("Objetos");

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        jLNombreObj.setFont(new java.awt.Font("Serif", 2, 36)); // NOI18N
        jLNombreObj.setText("Objetos");

        jTBuscarObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTBuscarObjetoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 2, 14)); // NOI18N
        jLabel2.setText("Buscar objeto por Nombre");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(Left)
                .addGap(36, 36, 36)
                .addComponent(jLIMAGENES, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Rigth)
                    .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(IdAccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLNombreObj, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTBuscarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(207, 207, 207))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(IdAccion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNombreObj)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTBuscarObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Rigth)
                            .addComponent(Left))
                        .addGap(104, 104, 104)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        Acciones Accion = new Acciones();
        Accion.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jMRegresarActionPerformed

    private void jLIMAGENESMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jLIMAGENESMouseWheelMoved
        if (sliderActivo && timer != null) {
            timer.stop();
        }
        siguienteImagen();
        if (!sliderActivo) {
            iniciarSlider();
        }

    }//GEN-LAST:event_jLIMAGENESMouseWheelMoved

    private void jLIMAGENESMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLIMAGENESMouseClicked
        
    }//GEN-LAST:event_jLIMAGENESMouseClicked

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

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
        Acciones Accion = new Acciones();
        Accion.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_regresarActionPerformed

    private void jTBuscarObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTBuscarObjetoActionPerformed
        // Obtener el texto ingresado en el campo de búsqueda
   
    }//GEN-LAST:event_jTBuscarObjetoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreObjeto = jTBuscarObjeto.getText().trim();
    

    // Verificar que no esté vacío
    if (!nombreObjeto.isEmpty()) {
        Objeto objetoEncontrado = ObjetoServicio.buscarObjetoPorNombre(Acciones._idAccion, nombreObjeto);
        
        if (objetoEncontrado != null) {
            mostrarDatosObjeto(objetoEncontrado);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró el objeto con el nombre: " + nombreObjeto);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Ingrese un nombre de objeto para buscar.");
    }
    }//GEN-LAST:event_jButton1ActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IdAccion;
    private javax.swing.JLabel Left;
    private javax.swing.JLabel Rigth;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLIMAGENES;
    private javax.swing.JLabel jLNombreObj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuItem jMRegresar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTBuscarObjeto;
    private javax.swing.JButton regresar;
    // End of variables declaration//GEN-END:variables
}
