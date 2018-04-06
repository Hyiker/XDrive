$(function () {
    // do register
});

function do_upload() {
    $.ajaxFileUpload({
        type: "POST",
        url: "/file/add",
        fileElementId: "upload-input",
        success: function (data) {
            data = $.parseJSON($(data).find('body').text())
            if (data.success === true) {
                window.location.reload();
            } else {
                $("#modal-text").text(data.message);
                $("#dialog").modal();
            }
        }
    });

}

function do_download() {
    var id_list = [];
    $(".file-selector:checked").each(function () {
        id_list.push(parseInt($(this).attr("data-id")));
    });
    var data = {
        "ids": id_list
    };

    var url = '/file/get';
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);        // 也可以使用POST方式，根据接口
    xhr.responseType = "blob";    // 返回类型blob
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.onload = function () {
        // 请求完成
        if (this.status === 200) {
            var blob = this.response;
            var reader = new FileReader();
            var filename = /(filename=).+/.exec(xhr.getResponseHeader('Content-disposition'))[0].replace("filename=", "");
            reader.readAsDataURL(blob);
            reader.onload = function (e) {
                var a = document.createElement('a');
                a.download = filename;
                a.href = e.target.result;
                $("body").append(a);
                a.click();
                $(a).remove();

            }
        }
    };
    // 发送ajax请求
    xhr.send(JSON.stringify(data))
}