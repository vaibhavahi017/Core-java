class A1
{
	static void m1(){
		System.out.println("A1 m1() Hi");
	}
	
	static void m1(int a){
		System.out.println("A1 m1(int PM)"+a);
	}
	
	void m2(){
		System.out.println("A1 m2() Hello");
	}
	
	void m2(int a){
		System.out.println("A1 m2(int PM)"+a);
	}
	A1(){
		System.out.println("A1 NPC ");
	}
	A1(int a){
		System.out.println("A1 IPC a :"+a);
	}
	
}

@FunctionalInterface
interface Abc1
{
	void abc();
}

@FunctionalInterface
interface Abc2
{
	void abc(int a);
}

class Test_MR 
{
	public static void main(String[] args) 
	{
		System.out.println("executed the non  parameterized static m1() method from A1 class");
		
		Abc1 a1 = ()->{System.out.println("Le hi");};
		a1.abc();
		//=====================for static method========================
		
		Abc1 a2 = ()->{A1.m1();};
		a2.abc();
		//============================================
		
		Abc1 a3 = A1::m1;//method refference short-cut for LE
		a3.abc();
		//========================================
		
		System.out.println("executed the parameterized static m1() method from A1 class");
		Abc2 a4 =a->{A1.m1(a);}; //(int a)->{A.m1(a)} no need to write like this for single parameter
		a4.abc(10);
		
		Abc2 a5 =  A1::m1;
		a5.abc(20);
		System.out.println();
		//=====================end======================
		
		
		
		Abc1 a6 =()->{new A1().m2();};
		a6.abc();
		
		Abc1 a7 =new A1()::m2;
		a7.abc(); //Execution flow :Execute no paramterized non static m2() from A1 class and constructor also execute and first ctor execute
		System.out.println();
		//=======================================
		 
		 System.out.println("Execute  the parameterised non static m2() from A1 class);
		 Abc2 a8 =a ->new A1().m2(a);
		 a8.abc(30);
		 
		 Abc2 a9=new A1()::m2;
		 a9.abc(40);//call the non static parameterized m2 method from A1 class
		
	}
}
