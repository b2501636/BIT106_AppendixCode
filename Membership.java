/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermembershipmanagement;

/**
 *
 * @author User
 */
public class Membership {
    //1. Encapsualtion: Declare vairiables as private 
    private String membershipID;
    private String membershipName;
    private String membershipType;
    private double membershipFee;
    private int rewardPoints;
    
    public Membership(){}
    //Constructor
    public Membership(String membershipID, String membershipName, 
            String membershipType,
            double membershipFee, int rewardPoints){
        this.membershipID = membershipID;
        this.membershipName = membershipName;
        this.membershipType = membershipType;
        this.membershipFee = membershipFee;
        this.rewardPoints = rewardPoints;
    }
    
    //All Getter 
    public String getMembershipID(){
        return membershipID;
    }
    public String getMembershipName(){
        return membershipName;
    }
    public String getMembershipType(){
        return membershipType;
    }
    public double getMembershipFee(){
        return membershipFee;
    }
    public int getRewardPoints(){
        return rewardPoints;
    }
    //All Setter
    public void setMembershipID(String membershipID){
        this.membershipID= membershipID;
    }
    public void setMembershipName(String membershipName){
        this.membershipName= membershipName;
    }
    public void setMembershipType(String membershipType){
        this.membershipType= membershipType;
    }
    public void setMembershipFee(double membershipFee){
        if (membershipFee >= 0){
            this.membershipFee= membershipFee;
        }
    }
    public void setRewardPoints(int rewardPoints){
        if (rewardPoints >= 0){
            this.rewardPoints= rewardPoints;
        }
    }
    //Display Membership Information
    @Override
    public String toString(){
        return "Membership ID: " + membershipID
                + "\nMembership Name: " + membershipName
                + "\nMembership Type: " + membershipType
                + "\nMembership Fee: RM" + String.format("%.2f", membershipFee)
                + "\nReward Points: " + rewardPoints;
    }
}
