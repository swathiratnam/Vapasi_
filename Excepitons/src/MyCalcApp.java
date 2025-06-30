import com.example.Calculator;
import com.example.MyArithException;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MyCalcApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();

        Calculator cal = new Calculator();
try{
    double douVal =   cal.caldouble(val);
    System.out.println("new double value :"+douVal);
}catch (MyArithException a)
{
    System.out.println(a.getMessage());
}



    }
}