//
//  組合模式
//
//  將物件組合成樹形結構以表示「 部分 - 整體 」的層次結構
//
//  組織中某些部位、功能可能包含部分或著整體時。
//  使用者對整體或是單一物件可以使用同樣的function進行操作。
//  在組合模式中所有的物件都是整體的一部分，而整體是物件的集合。
//
// https://ithelp.ithome.com.tw/articles/10207478

//公司和公司下的子公司和部門共同介面
public abstract class Component {
    
    String name;

    List<Component> componentList = new ArrayList<>();

    public Component(String name){

        this.name= name;
    }

    public Component(String name){

        this.name = name;
    }

    public void add(Component component){

        componentList.add(component);
    }

    public void remove(Component component){

        componentList.remove(component);
    }

    public void display(int depth){

        for (int i = 0; i < depth ; i++) {

            System.out.print("-");
        }

        System.out.println(this.name );

        for (Component c: componentList ) {

            c.display(depth + 2);
        }
    }

    public void command(String command){

        System.out.println(this.name + " " + command);

        for (Component c: componentList) {

            c.command(command);
        }
    }
}

//可以有子元件的 Composite 
public class Composite extends Component{

    public Composite(String name){

        super(name);
    }
}


//不能有子元件的 Leaf 
public class Leaf extends Component{

    public Leaf(String name){

        super(name);
    }

    @Override
    public void add(Component component) {
        System.out.println("Leaf cant add component");
    }

    @Override
    public void remove(Component component) {

        System.out.println("Leaf cant remove component");
    }

    @Override
    public void display(int depth) {
        super.display(depth);
    }
}

public class Client {

    @Test
    public void test(){

        Component big = new Composite("大公司");

        Component mid1 = new Composite("子公司1");
        Component mid2 = new Composite("子公司2");

        Component small1 = new Leaf("部門1");
        Component small2 = new Leaf("部門2");
        Component small3 = new Leaf("部門3");
        Component small4 = new Leaf("部門4");

        big.add(mid1);
        big.add(mid2);

        mid1.add(small1);
        mid1.add(small2);

        mid2.add(small3);
        mid2.add(small4);

        Component small5 = new Leaf("部門5");

        small1.add(small5);

        System.out.println("------- 大公司 -------");
//        公司階層
        big.display(1 );
//        大老闆發命令所有人都會接收到
        big.command("開發快一點");

        System.out.println("------- 子公司 -------");

        mid2.display(1 );
//        子公司命令只有子公司下面的階層可以接收到
        mid2.command("大老闆說Q4要完成");

    }

}

// 輸出

// Leaf cant add component
// ------- 大公司 -------
// -大公司
// ---子公司1
// -----部門1
// -----部門2
// ---子公司2
// -----部門3
// -----部門4
// 大公司 開發快一點
// 子公司1 開發快一點
// 部門1 開發快一點
// 部門2 開發快一點
// 子公司2 開發快一點
// 部門3 開發快一點
// 部門4 開發快一點
// ------- 子公司 -------
// -子公司2
// ---部門3
// ---部門4
// 子公司2 大老闆說Q4要完成
// 部門3 大老闆說Q4要完成
// 部門4 大老闆說Q4要完成