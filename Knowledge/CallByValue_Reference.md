####
#### Call By Value / Call By Reference
####

註 : javascript 的 陣列 物件都是 Call By Reference

傳值 傳址的差異舉例



        protected void setNum(int inputNum)
        {
            inputNum *= inputNum;
        }

        protected void setNumref(ref int inputNum)
        {
            inputNum *= inputNum;
        }
        
        public void TestMethod_value()
        {
            int _Num;
            //Call by Value
            //傳遞參數時，會將此參數複製再傳給方法
            A.S1 = 20;
            _Num = A.S1;
            setNum(_Num);

            Console.WriteLine(" _Num : " + _Num + "\n");   
            //  20
        }        

        public void TestMethod_reference()
        {
            int _Num;
            //Call by Reference
            
            A.S1 = 20;
            _Num = A.S1;
            setNumref(ref _Num);
            // C# 的 傳址 會用上 ref

            Console.WriteLine(" _Num : " + _Num + "\n");    
            //  400
        }

        // 註 : 珍惜生命 遠離指標