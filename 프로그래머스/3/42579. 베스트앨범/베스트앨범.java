import java.util.*;

class Solution {
    
    static class Song {
        public int id;
        public int plays;
        
        public Song(int id, int plays) {
            this.id = id;
            this.plays = plays;
        } 
    }
    
    static class Genre {
        public String name;
        public TreeSet<Song> songs;
        public int totalPlays;
        
        public Genre(String name) {
            this.name = name;
            this.songs = new TreeSet<>((s1, s2) ->{
                if(s1.plays != s2.plays) {
                    return s2.plays - s1.plays;
                }
                return s1.id - s2.id;
            });
            this.totalPlays = 0;
        }
        
        public void addSong(Song song) {
            totalPlays += song.plays;
            songs.add(song);
        }
        
        public List<Integer> getTop2SongIds() {
            List<Integer> songIds = new ArrayList<>();
            int count = 0;
            for(Song song : this.songs) {
                if(count >= 2) break;
                songIds.add(song.id);
                count++;
            }
            return songIds;
        }
    }
    
    static class Album {
        TreeSet<Genre> genres;
        
        public Album() {
            genres = new TreeSet<>((g1, g2) -> g2.totalPlays - g1.totalPlays); 
        }
        
        public void addGenre(Genre genre) {
            genres.add(genre);
        }
        
        public List<Integer> getSongIds() {
            List<Integer> songIds = new ArrayList<>();
            for(Genre genre : this.genres) {
                songIds.addAll(genre.getTop2SongIds());
            }
            return songIds;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Genre> genreMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++) {
            String genreName = genres[i];
            Song song = new Song(i, plays[i]);
            if(genreMap.containsKey(genreName)) {
                genreMap.get(genreName).addSong(song);
                continue;
            }
            Genre genre = new Genre(genreName);
            genre.addSong(song);
            genreMap.put(genreName, genre);
        }
        Album album = new Album();
        for(String genreName : genreMap.keySet()) {
            Genre genre = genreMap.get(genreName);
            album.addGenre(genre);
        }
        List<Integer> songIds = album.getSongIds();
        int[] answer = new int[songIds.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = songIds.get(i);
        }
        return answer;
    }
}