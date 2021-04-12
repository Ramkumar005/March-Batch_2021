package week3_Day1.ClassRoom.Polymorphism;

public class Calculator {

	public void add() {
		int a=5;
		int b=10;
		System.out.println("sum: "+(a+b));
	}
	public void add(int a,int b,int c) {
		
		System.out.println("sum: " +(a+b+c));
	}
	public void mul() {
		int a=5;
		int b=10;
		System.out.println("sum: " +(a*b));
	}public void mul(int a,int b,int c) {
		
		System.out.println("sum: " +(a*b*c));
	}
	public void add(double a,double b) {
		System.out.println("double: " +(a+b));
	}
public static void main(String[] args) {
	Calculator calc =new Calculator();
	calc.add();
	calc.mul(10, 20, 30);
	calc.mul();
	calc.mul(10, 10, 10);
	calc.add(36.5, 50.25);
}
	
}
