package VISTA;

import CONTROLADOR.ServicioPersona;
import MODELO.Persona;
import javax.swing.JOptionPane;

public class ActualizarContrasenia extends javax.swing.JFrame {
Persona personactualizar = null;
    public ActualizarContrasenia(Persona person) {
        initComponents();
        cargarPersona(person);
    }

        public void cargarPersona(Persona person) {
            personactualizar = person;
            txtUsuario.setText(personactualizar.getUsuario());
            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JPanel();
        Regresar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        psfnuevoContra = new javax.swing.JPasswordField();
        psfcontraConfirmar = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Actualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(224, 98, 4));
        escritorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        escritorio.add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));

        txtUsuario.setEditable(false);
        escritorio.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 88, 165, -1));
        txtUsuario.getAccessibleContext().setAccessibleName("");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        escritorio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 91, -1, -1));
        escritorio.add(psfnuevoContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 149, -1));
        escritorio.add(psfcontraConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 149, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nueva Contrasenia");
        escritorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Confirmar Contraseña ");
        escritorio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Cambiar Contrasenia");
        escritorio.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, 40));

        Actualizar.setText("Actualizar");
        Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActualizarActionPerformed(evt);
            }
        });
        escritorio.add(Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(escritorio, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
