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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * The main frame of the application.
 * Following the MVC architecture, this class ensure the display of different
 * menus (actions).
 * @author Tarek Boutefara <t_boutefara@esi.dz>
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame.
     * The default size is maximazed.
     */
    public MainFrame() {
        initComponents();

        setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        exitMenuItem = new javax.swing.JMenuItem();
        clientMenu = new javax.swing.JMenu();
        newClientMenuItem = new javax.swing.JMenuItem();
        allClientsMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        quickSearchMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion des Clients");

        fileMenu.setText("Fichier");

        exitMenuItem.setText("Quitter");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        clientMenu.setText("Clients");

        newClientMenuItem.setText("Nouveau Client");
        newClientMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClientMenuItemActionPerformed(evt);
            }
        });
        clientMenu.add(newClientMenuItem);

        allClientsMenuItem.setText("Tous les Clients");
        allClientsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allClientsMenuItemActionPerformed(evt);
            }
        });
        clientMenu.add(allClientsMenuItem);
        clientMenu.add(jSeparator1);

        quickSearchMenuItem.setText("Recherche rapide (par Code)");
        quickSearchMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickSearchMenuItemActionPerformed(evt);
            }
        });
        clientMenu.add(quickSearchMenuItem);

        menuBar.add(clientMenu);

        helpMenu.setText("Aide");

        aboutMenuItem.setText("A Propos");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        Main.exit();
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        JOptionPane.showMessageDialog(null,
                "Gestion des Client, exemple CRUD, v 0.0.1",
                "A Propos",
                JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void newClientMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClientMenuItemActionPerformed
        (new NewClientFrame()).setVisible(true);
    }//GEN-LAST:event_newClientMenuItemActionPerformed

    private void allClientsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allClientsMenuItemActionPerformed
        (new ClientListFrame()).setVisible(true);
    }//GEN-LAST:event_allClientsMenuItemActionPerformed

    private void quickSearchMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickSearchMenuItemActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                null,
                "Code Client :",
                "recherche par Code",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "1");
        System.out.println(s);
        
        if (s != null) {
            try {
                int code = Integer.parseInt(s);
                
                Client c = Main.SearchById(code);
                if(c == null){
                    JOptionPane.showMessageDialog(null,
                        "Aucun client ne porte le code donné.",
                        "Code incorrect",
                        JOptionPane.ERROR_MESSAGE);
                }else{
                    (new UpdateClientFrame(c)).setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Le code doit être un nombre",
                        "Code incorrect",
                        JOptionPane.ERROR_MESSAGE);
                
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_quickSearchMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JMenuItem allClientsMenuItem;
    private javax.swing.JMenu clientMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newClientMenuItem;
    private javax.swing.JMenuItem quickSearchMenuItem;
    // End of variables declaration//GEN-END:variables
}