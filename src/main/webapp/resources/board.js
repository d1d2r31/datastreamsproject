/**
 * 
 */


  function myTimer() {
	    var d = new Date();
	    document.getElementById("demo").innerHTML ="The time on the server is "+ d.toLocaleTimeString();
	  $.ajax({
		  type:"get",
		  url:"/board/boardNew",
		 
		  success:function(data){
			  $("#new").val(data);
		  }
	  });
}

  //글 리스트
$(document).ready(function(){        
		$("#boardListGo").click(function(){
				$.ajax({
					type:"get",
					url:"/board/boardList",
					/*dataType:"json",*/
				
					success: function(mydata){
						$("#boardList").html(mydata);
						
						/*for(var i=0;i<=mydata.boardList.length;i++) {        //Json 타입 값 뿌려주기
							$("#boardList").append(" 이름 : "+ mydata.boardList[i].name + " 제목 : " + mydata.boardList[i].title +"<br>");
						}*/
					}
		});
	});
});	
//해당 글 번호 눌렀을때
	function name(test){
		var i = test;
		$.ajax({
			type:"post",
			url:"/board/boardDetail",
			data:{
				"test" : i,
				},
				success: function(html){
					$("#boardList").html(html);
					
			}			
	});
}
	/*글작성페이지나오게*/
	$("#boardInsertGo").click(function(){
		$.ajax({
			type:"POST",
			url:"/board/boardInsertPage",
				success: function(html){
					$("#boardList").html(html);
					
			}		
	});
});
	 /*글 작성 완료 눌렀을때*/
	$("#boardInsertOK").click(function(){
		$.ajax({
			type:"post",
			url:"/board/boardInsert",
			data:{
				"name" : $("input[name=name]").val(),
				"title" : $("input[name=title]").val(),
				"content" : $("input[name=content]").val(),
				"insertCheck" :  $("input[name=insertCheck]").val(),
			},
				success: function(html){
					alert("작성완료!")
				$("#boardList").html(html);
					
			}
		});	
	});
	
	
	//글 수정 눌렀을때
	$("#boardUpdate").click(function(){
		$.ajax({
			type:"post",
			url:"/board/boardUpdate",
			data:{
				"updateCheck" :  $("input[name=updateCheck]").val(),
				},
				success: function(html){
					$("#boardList").html(html);
					
			}
		});	
	});
	//글 수정 완료 눌렀을때
	$("#boardUpdateOK").click(function(){
		$.ajax({
			type:"post",
			url:"/board/boardUpdate",
			data:{
				"name" : $("input[name=name]").val(),
				"title" : $("input[name=title]").val(),
				"content" : $("input[name=content]").val(),
				"hit" : $("input[name=hit]").val(),
				"test" : $("input[name=test]").val(),
				"updateCheck" :  $("input[name=updateCheck1]").val(),
			},
				success: function(html){
					alert("수정완료!")
					$("#boardList").html(html);
					
			}
		});	
	});

	//삭제 눌렀을때
	function boardDelete(test){
		var i = test;
		if(confirm(test+"번 글을 삭제하시겠습니까?")==true){
			$.ajax({
				type:"post",
				url:"/board/boardDelete",
				data:{
					"test" : i,
					},
					success: function(html){
						$("#boardList").html(html);
						
				}			
		});
			
		}else{
			return;
		}		
		
/*		//로그아웃됫을때 세션 해제
		
		$("#logout").click(function(){
			$.ajax({
				type:"post",
				url:"/board/logOut",
				data:{
					"name" : $("#nickname").val(),
				},
					success: function(html){
						
						alert("수정완료!")
						location.href="<c:url value='/j_spring_security_logout' />"
						$("#boardList").html(html);
						
				}
			});	
		});*/
}
	