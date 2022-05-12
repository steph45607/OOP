import java.util.Objects;
import java.util.Scanner;

public class Methods {
//    welcomeBank - output a prompt and ask for an input
//    also prints a list of created banks
    public static void welcomeBank(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Do you want to create a bank or go to one?");
        System.out.println("- Create a bank [input: create]");
        for(int i = 0; i < Storage.banks.toArray().length; i++){
            System.out.println("- " + Storage.banks.get(i));
        }System.out.println("- Kill the factory [ipnut: kill]");
        String answer = userInput.nextLine();
        exitPage(answer);
        serviceInput(answer);
    }

//    see the input from welcomeBank
//    redirect users to different functions between create and banks
    public static void serviceInput(String answer){
        if(answer.equalsIgnoreCase("create")){
            createProcess();
        }else if(answer.equalsIgnoreCase("kill")){
            killFactory();
        }
        else{
            if(nameAvailability(answer)) {
                enterBank(answer);
            }else{
                System.out.println("=========================");
                System.out.println("Bank doesn't exist, please enter again.\n");
                System.out.println("=========================");
                welcomeBank();
            }
        }
    }

//    function to create a bank, takes name as a parameter
//    will append to the banks array in Storage
    public static void createBank(String name) {
        Storage.bankExists.put(name, new Bank(name));
        Storage.banks.add(name);
    }

//    create bank process, ask for the name
//    and check the availability of the name
//    prompts user to input new name if bank name already exists
    public static void createProcess(){
        Scanner bankName = new Scanner(System.in);
        System.out.println("Enter new bank name:");
        String answer = bankName.nextLine();
        exitPage(answer);
        if(!nameAvailability(answer)){
            createBank(answer);
            System.out.println(answer + " created");
            System.out.println("=========================");
            welcomeBank();
        }else{
            System.out.println("Name already taken, please use another name");
            System.out.println("=========================");
            createProcess();
        }
    }

//    check the availability of bank's name
//    return boolean, output will be controlled from createProcess()
    public static boolean nameAvailability(String name){
        for(int i = 0; i < Storage.banks.toArray().length; i++){
            if(name.equalsIgnoreCase(Storage.banks.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static void enterBank(String name){
        for(int i = 0; i < Storage.banks.toArray().length; i++){
            if(Objects.equals(Storage.banks.get(i), name)){
                bankMenu(Storage.banks.get(i));
            }
        }
    }

    public static void bankMenu(String answer){
        System.out.println("======== Welcome to " + answer +" ========");
        Scanner userInput = new Scanner(System.in);
        System.out.println("- Log in [input: Login]");
        System.out.println("- Register [input: Register]");
        System.out.println("Input here: ");
        String user = userInput.nextLine();
        exitPage(user);
        if(user.equalsIgnoreCase("login")){
            loginCustomer(answer);
        }else if(user.equalsIgnoreCase("register")){
            newCustomer(answer);
        }
    }

    public static void newCustomer(String bankName){
        System.out.println("===== Register New Customer =====");
        System.out.println("Please enter your first and last\nname to create an account.");
        Scanner first = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = first.nextLine();
        exitPage(firstName);

        Scanner last = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = last.nextLine();
        exitPage(lastName);

        if(checkCustomer(bankName, firstName)){
            System.out.println("=========================");
            System.out.println("Name already exists, please use another name.");
            System.out.println("=========================");
            newCustomer(bankName);
        }else {
            Storage.bankExists.get(bankName).addCustomer(firstName, lastName);
            System.out.println("=========================");
            System.out.println("Welcome " + firstName + " " + lastName + " to " + bankName + "\n");
            System.out.println("=========================");
            System.out.println("To access data, please log in.");
            System.out.println("=========================");
            Storage.bankExists.get(bankName).getCustomer(firstName);

            bankMenu(bankName);
        }
    }

    public static void loginCustomer(String bankName){
        System.out.println("===== Log In =====");
        System.out.println("Please enter your first and last name.");
        Scanner first = new Scanner(System.in);
        System.out.println("First name: ");
        String firstName = first.nextLine();
        exitPage(firstName);

        Scanner last = new Scanner(System.in);
        System.out.println("Last name: ");
        String lastName = last.nextLine();
        exitPage(lastName);

        if(checkCustomer(bankName, firstName)){
            System.out.println("=========================");
            returnData(bankName, firstName);
        }
        else{
            System.out.println("=========================");
            System.out.println("Account doesn't exists. Enter again.");
            System.out.println("=========================");
            loginCustomer(bankName);
        };
    }

    public static boolean checkCustomer(String bankName, String firstName){
        for(int i = 0; i < Storage.bankExists.get(bankName).getNumOfCustomers(); i++){
            if(firstName.equalsIgnoreCase(Storage.bankExists.get(bankName).getCustomerExist(i))) {
                return true;
            }
        }
        return false;
    }

    public static void returnData(String bank, String name){
        System.out.println("Log-in successful. Account details:");
        Customer user = Storage.bankExists.get(bank).getCustomer(name);
        System.out.println("First Name: " + user.getFirstName());
        System.out.println("Last Name: " + user.getLastName());
        System.out.println("Balance: " + user.getAccount().getBalance());
        System.out.println("=========================");
        accMenu(bank, name);
    }
    public static void accMenu(String bank, String name){
        Customer user = Storage.bankExists.get(bank).getCustomer(name);
        System.out.println("Our services: ");
        System.out.println("- Deposit [input: deposit]");
        System.out.println("- Withdraw [input: withdraw]");
        Scanner input = new Scanner(System.in);
        System.out.println("Input here: ");
        String answer = input.nextLine();
        exitPage(answer);
        if(answer.equalsIgnoreCase("deposit")){
            depoAcc(user);
            returnData(bank, name);
        }else if(answer.equalsIgnoreCase("withdraw")){
            if(withAcc(user)){
                System.out.println("=========================");
                returnData(bank, name);
            }
            else{
                System.out.println("=========================");
                System.out.println("Can't withdraw less than 0, or your balance is 0.");
                System.out.println("=========================");
                withAcc(user);
            }
        }
    }

    public static void depoAcc(Customer name){
        System.out.println("=====DEPOSIT=====");
        Scanner amount = new Scanner(System.in);
        System.out.println("Input amount to deposit: ");
        double amt = amount.nextDouble();
        name.getAccount().deposit(amt);
    }

    public static boolean withAcc(Customer name){
        System.out.println("=====WITHDRAW=====");
        Scanner amount = new Scanner(System.in);
        System.out.println("Input amount to withdraw: ");
        double amt = amount.nextDouble();
        return name.getAccount().withdraw(amt);
    }

    public static void exitPage(String input){
        if(input.equalsIgnoreCase("exit")){
            welcomeBank();
        }
    }

    public static void killFactory(){
        System.out.println("=====Thanks for using our service=====");
    }
}
