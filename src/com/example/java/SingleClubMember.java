package com.example.java;

public class SingleClubMember extends Member {

final private int club;


    public SingleClubMember(char pMemberType, int pMemberID, String pName, double pFees, int pClub) {

        super(pMemberType, pMemberID, pName, pFees); // super keyword to call the constructor in the parent class

        this.club = pClub;
    }


    @Override
    public String toString() {
        return super.toString() +
                ", " + club;
    }
}
