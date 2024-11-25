import java.util.ArrayList;

public class Controller {
    UserInterface ui;
    private MemberManager mm = new MemberManager();

    public Controller(UserInterface ui) {
        this.ui = ui;
    }

    public void addMember(int age, boolean active, String name, String mail) {
        mm.addMember(age,active, name, mail);
    }
    public void addComp(int age, boolean active, String name, String mail, boolean crawl, boolean breastStroke, boolean butterfly, boolean backCrawl) {
        mm.addMember(age,active, name, mail);
    }

    public ArrayList<Member> runSearch(String searchType, String searchTerm){
        ArrayList<Member> results;
        while (true)
            switch (searchType) {
                case ("mail") -> {
                    return mm.memberFinderMail(searchTerm);
                }
                case ("name") -> {
                    return mm.memberFinderName(searchTerm);
                }
            }
    }

    public int countIncome() {
        ArrayList<Member> members = mm.memberFinderName("");
        int result = 0;
        for (Member member : members) {
            result += member.getPayment();
        }
        return result;
    }

    public ArrayList<Member> findUnpaid() {
        return mm.unpaidMembershipFinder();
    }
}
