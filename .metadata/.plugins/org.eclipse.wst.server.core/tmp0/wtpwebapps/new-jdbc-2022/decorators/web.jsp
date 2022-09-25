<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Trang chủ" /></title>
  	<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/template/web/assets/favicon.ico" />
	<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/template/web/css/styles.css" />
</head>
<body>
<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
    			<dec:body/>
    		</div>
    </section>
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	<!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script type="text/javascript" src="<c:url value='/template/web/js/scripts.js' />"></script>
</body>