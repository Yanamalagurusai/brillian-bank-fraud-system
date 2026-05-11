package wip;

import java.util.Scanner;

public class SwitchEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("enter a,b");
		int a=sc.nextInt();
		int b=sc.nextInt();
		System.out.println("1.add /n 2.sub /n 3. mul");
		int wish;
		
		do 
		{
		System.out.println("Enetr");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:System.out.println(a+b);
				break;
		case 2:System.out.println(a-b);
		break;
		
		case 3:System.out.println(a*b);
		break;
		
		default:System.out.println("noe");
				
		}
		System.out.println("contiune or xit..1.yes 2.no");
		wish=sc.nextInt();
		}
		while(wish==1); 

	}

}
