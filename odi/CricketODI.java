import java.util.*;
class CricketODI
{
public static void main(String[] args)
{
	Scanner s=new Scanner(System.in);
CricketClass.Team1 te1=new CricketClass().new Team1();
CricketClass.Team2 te2=new CricketClass().new Team2();
String t1=te1.teamName();
String t2=te2.teamName();
//int score1,score2;
System.out.println("Welcome to ONE DAY INTERNATIONAL CRICKET");
System.out.println("----------------------------------------");
System.out.println(t1 + " v/s " + t2);
System.out.println("Enter Weather Condition :");
System.out.println(" 1. Rainy \n 2. No Rain Start The Match \n");
System.out.println("----------------------------------------");
int choice=s.nextInt();
CricketClass.NoRain cr=new CricketClass(). new NoRain();
try
{
cr.choiceCondition(choice,t1,t2);
}
catch(Exception e)
{
}
}
}
/*switch(choice)
{
	case 1: System.out.println("Match Delay Due to Rain");
			CricketClass.Rain ra=new CricketClass().new Rain();
			try
			{
			ra.waiting();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			break;
	case 2: try
			{
				System.out.println("1st Innings Played By " +t1);
				te1.overs();
				score1=te1.calculatingScore();
				System.out.println(t1 + " Score " +  " = " + score1);				
				
				System.out.println("..........................");
				
				System.out.println("2nd Innings Played By " +t2);
				te2.overs();
				score2=te2.calculatingScore();
				System.out.println(t2 + " Score " +  " = " + score2);
				
				System.out.println("..........................");
				CricketClass.Result r=new CricketClass().new Result();
				r.resultCalculating(t1,score1,t2,score2);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
			
			break;
	default: System.out.println("Invalid Choice : Please Try Again");
				break;
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

System.out.println("Enter Team1 Name");
String t1=s.next();
System.out.println("Enter Team2 Name");
String t2=s.next();
System.out.println("Welcome to ONE DAY INTERNATIONAL CRICKET");
System.out.println("----------------------------------------");
System.out.println(t1 + " v/s " + t2);
System.out.println("Weather Condition : ok/no");
String s1=s.next();
if(s1.equalsIgnoreCase("no"))
System.out.println("Match Dely due to Rain");
else

System.out.println("Weather ok Ready to Play");
System.out.println("========================");
System.out.println("Enter the Overs Played by: " +t1);
float ov1=s.nextFloat();
Team1 te1=new Team1();
int score1=te1.calculatingScore(ov1,t1);

System.out.println("...................");
System.out.println("Enter the Overs Played by: " +t2);
float ov2=s.nextFloat();
Team2 te2=new Team2();
int score2=te2.calculatingScore(ov1,t2);
System.out.println("Total Scored By " + t2 + " = " + score2);
System.out.println("...................");
System.out.println("2nd Innings Over By " +t2);
System.out.println("...................");

if(score1>score2)
System.out.println("Match Won By " +t1);
else
System.out.println("Match Won By " +t2);
*/

