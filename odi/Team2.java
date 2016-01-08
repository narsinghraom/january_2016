import java.util.*;
class OversException extends Exception
{
	public String toString()
	{
		String s1="Overs not greater then 50: please enter <=50";
		return s1;
	}
}
class Team2
{
	String t2="";
	float ov2;
Scanner s=new Scanner(System.in);
String teamName()
{
	System.out.println("Enter Team2 Name :");
	t2=s.next();
	return t2;
}
float overs()throws Exception
{
	System.out.println("Enter the Overs Played by: " +t2);
	ov2=s.nextFloat();
	if(ov2>50)
	{
		throw new OversException();
	}
	return ov2;
}
int calculatingScore()
{
System.out.println("Enter the Runrate for :"+t2);
float rr=s.nextFloat();
int score=(int)(rr*ov2);
return score;
}
}
