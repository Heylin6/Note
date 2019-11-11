#### 給一組整數陣列 , 並提供目標值
#### 如果兩數相加等於目標值 則返回該兩數所在的陣列位置

#### ex. nums = [2, 7, 11, 15], target = 9
#### 其中 nums[0] + nums[1] = 2 + 7 = 9
#### 所以返回 [0,1]

    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> map = new HashMap();
        for(int i =0; i <nums.length;i==)
        {
            //將陣列加上索引 , 所以用map轉成(數字,第幾位)
            map.put(nums[i], i);
        }

        //再用陣列比對map一次            
        for(int i =0; i <nums.length;i==)
        {
            //目標數字 減去 當下數字 為 符合目標位數的第二個數
            //ex. target = 9 , 若 nums[i] = 1 ,則要尋找的就是 8
            
            int complement = target - nums[i];

            //尋找key為第二的數的陣列 , 而且不是當下跑的位置
            //返回值則為 i : 當下位置 ,  map.get(complement) : Map符合該數字的位置

            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }




    }

#### 參考頁面 ####

https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-2/