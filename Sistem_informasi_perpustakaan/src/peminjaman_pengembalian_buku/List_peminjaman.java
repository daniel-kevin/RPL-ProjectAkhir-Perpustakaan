/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peminjaman_pengembalian_buku;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import pendaftaran_buku.Daftar_buku_option;
import sistem_informasi_perpustakaan.connection.db_connection;

/**
 *
 * @author Daniel
 */
public class List_peminjaman extends javax.swing.JFrame {

    /**
     * Creates new form List_peminjaman
     */
    public List_peminjaman() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        loadTable(true);
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
        textbox_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        btn_show_all = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_peminjaman = new javax.swing.JTable();
        btn_back = new javax.swing.JLabel();
        validasi_judul = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Judul buku");

        btn_search.setText("Search");
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_searchMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_searchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_searchMouseExited(evt);
            }
        });

        btn_show_all.setText("Show All");
        btn_show_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_show_allMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_show_allMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_show_allMouseExited(evt);
            }
        });

        tabel_peminjaman.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul", "Tgl Peminjaman", "Tgl Kembali", "Tipe Buku", "Nama Peminjam"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabel_peminjaman);

        btn_back.setText("Back");
        btn_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_backMouseExited(evt);
            }
        });

        validasi_judul.setText("validasi");
        validasi_judul.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_back)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(validasi_judul)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textbox_search, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_search)
                                .addGap(18, 18, 18)
                                .addComponent(btn_show_all)))))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textbox_search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search)
                    .addComponent(btn_show_all))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(validasi_judul)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_back)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        boolean judulIsValid = textisValid();
        if(!judulIsValid){
            validasi_judul.setText("Judul tidak boleh kosong !");
            validasi_judul.setVisible(true);
        }
        else if(judulIsValid){
            validasi_judul.setVisible(false);
            loadTable(false);
        }
    }//GEN-LAST:event_btn_searchMouseClicked

    private void btn_show_allMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_allMouseClicked
        loadTable(true);
    }//GEN-LAST:event_btn_show_allMouseClicked

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_show_allMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_allMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_show_allMouseEntered

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        this.dispose();
        Daftar_buku_option daftar_buku_option = new Daftar_buku_option();
        daftar_buku_option.setVisible(true);
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_searchMouseExited

    private void btn_show_allMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_show_allMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_show_allMouseExited

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_backMouseExited
    private boolean textisValid(){
        String judul = textbox_search.getText().toLowerCase();
        if(judul.equals("")){
            return false;
        }
        return true;
    }
    private void loadTable(boolean showAll){
        Connection conn = db_connection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        String text = null;
        if(showAll){
            sql = "SELECT tb_buku.judul,tb_peminjaman.tgl_pinjam,tb_peminjaman.tgl_kembali,tb_tipe_buku.tipe_buku,tb_member.nama FROM tb_detail_peminjaman INNER JOIN tb_buku ON tb_detail_peminjaman.buku_id = tb_buku.id INNER JOIN tb_peminjaman ON tb_detail_peminjaman.peminjaman_id = tb_peminjaman.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id INNER JOIN tb_member ON tb_peminjaman.member_id = tb_member.id WHERE tb_detail_peminjaman.status_buku = 'dipinjam';";
        }
        else if(!showAll){
            text = textbox_search.getText().toLowerCase();
            sql = "SELECT tb_buku.judul,tb_peminjaman.tgl_pinjam,tb_peminjaman.tgl_kembali,tb_tipe_buku.tipe_buku,tb_member.nama FROM tb_detail_peminjaman INNER JOIN tb_buku ON tb_detail_peminjaman.buku_id = tb_buku.id INNER JOIN tb_peminjaman ON tb_detail_peminjaman.peminjaman_id = tb_peminjaman.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id INNER JOIN tb_member ON tb_peminjaman.member_id = tb_member.id WHERE tb_detail_peminjaman.status_buku = 'dipinjam'AND tb_buku.judul LIKE '%"+text+"%';";
        }
        String t_judul = null;
        Date tgl_pinjam = null;
        Date tgl_kembali = null;
        String t_tgl_pinjam = null;
        String t_tgl_kembali = null;
        String t_tipe = null;
        String t_peminjam = null;
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DefaultTableModel tableModel = new DefaultTableModel();
         tableModel.addColumn("Judul");
            tableModel.addColumn("Tgl Peminjaman");
            tableModel.addColumn("Tgl Kembali");
            tableModel.addColumn("Tipe Buku");
            tableModel.addColumn("Nama Peminjam");
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                t_judul = rs.getString(1);
                tgl_pinjam = rs.getDate(2);
                t_tgl_pinjam = dateFormat.format(tgl_pinjam);
                tgl_kembali = rs.getDate(3);
                t_tgl_kembali = dateFormat.format(tgl_kembali);
                t_tipe = rs.getString(4);
                t_peminjam = rs.getString(5);
                tableModel.addRow(new Object[]{
                        t_judul,t_tgl_pinjam,t_tgl_kembali,t_tipe,t_peminjam
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(List_peminjaman.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        tabel_peminjaman.setModel(tableModel);
    }
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
            java.util.logging.Logger.getLogger(List_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(List_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(List_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(List_peminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new List_peminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel btn_show_all;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel_peminjaman;
    private javax.swing.JTextField textbox_search;
    private javax.swing.JLabel validasi_judul;
    // End of variables declaration//GEN-END:variables
}
