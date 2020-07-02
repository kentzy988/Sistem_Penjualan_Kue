package Model;

import java.util.ArrayList;
import java.util.Date;

public class Pemesanan {

    private Integer Id_Pemesanan;
    private Pelanggan pelanggan;
    private Pegawai pegawai;
    private Kurir kurir;
    private Date Tanggal_Pemesanan;
    private Date Tanggal_Pengiriman;
    private String Alamat_Pengiriman;
    private Double Harga_Total;
    private ArrayList<Detail_Pemesanan> arrDetail_Pemesanan;

    public Integer getId_Pemesanan() {
        return Id_Pemesanan;
    }

    public void setId_Pemesanan(Integer Id_Pemesanan) {
        this.Id_Pemesanan = Id_Pemesanan;
    }

    public Pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public Pegawai getPegawai() {
        return pegawai;
    }

    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    public Kurir getKurir() {
        return kurir;
    }

    public void setKurir(Kurir kurir) {
        this.kurir = kurir;
    }

    public Date getTanggal_Pemesanan() {
        return Tanggal_Pemesanan;
    }

    public void setTanggal_Pemesanan(Date Tanggal_Pemesanan) {
        this.Tanggal_Pemesanan = Tanggal_Pemesanan;
    }

    public Date getTanggal_Pengiriman() {
        return Tanggal_Pengiriman;
    }

    public void setTanggal_Pengiriman(Date Tanggal_Pengiriman) {
        this.Tanggal_Pengiriman = Tanggal_Pengiriman;
    }

    public String getAlamat_Pengiriman() {
        return Alamat_Pengiriman;
    }

    public void setAlamat_Pengiriman(String Alamat_Pengiriman) {
        this.Alamat_Pengiriman = Alamat_Pengiriman;
    }

    public Double getHarga_Total() {
        return Harga_Total;
    }

    public void setHarga_Total(Double Harga_Total) {
        this.Harga_Total = Harga_Total;
    }

    public ArrayList<Detail_Pemesanan> getArrDetail_Pemesanan() {
        return arrDetail_Pemesanan;
    }

    public void setArrDetail_Pemesanan(ArrayList<Detail_Pemesanan> arrDetail_Pemesanan) {
        this.arrDetail_Pemesanan = arrDetail_Pemesanan;
    }

}
