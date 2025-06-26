package LaptopExample;

public class Processor {
    private String gen;
    private float ghz;

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public float getGhz() {
        return ghz;
    }

    public void setGhz(float ghz) {
        this.ghz = ghz;
    }

    @Override
    public String toString() {
        return "LaptopExample.Processor{" +
                "gen='" + gen + '\'' +
                ", ghz=" + ghz +
                '}';
    }
}
