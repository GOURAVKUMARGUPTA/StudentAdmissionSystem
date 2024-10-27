
package com.entities;

public class District {
    private int districtId;
    private int stateId;
    private String district;

    public District() {
    }

    public District(int districtId, int stateId, String district) {
        this.districtId = districtId;
        this.stateId = stateId;
        this.district = district;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    public int getStateId() {
        return stateId;
    }

    public void setStateId(int stateId) {
        this.stateId = stateId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
    
    
}
