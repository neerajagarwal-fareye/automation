package TestCases;

import utils.Constants;

import java.io.File;

public class TestingOfCode {

    public static void main(String...s){

        String path = System.getProperty("user.dir")+ File.separator+"resources"+File.separator+"drivers"+File.separator+"chromedriver";
        System.out.println(Constants.url);

    }
}
