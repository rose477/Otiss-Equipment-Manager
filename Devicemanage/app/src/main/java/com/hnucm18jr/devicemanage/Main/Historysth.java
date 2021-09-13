package com.hnucm18jr.devicemanage.Main;


import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

@Table(name = "findsth")
public class Historysth {
    @Column(name = "id", isId = true)
    private int id;


    @Column(name = "history")
    private String history;

    @Override
    public String toString() {
        return "Hotsth{" +
                "id=" + id +

                ", history='" + history + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}

