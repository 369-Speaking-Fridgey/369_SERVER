package web.fridge.global.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import web.fridge.global.enums.enumMappers.EnumMapperType;

@RequiredArgsConstructor
public enum Status implements EnumMapperType {


    RESERVED("거래 중"),
    INPROGRESS("거래 요청 중"),
    COMPLETED("거래 완료");

    @Getter
    private final String title;

    @Override
    public String getCode() {
        return name();
    }
}
