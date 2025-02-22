package VISTA;

import CONTROLADOR.ServicioPersona;
import MODELO.Persona;
import javax.swing.JOptionPane;

public class ActualizarContrasenia extends javax.swing.JFrame {
Persona personactualizar = null;
    public ActualizarContrasenia(Persona person) {
        initComponents();
        cargarPersona(person);
        this.setLocationRelativeTo(null);
    }

        public void cargarPersona(Persona person) {
            personactualizar = person;
            txtUsuario.setText(personactualizar.getUsuario());
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        psfnuevoContra = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        psfcontraConfirmar = new javax.swing.JPasswordField();
        Actualizar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(224, 98, 4));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Cambiar Contrasenia");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");

        txtUsuario.setEditable(false);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva Contrasenia");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirmar Contraseña ");

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, escritorioLayout.createSequentialGroup()
                .addContainerGap(37, Short.MAX_VALUE)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1)
                        .addGap(26, 26, 26)
                        .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(psfnuevoContra, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(psfcontraConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(Actualizar)
                        .addGap(78, 78, 78)
                        .addComponent(Regresar)))
                .addContainerGap())
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(escritorioLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(psfnuevoContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(psfcontraConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Actualizar)
                    .addComponent(Regresar))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        txtUsuario.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed

        Login log = new Login();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_RegresarActionPerformed

    private void ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActualizarActionPerformed
        if (!psfcontraConfirmar.getText().equals(psfnuevoContra.getText())&&!psfnuevoContra.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no son iguales");
        } else {
            int resultado = JOptionPane.showConfirmDialog(null, "¿Esta segúro de actualizar la clave?", "Actualizar", JOptionPane.YES_NO_OPTION);
            if (resultado == JOptionPane.YES_OPTION) {
                String contraseniaEncritada = ServicioPersona.encriptar(psfnuevoContra.getText());
                if( ServicioPersona.ActualizarContrasenia(contraseniaEncritada, personactualizar))
                {JOptionPane.showMessageDialog(null, "Contrasena Actualizada");
                Login log = new Login();
                log.setVisible(true);
            }
            }
        }
    }//GEN-LAST:event_ActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Actualizar;
    private javax.swing.JButton Regresar;
    private javax.swing.JPanel escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField psfcontraConfirmar;
    private javax.swing.JPasswordField psfnuevoContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
