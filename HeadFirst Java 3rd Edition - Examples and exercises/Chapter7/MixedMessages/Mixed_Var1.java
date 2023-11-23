class Mixed_Var1
{
	public static void main(String[] args)
	{
		A a = new A();
		B b = new B();
		C c = new C();
		A a2 = new C();
		b.m1();
		c.m2();
		a.m3();
		// B's m1, A's m2, A's m3,
	}
}