package swagger.test.dto;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class MemberDto {

    private int id;
    private String loginId;
    private String password;
    private String name;

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class req {
        private String loginId;
        private String password;
    }

    @Getter
    @Setter
    @Builder
    @ToString
    @AllArgsConstructor
    public static class res {
        private String name;
    }
}
