package com.example;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.example.Helper.ProductHelper;

public class PriceFilter
{
    public void filterByprice(WebDriver driver) {

        ProductHelper productHelper = new ProductHelper();
        
        List<Double> productPricesLth = productHelper.getProductPrices(driver, "lohi");

        if(sortProductsByPrice(productPricesLth,"lohi"))
            System.out.println("Low to high price filter is working");
        else
            System.out.println("Low to high price filter is not working!");

            
        List<Double> productPricesHtl = productHelper.getProductPrices(driver, "hilo");

        if(sortProductsByPrice(productPricesHtl,"hilo"))
            System.out.println("High to low price filter is working");
        else
            System.out.println("High to low price filter is not working!");

    }

    private boolean sortProductsByPrice(List<Double> productNames,String type)
    {
        for(int i = 0; i < productNames.size() - 1; i++)
        {
            if(type.equals("lohi"))
            {
                if(productNames.get(i).compareTo(productNames.get(i + 1)) > 0)
                    return false;
            }
            else
            {
                if(productNames.get(i).compareTo(productNames.get(i + 1)) < 0)
                    return false;
            }
        }
        
        return true;
    }
}
