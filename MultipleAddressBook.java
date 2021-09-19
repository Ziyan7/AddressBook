package AddressBook;

import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class MultipleAddressBook {
	
	/*@method to perform some operation 
	 * takes choice and specific address book object as parameters
	 */
	public static  void choice(int choice,AddressBookCreation object)
	{
			switch(choice)
			{
				case 1:	object.insertContact();			//add a new contact into address book
						break;
			
				case 2:object.edit();					//edit existing contact							
						break;
				   
				case 3: object.delete();				//delete the selected contact
						break;
						
				case 4: object.display();				//to display desired contact
						break;
					
				case 5:object.display_addressbook();	//to display entire address book
						break;	
			}
			
			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Map<String,AddressBookCreation>  multipleAddressBook = new HashMap<String, AddressBookCreation>();  //dictionary for mapping different address book with key 
		AddressBookCreation addressbook=new AddressBookCreation();					//first address book object
		
		String n="";
		String k="Book1";
		multipleAddressBook.put(k, addressbook);							//put the first address book into dictionary
		
		while(true)
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Delete contact\n4.Display contact\n5.Display addressbook\n6.Create another address book\n7.Search and count people from same place\n8.Search person by city name\n9.Search person by state name\n10.Sort names alphabetically\n11.Sort by City/State or zip\n12.exit"); //options for different actions
			int choice=sc.nextInt();
			if(choice==6)  //to create a new address book
			{
				System.out.println("Enter the name of the addressbook");
				n=sc.next();
				AddressBookCreation object1=new AddressBookCreation();  // a new address book object is created 
				multipleAddressBook.put(n, object1);
					
			}
			
			else if(choice==7)
			{
			    System.out.println("Enter the name of city or state");
			    String place=sc.next();
			    System.out.println("Persons whose state or city is "+place);
			    for(Map.Entry<String, AddressBookCreation> entry : multipleAddressBook.entrySet())
			    {
			        AddressBookCreation object1=entry.getValue();
			        object1.search(place);
			    }   
			}
			
			else if(choice==8)
			{
			    System.out.println("Enter the name of the city");
			    String city=sc.next();
			    System.out.println("Person belonging to this city is "+city);
			    for(Map.Entry<String, AddressBookCreation> entry : multipleAddressBook.entrySet())
			    {
			        AddressBookCreation object1=entry.getValue();
			        object1.viewPersonByCity(city);
			    }   
			}
			
			else if(choice==9)
			{
			    System.out.println("Enter the name of the state ");
			    String state=sc.next();
			    System.out.println("Person belonging to this state is "+state);
			    for(Map.Entry<String, AddressBookCreation> entry : multipleAddressBook.entrySet())
			    {
			        AddressBookCreation object1=entry.getValue();
			        object1.viewPersonByState(state);
			    }   
			}
			
			else if(choice==10)
			{
				int count=0;
			    for(Map.Entry<String, AddressBookCreation> entry : multipleAddressBook.entrySet())
			    {
			        AddressBookCreation temp=entry.getValue();
			        System.out.println("AddressBook "+(++count)+" details:");
			        temp.sortByName();
			    }  
			}
			
			else if(choice==11)
			{
				System.out.println("Enter the number to select the sort by option\n"
			    		+ "1.City\n"
			    		+ "2.State\n"
			    		+ "3.zip");
			    int option=sc.nextInt();
			    for(Map.Entry<String, AddressBookCreation> checkEntry : multipleAddressBook.entrySet())
			    {
			        AddressBookCreation tempObject=checkEntry.getValue();
			        System.out.println(checkEntry.getKey()+" details:");
			        tempObject.sortByCityStateZip(option);
			    }  
			}
			else if(choice==12)				//to exist from the program
				System.exit(0);
			else
			{
				System.out.println("Enter the addressbook where you want to insert or modify the  contact!!");
				n=sc.next();
				choice(choice,multipleAddressBook.get(n));   //to perform required operation on desired address book
			}		
		}
		
	}
}