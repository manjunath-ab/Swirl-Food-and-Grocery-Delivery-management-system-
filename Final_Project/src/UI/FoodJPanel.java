/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.FoodItem;
import model.Order;
import model.Restaurant;
import model.UniqueID;

/**
 *
 * @author Admin
 */
public class FoodJPanel extends javax.swing.JPanel {

    /**
     * Creates new form FoodJPanel
     */
    String username;
    Restaurant r;
    String name;
    String location;
    public FoodJPanel(Restaurant r,String username,String name,String location) {
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
        
        ObjectContainer db = Db4o.openFile("fooditems.db4o");
        DefaultTableModel model= (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        FoodItem newObj=new FoodItem();
        newObj.setRestaurantid(r.getId());
        ObjectSet result = db.queryByExample(newObj);
        while (result.hasNext()) {
        FoodItem f = (FoodItem) result.next();            
            Object[] row = new Object[100];//2 members for now
            //row[0]=e.getName();
            row[0]=f;//1st column stores object names so..they get deleted
            row[1]=f.getDescription();
            row[2]=f.getPrice();
            
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
        btnPlaceOrder = new javax.swing.JButton();

        jLabel1.setText("Select Food Items");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item Name", "Description", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnPlaceOrder.setText("Order");
        btnPlaceOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlaceOrderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnPlaceOrder)
                .addGap(277, 277, 277))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69)
                .addComponent(btnPlaceOrder)
                .addContainerGap(78, Short.MAX_VALUE))
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
        FoodItem selectedItem= (FoodItem) model.getValueAt(selectedRowIndex,0);
        //db implementation for order
        ObjectContainer db = Db4o.openFile("orders.db4o");
        Order newOrder=new Order();
        newOrder.setItem(selectedItem.getName());
        newOrder.setOrderOwner(username);
        newOrder.setOwnerName(name);
        newOrder.setSourceid(selectedItem.getRestaurantid());
        newOrder.setLocation(location);
        newOrder.setOrderID(generateID());
        db.store(newOrder);
        db.commit();
        db.close();
        JOptionPane.showMessageDialog(this,"Order Placed");
    }//GEN-LAST:event_btnPlaceOrderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
