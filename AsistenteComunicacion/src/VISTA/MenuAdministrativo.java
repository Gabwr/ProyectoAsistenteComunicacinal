package VISTA;

import CONTROLADOR.ServicioPersona;
import DAO.PersonaMetodos;
import MODELO.Perfil;
import MODELO.Persona;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class MenuAdministrativo extends javax.swing.JFrame {
       
    int fila=-1;
    private Persona person;
    private List<Persona> listapersonas = new PersonaMetodos().ListaPersona();
    
    public void consultarDatos() {
        DefaultTableModel modeloTabla = (DefaultTableModel) tbdatos.getModel();
        modeloTabla.setRowCount(0);
        String perfil="";
        for (Persona personas : listapersonas) {
            if(personas.getIdPerfil()==1){
                perfil="Administrador";
            }else if(personas.getIdPerfil()==2){
                perfil="Tutor";
            }else if(personas.getIdPerfil()==3){
                perfil="Paciente";
            }
            modeloTabla.addRow(new Object[]{personas.getIdPersona(), personas.getNombre(), 
                perfil,personas.getUsuario(), personas.getEstado()});
        }
    }
    
    public MenuAdministrativo(int id) {
        initComponents();
        consultarDatos();
        this.setLocationRelativeTo(null);
        person=new ServicioPersona().getpersona(id);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbdatos = new javax.swing.JTable();
        ingreso = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        regresar = new javax.swing.JButton();
        cambiarestado = new javax.swing.JButton();
        txtbusqueda = new javax.swing.JTextField();
        cbfiltro = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 98, 4));

        tbdatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id_Persona", "Nombre", "Perfil", "Usuario", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbdatos);

        ingreso.setText("Ingresar nueva persona");
        ingreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresoActionPerformed(evt);
            }
        });

        actualizar.setText("Actualizar Persona");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        regresar.setText("Regresar");
        regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regresarActionPerformed(evt);
            }
        });

        cambiarestado.setText("Cambiar Estado");
        cambiarestado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarestadoActionPerformed(evt);
            }
        });

        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyReleased(evt);
            }
        });

        cbfiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Filtro:", "ID", "Nombre", "Usuario", "Perfil", "Estado" }));

        jLabel21.setBackground(new java.awt.Color(51, 51, 0));
        jLabel21.setFont(new java.awt.Font("Sitka Banner", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 204));
        jLabel21.setText("Menu Administrativo de Usuarios");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ingreso)
                                .addGap(74, 74, 74)
                                .addComponent(actualizar)
                                .addGap(92, 92, 92)
                                .addComponent(cambiarestado))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtbusqueda))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jLabel21)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cambiarestado)
                    .addComponent(actualizar)
                    .addComponent(ingreso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        escritorio.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        fila = tbdatos.getSelectedRow();
        if (fila != -1) {
            
            ActualizarPersona actualizar = new ActualizarPersona(this,Integer.parseInt(tbdatos.getValueAt(fila, 0).toString()));
            escritorio.add(actualizar);
            actualizar.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la fila que desea actualizar");
        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regresarActionPerformed
    MenuIncioAdmin back = new MenuIncioAdmin(person.getIdPersona());
    back.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_regresarActionPerformed

    private void ingresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingresoActionPerformed
        // TODO add your handling code here:
        IngresoPersona ingreso = new IngresoPersona(this);
        escritorio.add(ingreso);
        ingreso.setVisible(true);
    }//GEN-LAST:event_ingresoActionPerformed

    private void cambiarestadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarestadoActionPerformed

        fila = tbdatos.getSelectedRow();
        if (fila != -1) {
            Persona nueva  = new ServicioPersona().getpersona(Integer.parseInt(tbdatos.getValueAt(fila, 0).toString()));
            if(!nueva.getEstado().equalsIgnoreCase("activo")){
                ServicioPersona.ActivarPersona(nueva);
                consultarDatos();
            }else{
                ServicioPersona.DesactivarPersona(nueva);
                consultarDatos();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione la fila que desea cambiar el estado");
        }
        
    }//GEN-LAST:event_cambiarestadoActionPerformed

    private void txtbusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyReleased
           DefaultTableModel modelo = (DefaultTableModel) tbdatos.getModel();
   
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modelo);
    tbdatos.setRowSorter(sorter);
    String text = txtbusqueda.getText().trim();
    
    int selectedIndex = cbfiltro.getSelectedIndex();
    if(text.length() == 0) {
        sorter.setRowFilter(null);
    } else {
        if(selectedIndex == 0) {
            JOptionPane.showMessageDialog(null, "Necesita seleccionar un filtro de busqueda");
        } else {
            int columnIndex = 0;
            switch(selectedIndex) {
                case 1:
                    columnIndex = 0;
                    break;
                case 2: 
                    columnIndex = 1;
                    break;
                case 3: 
                    columnIndex = 3;
                    break;
                case 4: 
                    columnIndex = 2;
                    break;
                case 5: 
                    columnIndex = 4;
                    break;
                default:
                    columnIndex = 0;
                    break;
            }
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, columnIndex));
        }
    }
    }//GEN-LAST:event_txtbusquedaKeyReleased


        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cambiarestado;
    private javax.swing.JComboBox<String> cbfiltro;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JButton ingreso;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton regresar;
    private javax.swing.JTable tbdatos;
    private javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables
}
