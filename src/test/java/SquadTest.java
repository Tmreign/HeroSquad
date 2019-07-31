import org.junit.*;
import static org.junit.Assert.*;

public class SquadTest {

    @Test
    public void squad_instantiatesWell() {
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals(true, mySquad instanceof Squad);
    }

    @Test
    public void squad_instatiatesWith_Name(){
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals("Justice league", mySquad.getName());
    }

    @Test
    public void squad_instatiatesWith_Cause(){
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals("domination", mySquad.getCause());
    }

    @Test
    public void squad_instatiatesWith_Max(){
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals(4, mySquad.getMax());
    }

    @Test
    public void all_returnsAllInstancesOfCategory_true() {
        Squad squad1 = new Squad("Justice league", "domination", 4);
        Squad squad2 = new Squad("Avengers", "Alienation", 3);
        assertEquals(true, Squad.all().contains(squad1));
        assertEquals(true, Squad.all().contains(squad2));
    }

    @Test
    public void addTask_addsTaskToList_true() {
        Squad testSquad = new Squad ("Justice league", "domination", 4);
        Hero testHero= new Hero ("Superman", "20", "Superpunch", "Kryptonite");
        testSquad.addHero(testHero);
        assertTrue(testSquad.getHeros().contains(testHero));
    }

    @Test
    public void clear_emptiesAllCategoriesFromList_0() {
        Squad mySquad= new Squad("Justice league", "domination", 4);
        Squad.clear();
        assertEquals(Squad.all().size(), 0);
    }

    @Test
    public void getId_categoriesInstantiateWithAnId_1() {
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals(1, mySquad.getId());
    }

    @Test
    public void find_returnsCategoryWithSameId_secondCategory() {
        Squad.clear();
        Squad squad1 = new Squad("Justice league", "domination", 4);
        Squad squad2 = new Squad("Avengers", "Alienation", 3);
        assertEquals(Squad.find(squad2.getId()), squad2);
    }

    @Test
    public void getTasks_initiallyReturnsEmptyList_ArrayList() {
        Squad.clear();
        Squad mySquad= new Squad("Justice league", "domination", 4);
        assertEquals(0, mySquad.getHeros().size());
    }
}