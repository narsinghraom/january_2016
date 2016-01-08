import java.util.*;
class OversException extends Exception
{
	public String toString()
	{
		String s1="Overs not greater then 50: please enter <=50";
		return s1;
	}
}
class MatchTieException extends Exception
{
	public String toString()
	{
		String s1="MATCH TIE";
		return s1;
	}
}
class AbandonedException extends Exception
{
	public String toString()
	{
		String s1="Match Abandoned";
		return s1;
	}
}
class NoResultException extends Exception
{
	public String toString()
	{
		String s1="NO RESULT"; //none team needs to have faced fewer than 20 overs (of the allotted 50 for a match) for a match to be a no result.";
		return s1;
	}
}
class FourtyException extends Exception
{
	public String toString()
	{
		String s1="Due to Rain Overs Reduced to 40.. Please enter <=40";
		return s1;
	}
}
class CricketClass //main class
{
class Team1	// team1 inner class
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
float overs(String t1)throws Exception
{
	System.out.println("Enter the Overs Played by: " +t1);
	ov1=s.nextFloat();
	if(ov1>50)
	{
		throw new OversException();
		
			}
	return ov1;
}
float oversFourty(String t1)throws Exception
{
	//Team1 tt=new Team1();
	System.out.println("Enter the Overs Played by: " +t1);
	ov1=s.nextFloat();
	if(ov1>40)
	{
		throw new FourtyException();
	}
	return ov1;
}
int calculatingScore(String t1)
{
System.out.println("Enter the Runrate for :"+t1);
float rr=s.nextFloat();
int score=(int)(rr*ov1);
return score;
}
}	// end of team1 inner class
class Team2	//team2 inner class
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
float overs(String t2)throws Exception
{
	Team1 tt=new Team1();
	System.out.println("Enter the Overs Played by: " +t2);
	ov2=s.nextFloat();
	if(ov2>50)
	{
		throw new OversException();
	}
	//if(ov2<50&&ov2>=20)
	//{
	//	Result r=new Result();
	//	r.duckWerth(ov2);
	//}
	if(ov2<20)
	{
		throw new NoResultException();
	}
	return ov2;
}
float oversFourty(String t2)throws Exception
{
	//Team1 tt=new Team1();
	System.out.println("Enter the Overs Played by: " +t2);
	ov2=s.nextFloat();
	if(ov2>40)
	{
		throw new FourtyException();
	}
	if(ov2<20)
	{
		throw new NoResultException();
	}
	return ov2;
}
int calculatingScore(String t2)
{
System.out.println("Enter the Runrate for :"+t2);
float rr=s.nextFloat();
int score=(int)(rr*ov2);
return score;
}
}	//end of team2 inner class
class Result	//for calculating result inner class
{
	void resultCalculating(String t1,String t2,int score1,int score2,float ov2)throws Exception
	{
		if(ov2==50||ov2>20)
		{
			if(score1>score2)
			{
			System.out.println("Match Won By " +t1);
			}
			if(score1<score2)
			{
			System.out.println("Match Won By " +t2);
			}
			if(score1==score2)
			{ 
				System.out.println(t1 + " v/s " +t2);
				throw new MatchTieException();
			}
		}
			if(ov2==20)
			{
				int rr=score1/50;
				int rr1=score2/20;
			if(rr>rr1)
			{
			System.out.println("Match Won By " +t1);
			}
			if(rr<rr1)
			{
			System.out.println("Match Won By " +t2);
			}
			if(rr==rr1)
			{ 
				System.out.println(t1 + " v/s " +t2);
				throw new MatchTieException();
			}
			}
				
		
	}
	void duckWerth(float over)
	{
		System.out.println("tie");
	}
}	// end of result class
class Rain	//Rain inner class
{
	Scanner s=new Scanner(System.in);
	void waiting(String t1,String t2)throws Exception
	{
		System.out.println("After 1.5hr: Still Raining? yes/no:");
		String s1=s.next();
		if(s1.equalsIgnoreCase("no"))
		{
			float ov=40.0f;
			System.out.println("Due to rain Overs Reduced to 40 overs");
			NoRain nr=new NoRain();
			nr.fourtyOvers(ov,t1,t2);
			
		}
		else
		System.out.println("After 3hr: Still Raining? yes/no:");
		String s2=s.next();
		if(s2.equalsIgnoreCase("no"))
		{
			System.out.println("Due to Rain Overs Reduced to 20 Overs");
		}
		else
		{
			throw new AbandonedException();
		}
	}
}	// end of Rain class
class NoRain	// NoRain class 
{
	CricketClass.Team1 te1=new CricketClass().new Team1();
	CricketClass.Team2 te2=new CricketClass().new Team2();
	//String t1=te1.teamName().t1;
	//String t2=te2.t2;
	void choiceCondition(int choice,String t1,String t2)
	{
		switch(choice)
{
	case 1: System.out.println("Match Delay Due to Rain");
			CricketClass.Rain ra=new CricketClass().new Rain();
			try
			{
			ra.waiting(t1,t2);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			break;
	case 2: try
			{
				System.out.println("1st Innings Played By " +t1);
				te1.overs(t1);
				int score1=te1.calculatingScore(t1);
				System.out.println(t1 + " Score " +  " = " + score1);				
				
				System.out.println("..........................");
				
				System.out.println("2nd Innings Played By " +t2);
				float ov2=te2.overs(t2);
				int score2=te2.calculatingScore(t2);
				System.out.println(t2 + " Score " +  " = " + score2);
				
				System.out.println("..........................");
				//Result r=new Result();
				CricketClass.Result r=new CricketClass().new Result();
				r.resultCalculating(t1,t2,score1,score2,ov2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			break;
	default: System.out.println("Invalid Choice : Please Try Again");
				break;
}

	}
	void fourtyOvers(float overs,String t1,String t2)
	{
		try
		{
				System.out.println("1st Innings Played By " +t1);
				te1.oversFourty(t1);
				int score1=te1.calculatingScore(t1);
				System.out.println(t1 + " Score " +  " = " + score1);				
				
				System.out.println("..........................");
				
				System.out.println("2nd Innings Played By " +t2);
				float f1=te2.oversFourty(t2);
				int score2=te2.calculatingScore(t2);
				System.out.println(t2 + " Score " +  " = " + score2);
				
				System.out.println("..........................");
				CricketClass.Result r=new CricketClass().new Result();
				r.resultCalculating(t1,t2,score1,score2,f1);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}	//end of No Rain class
}
