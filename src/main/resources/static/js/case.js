/*$(function(){
    	var flagtopic = false;
    	var flagoptionA= false;
    	var flagoptionB = false;
    	var flagoptionC = false;
    	var flagoptionD = false;
    	var flagcorrectAnser = false;
    	var optic=$("#opic").val();
    	var optionA=$("#optionA").val();
    	var optionB=$("#optionB").val();
    	var optionC=$("#optionC").val();
    	var optionD=$("#optionD").val();
    	var correctAnser=$("#correctAnser").val();
    	if((optic!=""&&null!=optic)&&(optionA!=""&&null!=optionA)
    	&&(optionB!=""&&null!=optionB)&&(optionC!=""&&null!=optionC)
    	&&(optionD!=""&&null!=optionD)&&(correctAnser!=""&&null!=correctAnser)){
    	$("#ssss").click(function(){
    	addCase();
    	});
    	}else{
    	$("#msgText").text("以上字段不可以为空！");}


});*/
//添加案例
function addCase(){
	$.post("/addCase",$("#update_customer_form").serialize(),function(data){
        if(data=="ok"){
        alert("添加成功");
            window.location.reload();
        }else{
        alert("添加失败");
            window.location.reload();
        }
	})
}
//删除案例
function deleteCase(id){
if(confirm("确认删除吗？")){
    $.post("/deleteCase",{"id" : id},function(msg){
    if(msg=="ok"){
    alert("删除成功");
    window.location.reload();
    }else{
    alert("删除失败");
    window.location.reload();
    }
    })
    }
}




            //删除教案
    function deletePlan(id){
    if(confirm("确认删除吗？")){
        $.post("/deletePlan",{"id" : id},function(msg){
        if(msg=="ok"){
        alert("删除成功");
        window.location.reload();
        }else{
        alert("删除失败");
        window.location.reload();
        }
        })
        }
    }

    function addPlan(){
    	$.post("/addPlan",$("#update_customer_form").serialize(),function(data){
            if(data=="ok"){
            alert("添加成功");
                window.location.reload();
            }else{
            alert("添加失败");
                window.location.reload();
            }
    	})
    }


function Case(id){
$.post("/findCaseToId",{"id":id},function(msg){
    $("#id1").val(msg.id);
    $("#topic1").val(msg.topic);
    $("#optionA1").val(msg.optionA);
    $("#optionB1").val(msg.optionB);
    $("#optionC1").val(msg.optionC);
    $("#optionD1").val(msg.optionD);
    $("#correctAnser1").val(msg.correctAnser);
})
}
function updateCase(){
    $.post("/updateCase",$("#update").serialize(),function(date){
    if(date=="ok"){
    alert("修改成功");
    window.location.reload();
    }else{
    alert("修改失败");
        window.location.reload();
    }
    });
}

