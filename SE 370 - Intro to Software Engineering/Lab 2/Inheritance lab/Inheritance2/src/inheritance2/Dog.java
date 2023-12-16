package inheritance2;

public class Dog extends Animal{
	
	public void display() {
	    System.out.println("My name is " + name);
	  }
	
	public void eat() {
		super.eat();
		System.out.println("Dogs need to eat dog food");
	}
	
	public void bark() {
		System.out.println("Dogs can bark");
	}
	

}
