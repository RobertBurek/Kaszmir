import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Robert Burek
 */
public class Pozycja {

    String poz = "";
    Double wys = 0.0;
    List<Integer> ileCzego=new ArrayList<>();
    List<Integer> przydzialRolek=new ArrayList<>();

    public Pozycja(String pozycia, Double suma) {
        this.poz = pozycia;
        this.wys = suma;
    }

    public String getPoz() {
        return poz;
    }

    public void setPoz(String poz) {
        this.poz = poz;
    }

    public Double getWys() {
        return wys;
    }

    public void setWys(Double wys) {
        this.wys = wys;
    }

    public List<Integer> getIleCzego() {
        return ileCzego;
    }

    public void setIleCzego(List<Integer> ileCzego) {
        this.ileCzego = ileCzego;
    }

    //    @Override
//    public String toString() {
//        return "Słupek{" +
//                "układ= '" + poz + '\'' +"\n"+
////                ", wysokość słupka= " + wys +
////                ", h=" + hashCode() +
//                '}';
//    }


    @Override
    public String toString() {
        return "Pozycja{" +
                "poz='" + poz + '\'' +
                ", ileCzego=" + ileCzego + "\n"+
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pozycja pozycja = (Pozycja) o;
        return Objects.equals(hashCode(), pozycja.hashCode());
    }

    @Override
    public int hashCode() {
        int suma = 0;
        char[] chars = this.poz.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            suma = suma + ((int) (chars[i]) * (int) (chars[i]));
        }
        return Objects.hash(suma);
    }

}
