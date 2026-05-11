package wip;

class Rectangle{
	 int ln;
	 int br;
	 
	 Rectangle()
	 {
		 System.out.println("constructor");
		 ln=10;
		 br=20;
	 }
	 
	 Rectangle(int ln, int br){
		 System.out.println("para"+ln +"  " +br);
		 this.ln=ln;
		 this.br=br;
	 }
	 void display() {
		 System.out.println("length "+ln);
		 System.out.println("brd"+br);
	 }
	         
}
public class ConstructorEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1= new Rectangle(3,5);
		r1.display();
		Rectangle r2= new Rectangle();
		r2.display();

	}

}
