//
//  觀察者模式(一對多的依賴關係)
//
//  當物件的狀態改變，所有依賴於它的物件都會得到通知並被自動更新。
//
//  對於GUI(畫面)相關的很適合用這種模式，
//
//  也有一些概念是用資料流的方式處理，
//
// https://ithelp.ithome.com.tw/articles/10204117


//
//訂閱廣播 每段時間就會換一次節目
//
public interface IObserverable {
    
    public void add(IObserver observer);
    public void remove(IObserver observer);
    public void notifyObservers();
}

public interface IObserver{

    public void update();
}

//被觀察者
public class PodcastA implements IObserverable{

    List<IObserver> list = new ArrayList<>{};

    String name = "日文廣播";

    @override
    public void add(IObserver observer){
        
        list.add(observer);
    }

    @override
    public void remove(IObserver observer){
        
        list.remove(observer);
    }

    public static String getName(){
        
        return this.name;
    }

    @override
    public void notifyObservers(){

        for(IObserver o:list)
        {
            o.update();
        }
    }
}

    //觀察者
public class Student interface IObserver{

    IObserverable observerable;

    public Student(IObserverable observerable){

        this.observerable = observerable;
    }

    @override
    public void update(){
            
        System.out.println("聽了" + observerable.getName());
    }
}

public class Test {
    
    public void test(){
        IObserverable podcast = new PodcastA();
        IObserver student = new Student(podcast);
        podcast.add(student);

        //預設節目是英文廣播
        podcast.notifyObservers();

        //節目變為今年流行歌
        ((PodcastA) podcast).name = "今年流行歌";

        podcast.notifyObservers();
    }

    //
    // 輸出
    //
    // 聽了英文廣播
    // 聽了今年流行歌
    //

}