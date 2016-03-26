package classes;

public class Factory {

    public static Game getInstance(Class<Game> c, Boolean b){
        return new GameImpl(b);
    }
}
