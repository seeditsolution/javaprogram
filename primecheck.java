class CheckPrime
{
	public static void main(String a[])
	{
	
		for(int i=2;i<11;i++)
	{	
		int flag=0;
		for(int j=2;j<i;j++)
	{	
		if(i%j==0)
		{
		System.out.println(i + "is not prime");
		flag=1;
		break;
		}
	}

	if(flag==0)
	{
	System.out.println(i + "is prime");
	
	}
}
}
}
