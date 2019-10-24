#### 判斷括號()是否合法
#### "()" <-合法 
#### ")(" 或 "(" 或 ")" <- 非法 

    public static boolean IsVaild(string inputStr)
    {   
        //暫存區
        String SetStr ="";

        //看字串長度
        for(int i = 0; i < inputStr.length(); i++)
        {
            //假設一開始為左
            if(inputStr.substring(i)=="{")
            {
                //放入暫存
                SetStr += inputStr.substring(i);
            }
            //假設一開始為右
            else if(inputStr.substring(i)=="}")
            {
                //開始比對暫存
                if(SetStr == ""){
                    //假設暫存為空
                    return false;
                }
                else{
                    //放入暫存
                    SetStr += inputStr.substring(i);
                    //去掉合法組成的一對括號{}
                    SetStr = SetStr.Replace("{}","");
                }
            }
        }

        //判斷暫存是否還有字
        //因為會有單獨左括號的狀況
        //若無代表皆成對 -> true

        returm SetStr == "" ? true : false;
    }

#### 寫的相當醜但比較直觀
#### 概念成功理解後可再繼續重構

https://codertw.com/%E7%A8%8B%E5%BC%8F%E8%AA%9E%E8%A8%80/452693/    