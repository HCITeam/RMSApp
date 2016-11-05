package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by 小春 on 2016/11/6.
 */
@Entity
@Table(name = "project_track", schema = "rms", catalog = "")
public class ProjectTrackEntity {
    private int id;
    private Integer projectId;
    private String risk;
    private Integer state;
    private String cause;
    private Integer tracker;
    private Timestamp updateTime;

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
    @Column(name = "risk", nullable = true, length = 255)
    public String getRisk() {
        return risk;
    }

    public void setRisk(String risk) {
        this.risk = risk;
    }

    @Basic
    @Column(name = "state", nullable = true)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "cause", nullable = true, length = 255)
    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    @Basic
    @Column(name = "tracker", nullable = true)
    public Integer getTracker() {
        return tracker;
    }

    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }

    @Basic
    @Column(name = "update_time", nullable = true)
    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjectTrackEntity that = (ProjectTrackEntity) o;

        if (id != that.id) return false;
        if (projectId != null ? !projectId.equals(that.projectId) : that.projectId != null) return false;
        if (risk != null ? !risk.equals(that.risk) : that.risk != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (cause != null ? !cause.equals(that.cause) : that.cause != null) return false;
        if (tracker != null ? !tracker.equals(that.tracker) : that.tracker != null) return false;
        if (updateTime != null ? !updateTime.equals(that.updateTime) : that.updateTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectId != null ? projectId.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + (tracker != null ? tracker.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
