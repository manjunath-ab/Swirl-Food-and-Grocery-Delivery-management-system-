/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.CustomerService;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Query;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Order.Order;
import Map.ViewMap;
import static UI.MainJFrame.splitPane;
import com.db4o.query.Constraint;

/**
 *
 * @author smrithijagithyala
 */
public class CustomerServiceJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerServiceJPanel
     */
    
    public CustomerServiceJPanel() {
        initComponents();
        populateTable();
    }
    
     private void populateTable(){
        ObjectContainer db = Db4o.openFile("orders.db4o");
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Query query = db.query();
        query.constrain(Order.class);
        Constraint constr = query.descend("status").constrain("Query");
        //query.descend("orderOwner").constrain("Queiry").and(constr);
        ObjectSet result=query.execute();
        while (result.hasNext()) {
        Order f = (Order) result.next();            
            Object[] row = new Object[1000];//2 members for now
            //row[0]=e.getName();
            //1st column stores object names so..they get deleted
            row[0]=f.getOrderID();
            row[2]=f.getStatus();
            row[1]=f;
            //row[3]=f.getLocation();
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
        btnResolve = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAgent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtItem = new javax.swing.JTextField();

        jLabel1.setText("Customer Service");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Order ID", "Item", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnResolve.setText("Resolve");
        btnResolve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolveActionPerformed(evt);
            }
        });

        jButton1.setText("Get Details");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Name on Order:");

        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        jLabel3.setText("Delivery Agent:");

        jLabel4.setText("Item Name:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(231, 231, 231)
                        .addComponent(btnResolve)
                        .addGap(94, 94, 94)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(133, 133, 133)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                            .addComponent(txtAgent))
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addGap(41, 41, 41)
                        .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolve)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnResolveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolveActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select an order");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        //getting the whole object to manipulate
        Order selectedOrder= (Order) model.getValueAt(selectedRowIndex,1);
        //modify data of the object in the db
        ObjectContainer db = Db4o.openFile("orders.db4o");
        ObjectSet result = db.queryByExample(selectedOrder);
        selectedOrder=(Order)result.next();
        //print message delivery is started then poulate table 
        selectedOrder.setStatus("Resolved");
        db.store(selectedOrder);
        db.commit();
        db.close();
        JOptionPane.showMessageDialog(this,"Query Resolved");
        populateTable();
        
    }//GEN-LAST:event_btnResolveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select an order");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        //getting the whole object to manipulate
        Order selectedOrder= (Order) model.getValueAt(selectedRowIndex,1);
        //modify data of the object in the db
        ObjectContainer db = Db4o.openFile("orders.db4o");
        ObjectSet result = db.queryByExample(selectedOrder);
        selectedOrder=(Order)result.get(0);
        txtName.setText(selectedOrder.getOwnerName());
        txtItem.setText(selectedOrder.getItem());
        txtAgent.setText(selectedOrder.getDagent());
        db.close();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResolve;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtAgent;
    private javax.swing.JTextField txtItem;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
