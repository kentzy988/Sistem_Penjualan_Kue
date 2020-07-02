package Model;

public class Produk {

    private Integer Id_Produk;
    private Pemasok pemasok;
    private Kategori kategori;
    private String Nama_Produk;
    private Integer Harga_Satuan;
    private Integer Stok_Produk;

    public Integer getId_Produk() {
        return Id_Produk;
    }

    public void setId_Produk(Integer Id_Produk) {
        this.Id_Produk = Id_Produk;
    }

    public Pemasok getPemasok() {
        return pemasok;
    }

    public void setPemasok(Pemasok pemasok) {
        this.pemasok = pemasok;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getNama_Produk() {
        return Nama_Produk;
    }

    public void setNama_Produk(String Nama_Produk) {
        this.Nama_Produk = Nama_Produk;
    }

    public Integer getHarga_Satuan() {
        return Harga_Satuan;
    }

    public void setHarga_Satuan(Integer Harga_Satuan) {
        this.Harga_Satuan = Harga_Satuan;
    }

    public Integer getStok_Produk() {
        return Stok_Produk;
    }

    public void setStok_Produk(Integer Stok_Produk) {
        this.Stok_Produk = Stok_Produk;
    }

}
