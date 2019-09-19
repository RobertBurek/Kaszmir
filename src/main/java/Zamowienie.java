/**
 * Created by Robert Burek
 */
public class Zamowienie {

    private String nrZamowienia = "";
    private Double wysokoscRolki = 0.0;
    private Integer ileRolek =0;

    public Zamowienie(String poz, Double wys, Integer ile) {
        this.nrZamowienia = poz;
        this.wysokoscRolki = wys;
        this.ileRolek = ile;
    }

    @Override
    public String toString() {
        return "Zamowienie{" +
                "pozycja= '" + nrZamowienia + '\'' +
                ", wyskość rolki= " + wysokoscRolki +
                ", ilość rolek= " + ileRolek +
                '}';
    }

    public String getNrZamowienia() {
        return nrZamowienia;
    }

    public void setNrZamowienia(String nrZamowienia) {
        this.nrZamowienia = nrZamowienia;
    }

    public Double getWysokoscRolki() {
        return wysokoscRolki;
    }

    public void setWysokoscRolki(Double wysokoscRolki) {
        this.wysokoscRolki = wysokoscRolki;
    }

    public Integer getIleRolek() {
        return ileRolek;
    }

    public void setIleRolek(Integer ileRolek) {
        this.ileRolek = ileRolek;
    }
}
