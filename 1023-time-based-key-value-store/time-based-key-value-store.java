class Pair{
    String value;
    int time;
    public Pair(String value,int time){
        this.value=value;
        this.time=time;
    }
}
class TimeMap {
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            List<Pair> temp=map.get(key);
            temp.add(new Pair(value,timestamp));
        }else{
            Pair it = new Pair(value, timestamp);
            List<Pair> temp = new ArrayList<>();
            temp.add(it);
            map.put(key, temp);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Pair> temp= map.get(key);

        int r=temp.size()-1;
        int l=0;
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;

            if(temp.get(mid).time <= timestamp){
                ans=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        if (ans == -1) return "";
        return temp.get(ans).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */