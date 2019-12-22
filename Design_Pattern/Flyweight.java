//
//  享元模式
//
//  享元模式:運用共有技術有效的支援大量細粒度的物件。
//
//  1. 避免需要大量創建物件的狀況，使物件的使用更有效（可以減少記憶體的使用量）。
//  2. 因為需要被分享所以Flyweight物件需要immutable。
//  3. 需要共用程式碼或是共有一份實體，是物件池的一種實作。
//
// https://ithelp.ithome.com.tw/articles/10207215

//macbook的產品有很多種，
//用享元模式(輕量模式)，
//同樣的macbook實體只實體化一次

//共有資料
public class Monitor {

    private final String monitor = "Retina Monitor";
    
    public String getMonitor(){
        return monitor;
    }
}

//外部資料
public class CustonSetting {

    //儲存一些使用者設定的類別
    public static CustonSetting LOW = new CustonSetting("LOW");
    public static CustonSetting HIGH = new CustonSetting("HIGH");

    private String cpu;
    private int memory;
    private int storage;

    public CustonSetting(){}
    
    public CustonSetting(String set){

        switch (set){

            case "LOW":
                //一些低階設定
                cpu = "i5";
                memory = 8;
                storage = 256;
                break;
            case "HIGH":
                //一些高階設定
                cpu = "i7";
                memory = 16;
                storage = 512;
                break;
            default:
                break;
    }

    public String getCpu() {

        return cpu;
    }

    public void setCpu(String cpu) {

        this.cpu = cpu;
    }

    public int getMemory() {

        return memory;
    }

    public void setMemory(int memory) {

        this.memory = memory;
    }

    public int getStorage() {

        return storage;
    }

    public void setStorage(int storage) {

        this.storage = storage;
    }

    @Override
    public String toString() {

        return "CustomSetting = { " + "\n" +
                "cpu = " + this.getCpu() + "\n" +
                "memory = " + this.getMemory() + "\n" +
                "storage = " + this.getStorage() + "\n" +
                "}";
    }
}

//Macbook 類別
public class Macbook extends Monitor{

    enum Spec{

        LOW(CustonSetting.LOW),
        HIGH(CustonSetting.HIGH);

        CustonSetting custonSetting;
        Spec(CustonSetting custonSetting){
            
            this.customSetting = customSetting;
        }

        public void getCustonSetting(){

            return customSetting;
        }
    }

    private CustomSetting customSetting;

    private CustomSetting customSetting;

    public Macbook(Spec spec){

        this.customSetting = spec.getCustomSetting();
    }

    public Macbook(CustomSetting customSetting){

        this.customSetting = customSetting;
    }


    public void setCustomSetting(CustomSetting customSetting){

        this.customSetting = customSetting;
    }

    @Override
    public String toString() {

        return "CustomSetting = { " + "\n" +
                "cpu = " + customSetting.getCpu() + "\n" +
                "memory = " + customSetting.getMemory() + "\n" +
                "storage = " + customSetting.getStorage() + "\n" +
                "monitor = " + getMonitor() + "\n" +
                "}";
    }
}

//享元模式的Macbook Factory
public class MacbookFactory{

    private HashMap<CustomSetting,Macbook> cache = new HashMap();

    public Macbook getCustomMacbook(CustomSetting key){

        if(cache.containsKey(key)){
            
            return cache.get(key);
        }

        Macbook macbook = new Macbook(key);
        cache.put(key,macbook);

        return macbook;
    }

    public Macbook getMacbook(Macbook.Spec spec){

        if(cache.containsKey(spec.getCustomSetting())){
            return cache.get(spec.getCustomSetting());
        }

        Macbook macbook = new Macbook(key);
        cache.put(spec.getCustomSetting(),macbook);

        return macbook;
    }
}

public class Test {

    public void test(){

        MacbookFactory factory = new MacbookFactory();
        Macbook goodbook = factory.getMacbook(Macbook.Spec.HIGH);
        System.out.println(goodbook.toString());
        CustomSetting superSetting = new CustomSetting();
        superSetting.setCpu("i9");
        superSetting.setMemory(32);
        superSetting.setStorage(1024);
        Macbook superMacbook = factory.getCustomMacbook(superSetting);
        System.out.println(superMacbook.toString());
    }
}

// 打印結果

// CustomSetting = { 
//     cpu = i7
//     memory = 16
//     storage = 512
//     monitor = Retina Display
//     }
// CustomSetting = { 
//     cpu = i9
//     memory = 32
//     storage = 1024
//     monitor = Retina Display
//     }