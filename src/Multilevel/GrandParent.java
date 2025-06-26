package Multilevel;

public class GrandParent {
    int gpAge;
    String gpName;

   GrandParent() {

   }

    public GrandParent(String gpName, int gpAge) {
        this();
        this.gpName = gpName;
        this.gpAge = gpAge;

    }
   public void getGrandParentName(){

       System.out.println("Grand Parent Name :"+gpName);
   }
   public void getGrandParentAge(){
       System.out.println("Grand Parent age :"+gpAge);
   }
}

