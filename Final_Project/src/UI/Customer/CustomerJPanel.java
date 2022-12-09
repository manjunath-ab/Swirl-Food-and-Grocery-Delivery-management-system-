/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Customer;

import UI.MainJFrame;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Vendor.GroceryStall;
import model.Restaurant.Restaurant;

/**
 *
 * @author Admin
 */
public class CustomerJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerJPanel
     */
    String username;
    String location;
    String name;
    public CustomerJPanel(String u,String name,String location) {
        initComponents();
        this.username=u;
        this.name=name;
        this.location=location;
        populateRandW();
        populateVendor();
    }
    private void populateRandW(){
        //need to put in code for warehouses later
        ObjectContainer db = Db4o.openFile("restaurant.db4o");
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Restaurant newObj=new Restaurant();
        newObj.setLocation(location);
        ObjectSet result = db.queryByExample(newObj);
        while (result.hasNext()) {
        Restaurant r = (Restaurant) result.next();            
            Object[] row = new Object[100];//2 members for now
            //row[0]=e.getName();
            row[0]=r;//1st column stores object names so..they get deleted
            row[1]=r.getCuisine();
            row[2]=r.getType();
            
            model.addRow(row);
            
        }
        db.close();
    }
    private void populateVendor(){
        ObjectContainer db = Db4o.openFile("grocerystall.db4o");
        DefaultTableModel model= (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        GroceryStall newObj=new GroceryStall();
        newObj.setLocation(location);
        ObjectSet result = db.queryByExample(newObj);
        while (result.hasNext()) {
        GroceryStall g = (GroceryStall) result.next();            
            Object[] row = new Object[100];//2 members for now
            //row[0]=e.getName();
            row[0]=g;//1st column stores object names so..they get deleted
            
            
            model.addRow(row);
            
        }
        db.close();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnfood = new javax.swing.JButton();
        btnGroceries = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        btnfood1 = new javax.swing.JButton();
        btnGroceries1 = new javax.swing.JButton();

        jLabel1.setText("Customer Panel");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Cuisine", "Type"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Grocery Stalls"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        btnfood.setText("Select");
        btnfood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfoodActionPerformed(evt);
            }
        });

        btnGroceries.setText("Select");
        btnGroceries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroceriesActionPerformed(evt);
            }
        });

        jLabel2.setText("Customer Panel");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Cuisine", "Type"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Grocery Stalls"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        btnfood1.setText("Select");
        btnfood1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfood1ActionPerformed(evt);
            }
        });

        btnGroceries1.setText("Select");
        btnGroceries1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGroceries1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnfood1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGroceries1)
                .addGap(175, 175, 175))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGroceries1)
                    .addComponent(btnfood1))
                .addContainerGap(143, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnfood)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGroceries)
                .addGap(175, 175, 175))
            .addGroup(layout.createSequentialGroup()
                .addGap(319, 319, 319)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGroceries)
                    .addComponent(btnfood))
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnfoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfoodActionPerformed
        // TODO add your handling code here:
        //takes u to food jpanel
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select a Restaurant");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        //getting the whole object to manipulate
        Restaurant selectedRestaurant= (Restaurant) model.getValueAt(selectedRowIndex,0);
        //figure a way to properly link menu per restaurant model
        
        //code to move to next JPanel
        //SearchJPanel1 searchJPanel1=new SearchJPanel1(selectedCommunity);
        //searchJPanel1.setVisible(true);
        //ObjectContainer db = Db4o.openFile("restaurant.db4o");
        //db1.close();
        FoodJPanel fPanel=new FoodJPanel(selectedRestaurant,username,name,location,0,0);
        MainJFrame.splitPane.setRightComponent(fPanel);
        
        
    }//GEN-LAST:event_btnfoodActionPerformed

    private void btnGroceriesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroceriesActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable2.getSelectedRow();
        
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select a stall");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) jTable2.getModel();
        //getting the whole object to manipulate
        GroceryStall selectedStall=(GroceryStall) model.getValueAt(selectedRowIndex,0);
        //figure a way to properly link menu per restaurant model
        
        //code to move to next JPanel
        //SearchJPanel1 searchJPanel1=new SearchJPanel1(selectedCommunity);
        //searchJPanel1.setVisible(true);
        //ObjectContainer db = Db4o.openFile("restaurant.db4o");
        //db1.close();
        GroceriesJPanel fPanel=new GroceriesJPanel(selectedStall,username,name,location);
        MainJFrame.splitPane.setRightComponent(fPanel);
    }//GEN-LAST:event_btnGroceriesActionPerformed

    private void btnfood1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfood1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfood1ActionPerformed

    private void btnGroceries1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGroceries1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGroceries1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGroceries;
    private javax.swing.JButton btnGroceries1;
    private javax.swing.JButton btnfood;
    private javax.swing.JButton btnfood1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    // End of variables declaration//GEN-END:variables
}
