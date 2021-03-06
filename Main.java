package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File zdrojovySoubor = new File("/Users/sorawski/Downloads/vat-eu.csv");

        Scanner scanner = new Scanner(zdrojovySoubor);

         List<DanoveSazbyStatu> sazbyStatu = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String nactenyRadek = scanner.nextLine();
            rozparsujRadek(nactenyRadek);
           sazbyStatu.add(rozparsujRadek(nactenyRadek));

        }
//pozn: slouzi pak pro vypis toho filtru
      //  vypisInformaceOStatech(vyfiltrujStatySeSazbamiVetsimiNez(sazbyStatu, 23.0F));
        //System.out.println("Done!");


        //načítaní z prikazového radku
        Scanner nacitaniZPrikazovehoRadku = new Scanner(System.in);

        String zkratka;


        System.out.println("Zadej zkratku požadovaneho statu :");

        zkratka = nacitaniZPrikazovehoRadku.nextLine();
       // System.out.println("Vybral sis tento stat: " + zkratka);

        DanoveSazbyStatu hledanaSazba = najdiStat(sazbyStatu, zkratka);
        if (hledanaSazba == null) {
            System.out.println("Pro tento stat nemame žadne informace!");
        } else {
            System.out.println("Nazev: " + hledanaSazba.getNazev());
            System.out.println("Plna danova sazba: " + hledanaSazba.getPlnaSazba());
            System.out.println("Snizena danova sazba: " + hledanaSazba.getSnizenaSazba());

        }

    }

    private static DanoveSazbyStatu rozparsujRadek(String nactenyRadek) {

        String[] rozsekanyRadek = nactenyRadek.split("\t");

        DanoveSazbyStatu danoveSazbyStatu = new DanoveSazbyStatu();

        danoveSazbyStatu.setZkratka(rozsekanyRadek[0]);
        danoveSazbyStatu.setNazev(rozsekanyRadek[1]);
        danoveSazbyStatu.setPlnaSazba(Float.valueOf(rozsekanyRadek[2].replace(",",".")));
        danoveSazbyStatu.setSnizenaSazba(Float.valueOf(rozsekanyRadek[3].replace(",",".")));
        danoveSazbyStatu.setSpecialniSazba(Boolean.valueOf(rozsekanyRadek[4]));


            // vypis
        /*
        System.out.println("Zkratka: "+ rozsekanyRadek[0]);
        System.out.println("Nazev: "+ rozsekanyRadek[1]);
        System.out.println("Plna sazba: "+ rozsekanyRadek[2]);
        System.out.println("Snizena sazba: "+ rozsekanyRadek[3]);
        System.out.println("Specialni sazba: "+ rozsekanyRadek[4]);

            */
            return danoveSazbyStatu;
    }

       private static List<DanoveSazbyStatu> vyfiltrujStatySeSazbamiVetsimiNez(List<DanoveSazbyStatu> kFiltrovani, Float sazba) {
            List<DanoveSazbyStatu> danoveSazbyStatu = new ArrayList<>();
            for (DanoveSazbyStatu dss : kFiltrovani) {
                if (dss.getPlnaSazba() > sazba) {
                    danoveSazbyStatu.add(dss);
                }
            }
            return danoveSazbyStatu;

            }


          private static void vypisInformaceOStatech(List<DanoveSazbyStatu> kVypsani) {
              for (DanoveSazbyStatu dss : kVypsani) {
                  System.out.println(dss.getNazev() + " (" + dss.getPlnaSazba() +
                          "%/" + dss.getSnizenaSazba() + "%)");

              }
          }

        private static DanoveSazbyStatu najdiStat(List<DanoveSazbyStatu> prohledavanySeznam, String zkratka) {
            for (DanoveSazbyStatu dss : prohledavanySeznam) {
                if (dss.getZkratka().equals(zkratka)) {
                    return dss;

                }

            }
                  return null;
              }

          }



