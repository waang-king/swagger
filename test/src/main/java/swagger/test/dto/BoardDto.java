package swagger.test.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class BoardDto {

    private int idx;
    private String title;
    private String contents;
    private String image;
    private String delYn;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class req {
        private int idx;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class req2 {
        private String title;
        private String contents;
        private String image;
        private String delYn;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class res {
        private String title;
        private String contents;
        private String image;
        private String delYn;
    }
}
