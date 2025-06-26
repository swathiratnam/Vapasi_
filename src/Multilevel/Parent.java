package Multilevel;

public class Parent extends GrandParent {

    String pName;
    int pAge;

    Parent(){

        super();
        System.out.println("In my parent class");
    }

    Parent(String pName, int pAge,String gpName,int gpAge) {
        super(gpName,gpAge);
        this.pName = pName;
        this.pAge = pAge;
        System.out.println("Parent name: "+ pName +" age "+ pAge);
    }

    public void parentHir(){
        super.getGrandParentName();
        super.getGrandParentAge();

    }

}
