package fr.teiki.linqboardgame;

/**
 * Created by antoine on 07/03/2016.
 */
public class Words {

    private static String[] words = {"Encre","Coude","Element"};

    public static String getAWord(){
        return words[(int)(Math.random()*words.length)];
    }

}
