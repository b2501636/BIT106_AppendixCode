/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermembershipmanagement;

/**
 *
 * @author User
 */
import java.io.*;
public class MembershipManager {
    private Customer[] customers;
    private int count;
    
    // Constructor
    public MembershipManager(int capacity){
        customers = new Customer[capacity];
        count = 0;
    }
    //1.Add: Register a new member into the array
    public boolean addMember(Customer newCustomer){
        if (newCustomer == null){
            System.out.println("Invalid customer.");
            return false;
        }
        if (count < customers.length){
            customers[count] = newCustomer;
            count++;
            System.out.println("Customer added successfully.");
            return true;
        }else {
            System.out.println("Error :Customer list is full.");
            return false;
        }
    }
    
    //2.Search: Find a member by ID or name
    public Customer searchMember(String keyword){
        for (int i = 0; i < count; i++){
            if (customers[i].getCustomerID().equalsIgnoreCase(keyword)||
                    customers[i].getCustomerName().equalsIgnoreCase(keyword)){
                return customers[i];
            }
        }
        return null;
    }
    
    //3.Update: Modify an existing member's details ot tier
    public boolean updateMember(String id, String newName, String newEmail){
        Customer target = searchMember(id);
        
        if (target != null){
            target.setCustomerName(newName);
            target.setEmail(newEmail);
            System.out.println("Customer updated successfully.");
            return true;
        }
        System.out.println("Customer ID not found.");
        return false;
    }
    
    //4.Delete: Remove or deactivate a member from the array
    public boolean deleteMember (String id){
        for (int i = 0; i < count; i++){
            if (customers[i].getCustomerID().equalsIgnoreCase(id)){
                for (int j = i; j < count -1; j++){
                    customers[j] = customers [j + 1];
                }
                customers [count -1 ] = null;
                count--;
                System.out.println("Customer deleted successfully");
                return true;
            }
        }
        System.out.println("CustomerID not found.");
        return false;
    }
    
    //5.Display: List all registered members 
    public void displayAllMembers(){
        if (count == 0){
            System.out.println("No customers  registered yet.");
            return;
        }
        System.out.println("\n---Registered Members (" + count + ")---");
        for (int i = 0; i < count; i++){
            Customer c = customers[i];
            System.out.println(
            "ID: " +c.getCustomerID()+
            " | Name: " + c.getCustomerName()+
            " | Email: " + c.getEmail());
        if (c.getMembership() != null){
            Membership m = c.getMembership();
            System.out.println("-----> Membership ID: " + m.getMembershipID() +
                    " | Type: " + m.getMembershipType() + 
                    " | Fee: " + String.format("%.2f", m.getMembershipFee())+
                    " | Point: " + m.getRewardPoints());
        }else{
            System.out.println("-----> No Membership Assigned.");
        }
            
        }
    }
    //6.View Specific Membership Details
    public void viewMembershipDetails(String id){
        Customer c = searchMember(id);
        if (c !=null && c.getMembership() != null){
            Membership m = c.getMembership();
            System.out.println("\n--Membership Details for " + c.getCustomerName() + "---");
            System.out.println("Membership ID: " + m.getMembershipID());
            System.out.println("Type: " + m.getMembershipType());
            System.out.println("Fee: " + m.getMembershipFee());
            System.out.println("Reward Points: " + m.getRewardPoints());
        }else{
            System.out.println("Customer not found or has no membership assigned.");
        }
    }
    //7.Save to File
    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < count; i++) {
                Customer c = customers[i];
                String line = c.getCustomerID() + "," + c.getCustomerName() + "," + c.getEmail();
                if (c.getMembership() != null) {
                    Membership m = c.getMembership();
                    line += "," + m.getMembershipID() + "," + m.getMembershipName() + "," + m.getMembershipType() + "," + m.getMembershipFee() + "," + m.getRewardPoints();
                }
                writer.println(line);
            }
            System.out.println("Records saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    //8.Load from File
    public void loadFromFile(String filename){
        File file = new File(filename);
        if(!file.exists()){
            System.out.println("No saved file found");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            count = 0;
            while((line = reader.readLine()) != null && count < customers.length){
            String[] data = line.split(",");
            if (data.length >= 3){
                Customer c = new Customer(data[0], data[1], "", data[2]);
                if (data.length >= 8){
                    Membership m = new Membership(data[3], data[4], data[5], Double.parseDouble(data[6]), Integer.parseInt(data[7]));
                    c.setMembership(m);
                }
                customers[count++] = c;
            }
            }
            System.out.println("Records loaded from file successfully.");
        }catch (IOException | NumberFormatException e){
        System.out.println("Error loading from file: " + e.getMessage());
    }
    }
}
