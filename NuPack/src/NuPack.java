import java.util.Scanner;


public class NuPack {
	
	public static double markup(String job,String people,String category)
	{
		String newjob=job.replace("$","");
		double baseprice=Double.parseDouble(newjob);
		//double amount=0.0;
		//flat markup 5% each
		double basemp =((baseprice*5)/100)+baseprice;
		
		//for people 1.2% each
		char[] peoples=people.toCharArray();
		int price_people=Integer.valueOf(peoples[0])-'0';
		double personmp=((basemp*price_people*1.2)/100);
		double categorymp;
		if(category.equals("pharmaceuticals"))
		{
			categorymp=((basemp*7.5)/100);
		}
		else if(category.equals("food"))
		{
			categorymp=((basemp*13)/100);
		}
		else if(category.equals("electronics"))
		{
			categorymp=((basemp*2)/100);
		}
		else
		{
			categorymp = 0.0;
		}
		return basemp+personmp+categorymp;
	}
	public static void main(String args[])
	{
		
		Scanner sc1=new Scanner(System.in);
		String s = sc1.nextLine();
		String price = null,person = null,category = null;
		String[] tempList = s.split(","); 
	    price = tempList[0];
	    person = tempList[1];
	    category=tempList[2];
		double finalprice=markup(price,person,category);
		System.out.println(" the final price is"+finalprice);
	}

}
