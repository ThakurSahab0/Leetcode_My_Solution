public class Solution {
public int minDistance(String word1, String word2) {
char[] w1 = word1.toCharArray(); char[] w2 = word2.toCharArray();
int m = word1.length(); int n= word2.length();
if(m==0) return n; if(n==0) return m;
int[][] dp = new int[m][n]; for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
return f(m-1,n-1,w1,w2,dp);
}
public static int f(int i1, int i2, char[] w1, char[] w2,int[][] dp){
if(i1==-1 && i2==-1) return 0;
if(i1==-1) return i2+1; //implicitly i2!=-1 returns num of remaining chars in w2, insert em in w1
if(i2==-1) return i1+1; //implicitly i1!=-1 returns rem chars in w1,delete em in w1
if(dp[i1][i2]!=-1) return dp[i1][i2];
int same,insert,delete,replace; same=insert=delete=replace= (int)1e9;
if(w1[i1]==w2[i2]) same = f(i1-1, i2-1, w1, w2,dp);
else{
insert = 1 + f(i1, i2-1, w1, w2,dp);
delete = 1 + f(i1-1, i2, w1,w2,dp);
replace = 1 + f(i1-1,i2-1,w1,w2,dp);
}
return dp[i1][i2] = Math.min(Math.min(insert,delete), Math.min(replace,same));
}
}