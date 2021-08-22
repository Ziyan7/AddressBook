package AddressBook;

import java.util.*;
public class AddressBookCreation {
	//Instance variables
	private String firstname;
	private String lastname;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone_number;
	private String email;
			
	//Constructors 
	public AddressBookCreation(String firstname,String lastname,String address,String city,String state,String zip,String number,String email)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_number=number;
		this.email=email;
	}
	//For displaying attributes
	public void display()
	{
		System.out.println("First Name: "+firstname);
		System.out.println("Last Name: "+lastname);
		System.out.println("Address: "+address);
		System.out.println("City: "+city);
		System.out.println("State: "+state);
		System.out.println("Zip: "+zip);
		System.out.println("Phone Number: "+phone_number);
		System.out.println("E-mail: "+email);
	}
	//For Editing Contacts
	public void edit(String firstname,String lastname,String address,String city,String state,String zip,String phone_number,String email)
	{
		this.firstname=firstname;
		this.lastname=lastname;
		this.address=address;
		this.city=city;
		this.state=state;
		this.zip=zip;
		this.phone_number=phone_number;
		this.email=email;
	}

	public static void main(String[] args) {
		System.out.println("Welcome to adress book program");	//welcome message for the concerned program
		
		Scanner sc=new Scanner(System.in);
		
		AddressBookCreation[] person=new AddressBookCreation[10];  //array to store objects
		String fname,lname,address,city,state,zip,phone,email;
		int n=0;
		//for loop to add n contact details
		while(true)
		{
			System.out.println("Enter your choice\n1.add contact\n2.edit contact\n3.Display contact\n4.exit");
			int ch=sc.nextInt();
			switch(ch)
			{
			case 1:									//To add contacts
			
				System.out.println("first Name:");
				fname=sc.next();
				System.out.println("last name:");
				lname=sc.next();
				System.out.println("address:");
				address=sc.next();
				System.out.println("city:");
				city=sc.next();
				System.out.println("state:");
				state=sc.next();
				System.out.println("zip:");
				zip=sc.next();
				System.out.println("phone number");
				phone=sc.next();
				System.out.println("E-mail:");
				email=sc.next();
				person[n]=new AddressBookCreation(fname,lname,address,city,state,zip,phone,email);	//object creation
				n++;
				break;
			
			case 2:System.out.println("Enter the person's first name : ");		//case to edit contacts
					String name=sc.next();
					for (int j=0;j<n;j++)
					{
						if(person[j].firstname.equals(name))
						{
							System.out.println("Enter first Name:");
							fname=sc.next();
							System.out.println("Enter last name:");
							lname=sc.next();
							System.out.println("Enter address:");
							address=sc.next();
							System.out.println("Enter city:");
							city=sc.next();
							System.out.println("Enter state:");
							state=sc.next();
							System.out.println("Enter zip:");
							zip=sc.next();
							System.out.println("Enter phone number:");
							phone=sc.next();
							System.out.println("E-mail address:");
							email=sc.next();
							person[j].edit(fname,lname,address,city,state,zip,phone,email);
						}
					}
					break;
				   
			
						
			case 3: System.out.println("Enter the person's first name:");		//To display a contact
					String name2=sc.next();
					for (int j=0;j<n;j++)
					{
						if(person[j].firstname.equals(name2))
						{
							int c1=j;
							person[c1].display();
						}
					   
					}
				
					break;
			case 4: System.out.println("Closed");
					System.exit(0);
					break;
			}
	}
}
}