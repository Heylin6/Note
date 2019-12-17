//
//  命令模式
//
//  命令模式(Command Pattern)有三個主要角色，
//  Invoker、ICommand和Receiver，是將對行爲進行封裝的典型模式，
//
//  將命令的命令接收(請求操作者)跟執行命令(實際操作者)之間切分開來。
//
// https://ithelp.ithome.com.tw/articles/10204425

//魔術方塊
public class Tetris {

    public Tetris(){
    }

    //Receiver可以是任何的類
    public void turnLeft(){

        System.out.println("左轉");
    }

    public void turnRight(){

        System.out.println("右轉");
    }

    public void straightDown(){

        System.out.println("下轉");
    }
}

//燈光控制介面
public abstract class ICommandTetris {

    //抽象的命令
    protected Tetris tetris;

    public ICommandTetris(Tetris tetris){

        this.tetris = tetris;
    }

    public abstract void execute();   
}

public class TurnLeft extends ICommandTetris {

    public TurnLeft(Tetris tetris){

        super(tetris);
    }

    @override
    public void execute(){

        tetris.turnRight();
    };
}

public class StraightDown extends ICommandTetris {

    public StraightDown(Tetris tetris){

        super(tetris);
    }

    @override
    public void execute(){

        tetris.straightDown();
    };
}



//遊戲的遙控者
public class Invoker {

    ICommandTetris command;

    public void Invoker(Command command){

        this.command = command;
    }

    public void setCommand(Command command){

        this.command = command;
    }

    public void execute(){
            
        command.execute();        
    }
}

public class Test {
    
    public void test(){

        Tetris tetris = new Tetris();
        ICommandTetris commandLeft = new TurnLeft(tetris);
        ICommandTetris commandRight = new TurnRight(tetris);
        ICommandTetris commandDown= new StraightDown(tetris);

        Invoker invoker = new Invoker(commandLeft);

        invoker.invoke();
        invoker.setCommand(commandRight);
        invoker.invoke();
        invoker.setCommand(commandDown);
        invoker.invoke();
    }
}

//
//  輸出
//
//  左轉
//  右轉
//  下轉
//