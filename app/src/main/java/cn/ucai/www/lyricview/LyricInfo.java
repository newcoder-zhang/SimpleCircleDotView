package cn.ucai.www.lyricview;

import java.util.List;

/**
 * Created by Administrator on 2016/9/5.
 */
public class LyricInfo {

    private List<LyricLine> song_lines;
    private String song_artist;
    private String song_title;
    private String song_album;
    private long song_offset;

    public List<LyricLine> getSong_lines() {
        return song_lines;
    }

    public void setSong_lines(List<LyricLine> song_lines) {
        this.song_lines = song_lines;
    }

    public String getSong_artist() {
        return song_artist;
    }

    public void setSong_artist(String song_artist) {
        this.song_artist = song_artist;
    }

    public String getSong_title() {
        return song_title;
    }

    public void setSong_title(String song_title) {
        this.song_title = song_title;
    }

    public String getSong_album() {
        return song_album;
    }

    public void setSong_album(String song_album) {
        this.song_album = song_album;
    }

    public long getSong_offset() {
        return song_offset;
    }

    public void setSong_offset(long song_offset) {
        this.song_offset = song_offset;
    }
}
