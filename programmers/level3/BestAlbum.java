import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> count = new HashMap<>();
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i < genres.length; i++) {
            count.put(genres[i], count.getOrDefault(genres[i], 0) + plays[i]);
            map.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i);
        }

        for(List<Integer> list : map.values()) {
            list.sort((o1, o2) -> plays[o2] - plays[o1]);
        }

        List<String> sortedGenres = new ArrayList<>(count.keySet());
        sortedGenres.sort((o1, o2) -> count.get(o2) - count.get(o1));

        for (String genre : sortedGenres) {
            List<Integer> songs = map.get(genre);
            answer.add(songs.get(0));
            if (songs.size() > 1) {
                answer.add(songs.get(1));
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
