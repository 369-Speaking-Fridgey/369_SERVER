package web.fridge.domain.post.dto;



import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostDetails {

    public String title;
    public String contents;
    public Long price;

    public LocalDateTime expiredAt;
    public LocalDateTime requestAt;
    public LocalDateTime exchangeAt;

    public String method;
    public String address;


}
