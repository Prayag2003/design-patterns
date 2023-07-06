import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

interface CustomerServiceDatabase {
    Customer getCustomerDetail(String custId) throws IOException;
}

class Customer {
    String custID, custName, custEmail, custCity;

    Customer(String custID) {
        this.custID = custID;
    }
}

class ClientServiceProxy implements CustomerServiceDatabase {
    CustomerService cs = new CustomerService();
    int flag = 0;
    String userInfo = "";

    public void Credentials(String UserName, String Password) {
        BufferedReader reader;
        try {
            FileReader readFile = new FileReader(
                    "C:/Users/Prayag Ravi Bhatt/OneDrive/Desktop/DESIGN_PATTERN/userInfo.txt");
            reader = new BufferedReader(readFile);
            String line = reader.readLine();
            while (line != null) {
                String str = line.substring(0, 6);
                String str1 = line.substring(15);
                if (Password.equalsIgnoreCase(str) && UserName.equalsIgnoreCase(str1)) {
                    userInfo = line;
                    flag = 2;
                    if (line.substring(7, 12).equalsIgnoreCase("admin")) {
                        flag = 1;
                    }
                    break;
                }
                line = reader.readLine();
            }
            if (flag == 0) {
                userInfo = "User Searched for Wrong Profile";
            } else if (flag != 1) {
                System.out.println("Unauthorized Access !");
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerDetail(String custId) throws IOException {
        // write user information to the logCustomerDatabase.txt
        // if user role is "admin" then forward the request
        if (flag == 1) {
            Customer c = cs.getCustomerDetail(custId);
        }
        String info1 = "\n User: " + userInfo + " searched for: " + custId;
        // else message "access denied".
        FileWriter fw = new FileWriter("C:/Users/Prayag Ravi Bhatt/OneDrive/Desktop/DESIGN_PATTERN/loggedUsers.txt",
                true);
        fw.write(info1);
        fw.close();
        return null;
    }
}

class CustomerService implements CustomerServiceDatabase {
    @Override
    public Customer getCustomerDetail(String custId) {
        // read file;
        // search for ID
        // else record not found
        BufferedReader reader;
        try {
            reader = new BufferedReader(
                    new FileReader("C:/Users/Prayag Ravi Bhatt/OneDrive/Desktop/DESIGN_PATTERN/loggedUsers.txt"));
            String line = reader.readLine();
            int flag = 0;
            while (line != null) {
                String str = line.substring(0, 5);
                if (custId.equalsIgnoreCase(str)) {
                    System.out.println(line);
                    flag = 1;
                    break;
                }
                // read next line
                line = reader.readLine();
            }
            if (flag == 0) {
                System.out.println("No such Client is found!");
                System.out.println("Access Denied!");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class Proxy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("User Name: ");
        String S1 = sc.nextLine();
        System.out.println("Password: ");

        String S2 = sc.nextLine();
        System.out.println("Client ID you want to search for: ");
        String S3 = sc.nextLine();
        
        sc.close();
        ClientServiceProxy c1 = new ClientServiceProxy();
        c1.Credentials(S1, S2);
        try {
            Customer c = c1.getCustomerDetail(S3);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}