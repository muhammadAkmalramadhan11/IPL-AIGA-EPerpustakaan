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

/**
 *
 * @author M Iqbal FS
 */
public class FDataAnggota extends javax.swing.JFrame {

    /**
     * Creates new form FDataAnggota
     */
    public FDataAnggota() {
        initComponents();
        load_data();
        IDOtomatis();
        LoadTingkat();
        LoadJurusan();
        LoadKelas();
        
        BEdit.setEnabled(false);
        BDelete.setEnabled(false);
    }

    private void load_data(){
        Connection kon = koneksi.koneksiDb();
        Object header[] = {"ID ANGGOTA","NIS","NAMA ANGGOTA","JK","TINGKAT","JURUSAN","KELAS","NO HP","STATUS"};
        DefaultTableModel data = new DefaultTableModel(null, header);
        TabelAnggota.setModel(data);
        String sql_data = "SELECT * FROM tbl_anggota";
        
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
                String d9 = rs.getString(9);
                
                String d[] = {d1, d2, d3, d4, d5, d6, d7, d8, d9};
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
            String sql_id = "SELECT * FROM tbl_anggota order by id_anggota desc";
            ResultSet rs = st.executeQuery(sql_id);
            
            if(rs.next()){
                String id_anggota = rs.getString("id_anggota").substring(1);
                String AN = ""+(Integer.parseInt(id_anggota) + 1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "0000";
                }else if(AN.length() == 2){
                    Nol = "000";
                }else if(AN.length() == 3){
                    Nol = "00";
                }
                ID.setText("A"+Nol+AN);
            }else{
                ID.setText("A00001");
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void LoadTingkat(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT * FROM tbl_tingkat";
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                KTINGKAT.addItem(rs.getString("id_tingkat"));
            }
            rs.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void NamaTingkat(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT tingkat FROM tbl_tingkat WHERE id_tingkat ='"+KTINGKAT.getSelectedItem();
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                NTINGKAT.setText(rs.getString("	tingkat"));
            }
        }catch(Exception e){
        
        }
    }
    
