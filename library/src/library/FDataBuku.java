/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package library;

import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author M Iqbal FS
 */
public class FDataBuku extends javax.swing.JFrame {

    /**
     * Creates new form FDataBuku
     */
    public FDataBuku() {
        initComponents();
        load_data();
        IDOtomatis();
        //loadJenis();
        
        BEdit.setEnabled(false);
        BDelete.setEnabled(false);
    }

    private void load_data(){
        Connection kon = koneksi.koneksiDb();
        Object header[] = {"ID BUKU", "JUDUL", "PENGARANG", "PENERBIT", "TAHUN TERBIT", "STOK", "JENIS BUKU", "HARGA"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TabelBuku.setModel(data);
        String sql_data = "SELECT * FROM tbl_buku";
        
        try{
            Statement st = kon.createStatement();
            ResultSet rs = st.executeQuery(sql_data);
            
            while(rs.next()){
                String d1 = rs.getString(1);
                String d2 = rs.getString(2);
                String d3 = rs.getString(3);
                String d4 = rs.getString(4);
                String d5 = rs.getString(5);
                String d6 = rs.getString(6);
                String d7 = rs.getString(7);
                String d8 = rs.getString(8);
                
                String d[] = {d1, d2, d3, d4, d5, d6, d7, d8};
                data.addRow(d);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void IDOtomatis(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_id = "SELECT * FROM tbl_buku order by id_buku desc";
            ResultSet rs = st.executeQuery(sql_id);
            
            if(rs.next()){
                String id_buku = rs.getString("id_buku").substring(1);
                String AN = ""+(Integer.parseInt(id_buku) + 1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "0000";
                }else if(AN.length() == 2){
                    Nol = "000";
                }else if(AN.length() == 3){
                    Nol = "00";
                }
                
                ID.setText("B"+Nol+AN);
            }else{
                ID.setText("B00001");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    /*public void loadJenis(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM tbl_buku";
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                JENISBUKU.addItem(rs.getString("jenis_buku"));
            }
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }*/
    
    private void inputData(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
            
            String date = sdr.format(TAHUNTERBIT.getDate());
            
        
            String sql = "INSERT INTO tbl_buku values('"+ID.getText()
                   +"','"+JUDUL.getText()
                   +"','"+PENGARANG.getText()
                   +"','"+PENERBIT.getText()
                   +"','"+date
                   +"','"+STOK.getText()
                   +"','"+JENISBUKU.getSelectedItem()
                    +"','"+HARGA.getText()
                   +"')";
            st.execute(sql);
            JOptionPane.showMessageDialog(null, "Data buku berhasil dimasukkan");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        JUDUL.setText("");
        PENGARANG.setText("");
        PENERBIT.setText("");
        TAHUNTERBIT.setDate(null);
        STOK.setText("");
        JENISBUKU.setSelectedItem("Fiksi");
        HARGA.setText("");
    }
    
    private void update(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
            
            String date = sdr.format(TAHUNTERBIT.getDate());
            
            String sql_update = "UPDATE tbl_buku SET judul='"+JUDUL.getText()
                +"',pengarang = '"+PENGARANG.getText()
                +"',penerbit = '"+PENERBIT.getText()
                +"',tahun_terbit = '"+date
                +"',stok = '"+STOK.getText()
                +"',jenis_buku = '"+JENISBUKU.getSelectedItem()
                +"',harga = '"+HARGA.getText()
                +"'WHERE id_buku = '"+ID.getText()+"'";
            st.execute(sql_update);
            JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void delete(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            
             String sql_delete = "DELETE from tbl_buku WHERE "
                     +"id_buku ='"+ID.getText()+"'";
             st.executeUpdate(sql_delete);
             JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }catch(Exception e){
        
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
        jLabel1 = new javax.swing.JLabel();
        kembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        PENERBIT = new javax.swing.JTextField();
        PENGARANG = new javax.swing.JTextField();
        JUDUL = new javax.swing.JTextField();
        ID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelBuku = new javax.swing.JTable();
        BInput = new javax.swing.JButton();
        BDelete = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        JENISBUKU = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        STOK = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        HARGA = new javax.swing.JTextField();
        TAHUNTERBIT = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Data Buku");

        kembali.setText("Kembali");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });

        jLabel2.setText("ID_BUKU");

        jLabel3.setText("JUDUL");

        jLabel4.setText("PENGARANG");

        jLabel5.setText("PENERBIT");

        jLabel6.setText("TAHUN TERBIT");

        jLabel7.setText("JENIS BUKU");

        PENERBIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PENERBITActionPerformed(evt);
            }
        });

        JUDUL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JUDULActionPerformed(evt);
            }
        });

