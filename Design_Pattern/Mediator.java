//
//  仲介者模式
//
//
// 1. 類別之間有大量的聯繫關係時。
// 2. 將網狀的結構重新分離成星狀的結構。
// 3. 引用關係複雜，類別之間關係混亂難以重用··，可以通過一個中間類別來封裝多個類別中的行為。
//
// https://ithelp.ithome.com.tw/articles/10208389

//Mediator：仲介者(中間人)的介面，中介者是各個同事的溝通橋樑
//
//Colleague：加盟者(同事?)的介面

//公司的介面
public interface Company {
    
    public void addMember(CoWorker coWorker);

    public void introduce(CoWorker coWorker);

    public void workHard();

    public void giveWork(CoWorker coWorker);
}

//員工的介面
public abstract class CoWorker {

    String name;
    Boss boss;

    public CoWorker(String name){

        this.name = name;
    }

    public abstract void work();
}

//公司下面的老闆
public class Boss implements Company{

    List<CoWorker> coWorkers;

    public Boss(){

        coWorkers = new ArrayList<>();
    }

    @Override
    public void addMember(CoWorker coWorker){
        coWorkers.add(coWorker);
        coWorker.boss = this;
    }

    @Override
    public void introduce(CoWorker coWorker) {
        System.out.println("Boss:跟大家介紹這位是" + coWorker.name);
    }

    @Override
    public void workHard() {
        for (CoWorker c: coWorkers
             ) {
            System.out.println("Boss:" + c.name + "認真點做啊！");
        }
    }

    @Override
    public void giveWork(CoWorker coWorker) {
        System.out.println("Boss:" + coWorker.name + "這個幫忙一下。");
    }
}

//PM
public class PM extends CoWorker {

    public PM(String name) {

        super(name);
    }

    @Override
    public void work() {

        System.out.println(this.name + "做PM工作");
    }

    public void bossHelp(CoWorker coWorker){

        this.boss.giveWork(coWorker);
    }
}

//Programmer
public class Programmer extends CoWorker {
    
    public Programmer(String name) {

        super(name);
    }

    @Override
    public void work() {

        System.out.println(this.name + "寫程式");
    }
}



public class Test {
    
    public void test(){

//        無名的Boss
        Boss boss = new Boss();

//        各個員工
        PM wei = new PM("小偉");
        Programmer bad = new Programmer("小惡");
        Programmer good = new Programmer("阿仁");

//        把員工加入Boss下面管理
        boss.addMember(wei);
        boss.addMember(bad);
        boss.addMember(good);

//        Boss介紹新來的小惡
        boss.introduce(bad);

//        阿仁自己工作
        good.work();

//        boss請大家專心工作
        boss.workHard();

//        小惡自己做不來
//        PM請老闆幫忙
        wei.bossHelp(bad);
    }
}


// 輸出

// Boss:跟大家介紹這位是小惡
// 阿仁寫程式
// Boss:小偉認真點做啊！
// Boss:小惡認真點做啊！
// Boss:阿仁認真點做啊！
// Boss:小惡這個幫忙一下。