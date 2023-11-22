package Modeller.Departmanlar;

public class BilisimTeklonojileriDepartmani implements Departman {

    final String departmanKodu = "BTD";

    final int zamOrani = 25;


    @Override
    public int getZamOrani() {
        return zamOrani;
    }

    @Override
    public String getDepartmanKodu() {
        return departmanKodu;
    }
}
