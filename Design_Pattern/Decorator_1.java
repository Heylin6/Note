//
//  裝飾模式(原版)
//
//
//
// https://ithelp.ithome.com.tw/articles/10203738

public class Restaurant {
    
    //低蕭
    private void minimumOrder() {
        System.out.println("一杯紅茶");
    }

    public void Order(){
        minimumOrder();
    }

}

//商業午餐
public class BusinessLunch extends Restaurant {

    private Restaurant restaurant;

    private BusinessLunch(Restaurant restaurant){
        this.restaurant = restaurant;
    }

    private void salad(){
        System.out.println("一份沙拉");
    }

    private void mainMeal(){
        System.out.println("一份正餐");
    }

    @Override
    public void order() {
        super.order();
        salad();
        mainMeal();
    }
}

//簡餐(繼承商業午餐)
public class SimpleCombo extends BusinessLunch {

    public SimpleCombo(Restaurant restaurant) {
        super(restaurant);
    }

    private void soup(){
        System.out.println("一份湯品");
    }

    @Override
    public void order() {
        super.order();
        soup();
    }
}

//全餐(繼承簡餐)
public class FullCombo extends SimpleCombo {

    public FullCombo(Restaurant restaurant) {
        super(restaurant);
    }

    private void sweet(){
        System.out.println("一份甜點");
    }

    @Override
    public void order() {
        super.order();
        sweet();
    }
}

public void test(){

    Restaurant restaurant = new Restaurant();

    SimpleCombo simpleCombo = new SimpleCombo(restaurant);

    System.out.println("簡餐：");
    simpleCombo.order();

    BusinessLunch businessLunch = new BusinessLunch(restaurant);
    System.out.println("商業午餐：");
    businessLunch.order();

    FullCombo fullCombo = new FullCombo(restaurant);
    System.out.println("全餐：");
    fullCombo.order();


}