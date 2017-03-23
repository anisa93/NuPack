import java.util.Scanner;


public class NuPack {
	
	public static double markup(String job,String people,String category)
	{
		String replacedollar=job.replace("$","");
		double baseprice=Double.parseDouble(replacedollar);
		//double amount=0.0;
		//flat markup 5% each
		double basemp =((baseprice*5)/100)+baseprice;
		
		//for people 1.2% each
		people = people.substring(0,people.indexOf("p"));
		int price_people = Integer.parseInt(people);
		double personmp = ((basemp*price_people*1.2)/100);
		double categorymp;
		if(category.equals("pharmaceuticals")||(category.equals("drugs")||(category.equals("medicines"))))
		{
			categorymp=((basemp*7.5)/100);
		}
		else if(category.equals("food")||category.equals("fruits")||category.equals("vegetables"))
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
		//remove all spaces
		s = s.replace(" ","");
		//remove the first comma from the price
		s = s.replaceFirst(",","");
		String[] temp = s.split(","); 
		price = temp[0];
		person = temp[1];
		category = temp[2];
		double finalprice=markup(price,person,category);
		System.out.println("" + finalprice);
	}

}
