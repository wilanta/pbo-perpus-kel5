import java.util.ArrayList;
import java.util.List;

public class GenreBuku {
    private int idGenre;
    private String namaGenre;
    private String deskripsi;

    // Menyimpan daftar buku yang tergabung dalam genre ini (sisi "1" pada relasi agregasi)
    private List<Buku> daftarBuku;

    public GenreBuku(int idGenre, String namaGenre, String deskripsi) {
        this.idGenre = idGenre;
        this.namaGenre = namaGenre;
        this.deskripsi = deskripsi;
        this.daftarBuku = new ArrayList<>();
    }

    public void tambahGenre() {
        System.out.println("Genre baru ditambahkan: " + namaGenre + " (ID: " + idGenre + ")");
    }

    public void ubahGenre() {
        System.out.println("Genre dengan ID " + idGenre + " berhasil diubah.");
    }

    public void hapusGenre() {
        System.out.println("Genre dengan ID " + idGenre + " berhasil dihapus.");
    }

    // Method bantu untuk relasi agregasi ke Buku
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public List<Buku> getDaftarBuku() {
        return daftarBuku;
    }

    // Getter & Setter
    public int getIdGenre() {
        return idGenre;
    }

    public void setIdGenre(int idGenre) {
        this.idGenre = idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public void setNamaGenre(String namaGenre) {
        this.namaGenre = namaGenre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {
        return "Genre{" + idGenre + " - " + namaGenre + "}";
    }
}
