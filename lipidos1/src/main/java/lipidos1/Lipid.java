package lipidos1;
import java.util.*;
public class Lipid {
    private String head;

    private Fa fa1;
    private Fa fa2;
    private Fa fa3;

    public Lipid(String head){
        this.head=head;
    }
    public Lipid(){}

    public void setFa1(String fa1, int intensity) {
        this.fa1 = new Fa(fa1,intensity);
    }

    public void setFa2(String fa2, int intensity) {
        this.fa2 = new Fa(fa2,intensity);
    }

    public void setFa3(String fa3, int intensity) {
        this.fa3 = new Fa(fa3,intensity);
    }

    public Fa getFa1() {
        return fa1;
    }

    public Fa getFa2() {
        return fa2;
    }

    public Fa getFa3() {
        return fa3;
    }

    public void setFa3(Fa fa3) {
        this.fa3 = fa3;
    }

    public void setFa2(Fa fa2) {
        this.fa2 = fa2;
    }

    public void setFa1(Fa fa1) {
        this.fa1 = fa1;
    }


    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }


    @Override public String toString(){
        String cadena=this.head;
        cadena=cadena.concat(" "+fa1);
        cadena=cadena.concat(" "+fa2);
        cadena=cadena.concat(" "+fa3);
        return cadena;
    }
}
