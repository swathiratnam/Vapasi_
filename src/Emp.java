public class Emp {

    private int eid;
    private float salary;
    private String ename;

    Emp(int id,float sal,String name){
        this.eid = id;
        this.salary = sal;
        this.ename = name;
    }

    void display(){
        System.out.println("Employee Id :"+this.eid);
        System.out.println("Salary :"+this.salary);
        System.out.println("Name :"+this.ename);
    }
}
