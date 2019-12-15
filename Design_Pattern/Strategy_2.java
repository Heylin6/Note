//
//  策略者模式 2
//
// https://ithelp.ithome.com.tw/articles/10202506

public interface IStrategy {

    public int caculate(int x,int y);
}


//複寫介面跟方法 公車
public class BusStrategy implements IStrategy {

    public int caculate(int km){

        //一段票15元
        //十公里內一段票，超過十公里兩段票
        int count = 0 ;

        if( km <= 10 ){
            count = 1 ;
        }else if( km > 10){
            count = 2 ;
        }

        return count * 15 ;
    };
}

//複寫介面跟方法 捷運
public class MRTStrategy implements IStrategy {

    public int caculate(int km){

        //小於十公里20元，超過每五公里五元
        int result = 0 ;

        if(km <= 0) return  result ;

        if(km <= 20) {
            result = 20 ;
        }

        if(km > 20){
            int count = (( km - 20 ) / 5 ) + 1 ;
            result = result + 5 * count ;
        }

        return result;
    };
}


public class PriceCalculator{
    
    //new抽象介面
    private IStrategy strstegy;

    private PriceCalculator(){};

    public PriceCalculator(IStrategy strstegy){

        this.strategy = strategy;
    };

    public setStrategy(IStrategy strstegy){
        
        this.strategy = strategy;
    };

    public int caculate(int km){

        return this.calculate(km ,strategy);
    }

    public int caculate(int km,IStrategy strategy){

        this.strategy = strategy;
        return strategy.calculate(km);
    }
}