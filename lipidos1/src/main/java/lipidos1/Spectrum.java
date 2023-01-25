package lipidos1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Spectrum {
    private List<Peak> peaks= new LinkedList<Peak>();
    private String type;
    public Spectrum(Peak peak) {
        peaks.add(peak);
    }
    public void addPeak(Peak peak){
        peaks.add(peak);
    }
    public Peak getPeak(int posicion){
        Iterator<Peak> it= peaks.iterator();
        for(int i=0; i<posicion;i++){
            if(it.hasNext()){
                it.next();
            }else{
                return null;
            }
        }
        if(it.hasNext()){
            return it.next();
        }else{
            return null;
        }
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
