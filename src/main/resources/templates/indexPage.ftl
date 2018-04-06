<!DOCTYPE html>
<html lang="en-US">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>XDriver - UNLIMITED CLOUD DRIVER</title>

    <!-- Bootstrap -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <link href="https://yarnpkg.com/en/package/normalize.css">


    <link href="/static/css/common.css">

    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand">XDrive</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">INDEX<span class="sr-only"></span></a></li>
            </ul>
        </div>
    </div>

</nav>
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="collapse navbar-collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#" onclick="do_download()"><span class="glyphicon glyphicon-download-alt"></span></a>
                    </li>
                    <li>
                        <a>
                        <span onclick="document.getElementById('upload-input').click()"
                              class="glyphicon glyphicon-upload"></span>
                        </a>
                        <input style="display: none;" multiple="multiple" onchange="do_upload()" name="file" type="file"
                               id="upload-input">
                    </li>
                    <li>
                        <a><span class="glyphicon glyphicon-trash"></span></a>
                    </li>

            </div>

    </nav>
    <div class="row">
        <div class="col-md-3">
            <ul class="list-group">
                <li class="list-group-item active">ALL</li>
                <li class="list-group-item">PICTURES</li>
                <li class="list-group-item">VIDEOS</li>
                <li class="list-group-item">OTHERS</li>
            </ul>
        </div>
        <div class="col-md-9">
            <table class="table">
                <thead>
                <tr>
                    <td>checker</td>
                    <td>filename</td>
                    <td>format</td>
                    <td>update time</td>
                </tr>
                </thead>
                <tbody>
                <#list files as file>
                <tr>
                    <td class="centered"><label class="check-box"><input class="file-selector" type="checkbox"
                                                                         data-id="${file.id}"/></label>
                    </td>
                    <td>${file.original_name}</td>
                    <td>${file.suffix}</td>
                    <td>${file.update_time?string("yyyy年MM月dd日hh时")}</td>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>

<div class="modal fade" id="dialog" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">提示消息</h4>
            </div>
            <div class="modal-body">
                <p id="modal-text"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.3.0/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/static/js/fileUpload.js"></script>
<script src="/static/js/index.js"></script>
</body>
</html>