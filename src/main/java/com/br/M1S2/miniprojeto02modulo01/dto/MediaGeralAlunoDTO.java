package com.br.M1S2.miniprojeto02modulo01.dto;

import lombok.Data;

@Data
public class MediaGeralAlunoDTO {
    private Double mediaGeral;

    public Double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(Double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }
}