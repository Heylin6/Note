
### 封裝 繼承 多型 ###

## 封裝

get set

    public class Heylin
    {
        private int age;

        public int getage(){ return age;}
        public void setAge(int _age) throws Exception{ this.age=_age; }
    }

## 多型

方法名相同，引數不一樣

    public class Heylin()
    extends Human
    {
        public void IsAct() throws Exception{

        }

        public void IsAct(String Str1){

        }

        public String IsAct(String Str1, String Str2)
        {
            return "";
        }
    }

## 繼承

程式碼重用方便

有class繼承
跟abstract class繼承(抽象)
還有interface繼承(繼承)

    class Seafoods
    {
        private void eat(){}
        public void swin(){}
    }

    public class Heylin
    extends Seafoods
    {
        public void swin(){}    //方法重寫
        public void swin(String str)){}    //方法過載
    }

#### 參考頁面 ####

https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/528939/