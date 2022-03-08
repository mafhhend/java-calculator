import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private static final int width=600;
    private static final int height=500;

    private JPanel lbl;
    private JPanel btns;
    private JLabel text;
    private JLabel text00;

    private Button btnDigits[];
    private Button btnC;
    private Button btnSum;
    private Button btnEquals;
    private Long n1,n2;

    public void setEquals(){
        n2 = Long.parseLong(text.getText());
        text00.setText(text00.getText()+n2+"=");
        text.setText((n1+n2)+"");
        n1 = n1 + n2;
    }
    public void setPlus(){
        n1=Long.parseLong(text.getText());
        text.setText("0");
        text00.setText(n1 + "+");
    }
    public void setNumertoText(String s) {

        int ii=Integer.parseInt(s);
        long num =Long.parseLong(text.getText());
        if(((int)Math.log10(num)+1)<19)
        {
            num=num*10+ii;
            text.setText(num+"");
        }
    }
    public Main(){
        super("ماشین حساب");
        this.setBounds(100,100,width,height);
        this.setLayout(new FlowLayout());

        //////////////////////////// lbl
        lbl=new JPanel();
        lbl.setPreferredSize(new Dimension(width - 10,100));
        lbl.setBackground(Color.green);
        text=new JLabel();
        text.setBackground(Color.white);
        text.setPreferredSize(new Dimension(width - 20,35));
        text.setOpaque(true);
        text.setText("0");

        text00=new JLabel();
        text00.setBackground(new Color(200,200,200));
        text00.setPreferredSize(new Dimension(width - 20,35));
        text00.setOpaque(true);
//        text00.setText("0");

        lbl.add(text00);
        lbl.add(text);

        //////////////////////////// btns
        btns=new JPanel();
        btns.setPreferredSize(new Dimension(150,300  ));
        btns.setBackground(Color.red);
        btns.setLayout(new FlowLayout());
        btnDigits = new Button[10]; //0...9
        for(int i=0;i<10;i++)
        {
            btnDigits[i]=new Button(this);
            btnDigits[i].setPreferredSize(new Dimension(45, 30));
            btnDigits[i].setFont(new Font("tahoma",1,10));
            btnDigits[i].setText(i+"");
            btns.add(btnDigits[i]);
            final int ii=i;
            btnDigits[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setNumertoText(ii+"");

                }
            });
        }

        btnC=new Button(this);
        btnC.setPreferredSize(new Dimension(45, 30));
        btnC.setText("C");
        btnC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("0");
            }
        });

        btnEquals=new Button(this);
        btnEquals.setPreferredSize(new Dimension(45, 30));
        btnEquals.setText("=");
        btnEquals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setEquals();
            }
        });

        btnSum=new Button(this);
        btnSum.setPreferredSize(new Dimension(45, 30));
        btnSum.setText("+");
        btnSum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setPlus();
            }
        });


        btns.add(btnEquals);
        btns.add(btnC);
        btns.add(btnSum);
        this.add(lbl);
        this.add(btns);

        this.setVisible(true);
    }
    public static void main(String[] args) {
    new Main();
    }
}
