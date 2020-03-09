function contentPost() {
    var questionId = $("#questionID").val();
    var contentMsg = $("#contentMsg").val();
    $.ajax({
        type: "post",
        url: "/comment",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify({
            "parentId":questionId,
            "content":contentMsg,
            "type": 1
        }),
        success: function (data) {
            if(data.code == 200){
                console.log(data);
                $("#contentTextarea").hide();
            }else{
                if(data.code == 2003){
                    var ischeck = confirm(data.message);
                    if(ischeck){
                        window.open("https://github.com/login/oauth/authorize?client_id=8264734a86a38fa60609&redirect_uri=http://localhost:8887/callback&scope=user&state=123");
                        window.localStorage.setItem("close",true);
                    }
                }else{
                    alert(data.message);
                }
            }

        }
    });
}