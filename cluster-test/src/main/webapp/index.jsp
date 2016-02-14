<html>
    <head>
        <title>Mastering JBoss Enterprise Application Platform 7</title>
    </head>
    <body>
        <h1>Mastering JBoss Enterprise Application Platform 7</h1>
        <h2>Cluster Test</h2>
        <h3>Refresh the page to increment the number of visits!</h3>
<%
    Object sessAttr = session.getAttribute("visits");
    int visits = sessAttr == null ? 1 : Integer.valueOf(sessAttr+"");
    System.out.println("********************************+");
    System.out.println("Number of visits: " + visits);
    System.out.println("********************************+");
%>
        <h3>Current number of visits: <%=visits%></h3>
<%
    session.setAttribute("visits", ++visits);
%>
    </body>
</html>
