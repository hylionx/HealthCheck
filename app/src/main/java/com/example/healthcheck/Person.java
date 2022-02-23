package com.example.healthcheck;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    // MAIN
    private String name;

    // MON PROFIL
    private int age;
    private int sexe;

    // MON CŒUR
    private String heartProblem;
    private String cholesterolProblem;
    private String diabetic;
    private String highBloodPressure;
    private String parentHeartProblem;
    private String IMC;
    private int pos;

    // MON SUIVI CARDIAQUE
    private boolean cardiovascularRiskCheck;
    private boolean heartCheckup;
    private boolean cardiologistConsulted;
    private String val;

    // MON ALIMENTATION
    private int startDayWithBreakfast;
    private int fruitsAndVegetables;
    private int mostEaten;
    private int resaltFood ;
    private int coldMeats ;
    private int knownNutriScore;
    private int walkEveryDay;
    private int physicalActivityPerWeek;
    private int knownHeartRateLimit;
    private int sportingProfile;
    private int weekendActivity;

    // MA CONSOMMATION DE TABAC
    private int smokeOnceADay;
    private int exSmoker;
    private int peopleSmokeInHome;

    // MA GESTION DU STRESS
    private int feelStressedAnxious;
    private int anger;
    private int antidepressantsAnxiolyticsHypnotics;
    private int aloneFamultManage;

    // MON HYGIÈNE DE VIE
    private int drinkAlcohol;
    private int energyDrinks;
    private int sleep7Hours;
    private int sleepDisturbances;

    public Person() {

    }


    protected Person(Parcel in) {
        name = in.readString();
        age = in.readInt();
        sexe = in.readInt();
        heartProblem = in.readString();
        cholesterolProblem = in.readString();
        diabetic = in.readString();
        highBloodPressure = in.readString();
        parentHeartProblem = in.readString();
        IMC = in.readString();
        cardiovascularRiskCheck = in.readByte() != 0;
        heartCheckup = in.readByte() != 0;
        cardiologistConsulted = in.readByte() != 0;
        startDayWithBreakfast = in.readInt();
        fruitsAndVegetables = in.readInt();
        mostEaten = in.readInt();
        resaltFood = in.readInt();
        coldMeats = in.readInt();
        knownNutriScore = in.readInt();
        walkEveryDay = in.readInt();
        physicalActivityPerWeek = in.readInt();
        knownHeartRateLimit = in.readInt();
        sportingProfile = in.readInt();
        weekendActivity = in.readInt();
        smokeOnceADay = in.readInt();
        exSmoker = in.readInt();
        peopleSmokeInHome = in.readInt();
        feelStressedAnxious = in.readInt();
        anger = in.readInt();
        antidepressantsAnxiolyticsHypnotics = in.readInt();
        aloneFamultManage = in.readInt();
        drinkAlcohol = in.readInt();
        energyDrinks = in.readInt();
        sleep7Hours = in.readInt();
        sleepDisturbances = in.readInt();
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

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSexe() {
        return sexe;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }

    public String getHeartProblem() {
        return heartProblem;
    }

    public void setHeartProblem(String heartProblem, int pos) {
        this.heartProblem = heartProblem;
        this.pos = pos;
    }

    public String getCholesterolProblem() {
        return cholesterolProblem;
    }

    public void setCholesterolProblem(String cholesterolProblem, int pos) {
        this.cholesterolProblem = cholesterolProblem;
    }

    public String getDiabetic() {
        return diabetic;
    }

    public void setDiabetic(String diabetic, int pos) {
        this.diabetic = diabetic;
    }

    public String getHighBloodPressure() {
        return highBloodPressure;
    }

    public void setHighBloodPressure(String highBloodPressure, int pos) {
        this.highBloodPressure = highBloodPressure;
    }

    public String getParentHeartProblem() {
        return parentHeartProblem;
    }

    public void setParentHeartProblem(String parentHeartProblem) {
        this.parentHeartProblem = parentHeartProblem;
    }

    public String getIMC() {
        return IMC;
    }

    public void setIMC(String IMC, int pos) {
        this.IMC = IMC;
    }

    public boolean getCardiovascularRiskCheck() {
        return cardiovascularRiskCheck;
    }

    public void setCardiovascularRiskCheck(boolean cardiovascularRiskCheck, String val) {
        this.cardiovascularRiskCheck = cardiovascularRiskCheck;
    }

    public boolean getHeartCheckup() {
        return heartCheckup;
    }

    public void setHeartCheckup(boolean heartCheckup, String val) {
        this.heartCheckup = heartCheckup;
    }

    public boolean getCardiologistConsulted() {
        return  cardiologistConsulted;
    }

    public void setCardiologistConsulted(boolean cardiologistConsulted, String val) {
        this.cardiologistConsulted = cardiologistConsulted;
    }

    public int getStartDayWithBreakfast() {
        return startDayWithBreakfast;
    }

    public void setStartDayWithBreakfast(int startDayWithBreakfast) {
        this.startDayWithBreakfast = startDayWithBreakfast;
    }

    public int getFruitsAndVegetables() {
        return fruitsAndVegetables;
    }

    public void setFruitsAndVegetables(int fruitsAndVegetables) {
        this.fruitsAndVegetables = fruitsAndVegetables;
    }

    public int getMostEaten() {
        return mostEaten;
    }

    public void setMostEaten(int mostEaten) {
        this.mostEaten = mostEaten;
    }

    public int getResaltFood() {
        return resaltFood;
    }

    public void setResaltFood(int resaltFood) {
        this.resaltFood = resaltFood;
    }

    public int getColdMeats() {
        return coldMeats;
    }

    public void setColdMeats(int coldMeats) {
        this.coldMeats = coldMeats;
    }

    public int getKnownNutriScore() {
        return knownNutriScore;
    }

    public void setKnownNutriScore(int knownNutriScore) {
        this.knownNutriScore = knownNutriScore;
    }

    public int getWalkEveryDay() {
        return walkEveryDay;
    }

    public void setWalkEveryDay(int walkEveryDay) {
        this.walkEveryDay = walkEveryDay;
    }

    public int getPhysicalActivityPerWeek() {
        return physicalActivityPerWeek;
    }

    public void setPhysicalActivityPerWeek(int physicalActivityPerWeek) {
        this.physicalActivityPerWeek = physicalActivityPerWeek;
    }

    public int getKnownHeartRateLimit() {
        return knownHeartRateLimit;
    }

    public void setKnownHeartRateLimit(int knownHeartRateLimit) {
        this.knownHeartRateLimit = knownHeartRateLimit;
    }

    public int getSportingProfile() {
        return sportingProfile;
    }

    public void setSportingProfile(int sportingProfile) {
        this.sportingProfile = sportingProfile;
    }

    public int getWeekendActivity() {
        return weekendActivity;
    }

    public void setWeekendActivity(int weekendActivity) {
        this.weekendActivity = weekendActivity;
    }

    public int getSmokeOnceADay() {
        return smokeOnceADay;
    }

    public void setSmokeOnceADay(int smokeOnceADay) {
        this.smokeOnceADay = smokeOnceADay;
    }

    public int getExSmoker() {
        return exSmoker;
    }

    public void setExSmoker(int exSmoker) {
        this.exSmoker = exSmoker;
    }

    public int getPeopleSmokeInHome() {
        return peopleSmokeInHome;
    }

    public void setPeopleSmokeInHome(int peopleSmokeInHome) {
        this.peopleSmokeInHome = peopleSmokeInHome;
    }

    public int getFeelStressedAnxious() {
        return feelStressedAnxious;
    }

    public void setFeelStressedAnxious(int feelStressedAnxious) {
        this.feelStressedAnxious = feelStressedAnxious;
    }

    public int getAnger() {
        return anger;
    }

    public void setAnger(int anger) {
        this.anger = anger;
    }

    public int getAntidepressantsAnxiolyticsHypnotics() {
        return antidepressantsAnxiolyticsHypnotics;
    }

    public void setAntidepressantsAnxiolyticsHypnotics(int antidepressantsAnxiolyticsHypnotics) {
        this.antidepressantsAnxiolyticsHypnotics = antidepressantsAnxiolyticsHypnotics;
    }

    public int getAloneFamultManage() {
        return aloneFamultManage;
    }

    public void setAloneFamultManage(int aloneFamultManage) {
        this.aloneFamultManage = aloneFamultManage;
    }

    public int getDrinkAlcohol() {
        return drinkAlcohol;
    }

    public void setDrinkAlcohol(int drinkAlcohol) {
        this.drinkAlcohol = drinkAlcohol;
    }

    public int getEnergyDrinks() {
        return energyDrinks;
    }

    public void setEnergyDrinks(int energyDrinks) {
        this.energyDrinks = energyDrinks;
    }

    public int getSleep7Hours() {
        return sleep7Hours;
    }

    public void setSleep7Hours(int sleep7Hours) {
        this.sleep7Hours = sleep7Hours;
    }

    public int getSleepDisturbances() {
        return sleepDisturbances;
    }

    public void setSleepDisturbances(int sleepDisturbances) {
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
        parcel.writeString(heartProblem);
        parcel.writeString(cholesterolProblem);
        parcel.writeString(diabetic);
        parcel.writeString(highBloodPressure);
        parcel.writeString(parentHeartProblem);
        parcel.writeString(IMC);
        parcel.writeByte((byte) (cardiovascularRiskCheck ? 1 : 0));
        parcel.writeByte((byte) (heartCheckup ? 1 : 0));
        parcel.writeByte((byte) (cardiologistConsulted ? 1 : 0));
        parcel.writeInt(startDayWithBreakfast);
        parcel.writeInt(fruitsAndVegetables);
        parcel.writeInt(mostEaten);
        parcel.writeInt(resaltFood);
        parcel.writeInt(coldMeats);
        parcel.writeInt(knownNutriScore);
        parcel.writeInt(walkEveryDay);
        parcel.writeInt(physicalActivityPerWeek);
        parcel.writeInt(knownHeartRateLimit);
        parcel.writeInt(sportingProfile);
        parcel.writeInt(weekendActivity);
        parcel.writeInt(smokeOnceADay);
        parcel.writeInt(exSmoker);
        parcel.writeInt(peopleSmokeInHome);
        parcel.writeInt(feelStressedAnxious);
        parcel.writeInt(anger);
        parcel.writeInt(antidepressantsAnxiolyticsHypnotics);
        parcel.writeInt(aloneFamultManage);
        parcel.writeInt(drinkAlcohol);
        parcel.writeInt(energyDrinks);
        parcel.writeInt(sleep7Hours);
        parcel.writeInt(sleepDisturbances);
    }
}
