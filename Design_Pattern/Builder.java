//
//  建造者模式
//
// 主要的角色有建造者、指揮者和產品
//
// https://ithelp.ithome.com.tw/articles/10204732

//蘋果電腦與他的歡樂夥伴元件
public class MacbookPro {

    private Processor processor;

    private Memory memory;
    
    private Storage storage;

    private Graphics graphics;

    private Keyboard keyboard;

    MacbookPro(){}

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Processor getProcessor() {
        return processor;
    }

    public Memory getMemory() {
        return memory;
    }

    public Storage getStorage() {
        return storage;
    }

    public Graphics getGraphics() {
        return graphics;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    @Override
    public String toString() {
        return "{ Macbook : " + "\n" +
                "Processor : " + this.getProcessor().name + "\n" +
                "Memory size : " + this.getMemory().size + "GB" + "\n" +
                "Graphics : " + this.getGraphics().name + "\n" +
                "Storage size : " + this.getStorage().size + "GB" +"\n" +
                "Keyboard language : "+ this.getKeyboard().language +
                " }";
    }

    public static class Processor{

        String name;
        Processor(String name){
            this.name = name;
        }
    }

    public static class Memory{

        int size;
        Memory(int size){
            this.size = size;
        }
    }

    public static class Graphics{

        String name;
        Graphics(String name){
            this.name = name;
        }
    }

    public static class Storage{

        int size;
        Storage(int size){
            this.size = size;
        }
    }

    public static class Keyboard{

        String language;
        Keyboard(String language){
            this.language = language;
        }
    }
}

// MacbookPro 介面類別
public abstract class MacbookProBuilder{

    protected MacbookPro macbookPro;

    MacbookProBuilder(){
    
        macbookPro = new MacbookPro();
    }

    abstract MacbookProBuilder buildCPU(MacbookPro.Processor processor);

    abstract MacbookProBuilder buildMemory(MacbookPro.Memory size);

    abstract MacbookProBuilder buildGraphics(MacbookPro.Graphics name);

    abstract MacbookProBuilder buildStorage(MacbookPro.Storage size);

    abstract MacbookProBuilder buildKeyboard(MacbookPro.Keyboard language);
    
    MacbookPro build(){
        return macbookPro;
    }
}

//銷售者
public class MacbookProSeller{

    private MacbookProSeller  macbookProSeller;

    MacbookProSeller(MacbookProBuilder macbookProBuilder){
        this.macbookProBuilder = macbookProBuilder;
    }

    public MacbookPro lowSpec(){

        return macbookProBuilder
                .buildCPU(new MacbookPro.Processor("2.2GHz 6 核心第八代 Intel Core i7 處理器"))
                .buildMemory(new MacbookPro.Memory(16))
                .buildGraphics(new MacbookPro.Graphics("Radeon Pro 555X 配備 4GB GDDR5 記憶體"))
                .buildStorage(new MacbookPro.Storage(256))
                .buildKeyboard(new MacbookPro.Keyboard("中文注音"))
                .build();
    }

    public MacbookPro highSpec(){

        return macbookProBuilder
                .buildCPU(new MacbookPro.Processor("2.6GHz 6 核心第八代 Intel Core i7 處理器"))
                .buildMemory(new MacbookPro.Memory(16))
                .buildGraphics(new MacbookPro.Graphics("Radeon Pro 560X 配備 4GB GDDR5 記憶體"))
                .buildStorage(new MacbookPro.Storage(512))
                .buildKeyboard(new MacbookPro.Keyboard("中文注音"))
                .build();
    }
}

public class Test {
    
    public void test(){

        MacbookPro_2018 macbookPro_2018 = new MacbookPro_2018();
        MacBookSeller macBookSeller = new MacBookSeller(macbookPro_2018);
        //經銷商的固定規格
        MacbookPro myMacbook= macBookSeller.lowSpec();

        System.out.println(myMacbook.toString());

        //想要夢想中的macbook pro需要自己訂製
        MacbookPro dreamMacbook = macbookPro_2018
                .buildCPU(new MacbookPro.Processor("2.9GHz 6 核心第八代 Intel Core i9 處理器"))
                .buildMemory(new MacbookPro.Memory(32))
                .buildStorage(new MacbookPro.Storage(4096))
                .buildKeyboard(new MacbookPro.Keyboard("英文"))
                .buildGraphics(new MacbookPro.Graphics("Radeon Pro 560X 配備 4GB GDDR5 記憶體"))
                .build();

        System.out.println(dreamMacbook.toString());
    }
}

//
// println
//
// { Macbook : 
//     Processor : 2.2GHz 6 核心第八代 Intel Core i7 處理器
//     Memory size : 16GB
//     Graphics : Radeon Pro 555X 配備 4GB GDDR5 記憶體
//     Storage size : 256GB
//     Keyboard language : 中文注音 }
//     { Macbook : 
//     Processor : 2.9GHz 6 核心第八代 Intel Core i9 處理器
//     Memory size : 32GB
//     Graphics : Radeon Pro 560X 配備 4GB GDDR5 記憶體
//     Storage size : 4096GB
//     Keyboard language : 英文 
// }