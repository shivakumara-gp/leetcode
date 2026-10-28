class Solution {
    public int ladderLength(String beginWord, String endWord,
                            List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int k = 0; k < size; k++) {
                String word = q.poll();

                if (word.equals(endWord)) {
                    return steps;
                }

                char[] arr = word.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String next = new String(arr);

                        if (set.contains(next)) {
                            q.offer(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            steps++;
        }

        return 0;
    }
}