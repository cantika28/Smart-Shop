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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Cantika
 */
public class Penjualan extends javax.swing.JFrame {
private DefaultTableModel TabModel;



    Connection conn;
    Statement st;
    ResultSet rs;

    /**
     * Creates new form Penjualan
     */
    public Penjualan() {
        initComponents();
        siapIsi(false);
        tombolNormal();
        stockTF.setVisible(false);
        subtotTF.setVisible(false);
        Object header[]={"Kode Barang","Nama Barang","Harga Jual","Jumlah","Subtotal"};
        TabModel=new DefaultTableModel(null, header);
    }
    
    private void bersih(){
        noTF.setText("");
        pembeliTF.setText("");
        kodeTF.setText("");
        namaTF.setText("");
        hjualTF.setText("");
        jumlahTF.setText("");
        subtotTF.setText("0");
        totalTF.setText("0");
        ubayTF.setText("0");
        ukemTF.setText("0");
    }

    private void siapIsi(boolean a){;
        noTF.setEnabled(a);
        pembeliTF.setEnabled(a);
        kodeTF.setEnabled(a);
        namaTF.setEnabled(a);
        hjualTF.setEnabled(a);
        jumlahTF.setEnabled(a);
        totalTF.setEnabled(a);
        ubayTF.setEnabled(a);
        ukemTF.setEnabled(a);
    }
    
    private void tombolNormal(){
        tambahBT.setEnabled(true);
        simpanBT.setEnabled(false);
        tbhBrgBT.setEnabled(false);
        krgBrgBT.setEnabled(false);
        cariBrgBT.setEnabled(false);
    }
    
