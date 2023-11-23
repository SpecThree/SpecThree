class Mixed_Var3
{
	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		a.m1();
		b.m2();
		c.m3();
		// A's m1, A's m2, C's m3, 13
	}
}