package lipidos1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Spectrum {

    // TODO si los queremos ordenados en base a mz, vamos a crear un arbol. compareTo a traves del pico (mz)
    private List<Peak> peaks;
    private int contador;

    public Spectrum(Peak peak) {
        peaks = new LinkedList<Peak>();
        this.peaks.add(peak);
        this.contador=1;
    }

    public Spectrum(List<Peak> peaks) {
        this.peaks = peaks;
        this.contador=1;
    }
    public void addPeak(Peak peak){
        this.peaks.add(peak);
        this.contador=contador+1;
    }
    public Peak getPeak(int posicion){
        Peak peak;
        Iterator<Peak> it= this.peaks.iterator();
        while(it.hasNext()){
            if((peak=it.next()).getPosition()==posicion){
                return peak;
            }
        }
        return null;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getContador() {
        return this.contador;
    }

    public void swapPeaks(Peak peak1, Peak peak2){
        Iterator<Peak> it= this.peaks.iterator();
        while(it.hasNext()){
            Peak peak3 = it.next();
            if(peak3.equals(peak1)){
                peak3.setPosition(peak3.getPosition()+1);
            }
            if(peak3.equals(peak2)){
                peak3.setPosition(peak3.getPosition()-1);
            }
        }
    }

    @Override public String toString(){
        Iterator<Peak> it= this.peaks.iterator();
        String cadena="";
        for(int i=0; it.hasNext();i++){
            cadena=cadena.concat(it.next().toString()+"   ");
        }
        return cadena;
    }
}
