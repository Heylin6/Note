//
//  狀態模式
//
//  當一個物件的內在狀態改變時允許改變其行為
//
//  個物件看起來像是改變了其類別。
//
//  將行為用一個介面封裝起來，針對不同的狀態去改變其行為。
//
// https://ithelp.ithome.com.tw/articles/10206608

//狀態的介面
public abstract class State  {
    
    //顯示的數值
    abstract public String tempToDisplay(double temperture);
    abstract public String vibToDisplay(double vibration);

    //儲存的數值
    abstract public String tempToSave(double temperture);
    abstract public String vibToSave(double vibration);

    //精準到小數點下兩位
    public static String twoDecPlaces(Double value){
        return String.format("%.2f",value);
    }

    public static String saveForm(Double value){
        return String.format("%f",value);
    }
}

//公制的State
public class Metric extends State {

    @Override
    public String tempToDisplay(Double temperture) {

        System.out.println("顯示公制");
        return twoDecPlaces(temperture);
    }

    @Override
    public String vibToDisplay(Double vibration) {

        System.out.println("顯示公制");
        return twoDecPlaces(vibration);
    }

    @Override
    public String tempToSave(Double temperture) {

        System.out.println("儲存公制");
        return saveForm(temperture);
    }

    @Override
    public String vibToSave(Double vibration) {

        System.out.println("儲存公制");
        return saveForm(vibration);
    }
}

//英制的State
public class British extends State {

    @Override
    public String tempToDisplay(Double temperture) {

        System.out.println("顯示英制");
        return twoDecPlaces(temperture * 9 / 5 + 32);
    }

    @Override
    public String vibToDisplay(Double vibration) {

        System.out.println("顯示英制");
        return twoDecPlaces(vibration * 25.4);
    }

    @Override
    public String tempToSave(Double temperture) {

        System.out.println("儲存英制");
        return saveForm((temperture - 32) * 5 / 9);
    }

    @Override
    public String vibToSave(Double vibration) {

        System.out.println("儲存英制");
        return saveForm(vibration/25.4);
    }
}

//選擇是哪一種狀態的環境 (Context)
public class MetricSystem {

    private State state;

    public void setState(final State state) {

        this.state = state;
    }

    public void tempView(Double temp){

        System.out.println(state.tempToDisplay(temp));
    }

    public void vibView(Double vib){

        System.out.println(state.vibToDisplay(vib));
    }

    public void tempSave(Double temp){

        System.out.println(state.tempToSave(temp));
    }

    public void vibSave(Double vib){

        System.out.println(state.vibToSave(vib));
    }
}


public class Test {
    @org.junit.jupiter.api.Test
    public void test(){

        MetricSystem metricSystem = new MetricSystem();
        metricSystem.setState(new Metric());

        metricSystem.tempView(50d);
        metricSystem.vibView(10d);
        metricSystem.tempSave(50d);
        metricSystem.vibSave(10d);

        metricSystem.setState(new British());

        metricSystem.tempView(50d);
        metricSystem.vibView(10d);
        metricSystem.tempSave(50d);
        metricSystem.vibSave(10d);

    }
}

// 顯示公制
// 50.00
// 顯示公制
// 10.00
// 儲存公制
// 50.000000
// 儲存公制
// 10.000000
// 顯示英制
// 122.00
// 顯示英制
// 254.00
// 儲存英制
// 10.000000
// 儲存英制
// 0.393701