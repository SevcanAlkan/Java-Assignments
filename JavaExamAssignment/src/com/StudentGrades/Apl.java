package com.StudentGrades;

import Models.Student;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.util.Arrays.sort;

public class Apl extends JFrame {

    private static final long serialVersionUID = 1L;

    protected JButton ad;
    protected JTextField tf[] = new JTextField[2];
    protected List lst;

    protected JPanel contr, plst;

    protected AdSt adSt;
    protected Student prs[] = new Student[0];

    Apl(int x, int y, int ln, int ht) {
        this.setLayout(new BorderLayout());
        this.setBounds(x, y, ln, ht);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Student's directory - version 1");

        contr = new JPanel(new FlowLayout());
        plst = new JPanel(new FlowLayout());

        ad = new JButton("add");
        contr.add(ad);
        tf[0] = new JTextField("name?", 10);
        tf[1] = new JTextField("grade?", 4);
        contr.add(tf[0]);
        contr.add(tf[1]);
        ad.addActionListener(adSt = new AdSt());
        add("North", contr);

        lst = new List(10);
        plst.add(lst);
        add("Center", plst);
        revalidate();
    }

    public static void main(String[] arg) {
        new Apl(20, 20, 400, 300);
    }

    class AdSt implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student s;
            int nt;
            String n = tf[0].getText();

            //Name verification
            if (!n.matches("[A-Z][a-z]{2,10}")) {
                tf[0].setText("Name?");
                return;
            }

            try {
                nt = Integer.parseInt(tf[1].getText());
            } catch (NumberFormatException ex) {
                tf[1].setText("Grade?");
                return;
            }
            Student help[] = new Student[prs.length + 1];
            System.arraycopy(prs, 0, help, 0, prs.length);
            help[help.length - 1] = s = new Student(n, nt);
            prs = help;

            tf[0].setText("name?");
            tf[1].setText("grade?");

            sortList();

            revalidate();
        }

        private void sortList() {
            lst.removeAll();

            sort(prs, (Student s1, Student s2) -> {
                return s2.compareTo(s1);
            });

            for (int i = 0; i < prs.length; i++) {
                lst.add("" + prs[i]);
            }
        }
    }
}