        ID.setEnabled(false);

        TabelBuku.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelBukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelBuku);

        BInput.setText("Input");
        BInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInputActionPerformed(evt);
            }
        });

        BDelete.setText("Delete");
        BDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteActionPerformed(evt);
            }
        });

        BEdit.setText("Edit");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });

        JENISBUKU.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fiksi", "Non Fiksi" }));

        jLabel8.setText("STOK");

        jLabel9.setText("HARGA");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(kembali)
                                .addGap(18, 18, 18)
                                .addComponent(BInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(HARGA))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(60, 60, 60)
                            .addComponent(STOK))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JUDUL)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(JENISBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(PENGARANG)
                                .addComponent(PENERBIT)
                                .addComponent(ID)
                                .addComponent(TAHUNTERBIT, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(418, 418, 418))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(JUDUL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(PENGARANG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(PENERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(TAHUNTERBIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(STOK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(JENISBUKU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(HARGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kembali)
                            .addComponent(BInput)
                            .addComponent(BDelete)
                            .addComponent(BEdit)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
       new FUtamaPustakawan().show();
       this.dispose();
    }//GEN-LAST:event_kembaliActionPerformed

    private void JUDULActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JUDULActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JUDULActionPerformed

    private void PENERBITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PENERBITActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PENERBITActionPerformed

    private void BInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInputActionPerformed
        int simpan = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "simpan data berhasil",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,null,null
                );
        
        if(simpan == JOptionPane.YES_OPTION){
            inputData();
            load_data();
            clear();
            IDOtomatis();
        }
    }//GEN-LAST:event_BInputActionPerformed

    private void TabelBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelBukuMouseClicked
        try{
            DefaultTableModel data = (DefaultTableModel)TabelBuku.getModel();
            int bar = TabelBuku.getSelectedRow();
            
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)data.getValueAt(bar, 4).toString());
            TAHUNTERBIT.setDate(date);
            
            String a = TabelBuku.getValueAt(bar, 0).toString();
            String b = TabelBuku.getValueAt(bar, 1).toString();
            String c = TabelBuku.getValueAt(bar, 2).toString();
            String d = TabelBuku.getValueAt(bar, 3).toString();
            String f = TabelBuku.getValueAt(bar, 5).toString();
            String g = TabelBuku.getValueAt(bar, 6).toString();
            String h = TabelBuku.getValueAt(bar, 7).toString();
            
            ID.setText(a);
            JUDUL.setText(b);
            PENGARANG.setText(c);
            PENERBIT.setText(d);

            STOK.setText(f);
            if("Fiksi".equals(g)){
                JENISBUKU.setSelectedItem(g);
            }else{
                JENISBUKU.setSelectedItem(g);
            }

            HARGA.setText(h);

            BInput.setEnabled(false);
            BEdit.setEnabled(true);
            BDelete.setEnabled(true);
        }catch(ParseException e){
            
        }
    }//GEN-LAST:event_TabelBukuMouseClicked

    private void BDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteActionPerformed
       int delete = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "delete data berhasil",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,null,null
                );
        
        if(delete == JOptionPane.YES_OPTION){
            delete();
            clear();
            load_data();
            IDOtomatis();
            
            BInput.setEnabled(true);
            BEdit.setEnabled(false);
            BDelete.setEnabled(false);
        }
    }//GEN-LAST:event_BDeleteActionPerformed

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        int update = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "edit data berhasil",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,null,null
                );
        
        if(update == JOptionPane.YES_OPTION){
            update();
            clear();
            load_data();
            IDOtomatis();
            
            BInput.setEnabled(true);
            BEdit.setEnabled(false);
            BDelete.setEnabled(false);
        }
    }//GEN-LAST:event_BEditActionPerformed

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
            java.util.logging.Logger.getLogger(FDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDataBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDataBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDelete;
    private javax.swing.JButton BEdit;
    private javax.swing.JButton BInput;
    private javax.swing.JTextField HARGA;
    private javax.swing.JTextField ID;
    private javax.swing.JComboBox<String> JENISBUKU;
    private javax.swing.JTextField JUDUL;
    private javax.swing.JTextField PENERBIT;
    private javax.swing.JTextField PENGARANG;
    private javax.swing.JTextField STOK;
    private com.toedter.calendar.JDateChooser TAHUNTERBIT;
    private javax.swing.JTable TabelBuku;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    // End of variables declaration//GEN-END:variables
}
