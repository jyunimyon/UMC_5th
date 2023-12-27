package umc.jyuny_springprj.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.jyuny_springprj.apiPayload.code.BaseCode;
import umc.jyuny_springprj.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess","code","message","result"})
//JSON으로 변환될 때 속성들의 순서를 정의
public class ApiResponse<T> {
        @JsonProperty("isSuccess")
        private final Boolean isSuccess;
        private final String code;
        private final String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private T result;
            public static <T> ApiResponse<T> onSuccess(T result){
                return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
            }

            public static <T> ApiResponse<T> of(BaseCode code, T result){
                return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
            }

        public static <T> ApiResponse<T> onFailure(String code, String message, T data){
                return new ApiResponse<>(false,code,message,data);
        }
}
