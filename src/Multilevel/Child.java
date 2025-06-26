package Multilevel;

public class Child extends Parent{
    String cName;
    int cAge;

    Child(){
        super();
    }
    Child(String cName,int cAge){
        super();
        this.cAge = cAge;
        this.cName = cName;
    }

    public void getParentDetails(){

        System.out.println("My parent name: "+pName);
        System.out.println("My parent age"+pAge);
    }
}
