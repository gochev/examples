package org.gochev.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Version;
import javax.validation.constraints.Size;
import javax.ws.rs.FormParam;

/**
 * Created by gochev on 10/6/15.
 */
@Entity
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Version
    private int version;

    @Column
    @Size(min = 8, max = 100)
    @FormParam("title")
    private String title;

    @FormParam("description")
    @Column(length = 3000)
    @Lob
    private String description;

    @FormParam("lecturer")
    @Column
    @Size(min = 8, max = 100)
    private String lecturer;

    public String getLecturer() {
        return lecturer;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Submission that = (Submission) o;

        if (version != that.version)
            return false;
        if (description != null ? !description.equals(that.description) : that.description != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (lecturer != null ? !lecturer.equals(that.lecturer) : that.lecturer != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + version;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        return result;
    }
}
