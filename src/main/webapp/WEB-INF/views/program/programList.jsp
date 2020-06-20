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
		<col width="3%"/>
	</colgroup>
	<thead>
		<tr>
			<td>programId</td>
			<td>title</td>
			<td>programType</td>
			<td>genreCount</td>
			<td>productCount</td>
			<td>useAt</td>
			<td></td>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="r" varStatus="s" items="${list.result}" >
			<tr class="" id="" style="">
				<td style="border:1px solid black">${r.programId }</td>
				<td style="border:1px solid black">${r.title }</td>
				<td style="border:1px solid black">${r.programType }</td>
				<td style="border:1px solid black"><c:if test="${r.genres != null }">${r.genres.size() }</c:if></td>
				<td style="border:1px solid black"><c:if test="${r.products != null }">${r.products.size() }</c:if></td>
				<td style="border:1px solid black">${r.useAt }</td>
				<td style="border:1px solid black"><a href="javascript:getProgramInformation('<c:out value="${r.programId }"/>')">show</a></td>
			</tr>	
		</c:forEach>
	</tbody>
</table>
<div style="margin:30px;"></div>
<div>
	<div>
		<a href="javascript:newProgram(null)">new program</a>
		<a href="javascript:save()">save</a>
	</div>
	<form id='form1' action="/api/ui/program/save" method="POST">
		<table class="programDetailTable" style="width:100%">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col />
			</colgroup>
			<tbody>
				<tr>
					<td>
						programId
					</td>
					<td>
						<input class='programDetailInput' id="programId" name="programId" type="text" readonly /> 
					</td>
					<td>
						title
					</td>
					<td>
						<input class='programDetailInput' name="title" id="title" type="text"   /> 
					</td>
				</tr>
				
				<tr>
					<td>
						programType
					</td>
					<td>
						<input class='programDetailInput' id="programType" name="programType"  /> 
					</td>
					<td>
						synopsis
					</td>
					<td>
						<textarea class='programDetailInput' name="synopsis" id="synopsis"   ></textarea> 
					</td>
				</tr>
				
				<tr>
					<td>
						genres
					</td>
					<td>
						<input class='programDetailInput' id="genres" name="genres"  /> 
					</td>
					<td>
						imageMeta
						</br>
						<a href="javascript:addProgramImage()">add</a>
					</td>
					<td id='imageMetaTd'>
						
					</td>
				</tr>
				<tr>
					<td>
						useAt
					</td>
					<td>
						<input class='programDetailInput' id="useAt" name="useAt"  /> 
					</td>
				</tr>
			</tbody>
		</table>
		
		<div style="margin-top:10px">
			<a href="javascript:newProgramProductInformation(null)">add program product</a>
		</div>
		<table class="programDetailTable" style="width:100%">
			<colgroup>
				<col width="15%"/>
				<col width="35%"/>
				<col width="15%"/>
				<col />
			</colgroup>
			<tbody id='programProductDetailTable'>
			</tbody>
		</table>
	</form>
