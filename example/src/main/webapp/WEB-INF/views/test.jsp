<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<title>XRoad client test</title>
		<style type="text/css">
			.test-name { text-align: right; }
			.test-ok { font-weight: bold; color: green; }
			.test-failed { font-weight: bold; color: red; }
		</style>
	<head>
	<body>
		<table>
			<tr>
				<td class="test-name">AttachmentEcho test:</td>
				<td class="${attachmentEchoResult eq 'OK' ? 'test-ok' : 'test-failed'}"><c:out value="${attachmentEchoResult}" /></td>
			</tr>
			<tr>
				<td class="test-name">Echo test:</td>
				<td class="${attachmentEchoResult eq 'OK' ? 'test-ok' : 'test-failed'}"><c:out value="${echoResult}" /></td>
			</tr>
			<tr>
				<td class="test-name">AxisEcho test:</td>
				<td class="${axisEchoResult eq 'OK' ? 'test-ok' : 'test-failed'}"><c:out value="${axisEchoResult}" /></td>
			</tr>
		</table>
		Check server console for XRoad requests/responses
	</body>
</html>