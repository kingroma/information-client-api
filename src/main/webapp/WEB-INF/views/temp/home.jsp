<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>

</body>
<script>

function getCtx(){
	var hostIndex = location.href.indexOf( location.host ) + location.host.length;
	return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1)) ;
}

function temp(){
	
	var selectedValue = "";
	//파라미터 값 생성 - 선택된 항목의 id값 가져오기
	$("input[id=checkbox]:checked").each(function() {
		selectedValue = selectedValue + $(this).val() + ",";
	});
	
	$.ajax({
		type : "GET",
		url : "${ctx}/content/new/vod/data/check",
		data : {
			checkedStr : selectedValue
		},
		error : function(xhr, status, error) {
			alert(error);
			// location.reload();
		},
		success : function(data) {
			alert(data);
			// location.reload();
		}
	});
}



</script>
</html>


