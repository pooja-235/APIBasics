package API.APIBasics;

import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJson {
	public static void main(String[] args) {
		int sum=0;
		//print the number of cources 
		JsonPath js=new JsonPath(payload.CoursePrice());
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//print the purchase amount
	    int purchaseamount=	js.getInt("dashboard.purchaseAmount");
	    System.out.println(purchaseamount);
	    
	    //print the title of the first cource
	    
	    String firstcourse=js.getString("courses[0].title");
	    System.out.println(firstcourse);
	    
	    //print all the course title and respective price
	    for(int i=0;i<count;i++) {
	    	String title=js.getString("courses["+i+"].title");
	    	System.out.println(title);
	    	System.out.println(js.getInt("courses["+i+"].price"));
	    }
	    
	    //print the number of copies sold by rpa
	    for(int i=0;i<count;i++) {
	    	String title=js.getString("courses["+i+"].title");
	    	if(title.equalsIgnoreCase("RPA")) {
	    		int copies=js.getInt("courses["+i+"].copies");
	    		System.out.println(copies);
	    		break;
	    	}
	    }
	    
	    //verify sum of all copies pricesmatches with price amount
	    for(int i=0;i<count;i++) {
	    	int price=js.getInt("courses["+i+"].price");	    	
	    	int copies=js.getInt("courses["+i+"].copies");
	    	int amount=price*copies;
	    	sum=sum+amount;
	    	System.out.println(amount);
	    }
	    
	    System.out.println(sum);
	    
	    
	}

}
