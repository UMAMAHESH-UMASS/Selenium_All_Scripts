package abcpack;

import org.testng.annotations.Test;

public class DependencyTest {
	@Test
	public void meth1()
	{
		int x=10,y=0;
		int z=x/y;
		System.out.println(z);
		System.out.println("meth1");
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("meth2");
	}

}
