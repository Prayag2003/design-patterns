import java.util.ArrayList;

// only 1 Banker should be there
// acc id , holder name , get set , acc no

class Account {

    protected String acc_ID;
    protected int accNumber;
    protected String holderName;

    public String getAcc_ID() {
        return acc_ID;
    }

    public void setAcc_ID(String acc_ID) {
        this.acc_ID = acc_ID;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    @Override
    public String toString() {
        return "\n   {  \n  Account ID : " + acc_ID + "  \n Account Number is " + accNumber + " \n  Account Holder name is "
                + holderName + " \n  } ";
    }
}

class Banker {
    ArrayList<Account> BankReg = new ArrayList<Account>();

    // private constructor
    private Banker() 
    {};

    // a static variable , hence no instantiation is possible
    private static Banker b = null;

    // Method which returns class
    public static Banker getInstance() {

        if (b == null) {
            b = new Banker();
        }
        return b;
    }

    @Override
    public String toString() {
        return "Banker :- \n  { \n BankReg = \n" + BankReg + " \n} ";
    }
}

class SingleTon {
    public static void main(String[] args) {
  
        // should be made exactly once
        Banker b1 = Banker.getInstance();

        Account a1 = new Account();
        Account a2 = new Account();

        a1.setAccNumber(1000);
        a1.setAcc_ID("1234");
        a1.setHolderName("Bhatt");

        a2.setAccNumber(2000);
        a2.setAcc_ID("5678");
        a2.setHolderName("Prayag");

        b1.BankReg.add(a1);
        b1.BankReg.add(a2);

        System.out.println(b1);
    }
}
