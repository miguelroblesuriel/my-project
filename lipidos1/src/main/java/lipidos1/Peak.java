package lipidos1;

public class Peak {
    private int mz;
    private int intensity;
    private int position;
    public Peak(int mz, int intensity, int position){
        this.mz=mz;
        this.intensity=intensity;
        this.position=position;
    }

    public int getIntensity() {
        return intensity;
    }

    public int getPosition() {
        return position;
    }

    public int getMz() {
        return mz;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public void setMz(int mz) {
        this.mz = mz;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override public String toString(){
        return "mz:"+ this.mz+ " intensity:"+ this.intensity+ " position:"+ this.position;
    }
    @Override public boolean equals(Object o){
        Peak peak= (Peak) o;
        if(peak.position==this.position && peak.mz==this.mz && peak.intensity==this.intensity){
            return true;
        }else{
            return false;
        }
    }
}
