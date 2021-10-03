package com.example.java;

public class Member {
    private final char memberType;
    private final int memberID;
    private final String name;
    private final double fees;

    public Member (char pMemberType, int pMemberID, String pName, double pFees ){
        this.memberType = pMemberType;
        this.memberID = pMemberID;
        this.name  = pName;
        this.fees = pFees;

    }

    public int getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return memberType + ", " + memberID + ", " + name + ", " + fees;
    }
}
