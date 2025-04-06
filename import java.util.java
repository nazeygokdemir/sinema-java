 import java.util.Scanner;

public class SinemaKayitSistemi {

    static String[] filmAdlari = new String[10];
    static int[] filmSureleri = new int[10];
    static String[] filmTurleri = new String[10];
    static int filmSayisi = 0;

    static String[] musteriAdlari = new String[20];
    static String[] musteriEmailleri = new String[20];
    static int musteriSayisi = 0;

    static int[][] biletler = new int[20][1]; // Her müşteri için bir film kaydı

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int secim;

        do {
            System.out.println("\n--- Sinema Müşteri Kayıt Sistemi ---");
            System.out.println("2. Müşteri Ekle");
            System.out.println("3. Bilet Oluştur");
            System.out.println("4. Filmleri Listele");
            System.out.println("5. Müşterileri Listele");
            System.out.println("6. Biletleri Listele");
            System.out.println("0. Çıkış");
            System.out.print("Seçiminiz: ");
            secim = input.nextInt();
            input.nextLine(); // Dummy read

            switch (secim) {
                case 1:
                    filmEkle(input);
                    break;
                case 2:
                    musteriEkle(input);
                    break;
                case 3:
                    biletOlustur(input);
                    break;
                case 4:
                    filmleriListele();
                    break;
                case 5:
                    musterileriListele();
                    break;
                case 6:
                    biletleriListele();
                    break;
                case 0:
                    System.out.println("Çıkılıyor...");
                    break;
                default:
                    System.out.println("Geçersiz seçim!");
            }
        } while (secim != 0);
    }

    public static void filmEkle(Scanner input) {
        if (filmSayisi >= 10) {
            System.out.println("Maksimum film sayısına ulaşıldı.");
            return;
        }

        System.out.print("Film Adı: ");
        filmAdlari[filmSayisi] = input.nextLine();

        System.out.print("Film Süresi (dk): ");
        filmSureleri[filmSayisi] = input.nextInt();
        input.nextLine();

        System.out.print("Film Türü: ");
        filmTurleri[filmSayisi] = input.nextLine();

        filmSayisi++;
        System.out.println("Film eklendi.");
    }

    public static void musteriEkle(Scanner input) {
        if (musteriSayisi >= 20) {
            System.out.println("Maksimum müşteri sayısına ulaşıldı.");
            return;
        }

        System.out.print("Müşteri Adı: ");
        musteriAdlari[musteriSayisi] = input.nextLine();

        System.out.print("Email: ");
        musteriEmailleri[musteriSayisi] = input.nextLine();

        musteriSayisi++;
        System.out.println("Müşteri eklendi.");
    }

    public static void biletOlustur(Scanner input) {
        if (musteriSayisi == 0 || filmSayisi == 0) {
            System.out.println("Önce müşteri ve film eklemelisiniz.");
            return;
        }

        musterileriListele();
        System.out.print("Müşteri numarası (0-" + (musteriSayisi - 1) + "): ");
        int musteriIndex = input.nextInt();

        filmleriListele();
        System.out.print("Film numarası (0-" + (filmSayisi - 1) + "): ");
        int filmIndex = input.nextInt();

        if (musteriIndex >= 0 && musteriIndex < musteriSayisi &&
            filmIndex >= 0 && filmIndex < filmSayisi) {
            biletler[musteriIndex][0] = filmIndex;
            System.out.println("Bilet başarıyla oluşturuldu.");
        } else {
            System.out.println("Geçersiz giriş!");
        }
    }

    public static void filmleriListele() {
        System.out.println("\n--- Filmler ---");
        for (int i = 0; i < filmSayisi; i++) {
            System.out.println(i + ". " + filmAdlari[i] + " | Süre: " + filmSureleri[i] + " dk | Tür: " + filmTurleri[i]);
        }
    }

    public static void musterileriListele() {
        System.out.println("\n--- Müşteriler ---");
        for (int i = 0; i < musteriSayisi; i++) {
            System.out.println(i + ". " + musteriAdlari[i] + " | Email: " + musteriEmailleri[i]);
        }
    }

    public static void biletleriListele() {
        System.out.println("\n--- Biletler ---");
        for (int i = 0; i < musteriSayisi; i++) {
            int filmIndex = biletler[i][0];
            if (filmIndex < filmSayisi) {
                System.out.println("Müşteri: " + musteriAdlari[i] + " -> Film: " + filmAdlari[filmIndex]);
            }
        }
    }
}
