package lipidos1;

public class Chain {
    private String name;
    private double intensity;
    public Chain(String name, double intensity){
        this.name=name;
        this.intensity=intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
    }

    public double getIntensity() {
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
