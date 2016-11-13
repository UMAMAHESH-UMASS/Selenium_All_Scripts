package abcpack;
class S
{
	static int x=10,y;
	static void sum()
	{
		System.out.println("Sum of x & y is:"+(x+y));
	}
	S()
	{
		System.out.println("Default constructor");
	}
	static 
	{
		y=x/2;
		System.out.println("Static block");
	}
}

public class StaticDemo {

	public static void main(String[] args) {
		//S b=new S();
        S.sum();
	}

}
