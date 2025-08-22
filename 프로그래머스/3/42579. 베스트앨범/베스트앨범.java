import java.util.*;

class Song{
    int index;
    int plays;
    
    public Song(int index, int plays){
        this.index = index;
        this.plays = plays;
    }
    
    public int getIndex(){
        return index;
    }
    
    public int getPlays(){
        return plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> genresPlaysMap = new HashMap<String, Integer>();
        HashMap<String, ArrayList<Song>> songMap = new HashMap<String, ArrayList<Song>>();
        
        for(int i = 0; i < genres.length; i++){
            genresPlaysMap.put(genres[i], genresPlaysMap.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!songMap.containsKey(genres[i])) {
                songMap.put(genres[i], new ArrayList<Song>());
                songMap.get(genres[i]).add(new Song(i, plays[i]));
            }else{
                songMap.get(genres[i]).add(new Song(i, plays[i]));
            }
        }
        List<String> sortedGenres = new ArrayList<>(genresPlaysMap.keySet());
        Collections.sort(sortedGenres, (g1, g2) -> genresPlaysMap.get(g2) - genresPlaysMap.get(g1));
        
        for(ArrayList<Song> songs : songMap.values()){
            // Collections.sort(songs, (s1,s2) -> s2.plays - s1.plays);
            songs.sort(Comparator.comparing(Song::getPlays).reversed().thenComparing(Song::getIndex));
        }
        
        for(String gen :sortedGenres){
            ArrayList<Song> songs = songMap.get(gen);
            for(int i = 0; i < songs.size(); i++){
                if(i == 2){
                    break;
                }
                result.add(songs.get(i).index);
            }
        }
        
        answer = new int[result.size()];
        for(int i = 0; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}