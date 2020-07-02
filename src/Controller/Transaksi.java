package Controller;

import Model.Detail_Pemesanan;
import Model.Kategori;
import Model.Kurir;
import Model.Pegawai;
import Model.Pelanggan;
import Model.Pemasok;
import Model.Pemesanan;
import Model.Produk;
import database.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaksi {

    Koneksi koneksi;
    ArrayList<Pelanggan> arrPelanggan;
    ArrayList<Pegawai> arrPegawai;
    ArrayList<Kurir> arrKurir;
    ArrayList<Produk> arrProduk;
    ArrayList<Pemesanan> arrPemesanan;

    public Transaksi() throws SQLException {
        this.koneksi = new Koneksi();
        this.arrPelanggan = new ArrayList<>();
        this.arrPegawai = new ArrayList<>();
        this.arrKurir = new ArrayList<>();
        this.arrProduk = new ArrayList<>();
        this.arrPemesanan = new ArrayList<>();
    }

    public ArrayList<Pelanggan> getDataPelanggan() throws SQLException {
        this.arrPelanggan.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PELANGGAN_06988");
        while (rs.next()) {
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            pelanggan.setNama_Depan(rs.getString("NAMA_DEPAN"));
            pelanggan.setNama_Belakang(rs.getString("NAMA_BELAKANG"));
            pelanggan.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR"));
            pelanggan.setAlamat(rs.getString("ALAMAT"));
            pelanggan.setKode_Pos(rs.getInt("KODE_POS"));
            pelanggan.setNo_Telp(rs.getString("NO_TELP"));

            this.arrPelanggan.add(pelanggan);
        }
        return this.arrPelanggan;
    }

    public ArrayList<Pegawai> getDataPegawai() throws SQLException {
        this.arrPegawai.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PEGAWAI_06988");
        while (rs.next()) {
            Pegawai pegawai = new Pegawai();
            pegawai.setId_Pegawai(rs.getInt("ID_PEGAWAI"));
            pegawai.setNama_Depan(rs.getString("NAMA_DEPAN"));
            pegawai.setNama_Belakang(rs.getString("NAMA_BELAKANG"));
            pegawai.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR"));
            pegawai.setAlamat(rs.getString("ALAMAT"));
            pegawai.setKode_Pos(rs.getInt("KODE_POS"));
            pegawai.setNo_Telp(rs.getString("NO_TELP"));

            this.arrPegawai.add(pegawai);
        }
        return this.arrPegawai;
    }
    
    public ArrayList<Kurir> getDataKurir() throws SQLException {
        this.arrKurir.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM KURIR_06988");
        while (rs.next()) {
            Kurir kurir = new Kurir();
            kurir.setId_Kurir(rs.getInt("ID_KURIR"));
            kurir.setNama_Perusahaan(rs.getString("NAMA_PERUSAHAAN"));
            kurir.setNo_Tlp(rs.getString("NO_TELP"));

            this.arrKurir.add(kurir);
        }
        return this.arrKurir;
    }

    public ArrayList<Produk> getDataProduk() throws SQLException {
        this.arrProduk.clear();
        ResultSet rs = this.koneksi.GetData("SELECT * FROM PRODUK_06988 JOIN KATEGORI_06988 ON "
                + "KATEGORI_06988.ID_KATEGORI = PRODUK_06988.ID_KATEGORI JOIN PEMASOK_06988 "
                + "ON PEMASOK_06988.ID_PEMASOK = PRODUK_06988.ID_PEMASOK");
        while (rs.next()) {
            Kategori kategori = new Kategori();
            kategori.setId_Kategori(rs.getInt("ID_KATEGORI"));
            kategori.setNama_Kategori(rs.getString("NAMA_KATEGORI"));
            
            Pemasok pemasok = new Pemasok();
            pemasok.setId_Pemasok(rs.getInt("ID_PEMASOK"));
            pemasok.setNama_Perusahaan(rs.getString("NAMA_PERUSAHAAN"));
            pemasok.setAlamat(rs.getString("ALAMAT"));
            pemasok.setKode_Pos(rs.getInt("KODE_POS"));
            pemasok.setNo_Tlp(rs.getString("NO_TELP"));

            Produk produk = new Produk();
            produk.setId_Produk(rs.getInt("ID_PRODUK"));
            produk.setPemasok(pemasok);
            produk.setKategori(kategori);
            produk.setNama_Produk(rs.getString("NAMA_PRODUK"));
            produk.setHarga_Satuan(rs.getInt("HARGA_SATUAN"));
            produk.setStok_Produk(rs.getInt("STOK_PRODUK"));

            this.arrProduk.add(produk);
        }
        return this.arrProduk;
    }

      public ArrayList<Pemesanan> getDataPemesanan() throws SQLException {
        this.arrPemesanan.clear();
        ResultSet rs = this.koneksi.GetData("SELECT PELANGGAN_06988.ID_PELANGGAN, PELANGGAN_06988.NAMA_DEPAN AS NAMA_DEPAN_PELANGGAN, "
                + "PELANGGAN_06988.NAMA_BELAKANG AS NAMA_BELAKANG_PELANGGAN, PELANGGAN_06988.TANGGAL_LAHIR AS TANGGAL_LAHIR_PELANGGAN, "
                + "PELANGGAN_06988.ALAMAT AS ALAMAT_PELANGGAN, PELANGGAN_06988.KODE_POS AS KODE_POS_PELANGGAN, "
                + "PELANGGAN_06988.NO_TELP AS NO_TELP_PELANGGAN, PEGAWAI_06988.ID_PEGAWAI, PEGAWAI_06988."
                + "NAMA_DEPAN AS NAMA_DEPAN_PEGAWAI, PEGAWAI_06988.NAMA_BELAKANG AS NAMA_BELAKANG_PEGAWAI, "
                + "PEGAWAI_06988.TANGGAL_LAHIR AS TANGGAL_LAHIR_PEGAWAI, PEGAWAI_06988.ALAMAT AS ALAMAT_PEGAWAI, "
                + "PEGAWAI_06988.KODE_POS AS KODE_POS_PEGAWAI, PEGAWAI_06988.NO_TELP AS NO_TELP_PEGAWAI, "
                + "PEMESANAN_06988.*, KURIR_06988.* FROM PEMESANAN_06988 JOIN PELANGGAN_06988 ON "
                + "PEMESANAN_06988.ID_PELANGGAN = PELANGGAN_06988.ID_PELANGGAN JOIN KURIR_06988 ON PEMESANAN_06988."
                + "ID_KURIR = KURIR_06988.ID_KURIR JOIN PEGAWAI_06988 ON PEMESANAN_06988.ID_PEGAWAI = PEGAWAI_06988.ID_PEGAWAI "
                + "ORDER BY ID_PEMESANAN DESC");
        while (rs.next()) {
            Pelanggan pelanggan = new Pelanggan();
            pelanggan.setId_Pelanggan(rs.getInt("ID_PELANGGAN"));
            pelanggan.setNama_Depan(rs.getString("NAMA_DEPAN_PELANGGAN"));
            pelanggan.setNama_Belakang(rs.getString("NAMA_BELAKANG_PELANGGAN"));
            pelanggan.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR_PELANGGAN"));
            pelanggan.setAlamat(rs.getString("ALAMAT_PELANGGAN"));
            pelanggan.setKode_Pos(rs.getInt("KODE_POS_PELANGGAN"));
            pelanggan.setNo_Telp(rs.getString("NO_TELP_PELANGGAN"));

            Pegawai pegawai = new Pegawai();
            pegawai.setId_Pegawai(rs.getInt("ID_PEGAWAI"));
            pegawai.setNama_Depan(rs.getString("NAMA_DEPAN_PEGAWAI"));
            pegawai.setNama_Belakang(rs.getString("NAMA_BELAKANG_PEGAWAI"));
            pegawai.setTanggal_Lahir(rs.getDate("TANGGAL_LAHIR_PEGAWAI"));
            pegawai.setAlamat(rs.getString("ALAMAT_PEGAWAI"));
            pegawai.setKode_Pos(rs.getInt("KODE_POS_PEGAWAI"));
            pegawai.setNo_Telp(rs.getString("NO_TELP_PEGAWAI"));

            Kurir kurir = new Kurir();
            kurir.setId_Kurir(rs.getInt("ID_KURIR"));
            kurir.setNama_Perusahaan(rs.getString("NAMA_PERUSAHAAN"));
            kurir.setNo_Tlp(rs.getString("NO_TELP"));

            Pemesanan pemesanan = new Pemesanan();
            pemesanan.setId_Pemesanan(rs.getInt("ID_PEMESANAN"));
            pemesanan.setPelanggan(pelanggan);
            pemesanan.setPegawai(pegawai);
            pemesanan.setKurir(kurir);
            pemesanan.setTanggal_Pemesanan(rs.getDate("TANGGAL_PEMESANAN"));
            pemesanan.setTanggal_Pengiriman(rs.getDate("TANGGAL_PENGIRIMAN"));
            pemesanan.setAlamat_Pengiriman(rs.getString("ALAMAT_PENGIRIMAN"));
            pemesanan.setHarga_Total(rs.getDouble("HARGA_TOTAL"));

            ResultSet rsDetail_Pemesanan = this.koneksi.GetData("SELECT * FROM DETAIL_PEMESANAN_06988 JOIN PRODUK_06988 ON "
                    + "DETAIL_PEMESANAN_06988.ID_PRODUK = PRODUK_06988.ID_PRODUK JOIN PEMASOK_06988 ON "
                    + "PRODUK_06988.ID_PEMASOK = PEMASOK_06988.ID_PEMASOK JOIN KATEGORI_06988 ON "
                    + "PRODUK_06988.ID_KATEGORI = KATEGORI_06988.ID_KATEGORI "
                    + "WHERE DETAIL_PEMESANAN_06988.ID_PEMESANAN = " + rs.getString("ID_PEMESANAN"));
            ArrayList<Detail_Pemesanan> dp = new ArrayList<>();

            while (rsDetail_Pemesanan.next()) {
                Pemasok pemasok = new Pemasok();
                pemasok.setId_Pemasok(rsDetail_Pemesanan.getInt("ID_PEMASOK"));
                pemasok.setNama_Perusahaan(rsDetail_Pemesanan.getString("NAMA_PERUSAHAAN"));
                pemasok.setAlamat(rsDetail_Pemesanan.getString("ALAMAT"));
                pemasok.setKode_Pos(rsDetail_Pemesanan.getInt("KODE_POS"));
                pemasok.setNo_Tlp(rsDetail_Pemesanan.getString("NO_TELP"));

                Kategori kategori = new Kategori();
                kategori.setId_Kategori(rsDetail_Pemesanan.getInt("ID_KATEGORI"));
                kategori.setNama_Kategori(rsDetail_Pemesanan.getString("NAMA_KATEGORI"));

                Produk produk = new Produk();
                produk.setId_Produk(rsDetail_Pemesanan.getInt("ID_PRODUK"));
                produk.setPemasok(pemasok);
                produk.setKategori(kategori);
                produk.setNama_Produk(rsDetail_Pemesanan.getString("NAMA_PRODUK"));
                produk.setHarga_Satuan(rsDetail_Pemesanan.getInt("HARGA_SATUAN"));
                produk.setStok_Produk(rsDetail_Pemesanan.getInt("STOK_PRODUK"));

                Detail_Pemesanan detail_pemesanan = new Detail_Pemesanan();
                detail_pemesanan.setProduk(produk);
                detail_pemesanan.setJumlah(rsDetail_Pemesanan.getInt("JUMLAH"));
                detail_pemesanan.setDiskon(rsDetail_Pemesanan.getDouble("DISKON"));

                dp.add(detail_pemesanan);
            }
            pemesanan.setArrDetail_Pemesanan(dp);

            this.arrPemesanan.add(pemesanan);
        }
        return this.arrPemesanan;
    }

    public void insertTransaksi(Pemesanan pemesanan) {
        try {
            String datePemesanan = new SimpleDateFormat("dd/MM/yyyy").format(pemesanan.getTanggal_Pemesanan());
            String datePengiriman = new SimpleDateFormat("dd/MM/yyyy").format(pemesanan.getTanggal_Pengiriman());

            this.koneksi.ManipulasiData("INSERT INTO PEMESANAN_06988 VALUES (ID_PEMESANAN.NEXTVAL," + 
                    pemesanan.getPelanggan().getId_Pelanggan() + "," + pemesanan.getPegawai().getId_Pegawai() + "," + 
                    pemesanan.getKurir().getId_Kurir() + ", TO_DATE('" + datePemesanan + "','dd/MM/yyyy'),TO_DATE"
                            + "('" + datePemesanan + "','dd/MM/yyyy'),'" + pemesanan.getAlamat_Pengiriman() + "'," + 
                    pemesanan.getHarga_Total().toString() + ")");
            ResultSet rs = this.koneksi.GetData("SELECT ID_PEMESANAN.CURRVAL FROM DUAL");
            rs.next();
            int id_pemesanan = rs.getInt("CURRVAL");
            for (Detail_Pemesanan p : pemesanan.getArrDetail_Pemesanan()) {
                this.koneksi.ManipulasiData("INSERT INTO DETAIL_PEMESANAN_06988 VALUES (" + p.getProduk().getId_Produk() + "," + id_pemesanan + "," + p.getJumlah() + "," + p.getDiskon() + ")");
                this.koneksi.ManipulasiData("UPDATE PRODUK_06988 SET STOK_PRODUK=STOK_PRODUK-" + p.getJumlah() + "WHERE ID_PRODUK=" + p.getProduk().getId_Produk());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}
