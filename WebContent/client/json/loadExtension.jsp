<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@taglib prefix="function" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="list" value="${sessionScope.extensionList }"></c:set>
<c:set var="len" value="${function:length(list) }"></c:set>
[<c:forEach items="${sessionScope.extensionList }" var="i" varStatus="j">
		{"extensionId":"${i.extensionId }","extensionName":"${i.extensionName }"}<c:if test="${len ne j.count }">,</c:if>
	</c:forEach>]