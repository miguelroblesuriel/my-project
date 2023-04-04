package lipidos1;
import java.util.*;
public class Lipid {
    // TODO ADD CABEZAS
    private String head;

    // TODO change the chains from 3 chains to a list of chains.
    private Chain chain1;
    private Chain chain2;
    private Chain chain3;
    private boolean viability;
    private boolean headstatus;
    private String type;

    public Lipid(String head){
        this.head=head;
        viability = false;
        headstatus = false;
    }
    public Lipid(){
        viability = false;
        headstatus = false;
    }
    public Lipid(Lipid lipid){
        viability = false;
        this.viability= lipid.viability;
        headstatus = false;
        this.headstatus= lipid.headstatus;
        this.head=lipid.head;
        this.chain1=lipid.chain1;
        this.chain2=lipid.chain2;
        this.chain3=lipid.chain3;
        this.type=lipid.type;
    }

    public void setChain1(String chain1, double intensity) {
        this.chain1 = new Chain(chain1,intensity);
    }

    public void setHeadstatus(boolean headstatus) {
        this.headstatus = headstatus;
    }
    public boolean getHeadstatus(){
        return this.headstatus;
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

    public boolean getViability(){
        return this.viability;
    }
    public void setHead(String head) {
        this.head=head;
    }

    public String getHead() {
        return head;
    }

    public void setType(String type) {
        if(!this.headstatus){
            this.type = type;
            this.headstatus=true;
        }
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
