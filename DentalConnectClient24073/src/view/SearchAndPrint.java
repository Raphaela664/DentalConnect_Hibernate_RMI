/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import javax.swing.text.Document;
import model.Appointments;
import model.Users;
import service.AppointmentService;

/**
 *
 * @author admin
 */
public class SearchAndPrint extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
     Appointments searchedAppointmment = new Appointments();
    public SearchAndPrint(Appointments appointment) {
        initComponents();
        searchedAppointmment = appointment;
        addColumnToTable();
        retrieveUserAppointmentFromDBTable(searchedAppointmment);
    }
    DefaultTableModel tableModel = new DefaultTableModel();

    private SearchAndPrint() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private void addColumnToTable(){
        tableModel.addColumn("APPOINTMENT ID");
        tableModel.addColumn("PATIENT ID");
        tableModel.addColumn("DOB");
        tableModel.addColumn("GENDER");
        tableModel.addColumn("DOCTOR");
        tableModel.addColumn("APPOINTMENT TIME");
        tableModel.addColumn("APPOINTMENT DATE");
        userAppointmentmentsTable.setModel(tableModel);
        
    }
    
    private void retrieveUserAppointmentFromDBTable(Appointments appointment){
        try{
            Registry registry =  LocateRegistry.getRegistry("127.0.0.1", 5000);
           AppointmentService intrf = (AppointmentService)registry.lookup("appointment");
           Appointments FoundAppointment = new Appointments();
           FoundAppointment  = intrf.getAppointmentById(appointment);
           
            if(FoundAppointment!=null && (FoundAppointment.getAppId()).equals(appointment.getAppId())){
                 tableModel.addRow(new Object[]{
                    FoundAppointment.getAppId(),
                    FoundAppointment.getPatient_id().getId(),
                    FoundAppointment.getDate_of_birth(),
                    FoundAppointment.getGender(),
                    FoundAppointment.getDoctor_id().getDoctor_id(),
                    FoundAppointment.getAppointment_time(),
                    FoundAppointment.getAppointment_date(),
                    
                });
            }
            else{
                JOptionPane.showMessageDialog(this,"Looks like you  don't an appointment with the provided Id","Data required",JOptionPane.ERROR_MESSAGE);
                Users loggedUser = new Users();
                loggedUser.setId(appointment.getPatient_id().getId()); 
                UserDashboard dashboard = new UserDashboard(loggedUser);
                this.dispose();
                dashboard.setVisible(true);
            } 
           
            
        }catch(Exception ex){
            ex.printStackTrace();
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
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tablePanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        userAppointmentmentsTable = new javax.swing.JTable();
        PritnBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 153));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/tooth-drill.png"))); // NOI18N
        jLabel8.setText("DentalConnect");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(295, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(8, 109, 229));
        jLabel1.setText("DENTAL APPOINTMENT");

        userAppointmentmentsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        userAppointmentmentsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userAppointmentmentsTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(userAppointmentmentsTable);

        PritnBtn.setText("Print");
        PritnBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PritnBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tablePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PritnBtn)
                .addGap(201, 201, 201))
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(PritnBtn)
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(tablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userAppointmentmentsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAppointmentmentsTableMouseClicked
       
    }//GEN-LAST:event_userAppointmentmentsTableMouseClicked

    private void PritnBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PritnBtnActionPerformed
        // TODO add your handling code here:
        try{
            userAppointmentmentsTable.print();
        }catch(Exception ex){
            ex.printStackTrace();
        }
//        try {
//        // Create a file chooser to select the save location
//        JFileChooser fileChooser = new JFileChooser();
//        int result = fileChooser.showSaveDialog(this);
//
//        if (result == JFileChooser.APPROVE_OPTION) {
//            // Get the selected file
//            File file = fileChooser.getSelectedFile();
//
//            // Append the ".pdf" extension if not already present
//            if (!file.getAbsolutePath().endsWith(".pdf")) {
//                file = new File(file.getAbsolutePath() + ".pdf");
//            }
//
//            // Create a new PDF document
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(file));
//            document.open();
//
//            // Write the table data to the PDF document
//            for ( userAppointmentmentsTable data : tableData) {
//                document.add(new Paragraph(data.toString()));
//            }
//
//            // Close the PDF document
//            document.close();
//
//            // Show a success message
//            JOptionPane.showMessageDialog(this, "Table data saved as PDF successfully!");
//        }
//    } catch (IOException | DocumentException ex) {
//        ex.printStackTrace();
//        JOptionPane.showMessageDialog(this, "Error saving table data as PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//    }
    }//GEN-LAST:event_PritnBtnActionPerformed

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
            java.util.logging.Logger.getLogger(SearchAndPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchAndPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchAndPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchAndPrint.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchAndPrint().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton PritnBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel tablePanel;
    private javax.swing.JTable userAppointmentmentsTable;
    // End of variables declaration//GEN-END:variables
}
