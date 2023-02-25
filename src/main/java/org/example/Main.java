package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.rit.edu/fa/diningservices/netnutrition/1");

        //select date=today
//        WebElement dateElement = (WebElement) driver.findElements(By.className("navigation__text--ellipses"))
//                .stream().filter(i->(i.getText().equals("Show All Dates")));
//
//        WebElement today = (WebElement) dateElement.findElements(By.className("dropdown-item"))
//                .stream().filter(i->(i.getText().equals("Today")));
//        //select date as today
//        today.click();

//        gets all the elements containing the names of the dining locations
        List<WebElement> diningFacilities = driver.findElements(By.className("unit__name-link"));

        String selectedFacility = DiningLocations.ARTESANO.getName();
//        System.out.println(diningFacilities.get(0).getText());

        WebElement selectedDiningFacility = diningFacilities.stream().
                filter(i->(i.getText().contains(selectedFacility))).findFirst().orElseThrow();

        selectedDiningFacility.click();

        //TODO maybe make it pick the correct day, for now just choosing the first day

        Thread.sleep(1000);
        WebElement menuLink = driver.findElement(By.className("cbo_nn_menuLink"));
        menuLink.click();//open the daily menu for the dining location

        //now go through and get data from each section of the menu

        //grab all food subcategories
        Thread.sleep(1000);
        List<WebElement> subFoodCategories = driver.findElements(By.cssSelector("[role=\"treeitem\"]"));
        //list to hold all the FoodInformation objects
        List<FoodInformation> foods = new ArrayList<>();

        for(WebElement curElement: subFoodCategories){
            Thread.sleep(500);
            curElement.click();
        }

        Thread.sleep(1000);
        List<WebElement> subCategoryFoodOptions = driver.findElements(By.className("cbo_nn_itemHover"));


        for(WebElement curFood: subCategoryFoodOptions){
            Thread.sleep(1000);

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", curFood);

            //create the list of elements that contain each line of nutritional information
            Thread.sleep(1000);
            List<WebElement> nutritionLines = driver.findElements(By.className("cbo_nn_LabelBorderedSubHeader"));

            String name = driver.findElement(By.className("cbo_nn_LabelHeader")).getText();
            int calories = Integer.parseInt(driver.findElement(By.xpath("//*[@id=\"nutritionLabel\"]/div/div/table/tbody/tr[4]/td/div[2]")).getText());

            //create the food information object and add in the name/calories
            FoodInformation currentFoodInformation = new FoodInformation(name);
            currentFoodInformation.setCalories(calories);

            for(WebElement curNutritionLine: nutritionLines){
                boolean response = currentFoodInformation.parseLineAndSet(curNutritionLine.getText());
                if(!response)
                    System.out.println("FUCK SHIT FUCK SHIT FUCK SHIT");
            }

            System.out.println(currentFoodInformation);
            //add to the overall foods list
            foods.add(currentFoodInformation);

            //close the popup
            WebElement exitButton = driver.findElement(By.xpath("//*[@id=\"btn_nn_nutrition_close\"]/span"));
            exitButton.click();
        }

        //for finding each line in the nutrition info
        //cbo_nn_LabelBorderedSubHeader

        driver.quit();

    }
}