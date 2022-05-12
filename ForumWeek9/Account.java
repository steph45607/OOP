public class Account {
    private double balance;
    public Account(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public boolean deposit(double amt){
        if(amt < 0){
            return false;
        }
        else{
            this.balance += amt;
            return true;
        }
    }
    public boolean withdraw(double amt){
        if(amt > this.balance||amt < 0){
            return false;
        }
        else{
            this.balance -= amt;
            return true;
        }
    }

}
