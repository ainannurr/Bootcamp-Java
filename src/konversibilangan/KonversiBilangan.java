/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konversibilangan;

import java.util.Scanner;

/**
 *
 * @author AINAN
 */
public class KonversiBilangan {
    
    String biner[] = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
    int desimal[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    int oktal[] = {0, 1, 2, 3, 4, 5, 6, 7};
    String heksa[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    
    public 
    
    /**
     * fungsi ini digunakan untuk mengkonversi bilangan biner menjadi bilangan desimal
     * @param bilBiner bertipe data String
     * @return hslakhir yang akan dihasilkan dari fungsi tersebut
     */
    public int BinertoDesimal(String bilBiner){
        int pangkat[] = {3, 2, 1, 0};
        int basis = 2;
        String num = String.valueOf(bilBiner);
        int hasil[] = new int[num.length()];
        int bnr[] = new int[num.length()];
        int hslakhir = 0;
        for (int i = 0; i < num.length(); i++) {
            bnr[i] = Character.digit(num.charAt(i), 10);
        }
        for (int i = 3; i >= 0; i--) {
            hasil[i] = bnr[i]*((int)Math.pow(basis, pangkat[i]));
            hslakhir += hasil[i];
        }
        return hslakhir;
    }
    
    /**
     * fungsi OktaltoDesimal adalah fungsi yang digunakan untuk mengkonversi bilangan oktal ke desimal
     * @param bilOkt digunakan untuk sebagai masukkan bilangan oktal
     * @return hslakhir yang akan dihasilkan dari fungsi OktaltoDesimal
     */
    public int OktaltoDesimal (int bilOkt){
        int basis = 8;
        String num = String.valueOf(bilOkt);
        int hasil[] = new int[num.length()];
        int okt[] = new int[num.length()];
        int hslakhir = 0;
        for (int i = 0; i < num.length(); i++) {
            okt[i] = Character.digit(num.charAt(i), 10);
        }
        int a = 0;
        for (int i = num.length()-1; i >= 0; i--) {
            hasil[i] = okt[i]*((int)Math.pow(basis, 0+a));
            hslakhir += hasil[i];
            a++;
        }
        return hslakhir;
    }
    
    /**
     * fungsi ini merupakan fungsi yang digunakan untuk mengubah bilangan heksadesimal menjadi bilangan desimal
     * @param hexa bertipe data String
     * @return nilai yang akan dikembalikan dalam fungsi HexatoDesimal
     */
    public int HexatoDesimal (String bilHex){
        int basis = 16;
        String ch[] = bilHex.split("");
        String hx[] = new String[ch.length];
        int hslakhir = 0;
        int temp;
        
        for (int i = 0; i < ch.length; i++) {
            hx[i] = ch[i];
        }
        int hasil[] = new int[hx.length];
        int a = 0;
        for (int i = hx.length - 1; i >= 0; i--){
            if (hx[i].equals("A")){
                temp = 10;
            } else if (hx[i].equals("B")){
                temp = 11;
            } else if (hx[i].equals("C")){
                temp = 12;
            } else if (hx[i].equals("D")){
                temp = 13;
            } else if (hx[i].equals("E")){
                temp = 14;
            } else if (hx[i].equals("F")){
                temp = 15;
            } else
                temp = Integer.parseInt(hx[i]);
            hasil[i] = temp * ((int) Math.pow(basis, 0+a));
            hslakhir += hasil[i];
            a++;
        }
        return hslakhir;
    }
    
    /**
     * fungsi ini merupakan fungsi yang digunakan untuk mengkonversi bilangan desimal menjadi bilangan biner
     * @param bilDesimal bertipe data integer
     * @return hslakhir yang akan dikembalikan pada fungsi DesimaltoBiner
     */
    public String DesimaltoBiner (int bilDesimal){
        String hslakhir = "";
        String num = String.valueOf(bilDesimal);
        int sisa = bilDesimal;
        int temp = 0;
        int i = 0;
        do {
            temp = bilDesimal / 2;
            sisa = bilDesimal % 2;
            bilDesimal = temp;
            hslakhir += sisa;
            if (temp == 1){
                hslakhir += temp;
            }
        } while (temp >= 2);
        StringBuffer balik;
        balik = new StringBuffer(hslakhir);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }
    
    /**
     * fungsi ini merupakan fungsi yang digunakan untuk mengubah bilangan desimal menjadi bilangan oktal
     * @param bilDesimal bertipe data int
     * @return nilai yang akan dikembalikan oleh fungsi DesimaltoOktal
     */
    public String DesimaltoOktal (int bilDesimal){
        String hslakhir = "";
        String num = String.valueOf(bilDesimal);
        int sisa = bilDesimal;
        int temp = 0;
        int i = 0;
        do {
            temp = bilDesimal / 8;
            sisa = bilDesimal % 8;
            bilDesimal = temp;
            hslakhir += sisa;
            if (temp == 1){
                hslakhir += temp;
            }
        } while (temp >= 2);
        StringBuffer balik;
        balik = new StringBuffer(hslakhir);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }
    
    /**
     * fungsi ini merupakan fungsi yang digunakan untuk mengubah bilangan desimal menjadi bilangan heksadesimal
     * @param bilDesimal bertipe data integer
     * @return nilai yang akan dikembalikan oleh fungsi ini
     */
    public String DesimaltoHexa (int bilDesimal){
        String hslakhir = "";
        String num = String.valueOf(bilDesimal);
        int sisa = bilDesimal;
        int temp = 0;
        int i = 0;
        String sisaAkhir = "";
        do {
            temp = bilDesimal / 16;
            sisa = bilDesimal % 16;
            bilDesimal = temp;
            if (sisa == 10){
                sisaAkhir = "A";
            } else if (sisa == 11){
                sisaAkhir = "B";
            } else if (sisa == 12){
                sisaAkhir = "C";
            } else if (sisa == 13){
                sisaAkhir = "D";
            } else if (sisa == 14){
                sisaAkhir = "E";
            } else if (sisa == 15){
                sisaAkhir = "F";
            } else
                sisaAkhir = Integer.toString(sisa);
            hslakhir += sisaAkhir;
            if (temp == 1){
                hslakhir += temp;
            }
        } while (temp >= 2);
        StringBuffer balik;
        balik = new StringBuffer(hslakhir);
        String hslfinal = balik.reverse().toString();
        return hslfinal;
    }
    
    /**
     * fungsi OktaltoBiner merupakan fungsi yang digunakan untuk mengkonversi bilangan oktal ke biner
     * @param bilOkt merupakan parameter untuk memasukkan nilai oktal dengan tipe data integer
     * @return nilai yang akan dikembalikan oleh fungsi OktaltoBiner
     */
    public String OktaltoBiner (int bilOkt){
        int okt[] = new int[3];
        String hasil[] = new String[3];
        String num = String.valueOf(bilOkt);
        String hslakhir = "";
        for (int i = 0; i < num.length(); i++) {
            okt[i] = Character.digit(num.charAt(i), 10);
        }
        
        for (int i = 0; i < okt.length; i++) {
            for (int j = 0; j < oktal.length; j++) {
                if (okt[i] == oktal[j]) {
                    hasil[i] = biner[j];
                }
            }
            hslakhir += hasil[i];
        }
        return hslakhir;
    }
    
    /**
     * fungsi HexatoBiner merupakan fungsi yang digunakan untuk mengkonversi bilangan heksadesimal ke biner
     * @param bilHexa bertipe data String
     * @return nilai yang akan dikembalikan oleh fungsi HexatoBiner
     */
    public String HexatoBiner (String bilHexa){
        String ch[] = bilHexa.split("");
        String hx[] = new String[ch.length];
        String hasil[] = new String[ch.length];
        String hslakhir = "";
        
        for(int i = 0; i < ch.length; i++) {
            hx[i] = ch[i];
        }
        
        for (int i = 0; i < hx.length; i++) {
            for (int j = 0; j < heksa.length; j++) {
                if (hx[i].equals(heksa[j])){
                   hasil[i] = biner[j];
                }
            }
            hslakhir += hasil[i];
        }
        return hslakhir;
    }
    
    /**
     * fungsi BinertoHexa merupakan fungsi yang digunakan untuk mengkonversi bilangan biner ke hexa
     * @param bilBiner bertipe data String
     * @return nilai yang akan dikembalikan pada fungsi BinertoHexa
     */
    public String BinertoHexa (String bilBiner){
        String hslakhir = "";
        for (int i = 0; i < heksa.length; i++) {
            if (bilBiner.equals(biner[i])) {
                hslakhir = heksa[i];
            }
        }
        return hslakhir;
    }
    
    public String OktaltoHexa (int bilOktal){
        KonversiBilangan kb = new KonversiBilangan();
        int dsm = kb.OktaltoDesimal(bilOktal);
        String hx = kb.DesimaltoHexa(dsm);
        return hx;
    }
    
    public String HexatoOktal (String bilHexa){
        KonversiBilangan kb = new KonversiBilangan();
        int dsm = kb.HexatoDesimal(bilHexa);
        String okt = kb.DesimaltoOktal(dsm);
        return okt;
    }
    
    public String BinertoOktal (String bilBiner){
        KonversiBilangan kb = new KonversiBilangan();
        int bin = kb.BinertoDesimal(bilBiner);
        String dsm = kb.DesimaltoOktal(bin);
        return dsm;
    }

    public static void main(String[] args) {
        // TODO code application logic here
        
        KonversiBilangan kb = new KonversiBilangan();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("KONVERSI BILANGAN:");
        System.out.println("1. Biner");
        System.out.println("2. Desimal");
        System.out.println("3. Oktal");
        System.out.println("4. Heksadesimal");
        System.out.print("Masukkan pilihan anda: ");
        
        int pilih = sc.nextInt();
        
        switch (pilih) { 
            case 1: 
                System.out.print("Masukkan nilai biner: ");
                String biner = sc.next();
                System.out.println("Hasil Desimal     : "+kb.BinertoDesimal(biner));
                System.out.println("Hasil Oktal       : "+kb.BinertoOktal(biner));
                System.out.println("Hasil Heksadesimal: " +kb.BinertoHexa(biner));
                break;
            case 2: 
                System.out.print("Masukkan nilai desimal: ");
                int desimal = sc.nextInt();
                System.out.println("Hasil Biner       : " +kb.DesimaltoBiner(desimal));
                System.out.println("Hasil Oktal       : " +kb.DesimaltoOktal(desimal));
                System.out.println("Hasil Heksadesimal: " +kb.DesimaltoHexa(desimal));
                break;
            case 3:
                System.out.print("Masukkan nilai oktal: ");
                int oktal = sc.nextInt();
                System.out.println("Hasil Biner       : "+kb.OktaltoBiner(oktal));
                System.out.println("Hasil Desimal     : "+kb.OktaltoDesimal(oktal));
                System.out.println("Hasil Heksadesimal: "+kb.OktaltoHexa(oktal));
                break;
            case 4:
                System.out.print("Masukkan nilai heksadesimal: ");
                String heksa = sc.next();
                System.out.println("Hasil Biner  : "+kb.HexatoBiner(heksa));
                System.out.println("Hasil Desimal: "+kb.HexatoDesimal(heksa));
                System.out.println("Hasil Oktal  : "+kb.HexatoOktal(heksa));
                break;
        default: 
            System.out.println("Pilihan tidak tersedia.");break;
        }
    }
}
