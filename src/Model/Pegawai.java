package Model;

import java.util.Date;

public class Pegawai {

    private Integer Id_Pegawai;
    private String Nama_Depan;
    private String Nama_Belakang;
    private Date Tanggal_Lahir;
    private String Alamat;
    private Integer Kode_Pos;
    private String No_Telp;

    public Integer getId_Pegawai() {
        return Id_Pegawai;
    }

    public void setId_Pegawai(Integer Id_Pegawai) {
        this.Id_Pegawai = Id_Pegawai;
    }

    public String getNama_Depan() {
        return Nama_Depan;
    }

    public void setNama_Depan(String Nama_Depan) {
        this.Nama_Depan = Nama_Depan;
    }

    public String getNama_Belakang() {
        return Nama_Belakang;
    }

    public void setNama_Belakang(String Nama_Belakang) {
        this.Nama_Belakang = Nama_Belakang;
    }

    public Date getTanggal_Lahir() {
        return Tanggal_Lahir;
    }

    public void setTanggal_Lahir(Date Tanggal_Lahir) {
        this.Tanggal_Lahir = Tanggal_Lahir;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public Integer getKode_Pos() {
        return Kode_Pos;
    }

    public void setKode_Pos(Integer Kode_Pos) {
        this.Kode_Pos = Kode_Pos;
    }

    public String getNo_Telp() {
        return No_Telp;
    }

    public void setNo_Telp(String No_Telp) {
        this.No_Telp = No_Telp;
    }

}
