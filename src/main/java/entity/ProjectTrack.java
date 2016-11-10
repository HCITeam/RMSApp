package entity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by mj on 16/11/6.
 */
@Entity
@Table(name = "project_track", schema = "rms")
public class ProjectTrack {
    private int id;
    private Integer riskId;
    private String risk;
    private Integer state;
    private String cause;
    private Integer tracker;
    private Timestamp updateTime;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Basic
    @Column(name = "risk_id")
    public Integer getRiskId() {
        return riskId;
    }
    
    public void setRiskId(Integer riskId) {
        this.riskId = riskId;
    }
    
    @Basic
    @Column(name = "risk")
    public String getRisk() {
        return risk;
    }
    
    public void setRisk(String risk) {
        this.risk = risk;
    }
    
    @Basic
    @Column(name = "state")
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    @Basic
    @Column(name = "cause")
    public String getCause() {
        return cause;
    }
    
    public void setCause(String cause) {
        this.cause = cause;
    }
    
    @Basic
    @Column(name = "tracker")
    public Integer getTracker() {
        return tracker;
    }
    
    public void setTracker(Integer tracker) {
        this.tracker = tracker;
    }
    
    @Basic
    @Column(name = "update_time")
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
        
        ProjectTrack that = (ProjectTrack) o;
        
        if (id != that.id) return false;
        if (riskId != null ? !riskId.equals(that.riskId) : that.riskId != null) return false;
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
        result = 31 * result + (riskId != null ? riskId.hashCode() : 0);
        result = 31 * result + (risk != null ? risk.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (cause != null ? cause.hashCode() : 0);
        result = 31 * result + (tracker != null ? tracker.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        return result;
    }
}
