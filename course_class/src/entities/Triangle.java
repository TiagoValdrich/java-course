package entities;

public class Triangle {

	public double a;
	public double b;
	public double c;
	
	public double area() {
		
		double p = (a + this.b + this.c) / 2;
		return Math.sqrt(p * ( p - this.a ) * ( p - this.b ) * ( p - this.c ) );		
		
	}
	
}
