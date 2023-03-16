package web.fridge.domain.image;

import lombok.Getter;

import javax.persistence.*;


@Getter
@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long imageId;

    @Column(length = 64)
    private String name;

    @Column(length = 225)
    private String url;

    public Image initImage(String url, String name){
        this.url = url;
        this.name = name;
        return this;
    }

}
