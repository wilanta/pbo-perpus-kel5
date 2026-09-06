import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id_member;
    private String nama;
    private String alamat;
    private String noTelepon;

    // Relasi Asosiasi: satu Member memiliki 0..* riwayat Peminjaman
    private List<Peminjaman> riwayatPeminjaman;

    public Member(int id_member, String nama, String alamat, String noTelepon) {
        this.id_member = id_member;
        this.nama = nama;
        this.alamat = alamat;
        this.noTelepon = noTelepon;
        this.riwayatPeminjaman = new ArrayList<>();
    }

    public void lihatRiwayatPeminjaman() {
        System.out.println("=== Riwayat Peminjaman " + nama + " ===");
        if (riwayatPeminjaman.isEmpty()) {
            System.out.println("Belum ada riwayat peminjaman.");
            return;
        }
        for (Peminjaman p : riwayatPeminjaman) {
            System.out.println(p);
        }
    }

    // Method bantu untuk relasi ke Peminjaman
    public void tambahRiwayatPeminjaman(Peminjaman peminjaman) {
        riwayatPeminjaman.add(peminjaman);
    }

    // Getter & Setter
    public int getId_member() {
        return id_member;
    }

    public void setId_member(int id_member) {
        this.id_member = id_member;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public void setNoTelepon(String noTelepon) {
        this.noTelepon = noTelepon;
    }

    @Override
    public String toString() {
        return "Member{" + id_member + " - " + nama + "}";
    }
}
