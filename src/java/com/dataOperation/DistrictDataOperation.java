
package com.dataOperation;

import com.entities.District;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DistrictDataOperation {
    private Connection con;

    public DistrictDataOperation(Connection con) {
        this.con = con;
    }
    
//    Fetching District By StateId Start
    public ArrayList<District> getDistrictByStateId(int stateId)
    {
        ArrayList<District> districtList=new ArrayList<>();
        District district=null;
        try {
            String query="SELECT * FROM district WHERE stateId=?";
            PreparedStatement pstmt=con.prepareStatement(query);
            pstmt.setInt(1, stateId);
            ResultSet set=pstmt.executeQuery();
            while (set.next()) {                
                district=new District();
                district.setDistrictId(set.getInt("districtId"));
                district.setStateId(set.getInt("stateId"));
                district.setDistrict(set.getString("district"));
                districtList.add(district);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districtList;
    }
//    Fetching District By StateId Stop
}
