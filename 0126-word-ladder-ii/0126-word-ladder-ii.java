class Solution {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> parent = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans.clear();
        parent.clear();
        HashSet<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        if (!words.contains(endWord)) {
            return ans;
        }
        Queue<String> q = new LinkedList<>();

        q.offer(beginWord);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            Set<String> usedOnLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {

                String word = q.poll();
                char[] arr = word.toCharArray();
                for (int j = 0; j < arr.length; j++) {
                    char orginal = arr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == orginal) {
                            continue;
                        }
                        arr[j] = k;

                        String newWord = new String(arr);
                        if (words.contains(newWord) || usedOnLevel.contains(newWord)) {

                            parent.computeIfAbsent(
                                    newWord, x -> new ArrayList<>()).add(word);
                            if (!usedOnLevel.contains(newWord)) {

                                usedOnLevel.add(newWord);
                                q.offer(newWord);
                            }
                            if (newWord.equals(endWord)) {
                                found = true;
                            }
                        }
                    }
                    arr[j] = orginal;
                }

            }
            words.removeAll(usedOnLevel);

        }
        if(found){
            List<String> path=new ArrayList<>();
            path.add(endWord);
            dfs(endWord,beginWord,path);
        }
        return ans;
    }
    public void dfs(String word,String beginword,List<String> path){
        if(word.equals(beginword)){
            List<String> temp=new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        for(String parent:parent.getOrDefault(word,new ArrayList<>())){
            path.add(parent);
            dfs(parent,beginword,path);
            path.remove(path.size()-1);
        }
    }
}