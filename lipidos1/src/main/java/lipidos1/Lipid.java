package lipidos1;
import java.util.*;
public class Lipid {
    private String head;
    private List<String> fas= new LinkedList<String>();
    public Lipid(String head){
        this.head=head;
    }
    public Lipid(){}
     public void addFa(String fa){
        this.fas.add(fa);
     }

    public void setHead(String head) {
        this.head = head;
    }

    public String getNextFA(int posicion){
        Iterator<String> it= fas.iterator();
        for(int i=0; i<posicion;i++){
            it.next();
        }
        return it.next();
    }
    @Override public String toString(){
        String cadena=this.head;
        Iterator<String> it= fas.iterator();
        while(it.hasNext()){
            cadena=cadena.concat(" "+it.next());
        }
        return cadena;
    }
}
