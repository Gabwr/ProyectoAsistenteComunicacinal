package VISTA;

import CONTROLADOR.ServicioPersona;
import MODELO.Persona;
import java.util.List;

public class MenuPacientes extends javax.swing.JFrame {

    private Persona person;
    private List<Persona> pacientes;
    public MenuPacientes(int id) {
        initComponents();
        CrearPersonas(id);
        img1.setText("");
        img2.setText("");
        img3.setText("");
        nm1.setText("");
        nm2.setText("");
        nm3.setText("");
    }
    public void CrearPersonas(int id){
        person = ServicioPersona.getpersona(id);
        pacientes = ServicioPersona.ListaPacientes(person);
        if(pacientes==null){
            return;
        }

            Paciente1Pj.setVisible(true);
        
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
        img2 = new javax.swing.JLabel();
        nm2 = new javax.swing.JLabel();
        img3 = new javax.swing.JLabel();
        nm3 = new javax.swing.JLabel();

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
        Paciente1Pj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Paciente1PjMouseClicked(evt);
            }
        });

        img1.setText("Imagen1");

        nm1.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm1.setText("Paciente 1");

        img2.setText("Imagen2");

        nm2.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm2.setText("Paciente 2");

        img3.setText("Imagen3");

        nm3.setFont(new java.awt.Font("SimSun", 0, 14)); // NOI18N
        nm3.setText("Paciente 3");

        javax.swing.GroupLayout Paciente1PjLayout = new javax.swing.GroupLayout(Paciente1Pj);
        Paciente1Pj.setLayout(Paciente1PjLayout);
        Paciente1PjLayout.setHorizontalGroup(
            Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente1PjLayout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(img1)
                .addGap(246, 246, 246)
                .addComponent(img2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(img3)
                .addGap(75, 75, 75))
            .addGroup(Paciente1PjLayout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(nm1)
                .addGap(224, 224, 224)
                .addComponent(nm3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 249, Short.MAX_VALUE)
                .addComponent(nm2)
                .addGap(61, 61, 61))
        );
        Paciente1PjLayout.setVerticalGroup(
            Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Paciente1PjLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(img3)
                    .addComponent(img2)
                    .addComponent(img1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addGroup(Paciente1PjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nm3)
                    .addComponent(nm1)
                    .addComponent(nm2))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Paciente1Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(Paciente1Pj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        MenuPacienteSeleccionado Paciente = new MenuPacienteSeleccionado();
        Paciente.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_Paciente1PjMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Paciente1Pj;
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
    // End of variables declaration//GEN-END:variables
}
