interface StringOperation
{
	void operation(String s);
}



class Test2 
{
	public static void main(String[] args) 
	{
		System.out.println("Main Start");
		
		StringOperation s1 = (String s)->{System.out.println(s.length());};
		s1.operation("vaibhav ahir");
		
		
		System.out.println("Main end");
		
	}
}
