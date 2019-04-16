package com.robots

class Table {
    private int width
    private int length

    Table(w = 5,l = 5) {
        assert w > 0 && l > 0
        width = w
        length = l
    }

    public int getWidth() {
        width
    }

    public int getLength() {
        length
    }
}
