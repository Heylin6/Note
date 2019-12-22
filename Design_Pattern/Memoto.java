//
//  備忘錄模式
//
// Memoto：負責儲存需要儲存的狀態的類。
// Originator：提供建立Memoto或是回復到某個Memoto的狀態的方法。
// CareTaker：負責保存備忘錄(memoto)的類別。
//
// https://ithelp.ithome.com.tw/articles/10206939

// 實作 : 電腦一定時間會自我記憶一次哪些東西在使用···其他就可以休眠


//Memoto類別存放現在電腦資訊
public class ComputerMemoto {
    
    String system;
    String hardisk;
    String userDoc;
    String userApp;
    
    public ComputerMemoto(String system,
                          String hardisk,
                          String userDoc,
                          String userApp){

        this.system = system;
        this.hardisk = hardisk;
        this.userDoc = userDoc;
        this.userApp = userApp;
    }

    public String getSystem() {

        return system;
    }

    public void setSystem(String system) {

        this.system = system;
    }

    public String getHardisk() {

        return hardisk;
    }

    public void setHardisk(String hardisk) {

        this.hardisk = hardisk;
    }

    public String getUserDoc() {

        return userDoc;
    }

    public void setUserDoc(String userDoc) {

        this.userDoc = userDoc;
    }

    public String getUserApp() {

        return userApp;
    }

    public void setUserApp(String userApp) {

        this.userApp = userApp;
    }
}

//產生備忘錄的類別
public class ComputerOriginator {

    private String system = "macOS";
    private String hardisk = "ssd";
    private String userDoc = "desk";
    private String userApp = "pages,numbers...";

    public ComputerMemoto save(){

        return new ComputerMemoto(system,hardisk,userDoc,userApp);
    }

    public void restore(ComputerMemoto memoto){

        this.hardisk = memoto.getHardisk();
        this.system = memoto.getSystem();
        this.userApp = memoto.getUserApp();
        this.userDoc = memoto.getUserDoc();
    }

    public String getSystem() {

        return system;
    }

    public void setSystem(String system) {

        this.system = system;
    }

    public String getHardisk() {

        return hardisk;
    }

    public void setHardisk(String hardisk) {

        this.hardisk = hardisk;
    }

    public String getUserDoc() {

        return userDoc;
    }

    public void setUserDoc(String userDoc) {

        this.userDoc = userDoc;
    }

    public String getUserApp() {

        return userApp;
    }

    public void setUserApp(String userApp) {

        this.userApp = userApp;
    }
}

//存放這些資訊的類別
public class ComputerCareTaker {

    //最多備份15筆
        private static final int MAX = 15;    
        public List<ComputerMemoto> saves = new ArrayList<>();
    
    
    //獲取電腦資訊
        public ComputerMemoto getSave(int index){

            if(index > saves.size() - 1){
                index = saves.size() - 1 ;
            }
    
            return saves.get(index);
        }    
        
        //超過時刪除最舊一筆
        public void saveMemoto(ComputerMemoto memoto){

            if (saves.size() > MAX){
                saves.remove(0);
            }

            saves.add(memoto);
        }    
    }

    public class Test {
        
        public void test(){
    
            ComputerCareTaker careTaker = new ComputerCareTaker();
            ComputerOriginator originator = new ComputerOriginator();
    
            careTaker.saveMemoto(originator.save());
    
            System.out.println(careTaker.getSave(0).getSystem());
    
            originator.setSystem("windows");
    
            careTaker.saveMemoto(originator.save());
    
            System.out.println(careTaker.getSave(1).getSystem());
    
        }
    }


// macOS
// windows