package com.laptop;

public class Laptop {

    private String logo;
    private Processor processor;
    private HDD hdd;
    private RAM ram;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "LaptopExample.Laptop{" +
                "logo='" + logo + '\'' +
                ", processor=" + processor +
                ", hdd=" + hdd +
                ", ram=" + ram +
                '}';
    }
}
