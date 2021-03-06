package entity;

import javax.persistence.*;

/**
 * Created by mj on 16/11/6.
 */
@Entity
@Table(name = "project_user_relationship", schema = "rms" )
public class ProjectUserRelationship {
    private int id;
    private Integer userId;
    private Integer projectId;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "user_id")
    public Integer getUserId() {
        return userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    @Basic
    @Column(name = "project_id")
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ProjectUserRelationship that = (ProjectUserRelationship) o;
        
        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        return result;
    }
}
