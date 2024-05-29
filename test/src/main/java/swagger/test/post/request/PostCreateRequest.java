package swagger.test.post.request;

import lombok.Data;

@Data
public class PostCreateRequest {
    private String title;
    private String content;
}