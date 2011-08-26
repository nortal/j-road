<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head><title>X-tee client test</title><head>
<body>
	<form method="post">
		<input type="submit" value="Send request" />
	</form>
	<pre><c:out value="${testresult}" /></pre>
	<br/>
</body>
</html>