package model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class DataModel {
    @Expose
    private String name;
    @Expose
    private String header;
    @Expose
    private String footer;
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    public DataModel withId(int id) {
        this.id = id;
        return this;
    }

    public DataModel withName(String name) {
        this.name = name;
        return this;
    }

    public DataModel withHeader(String header) {
        this.header = header;
        return this;
    }

    public DataModel withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return getId() == dataModel.getId()
                && Objects.equals(getName(), dataModel.getName())
                && Objects.equals(getHeader(), dataModel.getHeader())
                && Objects.equals(getFooter(), dataModel.getFooter());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getHeader(), getFooter(), getId());
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "GroupData{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}