    private void otomatis(){
        try {
            setKoneksi();
            String sql="select right (notrans,2)+1 from tbjual";
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                rs.last();
                String no=rs.getString(1);
                while (no.length()<3){
                    no="0"+no;
                    noTF.setText("S"+no);}
                }
            else
            {
                noTF.setText("S001"); 
        }
        } catch (Exception e) 
        {
        }
    } 
    
    public void ambildata() {
        try {
            jTable1.setModel(TabModel);
                String kolom1 = kodeTF.getText();
                String kolom2 = namaTF.getText();
                String kolom3 = hjualTF.getText();
                String kolom4 = jumlahTF.getText();
                String kolom5 = subtotTF.getText();
                String[] kolom = {kolom1, kolom2, kolom3, kolom4, kolom5};
                TabModel.addRow(kolom);
          }
          catch (Exception ex) {
              JOptionPane.showMessageDialog(null, "Data gagal disimpan");
          }     
    }
    
    private void simpan(){
        setKoneksi();
        try {
            Date skrg=new Date();
            SimpleDateFormat frm=new SimpleDateFormat("yyyy-MM-dd");
            String tgl=frm.format(skrg); 
            
            int t = jTable1.getRowCount();
            for(int i=0;i<t;i++)    
            {
            String kdbrng=jTable1.getValueAt(i, 0).toString();
            String nmbrng=jTable1.getValueAt(i, 1).toString();
            int harga= Integer.parseInt(jTable1.getValueAt(i, 2).toString());
            int jml= Integer.parseInt(jTable1.getValueAt(i, 3).toString());
            int subtot= Integer.parseInt(jTable1.getValueAt(i, 4).toString());
         
            String sql ="insert into tbjual values('"+noTF.getText()+"','"+tgl+"','"+pembeliTF.getText()+"','"
                    +kdbrng+"','"+nmbrng+"','"+harga+"','"+jml+"','"+subtot+"','"+totalTF.getText()+"','"+ubayTF.getText()+"','"+ukemTF.getText()+"')";
            
             st.executeUpdate(sql);
            }         
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Simpan transaksi penjualan gagal");
        }
    }
    
    private void hapusdatadaritabel() {
        int a = jTable1.getSelectedRow();
        if(a == -1){
        }TabModel.removeRow(a);
    }
   
    
    private void tampilBarang(){
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        cariTF = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        noTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        pembeliTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        kodeTF = new javax.swing.JTextField();
        namaTF = new javax.swing.JTextField();
        hjualTF = new javax.swing.JTextField();
        cariBrgBT = new javax.swing.JButton();
        krgBrgBT = new javax.swing.JButton();
        tbhBrgBT = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jumlahTF = new javax.swing.JTextField();
        simpanBT = new javax.swing.JButton();
        tambahBT = new javax.swing.JButton();
        ukemTF = new javax.swing.JTextField();
        totalTF = new javax.swing.JTextField();
        ubayTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tglTF = new com.toedter.calendar.JDateChooser();
        subtotTF = new javax.swing.JTextField();
        stockTF = new javax.swing.JTextField();

        jDialog1.setMinimumSize(new java.awt.Dimension(460, 386));
        jDialog1.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        jDialog1.setResizable(false);
        jDialog1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jDialog1MouseClicked(evt);
            }
        });

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
        jScrollPane3.setViewportView(jTable2);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Data Barang");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ketikan Kriteria Pencarian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cariTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariTFKeyPressed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Pilih.gif"))); // NOI18N
        jButton7.setText("Cari");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(cariTF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 255)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Transaksi Jual Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(352, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, -1));

        jLabel2.setText("No. Trans");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, 61, -1));

        noTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        noTF.setDisabledTextColor(new java.awt.Color(51, 51, 255));
        jPanel1.add(noTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 68, 113, -1));

        jLabel3.setText("Pembeli");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 106, 61, -1));

        pembeliTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pembeliTFKeyTyped(evt);
            }
        });
        jPanel1.add(pembeliTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 106, 270, -1));

        jLabel5.setText("Kode Barang");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 151, -1, -1));

        jLabel6.setText("Nama Barang");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 110, -1));

        jLabel7.setText("Harga Jual");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 90, -1));

        jLabel8.setText("Jumlah");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 150, 50, -1));
        jPanel1.add(kodeTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 90, -1));
        jPanel1.add(namaTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 210, 20));

        hjualTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                hjualTFKeyTyped(evt);
            }
        });
        jPanel1.add(hjualTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 103, -1));

        cariBrgBT.setText("...");
        cariBrgBT.setToolTipText("Cari barang");
        cariBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBrgBTActionPerformed(evt);
            }
        });
        jPanel1.add(cariBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 30, 20));

        krgBrgBT.setText("-");
        krgBrgBT.setToolTipText("Kurangi transaksi");
        krgBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                krgBrgBTActionPerformed(evt);
            }
        });
        jPanel1.add(krgBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 170, 40, 20));

        tbhBrgBT.setText("+");
        tbhBrgBT.setToolTipText("Tambah transaksi");
        tbhBrgBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbhBrgBTActionPerformed(evt);
            }
        });
        jPanel1.add(tbhBrgBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 170, 40, 20));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 623, 180));

        jumlahTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahTFActionPerformed(evt);
            }
        });
        jumlahTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jumlahTFKeyTyped(evt);
            }
        });
        jPanel1.add(jumlahTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 70, -1));

        simpanBT.setText("Simpan");
        simpanBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanBTActionPerformed(evt);
            }
        });
        jPanel1.add(simpanBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, -1));

        tambahBT.setText("Tambah");
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });
        jPanel1.add(tambahBT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 100, -1));

        ukemTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ukemTF.setForeground(new java.awt.Color(255, 0, 0));
        ukemTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ukemTFKeyTyped(evt);
            }
        });
        jPanel1.add(ukemTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 140, -1));

        totalTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        totalTF.setForeground(new java.awt.Color(255, 0, 0));
        totalTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                totalTFKeyTyped(evt);
            }
        });
        jPanel1.add(totalTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 400, 140, -1));

        ubayTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ubayTF.setForeground(new java.awt.Color(255, 0, 0));
        ubayTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ubayTFKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ubayTFKeyTyped(evt);
            }
        });
        jPanel1.add(ubayTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 430, 140, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText(" Kembali");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 460, 60, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("Total");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 50, 20));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 0, 0));
        jLabel10.setText("Bayar");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 50, 20));

        jLabel11.setText("Tanggal");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, -1));

        tglTF.setToolTipText("");
        tglTF.setDateFormatString("dd MMMM yyyy");
        jPanel1.add(tglTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 70, 150, -1));
        jPanel1.add(subtotTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 110, 60, -1));
        jPanel1.add(stockTF, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 60, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cariBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBrgBTActionPerformed
        // TODO add your handling code here:
        jDialog1.setLocationRelativeTo(null);
        tampilBarang();
        jDialog1.setVisible(true);
        cariTF.setText("");
    }//GEN-LAST:event_cariBrgBTActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        Date date = new Date();
        tglTF.setDate(date);
    }//GEN-LAST:event_formWindowActivated

    private void jumlahTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahTFActionPerformed

    private void simpanBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanBTActionPerformed
        // TODO add your handling code here:
        if(noTF.getText().equals("") || pembeliTF.getText().equals("") || ubayTF.getText().equals("0") || ukemTF.getText().equals("0")){
            JOptionPane.showMessageDialog(null, "Lengkapi inputan penjualan barang");
        } else{
            simpan();  
            int pesan=JOptionPane.showConfirmDialog(null, "simpan Transaksi Berhasil");
            
            if(pesan==JOptionPane.YES_OPTION){
                   
               }else {
                   JOptionPane.showMessageDialog(null, "Simpan Transaksi Berhasil");
               }
            bersih();
        }
    }//GEN-LAST:event_simpanBTActionPerformed

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
        if(tambahBT.getText().equalsIgnoreCase("tambah")){
            tambahBT.setText("Batal");
            siapIsi(true);
            bersih();
            otomatis();
            pembeliTF.requestFocus();
            noTF.setEnabled(false);
            simpanBT.setEnabled(true);
            tbhBrgBT.setEnabled(true);
            krgBrgBT.setEnabled(true);
            cariBrgBT.setEnabled(true);
        }else{
            bersih();
            siapIsi(false);
            tambahBT.setText("Tambah");
            TabModel.getDataVector().removeAllElements();
            TabModel.fireTableDataChanged();
            tombolNormal();
        }
    }//GEN-LAST:event_tambahBTActionPerformed

    private void tbhBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbhBrgBTActionPerformed
        // TODO add your handling code here:
        int harga=Integer.parseInt(hjualTF.getText());
        int jml=Integer.parseInt(jumlahTF.getText());
        int stok=Integer.parseInt(stockTF.getText());
        int total=Integer.parseInt(totalTF.getText());
        
        if(jml>stok){
             JOptionPane.showMessageDialog(null, "Stok barang tidak mencukupi");
        }else{
                 
            int subtot=harga*jml;
            subtotTF.setText(Integer.toString(subtot));
            
            int totbay=total+(harga*jml);
            totalTF.setText(Integer.toString(totbay));
            
            ambildata();
            
        kodeTF.setText("");
        namaTF.setText("");
        hjualTF.setText("");
        jumlahTF.setText("");
        }
    }//GEN-LAST:event_tbhBrgBTActionPerformed

    private void jDialog1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDialog1MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        kodeTF.setText(jTable2.getModel().getValueAt(baris, 0).toString());
        namaTF.setText(jTable2.getModel().getValueAt(baris, 1).toString());
        hjualTF.setText(jTable2.getModel().getValueAt(baris, 3).toString());
        stockTF.setText(jTable2.getModel().getValueAt(baris, 4).toString());
        jDialog1.dispose();
    }//GEN-LAST:event_jDialog1MouseClicked

    private void krgBrgBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_krgBrgBTActionPerformed
        // TODO add your handling code here:
        int baris = jTable1.getSelectedRow();
        int qty=Integer.parseInt(jTable1.getModel().getValueAt(baris, 3).toString());
        int total=Integer.parseInt(totalTF.getText());
        int harga=Integer.parseInt(jTable1.getModel().getValueAt(baris, 2).toString());
        
        int totbay=total-(harga*qty);
        totalTF.setText(Integer.toString(totbay)); 
        hapusdatadaritabel();
    }//GEN-LAST:event_krgBrgBTActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        int baris = jTable2.getSelectedRow();
        kodeTF.setText(jTable2.getModel().getValueAt(baris, 0).toString());
        namaTF.setText(jTable2.getModel().getValueAt(baris, 1).toString());
        hjualTF.setText(jTable2.getModel().getValueAt(baris, 3).toString());
        stockTF.setText(jTable2.getModel().getValueAt(baris, 4).toString());
        jDialog1.dispose();
    }//GEN-LAST:event_jTable2MouseClicked

    private void cariTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
        Object header[]={"Kode Barang","Nama Barang","Jenis","Harga Jual","Stock"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable2.setModel(data);
        setKoneksi();
        String sql="Select * from tbbrng where kdbrng like '%" + cariTF.getText() + "%'" + "or nmbrng like '%" + cariTF.getText()+ "%'";
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
    }//GEN-LAST:event_cariTFKeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Object header[]={"Kode Barang","Nama Barang","Jenis","Harga Jual","Stock"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        jTable2.setModel(data);
        setKoneksi();
        String sql="Select * from tbbrng where kdbrng like '%" + cariTF.getText() + "%'" + "or nmbrng like '%" + cariTF.getText()+ "%'";
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
    }//GEN-LAST:event_jButton7ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        ImageIcon img = new ImageIcon("src/gambar/kredit.png");
        setIconImage(img.getImage());
    }//GEN-LAST:event_formWindowOpened

    private void ubayTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubayTFKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            int total=Integer.parseInt(totalTF.getText());
            int bayar=Integer.parseInt(ubayTF.getText());
            if(bayar<total){
                JOptionPane.showMessageDialog(null, "Jumlah bayar tidak mencukupi");
                ubayTF.requestFocus();
            } else{
                int kembali=bayar-total;
                ukemTF.setText(Integer.toString(kembali));
            }
        }
    }//GEN-LAST:event_ubayTFKeyPressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        jTable1.setRowSelectionAllowed(true);
        int a = jTable1.getSelectedRow();
        String kolom1 = jTable1.getValueAt(a,0).toString();
        String kolom2 = jTable1.getValueAt(a,1).toString();
        String kolom3 = jTable1.getValueAt(a,2).toString();
        String kolom4 = jTable1.getValueAt(a,3).toString();
        String kolom5 = jTable1.getValueAt(a,4).toString();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jumlahTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jumlahTFKeyTyped
        // TODO add your handling code here:
        //validasi data harus angka atau tombol backspace
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_jumlahTFKeyTyped

    private void totalTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_totalTFKeyTyped
        // TODO add your handling code here:
        //validasi data harus angka atau tombol backspace
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_totalTFKeyTyped

    private void ukemTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ukemTFKeyTyped
        // TODO add your handling code here:
        //validasi data harus angka atau tombol backspace
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_ukemTFKeyTyped

    private void pembeliTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pembeliTFKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_pembeliTFKeyTyped

    private void ubayTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ubayTFKeyTyped
        // TODO add your handling code here:
        //validasi data harus angka atau tombol backspace
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE || karakter==KeyEvent.VK_ENTER))
        {
            evt.consume();
        }
    }//GEN-LAST:event_ubayTFKeyTyped

    private void hjualTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hjualTFKeyTyped
        // TODO add your handling code here:
        char karakter = evt.getKeyChar();
        if (!(Character.isDigit(karakter) || karakter==KeyEvent.VK_BACK_SPACE))
        {
            evt.consume();
        }
    }//GEN-LAST:event_hjualTFKeyTyped

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         /*
         * Set the Nimbus look and feel
         */    
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Penjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBrgBT;
    private javax.swing.JTextField cariTF;
    private javax.swing.JTextField hjualTF;
    private javax.swing.JButton jButton7;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jumlahTF;
    private javax.swing.JTextField kodeTF;
    private javax.swing.JButton krgBrgBT;
    private javax.swing.JTextField namaTF;
    private javax.swing.JTextField noTF;
    private javax.swing.JTextField pembeliTF;
    private javax.swing.JButton simpanBT;
    private javax.swing.JTextField stockTF;
    private javax.swing.JTextField subtotTF;
    private javax.swing.JButton tambahBT;
    private javax.swing.JButton tbhBrgBT;
    private com.toedter.calendar.JDateChooser tglTF;
    private javax.swing.JTextField totalTF;
    private javax.swing.JTextField ubayTF;
    private javax.swing.JTextField ukemTF;
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