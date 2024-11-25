import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Controller c = new Controller(this);

    public void userInterface() {
        boolean running = true;
        while (running) {
            try {
                System.out.print("""
                        
                        Type "help", for a list of commands.\
                        
                        Choose an option:\s""");
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                //Dette splitter brugerens input, som vi gør brug af i bla search funktionen:
                String userInput = br.readLine().toLowerCase();
                String[] splitPut = userInput.split(" ");
                String command = splitPut[0];

                //Switch på forskellige commands brugeren kan vælge
                switch (command) {
                    case ("add") -> addMember();
                    case ("search") -> System.out.println(doSearch());
                    case ("members") -> System.out.println(listMembers(c.runSearch("mail", "")));
                    case ("income") -> System.out.println("yearly income is a total of: " + c.countIncome() + "kr.");
                    case ("unpaid") -> System.out.println("members who have yet to pay are as follows:" + listMembers(c.findUnpaid()));
                    case ("help") -> System.out.println(help());

                    default -> System.out.println("Unknown request, please try again.");
                }
            } catch (ArrayIndexOutOfBoundsException | IOException aioobe) {
                System.out.println("Unknown request, please try again.");
            }
        }
    }

    public int reqInt(String quote) {
        Scanner sc = new Scanner(System.in);
        System.out.println(quote);
        while (true) {
            String temp = sc.next();
            String tempExclLetters = temp.replaceAll("[^0-9]", "");
            if (!tempExclLetters.equals("")) {
                return Integer.parseInt(tempExclLetters);
            } else System.out.println("no number was found");
        }
    }

    public String reqString(String quote) {
        Scanner sc = new Scanner(System.in);
        System.out.println(quote);
        return sc.next();
    }

    public Boolean reqBool(String quote) {
        Scanner sc = new Scanner(System.in);
        System.out.println(quote);
        while (true) {
            switch (sc.next().toLowerCase()) {
                case "true", "yes":
                    return true;
                case "false", "no":
                    return false;
                default:
                    System.out.println("that's not a bool, try again");
            }
        }
    }

    public String doSearch()
    {
        String s =reqString("search for mail or name?");
        while (true)
        {
                switch (s) {
                    case ("mail") -> {
                        return   listMembers(c.runSearch( s ,reqString("what mail are you looking for?")));
                    }
                    case ("name") -> {
                        return   listMembers(c.runSearch(s, reqString("what name are you looking for")));
                    }
                    default -> s = reqString("invalid input, try again");
                }
        }
    }

    public String help() {
        return
                """
                        commands:
                        1. add; adds a member to the system
                        2. search: find all members with a mail that contains what you write
                        3. members: list all members
                        4. income: see total annual income
                        5. unpaid: see all members with unpaid membership fees
                        """;
    }

    public String listMembers(ArrayList<Member> list) {
        String result = "";
        for (Member m : list) {
            String active;
            if (m.getActive()) active = "yes";
            else active = "no";

            result = result + "\n"
                    + m.getName() + " " + m.getMail() + "\n"
                    + "age: " + m.getAge() + "\n"
                    + "active membership: " + active + "\n"
                    + "annual fee: " + m.getPayment()
                    + m + "\n"
            ;
        }if (result == "") return "no such member was found";
        return result;
    }

    public void addMember() {
        if (reqBool("is the member a competitor?"))
        {
            c.addComp(
                    reqInt("type age"),
                    reqBool("is the member active"),
                    reqString("what is the name of the member"),
                    reqString("type Email"),
                    reqBool("crawl?"),
                    reqBool("breaststroke?"),
                    reqBool("butterfly?"),
                    reqBool("backCrawl?")
            );
        }
        c.addMember(
                reqInt("type age"),
                reqBool("is the member active"),
                reqString("what is the name of the member"),
                reqString("type Email")
        );
    }
}


