package Tests.day11;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist{

    @Test
    public void test() {

        System.out.println(System.getProperty("user.home")); // C:\Users\ferha
        // "C:\Users\ferha\Downloads\Profile.jpeg"

        // Masaüstündeki bir dosya yolunun tüm bilgisayarlarda sorunsuz calismasi icin dosya yolunu ikiye ayiracagiz.
        // 1) Herkesin bilgisisayarinda farkli olan kisim. Bu kismi bilgisayardan System.getProperty("user.home") kodu ile alabiliriz.
        // 2) Herkes icin ayni olan kisim. Bu kisim 1. maddedeki yolun devami seklinde olur.

        // ORN: Downloads Profile dosyasi icin yol kaydedelim.

        String dosyaYolu = System.getProperty("user.home") + "\\Downloads\\Profile.jpeg";
        System.out.println("Dosya yolumuz : " + dosyaYolu);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        System.out.println(System.getProperty("user.dir"));
        // Icinde oldugumuz dosyanin yolunu verir.
    }
}
