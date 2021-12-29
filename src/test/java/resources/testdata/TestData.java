package resources.testdata;

import org.testng.annotations.DataProvider;

public class TestData {

//    @DataProvider(name= "credentials")
//    public Object[] getData(){
//        String[][] data = new String[][]{
//                {"", "123456", "An email address required."},
//                {"abcd@gmail.com", "", "Password is required."},
//                {"adfdfgfg", "123456", "Invalid email address."},
//                {"abcd@gmail.com", "123456", "Authentication failed."}
//        };
//        return data;
//    }

    @DataProvider(name = "product")
    public Object[][] getProductData(){
        String[][] data = new String[][]{
                {"Blouse", "2", "M", "White"},
//                {"Faded Short Sleeve T-shirts", "2", "M", "Blue"},
//                {"Printed Dress", "3", "L", "Orange"},
//                {"Printed Chiffon Dress", "4", "S", "Green"},
//                {"Printed Summer Dress with Price $28.98", "2", "M", "Blue"},
        };
        return data;
    }
}
