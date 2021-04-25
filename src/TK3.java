import java.util.*;

public class TK3 {

    static String nama_produk = "-";
    static int jumlah_produk;

    static ArrayList<Produk> list = new ArrayList<Produk>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            menuUtama();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }


    }

    static void menuUtama() {
        String pilihan = "";
        System.out.println("====== Menu ======");
        System.out.println("1. Tambah Produk");
        System.out.println("2. Hapus Produk");
        System.out.println("3. Ubah Produk");
        System.out.println("4. Lihat Produk");
        System.out.println("5. Keluar");

        System.out.print("Masukkan pilihan > ");
        pilihan = input.nextLine();
        switch (pilihan) {
            case "1":
                tambahProduk();
                break;
            case "2":
                hapusProduk();
                break;
            case "3":
                ubahProduk();
                break;
            case "4":
                lihatProduk();
                break;
            case "5":
                break;
            default:
                menuUtama();
                break;
        }
    }

    static void tambahProduk() {

        System.out.println("***** Tambah Produk *****");

        System.out.print("Nama Produk > ");
        nama_produk = input.nextLine();
        System.out.print("Jumlah Produk > ");
        try {
            jumlah_produk = Integer.parseInt(input.nextLine());
            list.add(new Produk(nama_produk, jumlah_produk));
        } catch (InputMismatchException ime) {
            System.out.println("Hanya Menerima inputan angka");
        }
        menuUtama();
    }

    static void hapusProduk() {

    }

    private static void ubahProduk() {
        System.out.print("Masukan nama produk yang ingin diubah: ");
        String x = input.nextLine();
        boolean flag = false;
        for (Produk element : list) {
            if (element.getNama_produk().contains(x)) {
                System.out.print("Jumlah Produk >");
                try {
                    jumlah_produk = Integer.parseInt(input.nextLine());
                    do {
                        System.out.print("Apakah Anda yakin dengan jumlah produk saat ini? [Ya | Tidak]");
                        String jawab = input.nextLine();
                        if (jawab.equals("Ya")) {
                            element.setJumlah_produk(jumlah_produk);
                            flag = true;
                        }else if(jawab.equals("Tidak")){
                            flag=true;
                        }
                    } while (!flag);

                } catch (InputMismatchException ime) {
                    System.out.println("Hanya Menerima inputan angka");
                }
            } else {
                System.out.println("Produk yang dicari tidak ada");
                break;
            }
        }
        menuUtama();
    }

    static void lihatProduk() {
        //for loop untuk menampilkan nama buah, jumlah, dan harga setiap elemen
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + 1 + ".) Nama produk " + list.get(i).getNama_produk() + " jumlah produk " +
                    list.get(i).getJumlah_produk());

        }
        menuUtama();
    }

}
