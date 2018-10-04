package ru.sgorshkov.webapp.model;

import java.util.List;

public class ResponseObject<T> {
    private Iterable<T> data;
    private long total;

    public ResponseObject(Iterable<T> data, long total) {
        this.data = data;
        this.total = total;
    }

    public Iterable<T> getData() {
        return data;
    }

    public void setData(Iterable<T> data) {
        this.data = data;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
