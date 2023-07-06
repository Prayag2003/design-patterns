package PrevLabs;

// C O M P O S I T I O N 
import java.util.ArrayList;
import java.util.*;

class Contact {
    private String address;
    private String phone_number;
    private String email;

    Contact(String address, String phone, String email) {
        this.address = address;
        this.phone_number = phone;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "Phone Number :-" + phone_number + "email :- " + email + "Address :-" + address;
    }

}

class Applicant {
    private String applicant_name;
    private int years_of_experience;
    private Contact contact_List;

    Applicant(String name, int exp, Contact contact_list) {
        this.applicant_name = name;
        this.years_of_experience = exp;
        this.contact_List = contact_list;
    }

    public String toString() {
        return "applicant name :-" + applicant_name + "years_of_experience :-" + years_of_experience + "contact_List :-"
                + contact_List;
    }
}

class Industry {
    private String industry_name;
    List<String> applicant_list = new ArrayList<>();

    Industry(String name, List listt) {
        this.industry_name = name;
        this.applicant_list = listt;
    }

    void print(List contact_List) {
        for (int i = 0; i < contact_List.size(); i++) {
            System.out.println(contact_List.get(i));
        }
    }
}

public class Lab1 {
    public static void main(String[] args)

    {
        Contact a = new Contact("Vadodra", "123424842754", "prayagbhatt2003@gmail.com");
        Contact b = new Contact("Ahmedabad", "2313243995794", "karandattani2003@gmail.com");
        Contact c = new Contact("Bharuch", "75875228782502", "haritdobariya2003@gmail.com");
        Contact d = new Contact("Vadodara", "123424842754", "2003@gmail.com");
        Contact e = new Contact("Vadodara", "123424842754", "prayagbhatt2003@gmail.com");

        Applicant a1 = new Applicant("Prayag", 10, a);
        Applicant a2 = new Applicant("Karan", 11, b);
        Applicant a3 = new Applicant("Harit", 22, c);
        Applicant a4 = new Applicant("Aniket", 4, d);
        Applicant a5 = new Applicant("Jugal", 7, e);

        List<Applicant> listt = new ArrayList<>();
        List<Applicant> listtt = new ArrayList<>();
        List<Applicant> listttt = new ArrayList<>();
        listt.add(a1);
        listt.add(a2);
        listt.add(a3);
        listt.add(a4);
        listt.add(a5);

        Industry Software = new Industry("Software", listt);
        Industry Automobile = new Industry("Automobile", listt);
        Industry Mechanical = new Industry("Mechanical", listt);

        Software.print(listt);

    }
}

// composition not inheritance ---> industry , applicant example

// contact details ->seperate class
