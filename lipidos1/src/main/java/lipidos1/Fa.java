package lipidos1;

public class Fa {
    private String name;
    private int intensity;
    public Fa(String name, int intensity){
        this.name=name;
        this.intensity=intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getIntensity() {
        return intensity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override public String toString(){
        return this.name +" "+ this.intensity;
    }
}
