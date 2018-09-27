<%@ page language="java" contentType="text/html charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
        <title>ab</title>

        <script type="text/javascript"
        src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js">
        </script>

        <script type="text/javascript">
            $(document).ready(function() {
                var max = 30000;
                for(var i=1;i <= max;i++) {
                    $.ajax({
                        type:"get",
                        url:"./userRedPacket/grapRedPacketForVersion",
                        data:{"redPacketId":3,"userId":i},
                        success:function(result){}
                    });
                }
            });
        </script>
</head>
<body></body>
</html>
