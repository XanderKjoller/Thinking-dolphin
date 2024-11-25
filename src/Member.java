import java.util.Random;

public class Member {
    protected int payment;
    protected int age;
    protected String name;
    protected String mail;
    protected boolean active;
    protected boolean hasPaid;

    public Member(int age, boolean active, String name, String mail){
        this.age = age;
        this.active = active;
        this.mail = mail;
        this.name = name;
        calculatePayment();
        Random r = new Random();
        hasPaid = r.nextBoolean();
    }


    public void calculatePayment()
    {
        if(!active)
        {
            payment = 500;
        }else if(age<18)
        {
            payment = 1000;
        }
        else if (age<60)
        {
            payment = 1600;
        }else
        {
            payment = 1200;
        }
    }

    public int getAge() {
        return age;
    }

    public int getPayment() {
        return payment;
    }

    public String getMail() {
        return mail;
    }

    public String getName() {
        return name;
    }

    public boolean getActive()
    {
        return active;
    }

public boolean gethasPaid()
{
    return hasPaid;
}

    public void setActive(boolean active) {
        this.active = active;
        calculatePayment();
    }

    public void setAge(int age) {
        this.age = age;
        calculatePayment();
    }
}
