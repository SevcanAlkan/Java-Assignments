package com.exercises.common;

public class GuessWhoCondition {
    private String Name;
    private Boolean hasMustaches;
    private Boolean hasGlasses;
    private Boolean hasHat;
    private Boolean isAMan;

    public GuessWhoCondition (String Name, Boolean hasMustaches, Boolean hasGlasses, Boolean hasHat, Boolean isAMan) {
        this.hasGlasses = hasGlasses;
        this.hasHat = hasHat;
        this.hasMustaches = hasMustaches;
        this.isAMan = isAMan;
    }
}
