<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<title>test</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<head>
    <style type="text/css">
        .upload {
            margin-top: 100px;
            margin-left: 100px;
            text-align: center;
        }

    </style>

</head>
<body>
<h1 style="text-align: center;margin-top: 20px">test</h1>
<div>

    <input id="upfile" type="file" name="upfile" onchange="fileUpload();"/>

    <button class="btn btn-info btn-fill btn-wd" id="btn" name="btn">上传excel</button>
    <button class="btn btn-info btn-fill btn-wd" onclick="downloadTemp();">下载模板</button>
</div>

<script type="text/javascript">
    function downloadTemp(){
        window.location.href="/4sinfo/downloadTmpl.do";
    }

    function fileUpload(){
        var fileName = $("#upfile").val();
        if(fileName == null || fileName==""){
            alert("请选择文件");
        }else{
            var fileType = fileName.substr(fileName.length-4,fileName.length);
            if(fileType == ".xls" || fileType == "xlsx"){
                var formData = new FormData();
                formData.append("file",$("#upfile").prop("files")[0]);
                $.ajax({
                    type:"post",
                    url:"/4sinfo/ajaxUpload.do",
                    data:formData,
                    cache:false,
                    processData:false,
                    contentType:false,
                    dataType:"json",
                    success:function(data){
                        if(null != data){
                            if(data.dataStatus == "1"){
                                if(confirm("上传成功！")){
                                    window.location.reload();
                                }
                            }else{
                                alert("上传失败！");
                            }
                        }
                    },
                    error:function(){
                        alert("上传失败！");
                    }
                });
            }else{
                alert("上传文件类型错误！");
            }
        }
    }

</script>
</body>
</html>