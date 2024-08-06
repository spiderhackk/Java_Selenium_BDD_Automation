package org.example;

public class Locators {
    public static final  String ListOfHeaderName = "//div[@class='rt-table']/div[@class='rt-thead -header']/div/div";
    public static final  String inputSearchBox = "//input[@id='searchBox']";
    public static final  String  searchButton ="//span[@id='basic-addon2']";
    public static final  String  resultList = "//div[@class='rt-tr-group']//a";
    public static final String  tableData ="//div[@class='rt-table']";
    public static final String  getBookName ="(//div[@class='rt-tr-group']//a)['%s']";




    public static String getFormatXpathElement(String element, int index){
        return String.format(element,index);

    }
}
