/* 
 * Copyright 2023 Tarek Boutefara <t_boutefara@esi.dz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tarekboutefara.crud.simplejavaswing.gui;

import com.tarekboutefara.crud.simplejavaswing.main.Main;
import com.tarekboutefara.crud.simplejavaswing.model.Client;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 * The Client List Frame displays available data in the database.
 * This frame allows also the user to serach for Clients by "id" and by "name".
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class ClientListFrame extends javax.swing.JFrame {

    private List<Client> currentList;
    private ClientListModel model = new ClientListModel();

    /**
     * Creates new form Client List Frame.
     */
    public ClientListFrame() {
        initComponents();
        this.setLocationRelativeTo(null);

        currentList = Main.getAllClients();
        displayClients();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTableTitle = new javax.swing.JLabel();
        scrollTable = new javax.swing.JScrollPane();
        tblClients = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        lblId = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblSearchTitle = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        btnSearchByCode = new javax.swing.JButton();
        btnSearchByName = new javax.swing.JButton();
        btnCancelSearch = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des Clients");
        setResizable(false);

        lblTableTitle.setText("Liste des Clients");

        tblClients.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollTable.setViewportView(tblClients);

        btnClose.setText("Fermer");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        lblId.setText("Code Client :");

        lblName.setText("Nom et Prénom :");

        lblSearchTitle.setText("Recherche ");

        btnSearchByCode.setText("par Code");
        btnSearchByCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByCodeActionPerformed(evt);
            }
        });

        btnSearchByName.setText("par Nom");
        btnSearchByName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchByNameActionPerformed(evt);
            }
        });

        btnCancelSearch.setText("Annuler");
        btnCancelSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelSearchActionPerformed(evt);
            }
        });

        btnUpdate.setText("Modifier");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(scrollTable))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTableTitle)
                            .addComponent(lblSearchTitle))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblName)
                            .addComponent(lblId))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtId)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSearchByCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSearchByName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClose)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblSearchTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblId)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByCode))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchByName)
                    .addComponent(btnCancelSearch))
                .addGap(23, 23, 23)
                .addComponent(lblTableTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose)
                    .addComponent(btnUpdate))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSearchByCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByCodeActionPerformed
        try {
            int id = Integer.parseInt(txtId.getText());
            
            currentList = Main.searchByIdAsList(id);
            displayClients();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Le code doit être un nombre",
                    "Code incorrect",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSearchByCodeActionPerformed

    private void btnSearchByNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchByNameActionPerformed
        currentList = Main.searchByName(txtName.getText());
        displayClients();
    }//GEN-LAST:event_btnSearchByNameActionPerformed

    private void btnCancelSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelSearchActionPerformed
        currentList = Main.getAllClients();
        displayClients();
    }//GEN-LAST:event_btnCancelSearchActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(tblClients.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(null,
                    "Sélectionnez un client",
                    "Pas de sélection",
                    JOptionPane.ERROR_MESSAGE);
        }else{
            (new UpdateClientFrame(currentList.get(tblClients.getSelectedRow()))).setVisible(true);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelSearch;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSearchByCode;
    private javax.swing.JButton btnSearchByName;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblSearchTitle;
    private javax.swing.JLabel lblTableTitle;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JTable tblClients;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void displayClients() {
        model.setList(currentList);
        tblClients.setModel(model);
        model.fireTableDataChanged();
    }
}

class ClientListModel extends AbstractTableModel {

    List<Client> list;

    public ClientListModel() {
        list = new ArrayList<>();
    }

    public ClientListModel(List<Client> list) {
        this.list = list;
    }

    public void setList(List<Client> list) {
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int i) {
        switch (i) {
            case 0:
                return "Id";
            case 1:
                return "Last Name";
            case 2:
                return "First Name";
            case 3:
                return "Pone Number";
            case 4:
                return "Adresse";
        }

        return "";
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Client c = list.get(i);

        switch (i1) {
            case 0:
                return "" + c.getId();
            case 1:
                return c.getLastName();
            case 2:
                return c.getFirstName();
            case 3:
                return c.getPhoneNumber();
            case 4:
                return c.getAdresse();
        }

        return "";
    }

}