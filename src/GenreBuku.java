public class GenreBuku {
    // Memakai private untuk encapsulation (keamanan data)
    private String idGenre;
    private String namaGenre;
    private String deskripsi;

    // Constructor: Dijalankan pertama kali saat object dibuat
    public GenreBuku(String idGenre, String namaGenre, String deskripsi) {
        this.idGenre = idGenre;
        this.namaGenre = namaGenre;
        this.deskripsi = deskripsi;
    }

    // --- Getter (Untuk mengambil data) ---
    public String getIdGenre() {
        return idGenre;
    }

    public String getNamaGenre() {
        return namaGenre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    // --- Setter (Untuk mengubah data jika diperlukan) ---
    public void setIdGenre(String idGenre) {
        this.idGenre = idGenre;
    }

    public void setNamaGenre(String namaGenre) {
        this.namaGenre = namaGenre;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    // Method tambahan untuk menampilkan info genre dengan rapi
    public void tampilkanInfoGenre() {
        System.out.println("ID Genre   : " + idGenre);
        System.out.println("Nama Genre : " + namaGenre);
        System.out.println("Deskripsi  : " + deskripsi);
        System.out.println("-----------------------------------");
    }
}