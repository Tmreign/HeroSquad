import org.junit.*;
import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void Hero_Instatiates_Well(){
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals(true, myHero instanceof Hero);
    }

    @Test
    public void  Hero_Instatiates_withName(){
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals("Superman", myHero.getName());
    }


    @Test
    public void  Hero_Instatiates_withAge(){
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals("20", myHero.getAge());
    }

    @Test
    public void  Hero_Instatiates_withSuperpower(){
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals("Superpunch", myHero.getSuperpower());
    }

    @Test
    public void  Hero_Instatiates_withWeakness(){
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals("Kryptonite", myHero.getWeakness());
    }

    @Test
    public void clear_emptiesAllTasksFromArrayList_0() {
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        Hero.clear();
        assertEquals(Hero.all().size(), 0);
    }

    @Test
    public void getId_tasksInstantiateWithAnID_1() {
        Hero.clear();
        Hero myHero = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        assertEquals(1, myHero.getId());
    }

    @Test
    public void find_returnsTaskWithSameId_secondTask() {
        Hero hero1 = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        Hero hero2 = new Hero ("Batman", "25", "BatMobile", "catwoman");
        assertEquals(Hero.find(hero2.getId()), hero2);
    }

    @Test
    public void all_returnsAllInstances_ofHer0() {
        Hero hero1 = new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        Hero hero2 = new Hero ("Batman", "25", "BatMobile", "catwoman");
        assertEquals(true, Hero.all().contains(hero1));
        assertEquals(true, Hero.all().contains(hero2));
    }
}