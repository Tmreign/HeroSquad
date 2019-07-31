import java.util.ArrayList;
import java.util.List;

public class Squad {
     private String mName;
     private String mCause;
     private String mMax;
     private static List<Squad> instances = new ArrayList<Squad>();
     private List<Hero> mHeros;
     private int mId;

    public Squad(String name, String cause, String max) {
        mName = name;
        mCause = cause;
        mMax = max;
        instances.add(this);
        mHeros = new ArrayList<Hero>();
        mId = instances.size();
    }

    public static boolean heroAlreadyExists(Hero newHero) {
        boolean exists = false;
        for(Squad squad: instances){
            for(Hero hero: squad.getHeros()){
                if (hero.getName().equals(newHero.getName())) {
                    exists = true;
                }
            }
        }
        return exists;
    }

    public static void clear() {
        instances.clear();
    }

    public static Squad find(int id) { return instances.get(id - 1); }
    public void addHero(Hero hero) {
        mHeros.add(hero);
    }
    public String getName(){ return mName;}
    public String getCause(){return  mCause;}
    public String getMax(){return  mMax;}
    public static List<Squad> all() {return instances; }
    public List<Hero> getHeros() { return mHeros; }
    public int getId() { return mId; }
}
