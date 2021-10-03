package com.example.java;
import java.util.LinkedList;
import java.lang.String;

public class Main {

    public static void main(String[] args) {

        MembershipManagement mm = new MembershipManagement();
        LinkedList<Member> members = new LinkedList<>();

        int choice = mm.printGetChoice();

        do {
            if(choice == 0){
                System.out.println("\nThe system is closed.\nGood bye!");
                break;
            }else {
                switch (choice) {
                    case 1:
                        mm.addMember(members);
                        break;
                    case 2:
                        mm.removeMember(members);
                        break;
                    case 3:
                        mm.printMemberInfo(members);
                        break;
                    case 4:
                        mm.printAllMembers(members);
                        break;
                    case 5:
                        mm.filterMembers(members);
                        break;
                    default:
                        System.out.print("\nYou have selected an invalid option.\n\n");
                        break;
                }
            }

            choice = mm.printGetChoice();

        } while (choice != 0);

    }


}
