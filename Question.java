public class Question
{
    Question next;
    String Q;
    String A;
    boolean q, a;
    public Question(String s, String as, boolean p, boolean q)
    {
        Q=s;
        A=as;
        this.q=p;
        this.a=q;
        next=null;
    }
    public Question()
    {
        next=null;
    }
    public void addQ(String s, String as, boolean p, boolean q)
    {
        Question n=new Question(s, as, p, q);
        next=n;
    }
}