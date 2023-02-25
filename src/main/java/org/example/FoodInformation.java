package org.example;

public class FoodInformation {

    private String name;
    private int calories;
    private String totalFat;
    private String saturatedFat;
    private String transFat;
    private String cholesterol;
    private String sodium;
    private String totalCarbohydrate;
    private String dietaryFiber;
    private String totalSugars;
    private String protein;

    public FoodInformation(String name, int calories, String totalFat, String saturatedFat, String transFat, String cholesterol, String sodium, String totalCarbohydrate, String dietaryFiber, String totalSugars, String protein) {
        this.name = name;
        this.calories = calories;
        this.totalFat = totalFat;
        this.saturatedFat = saturatedFat;
        this.transFat = transFat;
        this.cholesterol = cholesterol;
        this.sodium = sodium;
        this.totalCarbohydrate = totalCarbohydrate;
        this.dietaryFiber = dietaryFiber;
        this.totalSugars = totalSugars;
        this.protein = protein;
    }

    @Override
    public String toString() {
        return "FoodInformation{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                ", totalFat='" + totalFat + '\'' +
                ", saturatedFat='" + saturatedFat + '\'' +
                ", transFat='" + transFat + '\'' +
                ", cholesterol='" + cholesterol + '\'' +
                ", sodium='" + sodium + '\'' +
                ", totalCarbohydrate='" + totalCarbohydrate + '\'' +
                ", dietaryFiber='" + dietaryFiber + '\'' +
                ", totalSugars='" + totalSugars + '\'' +
                ", protein='" + protein + '\'' +
                '}';
    }

    public FoodInformation(String name){
        this.name=name;
    }

    public boolean parseLineAndSet(String param){
        if(param.toLowerCase().contains("total fat")){
            this.totalFat = param;
            return true;
        }
        if(param.toLowerCase().contains("saturated fat")){
            this.saturatedFat = param;
            return true;
        }
        if(param.toLowerCase().contains("trans fat")){
            this.transFat = param;
            return true;
        }
        if(param.toLowerCase().contains("cholesterol")){
            this.cholesterol = param;
            return true;
        }
        if(param.toLowerCase().contains("sodium")){
            this.sodium = param;
            return true;
        }
        if(param.toLowerCase().contains("total carbohydrate")){
            this.totalCarbohydrate = param;
            return true;
        }
        if(param.toLowerCase().contains("dietary fiber")){
            this.dietaryFiber = param;
            return true;
        }
        if(param.toLowerCase().contains("total sugars")){
            this.totalSugars = param;
            return true;
        }
        if(param.toLowerCase().contains("protein")){
            this.protein = param;
            return true;
        }

        return false;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public String getTotalFat() {
        return totalFat;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public String getTransFat() {
        return transFat;
    }

    public String getCholesterol() {
        return cholesterol;
    }

    public String getSodium() {
        return sodium;
    }

    public String getTotalCarbohydrate() {
        return totalCarbohydrate;
    }

    public String getDietaryFiber() {
        return dietaryFiber;
    }

    public String getTotalSugars() {
        return totalSugars;
    }

    public String getProtein() {
        return protein;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public void setTotalFat(String totalFat) {
        this.totalFat = totalFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public void setTransFat(String transFat) {
        this.transFat = transFat;
    }

    public void setCholesterol(String cholesterol) {
        this.cholesterol = cholesterol;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public void setTotalCarbohydrate(String totalCarbohydrate) {
        this.totalCarbohydrate = totalCarbohydrate;
    }

    public void setDietaryFiber(String dietaryFiber) {
        this.dietaryFiber = dietaryFiber;
    }

    public void setTotalSugars(String totalSugars) {
        this.totalSugars = totalSugars;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }
}
