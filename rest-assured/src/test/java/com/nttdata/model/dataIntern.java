package com.nttdata.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id","petId","quantity","shipDate","status","complete"})
public class dataIntern {
    private int dataOrderId;

    public int getDataOrderId() {
        return dataOrderId;
    }

    public void setDataOrderId(int dataOrderId) {
        this.dataOrderId = dataOrderId;
    }
}
