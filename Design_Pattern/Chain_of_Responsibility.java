//
//  責任鍊模式
//
// https://ithelp.ithome.com.tw/articles/10208172

//公司大問題要給CEO處理，小問題經理就可以了

//Header類別 各個管理人的 SuperClass

public abstract class Handler {
    
    Handler successor;

    //
    public void setSuccessor(){

        this.successor = successor;
    }

    //負責處理問題的動作
    public abstract void handlerRequset(Trouble trouble);
}

public class Manager extends Handler{

    public Manager(){
        
        //為了方便在這邊設定上級是誰
        //可以轉換到客戶端設定
        setSuccessor(new CEO());
    }

    @Override
    public void handleRequest(Trouble trouble) {

        if(trouble.getCode() > 1000){

            successor.handleRequest(trouble);
        }else{

            System.out.println("Manager:" + trouble.getName() + "是小問題，不用擔心。" );
        }
    }
}

public class CEO extends Handler {

    @Override
    public void handleRequest(Trouble trouble) {

        System.out.println("CEO:" + trouble.getName() + "是誰搞的！叫他過來。");
    }
}

//問題類別 有名稱跟大小
public class Trouble {

    private String name;

    private int size;

    public Trouble(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }
}


public class Test {
    
    public void test(){

        Handler manager = new Manager();

        //小問題
        Trouble smallTrouble = new Trouble("想加薪500", 500);
        manager.handleRequest(smallTrouble);

        //大問題
        Trouble bigTrouble = new Trouble("搞壞五十萬的機器",500000);
        manager.handleRequest(bigTrouble);
    }
}

//
// 打印結果
//
// Manager:想加薪500是小問題，不用擔心。
// CEO:搞壞五十萬的機器是誰搞的！叫他過來。
//