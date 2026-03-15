import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
public class CardsChem extends JFrame
{
    JButton next, save, ans;
    JLabel l;
    Container c;
    Question q;
    String s;
    public CardsChem()
    {
        Qs.pic[146]=true;
        q=new Question();
        setBounds(420, 10, 470, 700);
        c=getContentPane();
        c.setBackground(new Color(170,170,170));
        setLayout(null);
        l=new JLabel();
        next=new JButton("Next");
        save=new JButton("Save");
        ans=new JButton("Show Answer");
        button();
        choose();
        label();
        setVisible(true);
        s="";
    }

    public void choose()
    {
        int x=0;
        boolean f=false;
        try
        {
            x=Integer.parseInt(JOptionPane.showInputDialog("No. of Question:"));
        }
        catch(Exception e)
        {
            System.out.println("WTF you doing brother");
        }
        if(x==0)
        {
            x=Qs.Q.length;
            f=true;
        }
        if(x<=Qs.Q.length)
        {
            Question t=q;
            while(x>0)
            {
                int ch=new Random().nextInt(Qs.Q.length);
                if(!(Qs.chosen[ch]))
                {
                    if(Qs.chem[ch])
                    {
                        t.addQ(Qs.Q[ch], Qs.Ans[ch], Qs.picQ[ch], Qs.pic[ch]);
                        Qs.chosen[ch]=!Qs.chosen[ch];
                        t=t.next;
                    }
                    if(Qs.chem[ch] || f)
                    {
                        x--;
                    }
                }
            }
            q=q.next;
        }
        else
        {
            System.exit(0);
        }
    }

    public void button()
    {
        ans.setBounds(140, 550, 180, 50);
        ans.setBackground(Color.blue);
        ans.setForeground(Color.white);
        c.add(ans);
        next.setBounds(240, 550, 180, 50);
        next.setBackground(Color.green);
        next.setForeground(Color.white);
        next.setVisible(false);
        c.add(next);
        save.setBounds(40, 550, 180, 50);
        save.setBackground(Color.red);
        save.setForeground(Color.white);
        c.add(save);
        save.setVisible(false);
    }

    public void label()
    {
        l.setBounds(20, 20, 400, 400);
        l.setForeground(Color.black);
        c.add(l);
        if(q.q)
        {
            l.setIcon(new ImageIcon(q.Q));
        }
        else
        {
            l.setText("<HTML>"+q.Q+"</HTML>");
        }
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setVerticalAlignment(JLabel.CENTER);
    }

    public static void main(String[] args)
    {
        CardsChem ob=new CardsChem();
        ob.ans.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ob.l.setIcon(null);
                    ob.l.setText("");
                    if(ob.q.a)
                    {
                        ob.l.setIcon(new ImageIcon(ob.q.A));
                    }
                    else
                    {
                        ob.l.setText("<HTML>"+ob.q.A+"</HTML>");
                    }
                    ob.save.setVisible(true);
                    ob.next.setVisible(true);
                    ob.ans.setVisible(false);
                }
            });
        ob.save.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    ob.s+=("Q: "+ob.q.Q+"\nA: "+ob.q.A+"\n");
                    ob.save.setEnabled(false);
                }
            });
        ob.next.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(ob.q.next==null)
                    {
                        System.out.println("Questions Saved:\n"+ob.s);
                        ob.setVisible(false);
                    }
                    else
                    {
                        ob.q=ob.q.next;
                        ob.l.setIcon(null);
                        ob.l.setText("");
                        ob.label();
                        ob.save.setVisible(!true);
                        ob.next.setVisible(!true);
                        ob.ans.setVisible(!false);
                        ob.save.setEnabled(true);
                    }
                }
            });
    }
}