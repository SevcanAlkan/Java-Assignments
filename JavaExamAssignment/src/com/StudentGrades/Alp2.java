package com.StudentGrades;

import java.awt.event.*;

class Apl2 extends Apl1 {

    private static final long serialVersionUID = 1L;
    protected InName inm;
    protected InGrade ing;

    public static void main(String[] args) {
        new Apl2();
    }
    Apl2(){
        tf[0].addFocusListener(inm = new InName());
        tf[1].addFocusListener(ing = new InGrade());
        this.setTitle("Student's directory - version 3");
    }
    class InName implements FocusListener{
        public void focusGained(FocusEvent e) {
            if (tf[0].getText().equals("name?"))
                tf[0].setText("");
        }
        public void focusLost(FocusEvent e){
            if (tf[0].getText().equals(""))
                tf[0].setText("name?");
        }
    }
    class InGrade implements FocusListener{
        public void focusGained(FocusEvent e) {
            if (tf[1].getText().equals("grade?"))
                tf[1].setText("");
        }
        public void focusLost(FocusEvent e){
            if (tf[1].getText().equals(""))
                tf[1].setText("grade?");
        }
    }
}