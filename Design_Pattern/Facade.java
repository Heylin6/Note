//
//  外觀模式
//
//  Facade為封裝用的介面。
//
//  在SubSystem Classes的虛線矩形是被封裝的複雜的系統。
//
// https://ithelp.ithome.com.tw/articles/10206318

public class SubClassOne {
    
    public void MethodOne(){

        System.out.println(1);
    }
}

public class SubClassTwo {

    public void MethodTwo(){

        System.out.println(2);
    }
}

public class SubClassThree {

    public void MethodThree(){

        System.out.println(3);
    }
}

public class ClassOne {

    public void MethodFour(){

        System.out.println(4);
    }
}

public class Facade {

    private SubClassOne one;
    private SubClassTwo two;
    private SubClassThree three;
    private ClassOne four;

    public Facade(){
        one = new SubClassOne();
        two = new SubClassTwo();
        three = new SubClassThree();
        four = new ClassOne();
    }

    public void MethodA(){
        four.MethodFour();
        one.MethodOne();
    }

    public void MethodB(){
        two.MethodTwo();
        three.MethodThree();
    }

}

public class Test {
    @org.junit.jupiter.api.Test
    public void test(){

        Facade facade = new Facade();

        System.out.println("MethodA : ");
        facade.MethodA();

        System.out.println("MethodB : ");
        facade.MethodB();

    }
}



// MethodA : 
// 4
// 1
// MethodB : 
// 2
// 3