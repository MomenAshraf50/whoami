package com.example.whoami;

public class PersonalityDetails {
    int imagePath;
    String personalityName ,personalityInfo ,personalityCharacteristicOne,personalityCharacteristicTwo
            ,personalityCharacteristicThree,personalityCharacteristicFour,personalityCharacteristicFive
            ,personalityCharacteristicSix;

    public PersonalityDetails(int imagePath, String personalityName, String personalityInfo, String personalityCharacteristicOne, String personalityCharacteristicTwo, String personalityCharacteristicThree, String personalityCharacteristicFour, String personalityCharacteristicFive, String personalityCharacteristicSix) {
        this.imagePath = imagePath;
        this.personalityName = personalityName;
        this.personalityInfo = personalityInfo;
        this.personalityCharacteristicOne = personalityCharacteristicOne;
        this.personalityCharacteristicTwo = personalityCharacteristicTwo;
        this.personalityCharacteristicThree = personalityCharacteristicThree;
        this.personalityCharacteristicFour = personalityCharacteristicFour;
        this.personalityCharacteristicFive = personalityCharacteristicFive;
        this.personalityCharacteristicSix = personalityCharacteristicSix;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public String getPersonalityName() {
        return personalityName;
    }

    public void setPersonalityName(String personalityName) {
        this.personalityName = personalityName;
    }

    public String getPersonalityInfo() {
        return personalityInfo;
    }

    public void setPersonalityInfo(String personalityInfo) {
        this.personalityInfo = personalityInfo;
    }

    public String getPersonalityCharacteristicOne() {
        return personalityCharacteristicOne;
    }

    public void setPersonalityCharacteristicOne(String personalityCharacteristicOne) {
        this.personalityCharacteristicOne = personalityCharacteristicOne;
    }

    public String getPersonalityCharacteristicTwo() {
        return personalityCharacteristicTwo;
    }

    public void setPersonalityCharacteristicTwo(String personalityCharacteristicTwo) {
        this.personalityCharacteristicTwo = personalityCharacteristicTwo;
    }

    public String getPersonalityCharacteristicThree() {
        return personalityCharacteristicThree;
    }

    public void setPersonalityCharacteristicThree(String personalityCharacteristicThree) {
        this.personalityCharacteristicThree = personalityCharacteristicThree;
    }

    public String getPersonalityCharacteristicFour() {
        return personalityCharacteristicFour;
    }

    public void setPersonalityCharacteristicFour(String personalityCharacteristicFour) {
        this.personalityCharacteristicFour = personalityCharacteristicFour;
    }

    public String getPersonalityCharacteristicFive() {
        return personalityCharacteristicFive;
    }

    public void setPersonalityCharacteristicFive(String personalityCharacteristicFive) {
        this.personalityCharacteristicFive = personalityCharacteristicFive;
    }

    public String getPersonalityCharacteristicSix() {
        return personalityCharacteristicSix;
    }

    public void setPersonalityCharacteristicSix(String personalityCharacteristicSix) {
        this.personalityCharacteristicSix = personalityCharacteristicSix;
    }
}
