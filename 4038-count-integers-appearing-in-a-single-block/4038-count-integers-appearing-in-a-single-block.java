class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        HashSet<Integer> invalid=new HashSet<>();
        int n=nums.length;
        
        for(int i=0;i<n;i++){
            if(invalid.contains(nums[i])){
            continue;
        }
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }
                else{
                    int prevind=map.get(nums[i]);
                    if(prevind!=i-1){
                        
                        map.remove(nums[i]);
                        invalid.add(nums[i]);
                    }else{
                        map.put(nums[i],i);
                    }
                }
            
            
            
        }
        return map.size();
    }
}