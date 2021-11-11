package ideas;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            //for each word in queue, turn into char[] cur
            for (int q=0; q < size; q++) {
                char[] cur = queue.poll().toCharArray();
                //for each char in the string, set to char tmp
                for (int i=0; i < cur.length; i++) {
                    char tmp = cur[i];
                    //for each char a->z, change the char tmp
                    //and check if it is in the wordlist (dict set)
                    for (char chr='a'; chr <= 'z'; chr++) {
                        cur[i] = chr;
                        String dest = new String(cur);
                        if (dict.contains(dest)) {
                            if (dest.equals(endWord)) return level+1;
                            queue.add(dest);
                            dict.remove(dest);
                        }
                    }
                    cur[i] = tmp;
                }
            }
            level++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordBank = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog" );
		
		System.out.println("number of sequences: " + ladderLength(beginWord, endWord, wordBank));
		
		
	}
}