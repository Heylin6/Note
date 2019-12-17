//
//  命令模式
//
//  命令模式(Command Pattern)有三個主要角色，
//  Invoker、ICommand和Receiver，是將對行爲進行封裝的典型模式，
//
//  將命令的命令接收(請求操作者)跟執行命令(實際操作者)之間切分開來。
//
// https://ithelp.ithome.com.tw/articles/10204425

public class Light {

    //Receiver可以是任何的類
    public void turnOn(){

        System.out.println("開燈");
    }

    public void turnOff(){

        System.out.println("關燈");
    }

    public void brighter(){

        System.out.println("調亮");
    }

    public void darker(){

        System.out.println("調暗");
    }
}

//燈光控制介面
public abstract class Command {

    Light Light;

    public Command(Light light){

        this.light = light;
    }

    public abstract void execute();   
}

public class TurnOn extends Command {

    public TurnOn(Light light){

        super(light);
    }

    @override
    public void execute(){

        light.turnOn();
    };
}

public class TurnOff extends Command {

    public TurnOff(Light light){

        super(light);
    }

    @override
    public void execute(){

        light.turnOff();
    };
}

public class Brighter extends Command{
    public Brighter(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.brighter();
    }
}

public class Darker extends Command {
    public Darker(Light light) {
        super(light);
    }

    @Override
    public void execute() {
        light.darker();
    }

}

//遙控器
public class Invoker {

    private List<Command> commandlist = new ArrayList<>();

    public void addCommand(Command command){

        commandlist.add(command);
    }

    public void execute(){
        
        for(Command command : commandlist){
            
            command.execute();
        }
    }
}

//測試
public class Test {
    
    public void test(){

        Light light = new Light();

        Command turnOn = new TurnOn(light);
        Command brighter = new Brighter(light);
        Command darker = new Darker(light);

        Invoker invoker = new Invoker();

        invoker.addCommand(turnOn);
        invoker.addCommand(brighter);
        invoker.addCommand(brighter);
        invoker.addCommand(brighter);
        invoker.addCommand(darker);

        invoker.execute();
    }
}

//
// 打印結果
//
//打開燈
//亮度提高
//亮度提高
//亮度提高
//亮度降低
//