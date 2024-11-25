import java.util.ArrayList;

public class MemberManager {

    private ArrayList<Member> members = new ArrayList<Member>();
    private ArrayList<Member> crawlMembers = new ArrayList<Member>();
    private ArrayList<Member> breastStrokeMembers = new ArrayList<Member>();
    private ArrayList<Member> butterflyMembers = new ArrayList<Member>();
    private ArrayList<Member> backCrawlMembers = new ArrayList<Member>();
    public void addMember(int age, boolean active, String name, String mail)
    {
        Member m = new Member(age, active, name, mail);
        members.add(m);

    }
    public void addCompetitor(int age, boolean active, String name, String mail, boolean crawl, boolean breastStroke, boolean butterfly, boolean backCrawl)
    {
        Competitor m = new Competitor(age, active, name, mail, crawl, breastStroke, butterfly, backCrawl);
        if (m.getCrawl()) crawlMembers.add(m);
        if (m.getBreastStroke()) breastStrokeMembers.add(m);
        if(m.getButterfly()) butterflyMembers.add(m);
        if(m.getBackCrawl()) backCrawlMembers.add(m);
        members.add(m);


    }
    public void addMemberByObject(Member m)
    {
        members.add(m);
    }

    public ArrayList<Member> memberFinderMail(String searchTerm) {
        ArrayList<Member> results = new ArrayList<>();
        for (Member member : members) {

            if (member.getMail().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(member);
            }
        }
        return results;
    }

    public ArrayList<Member> memberFinderName(String searchTerm) {
        ArrayList<Member> results = new ArrayList<>();
        for (Member member : members) {

            if (member.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(member);
            }
        }
        return results;
    }

    public MemberManager()
    {
        addMember(10,true,"jimmy","jimme@james.dk");
        addMember(30,true,"melanie","mellie@james.dk");
        addCompetitor(70,true,"meth","meth@james.dk",false,true,false,true);
    }

    public ArrayList<Member> unpaidMembershipFinder()
    {
        ArrayList<Member> criminals = new ArrayList<Member>();
        for(Member m : members)
        {
            if (m.gethasPaid()) criminals.add(m);
        }
        return criminals;
    }
}
