import java.util.Random;

public class Competitor extends Member {

    protected boolean crawl;
    protected boolean breastStroke;
    protected boolean butterfly;
    protected boolean backCrawl;

    public Competitor(int age, boolean active, String name, String mail, boolean crawl, boolean breastStroke, boolean butterfly, boolean backCrawl) {
        super(age, active, name, mail);
        this.age = age;
        this.active = active;
        this.mail = mail;
        this.name = name;
        this.crawl = crawl;
        this.breastStroke = breastStroke;
        this.butterfly = butterfly;
        this.backCrawl = backCrawl;
        calculatePayment();
        Random r = new Random();
        this.hasPaid = r.nextBoolean();
    }
    public boolean getBackCrawl()
    {
        return backCrawl;
    }

    public boolean getCrawl()
    {
        return crawl;
    }

    public boolean getBreastStroke()
    {
        return  breastStroke;
    }

    public boolean getButterfly()
    {

        return butterfly;
    }
}
