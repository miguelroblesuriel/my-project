package lipidos1;
import java.util.*;
public class Lipid {
    private String head;

    private Chain chain1;
    private Chain chain2;
    private Chain chain3;
    private boolean viability=false;
    private String type;

    public Lipid(String head){
        this.head=head;
    }
    public Lipid(){}

    public void setChain1(String chain1, double intensity) {
        this.chain1 = new Chain(chain1,intensity);
    }

    public void setChain2(String chain2, double intensity) {
        this.chain2 = new Chain(chain2,intensity);
    }

    public void setChain3(String chain3, double intensity) {
        this.chain3 = new Chain(chain3,intensity);
    }

    public Chain getChain1() {
        return this.chain1;
    }

    public Chain getChain2() {
        return this.chain2;
    }

    public Chain getChain3() {
        return this.chain3;
    }

    public void setChain3(Chain fa3) {
        this.chain3 = fa3;
    }

    public void setChain2(Chain fa2) {
        this.chain2 = fa2;
    }

    public void setChain1(Chain fa1) {
        this.chain1 = fa1;
    }


    public void setHead(String head) {
        this.head = head;
    }

    public String getHead() {
        return head;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setViability(boolean viability) {
        this.viability = viability;
    }

    @Override public String toString(){
        String cadena="";
        cadena=cadena.concat(" "+this.type);
        cadena=cadena.concat(" "+this.head);
        cadena=cadena.concat(" "+this.chain1);
        cadena=cadena.concat(" "+this.chain2);
        cadena=cadena.concat(" "+this.chain3);
        cadena=cadena.concat(" "+this.viability);
        return cadena;
    }
}
