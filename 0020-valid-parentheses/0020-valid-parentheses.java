class Solution {
    public boolean isValid(String s) {
        int [] arr = new int[3];
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('||s.charAt(i)=='{'||s.charAt(i)=='[')
                st.push(s.charAt(i));
            if(s.charAt(i)==')'){
                if(!st.empty() && st.peek()=='(')
                    st.pop();
                else 
                    return false;  
            }
            else if(s.charAt(i)==']'){
                if(!st.empty() && st.peek()=='[')
                    st.pop();
                else 
                    return false;  
            }
            else if(s.charAt(i)=='}'){
                if(!st.empty() && st.peek()=='{')
                    st.pop();
                else 
                    return false;  
            }
               
        }
        if(st.size()==0)
            return true;
        return false;
    }
        
}