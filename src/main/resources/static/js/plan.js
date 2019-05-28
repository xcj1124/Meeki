function findP(id){
    $.post("/findP",{"id":id},function(msg){
    $("#id1").val(msg.id);
    $("#name1").val(msg.name);
    $("#teaName1").val(msg.teaName);
    $("#msg1").val(msg.msg);
    })
}
function updatePlan(){
    $.post("/updatePlan",$("#update").serialize(),function(date){
    if (date == "ok") {
        alert("修改成功");
        window.location.reload();
        }else {
        alert("修改失败");
        window.location.reload();
        }
        });
}
function addPlan(){
$.post("/addPlan",$("#update_customer_form").serialize(),function(msg){
    if (msg == "ok") {
    alert("添加成功");
    window.location.reload();
    }else {
    window.location.reload();
    }});
}

