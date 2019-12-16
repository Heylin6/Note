//
//  單例模式_2
//
// https://ithelp.ithome.com.tw/articles/10203092
//
// 存取ＩＯ和資料庫等資源，這時候要考慮使用單例模式。

public abstract class Product {
    
    public String getName(){
        
        return this.getClass().getSimpleName(); 
    }    
}

public abstract class Factory{

    public Product getProduct();
}

public class Cola extends Product{

}

public class HamBerger extends Product{

}

//SingletonFactory
public class SingletonFactory{

    public static Factory getColaFactory() {
        return ColaFactory.colaFactory;
    }

    public static Factory getColaFactory() {
        return HamBergerFactory.hambergerfactory;
    }

    private static class ColaFactory implements Factory() {
        
        private static ColaFactory colafactory = new ColaFactory();

        private ColaFactory(){}

        public Product getProduct(){

            return new Cola();
        }
    }

    private static class HamBergerFactory implements Factory() {
        
        private static HamBergerFactory hambergerfactory = new HamBergerFactory();

        private HamBergerFactory(){}

        public Product getProduct(){

            return new HamBerger();
        }
    }
}

public class Test{

    public void test(){

        Cola cola = (Cola)SingletonFactory.getColaFactory().getProduct();
        HamBerger HamBerger = (HamBerger)SingletonFactory.getColaFactory().getProduct();

        //print : Cola
        System.out.println(cola.getName());
        //print : Humberger
        System.out.println(humberger.getName());        
    }
}