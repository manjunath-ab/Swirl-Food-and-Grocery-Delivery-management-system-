/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI;
import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import model.UserLogin;
import javax.swing.JOptionPane;
/**
 *
 * @author Admin
 */
public class RegisterJPanel extends javax.swing.JPanel {

    /**
     * Creates new form RegisterJPanel
     */
    public RegisterJPanel() {
        initComponents();
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
        btnRegister = new javax.swing.JButton();
        cbType = new javax.swing.JComboBox<>();
        txtUsername = new javax.swing.JTextField();
        txtPass = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setText("Register");

        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        cbType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Restaurant Owner", "Vendor", "Delivery Agent", "Customer", " " }));

        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });

        jLabel2.setText("User Type");

        jLabel3.setText("Username");

        jLabel4.setText("Password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(btnRegister)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(265, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPass, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(217, 217, 217))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(107, 107, 107)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(37, 37, 37)
                        .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
                .addComponent(btnRegister)
                .addGap(50, 50, 50))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        //put validation for unique username
        //and push to userlogin list
        //registration only for customer ,delivery service and restaurant
        UserLogin newUser = new UserLogin();
        ObjectContainer db = Db4o.openFile("userlogin.db4o");
        ObjectSet result = db.queryByExample(UserLogin.class);
        while (result.hasNext()) {
           UserLogin u=(UserLogin) result.next();
            try{
                if(u.getUserName().equals(txtUsername.getText())){
                JOptionPane.showMessageDialog(this,"User ID already exists");
                db.close();
                    return;
            }
            }catch (Exception e){
                
            }
           
        }
        //validation case
        if(txtUsername.getText().isEmpty()||txtPass.getText().isEmpty()){
            
            
            JOptionPane.showMessageDialog(this,"Fill in all the fields");
            db.close();
            return;
            
        }
        newUser.setUserName(txtUsername.getText());
        newUser.setPass(txtPass.getText());
        newUser.setUserType(cbType.getItemAt(cbType.getSelectedIndex()));
        db.store(newUser);
        db.commit();
        db.close();
        JOptionPane.showMessageDialog(this,"Credentials Created");
        return;
        
        
    }//GEN-LAST:event_btnRegisterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cbType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtPass;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
