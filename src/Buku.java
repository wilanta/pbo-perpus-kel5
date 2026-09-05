public class Buku {

    private int id_buku;
    private String judul;
    private String penulis;
    private String penerbit;
    private int tahunTerbit;
    private int stok;

    // Relasi Agregasi: satu Buku memiliki satu GenreBuku
    private GenreBuku genreBuku;

    public Buku(int id_buku, String judul, String penulis, String penerbit, int tahunTerbit, int stok, GenreBuku genreBuku) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.penulis = penulis;
        this.penerbit = penerbit;
        this.tahunTerbit = tahunTerbit;
        this.stok = stok;
        this.genreBuku = genreBuku;

        if (genreBuku != null) {
            genreBuku.tambahBuku(this);
        }
    }
    public boolean cekKetersediaan() {
        return stok > 0;
    }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
        System.out.println("Stok buku '" + judul + "' bertambah " + jumlah + ". Stok sekarang: " + stok);
    }

    public void kurangiStok(int jumlah) {
        if (stok - jumlah < 0) {
            System.out.println("Gagal! Stok buku '" + judul + "' tidak mencukupi.");
            return;
        }
        this.stok -= jumlah;
        System.out.println("Stok buku '" + judul + "' berkurang " + jumlah + ". Stok sekarang: " + stok);
    }

    // Getter & Setter
    public int getId_buku() {
        return id_buku;
    }

    public void setId_buku(int id_buku) {
        this.id_buku = id_buku;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getTahunTerbit() {
        return tahunTerbit;
    }

    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public GenreBuku getGenreBuku() {
        return genreBuku;
    }

    public void setGenreBuku(GenreBuku genreBuku) {
        this.genreBuku = genreBuku;
    }

    @Override
    public String toString() {
        return "Buku{" + id_buku + " - " + judul + ", stok=" + stok + "}";
    }

}