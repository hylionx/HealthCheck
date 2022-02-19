package com.example.healthcheck;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
/*
    public enum SexeEnum {
        MALE,
        FEMALE,
        OTHER
    }

    public enum AnswerEnum {
        YES,
        NO,
        DONT_KNOW
    }

    public enum mostEatenEnum {
        Commercial,
        HOME,
        TIN_CANS
    }

    public enum physicalActivityPerWeekEnum {
        NEVER,
        NOT_FOR_A_YEAR_OR_MORE,
        REGULARLY,
        SOMETIMES
    }

    public enum sportingProfileEnum {
        WATCH_TV,
        WALK,
        VIDEO_GAMES,
        SPORT
    }

    public enum weekendActivityEnum {
        NEVER,
        ONE,
        TWO,
        THREE_AND_PLUS
    }

*/



    // MAIN
    private String name;

    // MON PROFIL
    private int age;
    private int sexe;

    // MON CŒUR
    private boolean heartProblem;
    private boolean cholesterolProblem;
    private boolean diabetic;
    private boolean highBloodPressure;
    private int parentHeartProblem;
    private boolean IMC;

    // MON SUIVI CARDIAQUE
    private boolean cardiovascularRiskCheck;
    private boolean heartCheckup;
    private boolean cardiologistConsulted;

    // MON ALIMENTATION
    private boolean startDayWithBreakfast;
    private boolean fruitsAndVegetables;
    private int mostEaten;
    private boolean resaltFood ;
    private boolean coldMeats ;
    private boolean knownNutriScore;
    private boolean walkEveryDay;
    private int physicalActivityPerWeek;
    private boolean knownHeartRateLimit;
    private int sportingProfile;
    private int weekendActivity;

    // MA CONSOMMATION DE TABAC
    private boolean smokeOnceADay;
    private boolean exSmoker;
    private boolean peopleSmokeInHome;

    // MA GESTION DU STRESS
    private int feelStressedAnxious;
    private int anger;
    private boolean antidepressantsAnxiolyticsHypnotics;
    private boolean aloneFamultManage;

    // MON HYGIÈNE DE VIE
    private boolean drinkAlcohol;
    private boolean energyDrinks;
    private boolean sleep7Hours;
    private boolean sleepDisturbances;

    public Person() {

    }


    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
        sexe = in.readInt();
        heartProblem = in.readByte() != 0;
        cholesterolProblem = in.readByte() != 0;
        diabetic = in.readByte() != 0;
        highBloodPressure = in.readByte() != 0;
        parentHeartProblem = in.readInt();
        IMC = in.readByte() != 0;
        cardiovascularRiskCheck = in.readByte() != 0;
        heartCheckup = in.readByte() != 0;
        cardiologistConsulted = in.readByte() != 0;
        startDayWithBreakfast = in.readByte() != 0;
        fruitsAndVegetables = in.readByte() != 0;
        mostEaten = in.readInt();
        resaltFood = in.readByte() != 0;
        coldMeats = in.readByte() != 0;
        knownNutriScore = in.readByte() != 0;
        walkEveryDay = in.readByte() != 0;
        physicalActivityPerWeek = in.readInt();
        knownHeartRateLimit = in.readByte() != 0;
        sportingProfile = in.readInt();
        weekendActivity = in.readInt();
        smokeOnceADay = in.readByte() != 0;
        exSmoker = in.readByte() != 0;
        peopleSmokeInHome = in.readByte() != 0;
        feelStressedAnxious = in.readInt();
        anger = in.readInt();
        antidepressantsAnxiolyticsHypnotics = in.readByte() != 0;
        aloneFamultManage = in.readByte() != 0;
        drinkAlcohol = in.readByte() != 0;
        energyDrinks = in.readByte() != 0;
        sleep7Hours = in.readByte() != 0;
        sleepDisturbances = in.readByte() != 0;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public boolean isHeartProblem() {
        return heartProblem;
    }

    public boolean isCholesterolProblem() {
        return cholesterolProblem;
    }

    public boolean isDiabetic() {
        return diabetic;
    }

    public boolean isHighBloodPressure() {
        return highBloodPressure;
    }

    public int getParentHeartProblem() {
        return parentHeartProblem;
    }

    public boolean isIMC() {
        return IMC;
    }

    public boolean isCardiovascularRiskCheck() {
        return cardiovascularRiskCheck;
    }

    public boolean isHeartCheckup() {
        return heartCheckup;
    }

    public boolean isCardiologistConsulted() {
        return cardiologistConsulted;
    }

    public boolean isStartDayWithBreakfast() {
        return startDayWithBreakfast;
    }

    public boolean isFruitsAndVegetables() {
        return fruitsAndVegetables;
    }

    public int getMostEaten() {
        return mostEaten;
    }

    public boolean isResaltFood() {
        return resaltFood;
    }

    public boolean isColdMeats() {
        return coldMeats;
    }

    public boolean isKnownNutriScore() {
        return knownNutriScore;
    }

    public boolean isWalkEveryDay() {
        return walkEveryDay;
    }

    public int getPhysicalActivityPerWeek() {
        return physicalActivityPerWeek;
    }

    public boolean isKnownHeartRateLimit() {
        return knownHeartRateLimit;
    }

    public int getSportingProfile() {
        return sportingProfile;
    }

    public int getWeekendActivity() {
        return weekendActivity;
    }

    public boolean isSmokeOnceADay() {
        return smokeOnceADay;
    }

    public boolean isExSmoker() {
        return exSmoker;
    }

    public boolean isPeopleSmokeInHome() {
        return peopleSmokeInHome;
    }

    public int getFeelStressedAnxious() {
        return feelStressedAnxious;
    }

    public int getAnger() {
        return anger;
    }

    public boolean isAntidepressantsAnxiolyticsHypnotics() {
        return antidepressantsAnxiolyticsHypnotics;
    }

    public boolean isAloneFamultManage() {
        return aloneFamultManage;
    }

    public boolean isDrinkAlcohol() {
        return drinkAlcohol;
    }

    public boolean isEnergyDrinks() {
        return energyDrinks;
    }

    public boolean isSleep7Hours() {
        return sleep7Hours;
    }

    public boolean isSleepDisturbances() {
        return sleepDisturbances;
    }





    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public void setHeartProblem(boolean heartProblem) {
        this.heartProblem = heartProblem;
    }

    public void setCholesterolProblem(boolean cholesterolProblem) {
        this.cholesterolProblem = cholesterolProblem;
    }

    public void setDiabetic(boolean diabetic) {
        this.diabetic = diabetic;
    }

    public void setHighBloodPressure(boolean highBloodPressure) {
        this.highBloodPressure = highBloodPressure;
    }

    public void setParentHeartProblem(int parentHeartProblem) {
        this.parentHeartProblem = parentHeartProblem;
    }

    public void setIMC(boolean IMC) {
        this.IMC = IMC;
    }

    public void setCardiovascularRiskCheck(boolean cardiovascularRiskCheck) {
        this.cardiovascularRiskCheck = cardiovascularRiskCheck;
    }

    public void setHeartCheckup(boolean heartCheckup) {
        this.heartCheckup = heartCheckup;
    }

    public void setCardiologistConsulted(boolean cardiologistConsulted) {
        this.cardiologistConsulted = cardiologistConsulted;
    }

    public void setStartDayWithBreakfast(boolean startDayWithBreakfast) {
        this.startDayWithBreakfast = startDayWithBreakfast;
    }

    public void setFruitsAndVegetables(boolean fruitsAndVegetables) {
        this.fruitsAndVegetables = fruitsAndVegetables;
    }

    public void setMostEaten(int mostEaten) {
        this.mostEaten = mostEaten;
    }

    public void setResaltFood(boolean resaltFood) {
        this.resaltFood = resaltFood;
    }

    public void setColdMeats(boolean coldMeats) {
        this.coldMeats = coldMeats;
    }

    public void setKnownNutriScore(boolean knownNutriScore) {
        this.knownNutriScore = knownNutriScore;
    }

    public void setWalkEveryDay(boolean walkEveryDay) {
        this.walkEveryDay = walkEveryDay;
    }

    public void setPhysicalActivityPerWeek(int physicalActivityPerWeek) {
        this.physicalActivityPerWeek = physicalActivityPerWeek;
    }

    public void setKnownHeartRateLimit(boolean knownHeartRateLimit) {
        this.knownHeartRateLimit = knownHeartRateLimit;
    }

    public void setSportingProfile(int sportingProfile) {
        this.sportingProfile = sportingProfile;
    }

    public void setWeekendActivity(int weekendActivity) {
        this.weekendActivity = weekendActivity;
    }

    public void setSmokeOnceADay(boolean smokeOnceADay) {
        this.smokeOnceADay = smokeOnceADay;
    }

    public void setExSmoker(boolean exSmoker) {
        this.exSmoker = exSmoker;
    }

    public void setPeopleSmokeInHome(boolean peopleSmokeInHome) {
        this.peopleSmokeInHome = peopleSmokeInHome;
    }

    public void setFeelStressedAnxious(int feelStressedAnxious) {
        this.feelStressedAnxious = feelStressedAnxious;
    }

    public void setAnger(int anger) {
        this.anger = anger;
    }

    public void setAntidepressantsAnxiolyticsHypnotics(boolean antidepressantsAnxiolyticsHypnotics) {
        this.antidepressantsAnxiolyticsHypnotics = antidepressantsAnxiolyticsHypnotics;
    }

    public void setAloneFamultManage(boolean aloneFamultManage) {
        this.aloneFamultManage = aloneFamultManage;
    }

    public void setDrinkAlcohol(boolean drinkAlcohol) {
        this.drinkAlcohol = drinkAlcohol;
    }

    public void setEnergyDrinks(boolean energyDrinks) {
        this.energyDrinks = energyDrinks;
    }

    public void setSleep7Hours(boolean sleep7Hours) {
        this.sleep7Hours = sleep7Hours;
    }

    public void setSleepDisturbances(boolean sleepDisturbances) {
        this.sleepDisturbances = sleepDisturbances;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(age);
        parcel.writeInt(sexe);
        parcel.writeByte((byte) (heartProblem ? 1 : 0));
        parcel.writeByte((byte) (cholesterolProblem ? 1 : 0));
        parcel.writeByte((byte) (diabetic ? 1 : 0));
        parcel.writeByte((byte) (highBloodPressure ? 1 : 0));
        parcel.writeInt(parentHeartProblem);
        parcel.writeByte((byte) (IMC ? 1 : 0));
        parcel.writeByte((byte) (cardiovascularRiskCheck ? 1 : 0));
        parcel.writeByte((byte) (heartCheckup ? 1 : 0));
        parcel.writeByte((byte) (cardiologistConsulted ? 1 : 0));
        parcel.writeByte((byte) (startDayWithBreakfast ? 1 : 0));
        parcel.writeByte((byte) (fruitsAndVegetables ? 1 : 0));
        parcel.writeInt(mostEaten);
        parcel.writeByte((byte) (resaltFood ? 1 : 0));
        parcel.writeByte((byte) (coldMeats ? 1 : 0));
        parcel.writeByte((byte) (knownNutriScore ? 1 : 0));
        parcel.writeByte((byte) (walkEveryDay ? 1 : 0));
        parcel.writeInt(physicalActivityPerWeek);
        parcel.writeByte((byte) (knownHeartRateLimit ? 1 : 0));
        parcel.writeInt(sportingProfile);
        parcel.writeInt(weekendActivity);
        parcel.writeByte((byte) (smokeOnceADay ? 1 : 0));
        parcel.writeByte((byte) (exSmoker ? 1 : 0));
        parcel.writeByte((byte) (peopleSmokeInHome ? 1 : 0));
        parcel.writeInt(feelStressedAnxious);
        parcel.writeInt(anger);
        parcel.writeByte((byte) (antidepressantsAnxiolyticsHypnotics ? 1 : 0));
        parcel.writeByte((byte) (aloneFamultManage ? 1 : 0));
        parcel.writeByte((byte) (drinkAlcohol ? 1 : 0));
        parcel.writeByte((byte) (energyDrinks ? 1 : 0));
        parcel.writeByte((byte) (sleep7Hours ? 1 : 0));
        parcel.writeByte((byte) (sleepDisturbances ? 1 : 0));
    }
}
