package Medium;
public class Count_primes {
    public int countPrimes(int n) {
        //This method get TLE
        // ArrayList<Integer> k=new ArrayList<>();
        // for(int i=2;i<n;i++){
        //     boolean c=true;
        //     for(int j=0;c && j<k.size() && k.get(j)<=Math.sqrt(i);j++) if(i%k.get(j)==0) c=false;
        //     if(c) k.add(i);
        // }
        // return k.size();
//-----------------------------------------------------------------------------------------------------------
        //Using Sieve of Eratosthenes - O(maxR * log (log maxR)))
        int count=0;
        boolean[] iP=new boolean[n];
        if(n<2) return 0;
        iP[0]=true;
        iP[1]=true;
        for(int i=2;i<n;i++){
            if(!iP[i]){
                count++;
                int j=i*2;
                while(j<n) {
                    iP[j]=true; 
                    j+=i;
                }
            }
        }
        return count;
    }
}
