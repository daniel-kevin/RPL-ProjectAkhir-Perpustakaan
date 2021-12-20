/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Report;

import java.awt.Cursor;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import sistem_informasi_perpustakaan.connection.db_connection;

/**
 *
 * @author Daniel
 */
public class Report_buku_masuk extends javax.swing.JFrame {

    /**
     * Creates new form Report_buku_masuk
     */
    public Report_buku_masuk() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_buat_laporan = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chooser_bulan = new com.toedter.calendar.JMonthChooser();
        jLabel2 = new javax.swing.JLabel();
        spinner_tahun = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(300, 300));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buat_laporan.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        btn_buat_laporan.setForeground(new java.awt.Color(255, 255, 255));
        btn_buat_laporan.setText("Buat Laporan");
        btn_buat_laporan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_buat_laporanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_buat_laporanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_buat_laporanMouseExited(evt);
            }
        });
        getContentPane().add(btn_buat_laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel1.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bulan");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, -1, -1));

        chooser_bulan.setBackground(new java.awt.Color(148, 61, 21));
        getContentPane().add(chooser_bulan, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel2.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tahun");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, -1, -1));

        spinner_tahun.setModel(new javax.swing.SpinnerNumberModel(2021, 1, null, 1));
        getContentPane().add(spinner_tahun, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 101, -1));

        jLabel3.setFont(new java.awt.Font("Harrington", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/backyellow50x50.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 50, 50));

        jLabel4.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 0));
        jLabel4.setText("Laporan Bulanan");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 20));

        jLabel5.setFont(new java.awt.Font("Harrington", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 0));
        jLabel5.setText("Buku Masuk");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, -1));

        jPanel1.setBackground(new java.awt.Color(148,61,21,70));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 255), new java.awt.Color(102, 0, 102), new java.awt.Color(0, 0, 255), new java.awt.Color(102, 0, 102)));
        jPanel1.setForeground(new java.awt.Color(163, 9, 9));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 224, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 230, 230));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Background300x300.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buat_laporanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buat_laporanMouseClicked
        try {
            int month = chooser_bulan.getMonth() + 1;
            int year = (int) spinner_tahun.getValue();
            String month_name = Month.of(month).name();
            Map<String, Object> map = new HashMap<>();
            //Path path = Paths.get("/Report/report1.jrxml");
            //Path real_path = path.toRealPath();
            //String real_path_string = real_path.toString();
            //String path = "E:\\Tugas TI\\Semester 3\\Rekayasa Perangkat Lunak\\Project\\4\\RPL-ProjectAkhir-Perpustakaan-main\\Sistem_informasi_perpustakaan\\src\\Report\\report1.jrxml";
            map.put("bulan",month);
            map.put("tahun", year);
            map.put("bulan_string", month_name);
            Connection conn = db_connection.getConnection();
            //JasperReport jr = JasperCompileManager.compileReport(ClassLoader.getSystemResourceAsStream(path));
            //JasperPrint jp = JasperFillManager.fillReport(jr,map,conn);
            //JasperViewer.viewReport(jp);
            //JasperDesign jd = JRXmlLoader.load("E:\\Tugas TI\\Semester 3\\Rekayasa Perangkat Lunak\\Project\\4\\RPL-ProjectAkhir-Perpustakaan-main\\Sistem_informasi_perpustakaan\\src\\Report\\report1.jrxml");
            JasperDesign jd = JRXmlLoader.load("src\\Report\\report_buku_masuk.jrxml");
            //String query ="SELECT tb_buku.judul,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_buku.tgl_pendaftaran,tb_rak.no_rak,tb_kota_terbit.nama_kota,tb_tipe_buku.tipe_buku,tb_buku.isbn_issn FROM tb_buku INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_kota_terbit ON tb_buku.kota_terbit_id = tb_kota_terbit.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE MONTH(tb_buku.tgl_pendaftaran) = $P{month} AND YEAR(tb_buku.tgl_pendaftaran) = $P{year};";
            //JRDesignQuery updateQuery = new JRDesignQuery();
            //updateQuery.setText(query);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, map, conn);
            //JasperViewer jv = new JasperViewer(jp,false);
            JasperViewer.viewReport(jp,false);
        } catch (JRException ex) {
            Logger.getLogger(Report_buku_masuk.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_buat_laporanMouseClicked

    private void btn_buat_laporanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buat_laporanMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_buat_laporanMouseEntered

    private void btn_buat_laporanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_buat_laporanMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_buat_laporanMouseExited

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.dispose();
        Report_option report_option = new Report_option();
        report_option.setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

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
            java.util.logging.Logger.getLogger(Report_buku_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Report_buku_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Report_buku_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Report_buku_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Report_buku_masuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel btn_buat_laporan;
    private com.toedter.calendar.JMonthChooser chooser_bulan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner spinner_tahun;
    // End of variables declaration//GEN-END:variables
}
