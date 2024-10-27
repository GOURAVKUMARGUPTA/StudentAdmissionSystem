<%-- 
    Document   : fetchDistrict
    Created on : 28 Aug, 2021, 6:55:18 PM
    Author     : URL INSTITUTE
--%>


<%@page import="com.entities.District"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.helper.ConnectionProvider"%>
<%@page import="com.dataOperation.DistrictDataOperation"%>
<%
    int stateId=Integer.parseInt(request.getParameter("stateId"));
    DistrictDataOperation districtData=new DistrictDataOperation(ConnectionProvider.getConnection());
    ArrayList<District> districtList =districtData.getDistrictByStateId(stateId);
    %>
    <option selected disabled value="">---Select District---</option>
    <%
    for (District district : districtList) {
            %>
            <option><%=district.getDistrict() %></option>
            <%
        }
%>