import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Peminjaman {
    private int id_peminjaman;
    private int id_member;
    private int id_buku;
    private LocalDate tanggal_pinjam;
    private LocalDate tanggalPengembalianAktual;
    private String status;
    private int denda;

    // Batas waktu peminjaman (asumsi 7 hari sejak tanggal pinjam)
    private static final int BATAS_HARI_PINJAM = 7;
    private static final int DENDA_PER_HARI = 2000; // dalam rupiah

    // Referensi objek untuk mempermudah pemanggilan method Buku & Member
    private Member member;
    private Buku buku;

    public Peminjaman(int id_peminjaman, Member member, Buku buku) {
        this.id_peminjaman = id_peminjaman;
        this.member = member;
        this.buku = buku;
        this.id_member = member.getId_member();
        this.id_buku = buku.getId_buku();
        this.tanggal_pinjam = LocalDate.now();
        this.tanggalPengembalianAktual = null;
        this.status = "Menunggu Diproses";
        this.denda = 0;
    }

    public void prosesPeminjaman() {
        if (!buku.cekKetersediaan()) {
            System.out.println("Peminjaman gagal! Buku '" + buku.getJudul() + "' tidak tersedia.");
            this.status = "Gagal";
            return;
        }
        buku.kurangiStok(1);
        this.status = "Dipinjam";
        member.tambahRiwayatPeminjaman(this);
        System.out.println("Peminjaman berhasil: " + member.getNama() + " meminjam '" + buku.getJudul() + "'.");
    }

    public void prosesPengembalian() {
        this.tanggalPengembalianAktual = LocalDate.now();
        boolean terlambat = cekKeterlambatanPengembalian();

        if (terlambat) {
            hitungDenda();
            this.status = "Dikembalikan (Terlambat)";
        } else {
            this.status = "Dikembalikan";
        }

        buku.tambahStok(1);
        System.out.println("Pengembalian buku '" + buku.getJudul() + "' oleh " + member.getNama()
                + " berhasil dicatat. Status: " + status + ", Denda: Rp" + denda);
    }

    public int hitungDenda() {
        LocalDate batasKembali = tanggal_pinjam.plusDays(BATAS_HARI_PINJAM);
        LocalDate tanggalCek = (tanggalPengembalianAktual != null) ? tanggalPengembalianAktual : LocalDate.now();

        long selisihHari = ChronoUnit.DAYS.between(batasKembali, tanggalCek);
        if (selisihHari > 0) {
            this.denda = (int) selisihHari * DENDA_PER_HARI;
        } else {
            this.denda = 0;
        }
        return this.denda;
    }

    public boolean cekKeterlambatanPengembalian() {
        LocalDate batasKembali = tanggal_pinjam.plusDays(BATAS_HARI_PINJAM);
        LocalDate tanggalCek = (tanggalPengembalianAktual != null) ? tanggalPengembalianAktual : LocalDate.now();
        return tanggalCek.isAfter(batasKembali);
    }

    // Getter & Setter
    public int getId_peminjaman() {
        return id_peminjaman;
    }

    public void setId_peminjaman(int id_peminjaman) {
        this.id_peminjaman = id_peminjaman;
    }

    public int getId_member() {
        return id_member;
    }

    public int getId_buku() {
        return id_buku;
    }

    public LocalDate getTanggal_pinjam() {
        return tanggal_pinjam;
    }

    public LocalDate getTanggalPengembalianAktual() {
        return tanggalPengembalianAktual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDenda() {
        return denda;
    }

    public Member getMember() {
        return member;
    }

    public Buku getBuku() {
        return buku;
    }

    @Override
    public String toString() {
        return "Peminjaman{id=" + id_peminjaman + ", buku=" + buku.getJudul()
                + ", tglPinjam=" + tanggal_pinjam + ", status=" + status + ", denda=Rp" + denda + "}";
    }
}
