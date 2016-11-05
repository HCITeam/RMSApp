package entity;

import javax.persistence.*;

/**
 * Created by mj on 16/11/6.
 */
@Entity
@Table(name = "project_risk", schema = "rms")
public class ProjectRisk {
    private int id;
    private Integer projectId;
    private String content;
    private Integer possibility;
    private Integer influenceLevel;
    private Integer threshold;
    private Integer creater;
    private Integer tracker;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "project_id")
    public Integer getProjectId() {
        return projectId;
    }
    
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    
    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    @Basic
    @Column(name = "possibility")
    public Integer getPossibility() {
        return possibility;
    }
    
    public void setPossibility(Integer possibility) {
        this.possibility = possibility;
    }
    
    @Basic
    @Column(name = "influenceLevel")
    public Integer getInfluenceLevel() {
        return influenceLevel;
    }
    
    public void setInfluenceLevel(Integer influenceLevel) {
        this.influenceLevel = influenceLevel;
    }
    
    @Basic
    @Column(name = "threshold")
    public Integer getThreshold() {
        return threshold;
    }
    
    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }
    
    @Basic
    @Column(name = "creater")
    public Integer getCreater() {
        return creater;
    }
    
    public void setCreater(Integer creater) {
        this.creater = creater;
    }
    
    @Basic
    @Column(name = "tracker")
    public Integer getTracker() {
        return tracker;
    }
    
    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        ProjectRisk that = (ProjectRisk) o;
        
        if (id != that.id) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (possibility != null ? !possibility.equals(that.possibility) : that.possibility != null) return false;
        if (influenceLevel != null ? !influenceLevel.equals(that.influenceLevel) : that.influenceLevel != null)
            return false;
        if (threshold != null ? !threshold.equals(that.threshold) : that.threshold != null) return false;
        if (creater != null ? !creater.equals(that.creater) : that.creater != null) return false;
        if (tracker != null ? !tracker.equals(that.tracker) : that.tracker != null) return false;
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (possibility != null ? possibility.hashCode() : 0);
        result = 31 * result + (influenceLevel != null ? influenceLevel.hashCode() : 0);
        result = 31 * result + (threshold != null ? threshold.hashCode() : 0);
        result = 31 * result + (creater != null ? creater.hashCode() : 0);
        result = 31 * result + (tracker != null ? tracker.hashCode() : 0);
        return result;
    }
}
