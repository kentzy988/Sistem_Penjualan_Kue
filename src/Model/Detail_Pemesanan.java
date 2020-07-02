package Model;

public class Detail_Pemesanan {

    private Produk produk;
    private Integer Jumlah;
    private Double Diskon;

    public Produk getProduk() {
        return produk;
    }

    public void setProduk(Produk produk) {
        this.produk = produk;
    }

    public Integer getJumlah() {
        return Jumlah;
    }

    public void setJumlah(Integer Jumlah) {
        this.Jumlah = Jumlah;
    }

    public Double getDiskon() {
        return Diskon;
    }

    public void setDiskon(Double Diskon) {
        this.Diskon = Diskon;
    }

}
