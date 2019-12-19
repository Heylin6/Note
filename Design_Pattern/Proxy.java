//
//  代理模式
//
//  為其他物件提供一種代理以控制對這個物件的存取(又稱 委任模式)
//
//  如同 代理上網 律師代打官司 房仲代銷
//
// https://ithelp.ithome.com.tw/articles/10205659


//以買房子為例 介面
public interface IBuyHouse {
    
    //找房子
    public vuid findHouse();

    //砍價
    public vuid priceTooHigh();

    //防砍價
    public vuid defendPrice();

    //成交
    public vuid finish();
}

//實際買房子的是我們
public class LittleEngineer implements IBuyHouse{

    @Override
    public void findHouse() {

        //小小工程師想找在民生社區的房子
        System.out.println("民生社區機能特好！當然找那邊的房子！");
    }

    @Override
    public void priceTooHigh() {

        //價錢實在太貴
        System.out.println("現在台灣薪水那麼低，屋主開那麼高賣不掉啦！");
    }

    @Override
    public void defendPrice() {

        //屋主反擊說價錢已經很便宜
        System.out.println("未來人口越來越少，我們也是自住而已！打我五折吧！");
    }

    @Override
    public void finish() {

        //沒想到屋主同意買到了
        System.out.println("辛苦還房貸幾十年");
    }
}

//幫忙代理的房仲從中協調
public class EstateAgent implements IBuyHouse {

    private IBuyHouse iBuyHouse;

    public EstateAgent(IBuyHouse iBuyHouse){

        this.iBuyHouse = iBuyHouse;
    }

    @Override
    public void findHouse() {

        iBuyHouse.findHouse();
        System.out.println("#房仲幫忙找房子");
    }

    @Override
    public void priceTooHigh() {

        iBuyHouse.priceTooHigh();
        System.out.println("#房仲幫忙喬價錢");
    }

    @Override
    public void defendPrice() {

        iBuyHouse.defendPrice();
        System.out.println("#房仲強力喬價錢");
    }

    @Override
    public void finish() {

        System.out.println("#成交的話房仲幫忙付訂、簽約、用印、完稅、交屋");
        iBuyHouse.finish();
    }
}

//Client使用方式 (Test)
public class Test {
    
    public void test(){

        IBuyHouse littleEngineer = new LittleEngineer();
        IBuyHouse estateAgent = new EstateAgent(littleEngineer);

        estateAgent.findHouse();
        estateAgent.priceTooHigh();
        estateAgent.defendPrice();
        estateAgent.finish();

    }
}

// 民生社區機能特好！當然找那邊的房子！
// #房仲幫忙找房子
// 現在台灣薪水那麼低，屋主開那麼高賣不掉啦！
// #房仲幫忙喬價錢
// 未來人口越來越少，我們也是自住而已！打我五折吧！
// #房仲強力喬價錢
// #成交的話房仲幫忙付訂、簽約、用印、完稅、交屋
// 辛苦還房貸幾十年