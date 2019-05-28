function addVid(){
$.post("/addVid",$("#update_customer_form").serialize(),function(msg){
    if (msg == "ok") {
    alert("添加成功");
    window.location.reload();
    }else {
    window.location.reload();
    }});
}

