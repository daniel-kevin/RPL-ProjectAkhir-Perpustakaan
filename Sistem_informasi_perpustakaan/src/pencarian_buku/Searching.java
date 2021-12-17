/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pencarian_buku;

import java.awt.Cursor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import peminjaman_pengembalian_buku.peminjaman_buku;
import pendaftaran_buku.Daftar_buku;
import pendaftaran_buku.Daftar_buku_option;
import pendaftaran_buku.Daftar_journal;
import pendaftaran_buku.Daftar_majalah;
import sistem_informasi_perpustakaan.connection.db_connection;

/**
 *
 * @author Daniel
 */
//Class yang digunakan kalau melakukan search dengan judul buku, nama penulis atau nama penerbit
public class Searching extends javax.swing.JFrame {
    private int mode;//mode (0 search by title, 1 search by author, 2 search by publisher)
    private boolean isAdmin = false;//untuk pengecekan admin atau bukan
    /*isAdmin digunakan untuk pengecekan admin atau bukan karena kelas ini juga 
      digunakan pada saat melakukan pencarian buku yang mau diganti datanya.
      Perubahan data buku hanya dilakukan oleh Admin/Pegawai.
    */
    private int tipe;//1 = buku,2 = jurnal,3 = majalah, 4 = all
    private boolean pinjam = false;//cek dibuka dari form peminjaman atau bukan (true = dari form peminjaman)
    private peminjaman_buku peminjaman_buku;
    private int indexTextBox;
    /**
     * Creates new form Search_by_title
     */
    public Searching() {
        initComponents();
        this.setResizable(false);
    }
    //Constructor yang dipanggil kalau ingin melakukan perubahan data buku
    public Searching(boolean isAdmin){
        this.isAdmin = isAdmin;
        this.mode = 0;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }
    /*Constructor yang dipanggil kalau hanya ingin mencari data buku.
      Variabel mode menentukan metode pencarian yang digunakan*/
    public Searching(int mode,boolean isAdmin,int tipe) {
        this.mode = mode;
        this.isAdmin = isAdmin;
        this.tipe = tipe;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        if(tipe == 2 || tipe == 3){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Judul");
        //tableModel.addColumn("Penulis");
        tableModel.addColumn("Penerbit");
        tableModel.addColumn("Tahun Terbit");
        tableModel.addColumn("Nomor Rak");
        tableModel.addColumn("Status");
        tableModel.addColumn("ISSN/ISBN");
        tableModel.addColumn("Tipe");
        tabel_buku.setModel(tableModel);
        }
    }
    public Searching(peminjaman_buku peminjaman_buku, boolean isAdmin, int indexTextBox){
        this.pinjam = true;
        this.isAdmin = isAdmin;
        this.peminjaman_buku = peminjaman_buku;
        this.indexTextBox = indexTextBox;
        this.tipe = 4;
        this.mode = 0;
        initComponents();
        this.setLocationRelativeTo(this.peminjaman_buku);
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

        keterangan = new javax.swing.JLabel();
        textbox_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_buku = new javax.swing.JTable();
        validasi = new javax.swing.JLabel();
        btn_back = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        keterangan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        keterangan.setForeground(new java.awt.Color(255, 255, 255));
        keterangan.setText("Keterangan");
        if(mode == 0){
            keterangan.setText("Judul");
        }
        else if(mode == 1){
            keterangan.setText("Penulis");
        }
        else if(mode == 2){
            keterangan.setText("Penerbit");
        }
        getContentPane().add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        textbox_search.setBackground(new java.awt.Color(204, 204, 204));
        getContentPane().add(textbox_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 45, 300, -1));

