<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="mytags"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <META http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <mytags:style />
        <title><tiles:insertAttribute name="title" ignore="true" /></title>
    </head>
    <body>

        <!-- page -->
        <div class="emds-page">

            <!-- header -->
            <tiles:insertAttribute name="header" />

            <!-- body -->
            <div class="emds-body">

                <!-- panel -->
                <tiles:insertAttribute name="panel" />

                <!-- main content -->
                <div class="emds-content">

                    <!-- content caption -->
                    <div class="emds-content-title">
                        <span class="emds-content-title-text"><tiles:insertAttribute name="contentCaption" ignore="true"/></span>
                    </div>

                    <!-- content -->
                    <tiles:insertAttribute name="mainContent" />

                </div>
            </div>


            <!-- footer -->
            <tiles:insertAttribute name="footer" />

        </div>

        <!-- scripts -->
        <tiles:insertAttribute name="scripts" />

    </body>
</html>