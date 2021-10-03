package com.example.java;

public class MultiClubMember extends Member {

    final private int membershipPoints;


    public MultiClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pMembershipPoints) {

        super(pMemberType, pMemberID, pName, pFees);

        this.membershipPoints = pMembershipPoints;

    }

    @Override
    public String toString() {
        return super.toString() + ", " + membershipPoints;
    }
}

