import java.util.*;
class OversException extends Exception
{
	public String toString()
	{
		String s1="Overs not greater then 50: please enter <=50";
		return s1;
	}
}
class Team1
{
	String t1="";
	float ov1;
Scanner s=new Scanner(System.in);
String teamName()
{
	System.out.println("Enter Team1 Name :");
	t1=s.next();
	return t1;
}
float overs()throws Exception
{
	System.out.println("Enter the Overs Played by: " +t1);
	ov1=s.nextFloat();
	if(ov1>50)
	{
		throw new OversException();
	}
	return ov1;
}
int calculatingScore()
{
System.out.println("Enter the Runrate for :"+t1);
float rr=s.nextFloat();
int score=(int)(rr*ov1);
return score;
}
}
