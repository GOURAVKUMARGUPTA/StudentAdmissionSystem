package com.dataOperation;

import com.entities.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class StateDataOperation {

    private Connection con;

    public StateDataOperation(Connection con) {
        this.con = con;
    }

//    Fetching All State Start
    public ArrayList<State> getAllState() {
        ArrayList<State> stateList = new ArrayList<>();
        State state = null;
        try {

            String query = "SELECT * FROM state";
            Statement stmt = con.createStatement();
            ResultSet set=stmt.executeQuery(query);
            while (set.next()) {                
                state=new State();
                state.setStateId(set.getInt("stateId"));
                state.setState(set.getString("state"));
                stateList.add(state);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stateList;
    }
//    Fetching All State Stop
}
