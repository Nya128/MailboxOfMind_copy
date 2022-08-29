package mailbox.core.config;

import lombok.Getter;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 : 요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request 오류
     */
    // Common
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),


    POST_POSTS_INVALID_CONTENTS(false, 2018, "게시글 내용의 글자 수를 확인해주세요."),
    POST_POSTS_EMPTY_IMGURL(false, 2019, "게시글의 이미지를 입력해주세요."),

    POSTS_EMPTY_POST_ID(false, 2020, "게시물 아이디 값을 확인해주세요."),

    /**
     * 3000 : Response 오류
     */
    // Common
    RESPONSE_ERROR(false, 3000, "값을 불러오는데 실패하였습니다."),


    MODIFY_FAIL_POST(false, 3020, "게시물 수정을 실패했습니다."),
    DELETE_FAIL_POST(false, 3021, "게시물 삭제를 실패했습니다."),



    /**
     * 4000 : Database, Server 오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다.");



    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message) {
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
