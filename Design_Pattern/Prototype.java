//
//  原型模式
//
//  從一個物件再建立另外一個可訂製的物件，而且不需要知道任何建立的細節。
//
// https://ithelp.ithome.com.tw/articles/10205989

//空氣品質感測器
public abstract class Prototype implements Cloneable {
    
    public Prototype clone() throws CloneNotSupportException{

        return (Prototype) super.clone();
    }
}

public class Sensor extends Prototype{

    private int ID;

    private String name;
    private String nickname;

    private String version;
    private String wifiID;
    private String wifiPass;

    private String data;

    public String getData() {

        return data;
    }

    public void setData(String data) {

        this.data = data;
    }

    public int getID() {

        return ID;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getNickname() {

        return nickname;
    }

    public void setNickname(String nickname) {

        this.nickname = nickname;
    }

    public String getVersion() {

        return version;
    }

    public void setVersion(String version) {

        this.version = version;
    }

    public String getWifiID() {

        return wifiID;
    }

    public void setWifiID(String wifiID) {

        this.wifiID = wifiID;
    }

    public String getWifiPass() {

        return wifiPass;
    }

    public void setWifiPass(String wifiPass) {

        this.wifiPass = wifiPass;
    }

    @override
    public Prototype clone()  throws CloneNotSupportException{

        return (Sensor) super.clone();
    }
}



import org.junit.jupiter.api.Assertions;

//設定五千個感測器的初始設定檔
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){

        Sensor[] sensors = new Sensor[5000];
        sensors[0] = new Sensor();
        sensors[0].setID(1);
        sensors[0].setName("Sensor第一版");
        sensors[0].setNickname("我的空氣探測器");
        sensors[0].setVersion("1.0.0");
        sensors[0].setWifiID("MYSENSORWIFIID1.0.0");
        sensors[0].setWifiPass("THISisWiFiPasssOuO");
        sensors[0].setData("None");

        for(int i = 1 ; i < 5000 ; i ++){
            try{
                sensors[i] = (Sensor)sensors[0].clone();
                sensors[i].setID(i+1);
            }catch (CloneNotSupportedException e){
                e.printStackTrace();
            }

        }

        for (int i = 0 ; i < 5000 ; i++) {
        //測試是否每個感測器ID如我們所想要的
            Assertions.assertEquals(i+1,sensors[i].getID());
        }

    }
}