package fr.teiki.linqboardgame;

/**
 * Created by antoine on 07/03/2016.
 */
public class Player {

    private String name;
    private Boolean spy;

    public Player(String name, Boolean spy) {
        this.name = name;
        this.spy = spy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isASpy() {
        return spy;
    }

    public void setSpy(Boolean spy) {
        this.spy = spy;
    }

    @Override
    public String toString() {
        if (spy){
            return "Tu es un espion, mémorise bien le mot";
        }
        else{
            return "Tu es un contre-espion, bonne chance!";
        }
    }
}
