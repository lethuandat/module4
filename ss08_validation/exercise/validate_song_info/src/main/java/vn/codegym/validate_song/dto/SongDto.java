package vn.codegym.validate_song.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SongDto {
    private Integer id;

    @NotBlank
    @Size(max = 800)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String name;

    @NotBlank
    @Size(max = 300)
    @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$", message = "Not valid")
    private String artist;

    @NotBlank
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z,\\s\\d\\p{L}]+$", message = "Not valid")
    private String type;

    public SongDto() {
    }

    public SongDto(Integer id, @NotBlank @Size(max = 800) @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$") String name, @NotBlank @Size(max = 300) @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$") String artist, @NotBlank @Size(max = 1000) @Pattern(regexp = "^[a-zA-Z\\s\\d\\p{L}]+$") String type) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
