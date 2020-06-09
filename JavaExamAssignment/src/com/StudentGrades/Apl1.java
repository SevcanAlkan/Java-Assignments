package com.StudentGrades;

import Models.Student;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Apl1 extends Apl{

    private static final long serialVersionUID = 1L;
    protected Load ld;
    protected Save sv;

    protected JButton load,save;
    Apl1(){
        super(20,20,400,250);
        load = new JButton("load");
        load.addActionListener(ld = new Load());
        contr.add(load);
        save = new JButton("save");
        save.addActionListener(sv=new Save());
        contr.add(save);
        setTitle("Student's directory - version 2");
        revalidate();
    }
    public static void main(String arg[]){
        new Apl1();
    }
    class Save implements ActionListener  {
        public void actionPerformed(ActionEvent e ){
            ObjectOutputStream oos = null;
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");

            try{
                int userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    String path = fileToSave.getAbsolutePath();
                    path = path.contains(".") ? path.substring(0, path.indexOf(".")) + ".txt" : path + ".txt";

                    oos = new ObjectOutputStream (
                            new FileOutputStream (path));
                    oos.writeObject(prs);
                }

            }
            catch (IOException ex){
                System.out.println(ex);
            }
            try{
                if(oos!=null)oos.close();
            }
            catch (IOException ex){}
        }
    }
    class Load implements ActionListener  {
        public void actionPerformed(ActionEvent e ){
            ObjectInputStream ios = null;
            JFrame parentFrame = new JFrame();

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to load");

            try{
                int userSelection = fileChooser.showSaveDialog(parentFrame);

                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToSave = fileChooser.getSelectedFile();

                    String path = fileToSave.getAbsolutePath();

                    ios = new ObjectInputStream (new FileInputStream (path));
                    prs= (Student[])ios.readObject();
                }
            }
            catch (Exception ex){
                tf[0].setText("Error");
            }
            try{
                if(ios!=null)ios.close();
            }
            catch (IOException ex){}
            lst. removeAll();
            for(int i=0;i<prs.length;i++){
                lst.add(""+prs[i]);
            }
        }
    }
}