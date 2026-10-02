class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        para(0,0,"",n,res);
        return res;
    }
    public void para(int openP, int closeP, String s, int n, List<String> res){
        //Base Case
        if(openP == closeP && openP+closeP == 2*n){
            res.add(s);
            return;
        }                                                
        if(openP < n) para(openP+1, closeP, s + "(", n, res);
        if(closeP < openP) para(openP, closeP + 1, s + ")", n, res);
    }
}
