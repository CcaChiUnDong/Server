package com.ssafit.core.board.model.dto.request;

import java.util.List;

import com.ssafit.core.board.model.entity.BoardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class BoardModifyRequest {

    private String subject;
    private String content;
    private BoardType boardType;
    private List<String> imageUrls;
}
