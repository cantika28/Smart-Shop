/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cantika
 */
public class Barang extends javax.swing.JFrame {
    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Barang
     */
    public Barang() {
        initComponents();
        siapIsi(false);
        tombolNormal();
    }
    
    private void bersih(){
        kodeTF.setText("");
        namaTF.setText("");
        jenisCB.setSelectedItem(null);
        hjualTF.setText("");
        stockTF.setText("0");
    }

    private void siapIsi(boolean a){
        kodeTF.setEnabled(a);
        namaTF.setEnabled(a);
        jenisCB.setEnabled(a);
        hjualTF.setEnabled(a);
        stockTF.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        hapusBT.setEnabled(false);
        editBT.setEnabled(false);
        keluarBT.setEnabled(true);
        cariBT.setEnabled(true);
    }
    
    private void otomatis(){
        try {
            setKoneksi();
            String sql="select right (kdbrng,2)+1 from tbbrng";
            ResultSet rs=st.executeQuery(sql);
            namaTF.setText("");
            jenisCB.setSelectedItem(null);
            hjualTF.setText("");
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    kodeTF.setText("B"+no);}
                }
            else
            {
                kodeTF.setText("B001"); 
            }
            } catch (Exception e) 
            {
        }
    }
    
    private void simpan(){
        try{
            setKoneksi();
            String sql="insert into tbbrng values('"+ kodeTF.getText() +"','" + namaTF.getText() 
                    + "','" + jenisCB.getSelectedItem()+ "','" + hjualTF.getText() + "','" + stockTF.getText() +"')";
            st.executeUpdate(sql); 
            JOptionPane.showMessageDialog(null,"Simpan data berhasil");
            }
            catch (Exception e) {
        }
        tampil();
    }
    
    private void perbarui(){
        try{
            setKoneksi();
            String sql="update tbbrng set nmbrng='"+namaTF.getText()+"',jenis='"+jenisCB.getSelectedItem()+
                    "',hjual='"+hjualTF.getText()+"' where kdbrng='"+kodeTF.getText()+"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Edit data berhasil","Abadi Sport",JOptionPane.INFORMATION_MESSAGE);
        } 
        catch(Exception e){
        }
        tampil();
    }
    
    public void tampil(){
        Object header[]={"Kode Barang","Nama Barang","Jenis","Harga Jual","Stock"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable2.setModel(data);
        setKoneksi();
        String sql="select*from tbbrng";
        try {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }
        } catch (Exception e) {
        }
    }
    
    private void hapus(){
        try{
            String sql="delete from tbbrng where kdbrng='"+ kodeTF.getText() +"'";
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Hapus data sukses");
            }
            catch (Exception e) {
            }
        tampil();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        kodeTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jenisCB = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        hjualTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        stockTF = new javax.swing.JTextField();
        tambahBT = new javax.swing.JButton();
        simpanBT = new javax.swing.JButton();
        editBT = new javax.swing.JButton();
        hapusBT = new javax.swing.JButton();
        keluarBT = new javax.swing.JButton();
        cariBT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255), 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Data Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(169, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 510, 200));

        jLabel2.setText("Kode Barang");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, 80, -1));

        kodeTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        kodeTF.setDisabledTextColor(new java.awt.Color(51, 51, 255));
        jPanel1.add(kodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 90, -1));

        jLabel3.setText("Nama Barang");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, -1));
        jPanel1.add(namaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 430, -1));

        jLabel5.setText("Jenis");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 121, 70, -1));

        jenisCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Makanan", "Minuman", "Kosmetik", "Lain-lain", " ", " " }));
        jPanel1.add(jenisCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 100, 20));

        jLabel8.setText("Harga Jual");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, 20));

        hjualTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hjualTFActionPerformed(evt);
            }
        });
        hjualTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                hjualTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hjualTFKeyTyped(evt);
            }
        });
        jPanel1.add(hjualTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 230, -1));

        jLabel4.setText("Stock");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 70, -1));

        stockTF.setText("0");
        jPanel1.add(stockTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 100, -1));

        tambahBT.setText("Tambah");
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });
        jPanel1.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 90, -1));

        simpanBT.setText("Simpan");
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });
        jPanel1.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 90, -1));

        editBT.setText("Edit");
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });
        jPanel1.add(editBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 80, -1));

        hapusBT.setText("Hapus");
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });
        jPanel1.add(hapusBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 90, -1));

        keluarBT.setText("Keluar");
        keluarBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarBTActionPerformed(evt);
            }
        });
        jPanel1.add(keluarBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, 80, -1));

        cariBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Cari2.png"))); // NOI18N
        cariBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBTActionPerformed(evt);
            }
        });
        jPanel1.add(cariBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 40, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        kodeTF.setText(jTable2.getModel().getValueAt(baris, 0).toString());
        namaTF.setText(jTable2.getModel().getValueAt(baris, 1).toString());
        jenisCB.setSelectedItem(jTable2.getModel().getValueAt(baris, 2).toString());
        hjualTF.setText(jTable2.getModel().getValueAt(baris, 3).toString());
        stockTF.setText(jTable2.getModel().getValueAt(baris, 4).toString());
        hapusBT.setEnabled(true);
        editBT.setEnabled(true);
    }//GEN-LAST:event_jTable2MouseClicked

    private void hjualTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hjualTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hjualTFActionPerformed

    private void hjualTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hjualTFKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_hjualTFKeyPressed

    private void hjualTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hjualTFKeyTyped
        // TODO add your handling code here:
        //validasi data harus angka atau tombol backspace
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_hjualTFKeyTyped

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
        if(tambahBT.getText().equalsIgnoreCase("tambah")){
            tambahBT.setText("Batal");
            //bersih();
            siapIsi(true);
            otomatis();
            namaTF.requestFocus();
            kodeTF.setEnabled(false);
            tambahBT.setEnabled(true);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(false);
            keluarBT.setEnabled(false);
            cariBT.setEnabled(false);
            stockTF.setEnabled(false);
        } else{
            tambahBT.setText("Tambah");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_tambahBTActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        if(kodeTF.getText().isEmpty() ||namaTF.getText().isEmpty()||jenisCB.getSelectedItem().equals("") ||hjualTF.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan data","Smart Shop",JOptionPane.INFORMATION_MESSAGE);
        } else{

            if(tambahBT.getText().equalsIgnoreCase("batal")){
                if(tambahBT.getText().equalsIgnoreCase("batal")){
                    simpan();
                } else{
                    JOptionPane.showMessageDialog(null, "Simpan data gagal, periksa kembali","Smart Shop",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            if(editBT.getText().equalsIgnoreCase("batal")){
                if(editBT.getText().equalsIgnoreCase("batal")){
                    perbarui();
                } else{
                    JOptionPane.showMessageDialog(null, "Edit data gagal, periksa kembali","Smart Shop",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            editBT.setText("Edit");
            tombolNormal();
        }
    }//GEN-LAST:event_simpanBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        // TODO add your handling code here:
        if(editBT.getText().equalsIgnoreCase("edit")){
            editBT.setText("Batal");
            siapIsi(true);
            kodeTF.setEnabled(false);
            stockTF.setEnabled(false);
            namaTF.requestFocus();
            tambahBT.setEnabled(false);
            simpanBT.setEnabled(true);
            hapusBT.setEnabled(false);
            editBT.setEnabled(true);
            keluarBT.setEnabled(false);
            cariBT.setEnabled(false);
        } else{
            editBT.setText("Edit");
            bersih();
            siapIsi(false);
            tombolNormal();
        }
    }//GEN-LAST:event_editBTActionPerformed

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        // TODO add your handling code here:
        int pesan=JOptionPane.showConfirmDialog(null, "Yakin data akan dihapus ?","Konfirmasi",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(pesan==JOptionPane.YES_OPTION){
            if(pesan==JOptionPane.YES_OPTION){
                hapus();
                bersih();
                siapIsi(false);
                tombolNormal();
            } else{
                JOptionPane.showMessageDialog(null, "Hapus data gagal");
            }
            tampil();
        }
    }//GEN-LAST:event_hapusBTActionPerformed

    private void keluarBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarBTActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_keluarBTActionPerformed

    private void cariBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBTActionPerformed
        // TODO add your handling code here:
        String cari = JOptionPane.showInputDialog(null, "Inputkan kriteria pencarian", "Input", JOptionPane.QUESTION_MESSAGE);
        Object header[]={"Kode Barang","Nama Barang","Jenis","Harga Jual","Stock"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable2.setModel(data);
        setKoneksi();
        String sql="Select * from tbbrng where kdbrng like '%" + cari + "%'" + "or nmbrng like '%" + cari+  "%'" + "or jenis like '%" + cari+  "%'" + "or hjual like '%" + cari+"%'";
        try {
            ResultSet rs=st.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString(1);
                String kolom2=rs.getString(2);
                String kolom3=rs.getString(3);
                String kolom4=rs.getString(4);
                String kolom5=rs.getString(5);
                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5};
                data.addRow(kolom);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cariBTActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        ImageIcon img = new ImageIcon("src/gambar/kredit.png");
        setIconImage(img.getImage());
        jenisCB.setSelectedItem(null);
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Barang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBT;
    private javax.swing.JButton editBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JTextField hjualTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> jenisCB;
    private javax.swing.JButton keluarBT;
    private javax.swing.JTextField kodeTF;
    private javax.swing.JTextField namaTF;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTextField stockTF;
    private javax.swing.JButton tambahBT;
    // End of variables declaration//GEN-END:variables
 
    public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/smartshop","root","");
            st=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }


}
