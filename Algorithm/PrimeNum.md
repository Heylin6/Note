#### 判斷1到100有幾個質數

### 只能被 1 跟 自己整除 才是質數
### 所以被整除只有兩個數 就是質數


    public static ArrayList PrimeCount(int MaxNum)
    {    
        // i 為第一層
        // j 為第二層
        // Array紀錄質數

        int counter = 0;
        string res = "";

        for(int i=1;i<=MaxNum;i++)
        {
            for(int j=1;j<=MaxNum;j++)
            {
                int _Num = i % j; 
                if(_Num==0)
                {
                    counter++;
                }
            }
            if(counter==2)
            {
                // 第二層跑完後
                // 1 跟自己 所以2個數 counter == 2
                
                res += i.ToString()+",";                
            }

            //第二層跑完 counter 要歸0
            counter = 0;
        }

        return res;
    }

    #### 參考頁面 ####

    http://www.programmer-club.com.tw/ShowSameTitleN/java/18236.html