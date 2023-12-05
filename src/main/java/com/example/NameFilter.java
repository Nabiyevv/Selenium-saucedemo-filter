package com.example;

import java.util.List;
import org.openqa.selenium.WebDriver;

import com.example.Helper.ProductHelper;

public class NameFilter {
    public void filterByName(WebDriver driver) {

        ProductHelper productHelper = new ProductHelper();
        
        List<String> productNamesAz = productHelper.getProductNames(driver, "az");

        if(sortProductsByName(productNamesAz,"asc"))
            System.out.println("A to Z filter is working");
        else
            System.out.println("A to Z filter is not working!");



        List<String> productNamesZa = productHelper.getProductNames(driver, "za");

        if(sortProductsByName(productNamesZa,"desc"))
            System.out.println("Z to A filter is working");
        else
            System.out.println("Z to A filter is not working!");

    }

    private boolean sortProductsByName(List<String> productNames,String type)
    {
        for(int i = 0; i < productNames.size() - 1; i++)
        {
            if(type.equals("asc"))
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
