class Mixed_Var2
{
	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		c.m1();
		c.m2();
		c.m3();
		// B's m1, A's m2, C's m3, 13
	}
}