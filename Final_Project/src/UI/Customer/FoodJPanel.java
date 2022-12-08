/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.Customer;

import static UI.MainJFrame.splitPane;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Restaurant.FoodItem;
import model.Order.Order;
import model.Restaurant.Restaurant;
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
    double lat;
    double longi;
    public FoodJPanel(Restaurant r,String username,String name,String location,double lat,double longi) {
        initComponents();
        this.r=r;
        this.username=username;
        this.name=name;
        this.location=location;
        this.lat=lat;
        this.longi=longi;
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
        jLabel2 = new javax.swing.JLabel();
        spinnnerQuant = new javax.swing.JSpinner();
        btnFrom = new javax.swing.JButton();

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

        jLabel2.setText("Quantity:");

        btnFrom.setText("Set Drop Location");
        btnFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFromActionPerformed(evt);
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(btnPlaceOrder))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(spinnnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(123, 123, 123)
                        .addComponent(btnFrom)))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinnnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFrom))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnPlaceOrder)
                .addGap(23, 23, 23))
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
        newOrder.setToLat(lat);
        newOrder.setToLong(longi);
        System.out.print(lat);
        System.out.print(longi);
        db.store(newOrder);
        db.commit();
        db.close();
        
        JOptionPane.showMessageDialog(this,"Order Placed");
    }//GEN-LAST:event_btnPlaceOrderActionPerformed

    private void btnFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFromActionPerformed
        // TODO add your handling code here:
        Map.PickLocation jpanel= new Map.PickLocation(r,username,name,location);
        splitPane.setRightComponent(jpanel);
        
    }//GEN-LAST:event_btnFromActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFrom;
    private javax.swing.JButton btnPlaceOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JSpinner spinnnerQuant;
    // End of variables declaration//GEN-END:variables
}
