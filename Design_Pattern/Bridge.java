//
//  橋接模式
//
//  將抽象部分與它的實現部分分離，使它們都可以獨立地變化。
//
// https://ithelp.ithome.com.tw/articles/10207956

//定義頁面的Super Class
public abstract class View {
    
    Resource resources;

    public void setResource(Resource resources){

        this.resources = resources;
    }

    //定義畫面如何開啟
    public abstract void show();
}

//定義來源的介面
public interface Resources {

    public void photo();
    public void snippet();
    public void describe();
}

//書本和包包來源
//書本
public class book implements Resources{

    @Override
    public void photo() {
        System.out.println("書本的照片");
    }

    @Override
    public void snippet() {
        System.out.println("書本的簡短說明");
    }

    @Override
    public void describe() {
        System.out.println("書本詳細說明");
    }
}

//包包
public class Bag implements Resources {
    @Override
    public void photo() {
        System.out.println("包包的照片");
    }

    @Override
    public void snippet() {
        System.out.println("包包的簡短說明");
    }

    @Override
    public void describe() {
        System.out.println("包包詳細說明");
    }
}

//小資訊的頁面跟所有資訊的頁面
public class FewView extends View{

    @Override
    public void show() {
        resources.photo();
        resources.snippet();
    }
}

//所有資訊
public class FullView extends View {

    @Override
    public void show() {
        resources.photo();
        resources.describe();
    }
}

public class Test {
    
    public void test(){

        FewView fewView = new FewView();
        System.out.println("---- 簡單包包說明 ----");
        fewView.setResources(new Bag());
        fewView.show();
        System.out.println("---- 簡單書本說明 ----");
        fewView.setResources(new Book());
        fewView.show();

        FullView fullView = new FullView();
        System.out.println("---- 詳細包包說明 ----");
        fullView.setResources(new Bag());
        fullView.show();
        System.out.println("---- 詳細書本說明 ----");
        fullView.setResources(new Book());
        fullView.show();
    }
}

// 測試結果

// ---- 簡單包包說明 ----
// 包包的照片
// 包包的簡短說明
// ---- 簡單書本說明 ----
// 書本的照片
// 書本的簡短說明
// ---- 詳細包包說明 ----
// 包包的照片
// 包包詳細說明
// ---- 詳細書本說明 ----
// 書本的照片
// 書本詳細說明