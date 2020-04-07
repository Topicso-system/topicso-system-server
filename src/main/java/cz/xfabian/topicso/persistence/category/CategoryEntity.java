package cz.xfabian.topicso.persistence.category;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category")
public class CategoryEntity {

    @Id
    @Access(AccessType.PROPERTY)
    private int id;

    private String name;

    private String picture;

    @ManyToOne(fetch= FetchType.LAZY)
    private CategoryEntity parent;

    @Column(name = "order_number")
    private int order;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public CategoryEntity getParent() {
        return parent;
    }

    public void setParent(CategoryEntity parent) {
        this.parent = parent;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return id == that.id &&
                order == that.order &&
                Objects.equals(name, that.name) &&
                Objects.equals(picture, that.picture) &&
                Objects.equals(parent, that.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, picture, parent, order);
    }
}
