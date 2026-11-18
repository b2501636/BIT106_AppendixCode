/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package customermembershipmanagement;

/**
 *
 * @author User
 */
public class VipMembership extends Membership{
    // Additional attributes for VIP members
    private double discountRate;
    private String exclusivePerks;

    // Constructor
    public VipMembership(String membershipID, String membershipName,
                         double membershipFee, int rewardPoints,
                         double discountRate, String exclusivePerks) {

        super(membershipID, membershipName, "VIP",
              membershipFee, rewardPoints);

        this.discountRate = discountRate;
        this.exclusivePerks = exclusivePerks;
    }

    // Getter for discountRate
    public double getDiscountRate() {
        return discountRate;
    }

    // Setter for discountRate
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    // Getter for exclusivePerks
    public String getExclusivePerks() {
        return exclusivePerks;
    }

    // Setter for exclusivePerks
    public void setExclusivePerks(String exclusivePerks) {
        this.exclusivePerks = exclusivePerks;
    }

    // Override toString()
    @Override
    public String toString() {
        return super.toString()
                + "\nDiscount Rate: " + (discountRate * 100) + "%"
                + "\nExclusive Perks: " + exclusivePerks;
    }
}
