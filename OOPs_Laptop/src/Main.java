import com.laptop.HDD;
import com.laptop.Laptop;
import com.laptop.Processor;
import com.laptop.RAM;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       /* Emp e1 = new Emp(101, 999.34f, "Swathi");
        Emp e2 = new Emp(102, 1000.34f, "Bhavya");

        e1.display();
        e2.display();*/

        // Creating processor
        Processor p1= new Processor();
        p1.setGen("5TH");
        p1.setGhz(3.5f);

        /* creating Hard disk */
        HDD h1= new HDD();
        h1.setSize(500);
        h1.setHtype("SDD");

        /*
         * Creating LaptopExample.RAM
         */
        RAM r1= new RAM();
        r1.setGen("DDR3");
        r1.setSize(16);

        Laptop abc = new Laptop();
        abc.setLogo("MAC");
        abc.setProcessor(p1);
        abc.setHdd(h1);
        abc.setRam(r1);
        System.out.println(abc.toString());

    }
}