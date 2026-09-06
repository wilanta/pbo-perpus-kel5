public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEM PERPUSTAKAAN =====\n");

        // 1. Membuat data Genre
        GenreBuku genreFiksi = new GenreBuku(1, "Fiksi", "Buku cerita rekaan/imajinatif");
        GenreBuku genreSains = new GenreBuku(2, "Sains", "Buku ilmiah dan pengetahuan alam");
        genreFiksi.tambahGenre();
        genreSains.tambahGenre();

        System.out.println();

        // 2. Membuat data Buku
        Buku buku1 = new Buku(101, "Laskar Pelangi", "Andrea Hirata", "Bentang Pustaka", 2005, 3, genreFiksi);
        Buku buku2 = new Buku(102, "Sejarah Singkat Waktu", "Stephen Hawking", "Bantam Books", 1988, 1, genreSains);

        System.out.println();

        // 3. Membuat data Member
        Member member1 = new Member(1, "Jason", "Bogor", "081234567890");
        Member member2 = new Member(2, "Lucia", "Jakarta", "089876543210");

        System.out.println();

        // 4. Proses Peminjaman
        Peminjaman peminjaman1 = new Peminjaman(1001, member1, buku1);
        peminjaman1.prosesPeminjaman();

        Peminjaman peminjaman2 = new Peminjaman(1002, member2, buku2);
        peminjaman2.prosesPeminjaman();

        // Percobaan meminjam buku yang stoknya habis
        Peminjaman peminjaman3 = new Peminjaman(1003, member1, buku2);
        peminjaman3.prosesPeminjaman();

        System.out.println();

        // 5. Proses Pengembalian
        peminjaman1.prosesPengembalian();

        System.out.println();

        // 6. Melihat riwayat peminjaman tiap member
        member1.lihatRiwayatPeminjaman();
        System.out.println();
        member2.lihatRiwayatPeminjaman();

        System.out.println();

        // 7. Menampilkan buku dalam satu genre (relasi agregasi Buku - genreBuku)
        System.out.println("Daftar buku dengan genre '" + genreFiksi.getNamaGenre() + "':");
        for (Buku b : genreFiksi.getDaftarBuku()) {
            System.out.println("- " + b);
        }
    }
}
