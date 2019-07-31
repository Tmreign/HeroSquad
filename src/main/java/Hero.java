import java.util.ArrayList;
import java.util.List;

public class Hero {
    private String mName;
    private String mAge;
    private String mSuperpower;
    private String mWeakness;
    private static List<Hero> instances = new ArrayList<Hero>();
    private int mId;

    public Hero(String name, String age, String superpower, String weakness){
        mName = name;
        mAge = age;
        mSuperpower =superpower;
        mWeakness = weakness;
        instances.add(this);
        mId = instances.size();
    }

    public static void clear() {
        instances.clear();
    }

    public static Hero find(int id) {
        return instances.get(id - 1);
    }

    public String getName(){
        return mName;
    }
    public String getAge(){return mAge;}
    public String getSuperpower(){ return mSuperpower;}
    public String getWeakness(){return mWeakness;}
    public static List<Hero> all() {return instances; }
    public int getId() { return mId; }
}
