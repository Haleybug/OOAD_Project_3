import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GourmetCustomerLine extends CustomerLine{

	public GourmetCustomerLine(List<String> menu) {
		super(menu);
	}
	
	public List<Customer> getCustomerLine(){
		Random rand = new Random(); ////https://www.geeksforgeeks.org/java-util-random-nextint-java/)
		//randomlly determine how many customer will get in line
		int numCasual = rand.nextInt(12) + 1; //1-12 casual customers
		int numBusiness = rand.nextInt(3) + 1; //1-3 business customers
		int numCatering = rand.nextInt(3) + 1; //1-3 catering customers
		int totalCustomers = numCasual + numBusiness + numCatering;
		
		List<Customer> line = new ArrayList<Customer>(); 
		while(totalCustomers != 0) { //add customers until the total amount determined in line is fulfilled 
			int customerType = rand.nextInt(3); // choose which customer type will be added to line
			if(customerType == 0 && numCasual != 0) { //Casual Customer
				totalCustomers -= 1;
				numCasual -= 1;   
				line.add(new CasualCustomer(getStoreMenu()));
			}
			else if(customerType == 1 && numBusiness != 0) { //Business Customer
				totalCustomers -= 1;
				numBusiness -= 1;
				line.add(new BusinessCustomer(getStoreMenu()));
			}
			else if(customerType == 2 && numCatering != 0){ //Catering Customer
				totalCustomers -= 1;
				numCatering -= 1;
				line.add(new CateringCustomer(getStoreMenu()));
			}
		}
		
		return line;
	}

}
