import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<String, Customer> customers = new HashMap<String, Customer>();
    private List<String> customersExists = new ArrayList<>();
//    private static Integer numberOfCustomers = 0;
    private Integer numberOfCustomers = 0;
    private String bankName;

    public Bank(String bName){
        this.bankName = bName;
    }
    public void addCustomer(String f, String l){
        Customer newCustomer = new Customer(f,l);
        this.customers.put(f, new Customer(f,l));
        this.customersExists.add(f);
        numberOfCustomers++;
    }
    public Integer getNumOfCustomers(){
        return numberOfCustomers;
    }
    public Customer getCustomer(String firstName){
        return customers.get(firstName);
    }
    public String getCustomerExist(int index){
        return customersExists.get(index);
    }
}
