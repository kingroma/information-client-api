<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Program</title>
<style>
	body table {
		margin: 0px ;
		padding: 0px ;	
	}
	thead tr td{
		border: 2px solid black;
	}
	
	.programDetailTable tbody > tr > td {
		border: 1px solid black;
		text-align: center
	}
	
	.programDetailInput {
		width: 97%
	}
</style>
</head>
<body>
<div style="text-align:right">
	<a href="javascript:"></a>
</div>
<table style="width:100%">
	<colgroup>
		<col width="10%"/>
		<col />
		<col width="12%"/>
		<col width="3%"/>
		<col width="3%"/>
		<col width="3%"/>
	</colgroup>
	<thead>
		<tr>
			<td>contentId</td>
			<td>contentName</td>
			<td>contentType</td>
			<td>sortSn</td>
			<td>useAt</td>
			<td>show</td>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="r" varStatus="s" items="${list.result}" >
			<tr class="" id="" style="">
				<td style="border:1px solid black">${r.contentId }</td>
				<td style="border:1px solid black">${r.contentName }</td>
				<td style="border:1px solid black">${r.contentType }</td>
				<td style="border:1px solid black">${r.sortSn }</td>
				<td style="border:1px solid black">${r.useAt }</td>
				<td ><a href="javascript:getContentInformation('<c:out value="${r.contentId }"/>')">show</a></td>
			</tr>	
		</c:forEach>
	</tbody>
</table>
<div style="margin:30px;"></div>
<div>
	<div>
		<a href="javascript:setContent(null)">new content</a>
		<a href="javascript:save()">save</a>
	</div>
	<form id='form1' action="/api/ui/content/save" method="POST">
		<div>
			contentId = <input type="text" id="contentId" name="contentId" readonly/>
		</div>
		<div>
			contentName = <input type="text" id="contentName" name="contentName" />
		</div>
		<div>
			contentType = <input type="text" id="contentType" name="contentType" />
		</div>
		<div>
			sortSn = <input type="text" id="sortSn" name="sortSn" />
		</div>
		<div>
			useAt = <input type="text" id="useAt" name="useAt" />
		</div>
	
		<div>
			<a href="javascript:addContentProgram(null)">new content program</a>
		</div>
		<ul id='contentProgramUl'>
		</ul>
	</form>
</div>
</body>
<script>
	function save(){
		$('input').each(function(){
			if ( $(this).val() == '' ) {
		  		$(this).val("null")
			}
		})
		$('#form1').submit()
	}
	function getContentInformation(contentId){
		$.ajax("http://localhost:8080/api/content/listAll")		
		.done(function(data) {
			console.log(data);
			$('#contentProgramUl').html('')
			for ( var i = 0 ; i < data.result.length ; i ++ ) {
				if ( data.result[i].contentId == contentId ){
					setContent(data.result[i])
				}				
			}
		}).fail(function(e) {
			alert("error",e);
		})
	}
	
	function setContent(content){
		if ( content == null ) { 
			content = new Object();
			content.contentId = '';
			content.contentName = '';
			content.contentType = '' ;
			content.sortSn = null;
			content.useAt = 'Y'
			content.list = [] ;
			
			$('#contentProgramUl').html('')
		}
		
		var contentId = content.contentId ; 
		var contentName = content.contentName ; 
		var contentType = content.contentType ; 
		var sortSn = content.sortSn ; 
		var useAt = content.useAt ; 
		var list = content.list ; 
		
		$('#contentId').val(contentId);
		$('#contentName').val(contentName);
		$('#contentType').val(contentType);
		$('#sortSn').val(sortSn);
		$('#useAt').val(useAt);

		
		for ( var i = 0 ; i < list.length ; i ++) {
			var p = list[i];
			addContentProgram(p,contentId);
		}
		
	}
	
	var contentProgramImageCnt = 0 ; 
	function addContentProgram(p){
		if ( p == null ){
			p = new Object();
			p.programId = '';
			p.title = '';
			p.imageMeta = [] ;
			
			var temp = new Object();
			temp.imageId = contentProgramImageCnt ;
			temp.mappingId = '';
			temp.imageType = 'contentBasic';
			p.imageMeta.push(temp)
		}
		var programId = p.programId;
		var title = p.title ; 
		var imageMeta = p.imageMeta ; 	
		
		var str = '<li id="li_'+programId+'">'; 
		str += 
			'<div>' + 
				'programId = <input type="text" value="' + programId + '" name="programId" />' + 
			'</div>' + 
			'<div>' + 
				'title = <input type="text" value="' + title + '" name="title" readonly />' + 
			'</div>' 
		
		var imageId = '' ; 
		var mappingId = '' ;
		var imageType = '' ;
				
		if ( imageMeta != null ){
			for ( var j = 0 ; j < imageMeta.length ; j ++ ) {
				var im = imageMeta[j];
		
				var imageId = im.imageId ; 
				var mappingId = im.mappingId ; 
				var imageType = im.imageType ;
				
				break;
			}
		}
		str+=
			'<div programImageId="' + imageId + '">' + 
			'<div>' + 
				'imageId = <input type="text" value="' + ( imageId == contentProgramImageCnt ? '' : imageId ) + '" name="imageId" />' + 
			'</div>' +
			'<div>' + 
				'imageType = <input type="text" value="' + imageType + '" name="imageType" />' + 
			'</div>' +
			'<div><img width="70px" height="100px" programImageId="' + ( imageId == contentProgramImageCnt ? '' : imageId ) + '" src="http://localhost:8080/api/image/get/' + imageId + '" /></div>' +
			
			'</div>'
			
		str +=
			'<div>'+
				'<a href="javascript:removeProgram(\''+programId+'\')">remove</a>'+
			'</div>' ;
			
		str += '</li>'
			
		$('#contentProgramUl').append(str);
		
		contentProgramImageCnt ++ ;
	}
	
	function removeProgram(programId){
		$('#li_' + programId).remove();
	}

</script>

</html>