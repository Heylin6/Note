//
//  轉接器模式
//
//  例如USB TypeC -> vga的轉接器。
//
//  主要的角色有客戶端(Client)、轉接的介面(Target)、介面的實作(Adapter)、提供的類別(Adaptee)
//
// https://ithelp.ithome.com.tw/articles/10205321

//有一個黑人我想要重用他的名字
public class BlackMan {
    
    String name;

    public BlackMan(String name){

        this.name= name;
    }

    public void helloEnglish(){

        System.out.println("yo~ what's up!! niga~");
    }

    public void selfIntroEnglish(){

        System.out.println("hello, I living in taipei. " +
                "my name is " + this.name + ".");
    }
}

//介面
public abstract class People{

    String name;

    public People(String name){

        thus.name = name;
    }

    public abstract void hello();

    public abstract void selfIntro();

    public String getName() {

        return name;
    }
}

//介面實踐
public class BlackManTranslator extends People{

    public BlackManTranslator(String name){

        return name;
    }

    @override
    public void hello(){

        System.out.println(getName() + ":哩甲霸咩～真的假的！？");
    };

    @override
    public void selfIntro(){

        System.out.println("大家好我是" + getName() +
                "，現在台北工作。");
    };
}

//翻譯介面
public class TaiwanMan {

    private People people;

    public TaiwanMan(People people){

        this.people = people;
    }

    public void hello(){

        people.hello();
    }

    public void selfIntro(){

        people.selfIntro();
    }

}


public class Test {
   
    public void test(){

        BlackMan blackMan = new BlackMan("black");

        blackMan.helloEnglish();
        blackMan.selfIntroEnglish();


        TaiwanMan taiwanMan = new TaiwanMan(new BlackmanTranslator(blackMan.name));

        taiwanMan.hello();
        taiwanMan.selfIntro();
    }
}

// 打印結果

// yo~ what's up!! niga~
// hello, I living in taipei. my name is black.
// black:哩甲霸咩～真的假的！？
// 大家好我是black，現在台北工作。