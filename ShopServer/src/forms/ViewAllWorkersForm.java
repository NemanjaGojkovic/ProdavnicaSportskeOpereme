/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package forms;

import controller.Controller;
import domain.Worker;
import forms.util.FormViewMode;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import tablemodels.TableModelWorker;

/**
 *
 * @author Nemanja
 */
public class ViewAllWorkersForm extends javax.swing.JFrame {
    
    private List<Worker> workers;

    
    /**
     * Creates new form ViewAllWorkersForm
     */
    public ViewAllWorkersForm(List<Worker> workers) {
        initComponents();
        this.workers=workers;
        populateForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkers = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnDetails = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Radnici");

        tblWorkers.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblWorkers);

        btnDelete.setText("Izbrisi");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnBack.setText("←");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnDetails.setText("Detalji");
        btnDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailsActionPerformed(evt);
            }
        });

        btnHelp.setText("?");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHelp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 444, Short.MAX_VALUE)
                        .addComponent(btnDetails)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnBack)
                    .addComponent(btnDetails)
                    .addComponent(btnHelp))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = tblWorkers.getSelectedRow();
            if(row==-1){
                JOptionPane.showMessageDialog(this, "Nijedan radnik nije izabran!");
                return;
            }
            TableModelWorker tmw = (TableModelWorker) tblWorkers.getModel();
            tmw.deleteWorker(row);
            JOptionPane.showMessageDialog(this, "Sistem je obrisao radnika");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obrise radnika", "Message", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailsActionPerformed
        int row=tblWorkers.getSelectedRow();
        if(row==-1){
            JOptionPane.showMessageDialog(this, "Nijedan radnik nije izabran");
            return;
        }
        TableModelWorker tmw = (TableModelWorker) tblWorkers.getModel();
        Worker worker = tmw.getWorker(row);
        WorkerForm wf = new WorkerForm(FormViewMode.VIEW_MODE, worker);
        this.setVisible(false);
        this.dispose();
        wf.setVisible(true);
    }//GEN-LAST:event_btnDetailsActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        JOptionPane.showMessageDialog(this, "Ovo je forma za prikaz svih radnika!\n"
                + "U tabeli su prikazani svi radnici i njihovi podaci.\n"
                + "Ukoliko zelite da izaberete nekog radnika i prikazete njegove podatke\n"
                + "selektujte ga u tabeli i zatim kliknite dugme detalji. Ukoliko zelite da ga\n"
                + "obrisete iz sistema, postupak je isti samo se klikne dugme izbrisi.");
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnDetails;
    private javax.swing.JButton btnHelp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblWorkers;
    // End of variables declaration//GEN-END:variables

    private void populateForm() {
        TableModelWorker tmw = new TableModelWorker(workers);
        tblWorkers.setModel(tmw);
        
    }
}
