package com.sf.utils.sla.entity;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author lash
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 7229631406248028347L;

    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, insertable = true, updatable = false)
    private Long id;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BaseEntity)) {
            return false;
        }
        BaseEntity that = (BaseEntity) object;
        if ((this.id == null) || (that.getId() == null)
                || (!this.id.equals(that.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 13;
        hashCode = 129 * hashCode + (this.id == null ? 0 : this.id.hashCode());
        return hashCode;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append(getClass().getName());
        result.append(getClass().getSimpleName()).append(" {");
        result.append(newLine);

        Field[] fields = getClass().getDeclaredFields();

        for (Field field : fields)
            if (!Modifier.isStatic(field.getModifiers())) {
                result.append("  ");
                try {
                    result.append(field.getName());
                    result.append(": ");

                    String name = field.getName();
                    String prefix = "get";
                    if (field.getType().isAssignableFrom(Boolean.class)) {
                        prefix = "is";
                    }
                    name = name.substring(0, 1).toUpperCase()
                            + name.substring(1);

                    result.append(getClass().getMethod(prefix + name,
                            new Class[0]).invoke(this, new Object[0]));
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                result.append(newLine);
            }
        result.append("}");

        return result.toString();
    }
}