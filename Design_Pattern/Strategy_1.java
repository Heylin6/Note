//
//  策略者模式 1
//
// https://ithelp.ithome.com.tw/articles/10202506

public interface IStrategy {

    public int caculate(int x,int y);
}


//複寫介面跟方法
public class add implements IStrategy {

    public int caculate(int x,int y){
        return a + b;
    };
}

//複寫介面跟方法
public class minus implements IStrategy {

    public int caculate(int x,int y){
        return a - b;
    };
}

//複寫介面跟方法
public class multyply implements IStrategy {

    public int caculate(int x,int y){
        return a * b;
    };
}

//複寫介面跟方法
public class divide implements IStrategy {

    public int caculate(int x,int y){
        return a / b;
    };
}

public class Calculator {

    //初始值
    private int initNum = 0;
    
    //new抽象介面
    private IStrategy strstegy;

    //策略模式
    private int excute(int a,int b){

        return strstegy.caculate(a,b);
    }

    public void reset(){

        this.initNum = 0;
    }

    public void setStrategy(DoType doType)
    {
        switch(doType)
        {
            case ADD:
                this.strstegy = new add();
                break;
            case MINUS:
                this.strstegy = new minus();
                break;
            case DIVIDE:
                this.strstegy = new multyply();
                break;
            case MULTYPLY:
                this.strstegy = new divide();
                break;
        }
    }

    enum DoType{
        ADD , MINUS , DIVIDE , MULTYPLY
    }
}