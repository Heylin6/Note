//
//  範本方法模式
//
// https://ithelp.ithome.com.tw/articles/10205036

//老闆的腦子
public abstract class BossMethod  {
    
    private String BossThink() {
        
        return "我說的算";
    }

    private String BossRedo() {
        
        return "你們這樣做不符合市場需求阿";
    }

    abstract String UI_Design();

    abstract String systemAnalysis();

    abstract String systemDesign();

    abstract String programming();

    abstract String test();
    
    public void completeSoftware(){

        System.out.println(
                bossThink() + UI_Design() + "\n" +
                bossThink() + systemAnalysis() + "\n" +
                bossThink() + systemDesign() + "\n" +
                bossThink() + programming() + "\n" +
                bossThink() + test()
        );

    }

    public void redoSoftware(){
        System.out.println(bossRedo());
        completeSoftware();
    }
}

//開發時繼承老闆的意志

public class SoftwareManager extends BossMethod{

    @override
    String UI_Design(){

        System.out.println("找一個UI Design做");
        return "UI成果";
    };

    @Override
    String systemAnalysis() {
        
        System.out.println("找一個軟體分析師做");
        return "軟體分析成果";
    }

    @Override
    String systemDesign() {

        System.out.println("找一個系統設計師做");
        return "系統設計成果";
    }

    @Override
    String programming() {

        System.out.println("找一個軟體工程師做");
        return "程式成果";
    }

    @Override
    String test() {

        System.out.println("找一個測試工程師做");
        return "測試成果";
    }
}

public class Test {
    
    public void test(){

        SoftwareManager softwareManager = new SoftwareManager();
        softwareManager.completeSoftware();
        softwareManager.redoSoftware();
    }
}