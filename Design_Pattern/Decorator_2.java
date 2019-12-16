//
//  裝飾模式(低耦合版本)
//
// https://ithelp.ithome.com.tw/articles/10203738

public class Order(){

    public void show(){

    }
}

//繼承 order
public class Item extends Order {
    protected Order order;

    public void decorate(Order order){
        this.order = order;
    }

    @Override
    public void show() {
        if(order!= null)
            order.show();
    }
}

public class Drink extends Item {

    private void addDrink(){
        System.out.println("一份飲料");
    }

    @Override
    public void show() {
        super.show();
        addDrink();
    }
}

public class MainMeal extends Item {

    private void addMeal(){
        System.out.println("加一份主餐");
    }

    @Override
    public void show() {
        super.show();
        addMeal();
    }
}

public class Salad extends Item {

    private void addSalad(){
        System.out.println("一份沙拉");
    }

    @Override
    public void show() {
        super.show();
        addSalad();
    }
}

public class Soup extends Item {

    private void addSoup(){
        System.out.println("加一份湯品");
    }

    @Override
    public void show() {
        super.show();
        addSoup();
    }
}

public class Test {
    
    public void test(){
        Order order = new Order();

        Drink drink = new Drink();
        MainMeal mainMeal = new MainMeal();
        Soup soup = new Soup();

        drink.decorate(order);
        mainMeal.decorate(drink);
        soup.decorate(mainMeal);

        soup.show();

    }
}

public class Set extends Order {

    protected Order order;
    
    public void decorate(Order order){
        this.order = order;
    }

    @Override
    public void show() {
        if(order!= null)
            order.show();
    }
}

public class SimpleSet extends Set {

    private void addSet(){
        Salad salad = new Salad();
        MainMeal mainMeal = new MainMeal();
        Drink drink = new Drink();
        salad.decorate(order);
        mainMeal.decorate(salad);
        drink.decorate(mainMeal);
        this.order = drink;
    }

    @Override
    public void show() {
        addSet();
        super.show();
    }
}

public class Test {
    
    public void test(){

        SimpleSet simpleSet = new SimpleSet();
        simpleSet.show();
    }
}
