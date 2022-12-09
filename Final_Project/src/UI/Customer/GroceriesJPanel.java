/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Customer;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Vendor.Grocery;
import model.Vendor.GroceryStall;
import model.Order.Order;
import model.UniqueID;

/**
 *
 * @author Admin
 */
public class GroceriesJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GroceriesJPanel
     */
    String username;
    GroceryStall r;
    String name;
    String location;
    public GroceriesJPanel(GroceryStall r,String username,String name,String location) {
        initComponents();
        this.r=r;
        this.username=username;
        this.name=name;
        this.location=location;
        populateTable();
    }
    private int generateID(){
        // create instance of Random class
        Random rand = new Random();
        ObjectContainer db = Db4o.openFile("uniqueid.db4o");
        // Generate random integers in range 0 to 999
        int rand_int = rand.nextInt(1000);
        ObjectSet result = db.queryByExample(UniqueID.class);
        while (result.hasNext()) {
           UniqueID u=(UniqueID) result.next();
           if(rand_int==u.getId()){
               generateID();
           }      
        }
        UniqueID uid=new UniqueID();
        uid.setId(rand_int);
        db.store(uid);
        db.commit();
        db.close();
        return rand_int;
    }
    private void populateTable(){
        
        ObjectContainer db = Db4o.openFile("groceries.db4o");
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        Grocery newObj=new Grocery();
        newObj.setStallid(r.getId());
        ObjectSet result = db.queryByExample(newObj);
        while (result.hasNext()) {
        Grocery f = (Grocery) result.next();            
            Object[] row = new Object[100];//2 members for now
            //row[0]=e.getName();
            row[0]=f;//1st column stores object names so..they get deleted
            row[1]=f.getPrice();
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnPlaceOrder = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        spinnerQuant = new javax.swing.JSpinner();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 51));

        jTable1.setBackground(new java.awt.Color(128, 128, 128));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Produce", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnPlaceOrder.setBackground(new java.awt.Color(0, 102, 204));
        btnPlaceOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnPlaceOrder.setText("Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Quantity:");

        jPanel1.setBackground(new java.awt.Color(77, 0, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Select Groceries");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(331, 331, 331)
                .addComponent(jLabel1)
                .addContainerGap(440, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(spinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(69, 69, 69)
                                .addComponent(btnPlaceOrder)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnPlaceOrder))
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlaceOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlaceOrderActionPerformed
        // TODO add your handling code here:
        int selectedRowIndex = jTable1.getSelectedRow();
        
        if (selectedRowIndex<0){
            JOptionPane.showMessageDialog(this,"Please select an item");
            return;
        }
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        //getting the whole object to manipulate
        Grocery selectedItem= (Grocery) model.getValueAt(selectedRowIndex,0);
        //db implementation for order
        ObjectContainer db = Db4o.openFile("orders.db4o");
        Order newOrder=new Order();
        newOrder.setItem(selectedItem.getName());
        newOrder.setOrderOwner(username);
        newOrder.setOwnerName(name);
        newOrder.setSourceid(selectedItem.getStallid());
        newOrder.setOrderID(generateID());
        newOrder.setLocation(location);
        db.store(newOrder);
        db.commit();
        db.close();
        JOptionPane.showMessageDialog(this,"Order Placed");
    }//GEN-LAST:event_btnPlaceOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spinnerQuant;
    // End of variables declaration//GEN-END:variables
}
