var pageTotal=0;//总页数
var rowTotal=0;//总行数
var currentPage=0;//当前页数
var startRow=0;//页开始行数
var endRow=0;//页结束行数
var pageSize=5;//每页行数

function page(){
    $.ajax({
        url:"../motorSearch/searchMotor",
        type:"POST",
        dataType:"json",
        timeout:1000,
        // error:function(){
        //     alert("ajax error");
        // },
        success:function(data){
            rowTotal=data.length;
            if(rowTotal == 0){
                alertWindow("无电动葫芦记录","error");
            }
            pageTotal=Math.ceil(rowTotal/pageSize);//上取整
            currentPage=1;
 //       <span style="white-space:pre">            </span>//绘制数据table
            if(pageTotal==1){
                $('#电动葫芦记录').html("");
                for(var i = 0;i<rowTotal;i++){
                    var rowData = data[i];
                    //          alert(JSON.stringify(rowData));
                    var newRow = '<tr id="option" '+i+'><td>'+ rowData.id +'</td>'
                        + '<td >' +rowData.manufacturer+ '</td>'
                        + '<td >' +rowData.pattern+ '</td>'
                        + '<td >' +rowData.testNum+ '</td>'
                        + '<td >' +rowData.avgEfficiency+ '</td></tr>'
                    $('#电动葫芦记录').append(newRow);
                }
            }else{
                $('#电动葫芦记录').html("");
                for(var i = 0;i<pageSize;i++){
                    var rowData = data[i];
                    //          alert(JSON.stringify(rowData));
                    var newRow = '<tr id="option" '+i+'><td>'+ rowData.id +'</td>'
                        + '<td >' +rowData.manufacturer+ '</td>'
                        + '<td >' +rowData.pattern+ '</td>'
                        + '<td >' +rowData.testNum+ '</td>'
                        + '<td >' +rowData.avgEfficiency+ '</td></tr>'
                    $('#电动葫芦记录').append(newRow);
                }

                //           <span style="white-space:pre">                </span>//绘制页面ul
                for(var i=1;i<pageTotal+1;i++){
                    $("#page_ul").append(
                        $("<li><a href='#'>"+i+"</a><li>")
                    );
                }
            }
        }
    });
}
//翻页
function gotoPage(pageNum){
    $.ajax({
        url:"../motorSearch/searchMotor",
        type:"POST",
        dataType:"json",
        timeout:1000,
        error:function(){
            alert("ajax error");
        },
        success:function(data){
            currentPage=pageNum;
            startRow=pageSize*(pageNum-1);
            endRow=startRow+pageSize;
            endRow=(rowTotal>endRow)?endRow:rowTotal;
            $('#电动葫芦记录').html("");
            for(var i=startRow;i<endRow;i++){
                var rowData = data[i];
                //          alert(JSON.stringify(rowData));
                var newRow = '<tr id="option" '+i+'><td>'+ rowData.id +'</td>'
                    + '<td >' +rowData.manufacturer+ '</td>'
                    + '<td >' +rowData.pattern+ '</td>'
                    + '<td >' +rowData.testNum+ '</td>'
                    + '<td >' +rowData.avgEfficiency+ '</td></tr>'
                $('#电动葫芦记录').append(newRow);
            }


        }
    });
}


$(function(){
    page();

    $("#page_ul").on("click","li",function(){
        var pageNum=$(this).text();
        gotoPage(pageNum);
    });

    $("#page_prev").on("click","li",function(){
        if(currentPage==1){

        }else{
            gotoPage(--currentPage);
        }
    });

    $("#page_next").on("click","li",function(){
        if(currentPage==pageTotal){

        }else{
            gotoPage(++currentPage);
        }
    })
});


function showMotorData() {
    //   alert("cousuo");
    var motorid = $("#motorid").val();
    $.ajax({
        type: 'post',
        url: '../motorSearch/searchMotorById',
        data:{
            motorId : motorid
        },
        dataType:"json",
        success: function (data) {
            //           alert("开始搜索");
            //          alert(JSON.stringify(data));
            if(data.id == null){
                // $('#t tbody').html("");
                $('#电动葫芦记录').html("");
                alertWindow("无电动葫芦数据记录","error");
            }else {
                $('#电动葫芦记录').html("");
                //          alert(JSON.stringify(data));
                var newRow = '<tr id="option" ><td>'+ data.id +'</td>'
                    + '<td >' +data.manufacturer+ '</td>'
                    + '<td >' +data.pattern+ '</td>'
                    + '<td >' +data.testNum+ '</td>'
                    + '<td >' +data.avgEfficiency+ '</td></tr>'
                $('#电动葫芦记录').append(newRow);
            }
        }

    })

}