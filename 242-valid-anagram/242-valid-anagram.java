class Solution {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false; 
        
        String[] ana = s.split("");
        String[] gram = t.split("");
        
        Arrays.sort(ana);
        Arrays.sort(gram);
        
        return (String.join("", ana).equals(String.join("", gram)));
    }
}