        btn_search.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_search.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 80, 60, -1));

        tabel_buku.setBackground(new java.awt.Color(204, 204, 204));
        tabel_buku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Judul", "Penulis", "Penerbit", "Tahun Terbit", "Nomor Rak", "Status", "ISSN/ISBN", "Tipe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_buku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_bukuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_buku);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 108, 560, 134));

        validasi.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        validasi.setForeground(new java.awt.Color(255, 0, 0));
        validasi.setText("Validasi");
        validasi.setVisible(false);
        getContentPane().add(validasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 200, -1));

        btn_back.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_back.setForeground(new java.awt.Color(255, 255, 255));
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
        getContentPane().add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 76, 30, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pencarian");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 120, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/bg_pencarian_op.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 250));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseClicked
        boolean isValid = searchValidation();
        if(isValid){
            validasi.setVisible(false);
            search();
        }
    }//GEN-LAST:event_btn_searchMouseClicked
    //Validasi agar textbox search tidak kosong
    private boolean searchValidation(){
        String text = textbox_search.getText().toLowerCase();
        if(text.equals("")){
            if(mode == 0){
                validasi.setText("Judul tidak boleh kosong");
                validasi.setVisible(true);
            }
            else if(mode == 1){
                validasi.setText("Penulis tidak boleh kosong");
                validasi.setVisible(true);
            }
            else{
               validasi.setText("Penerbit tidak boleh kosong");
               validasi.setVisible(true); 
            }
            return false;
        }
        else return true;
    }
    //proses searching
    private void search(){
        String t_judul=null;
        String t_penulis=null;
        String t_penerbit=null;
        int t_thn_terbit=0;
        int t_no_rak=0;
        int t_jumlah = 0;
        int t_dipinjam;
        String t_status;
        int t_id_buku = 0;
        String t_isbn_issn = null;
        String t_tipe = null;
        Connection conn = db_connection.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        String text = textbox_search.getText().toLowerCase();
        String sql = null;
        //melakukan select dimana kondisi where sesuai dengan metode pencarian yang digunakan
        if(tipe == 1){
            if(mode == 0){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku INNER JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 1 AND tb_buku.judul LIKE '%"+text+"%';";
            }
            else if(mode == 1){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku  FROM tb_buku INNER JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 1 AND tb_penulis.nama LIKE '%"+text+"%';";
            }
            else if(mode == 2){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku  FROM tb_buku INNER JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 1 AND tb_penerbit.nama LIKE '%"+text+"%';";
            }
        }
        else if(tipe == 2){
            if(mode == 0){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 2 AND tb_buku.judul LIKE '%"+text+"%';";
            }
            else if(mode == 2){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 2 AND tb_penerbit.nama LIKE '%"+text+"%';";
            }
        }
        else if(tipe == 3){
            if(mode == 0){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 3 AND tb_buku.judul LIKE '%"+text+"%';";
            }
            else if(mode == 2){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.tipe_buku_id = 3 AND tb_penerbit.nama LIKE '%"+text+"%';";
            }
        }
        else if(tipe == 4){
            if(mode == 0){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku FROM tb_buku LEFT JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_buku.judul LIKE '%"+text+"%';";
            }
            else if(mode == 1){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku  FROM tb_buku LEFT JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_penulis.nama LIKE '%"+text+"%';";
            }
            else if(mode == 2){
                sql ="SELECT tb_buku.id,tb_buku.judul,tb_penulis.nama,tb_penerbit.nama,tb_buku.tahun_terbit,tb_buku.jumlah,tb_rak.no_rak,tb_buku.isbn_issn,tb_tipe_buku.tipe_buku  FROM tb_buku LEFT JOIN tb_penulis ON tb_buku.penulis_id = tb_penulis.id INNER JOIN tb_penerbit ON tb_buku.penerbit_id = tb_penerbit.id INNER JOIN tb_rak ON tb_buku.rak_id = tb_rak.id INNER JOIN tb_tipe_buku ON tb_buku.tipe_buku_id = tb_tipe_buku.id WHERE tb_penerbit.nama LIKE '%"+text+"%';";
            }
        }
        /*cek banyak buku dengan id tertentu yang sedang dipinjam.Kalau jumlah buku lebih banyak dari yang sedang dipinjam
          Berarti status = tersedia kalau tidak status = sedang dipinjam*/
        String sql2 = "SELECT COUNT(tb_detail_peminjaman.id) FROM tb_detail_peminjaman WHERE buku_id = ? AND status_buku ='dipinjam';";
        DefaultTableModel tableModel = new DefaultTableModel();
        if(tipe == 1 || tipe == 4){
            tableModel.addColumn("Judul");
            tableModel.addColumn("Penulis");
            tableModel.addColumn("Penerbit");
            tableModel.addColumn("Tahun Terbit");
            tableModel.addColumn("Nomor Rak");
            tableModel.addColumn("Status");
            tableModel.addColumn("ISSN/ISBN");
            tableModel.addColumn("Tipe");
        }
        else if(tipe == 2 || tipe == 3){
            tableModel.addColumn("Judul");
            tableModel.addColumn("Penerbit");
            tableModel.addColumn("Tahun Terbit");
            tableModel.addColumn("Nomor Rak");
            tableModel.addColumn("Status");
            tableModel.addColumn("ISSN/ISBN");
            tableModel.addColumn("Tipe");
        }

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                if(tipe == 1){
                    t_id_buku = rs.getInt(1);
                    t_judul = rs.getString(2);
                    t_penulis = rs.getString(3);
                    t_penerbit = rs.getString(4);
                    t_thn_terbit = rs.getInt(5);
                    t_jumlah = rs.getInt(6);
                    t_no_rak = rs.getInt(7);
                    t_isbn_issn = rs.getString(8);
                    t_tipe = rs.getString(9);
                }
                else if(tipe == 2 || tipe == 3){
                    t_id_buku = rs.getInt(1);
                    t_judul = rs.getString(2);
                    //t_penulis = rs.getString(3);
                    t_penerbit = rs.getString(3);
                    t_thn_terbit = rs.getInt(4);
                    t_jumlah = rs.getInt(5);
                    t_no_rak = rs.getInt(6);
                    t_isbn_issn = rs.getString(7);
                    t_tipe = rs.getString(8);
                }
                else if(tipe == 4){
                    t_id_buku = rs.getInt(1);
                    t_judul = rs.getString(2);
                    t_penulis = rs.getString(3);
                    t_penerbit = rs.getString(4);
                    t_thn_terbit = rs.getInt(5);
                    t_jumlah = rs.getInt(6);
                    t_no_rak = rs.getInt(7);
                    t_isbn_issn = rs.getString(8);
                    t_tipe = rs.getString(9);
                }
                ps2 = conn.prepareStatement(sql2);
                ps2.setInt(1,t_id_buku);
                rs2 = ps2.executeQuery();
                if(rs2.next()){
                    t_dipinjam = rs2.getInt(1);
                    t_jumlah = t_jumlah - t_dipinjam;
                }
                if(t_jumlah > 0){
                    t_status = "Tersedia";
                }
                else{
                    t_status = "Sedang Dipinjam";
                }
                if(tipe == 1 || tipe == 4){
                    tableModel.addRow(new Object[]{
                        t_judul,t_penulis,t_penerbit,t_thn_terbit,t_no_rak,t_status,t_isbn_issn,t_tipe
                });
                }
                else if(tipe == 2 || tipe == 3){
                    tableModel.addRow(new Object[]{
                        t_judul,t_penerbit,t_thn_terbit,t_no_rak,t_status,t_isbn_issn,t_tipe
                });
                }

            }
        } catch (SQLException e) {
        }
        finally{
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }
            if(rs2 != null){
                try {
                    rs2.close();
                } catch (SQLException e) {
                }
            }
            if(ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if(ps2 != null){
                try {
                    ps2.close();
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
        tabel_buku.setModel(tableModel);
    }
    //Kalau admin/pegawai bisa click hasil pencarian untuk ubah data buku sesuai yang di click
    private void tabel_bukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_bukuMouseClicked
        if(isAdmin == true && pinjam == false){
            int row = tabel_buku.rowAtPoint(evt.getPoint());
            String judul = (String) tabel_buku.getValueAt(row,0);
            if(tipe == 1){
                Daftar_buku daftar_buku = new Daftar_buku();
                daftar_buku.setVisible(true);
                daftar_buku.prepareUpdate(judul);
            }
            else if(tipe == 2){
                Daftar_journal daftar_journal = new Daftar_journal();
                daftar_journal.setVisible(true);
                daftar_journal.prepareUpdate(judul);
            }
            else if(tipe == 3){
                Daftar_majalah daftar_majalah = new Daftar_majalah();
                daftar_majalah.setVisible(true);
                daftar_majalah.prepareUpdate(judul);
            }
            this.dispose();
        }
        else if(isAdmin == true && pinjam == true){
            int row = tabel_buku.rowAtPoint(evt.getPoint());
            String judul = (String) tabel_buku.getValueAt(row,0);
            String status = (String) tabel_buku.getValueAt(row,5);
            if(status.equals("Sedang Dipinjam")){
                JOptionPane.showConfirmDialog(this,"Buku tidak tersedia !","",JOptionPane.DEFAULT_OPTION);
            }
            else{
                if(indexTextBox == 1){
                    peminjaman_buku.textbox_buku1.setText(judul);
                }
                else if(indexTextBox == 2){
                    peminjaman_buku.textbox_buku2.setText(judul);
                }
                else if(indexTextBox == 3){
                    peminjaman_buku.textbox_buku3.setText(judul);
                }
                peminjaman_buku.isSearchingOpen = false;
                this.dispose();
            }
        }
    }//GEN-LAST:event_tabel_bukuMouseClicked

    private void btn_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseClicked
        this.dispose();
        //admin dikembalikan ke halaman opsi pendaftaran buku
        if(isAdmin == true && pinjam == false){
            Daftar_buku_option daftar_buku_option = new Daftar_buku_option();
            daftar_buku_option.setVisible(true);
        }
        else if(isAdmin == true && pinjam == true){
            peminjaman_buku.isSearchingOpen = false;
            this.dispose();
        }
        else{
            Pencarian_buku_option pencarian_buku_option = new Pencarian_buku_option();
            pencarian_buku_option.setVisible(true);
        }
    }//GEN-LAST:event_btn_backMouseClicked

    private void btn_searchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_searchMouseEntered

    private void btn_searchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_searchMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_searchMouseExited

    private void btn_backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseEntered
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btn_backMouseEntered

    private void btn_backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_backMouseExited
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btn_backMouseExited

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
            java.util.logging.Logger.getLogger(Searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Searching.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Searching().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn_back;
    private javax.swing.JLabel btn_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel keterangan;
    private javax.swing.JTable tabel_buku;
    private javax.swing.JTextField textbox_search;
    private javax.swing.JLabel validasi;
    // End of variables declaration//GEN-END:variables
}
