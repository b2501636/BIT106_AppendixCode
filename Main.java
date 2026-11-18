/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermembershipmanagement;

/**
 *
 * @author User
 */
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args){
        MembershipManager manager = new MembershipManager(100);
        int choice = 0;
        
        do {
            System.out.println("\n=======================================");
            System.out.println("      MEMBERSHIP MANAGEMENT SYSTEM");
            System.out.println("=======================================");
            System.out.println("1. Add New Member");
            System.out.println("2. View all Members");
            System.out.println("3. Search Member (by ID or Name)");
            System.out.println("4. Update Member Details");
            System.out.println("5. Delete Member");
            System.out.println("6. Assign Membership");
            System.out.println("7. View Membership Details");
            System.out.println("8. Save Records to File");
            System.out.println("9. Load Records from File");
            System.out.println("0. Exit");
            
            System.out.println("Enter your choice (0-9): ");
            
            try{
                choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch(choice){
                    case 1:
                        handleAddMember(manager);
                        break;
                        
                    case 2:
                        manager.displayAllMembers();
                        break;
                        
                    case 3:
                        handleSearchMember(manager);
                        break;
                        
                    case 4:
                        handleUpdateMember(manager);
                        break;
                        
                    case 5:
                        handleDeleteMember(manager);
                        break;
                    
                    case 6:
                        handleAssignMembership(manager);
                        break;
                    
                    case 7:
                        handleViewMembershipDetails(manager);
                        break;
                    
                    case 8:
                        manager.saveToFile("membership.txt");
                        break;
                        
                    case 9:
                        manager.loadFromFile("membership.txt");
                        break;
                        
                    case 0:
                        System.out.println("Exiting system. Goodbye!");
                        break;
                        
                    default:
                        System.out.println("Error: Please enter a number between 0-9.");
                }
            }catch (NumberFormatException e){
            System.out.println("Invalid input! Please enter a valid numeric choice.");
            }
        }while (choice != 0);
        scanner.close();
    }
    
    private static void handleAddMember(MembershipManager manager){
        System.out.println("Enter Customer ID: ");
        String id = scanner.nextLine().trim();
        System.out.println("Enter Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Enter Phone Number: ");
        String phone = scanner.nextLine().trim();
        System.out.println("Enter Customer Email: ");
        String email = scanner.nextLine().trim();
        
        Customer c = new Customer(id, name, phone, email);
        manager.addMember(c);
    }
    
    private static void handleSearchMember(MembershipManager manager){
        System.out.println("Enter Customer ID or Name to search: ");
        String keyword = scanner.nextLine().trim();
        Customer found = manager.searchMember(keyword);
        if(found != null){
            System.out.println("Customer Found --> ID: " + found.getCustomerID() + ", Name: " + found.getCustomerName());
        }else{
            System.out.println("Customer not found.");
        }
    }
    
    private static void handleUpdateMember(MembershipManager manager){
        System.out.println("Enter Customer ID to update:");
        String id = scanner.nextLine().trim();
        System.out.println("Enter New Name:");
        String name = scanner.nextLine().trim();
        System.out.println("Enter New Email:");
        String email = scanner.nextLine().trim();
        manager.updateMember(id,name,email);
    }
    
    private static void handleDeleteMember(MembershipManager manager){
        System.out.print("Enter Customer ID to delete: ");
        String id = scanner.nextLine().trim();
        manager.deleteMember(id);
    }
    
    private static void handleAssignMembership(MembershipManager manager){
        System.out.println("Enter Customer ID to assign membership: ");
        String cusId = scanner.nextLine().trim();
        Customer c = manager.searchMember(cusId);
        if (c != null){
            System.out.print("Enter Membership ID: ");
            String mId = scanner.nextLine().trim();
            System.out.println("Enter Membership Name: ");
            String name = scanner.nextLine().trim();
            System.out.print("Enter Membership Type (Regular/VIP): ");
            String type = scanner.nextLine().trim();
            System.out.print("Enter Membership Fee: ");
            double fee = Double.parseDouble(scanner.nextLine().trim());
            System.out.print("Enter Reward Points: ");
            int points = Integer.parseInt(scanner.nextLine().trim());
            
            Membership m = new Membership(mId, name, type, fee, points);
            c.setMembership(m);
            System.out.println("Membership assigned successfully!");
        }else {
            System.out.println("Customer not found.");
        }
    }
    
    private static void handleViewMembershipDetails(MembershipManager manager){
        System.out.print("Enter Customer ID to view membership: ");
        String id = scanner.nextLine().trim();
        manager.viewMembershipDetails(id);
    }
}
