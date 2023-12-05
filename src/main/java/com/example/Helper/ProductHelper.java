package com.example.Helper;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductHelper {
    public List<String> getProductNames(WebDriver driver, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.cssSelector(".product_sort_container[data-test='product_sort_container']"))));
        Select dropdown = new Select(
                driver.findElement(By.cssSelector(".product_sort_container[data-test='product_sort_container']")));
        dropdown.selectByValue(value);

        List<WebElement> products = driver.findElements(By.cssSelector("#inventory_container .inventory_item"));

        List<String> productNames = new ArrayList<String>();

        for (WebElement product : products) {

            String name = product.findElement(By.cssSelector(".inventory_item_name")).getText();
            productNames.add(name);

        }
        return productNames;
    }

    public List<Double> getProductPrices(WebDriver driver, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        wait.until(ExpectedConditions.visibilityOfAllElements(
                driver.findElement(By.cssSelector(".product_sort_container[data-test='product_sort_container']"))));
        Select dropdown = new Select(
                driver.findElement(By.cssSelector(".product_sort_container[data-test='product_sort_container']")));
        dropdown.selectByValue(value);

        List<WebElement> products = driver.findElements(By.cssSelector("#inventory_container .inventory_item"));

        List<Double> productPrices = new ArrayList<Double>();

        for (WebElement product : products) {

            Double price = Double.parseDouble(
                    product.findElement(By.cssSelector(".inventory_item_price")).getText().replace("$", ""));
            productPrices.add(price);

        }
        return productPrices;
    }

}