</div>
</body>
<script>
	/* var UUID_SPELLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	function getUUID(length) {
		for (var i = 0 ; i < length ; i ++) {
			sb.append(UUID_SPELLS.charAt(random.nextInt(UUID_SPELLS.length())));
		}
		
		return sb.toString();
	} */
	function save(){
		$('input').each(function(){
			if ( $(this).val() == '' ) {
		  		$(this).val("null")
			}
		})
		$('#form1').submit()
	}
	
	function removeProgramInformation(productId){
		$('.tr_'+productId).remove();
	}
	
	var programProductCnt = 0 ; 
	function newProgramProductInformation(p){
		
		if ( p == null ){
			p = new Object();
			p.productId = programProductCnt;
			p.season = ''; 
			p.episode = '';
			p.text = '';
			p.title = '';
			p.imageMeta = [] ; 
			p.useAt = 'Y';
		}
		var productId = p.productId ; 
		var season = p.season ; 
		var episode = p.episode ; 
		var text = p.text ; 
		var title = p.title ; 
		var useAt = p.useAt;
		var imageMeta = p.imageMeta ;
		
		var tr0 = $('<tr></tr>').attr("class","tr_"+productId)
		tr0.append(
			'<td>productId</td><td><input class="programDetailInput" id="productId" name="productId" value="' + ( productId != programProductCnt ? productId : '' ) + '" type="text" readonly /> </td>'  +
			'<td>useAt</td><td><input class="programDetailInput" id="programProductUseAt" name="programProductUseAt" value="' + useAt + '" type="text" /> </td>'
		)
		
		var tr1 = $('<tr></tr>').attr("class","tr_"+productId);
		
		tr1.append(
				'<td>season</td><td><input class="programDetailInput" name="season" type="text" value="'+season+'" /></td>' + 
				'<td>episode</td><td><input class="programDetailInput" name="episode" type="text" value="'+episode+'" /></td>' 
				
				)
		// '<td>text</td><td><textarea class="programDetailInput" type="text" >'+text+'</textarea></td>'
		
		var tr2 = $('<tr></tr>').attr("class","tr_"+productId)
		tr2.append(
				'<td>programProductTitle</td><td><input name="programProductTitle" name="programProductTitle" class="programDetailInput" type="text" value="'+title+'" /></td>' + 
				'<td>programProductText</td><td><textarea name="programProductText" name="programProductText" class="programDetailInput" >' + text + '</textarea></td>' 
				)
		
		var imageAppend =  '' 
		for ( var i = 0 ; i < imageMeta.length ; i ++ ){
			var im = imageMeta[i];
			var imageId = im.imageId;
			var imageType = im.imageType ; 
			
			imageAppend += 
			(
				'<div><input class="programDetailInput" programImageId="' + imageId + '" name="programProductImageProductId" type="text" readonly value="' + productId + '" /></div>' + 
				'<div><input class="programDetailInput" programImageId="' + imageId + '" name="programProductImageId" type="text" readonly value="' + imageId + '" /></div>' + 
				'<div><input class="programDetailInput" programImageId="' + imageId + '" name="programProductImageType" type="text" value="' + imageType + '" /></div>'	 +
				'<div><img width="70px" height="100px" programImageId="' + imageId + '" src="http://localhost:8080/api/image/get/' + imageId + '" /></div>' +
				'<div><a programImageId=\'' + imageId + '\' href="javascript:removeProgramImage(\''+imageId+'\')">remove</a></div>'
			)
		}
		
			
			
				
		var tr3 = $('<tr></tr>').attr("class","tr_"+productId)
		tr3.append(
				'<td>programProductImage</br><a href="javascript:addProgramProductImage(\'' + (productId == programProductCnt ? '' : productId ) + '\')">add</a></td>'+
				'<td id="programProductImageMeta_'+productId+'">'+imageAppend+'</td>' +
				'<td><a href="javascript:removeProgramInformation(\''+productId+'\')">remove</a></td>' 
				)
				
		$('#programProductDetailTable').append(tr0)
		$('#programProductDetailTable').append(tr1)
		$('#programProductDetailTable').append(tr2)
		$('#programProductDetailTable').append(tr3)
		
		
		var temp = $('<tr></tr>').attr("class","tr_"+productId)
		temp.append('<td></td><td></td><td></td><td></td>');
		$('#programProductDetailTable').append(temp).append(temp);
		
		programProductCnt ++ ;
		
		
		
	}
	
	var programProductImageIdCnt = 0 ;
	function addProgramProductImage (productId){
		$('#programProductImageMeta_' + productId)
			.append('<div><input class="programDetailInput" programImageId="' + programProductImageIdCnt + '" name="programProductImageProductId" type="text" readonly value="' + productId + '" /></div>')
		$('#programProductImageMeta_' + productId)
			.append('<div><input class="programDetailInput" programImageId="' + programProductImageIdCnt + '" name="programProductImageId" type="text" readonly value="' + '' + '" /></div>')
		$('#programProductImageMeta_' + productId)
			.append('<div><input class="programDetailInput" programImageId="' + programProductImageIdCnt + '" name="programProductImageType" type="text" value="' + '' + '" /></div>')	
	
		$('#programProductImageMeta_' + productId)
			.append('<div><a programImageId=\'' + programProductImageIdCnt + '\' href="javascript:removeProgramImage(\''+programProductImageIdCnt+'\')">remove</a></div>')
		programProductImageIdCnt ++;
	}
	
	var programImageIdCnt = 0 ; 
	function addProgramImage(){
		$('#imageMetaTd')
			.append('<div><input class="programDetailInput" imageId="' + programImageIdCnt + '" name="imageId" type="text" readonly value="' + '' + '" /></div>')
		$('#imageMetaTd')
			.append('<div><input class="programDetailInput" imageId="' + programImageIdCnt + '" name="imageType" type="text" value="' + '' + '" /></div>')	
		
		$('#imageMetaTd')
			.append('<div><a imageId=\'' + programImageIdCnt + '\' href="javascript:removeImage(\''+programImageIdCnt+'\')">remove</a></div>')
		programImageIdCnt ++;
	}
	function removeImage(imageId){
		$('input[imageId='+imageId+']').remove();
		$('img[imageId='+imageId+']').remove();
		$('a[imageId='+imageId+']').remove();
	}
	
	function removeProgramImage(imageId){
		$('input[programImageId='+imageId+']').remove();
		$('img[programImageId='+imageId+']').remove();
		$('a[programImageId='+imageId+']').remove();
	}
	function newProgram(result){
		if ( result == null ) {
			result = new Object();
			result.programId = '';
			result.synopsis = '';
			result.title = '';
			result.programType = '';
			result.genres = '';
			result.imageMeta = [];
			result.useAt = 'Y';
			$('#programProductDetailTable').html('');
			
		}
		
		var programId = result.programId ;
		var synopsis = result.synopsis ;
		var title = result.title ; 
		var programType = result.programType ;
		
		var genres = result.genres ; 
		var imageMeta = result.imageMeta ;
		var useAt = result.useAt;
		
		var imageMetaTd = "";
		$('#imageMetaTd').html('')
		for( var i = 0 ; i < imageMeta.length ; i ++ ) {
			var im = imageMeta[i];
			var imageId = im.imageId ; 
			var imageType = im.imageType ; 
			var mappingId = im.mappingId ; 
			
			$('#imageMetaTd')
				.append('<div><input class="programDetailInput" imageId="' + imageId + '" name="imageId" type="text" readonly value="' + imageId + '" /></div>')
			$('#imageMetaTd')
				.append('<div><input class="programDetailInput" imageId="' + imageId + '" name="imageType" type="text" value="' + imageType + '" /></div>')	
			$('#imageMetaTd')
				.append('<div><img width="70px" height="100px" imageId="' + imageId + '" src="http://localhost:8080/api/image/get/' + imageId + '" /></div>')
			$('#imageMetaTd')
				.append('<div><a imageId=\'' + imageId + '\' href="javascript:removeImage(\''+imageId+'\')">remove</a></div>')	
		}
		
		$('#programId').val(programId)
		$('#title').val(title)
		$('#programType').val(programType);
		$('#synopsis').val(synopsis)
		$('#genres').val(genres)
		$('#useAt').val(useAt);
	}
	
	function getProgramInformation(programId) {
		console.log(programId)
		$.ajax("http://localhost:8080/api/program/information/" + programId)
				.done(function(data) {
					console.log(data)
					newProgram(data.result)
					var products = data.result.products ; 
					
					$('#programProductDetailTable').html('');
					for (var i = 0 ; i < products.length ; i ++ ) {
						var p = products[i];
						newProgramProductInformation(p)
					}
					

				}).fail(function(e) {
					alert("error",e);
				})
	}
</script>

</html>