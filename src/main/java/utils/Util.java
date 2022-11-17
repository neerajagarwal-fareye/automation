package utils;

public class Util {

    public static void pauseExecutionForSeconds(int seconds){
        try{
            Thread.sleep(seconds*1000);

        }catch (Exception e){

        }
    }

}
