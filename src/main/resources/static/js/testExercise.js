function deleteEx(id){
   if(confirm("确认要删除吗？")){
    $.post("/deleteTest",{"id":id},function(date){
    if(date=="ok"){
    alert("删除成功")
    window.location.reload();
    }else {
     alert("删除失败")
     window.location.reload();
   }
   });
    }
}

function fidEx(id){
    $.post("/findTest",{"id":id},function(msg){
    $("#id1").val(msg.id);
    $("#topic1").val(msg.topic);
    $("#optionA1").val(msg.optionA);
    $("#optionB1").val(msg.optionB);
    $("#optionC1").val(msg.optionC);
    $("#optionC1").val(msg.optionC);
    $("#optionD1").val(msg.optionD);
    $("#result1").val(msg.result);
    });
}

function UpdateEx(){
    $.post("/updataTest",$("#update").serialize(),function(msg){
        if(msg=="ok"){
            alert("修改成功")
            window.location.reload();
            }else {
             alert("修改失败")
             window.location.reload();
           }
    })
}

function addEx(){
$.post("/addTest",$("#update_customer_form").serialize(),function(msg){
    if(msg=="ok"){
                alert("添加成功")
                window.location.reload();
                }else {
                 alert("添加失败")
                 window.location.reload();
               }
})
}