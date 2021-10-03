package com.example.java;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class MembershipManagement {

    final private Scanner input = new Scanner(System.in);


            private int getIntInput() {

                int choice = input.nextInt();
                try {

                    if (choice < 0 || choice > 6)
                        throw new InputMismatchException();
                } catch (InputMismatchException e) {
                    System.out.print("\nERROR: INVALID INPUT. Please try again, insert numeric input from 0 to 4:");
                }

                return choice;
            }

    public int  printGetChoice() {
        int choice;

        System.out.println("\nWELCOME TO OZONE FITNESS CENTER");
        System.out.println("================================");
        System.out.println("1) Add Member");
        System.out.println("2) Remove Member");
        System.out.println("3) Display Member Information");
        System.out.println("4) Display All Members Information");
        System.out.println("5) Filter Members According Name");
        System.out.print("\nPlease select an option (or Enter 0 to quit): ");

        choice = getIntInput();
        return choice;
    }


    private void printClubOptions(){
        System.out.println("1) Club Mercury");
        System.out.println("2) Club Neptune");
        System.out.println("3) Club Jupiter");
        System.out.println("4) Multi Clubs");
    }

    public void addMember(LinkedList<Member> memberList){
        Scanner userInput = new Scanner(System.in);
        String name;
        int club;
        double fees;
        int memberID;
        Member mbr;
        Calculator<Integer> cal;

        System.out.println("\nPlease enter member's name: ");
        name = userInput.nextLine();

        printClubOptions();

        System.out.println("Please enter the club ID that the member has access to: ");
        club = getIntInput();

        while (club < 1 || club > 4)
        {
            System.out.print("\nInvalid Club ID. Please try again: ");
            club = getIntInput();
        }

        if (memberList.size() !=0)

            memberID = memberList.getLast().getMemberID() + 1;
        else
            memberID = 1;

        if (club != 4)
        {
            //Add a single club member
            cal = (n)-> {
                switch(n){
                    case 1:
                        return 900;
                    case 2:
                        return 950;
                    case 3:
                        return 1000;
                    default:
                        return -1;
                }
            };
            fees = cal.calculateFees(club);

            mbr = new SingleClubMember('S',memberID, name, fees, club);
            memberList.add(mbr);


            System.out.println("\nSTATUS: Single Club Member added\n");
        }
        else {
            //Add a multi club member
            cal = (n)-> {
                if (n == 4)
                    return 1200;

                    else
                        return -1;
            };
            fees = cal.calculateFees(club);

            mbr = new MultiClubMember('M',memberID, name, fees, 100);
            memberList.add(mbr);


            System.out.println("\nSTATUS: Multi Club Member added\n");
        }
    }

    public void removeMember(LinkedList<Member> memberList){

                int memberID;

        System.out.println("\n Enter the Member ID of the member that you want to remove\n");

                memberID = getIntInput();

                for (int i = 0; i<memberList.size();i++){

                    if (memberList.get(i).getMemberID()==memberID){

                        memberList.remove(i);

                        System.out.println("The club member ID " +memberID+ " has been removed");

                        return;
                    } else {
                        System.out.println("\nMember ID not found\n");
                    }
                }
    }

    public void printMemberInfo(LinkedList<Member> memberList){


        System.out.print("\nEnter Member ID to display information: ");
        int memberID = getIntInput();

        for (Member member : memberList) {

            if (member.getMemberID() == memberID) {

                String[] memberInfo = member.toString().split(",");

                System.out.println("\nMember type " + memberInfo[0]);
                System.out.println("Member ID " + memberInfo[1]);
                System.out.println("Member name " + memberInfo[2]);
                System.out.println("Membership Fees " + memberInfo[3]);

                if (memberInfo[0].equals("S")) {
                    System.out.println("Club ID " + memberInfo[4]);
                } else {
                    System.out.println("Membership Points " + memberInfo[4]);
                }
                return;
            } else {
                System.out.println("\nMember ID not found\n");
            }
        }
    }

    public void printAllMembers(LinkedList<Member> memberList){

        for (Member member : memberList) {
            System.out.println(member.toString());
        }
    }

    public void filterMembers(LinkedList<Member> memberList){
        Scanner userInput = new Scanner(System.in);

        System.out.println("\nPlease enter member's name: ");

        String memberName = userInput.nextLine();

        memberList.parallelStream().filter(member -> {

            return member.getName().equalsIgnoreCase(memberName);
        }).forEach(System.out::println);

    }
}
