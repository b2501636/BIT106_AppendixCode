/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermembershipmanagement;

/**
 *
 * @author User
 */
public class Customer {
    //Encapsulation: private attributes
    private String customerID;
    private String customerName;
    private String phoneNumber;
    private String email;
    private Membership membership;
    //Constructor
    public Customer(String customerID, String customerName,
            String phoneNumber, String email){
        this.customerID = customerID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    //Getter
    public String getCustomerID(){
        return customerID;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    
    public String getphoneNumber(){
        return phoneNumber;
    }
    
    public String getEmail(){
        return email;
    }
    
    public Membership getMembership(){
        return membership;
    }
    //Setter
    public void setCustomerID(String customerID){
        this.customerID = customerID;
    }
    
    public void setCustomerName(String customerName){
        this.customerName = customerName;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setMembership(Membership membership){
        this.membership = membership;
    }
}
