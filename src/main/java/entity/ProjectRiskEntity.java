package entity;

import javax.persistence.*;

/**
 * Created by 小春 on 2016/11/6.
 */
@Entity
@Table(name = "project_risk", schema = "rms", catalog = "")
public class ProjectRiskEntity {
    private int id;
    private Integer projectId;
    private String content;
    private Integer possibility;
    private Integer influenceLevel;
    private Integer threshold;
    private Integer creater;
    private Integer tracker;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "project_id", nullable = true)
    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "possibility", nullable = true)
    public Integer getPossibility() {
        return possibility;
    }

    public void setPossibility(Integer possibility) {
        this.possibility = possibility;
    }

    @Basic
    @Column(name = "influenceLevel", nullable = true)
    public Integer getInfluenceLevel() {
        return influenceLevel;
    }

    public void setInfluenceLevel(Integer influenceLevel) {
        this.influenceLevel = influenceLevel;
    }

    @Basic
    @Column(name = "threshold", nullable = true)
    public Integer getThreshold() {
        return threshold;
    }

    public void setThreshold(Integer threshold) {
        this.threshold = threshold;
    }

    @Basic
    @Column(name = "creater", nullable = true)
    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

    @Basic
    @Column(name = "tracker", nullable = true)
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

        ProjectRiskEntity that = (ProjectRiskEntity) o;

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
