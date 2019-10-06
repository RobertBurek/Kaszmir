import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Created by Robert Burek
 */
public class Main {

    public static void main(String[] args) {

        List<Integer> listaRolek = new ArrayList<>();
        List<Zamowienie> zamowienia = new ArrayList<Zamowienie>();

        List<Pozycja> pozycjeZamowien = new ArrayList<Pozycja>();
        List<Pozycja> listaWszystkich = new ArrayList<Pozycja>();
        List<Pozycja> wynik = new ArrayList<Pozycja>();
        List<Pozycja> czystaLista = new ArrayList<Pozycja>();


        zamowienia.add(new Zamowienie("1",73.5,100));
        zamowienia.add(new Zamowienie("2",69.5,50));
        zamowienia.add(new Zamowienie("3",54.5,50));

//        zamowienia.add(new Zamowienie("1",54.5,50));
//        zamowienia.add(new Zamowienie("2",69.5,50));
//        zamowienia.add(new Zamowienie("3",73.5,100));

//        zamowienia.add(new Zamowienie("1",74.0,30));
//        zamowienia.add(new Zamowienie("2",69.0,20));
//        zamowienia.add(new Zamowienie("3",51.0,30));
//        zamowienia.add(new Zamowienie("4",46.0,20));
//        zamowienia.add(new Zamowienie("5",43.0,30));

//        zamowienia.add(new Zamowienie("1",43.0,30));
//        zamowienia.add(new Zamowienie("2",46.0,20));
//        zamowienia.add(new Zamowienie("3",51.0,30));
//        zamowienia.add(new Zamowienie("4",69.0,20));
//        zamowienia.add(new Zamowienie("5",74.0,30));

//        zamowienia.add(new Zamowienie("1", 73.5, 15));
//        zamowienia.add(new Zamowienie("2", 54.5, 80));
//        zamowienia.add(new Zamowienie("3", 44.5, 40));

//        zamowienia.add(new Zamowienie("1",44.5,40));
//        zamowienia.add(new Zamowienie("2",54.5,80));
//        zamowienia.add(new Zamowienie("3",73.5,15));

//        zamowienia.add(new Zamowienie("1", 1.0, 50));
//        zamowienia.add(new Zamowienie("2", 1.0, 45));
//        zamowienia.add(new Zamowienie("3", 1.0, 80));
//        zamowienia.add(new Zamowienie("4", 1.0, 80));
//        zamowienia.add(new Zamowienie("5", 1.0, 80));
//        zamowienia.add(new Zamowienie("6", 1.0, 80));
//        zamowienia.add(new Zamowienie("7", 1.0, 80));
//        zamowienia.add(new Zamowienie("8", 1.0, 80));
//        zamowienia.add(new Zamowienie("9", 1.0, 80));


        int wszystkieRolki = 0;
        Double maxWysokoscZamowienia = 0.0;
        for (int i = 0; i < zamowienia.size(); i++) {
            Pozycja pozycja = new Pozycja(zamowienia.get(i).getNrZamowienia(), zamowienia.get(i).getWysokoscRolki());
            pozycjeZamowien.add(pozycja);
            listaRolek.add(zamowienia.get(i).getIleRolek());
            wszystkieRolki = wszystkieRolki + zamowienia.get(i).getIleRolek();
            maxWysokoscZamowienia = maxWysokoscZamowienia + zamowienia.get(i).getIleRolek()*zamowienia.get(i).getWysokoscRolki();
            wynik.add(pozycja);
        }

//        pozycjeZamowien.add(new Pozycja("1", 73.5));
//        pozycjeZamowien.add(new Pozycja("2", 69.5));
//        pozycjeZamowien.add(new Pozycja("3", 54.5));

//        listaRolek.add(100);
//        listaRolek.add(50);
//        listaRolek.add(50);


//        wynik.add(new Pozycja("1", 73.5));
//        wynik.add(new Pozycja("2", 69.5));
//        wynik.add(new Pozycja("3", 54.5));


//        System.out.println(listaWszystkich);
//        System.out.println(pozycjeZamowien);
//        System.out.println(listaWszystkich.size());

        int dlugosc = pozycjeZamowien.size();
        int z = 1;

        do {
            for (int i = 0; i < dlugosc; i++) {
                for (int j = 0; j < pozycjeZamowien.size(); j++) {
                    listaWszystkich.add(new Pozycja((j + 1) + "" + wynik.get(i).getPoz(),
                            wynik.get(i).getWys() + pozycjeZamowien.get(j).getWys()));
                }
            }
//            System.out.println("LW: " + listaWszystkich.stream().distinct().collect(Collectors.toList()));
//            System.out.println("LW: " + listaWszystkich.stream().distinct().collect(Collectors.toList()).size());

            List<Pozycja> posortowanaListaWszystkich = listaWszystkich
                    .stream()
                    .distinct()
//                    .sorted((o1, o2) -> o2.getWys().compareTo(o1.getWys()))
//                    .sorted((o1, o2) -> o1.hashCode() - o2.hashCode())
                    .sorted((o1, o2) -> o1.hashCode() - o2.hashCode())
//                    .sorted()
//                    .distinct()
                    .collect(Collectors.toList());
            System.out.println("PL: " + posortowanaListaWszystkich);
            System.out.println("PLs: " + posortowanaListaWszystkich.size());
            for (int i = 0; i < posortowanaListaWszystkich.size() - 1; i++) {
//                System.out.println(posortowanaListaWszystkich.get(i).getWys()-posortowanaListaWszystkich.get(i+1).getWys());
//                if (posortowanaListaWszystkich.get(i).getWys()-posortowanaListaWszystkich.get(i+1).getWys()==0.0) {
                if (posortowanaListaWszystkich.get(i).hashCode() - posortowanaListaWszystkich.get(i + 1).hashCode() != 0) {
//                    posortowanaListaWszystkich.remove(i+1);
                    czystaLista.addAll(posortowanaListaWszystkich.stream().distinct().collect(Collectors.toList()));
            System.out.println(posortowanaListaWszystkich.stream().distinct().collect(Collectors.toList()));
            System.out.println(posortowanaListaWszystkich.stream().distinct().collect(Collectors.toList()).size());
//                    System.out.println(posortowanaListaWszystkich.get(i).getWys()+
//                            "/"+posortowanaListaWszystkich.get(i+1).getWys());
                }
            }
//            posortowanaListaWszystkich.remove(1);
            System.out.println(posortowanaListaWszystkich);

            System.out.println(posortowanaListaWszystkich.size());
            System.out.println(czystaLista);
            System.out.println(czystaLista.size());
            Stream<Pozycja> sorted = listaWszystkich.stream().sorted((o1, o2) -> (int) (o1.getWys() - o2.getWys()));

            System.out.println(listaWszystkich);

            dlugosc = listaWszystkich.size();
            wynik.clear();
            wynik.addAll(listaWszystkich);
            listaWszystkich.clear();


            dlugosc = posortowanaListaWszystkich.size();
            wynik.clear();
            wynik.addAll(posortowanaListaWszystkich);
            listaWszystkich.clear();
            listaWszystkich.addAll(posortowanaListaWszystkich);
            posortowanaListaWszystkich.clear();

            z++;
        } while (z < 12);

//        System.out.println(wynik.stream().distinct().collect(Collectors.toList()));
//        System.out.println(wynik.stream().distinct().collect(Collectors.toList()).size());
//        System.out.println(wynik);
//        System.out.println(wynik.size());
        List<Pozycja> collect =
//                wynik.stream().sorted((o1, o2) -> o2.hashCode()-o1.hashCode()).collect(Collectors.toList());
                wynik.stream().distinct().collect(Collectors.toList());
        List<Pozycja> koniec = collect.stream().sorted((o1, o2) -> o2.getWys().compareTo(o1.getWys())).collect(Collectors.toList());
//        wynik.addAll(collect.stream().distinct().collect(Collectors.toList()));
//        wynik.addAll(collect.stream().distinct().collect(Collectors.toList()));

        System.out.println("");
        System.out.println("");
        System.out.println("");
        for (int i = 0; i < zamowienia.size(); i++)
            System.out.println(zamowienia.get(i).toString());
        System.out.println("");
        for (Pozycja pozycja : koniec) {
            if ((pozycja.getWys() > 1) && (pozycja.getWys() < 999999)) {
                IleCzego(zamowienia, pozycja);
                System.out.print(pozycja);
                IleCzego(zamowienia, pozycja);
                System.out.print("   rozkład " + pozycja.ileCzego);
                System.out.print("   rolki " + pozycja.przydzialRolek);
                Integer maxSlupkow = pozycja.przydzialRolek.stream().filter(s -> s > 0).min(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1 - o2;
                    }
                }).orElse(0);
                System.out.print("   max.słupków " + maxSlupkow);

                int sumaRozkladu = getSumaRozkladu(pozycja, maxSlupkow);
                System.out.println("    Pozostało: " + (wszystkieRolki - sumaRozkladu)+"/"+wszystkieRolki);
            }
        }
        System.out.println(koniec.size());
    }

    private static int getSumaRozkladu(Pozycja pozycja, Integer maxSlupkow) {
        int sumaRozkladu = 0;
        for (int i = 0; i < pozycja.ileCzego.size(); i++) {
            sumaRozkladu = sumaRozkladu + pozycja.ileCzego.get(i) * maxSlupkow;
        }
        return sumaRozkladu;
    }


    private static void IleCzego(List<Zamowienie> zamowienia, Pozycja pozycja) {
        for (int j = 0; j < zamowienia.size(); j++) {
            int ile = 0;
            char[] chars = pozycja.getPoz().toCharArray();
            char[] zam = zamowienia.get(j).getNrZamowienia().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == zam[0])
                    ile++;
            }
            pozycja.ileCzego.add(ile);
            if (ile != 0) pozycja.przydzialRolek.add(zamowienia.get(j).getIleRolek() / ile);
            else pozycja.przydzialRolek.add(0);
        }
        pozycja.setIleCzego(pozycja.ileCzego);
    }
}
