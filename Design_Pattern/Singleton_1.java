//
//  單例模式_1
//
// https://ithelp.ithome.com.tw/articles/10203092
// https://dotblogs.com.tw/Leo_CodeSpace/2017/06/03/204504
//
// 存取ＩＯ和資料庫等資源，這時候要考慮使用單例模式。
//
// 範例 : 打開電腦的裝置管理員 無法多開同樣畫面
// 因為鎖起來了
// 
// 可應用在網站後台 登入相關人員後 登出前其他裝置都無法進行登入

//積極模式
//在宣告物件時已經初始化
public class SingleObject {
    
    //創建 SingleObject
    private static SingleObject instance = new SingleObject();

    //建立成 provate 確保不會被外部實例化
    private SingleObject(){}

    //建立唯一可用的方法
    private static SingleObject getInstance(){

        return instance;
    }
}

//懶散模式
//呼叫getInstance時才進行初始化
//每次都需要進行同步，效率會很很低。
public class SingleObjectLazy {
    
    //創建 SingleObject
    private static SingleObjectLazy instance;

    //建立成 provate 確保不會被外部實例化
    private SingleObjectLazy(){}

    //因為整個系統都要存取這個類別，很可能有多個process或thread同時存取
    //為了讓線程安全添加synchronized在多線程下確保物件唯一性
    public static synchronized SingleObjectLazy getInstance(){
        if (instance == null)
        {
            instance = new SingleObjectLazy();
        }
        return instance;
    }
}

//雙重鎖
public class SingletonDoubleLock {

    public static SingletonDoubleLock instance;
    private SingletonDoubleLock(){}
    public static SingletonDoubleLock getInstance(){

        //第一層判斷為了避免不必要的同步
        if(instance == null){
            
            synchronized (SingletonDoubleLock.class){
                //第二層判斷為了在null的狀況下建立實例
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


//靜態內部類實現
public class StaticInnerClass{

    private StaticInnerClass(){}

    public static StaticInnerClass getInstance(){
        return StaticInnerClassHolder.instance;
    }

    //靜態內部類別
    private static StaticInnerClassHolder{
        private static StaticInnerClass instance = new StaticInnerClass();
    }
}