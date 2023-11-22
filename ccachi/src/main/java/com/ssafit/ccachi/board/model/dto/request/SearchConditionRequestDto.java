package com.ssafit.ccachi.board.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SearchConditionRequestDto {
    private String key = "none";
    private String word;
    private String orderBy = "none";
    private String orderByDir;
    private Integer objectStartNum;
    private Integer objectEndNum;

    public String toString() {
        return "SearchConditionRequestDto{" +
                "key='" + key + '\'' +
                ", word='" + word + '\'' +
                ", orderBy='" + orderBy + '\'' +
                ", orderByDir='" + orderByDir + '\'' +
                ", objectStartNum=" + objectStartNum +
                ", objectEndNum=" + objectEndNum +
                '}';
    }
}
