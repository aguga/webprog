class Bicycle
{
private double maxspeed;
private String model;
Bicycle(){
maxspeed=12.5;
model="A34R";
}
public void display()
{
System.out.println(maxspeed);
System.out.println(model);
}
}

class Mountainbike extends Bicycle
{
private double seatheight;
Mountainbike(){
seatheight=25.5;
}
public void display()
{
super.display();
System.out.println(seatheight);
}
}

public class Bice
{
   public static void main(String[] args){
   	   Mountainbike bike=new Mountainbike(); 
	   bike.display();
   	
   }


}