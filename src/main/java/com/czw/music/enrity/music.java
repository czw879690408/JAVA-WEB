package com.czw.music.enrity;


import org.springframework.context.annotation.Bean;





public class music {
    private Integer musicId;
    private String  musicName;
    private String  musicDirectory;
    private Integer musicType;


    @Override
    public String toString() {
        return "music{" +
                "musicId=" + musicId +
                ", musicName='" + musicName + '\'' +
                ", musicDirectory='" + musicDirectory + '\'' +
                ", musicType=" + musicType +
                '}';
    }


    public Integer getMusicId() {
        return musicId;
    }

    public void setMusicId(Integer musicId) {
        this.musicId = musicId;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public String getMusicDirectory() {
        return musicDirectory;
    }

    public void setMusicDirectory(String musicDirectory) {
        this.musicDirectory = musicDirectory;
    }

    public Integer getMusicType() {
        return musicType;
    }

    public void setMusicType(Integer musicType) {
        this.musicType = musicType;
    }
}
