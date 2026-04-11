// Anagram
// An anagram is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String word:strs){
            char chars[]= word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            //adding to map
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
        
    }
}