    public void LoadJurusan(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT kd_jurusan FROM tbl_jurusan";
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                KJURUSAN.addItem(rs.getString("kd_jurusan"));
            }
            rs.close();
        }catch(Exception e){
        
        }
    }
    
    public void NamaJurusan(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT jurusan FROM tbl_jurusan WHERE kd_jurusan ='"+KJURUSAN.getSelectedItem();
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                NJURUSAN.setText(rs.getString("jurusan"));
            }
        }catch(Exception e){
        
        }
    }
    
    public void LoadKelas(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String sql_tingkat = "SELECT id_kelas FROM tbl_kelas";
            ResultSet rs = st.executeQuery(sql_tingkat);
            
            while(rs.next()){
                KKELAS.addItem(rs.getString("id_kelas"));
            }
            rs.close();
        }catch(Exception e){
        
        }
    }
    
    private void input_data(){
        try{
           Connection kon = koneksi.koneksiDb();
           Statement st = kon.createStatement();
           String jk = "";
           
           if(JKP.isSelected()){
               jk = JKP.getText();
           }else{
               jk = JKW.getText();
           }
           
           String sql = "INSERT INTO tbl_anggota values('"+ID.getText()
                   +"','"+NIS.getText()
                   +"','"+NAMA.getText()
                   +"','"+jk
                   +"','"+KTINGKAT.getSelectedItem()
                   +"','"+KJURUSAN.getSelectedItem()
                   +"','"+KKELAS.getSelectedItem()
                   +"','"+NOPE.getText()
                   +"','"+STATUS.getSelectedItem()
                   +"')";
           st.execute(sql);
           JOptionPane.showMessageDialog(null, "Data anggota berhasil dimasukkan");
                   
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clear(){
        NIS.setText("");
        NAMA.setText("");
        NOPE.setText("");
        JKP.setSelected(rootPaneCheckingEnabled);
        KTINGKAT.setSelectedItem(1);
        KJURUSAN.setSelectedItem("FAR");
        KKELAS.setSelectedItem(1);
        STATUS.setSelectedItem("AKTIF");
    }
    
    private void update(){
        try{
            Connection kon = koneksi.koneksiDb();
            Statement st = kon.createStatement();
            String jk = "";
            
            if(JKP.isSelected()){
                jk = JKP.getText();
            }else{
                jk = JKW.getText();
            }
            
            String sql_update = "UPDATE tbl_anggota SET nis='"+NIS.getText()
                +"',nama = '"+NAMA.getText()
                +"',jk = '"+jk  
                +"',id_tingkat = '"+KTINGKAT.getSelectedItem()
                +"',kd_jurusan = '"+KJURUSAN.getSelectedItem()
                +"',id_kelas = '"+KKELAS.getSelectedItem()
                +"',nope = '"+NOPE.getText()
                +"',status = '"+STATUS.getSelectedItem()
                +"'WHERE id_anggota = '"+ID.getText()+"'";
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
            
            String sql_delete = "DELETE from tbl_anggota WHERE "
                    +"id_anggota ='"+ID.getText()+"'";

            st.executeUpdate(sql_delete);
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak berhasil dihapus");
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

        JK = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BKeluar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ID = new javax.swing.JTextField();
        NIS = new javax.swing.JTextField();
        NAMA = new javax.swing.JTextField();
        JKP = new javax.swing.JRadioButton();
        JKW = new javax.swing.JRadioButton();
        KTINGKAT = new javax.swing.JComboBox<>();
        KJURUSAN = new javax.swing.JComboBox<>();
        KKELAS = new javax.swing.JComboBox<>();
        NOPE = new javax.swing.JTextField();
        STATUS = new javax.swing.JComboBox<>();
        NTINGKAT = new javax.swing.JTextField();
        NJURUSAN = new javax.swing.JTextField();
        BInput = new javax.swing.JButton();
        BEdit = new javax.swing.JButton();
        BDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelAnggota = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Kelola Data Anggota Pustakawan");

        BKeluar.setText("Keluar");
        BKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BKeluarActionPerformed(evt);
            }
        });

        jLabel2.setText("ID_ANGGOTA");

        jLabel3.setText("NIS");

        jLabel4.setText("NAMA ANGGOTA");

        jLabel5.setText("JENIS KELAMIN");

        jLabel6.setText("TINGKAT");

        jLabel7.setText("JURUSAN");

        jLabel8.setText("KELAS");

        jLabel9.setText("NO HP");

        jLabel10.setText("STATUS");

        ID.setEnabled(false);
        ID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDActionPerformed(evt);
            }
        });

        JK.add(JKP);
        JKP.setText("PRIA");

        JK.add(JKW);
        JKW.setText("WANITA");
        JKW.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JKWActionPerformed(evt);
            }
        });

        KTINGKAT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                KTINGKATMouseClicked(evt);
            }
        });
        KTINGKAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KTINGKATActionPerformed(evt);
            }
        });

        KJURUSAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KJURUSANActionPerformed(evt);
            }
        });

        STATUS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AKTIF", "PASIF" }));

        NTINGKAT.setEditable(false);
        NTINGKAT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NTINGKATActionPerformed(evt);
            }
        });

        NJURUSAN.setEditable(false);

        BInput.setText("Input");
        BInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BInputActionPerformed(evt);
            }
        });

        BEdit.setText("Edit");
        BEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BEditActionPerformed(evt);
            }
        });

        BDelete.setText("Delete");
        BDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BDeleteActionPerformed(evt);
            }
        });

        TabelAnggota.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelAnggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelAnggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelAnggota);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(BKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(KTINGKAT, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(NTINGKAT))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(JKP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(JKW, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(NAMA)
                        .addComponent(NIS)
                        .addComponent(ID)
                        .addComponent(NOPE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(KKELAS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(KJURUSAN, javax.swing.GroupLayout.Alignment.LEADING, 0, 64, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(NJURUSAN)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(STATUS, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(413, 413, 413))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(NIS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(NAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(JKP)
                            .addComponent(JKW))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(KTINGKAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NTINGKAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(KJURUSAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NJURUSAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(KKELAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NOPE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(STATUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BKeluar)
                            .addComponent(BInput)
                            .addComponent(BEdit)
                            .addComponent(BDelete)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BKeluarActionPerformed
        int keluar;
        
        keluar = JOptionPane.showOptionDialog(this,
                "keluar dari kelola data anggota?",
                "exit",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
        
        if(keluar == JOptionPane.YES_NO_OPTION){
            new FUtamaPustakawan().show();
            this.dispose();
        }
    }//GEN-LAST:event_BKeluarActionPerformed

    private void JKWActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JKWActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JKWActionPerformed

    private void NTINGKATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NTINGKATActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NTINGKATActionPerformed

    private void KTINGKATMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KTINGKATMouseClicked
       
    }//GEN-LAST:event_KTINGKATMouseClicked

    private void KTINGKATActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KTINGKATActionPerformed
        NamaTingkat();
    }//GEN-LAST:event_KTINGKATActionPerformed

    private void KJURUSANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KJURUSANActionPerformed
        NamaJurusan();
    }//GEN-LAST:event_KJURUSANActionPerformed

    private void BInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BInputActionPerformed
        int simpan = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "simpan data",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,null,null,null
                );
        
        if(simpan == JOptionPane.YES_OPTION){
            input_data();
            load_data();
            clear();
            IDOtomatis();
        }
        
    }//GEN-LAST:event_BInputActionPerformed

    private void TabelAnggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelAnggotaMouseClicked
        int bar = TabelAnggota.getSelectedRow();
        String a = TabelAnggota.getValueAt(bar, 0).toString();
        String b = TabelAnggota.getValueAt(bar, 1).toString();
        String c = TabelAnggota.getValueAt(bar, 2).toString();
        String d = TabelAnggota.getValueAt(bar, 3).toString();
        String e = TabelAnggota.getValueAt(bar, 4).toString();
        String f = TabelAnggota.getValueAt(bar, 5).toString();
        String g = TabelAnggota.getValueAt(bar, 6).toString();
        String h = TabelAnggota.getValueAt(bar, 7).toString();
        String i = TabelAnggota.getValueAt(bar, 8).toString();
        
        ID.setText(a);
        NIS.setText(b);
        NAMA.setText(c);
        
        if("PRIA".equals(d)){
            JKP.setSelected(true);
        }else{
            JKW.setSelected(true);
        }
        
        KTINGKAT.setSelectedItem(e);
        KJURUSAN.setSelectedItem(f);
        KKELAS.setSelectedItem(g);
        NOPE.setText(h);
        
        if("AKITF".equals(i)){
            STATUS.setSelectedItem(i);
        }else{
            STATUS.setSelectedItem(i);
        }
        
        BInput.setEnabled(false);
        BEdit.setEnabled(true);
        BDelete.setEnabled(true);
    }//GEN-LAST:event_TabelAnggotaMouseClicked

    private void BEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BEditActionPerformed
        int update = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "update data",
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

    private void BDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BDeleteActionPerformed
        int delete = JOptionPane.showOptionDialog(this,
                    "apakah anda yakin?",
                    "delete data",
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

    private void IDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDActionPerformed

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
            java.util.logging.Logger.getLogger(FDataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDataAnggota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDataAnggota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BDelete;
    private javax.swing.JButton BEdit;
    private javax.swing.JButton BInput;
    private javax.swing.JButton BKeluar;
    private javax.swing.JTextField ID;
    private javax.swing.ButtonGroup JK;
    private javax.swing.JRadioButton JKP;
    private javax.swing.JRadioButton JKW;
    private javax.swing.JComboBox<String> KJURUSAN;
    private javax.swing.JComboBox<String> KKELAS;
    private javax.swing.JComboBox<String> KTINGKAT;
    private javax.swing.JTextField NAMA;
    private javax.swing.JTextField NIS;
    private javax.swing.JTextField NJURUSAN;
    private javax.swing.JTextField NOPE;
    private javax.swing.JTextField NTINGKAT;
    private javax.swing.JComboBox<String> STATUS;
    private javax.swing.JTable TabelAnggota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    // End of variables declaration//GEN-END:variables
}
