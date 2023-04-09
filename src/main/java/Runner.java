public class Runner extends Depo {
    public static void main(String[] args) {
        urunEkle();
        startMarket();
    }

    private static void urunEkle() {
        Urunler domates = new Urunler("00", "Domates", 2.10);
        Urunler patates = new Urunler("01", "Patates", 3.20);
        Urunler biber = new Urunler("02", "Biber", 1.50);
        Urunler sogan = new Urunler("03", "Sogan", 2.30);
        Urunler havuc = new Urunler("04", "Havuc", 3.10);
        Urunler elma = new Urunler("05", "Elma", 1.20);
        Urunler muz = new Urunler("06", "Muz", 1.90);
        Urunler cilek = new Urunler("07", "Cilek", 6.10);
        Urunler kavun = new Urunler("08", "Kavun", 4.30);
        Urunler uzum = new Urunler("09", "Uzum", 2.70);
        Urunler limon = new Urunler("10", "Limon", 0.50);


        urunlerList.add(domates);
        urunlerList.add(patates);
        urunlerList.add(biber);
        urunlerList.add(sogan);
        urunlerList.add(havuc);
        urunlerList.add(elma);
        urunlerList.add(muz);
        urunlerList.add(cilek);
        urunlerList.add(kavun);
        urunlerList.add(uzum);
        urunlerList.add(limon);
    }

    private static void startMarket() {

        System.out.println("Yapmak istediginiz islemi giriniz\n1-Urun Al\n2-Cikis");
        secim = scan.next();
        switch (secim) {
            case "1":
                urunAl();
            case "2":
                System.exit(0);
            default:
                System.out.println("Hatali giris");
                startMarket();
        }


    }

    private static void urunAl() {
        System.out.println(urunlerList);
        System.out.println("listeden almak istediginiz urunu seciniz");
        secim = scan.next();
        if (!urunKontrol(secim)) {
            System.out.println("Gecerli urun giriniz");
            urunAl();
        }

        System.out.println("Kac kilo almak istersiniz");
        kilo=scan.next();
        alinanUrunSecim(secim);
    }

    private static boolean urunKontrol(String secim) {
        boolean bl=false;
        for (Urunler urunler : urunlerList) {
            String secilenId=urunlerList.get(urunlerList.indexOf(urunler)).getId();
            if (secilenId.equals(secim) ) {
                bl=true;
            }
        }return bl;

    }

    private static void alinanUrunSecim(String secim) {
        secilenUrunlerList.add(urunlerList.get(Integer.parseInt(secim)));
        totalPrice += (urunlerList.get(Integer.parseInt(secim)).getPrice()*Double.parseDouble(kilo));
        System.out.println("Sepetiniz: " + secilenUrunlerList);
        System.out.println("Yapmak istediginiz islemi giriniz\n1-Sepete urun ekle\n2-odeme");
        secim = scan.next();
        switch (secim) {
            case "1":
                urunAl();
            case "2":
                odeme();
            default:
                System.out.println("Yanlis secim");
                odeme();
        }
    }

    private static void odeme() {

        System.out.println("Aldiginiz urunler \n"+secilenUrunlerList);
        System.out.println("Odemeniz gerekn tutar: " + totalPrice);
        System.out.println( " odeme tutari giriniz");
        odenenTutar=scan.next();
        double odeme=Double.parseDouble(odenenTutar);
        if (odeme<totalPrice) {
            System.out.println("eksik odeme yaptiniz");
            odeme();
        }else {
            paraUstu=odeme-totalPrice;
        }
        System.out.println("Para ustu "+ paraUstu+"\nBizi tercih ettiginiz icin tesekkur ederiz");

            startMarket();
    }
}
