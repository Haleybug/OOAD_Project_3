import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class GourmetStore extends Store{

	public GourmetStore(int inventorySize) { //concrete factory for Store
		super(inventorySize, new ArrayList<String>(Arrays.asList("Egg Roll", "Jelly Roll", "Pastry Roll", "Sausage Roll", "Spring Roll")));
		//https://stackoverflow.com/questions/13395114/how-to-initialize-liststring-object-in-java
	}
	
	//return the corresponding roll object based on the order 
	//prices are all preset to different prices
	public Roll orderFromMenu(String order) { //factory pattern
		if(order == "Egg Roll") {
			return new EggRoll(1.00);
		}
		else if(order == "Jelly Roll") {
			return new JellyRoll(1.50);
		}
		else if(order == "Pastry Roll") {
			return new PastryRoll(2.00);
		}
		else if(order == "Sausage Roll") {
			return new SausageRoll(2.50);
		}
		else if(order == "Spring Roll") {
			return new SpringRoll(3.00);
		}
		
		return null;
	}
	
	public CustomerLine newCustomerLine() {
		return new GourmetCustomerLine(getMenu()); //create a new line of customers
	}
	
}
