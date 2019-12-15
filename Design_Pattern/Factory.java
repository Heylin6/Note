
//
//  工廠模式
//
//https://ithelp.ithome.com.tw/articles/10202075

public interface Product() 

    //敘述是甚麼產品
    public void icecream();
}

public interface Factory(){

    //工廠返回產品
    public icecream geticecream();
}

//實現 義大利產冰淇淋
public class Italy implements Product{

    //預設口味
    String state = "香草";
    //預設建構子
    protected Italy(){}
    //帶入參數的建構子
    protected Italy(String state){
        this.state = state;
    }

    public void output_icecream(){

        //複寫 Product 的 icecream
        System.out.println(state+" 口味的冰淇淋");
    };
}


public class IceCreamFactory implements Factory{

    //複寫 返回一般口味
    public icecream geticecream(){
        return new icecream();
    };

    //返回特殊口味
    public icecream geticecream(String state){
        return new icecream(state);
    };
}

//
// 實際 RUN
//

Factory IceCFactory = new Factory();

Product IceC = IceCFactory.geticecream();
Product Milk_IceC = IceCFactory.geticecream("牛奶");

//香草 口味的冰淇淋
IceC.output_icecream()
//牛奶 口味的冰淇淋
Milk_IceC.output_icecream();