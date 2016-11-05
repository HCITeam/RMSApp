package entity;

import javax.persistence.*;

/**
 * Created by mj on 16/11/6.
 */
@Entity
@Table(name = "project", schema = "rms" )
public class Project {
    private int id;
    private String name;
    private String describe;
    private int creater;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Basic
    @Column(name = "describe")
    public String getDescribe() {
        return describe;
    }
    
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    
    @Basic
    @Column(name = "creater")
    public int getCreater() {
        return creater;
    }
    
    public void setCreater(int creater) {
        this.creater = creater;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Project project = (Project) o;
        
        if (id != project.id) return false;
        if (creater != project.creater) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        if (describe != null ? !describe.equals(project.describe) : project.describe != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (describe != null ? describe.hashCode() : 0);
        result = 31 * result + creater;
        return result;
    }
}
